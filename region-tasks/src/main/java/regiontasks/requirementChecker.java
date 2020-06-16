package regiontasks;

import net.runelite.api.Skill;
import regionlocker.RegionLocker;

import java.util.List;

import static regiontasks.ItemSourceSet.*;

public class requirementChecker {

    public static boolean checkIfRequiredItemsAreAvailable(List<Integer> itemCodes){

        for (Integer itemCode : itemCodes) {
            switch(itemCode){
                case TINDERBOX:
                    if (!ItemSourceSet.tinderboxAvailable()){ return false; }
                case LIGHT_SOURCE:
                    if (!ItemSourceSet.lightSourceAvailable()){ return false; }
                case PICKAXE:
                    if (!ItemSourceSet.pickaxeAvailable()){ return false; }
                case FLY_FISHING_ROD:
                    if (!ItemSourceSet.flyFishingRodAvailable()){ return false; }
                case AXE:
                    if (!ItemSourceSet.axeAvailable()){ return false; }
                case KNIFE:
                    if (!ItemSourceSet.knifeAvailable()){ return false; }
                case DAIRY_COW:
                    if (!ItemSourceSet.dairyCowAvailable()){ return false; }
                case EGG:
                    if (!ItemSourceSet.eggAvailable()){ return false; }
                case WINDMILL:
                    if (!ItemSourceSet.windmillAvailable()){ return false; }
            }
        }
        return true;
    }
    
}
