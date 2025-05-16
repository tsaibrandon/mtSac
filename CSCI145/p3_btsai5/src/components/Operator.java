package components;

import java.util.List;

public class Operator extends Entity {
    private boolean hasSetLittleDoctor;
    private char symbol;

    public Operator() {
        super(GameConstants.SHUTTLE_BAY_ROW, GameConstants.SHUTTLE_BAY_COL);
        this.hasSetLittleDoctor = false;
        this.symbol = GameConstants.OPERATOR_SYMBOL;
    }

    public boolean hasSetLittleDoctor() {
        return hasSetLittleDoctor;
    }

    public char getSymbol() {
        return symbol;
    }

    public boolean isInCenterRoom() {
        return row >= GameConstants.CENTER_START && row <= GameConstants.CENTER_END &&
               col >= GameConstants.CENTER_START && col <= GameConstants.CENTER_END;
    }

    public boolean isInShuttleBay() {
        return row == GameConstants.SHUTTLE_BAY_ROW && col == GameConstants.SHUTTLE_BAY_COL;
    }

    public void setLittleDoctor() {
        if(isInCenterRoom()) {
            System.out.println("\nThe little doctor has been set!");
            hasSetLittleDoctor = true;
        }else {
            System.out.println("\nThere\'s not enough power in this room. Get to the center!");
        }
    }

    @Override
    public void move(List<Entity>[][] board) {}

    public boolean tryMove(int newRow, int newCol, List<Entity>[][] board) {
        if(isValidMove(newRow, newCol)) {
            board[row][col].remove(this);
            setPosition(newRow, newCol);
            board[newRow][newCol].add(this);
            
            return true;
        }
        
        return false;
    }

    private boolean isValidMove(int newRow, int newCol) {
        return newRow >= 0 && newRow < GameConstants.BOARD_SIZE &&
               newCol >= 0 && newCol < GameConstants.BOARD_SIZE;
    }
} 