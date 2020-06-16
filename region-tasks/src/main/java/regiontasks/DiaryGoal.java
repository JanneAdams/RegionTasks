package regiontasks;

import com.google.common.collect.ImmutableSet;

import net.runelite.api.Quest;
import net.runelite.api.Skill;

import static regiontasks.ItemSourceSet.*;
import static regiontasks.DiaryGoalID.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class DiaryGoal extends RegionGoal{

    private static RegionTasksPlugin plugin;

    private static final Set<DiaryGoal> DIARY_GOALS = ImmutableSet.of(
            new DiaryGoal(LUMB_EASY_5, "Learn your age from Hans in Lumbridge"),
            new DiaryGoal(LUMB_EASY_6, "Pickpocket a man or woman in Lumbridge"),
            new DiaryGoal(LUMB_EASY_7, "Chop and burn some oak logs in Lumbridge"),
            new DiaryGoal(LUMB_EASY_10, "Bake some Bread on the Lumbridge kitchen range"),
            new DiaryGoal(LUMB_MEDIUM_5, "Cast the teleport to Lumbridge spell"),
            new DiaryGoal(LUMB_MEDIUM_6, "Catch some Salmon in Lumbridge")

    );

    private int id;
    private String text;
    private ArrayList<Quest> questRequirements = new ArrayList<>();
    private ArrayList<Skill> skillRequirements = new ArrayList<>();
    private ArrayList<Integer> itemRequirements = new ArrayList<>();

    private DiaryGoal(int id, String text){
        super(plugin);
        this.id = id;
        this.text = text;
    }

    private DiaryGoal(int id, String text, ArrayList<Quest> questRequirements, ArrayList<Skill> skillRequirements, ArrayList<Integer> itemRequirements){
        super(plugin);
        this.id = id;
        this.text = text;
        if (questRequirements != null) {
            this.questRequirements = questRequirements; }
        if (skillRequirements != null) {
            this.skillRequirements = skillRequirements; }
        if (itemRequirements != null) {
            this.itemRequirements = itemRequirements; }
    }

    public static void setPlugin(RegionTasksPlugin plugin) {
        DiaryGoal.plugin = plugin;
    }

    public String getText() {
        return text;
    }

    public ArrayList<Quest> getQuestRequirements() {
        return questRequirements;
    }

    public ArrayList<Skill> getSkillRequirements() {
        return skillRequirements;
    }

    public ArrayList<Integer> getItemRequirements() {
        return itemRequirements;
    }

    public static DiaryGoal task(int id){
        for (DiaryGoal task : DIARY_GOALS){
            if (id == task.id){
                return task;
            }
        }
        return null;
    }

}
