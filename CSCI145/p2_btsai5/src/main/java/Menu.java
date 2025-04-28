public class Menu {
    private static final int ROWS = 8;
    private static final int COLS = 8;

    public void printInstructions() {
        System.out.println("Welcome to the Space Station Mission!");
        System.out.println("\nInstructions:");
        System.out.println("- Use R, L, U, D to move Right, Left, Up, Down");
        System.out.println("- Use P to pick up the weapon when you find it");
        System.out.println("- Avoid rooms with Radiation (R) or Vacuum (V)");
        System.out.println("- Find the weapon (W) and return to start (0,0)");
        System.out.println("- Your position is marked with 'O'");
        System.out.println("\nGood luck, operator!\n");
    }

    public void printBoard(RoomType[][] board, BoardState boardState, Player player) {
        System.out.println("\nCurrent Board State:");
        System.out.println("   0  1  2  3  4  5  6  7");
        
        for (int i = 0; i < ROWS; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < COLS; j++) {
                System.out.print("[");
                
                // Print detected hazards from BoardState
                ScanDetect[] detections = boardState.getDetections(i, j);
                if (detections != null) {
                    for (ScanDetect detection : detections) {
                        if (detection != null) {
                            System.out.print(detection.toString());
                        }
                    }
                }
                
                // Print player icon if present
                if (i == player.getRow() && j == player.getColumn()) {
                    System.out.print("O");
                } else {
                    System.out.print(" ");
                }
                
                System.out.print("]");
            }
            System.out.println();
        }
        
        System.out.println("\nStatus: " + player.getStatus());
        System.out.println("Bag: " + player.getBag());
    }

    public void printGameOver(boolean success) {
        if (success) {
            System.out.println("\nCongratulations! Mission Successful!");
            System.out.println("You retrieved the weapon and made it back safely!");
        } else {
            System.out.println("\nGame Over! Mission Failed!");
            System.out.println("Better luck next time, operator.");
        }
    }

    public void printPrompt() {
        System.out.print("\nEnter move (R/L/U/D/P): ");
    }

    public void printError(String message) {
        System.out.println("\nError: " + message);
    }
}
