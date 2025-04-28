public class Menu {
    public void printInstructions() {
        System.out.println("\nEnder Outpost Attack Simulator");
        System.out.println("Avoid at all cost the radiation and vaccuum of space.");
        System.out.println("Locate the dreaded PMS weapon and return to Centurion Station with it.");
    }

    public void printBoard(BoardState boardState, Player player) {
        System.out.println("\n  0   1   2   3   4   5   6   7");
        for (int i = 0; i < 8; i++) {
            System.out.print(" ");
            for (int j = 0; j < 8; j++) {
                System.out.print("+---");
            }
            System.out.println("+");
            
            System.out.print(i);
            for (int j = 0; j < 8; j++) {
                System.out.print("|");
                String scanResults = boardState.getScanResults(i, j);
                System.out.print(scanResults);
            }
            System.out.println("|");
            
            System.out.print(" ");
            for (int j = 0; j < 8; j++) {
                System.out.print("|");
                if (player.getRow() == i && player.getColumn() == j) {
                    System.out.print(" " + player.getIcon() + " ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println("|");
        }
        
        System.out.print(" ");
        for (int j = 0; j < 8; j++) {
            System.out.print("+---");
        }
        System.out.println("+");
    }

    public void printGameOver(boolean isWin) {
        if (isWin) {
            System.out.println("\nCongratulations! Mission Accomplished!");
            System.out.println("You successfully retrieved the weapon and escaped!");
        } else {
            System.out.println("\nGame Over! Mission Failed!");
            System.out.println("Your operator did not survive...");
        }
    }

    public void printInvalidMove() {
        System.out.println("\nInvalid move! Please stay within the grid boundaries.\n");
    }

    public void printInvalidPickup() {
        System.out.println("\nThere is no weapon to pick up in this room!\n");
    }

    public void printPrompt() {
        System.out.println("\nEnter your move ");
        System.out.print("(R)ight, (L)eft, (U)p, (D)own, (P)ick up weapon: ");
    }

    public void printPlayAgain() {
        System.out.print("\nWould you like to play again? (Y/N): ");
    }
}
