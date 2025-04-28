import java.util.Scanner;

public class Game {
    private Board board;
    private BoardState boardState;
    private Player player;
    private ScanTool tool;
    private Menu menu;
    private Scanner scan;
    private boolean gameRunning;

    public Game() {
        this.board = new Board();
        this.boardState = new BoardState();
        this.player = new Player();
        this.menu = new Menu();
        this.scan = new Scanner(System.in);
        this.tool = new ScanTool(board, boardState, player);
        this.gameRunning = true;
    }

    public void startGame() {
        menu.printInstructions();
        board.createRooms();
        board.createBoard();
        tool.scanRooms();
        
        while (gameRunning) {
            menu.printBoard(boardState, player);
            menu.printPrompt();
            String input = scan.nextLine().toUpperCase();
            
            if (input.length() > 0) {
                processInput(input.charAt(0));
            }
        }

        menu.printPlayAgain();
        String playAgain = scan.nextLine().toUpperCase();
        if (playAgain.equals("Y")) {
            resetGame();
            startGame();
        }
    }

    private void processInput(char input) {
        if (!isValidInput(input)) {
            System.out.println("Invalid input! Please use R, L, U, D, or P.");
            return;
        }

        int newRow = player.getRow();
        int newCol = player.getColumn();

        switch (input) {
            case 'U':
                newRow--;
                break;
            case 'D':
                newRow++;
                break;
            case 'L':
                newCol--;
                break;
            case 'R':
                newCol++;
                break;
            case 'P':
                handlePickup();
                return;
        }

        if (isValidMove(newRow, newCol)) {
            player.updatePosition(newRow, newCol);
            checkCurrentRoom();
            tool.scanRooms();
        } else {
            menu.printInvalidMove();
        }
    }

    private boolean isValidInput(char input) {
        char[] validInputs = {'R', 'L', 'U', 'D', 'P'};
        
        for (char validInput : validInputs) {
            if (input == validInput) {
                return true;
            }
        }
        
        return false;
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    private void handlePickup() {
        int row = player.getRow();
        int col = player.getColumn();
        
        if (board.getBoard()[row][col] == RoomType.WEAPON) {
            player.setBag("Weapon");
            board.getBoard()[row][col] = RoomType.EMPTY;
            tool.scanRooms();
        } else {
            menu.printInvalidPickup();
        }
    }

    private void checkCurrentRoom() {
        int row = player.getRow();
        int col = player.getColumn();
        RoomType currentRoom = board.getBoard()[row][col];

        if (currentRoom == RoomType.RADIATION || currentRoom == RoomType.VENT) {
            gameRunning = false;
            menu.printGameOver(false);
        } else if (row == 0 && col == 0 && player.getBag().equals("Weapon")) {
            gameRunning = false;
            menu.printGameOver(true);
        }
    }

    private void resetGame() {
        this.board = new Board();
        this.boardState = new BoardState();
        this.player = new Player();
        this.tool = new ScanTool(board, boardState, player);
        this.gameRunning = true;
    }
}

