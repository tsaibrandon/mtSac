public abstract class Pet {

    private int id;
    private String name;
    private Species species;  

    public Pet(int id, String name, Species species) {
        this.id = id;
        this.name = name;
        this.species = species;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public abstract String speak();

    public String toString() {
        return Integer.toString(id) + " the " + species + " is named " + name + " says " + speak();
    }

}
