public class Main {

    public static void main(String[] args) {
        Pet[] inventory = new Pet[] {
            new Dog(777, "Lucky"),
            new Cat(0, "Unwanted"),
            new Bird(1024, "Ginger")
        };
            
        for (int i = 0; i < inventory.length; i++) {
            System.out.println(inventory[i]);
        }
    }
}
