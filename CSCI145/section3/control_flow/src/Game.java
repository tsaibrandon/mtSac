import java.util.Scanner;

public class Game {
    
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Game game = new Game();
        char option;

        while(true) {  
            option = game.getOption("Would you like to play the game (y/n)? ");

            if(game.isValidOption(option)) {
                if(option == 'y') game.start();
                else return;
            } else {
                System.out.println("Invalid option!!!\nTry Again.");
            }
        }   
    }
        

    public Game() {
        
    }

    public void start() {
        System.out.println("The game ran");
    }

    private char getOption(String prompt) {
        System.out.print(prompt);
        return input.next().charAt(0);

    }

    private boolean isValidOption(char option) {
        option = Character.toLowerCase(option);
        return option == 'n' || option == 'y';
    }
}
