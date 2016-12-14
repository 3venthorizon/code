package code.wald.logic.branch;


/**
 * The intent of this class is to contrast the coding style and structure of branching logic between nesting of 
 * if-statements versus conditional escape instructions. 
 * 
 * @author Dewald Pretorius
 */
public class ConditionalEscapeInstruction {

    /**
     * A classic example where if-statements with a nested block-scope is collapsed into a conditional instruction.
     * 
     * @param text
     */
    public void emptyNullCheck(String text) {
//        if (text != null) {
//            if (text.isEmpty() == false) {
//                System.out.println("Text: " + text);
//            }
//        }
        
        /**
         * The solution to each block-scope if-statement is to negate the if-statement condition and then apply the
         * escape instruction (return; continue; break; throw ...Exception;)
         */
        
        if (text == null) return; //conditional escape instruction
        if (text.isEmpty() == true) return; //conditional escape instruction
        System.out.println("Text: " + text);
        
        //the result is neatly structured code in the same block-scope that is functionally identical
    }
}
