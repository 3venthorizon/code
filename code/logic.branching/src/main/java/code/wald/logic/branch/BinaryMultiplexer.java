package code.wald.logic.branch;


/**
 * <p>
 * Binary Multiplexing is a method that not only proposes a solution but challenges the code style convention. By
 * multiplexing multiple Boolean variables into a single Integer (32-bit) or Long (64-bit) value it is able to reduce
 * the input parameters 32 or 64 fold respectively. Thus, drastically reducing the interface complexity while allowing a
 * great degree of interface tolerance for future changes.
 * </p>
 * <p>
 * A single Boolean variable can be represented by a single binary bit for which the possible values are:
 * <ul>
 * <li>0 = False
 * <li>1 = True
 * </ul>
 * Based on the fact that an Integer value consists of 32 bits, we can logically group 32 Boolean variables into a
 * single Integer variable. The benefit now is that instead of using single Boolean variables we can simultaneously
 * evaluate and manipulate multiple bits in an Integer using basic arithmetic.
 * </p>
 * 
 * @author Dewald Pretorius
 */
public class BinaryMultiplexer {

    /**
     * Here we need to create the constants that will indicate the bit position to which each boolean variable will be
     * multiplexed into. Each integer constant contains only a single bit set denoting the position which the boolean
     * variable will occupy in the {@link #multiplexed} field. Without memorising the 2-power bit values one can just
     * bit-wise left-shift the least significant (LSB) bit starting at 0 all the way to 31.
     */

    public static final int VAR_ONE = 1 << 0; // will set the lsb
    public static final int VAR_TWO = 1 << 1; // shift-left 1 place
    public static final int VAR_THREE = 1 << 2; // shift-left 2 places
    public static final int VAR_FOUR = 1 << 3; // shift-left 3 places
    public static final int VAR_FIVE = 1 << 4; // shift-left 4 places

    // single binary multiplexed field containing all boolean bit variables
    private int multiplexed;

    public BinaryMultiplexer(int multiplexed) {
        setMultiplexed(multiplexed);
    }

    /**
     * <p>
     * This method will set the binary value to the single bit on the {@link #multiplexed} field for the given
     * bitVariable constant.
     * </p>
     * <p>
     * We use a bit-mask to apply bit-wise arithmetic to the {@link #multiplexed} field:
     * <ul>
     * <li>When the value is true: bit-wise OR the bit-mask to the {@link #multiplexed} field
     * <li>When the value is false: bit-wise AND the compliment of the bit-mask to the {@link #multiplexed} field
     * </ul>
     * </p>
     * 
     * @param bitVariable
     * @param value
     */
    public void setBit(int bitVariable, boolean value) {
        int bitMask;

        if (value == true) {
            bitMask = bitVariable;
            multiplexed |= bitMask;
        } else /* if (value == false) */ {
            bitMask = ~bitVariable;
            multiplexed &= bitMask;
        }
    }

    /**
     * <p>
     * This method will return the boolean bit value of the {@link #multiplexed} field for the given bitVariable
     * constant.
     * </p>
     * <p>
     * The bitVariable is used as a bit-mask to zero-out the other bits of the {@link #multiplexed} field by applying a
     * bit-wise AND operation. Then by equating the result against the bitVariable will calculate the appropriate bit's
     * boolean value.
     * </p>
     * 
     * @param bitVariable
     * @return bit-value
     */
    public boolean getBit(int bitVariable) {
        return ((multiplexed & bitVariable) == bitVariable);
    }

    public int getMultiplexed() {
        return multiplexed;
    }

    public void setMultiplexed(int multiplexed) {
        this.multiplexed = multiplexed;
    }
}
