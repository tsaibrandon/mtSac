import java.util.Scanner;

public class Game {

    Players players = new Players();
    Dice dice = new Dice();
    Scoring scoring = new Scoring();

    private static Scanner input = new Scanner(System.in);

    public void play(char choice) {
        while(choice == 'y') {
            getPlayers();
            scoreBoard();
            turn();

            choice = validInput("\nWould you like to play again? (Y/N) ");
            
            if(choice == 'n') {
                System.out.println("\n---- See you later, alligator ----");
            }

            if(choice == 'y') {
                players.addP1Score(-players.p1Score());
                players.addP2Score(-players.p2Score());
            }
        }
    }

    public void startMenu() {
        System.out.println("Welcome to Muster!");
        System.out.println("The first player to reach 1000 and exceed the other player's score wins.");
        System.out.println("\nScoring:");
        System.out.println("\t3\t\t3 points");
        System.out.println("\t5\t\t5 points");
        System.out.println("\tThree 1's\t10 points");
        System.out.println("\tThree 2's\t20 points");
        System.out.println("\tThree 3's\t30 points");
        System.out.println("\tThree 4's\t40 points");
        System.out.println("\tThree 5's\t50 points");
        System.out.println("\tThree 6's\t60 points");
        System.out.println("\t1-2-3-4-5-6\t300 points");
        System.out.println("\t3 Pairs\t\t150 points");
    }

    public char playPrompt() {
        return validInput("\nWould you like to play (Y/N)? ");
    }

    private char validInput(String prompt) {
        while(true) {
            System.out.print(prompt);
            String inputLine = input.next();
            char userInput = Character.toLowerCase(inputLine.charAt(0));

            if(inputLine.length() == 1 && Character.isLetter(userInput)) {
                if(userInput == 'y' || userInput == 'n') {
                    return userInput;
                }else {
                    System.out.println("Invalid input. Please enter Y or N");
                }
            }else {
                System.out.println("Invalid input. Please enter Y or N");
            }
        }
    }

    private void getPlayers() {
        System.out.print("\nEnter the first player's name: ");
        String player1 = input.next();

        System.out.print("Enter the second player's name: ");
        String player2 = input.next();

        players.setP1Name(player1);
        players.setP2Name(player2);
    }

    private void scoreBoard() {
        System.out.println("\nThe scores are: ");
        System.out.printf("\t%s: %d\n", players.getP1Name(), players.p1Score());
        System.out.printf("\t%s: %d\n", players.getP2Name(), players.p2Score());
    }

    private void turn() {
        int turn = 1;
        boolean gameOver = false;

        while(!gameOver) {
            System.out.printf("\n%s %d\n", "Turn", turn);
            System.out.println("------");   
            
            int p1Rolls = validNumRolls(p1NumRolls());
            dice.rollDice(p1Rolls);
            System.out.print("\tThe roll is: ");
            dice.printRolls();

            int points = scoring.calculateScore(dice.getDiceRolls());
            players.addP1Score(points);
            System.out.println("\t" + players.getP1Name() + " earns " + points + " points(s)");

            int p2Rolls = validNumRolls(p2NumRolls());
            dice.rollDice(p2Rolls);
            System.out.print("\tThe roll is: ");
            dice.printRolls();

            points = scoring.calculateScore(dice.getDiceRolls());
            players.addP2Score(points);
            System.out.println("\t" + players.getP2Name() + " earns " + points + " points(s)");

            scoreBoard();

            if (players.p1Score() >= 1000 || players.p2Score() >= 1000) {
                if (players.p1Score() > players.p2Score()) {
                    System.out.println("\n" + players.getP1Name() + " wins!");
                    gameOver = true;
                } else if (players.p2Score() > players.p1Score()) {
                    System.out.println("\n" + players.getP2Name() + " wins!");
                    gameOver = true;
                }
            }
            
            turn++;
        }
        
    }

    private int p1NumRolls() {
        System.out.print("\tHow many times would " + players.getP1Name() + " like to shake the dice? ");
        int numRolls = input.nextInt();
        return numRolls;
    }

    private int p2NumRolls() {
        System.out.print("\n\tHow many times would " + players.getP2Name() + " like to shake the dice? ");
        int numRolls = input.nextInt();
        return numRolls;
    }

    private int validNumRolls(int numRolls) {
        while(true) {
            if(numRolls >= 1 && numRolls <= 1000) {
                return numRolls;
            }else {
                System.out.print("\tPlease enter a value from 1 - 1000: ");
                numRolls = input.nextInt();
            }
        }
    }
}

