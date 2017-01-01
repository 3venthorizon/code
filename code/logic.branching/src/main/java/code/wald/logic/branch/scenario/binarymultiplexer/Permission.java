package code.wald.logic.branch.scenario.binarymultiplexer;


/**
 * @author Dewald Pretorius
 */
public class Permission {
    
    //encode execute only constant to the least significant integer bit-position
    public static final int EXECUTE = 1 << 0;
    //encode write only constant to the second bit position
    public static final int WRITE = 1 << 1;
    //encode read only constant to the third bit-position
    public static final int READ = 1 << 2;
    
    //encode a constant where none of the permission bits are set
    public static final int NONE = 0;
    //encode a constant where all of the permission bits are set, the complement of NONE
    public static final int ALL = ~NONE;
    
    //binary-multiplexed permission
    private int multiplexed;
    
    public Permission() {
        this(NONE);
    }
    
    public Permission(int permission) {
        setMultiplexed(permission);
    }

    public boolean getPermissions(int bitMask) {
        return ((multiplexed & bitMask) == bitMask);
    }
    
    public void setPermissions(int bitMask, boolean value) {
        if (value) {
            multiplexed |= bitMask; 
        } else {
            multiplexed &= ~bitMask;
        }
    }
    
    @Override
    public int hashCode() {
        return multiplexed;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Permission)) return false;
        
        Permission other = (Permission) obj;
        if (this.multiplexed != other.multiplexed) return false;
        
        return true;
    }
    
    @Override
    public String toString() {
        String permissions = "rwx";
        String result = new String();
        
        for (int position = 0, bitMask = READ; bitMask > NONE; position++, bitMask >>= 1) {
            result += getPermissions(bitMask) ? permissions.charAt(position) : '-';
        }
        
        return result;
    }

    public int getMultiplexed() {
        return multiplexed;
    }
    
    public void setMultiplexed(int multiplexed) {
        this.multiplexed = multiplexed;
    }
}
