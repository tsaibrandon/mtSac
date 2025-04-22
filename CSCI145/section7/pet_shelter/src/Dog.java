public class Dog extends Pet{

    public Dog(int id, String name, Species species) {
        super(id, name, Species.CANINE);
    }

    @Override
    public String speak() {
        return "Woof!!!";
    }
}
