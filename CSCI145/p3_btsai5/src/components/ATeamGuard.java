package components;

import java.util.List;

public class ATeamGuard extends Guard {
    private boolean canMoveRandomly;
    private int targetRow;
    private int targetCol;
    private boolean isTracking; 

    public ATeamGuard(int row, int col) {
        super(row, col, GameConstants.ATEAM_MOVE_PROBABILITY, GameConstants.ATEAM_SYMBOL);
        this.canMoveRandomly = true;
        this.isTracking = false;
        this.targetRow = -1;
        this.targetCol = -1;
    }

    @Override
    public void move(List<Entity>[][] board) {
        Entity operator = findAdjacentOperator(board);

        boolean operatorInRoom = false;
        
        for(Entity entity : board[row][col]) {
            if(entity instanceof Operator) {
                operatorInRoom = true;
                
                break;
            }
        }
        
        if(operatorInRoom) {
            return;
        }
        
        if (operator != null) {
            int operatorRow = operator.getRow();
            int operatorCol = operator.getCol();

            boolean roomEmpty = true;
            
            targetRow = operatorRow;
            targetCol = operatorCol;
            canMoveRandomly = false;
            isTracking = true;
            
            for(Entity entity : board[operatorRow][operatorCol]) {
                if(entity instanceof Operator) {
                    roomEmpty = false;
                    
                    break;
                }
            }
            
            if(roomEmpty && isOneSpaceMove(operatorRow, operatorCol)) {
                setPosition(operatorRow, operatorCol);
                operator = findAdjacentOperator(board);

                if(operator != null) {
                    targetRow = operator.getRow();
                    targetCol = operator.getCol();
                    isTracking = true;
                    canMoveRandomly = false;
                }
            }
        }else if(isTracking) {
            if(isOneSpaceMove(targetRow, targetCol)) {
                boolean roomEmpty = true;
                
                for(Entity entity : board[targetRow][targetCol]) {
                    if(entity instanceof Operator) {
                        roomEmpty = false;
                        
                        break;
                    }
                }
                
                if (roomEmpty) {
                    setPosition(targetRow, targetCol);
                    operator = findAdjacentOperator(board);

                    if(operator != null) {
                        targetRow = operator.getRow();
                        targetCol = operator.getCol();
                        isTracking = true;
                        canMoveRandomly = false;
                    }else {
                        isTracking = false;
                        canMoveRandomly = true;
                        targetRow = -1;
                        targetCol = -1;
                    }
                }
            }
        }else if(shouldMove() && canMoveRandomly) {
            moveRandomly(board);
            operator = findAdjacentOperator(board);
            
            if(operator != null) {
                targetRow = operator.getRow();
                targetCol = operator.getCol();
                canMoveRandomly = false;
                isTracking = true;
            }
        }
    }

    private Entity findAdjacentOperator(List<Entity>[][] board) {
        int[][] directions = {
            {-1, 0},  // Up
            {0, 1},   // Right
            {1, 0},   // Down
            {0, -1}   // Left
        };
        
        for (int[] dir : directions) {
            int checkRow = row + dir[0];
            int checkCol = col + dir[1];
            
            if(isValidPosition(checkRow, checkCol)) {
                for(Entity entity : board[checkRow][checkCol]) {
                    if(entity instanceof Operator) {
                        return entity;
                    }
                }
            }
        }
        
        return null;
    }

    private void moveRandomly(List<Entity>[][] board) {
        int[] directions = {-1, 0, 1, 0, 0, -1, 0, 1}; 
        int randomStart = (int)(Math.random() * 4) * 2;
        
        for(int i = 0; i < 4; i++) {
            int dirIndex = (randomStart + i * 2) % 8;
            int newRow = row + directions[dirIndex];
            int newCol = col + directions[dirIndex + 1];
            
            if(isValidPosition(newRow, newCol) && isOneSpaceMove(newRow, newCol)) {
                setPosition(newRow, newCol);
                
                break;
            }
        }
    }

    @Override
    protected boolean isOneSpaceMove(int newRow, int newCol) {
        int rowDiff = Math.abs(newRow - row);
        int colDiff = Math.abs(newCol - col);
        boolean isOneSpace = (rowDiff == 1 && colDiff == 0) || (rowDiff == 0 && colDiff == 1);
        return isOneSpace;
    }
} 