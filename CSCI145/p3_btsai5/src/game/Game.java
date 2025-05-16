package game;

import java.util.ArrayList;
import java.util.List;

import components.Entity;
import components.Operator;
import components.Guard;
import components.GameConstants;
import components.FodderGuard;
import components.RegularGuard;
import components.ATeamGuard;

public class Game {
    private List<Entity>[][] board;
    private List<Entity> guards;
    private Operator operator;
    private boolean gameOver;
    private boolean hasWon;

    @SuppressWarnings("unchecked")
    public Game() {
        board = new List[GameConstants.BOARD_SIZE][GameConstants.BOARD_SIZE];
        // Initialize each cell with an empty list
        for (int i = 0; i < GameConstants.BOARD_SIZE; i++) {
            for (int j = 0; j < GameConstants.BOARD_SIZE; j++) {
                board[i][j] = new ArrayList<>();
            }
        }
        guards = new ArrayList<>();
        operator = new Operator();
        initializeGame();
    }

    private void initializeGame() {
        // Place operator in shuttle bay
        board[operator.getRow()][operator.getCol()].add(operator);

        // Create and place guards
        placeGuards(GameConstants.FODDER_GUARD_COUNT, FodderGuard.class);
        placeGuards(GameConstants.REGULAR_GUARD_COUNT, RegularGuard.class);
        placeGuards(GameConstants.ATEAM_GUARD_COUNT, ATeamGuard.class);
    }

    private void placeGuards(int count, Class<? extends Guard> guardType) {
        for (int i = 0; i < count; i++) {
            while (true) {
                int row = (int)(Math.random() * GameConstants.BOARD_SIZE);
                int col = (int)(Math.random() * GameConstants.BOARD_SIZE);

                if (isValidGuardPlacement(row, col)) {
                    try {
                        Guard guard = guardType.getDeclaredConstructor(int.class, int.class)
                                             .newInstance(row, col);
                        board[row][col].add(guard);
                        guards.add(guard);
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private boolean isValidGuardPlacement(int row, int col) {
        // Check if position is not in restricted areas
        if ((row == 0 && col == 0) || // Shuttle bay
            (row == 0 && col == 1) || // Right of shuttle bay
            (row == 1 && col == 0))   // Below shuttle bay
        {
            return false;
        }

        return true; // Multiple guards can share a cell
    }

    public boolean moveOperator(char direction) {
        int newRow = operator.getRow();
        int newCol = operator.getCol();

        switch (Character.toUpperCase(direction)) {
            case 'U': newRow--; break;
            case 'D': newRow++; break;
            case 'L': newCol--; break;
            case 'R': newCol++; break;
            default: return false;
        }

        if (isValidPosition(newRow, newCol)) {
            // Remove operator from current position
            board[operator.getRow()][operator.getCol()].remove(operator);
            operator.setPosition(newRow, newCol);
            board[newRow][newCol].add(operator);
            
            moveGuards();
            checkGameState();
            return true;
        }
        return false;
    }

    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < GameConstants.BOARD_SIZE &&
               col >= 0 && col < GameConstants.BOARD_SIZE;
    }

    public void trySetLittleDoctor() {
        operator.setLittleDoctor();
    }

    private void moveGuards() {
        // Create a copy of guards list to avoid concurrent modification
        List<Entity> guardsCopy = new ArrayList<>(guards);
        for (Entity guard : guardsCopy) {
            // Remove guard from current position
            board[guard.getRow()][guard.getCol()].remove(guard);
            guard.move(board);
            // Add guard to new position
            board[guard.getRow()][guard.getCol()].add(guard);
        }
    }

    private void checkGameState() {
        // Check if operator is in same room as a guard
        if (isOperatorCaught()) {
            gameOver = true;
            hasWon = false;
            return;
        }

        // Check win condition
        if (operator.hasSetLittleDoctor() && operator.isInShuttleBay()) {
            gameOver = true;
            hasWon = true;
        }
    }

    private boolean isOperatorCaught() {
        List<Entity> operatorCell = board[operator.getRow()][operator.getCol()];
        for (Entity entity : operatorCell) {
            if (entity instanceof Guard) {
                return true;
            }
        }
        return false;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean hasWon() {
        return hasWon;
    }

    public List<Entity>[][] getBoard() {
        return board;
    }

    public List<Entity> getGuards() {
        return guards;
    }

    public Operator getOperator() {
        return operator;
    }
} 