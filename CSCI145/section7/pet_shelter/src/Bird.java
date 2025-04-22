public class Bird extends Pet {

    public Bird(int id, String name, Species species) {
        super(id, name, Species.BIRD);
    }

    @Override
    public String speak() {
        return "Chirp Chirp";
    }

}
