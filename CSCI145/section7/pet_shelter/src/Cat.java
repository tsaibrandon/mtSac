public class Cat extends Pet{

    public Cat(int id, String name, Species species) {
        super(id, name, Species.FELINE);
    }

    @Override
    public String speak() {
        return "Hiss";
    }
}
