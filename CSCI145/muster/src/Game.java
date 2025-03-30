import java.util.Scanner;

public class Game {

    Players players = new Players();

    private static Scanner input = new Scanner(System.in);

    public static void play() {
        startMenu();
        gameState();

        while(startMenu() == "Y") {
            
        }
    }

    public static void startMenu() {
        System.out.println("Welcome to Muster!");
        System.out.println("The first player to reach 1000 and exceed the other player's score wins.");
        System.out.println("Scoring:");
        System.out.println("\t3\t\t3 points");
        System.out.println("\t5\t\t5 points");
        System.out.println("\tThree 1's\t\t10 points");
        System.out.println("\tThree 2's\t\t20 points");
        System.out.println("\tThree 3's\t\t30 points");
        System.out.println("\tThree 4's\t\t40 points");
        System.out.println("\tThree 5's\t\t50 points");
        System.out.println("\tThree 6's\t\t60 points");
        System.out.println("\t1-2-3-4-5-6\t\t300 points");
        System.out.println("\t3 Pairs\t\t150 points");
    }

    private char gameState() {
        return validInput("Would you like to play (Y/N)? ");
    }

    private char validInput(String prompt) {
        char userInput;

        while(true) {
            System.out.println(prompt);
            String inputLine = input.next();

            if(inputLine.length() > 1 || !inputLine.isDigit()) {
                System.out.println("Invalid input. Please enter Y or N");
            }else {
                userInput = this.input.next().charAt(0);
                if(userInput.toLower() == "y" || userInput.toLower() == "n") {
                    return userInput;
                }
            }
            
        }
        

    }

}
