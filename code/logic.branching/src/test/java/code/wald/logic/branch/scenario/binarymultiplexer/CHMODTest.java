package code.wald.logic.branch.scenario.binarymultiplexer;


import static code.wald.logic.branch.scenario.binarymultiplexer.Permission.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import code.wald.logic.branch.scenario.binarymultiplexer.CHMOD;
import code.wald.logic.branch.scenario.binarymultiplexer.File;


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
