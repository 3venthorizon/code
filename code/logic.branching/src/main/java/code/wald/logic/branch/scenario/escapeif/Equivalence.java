package code.wald.logic.branch.scenario.escapeif;


import java.util.Date;


/**
 * @author Dewald Pretorius
 */
public class Equivalence {

    private String name;
    private String surname;
    private Date dob;
    
    
    /**
     * An example where the conditional-escape-instruction is used to reduce deeply nested if-statements
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (!(object instanceof Equivalence)) return false;
        
        Equivalence other = (Equivalence) object;
        
        if (this.name == null && other.name != null) return false;
        if (this.name != null && !this.name.equals(other.name)) return false;
        
        if (this.surname == null && other.surname != null) return false;
        if (this.surname != null && !this.surname.equals(other.surname)) return false;
        
        if (this.dob == null && other.dob != null) return false;
        if (this.dob != null && !this.dob.equals(other.dob)) return false;
        
        return true;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
