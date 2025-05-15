import java.util.List;

public class RegularGuard extends Guard {
    public RegularGuard(int row, int col) {
        super(row, col, GameConstants.REGULAR_MOVE_PROBABILITY, GameConstants.REGULAR_SYMBOL);
    }

    @Override
    public void move(List<Entity>[][] board) {
        if (shouldMove()) {
            moveRandomly(board);
        }
    }

    private void moveRandomly(List<Entity>[][] board) {
        int[] directions = {-1, 0, 1, 0, 0, -1, 0, 1}; // Up, Right, Down, Left
        int randomStart = (int)(Math.random() * 4) * 2;
        
        // Try each direction once, starting from a random direction
        for (int i = 0; i < 4; i++) {
            int dirIndex = (randomStart + i * 2) % 8;
            int newRow = row + directions[dirIndex];
            int newCol = col + directions[dirIndex + 1];
            
            if (isValidPosition(newRow, newCol) && isOneSpaceMove(newRow, newCol)) {
                setPosition(newRow, newCol);
                break;
            }
        }
    }
} 