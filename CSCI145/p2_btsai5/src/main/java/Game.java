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
        this.tool = new ScanTool(player, board, boardState);
        this.gameRunning = true;
    }

    public void startGame() {
        menu.printInstructions();
        board.createRooms();
        board.createBoard();
        
        while (gameRunning) {
            tool.scanRooms();
            menu.printBoard(board.getBoard(), boardState, player);
            menu.printPrompt();
            
            String input = scan.nextLine().toUpperCase();
            if (!input.isEmpty()) {
                processMove(input.charAt(0));
            }
        }
        
        scan.close();
    }

    private void processMove(char input) {
        if (validMove(input)) {
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
                    pickupWeapon();
                    return;
            }
            
            if (isValidPosition(newRow, newCol)) {
                player.updatePosition(newRow, newCol);
                checkCurrentRoom();
            } else {
                menu.printError("Cannot move outside the grid!");
            }
        } else {
            menu.printError("Invalid move! Use R, L, U, D, or P.");
        }
    }

    private boolean validMove(char input) {
        return input == 'R' || input == 'L' || input == 'U' || input == 'D' || input == 'P';
    }

    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    private void checkCurrentRoom() {
        RoomType currentRoom = board.getBoard()[player.getRow()][player.getColumn()];
        
        if (currentRoom == RoomType.RADIATION || currentRoom == RoomType.VENT) {
            player.setStatus("Dead");
            gameRunning = false;
            menu.printBoard(board.getBoard(), boardState, player);
            menu.printGameOver(false);
        } else if (player.getBag().equals("Weapon") && player.getRow() == 0 && player.getColumn() == 0) {
            gameRunning = false;
            menu.printBoard(board.getBoard(), boardState, player);
            menu.printGameOver(true);
        }
    }

    private void pickupWeapon() {
        RoomType currentRoom = board.getBoard()[player.getRow()][player.getColumn()];
        if (currentRoom == RoomType.WEAPON) {
            player.setBag("Weapon");
            menu.printBoard(board.getBoard(), boardState, player);
            System.out.println("You picked up the weapon!");
        } else {
            menu.printError("No weapon to pick up in this room!");
        }
    }
}
