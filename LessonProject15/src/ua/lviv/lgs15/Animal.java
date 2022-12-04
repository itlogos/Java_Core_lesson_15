package ua.lviv.lgs15;

public class Animal {
    private String type;
    private String petName;
    public Animal(String type, String petName) {
        super();
        this.type = type;
        this.petName = petName;
    }
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public String getPetName() {
        return petName;
    }
    public void setPetName(String petName) {
        this.petName = petName;
    }
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((petName == null) ? 0 : petName.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Animal other = (Animal) obj;
        if (petName == null) {
            if (other.petName != null)
                return false;
        } else if (!petName.equals(other.petName))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "\n type=" + type + ", petName=" + petName;
    }
    
    
    }
