package code.wald.logic.branch.scenario;


import static org.junit.Assert.*;
import static code.wald.logic.branch.scenario.Permission.*;

import org.junit.Before;
import org.junit.Test;


/**
 * @author Dewald Pretorius
 */
public class CHMODTest {
    
    private File file;
    
    @Before
    public void setUp() {
        file = new File("home", "chmod.test");
    }
    

    @Test
    public void test() {
        int owner = READ | WRITE | EXECUTE;
        int group = READ | WRITE;
        int other = READ;
        
        String expected = "rwxrw-r--";
        String result = CHMOD.setPermissions(file, owner, group, other);
        
        System.out.println("Test CHMOD File Permissions: " + owner + "" + group + "" + other + " - Expect " +expected);
        assertEquals(expected, result);
    }

}
