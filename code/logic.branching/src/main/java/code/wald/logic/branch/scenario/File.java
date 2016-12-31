/**
 * 
 */
package code.wald.logic.branch.scenario;


/**
 * @author Dewald Pretorius
 */
public class File {
    
    private final Permission owner;
    private final Permission group;
    private final Permission other;
    
    private String path;
    private String name; 
    
    public File(String path, String name) {
        setPath(path);
        setName(name);
        
        owner = new Permission();
        group = new Permission();
        other = new Permission();
    }
    
    @Override
    public int hashCode() {
        int result = 31;
        result += ((name == null) ? 0 : name.hashCode());
        result += ((path == null) ? 0 : path.hashCode());
        
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof File)) return false;
        
        File other = (File) obj;
        
        if (this.name == null && other.name != null) return false;
        if (this.name != null && !this.name.equals(other.name)) return false;

        if (this.path == null && other.path != null) return false;
        if (this.path != null && !this.path.equals(other.path)) return false;
        
        return true;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Permission getOwner() {
        return owner;
    }

    public Permission getGroup() {
        return group;
    }

    public Permission getOther() {
        return other;
    }
}
