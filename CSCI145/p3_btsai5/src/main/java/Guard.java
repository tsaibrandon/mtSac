import java.util.List;

public abstract class Guard extends Entity {
    protected double moveProbability;
    protected char symbol;

    public Guard(int row, int col, double moveProbability, char symbol) {
        super(row, col);
        this.moveProbability = moveProbability;
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    protected boolean shouldMove() {
        return Math.random() < moveProbability;
    }

    // Helper method to validate one-space movement
    protected boolean isOneSpaceMove(int newRow, int newCol) {
        int rowDiff = Math.abs(newRow - row);
        int colDiff = Math.abs(newCol - col);
        
        // Must move exactly one space, either horizontally or vertically (not both)
        return (rowDiff == 1 && colDiff == 0) || (rowDiff == 0 && colDiff == 1);
    }

    // Helper method to check if position is within board boundaries
    protected boolean isValidPosition(int newRow, int newCol) {
        return newRow >= 0 && newRow < GameConstants.BOARD_SIZE &&
               newCol >= 0 && newCol < GameConstants.BOARD_SIZE;
    }

    @Override
    public abstract void move(List<Entity>[][] board);
} 