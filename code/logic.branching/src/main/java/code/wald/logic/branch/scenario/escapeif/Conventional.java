package code.wald.logic.branch.scenario.escapeif;


import java.util.Date;


/**
 * @author Dewald Pretorius
 */
public class Conventional {

    private String name;
    private String surname;
    private Date dob;
    
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (object != null && object instanceof Conventional) {
            Conventional other = (Conventional) object;
            
            if ((this.name == null && other.name == null) || 
                (this.name != null) && this.name.equals(other.name)) {
                if ((this.surname == null && other.surname == null) || 
                    (this.surname != null) && this.surname.equals(other.surname)) {
                    if ((this.dob == null && other.dob == null) || 
                        (this.dob != null) && this.dob.equals(other.dob)) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
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
