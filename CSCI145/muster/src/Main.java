public class Main {

    public static void main(String[] args) {
        Game game = new Game();

        game.startMenu();
        
        char choice = game.playPrompt();
        
        if(choice == 'n') {
            System.out.println("\n---- See you later, alligator ----");
        } else {
            game.play(choice);
        }
    }
}