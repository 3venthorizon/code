package code.wald.logic.branch.scenario;


import static org.junit.Assert.*;
import static code.wald.logic.branch.scenario.Permission.*;

import org.junit.Before;
import org.junit.Test;


/**
 * @author Dewald Pretorius
 */
public class PermissionTest {
    
    Permission permission;
    
    @Before
    public void setUp() throws Exception {
        permission = new Permission();
        
        assertEquals(NONE, permission.getMultiplexed());
    }

    @Test
    public void getPermissions() {
        int multiplexed = READ | EXECUTE;
        permission.setMultiplexed(multiplexed);
        
        boolean isRead = permission.getPermissions(READ);
        boolean isExecute = permission.getPermissions(EXECUTE);
        boolean isReadAndExecute = permission.getPermissions(READ | EXECUTE);
        boolean isWrite = permission.getPermissions(WRITE);
        
        assertTrue(isRead);
        assertTrue(isExecute);
        assertTrue(isReadAndExecute);
        assertFalse(isWrite);
    }

    @Test
    public void setPermissions() {
        int multiplexed = EXECUTE;
        permission.setMultiplexed(multiplexed);
        
        permission.setPermissions(READ, true);
        assertTrue(permission.getPermissions(EXECUTE));
        assertTrue(permission.getPermissions(READ));
        assertFalse(permission.getPermissions(WRITE));
        assertEquals(READ | EXECUTE, permission.getMultiplexed());
        
        permission.setPermissions(WRITE, true);
        assertTrue(permission.getPermissions(WRITE));
        assertEquals(READ | WRITE | EXECUTE, permission.getMultiplexed());
        
        permission.setPermissions(WRITE | EXECUTE, false);
        assertTrue(permission.getPermissions(READ));
        assertFalse(permission.getPermissions(EXECUTE));
        assertFalse(permission.getPermissions(WRITE));
        assertEquals(READ, permission.getMultiplexed());
    }

}
