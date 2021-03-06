/*
 * Copyright (c) 2019, Slay to Stay, <https://github.com/slaytostay>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package goaltracker2.ui;

import com.google.inject.Inject;
import goaltracker2.Goal;
import goaltracker2.GoalTrackerPlugin;
import lombok.Getter;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GoalTrackerPanel extends PluginPanel
{

	private static final Color DEFAULT_BORDER_COLOR = Color.GREEN;
	private static final Color DEFAULT_FILL_COLOR = new Color(0, 255, 0, 0);

	private static final int DEFAULT_BORDER_THICKNESS = 3;

	private final JLabel title = new JLabel();

	private final JPanel goalView = new JPanel(new GridBagLayout());

	@Inject
	private GoalTrackerPlugin plugin;

	@Getter
	private Color selectedColor = DEFAULT_BORDER_COLOR;

	@Getter
	private Color selectedFillColor = DEFAULT_FILL_COLOR;

	@Getter
	private int selectedBorderThickness = DEFAULT_BORDER_THICKNESS;

	public void init()
	{
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(10, 10, 10, 10));

		JPanel northPanel = new JPanel(new BorderLayout(0, 5));
		northPanel.setBorder(new EmptyBorder(1, 0, 10, 0));

		JPanel actionWrapper = new JPanel(new BorderLayout(8, 0));

		title.setText("Goal Tracker 2");
		title.setForeground(Color.WHITE);

		northPanel.add(title, BorderLayout.WEST);
		northPanel.add(actionWrapper, BorderLayout.EAST);

		JPanel centerPanel = new JPanel(new BorderLayout());
		centerPanel.setBackground(ColorScheme.DARK_GRAY_COLOR);

		goalView.setBackground(ColorScheme.DARK_GRAY_COLOR);

		updateGoals();

		centerPanel.add(goalView, BorderLayout.CENTER);

		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
	}

	public void rebuild()
	{
		removeAll();
		repaint();
		revalidate();
		init();
	}

	public void updateGoals()
	{
		updateGoals("");
	}

	public void updateGoals(String text)
	{
		goalView.removeAll();

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 1;
		constraints.gridx = 0;
		constraints.gridy = 0;

		for (final Goal goal : plugin.getGoals())
		{
			if (goal != null && (text.isEmpty() || matchesSearchTerms(goal, text.toLowerCase())))
			{
				goalView.add(new RegionPanel(plugin, goal), constraints);
				constraints.gridy++;

				goalView.add(Box.createRigidArea(new Dimension(0, 10)), constraints);
				constraints.gridy++;
			}
		}

		repaint();
		revalidate();
	}

	public boolean matchesSearchTerms(Goal goal, String text)
	{
		Pattern p = Pattern.compile("((?:\\\")([^\\\"]*)(?:\\\")|\\w+)");
		Matcher m = p.matcher(text);

		while (m.find())
		{
			String term = m.group();
			term = term.replaceAll("^\"|\"$", "");
			final String t = term;
			if (t.isEmpty()) continue;
			if (t.equals(Integer.toString(goal.getChunk())))
			{
				return true;
			}
			else if (goal.getName().toLowerCase().contains(t))
			{
				return true;
			}
			else if (goal.getRequirements().stream().anyMatch(str -> str.getName().toLowerCase().contains(t)))
			{
				return true;
			}
		}
		return false;
	}
}
