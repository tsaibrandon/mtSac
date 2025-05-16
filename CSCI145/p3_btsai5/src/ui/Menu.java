package ui;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

import main.Main;
import game.Game;
import components.Entity;
import components.GameConstants;
import components.Operator;
import components.Guard;

public class Menu {
    private Scanner scanner;
    private Game game;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("\nEnder Outpost Attack Simulator");
        System.out.println("Avoid at all costs the roving guards.");
        System.out.println("Get to one of the four centrally located rooms and set the MD device then escape to activate it.");
        
        do {
            game = new Game();
            playGame();
            System.out.print("\nWould you like to play again? (Y/N): ");
        } while (scanner.nextLine().trim().toUpperCase().startsWith("Y"));
    }

    private void playGame() {
        while (!game.isGameOver()) {
            displayBoard();
            handleUserInput();
        }
        
        displayBoard();
        displayGameResult();
    }

    private void displayBoard() {
        List<Entity>[][] board = game.getBoard();
        
        System.out.println("\n   0     1     2     3     4     5     6     7");
        
        for(int i = 0; i < GameConstants.BOARD_SIZE; i++) {
            System.out.print(" ");
            
            for(int j = 0; j < GameConstants.BOARD_SIZE; j++) {
                System.out.print("+-----");
            }
            
            System.out.println("+");
            
            System.out.print(i);
            for(int j = 0; j < GameConstants.BOARD_SIZE; j++) {
                System.out.print("|");
                List<Entity> cellEntities = board[i][j];
                
                if(!cellEntities.isEmpty()) {
                    Set<Character> symbols = new HashSet<>();
                    
                    boolean hasOperator = false;
                    int startPos = 1; 
                    
                    for(Entity entity : cellEntities) {
                        if(entity instanceof Operator) {
                            hasOperator = true;
                            symbols.add(entity.getSymbol());
                            
                            break;
                        }
                    }
                    
                    for(Entity entity : cellEntities) {
                        if(entity instanceof Guard) {
                            symbols.add(((Guard) entity).getSymbol());
                        }
                    }
                    
                    StringBuilder cell = new StringBuilder("     "); 
                    
                    if(hasOperator) {
                        cell.setCharAt(startPos++, GameConstants.OPERATOR_SYMBOL);
                    }
                    
                    for(char symbol : symbols) {
                        if(symbol != GameConstants.OPERATOR_SYMBOL && startPos < 4) {
                            cell.setCharAt(startPos++, symbol);
                        }
                    }
                    
                    System.out.print(cell);
                }else {
                    System.out.print("     ");
                }
            }
            System.out.println("|");
            
            System.out.print(" ");
            
            for (int j = 0; j < GameConstants.BOARD_SIZE; j++) {
                System.out.print("|     ");
            }
            
            System.out.println("|");
        }
        
        System.out.print(" ");
        
        for(int j = 0; j < GameConstants.BOARD_SIZE; j++) {
            System.out.print("+-----");
        }
        
        System.out.println("+");
    }

    private void handleUserInput() {
        System.out.println("\nEnter your move");
        System.out.print("(R)ight, (L)eft, (U)p, (D)own, (S)et to set the device: ");
        
        String input = scanner.nextLine().trim().toUpperCase();
        char action = input.charAt(0);
        
        if(input.isEmpty()) {
            return;
        }

        if(action == 'S') {
            game.trySetLittleDoctor();
        }else if("RLUD".indexOf(action) >= 0) {
            if(!game.moveOperator(action)) {
                System.out.println("\nInvalid move! Please stay within the grid boundaries.");
            }
        }else {
            System.out.println("\nInvalid input! Please try again.");
        }
    }

    private void displayGameResult() {
        if(game.hasWon()) {
            System.out.println("\nCongratulations! You've successfully set the little doctor and escaped!");
        }else {
            System.out.println("\nGame Over! You were caught by a guard!");
        }
    }
} 