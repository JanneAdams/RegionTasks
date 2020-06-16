package regiontasks;

import com.google.common.collect.ImmutableSet;
import lombok.Getter;
import net.runelite.api.Quest;
import net.runelite.api.Skill;
import net.runelite.client.plugins.Plugin;

import java.util.*;

import static regiontasks.SkillingGoalID.*;
import static regiontasks.QuestGoalID.*;
import static regiontasks.DiaryGoalID.*;

@Getter
public class MapSquare {

    private static final Set<MapSquare> MAP_SQUARE_SET = ImmutableSet.of(
            new MapSquare(4663, "Quidamortem Cave"),
            new MapSquare(4664, "Ket'sal K'uk"),
            new MapSquare(4665, "Kebos Mine"),
            new MapSquare(4666, "Kebos West Shore"),
            new MapSquare(4918, "Quidamortem Path"),
            new MapSquare(4919, "Mount Quidamortem"),
            new MapSquare(4920, "Kebos Swamp"),
            new MapSquare(4921, "River Molch"),
            new MapSquare(4922, "Farming Guild"),
            new MapSquare(4923, "West Mount Karuulm"),
            new MapSquare(5174, "Settlement Path"),
            new MapSquare(5175, "Lizardman Settlement"),
            new MapSquare(5176, "Xeric's Shrine"),
            new MapSquare(5177, "Molch"),
            new MapSquare(5178, "Keith's House"),
            new MapSquare(5179, "Mount Karuulm"),
            new MapSquare(5430, "Lacerta Falls"),
            new MapSquare(5431, "Shayziens' Wall"),
            new MapSquare(5432, "Molch Island"),
            new MapSquare(5433, "Battlefront Dock"),
            new MapSquare(5434, "Battlefront"),
            new MapSquare(5435, "The Forsaken Tower"),
            new MapSquare(5686, "South Shayzien Shore"),
            new MapSquare(5687, "Shayziens' Gate"),
            new MapSquare(5688, "Shayzien Dock"),
            new MapSquare(5689, "Chasm of Fire"),
            new MapSquare(5690, "West Lovakengj"),
            new MapSquare(5691, "Lovakite Mine"),
            new MapSquare(5692, "Sulphur Mine"),
            new MapSquare(5941, "Land's End"),
            new MapSquare(5942, "West Kourend Woodland"),
            new MapSquare(5943, "Graveyard of Heroes"),
            new MapSquare(5944, "Shayzien House"),
            new MapSquare(5945, "West Lizardman Canyon"),
            new MapSquare(5946, "Lovakengj Assembly"),
            new MapSquare(5947, "Lovakite Furnace"),
            new MapSquare(5948, "Blast Mine"),
            new MapSquare(6197, "South Kourend Woodland"),
            new MapSquare(6198, "West Woodcutting Guild"),
            new MapSquare(6199, "War Tent"),
            new MapSquare(6200, "Combat Ring"),
            new MapSquare(6201, "East Lizardman Canyon"),
            new MapSquare(6202, "The Deeper Lode"),
            new MapSquare(6203, "Tower of Magic"),
            new MapSquare(6204, "Settlement Ruins"),
            new MapSquare(6205, "Unmarked Grave"),
            new MapSquare(6453, "Crabclaw Caves"),
            new MapSquare(6454, "East Woodcutting Guild"),
            new MapSquare(6455, "Watson's House"),
            new MapSquare(6456, "Mess"),
            new MapSquare(6457, "Kourend Castle"),
            new MapSquare(6458, "West Arceuus"),
            new MapSquare(6459, "Arceuus Library"),
            new MapSquare(6460, "North Arceuus Path"),
            new MapSquare(6461, "Wintertodt Camp"),
            new MapSquare(6462, "Wintertodt"),
            new MapSquare(6710, "Charcoal Burners"),
            new MapSquare(6711, "Forthos Ruin"),
            new MapSquare(6712, "Hosidius Kitchen"),
            new MapSquare(6713, "Kingstown"),
            new MapSquare(6714, "East Arceuus"),
            new MapSquare(6715, "Blood Altar"),
            new MapSquare(6716, "Dark Altar"),
            new MapSquare(6717, "Fishing Hamlet"),
            new MapSquare(6965, "Crabclaw Isle"),
            new MapSquare(6966, "Monk Camping Site"),
            new MapSquare(6967, "Ploughing Fields"),
            new MapSquare(6968, "Hosidius Square"),
            new MapSquare(6969, "Piscarilius Station"),
            new MapSquare(6970, "West Piscarilius"),
            new MapSquare(6971, "Blood River"),
            new MapSquare(6972, "Arceuus Essence Mine"),
            new MapSquare(7221, "South Sand Crabs"),
            new MapSquare(7222, "Tithe Farm"),
            new MapSquare(7223, "Vinery"),
            new MapSquare(7224, "Hosidius Peninsula"),
            new MapSquare(7225, "Port Piscarilius"),
            new MapSquare(7226, "The Warrens"),
            new MapSquare(7227, "Piscarilius Bank"),
            new MapSquare(7228, "Soul Altar"),
            new MapSquare(7478, "East Hosidius Shore"),
            new MapSquare(7479, "East Sand Crabs"),
            new MapSquare(8252, "South Moonclan"),
            new MapSquare(8253, "North Moonclan"),
            new MapSquare(8495, "Zul-Andra Entrance"),
            new MapSquare(8496, "Port Tyras"),
            new MapSquare(8499, "Prifddinas Shore"),
            new MapSquare(8500, "Prifddinas Harbour"),
            new MapSquare(8501, "Mynydd"),
            new MapSquare(8508, "Astral Altar"),
            new MapSquare(8509, "Lunar Isle Mine"),
            new MapSquare(8751, "Zul-Andra"),
            new MapSquare(8752, "West Poison Waste"),
            new MapSquare(8753, "Tyras Camp"),
            new MapSquare(8754, "Iorwerth Camp"),
            new MapSquare(8755, "Ithell & Iorwerth"),
            new MapSquare(8756, "Amlodd & Hefin"),
            new MapSquare(8757, "Gwenith"),
            new MapSquare(8763, "Pirates' Cove"),
            new MapSquare(9007, "Zulrah's Shrine"),
            new MapSquare(9008, "East Poison Waste"),
            new MapSquare(9009, "South Isafdar"),
            new MapSquare(9010, "North Isafdar"),
            new MapSquare(9011, "Cadarn & Trahaearn"),
            new MapSquare(9012, "Crwys & Meilyr"),
            new MapSquare(9013, "Gorlah"),
            new MapSquare(9015, "East Piscatoris"),
            new MapSquare(9016, "Kraken Cove"),
            new MapSquare(9023, "Ungael"),
            new MapSquare(9263, "Dougne Delta"),
            new MapSquare(9265, "Lletya"),
            new MapSquare(9266, "South Arandar"),
            new MapSquare(9267, "Arandar"),
            new MapSquare(9270, "Eagles' Peak"),
            new MapSquare(9271, "Piscatoris Woodland"),
            new MapSquare(9272, "Piscatoris Mine"),
            new MapSquare(9273, "Fishing Colony"),
            new MapSquare(9275, "Neitiznot"),
            new MapSquare(9276, "West Ice Trolls"),
            new MapSquare(9519, "Smoke Devil Dungeon"),
            new MapSquare(9520, "Castle Wars"),
            new MapSquare(9523, "Arandar Mountain"),
            new MapSquare(9524, "Arandar Gate"),
            new MapSquare(9525, "Brimstail's Cave"),
            new MapSquare(9526, "Gnome Ball Field"),
            new MapSquare(9527, "River Delta"),
            new MapSquare(9528, "Falconry Area"),
            new MapSquare(9531, "Jatizso"),
            new MapSquare(9532, "East Ice Trolls"),
            new MapSquare(9772, "Myths' Guild"),
            new MapSquare(9773, "Corsair Resource Area"),
            new MapSquare(9774, "West Feldip Coast"),
            new MapSquare(9775, "Jiggig"),
            new MapSquare(9776, "Castle Wars Lobby"),
            new MapSquare(9777, "Observatory"),
            new MapSquare(9778, "Ouriana Altar"),
            new MapSquare(9779, "Underground Pass"),
            new MapSquare(9780, "Jorral's Outpost"),
            new MapSquare(9781, "Tree Gnome Stronghold"),
            new MapSquare(9782, "Grand Tree"),
            new MapSquare(9783, "Crash Site Cavern"),
            new MapSquare(9790, "Island of Stone"),
            new MapSquare(10028, "Corsair South Shore"),
            new MapSquare(10029, "Feldip Hunter Area"),
            new MapSquare(10030, "West Feldip Hills"),
            new MapSquare(10031, "Gu'Tanoth"),
            new MapSquare(10032, "West Yanille"),
            new MapSquare(10033, "Tree Gnome Village"),
            new MapSquare(10034, "Khazard Battlefield"),
            new MapSquare(10035, "West Ardougne"),
            new MapSquare(10036, "Combat Training Camp"),
            new MapSquare(10037, "Glarial's Tomb"),
            new MapSquare(10038, "Baxtorian Falls"),
            new MapSquare(10039, "Barbarian Outpost"),
            new MapSquare(10040, "Lighthouse"),
            new MapSquare(10042, "Waterbirth Island"),
            new MapSquare(10044, "Miscellania"),
            new MapSquare(10284, "Corsair Cove"),
            new MapSquare(10285, "East Feldip Shore"),
            new MapSquare(10286, "East Feldip Hills"),
            new MapSquare(10287, "Gu'Tanoth Island"),
            new MapSquare(10288, "East Yanille"),
            new MapSquare(10289, "Fight Arena"),
            new MapSquare(10290, "Ardougne Monastery"),
            new MapSquare(10291, "Ardougne Castle"),
            new MapSquare(10292, "Chaos Druid Tower"),
            new MapSquare(10293, "Fishing Guild"),
            new MapSquare(10294, "Coal Truck Mine"),
            new MapSquare(10296, "Lighthouse Bridge"),
            new MapSquare(10297, "West Rellekka"),
            new MapSquare(10300, "Etceteria"),
            new MapSquare(10536, "Pest Control"),
            new MapSquare(10537, "Void Knights' Outpost"),
            new MapSquare(10542, "Rantz' Cave"),
            new MapSquare(10544, "Hazelmere's Island"),
            new MapSquare(10545, "Port Khazard"),
            new MapSquare(10546, "Tower of Life"),
            new MapSquare(10547, "Ardougne Market"),
            new MapSquare(10548, "Ardougne Farm"),
            new MapSquare(10549, "Hemenster"),
            new MapSquare(10550, "McGrubor's Wood"),
            new MapSquare(10551, "Fremennik Road"),
            new MapSquare(10552, "Fremennik Province"),
            new MapSquare(10553, "Rellekka"),
            new MapSquare(10554, "Rellekka Rocks"),
            new MapSquare(10558, "South Iceberg"),
            new MapSquare(10559, "North Iceberg"),
            new MapSquare(10794, "West Ape Atoll"),
            new MapSquare(10795, "Marim Entrance"),
            new MapSquare(10801, "Brimhaven Dungeon"),
            new MapSquare(10802, "Horseshoe Mine"),
            new MapSquare(10803, "Witchaven"),
            new MapSquare(10804, "Legends' Guild"),
            new MapSquare(10805, "Sorcerer's Tower"),
            new MapSquare(10806, "Seers' Village"),
            new MapSquare(10807, "Sinclair Mansion"),
            new MapSquare(10808, "Fremennik Forest"),
            new MapSquare(10809, "Fremennik Mine"),
            new MapSquare(10810, "Rellekka Peninsula"),
            new MapSquare(10811, "Rellekka Hunter Area"),
            new MapSquare(11050, "East Ape Atoll"),
            new MapSquare(11051, "Marim"),
            new MapSquare(11053, "West Khazari Jungle"),
            new MapSquare(11054, "Cairn Isle"),
            new MapSquare(11055, "South Tai Bwo Wannai"),
            new MapSquare(11056, "North Tai Bwo Wannai"),
            new MapSquare(11057, "Brimhaven"),
            new MapSquare(11058, "North Brimhaven"),
            new MapSquare(11059, "Fishing Platform"),
            new MapSquare(11060, "West Entrana"),
            new MapSquare(11061, "West Catherby"),
            new MapSquare(11062, "Camelot"),
            new MapSquare(11063, "Sinclair Lake"),
            new MapSquare(11064, "Golden Apple Tree"),
            new MapSquare(11065, "Mountain Camp"),
            new MapSquare(11066, "Mountain Slope South"),
            new MapSquare(11067, "Mountain Slope North"),
            new MapSquare(11068, "Trollweiss Mountain"),
            new MapSquare(11309, "Mid Khazari Jungle"),
            new MapSquare(11310, "Shilo Village"),
            new MapSquare(11311, "Karamja Jungle Mine"),
            new MapSquare(11312, "Jogre Dungeon"),
            new MapSquare(11313, "Karamja Volcano"),
            new MapSquare(11314, "South Crandor"),
            new MapSquare(11315, "North Crandor"),
            new MapSquare(11316, "Entrana"),
            new MapSquare(11317, "East Catherby"),
            new MapSquare(11318, "White Wolf Mountain"),
            new MapSquare(11319, "Warriors' Guild"),
            new MapSquare(11320, "Death Plateau"),
            new MapSquare(11321, "Troll Stronghold"),
            new MapSquare(11322, "Ice Gate"),
            new MapSquare(11323, "Ice Path"),
            new MapSquare(11325, "Weiss"),
            new MapSquare(11562, "Crash Island"),
            new MapSquare(11565, "East Khazari Jungle"),
            new MapSquare(11566, "Ah Za Rhoon"),
            new MapSquare(11567, "Karamja River"),
            new MapSquare(11568, "Karambwan Shore"),
            new MapSquare(11569, "Musa Point"),
            new MapSquare(11570, "Melzar's Maze"),
            new MapSquare(11571, "Crafting Guild"),
            new MapSquare(11572, "Falador West Wall"),
            new MapSquare(11573, "South Taverley"),
            new MapSquare(11574, "North Taverley"),
            new MapSquare(11575, "Burthorpe"),
            new MapSquare(11576, "Troll Arena"),
            new MapSquare(11577, "Trollheim"),
            new MapSquare(11578, "God Wars Dungeon"),
            new MapSquare(11581, "Ghorrock Fortress"),
            new MapSquare(11821, "Khazari East Coast"),
            new MapSquare(11822, "Gandius' Glider"),
            new MapSquare(11823, "Ship Yard"),
            new MapSquare(11824, "Mudskipper Point"),
            new MapSquare(11825, "Sarim Church"),
            new MapSquare(11826, "Rimmington"),
            new MapSquare(11827, "Falador South Wall"),
            new MapSquare(11828, "West Falador"),
            new MapSquare(11829, "Falador North Gate"),
            new MapSquare(11830, "Goblin Village"),
            new MapSquare(11831, "West Wildy Ditch"),
            new MapSquare(11832, "West Green Dragons"),
            new MapSquare(11833, "Dareeyak Ruins"),
            new MapSquare(11834, "Forgotten Cemetery"),
            new MapSquare(11835, "Chaos Altar"),
            new MapSquare(11836, "Western Obelisk"),
            new MapSquare(11837, "Frozen Waste Plateau"),
            new MapSquare(12079, "Tutorial Island"),
            new MapSquare(12080, "Tutorial Island"),
            new MapSquare(12081, "Asgarnia Ice Cave"),
            new MapSquare(12082, "Port Sarim"),
            new MapSquare(12083, "Falador Farm"),
            new MapSquare(12084, "East Falador"),
            new MapSquare(12085, "Asgarnian Road"),
            new MapSquare(12086, "Edgeville Monastery"),
            new MapSquare(12087, "Monastery Ditch"),
            new MapSquare(12088, "Dark Warriors' Fort"),
            new MapSquare(12089, "Wildy Bandit Camp"),
            new MapSquare(12090, "Wilderness God Wars"),
            new MapSquare(12091, "Lava Maze Entrance"),
            new MapSquare(12092, "West Lava Maze"),
            new MapSquare(12093, "Pirates' Hideout"),
            new MapSquare(12335, "Tutorial Island"),
            new MapSquare(12336, "Tutorial Island"),
            new MapSquare(12337, "Wizards' Tower"),
            new MapSquare(12338, "South Draynor"),
            new MapSquare(12339, "North Draynor"),
            new MapSquare(12340, "Draynor Manor"),
            new MapSquare(12341, "Barbarian Village"),
            new MapSquare(12342, "Edgeville"),
            new MapSquare(12343, "Edgeville Ditch"),
            new MapSquare(12344, "Center Wilderness"),
            new MapSquare(12345, "South Revenant Caves"),
            new MapSquare(12346, "Center Wildy Mine"),
            new MapSquare(12347, "North Revenant Caves"),
            new MapSquare(12348, "East Lava Maze"),
            new MapSquare(12349, "Mage Arena"),
            new MapSquare(12589, "Desert Quarry"),
            new MapSquare(12590, "Desert Bandit Camp"),
            new MapSquare(12591, "Bedabin Camp"),
            new MapSquare(12592, "Tutorial Island"),
            new MapSquare(12593, "West Lumbridge Swamp"),
            new MapSquare(12594, "H.A.M. Hideout"),
            new MapSquare(12595, "Mill Lane Mill"),
            new MapSquare(12596, "Champions' Guild"),
            new MapSquare(12597, "West Varrock"),
            new MapSquare(12598, "Grand Exchange"),
            new MapSquare(12599, "Center Wildy Ditch"),
            new MapSquare(12600, "Mammoth Obelisk"),
            new MapSquare(12601, "Graveyard of Shadows"),
            new MapSquare(12602, "Eastern Ruins"),
            new MapSquare(12603, "Wilderness Pond"),
            new MapSquare(12604, "Center North Wildy"),
            new MapSquare(12605, "Deserted Keep"),
            new MapSquare(12843, "Menaphos"),
            new MapSquare(12844, "Menaphos Desert"),
            new MapSquare(12845, "Jaldraocht Pyramid"),
            new MapSquare(12846, "Desert Wall"),
            new MapSquare(12847, "Rocky Desert"),
            new MapSquare(12848, "Kalphite Lair"),
            new MapSquare(12849, "East Lumbridge Swamp"),

            new MapSquare(12850, "Lumbridge Castle",
                    new ArrayList<>(Arrays.asList(ATTA_MITHRIL_BATTLEAXE, COOK_FRIED_ONIONS, FIRE_YEW_LOGS, FISH_SALMON, FLET_YEW_LOGS, WOOD_YEW_LOGS)),
                    new ArrayList<>(),
                    new ArrayList<>(Arrays.asList(COOKS_ASSISTANT_START, COOKS_ASSISTANT_MILK, COOKS_ASSISTANT_EGG, COOKS_ASSISTANT_FLOUR, THE_LOST_TRIBE_START, THE_RESTLESS_GHOST_START, RUNE_MYSTERIES_START, X_MARKS_THE_SPOT_START)),
                    new ArrayList<>(Arrays.asList(LUMB_EASY_5, LUMB_EASY_6, LUMB_EASY_7, LUMB_EASY_10, LUMB_MEDIUM_5, LUMB_MEDIUM_6))
            ),

            new MapSquare(12851, "Groats' Farm"),
            new MapSquare(12852, "Varrock South Gate"),
            new MapSquare(12853, "Varrock Center"),
            new MapSquare(12854, "Varrock Palace"),
            new MapSquare(12855, "Varrock Ditch"),
            new MapSquare(12856, "Chaos Temple"),
            new MapSquare(12857, "Corporeal Beast Cave"),
            new MapSquare(12858, "Bone Yard"),
            new MapSquare(12859, "Vet'ion"),
            new MapSquare(12860, "Lava Dragon Isle"),
            new MapSquare(12861, "Scorpion Pit"),
            new MapSquare(13099, "Sophanem"),
            new MapSquare(13100, "Desert Wanderer"),
            new MapSquare(13101, "Elid South Bridge"),
            new MapSquare(13102, "Smoke Dungeon"),
            new MapSquare(13103, "Desert Mining Camp"),
            new MapSquare(13104, "Shantay Pass"),
            new MapSquare(13105, "Al Kharid Palace"),
            new MapSquare(13106, "North Al Kharid"),
            new MapSquare(13107, "Al Kharid Mine"),
            new MapSquare(13108, "East Varrock Mine"),
            new MapSquare(13109, "East Varrock Gate"),
            new MapSquare(13110, "Lumber Yard"),
            new MapSquare(13111, "Lumber Yard Ditch"),
            new MapSquare(13112, "Ent Forest"),
            new MapSquare(13113, "Boneyard Hunter Area"),
            new MapSquare(13114, "Venenatis"),
            new MapSquare(13115, "Callisto"),
            new MapSquare(13116, "Demonic Ruins"),
            new MapSquare(13117, "Rogues' Castle"),
            new MapSquare(13356, "Agility Pyramid"),
            new MapSquare(13357, "Deserted Cave"),
            new MapSquare(13358, "Pollnivneach"),
            new MapSquare(13359, "River Elid"),
            new MapSquare(13360, "Elid North Bridge"),
            new MapSquare(13361, "Clan Wars"),
            new MapSquare(13362, "Duel Arena"),
            new MapSquare(13363, "Mage Training Arena"),
            new MapSquare(13364, "Exam Centre"),
            new MapSquare(13365, "Digsite"),
            new MapSquare(13366, "Silvarea"),
            new MapSquare(13367, "South East Wildy"),
            new MapSquare(13368, "Ent Forest Shore"),
            new MapSquare(13369, "East Green Dragons"),
            new MapSquare(13370, "East Wildy Shore"),
            new MapSquare(13371, "Wilderness Crabs"),
            new MapSquare(13372, "Fountain of Rune"),
            new MapSquare(13373, "Wilderness Volcano"),
            new MapSquare(13613, "Nardah"),
            new MapSquare(13614, "Nardah Desert"),
            new MapSquare(13615, "Desert Lizards"),
            new MapSquare(13616, "Desert Hunter Area"),
            new MapSquare(13617, "Last Man Standing"),
            new MapSquare(13618, "Abandoned Mine"),
            new MapSquare(13619, "Path to Mort'ton"),
            new MapSquare(13620, "Nature Grotto"),
            new MapSquare(13621, "Mort Myre Swamp"),
            new MapSquare(13622, "Paterdomus"),
            new MapSquare(13623, "Slayer Tower"),
            new MapSquare(13872, "Uzer"),
            new MapSquare(13873, "South Burgh de Rott"),
            new MapSquare(13874, "Burgh de Rott"),
            new MapSquare(13875, "Mort'ton"),
            new MapSquare(13876, "Swamp Rowboat"),
            new MapSquare(13877, "Myreque Hideout"),
            new MapSquare(13878, "Canifis"),
            new MapSquare(13879, "Mausoleum"),
            new MapSquare(14129, "Burgh de Rott Pier"),
            new MapSquare(14130, "East Burgh de Rott"),
            new MapSquare(14131, "Barrows"),
            new MapSquare(14132, "Castle Drakan"),
            new MapSquare(14133, "Morytania Graveyard"),
            new MapSquare(14134, "West Haunted Woods"),
            new MapSquare(14135, "Fenkenstrain's Castle"),
            new MapSquare(14142, "Lithkren"),
            new MapSquare(14385, "Meiyerditch Wall"),
            new MapSquare(14386, "South Meiyerditch"),
            new MapSquare(14387, "North Meiyerditch"),
            new MapSquare(14388, "Darkmeyer"),
            new MapSquare(14389, "Haunted Woods Bridge"),
            new MapSquare(14390, "East Haunted Woods"),
            new MapSquare(14391, "Alice's Farm"),
            new MapSquare(14398, "East Lithkren"),
            new MapSquare(14638, "Pirate Pier"),
            new MapSquare(14638, "Pirate Base"),
            new MapSquare(14639, "West Mos Le'Harmless"),
            new MapSquare(14641, "Icyene Graveyard"),
            new MapSquare(14642, "Ver Sinhaza"),
            new MapSquare(14643, "Slepe Entrance"),
            new MapSquare(14644, "East Darkmeyer"),
            new MapSquare(14645, "Morytania Delta"),
            new MapSquare(14646, "Port Phasmatys"),
            new MapSquare(14647, "Ectofuntus"),
            new MapSquare(14650, "Tar Swamp"),
            new MapSquare(14651, "Swamp Border"),
            new MapSquare(14652, "Mushroom Forest"),
            new MapSquare(14894, "Mos Le'Harmless Cave"),
            new MapSquare(14895, "Mid Mos Le'Harmless"),
            new MapSquare(14899, "Slepe"),
            new MapSquare(14900, "Crombwick Manor"),
            new MapSquare(14906, "Verdant Valley"),
            new MapSquare(14907, "Museum Camp"),
            new MapSquare(14908, "House on the Hill"),
            new MapSquare(15148, "Harmony Island"),
            new MapSquare(15150, "Trouble Brewing"),
            new MapSquare(15151, "Trouble Brewing Lobby"),
            new MapSquare(15159, "Dragontooth Island"),
            new MapSquare(15162, "South Volcano"),
            new MapSquare(15163, "Fossil Island Volcano"),
            new MapSquare(15164, "Strange Stone")
    );

    private final int id;
    private final String locationName;
    private static Plugin plugin;

    private ArrayList<Integer> skillingGoals = new ArrayList<>();
    private ArrayList<Integer> itemGoals = new ArrayList<>();
    private ArrayList<Integer> questGoals = new ArrayList<>();
    private ArrayList<Integer> diaryGoals = new ArrayList<>();

    private MapSquare(int id, String locationName, ArrayList<Integer> skillingGoals, ArrayList<Integer> itemGoals, ArrayList<Integer> questGoals, ArrayList<Integer> diaryGoals) {
        this.id = id;
        this.locationName = locationName;
        this.skillingGoals = skillingGoals;
        this.itemGoals = itemGoals;
        this.questGoals = questGoals;
        this.diaryGoals = diaryGoals;
    }

    private MapSquare(int id, String locationName){
        this.id = id;
        this.locationName = locationName;
    }

    public static Set<MapSquare> getMapSquareSet() {
        return MAP_SQUARE_SET;
    }

    public static void setPlugin(RegionTasksPlugin plugin) {
        MapSquare.plugin = plugin;
    }

    public static MapSquare forId(int id){
        for (MapSquare mapSquare : MAP_SQUARE_SET){
            if (id == mapSquare.id){
                return mapSquare;
            }
        }
        return null;
    }

    public ArrayList<Integer> getEligibleSkillingGoals() {
        ArrayList<Integer> eligibleSkillingGoals = new ArrayList<>();
        for (Integer skillingGoalId : skillingGoals) {
            SkillingGoal skillingGoal = SkillingGoal.task(skillingGoalId);
            if (questRequirementsCheck(skillingGoal.getQuestRequirements()) && skillRequirementsCheck(skillingGoal.getSkillRequirements()) && itemRequirementsCheck(skillingGoal.getItemRequirements()))
                eligibleSkillingGoals.add(skillingGoalId);
        }
        return eligibleSkillingGoals;
    }

    public ArrayList<Integer> getEligibleQuestGoals() {
        ArrayList<Integer> eligibleQuestGoals = new ArrayList<>();
        for (Integer questGoalId : questGoals) {
            QuestGoal questGoal = QuestGoal.task(questGoalId);
            if (questRequirementsCheck(questGoal.getQuestRequirements()) && skillRequirementsCheck(questGoal.getSkillRequirements()) && itemRequirementsCheck(questGoal.getItemRequirements()))
                eligibleQuestGoals.add(questGoalId);
        }
        return eligibleQuestGoals;
    }

    public ArrayList<Integer> getEligibleDiaryGoals() {
        ArrayList<Integer> eligibleDiaryGoals = new ArrayList<>();
        for (Integer diaryGoalId : diaryGoals) {
            DiaryGoal diaryGoal = DiaryGoal.task(diaryGoalId);
            if (questRequirementsCheck(diaryGoal.getQuestRequirements()) && skillRequirementsCheck(diaryGoal.getSkillRequirements()) && itemRequirementsCheck(diaryGoal.getItemRequirements()))
                eligibleDiaryGoals.add(diaryGoalId);
        }
        return eligibleDiaryGoals;
    }

    private boolean questRequirementsCheck(ArrayList<Quest> questRequirements) {
        ArrayList<Quest> completedQuests = RegionTasksPlugin.getCompletedQuests();
        if (questRequirements.isEmpty())
            return true;
        else if (!Collections.disjoint(completedQuests, questRequirements)) {
            for (Quest quest : questRequirements) {
                if (!completedQuests.contains(quest)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static boolean skillRequirementsCheck(ArrayList<Skill> skillRequirements) {
        ArrayList<Skill> unlockedSkills = RegionTasksPlugin.getUnlockedSkills();
        if (skillRequirements.isEmpty())
            return true;
        else if (!Collections.disjoint(unlockedSkills, skillRequirements)) {
            for (Skill skill : skillRequirements) {
                if (!unlockedSkills.contains(skill)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private boolean itemRequirementsCheck(ArrayList<Integer> itemRequirements) {
        return requirementChecker.checkIfRequiredItemsAreAvailable(itemRequirements);
    }
}
