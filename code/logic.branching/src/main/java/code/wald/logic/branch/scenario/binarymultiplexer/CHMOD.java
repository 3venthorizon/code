package code.wald.logic.branch.scenario.binarymultiplexer;


/**
 * @author Dewald Pretorius
 */
public class CHMOD {
    
    public static String setPermissions(File file, int owner, int group, int other) {
        file.getOwner().setMultiplexed(owner);
        file.getGroup().setMultiplexed(group);
        file.getOther().setMultiplexed(other);
        
        return file.getOwner().toString() + file.getGroup().toString() + file.getOther().toString();
    }
    
}
