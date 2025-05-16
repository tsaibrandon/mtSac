package components;

import java.util.List;

public class ATeamGuard extends Guard {
    private boolean canMoveRandomly;
    private int targetRow; // Track operator's last position
    private int targetCol;
    private boolean isTracking; // Whether we're waiting to move to operator's position

    public ATeamGuard(int row, int col) {
        super(row, col, GameConstants.ATEAM_MOVE_PROBABILITY, GameConstants.ATEAM_SYMBOL);
        this.canMoveRandomly = true;
        this.isTracking = false;
        this.targetRow = -1;
        this.targetCol = -1;
    }

    @Override
    public void move(List<Entity>[][] board) {
        // First check if operator has moved into our room
        boolean operatorInRoom = false;
        for (Entity entity : board[row][col]) {
            if (entity instanceof Operator) {
                operatorInRoom = true;
                break;
            }
        }
        
        // If operator is in our room, don't move - they are captured
        if (operatorInRoom) {
            return;
        }

        // ALWAYS check for operator in adjacent rooms first
        Entity operator = findAdjacentOperator(board);
        
        if (operator != null) {
            // Operator detected in adjacent room
            int operatorRow = operator.getRow();
            int operatorCol = operator.getCol();
            
            // Store the operator's current position and disable random movement
            targetRow = operatorRow;
            targetCol = operatorCol;
            canMoveRandomly = false;
            isTracking = true;
            
            // Check if we can move to the operator's position
            boolean roomEmpty = true;
            for (Entity entity : board[operatorRow][operatorCol]) {
                if (entity instanceof Operator) {
                    roomEmpty = false;
                    break;
                }
            }
            
            if (roomEmpty && isOneSpaceMove(operatorRow, operatorCol)) {
                // Move to operator's position
                setPosition(operatorRow, operatorCol);
                
                // After moving, check adjacent rooms again
                operator = findAdjacentOperator(board);
                if (operator != null) {
                    // Operator is still nearby, update tracking to their new position
                    targetRow = operator.getRow();
                    targetCol = operator.getCol();
                    // Keep tracking enabled and random movement disabled
                    isTracking = true;
                    canMoveRandomly = false;
                }
            }
        } else if (isTracking) {
            // We're tracking but operator moved - try to move to their last position
            if (isOneSpaceMove(targetRow, targetCol)) {
                boolean roomEmpty = true;
                for (Entity entity : board[targetRow][targetCol]) {
                    if (entity instanceof Operator) {
                        roomEmpty = false;
                        break;
                    }
                }
                
                if (roomEmpty) {
                    setPosition(targetRow, targetCol);
                    
                    // After moving to operator's previous position, check adjacent rooms
                    operator = findAdjacentOperator(board);
                    if (operator != null) {
                        // Operator is still nearby, update tracking to their new position
                        targetRow = operator.getRow();
                        targetCol = operator.getCol();
                        // Keep tracking enabled and random movement disabled
                        isTracking = true;
                        canMoveRandomly = false;
                    } else {
                        // No operator nearby, reset tracking state and re-enable random movement
                        isTracking = false;
                        canMoveRandomly = true;
                        targetRow = -1;
                        targetCol = -1;
                    }
                }
            }
        } else if (shouldMove() && canMoveRandomly) {
            // No operator detected and random movement is enabled
            moveRandomly(board);
            // After moving randomly, immediately check adjacent rooms again
            operator = findAdjacentOperator(board);
            if (operator != null) {
                // Start tracking immediately when operator is detected
                targetRow = operator.getRow();
                targetCol = operator.getCol();
                canMoveRandomly = false;
                isTracking = true;
            }
        }
    }

    private Entity findAdjacentOperator(List<Entity>[][] board) {
        // Check rooms in order: Up, Right, Down, Left
        int[][] directions = {
            {-1, 0},  // Up
            {0, 1},   // Right
            {1, 0},   // Down
            {0, -1}   // Left
        };
        
        for (int[] dir : directions) {
            int checkRow = row + dir[0];
            int checkCol = col + dir[1];
            
            if (isValidPosition(checkRow, checkCol)) {
                for (Entity entity : board[checkRow][checkCol]) {
                    if (entity instanceof Operator) {
                        return entity;
                    }
                }
            }
        }
        return null;
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

    @Override
    protected boolean isOneSpaceMove(int newRow, int newCol) {
        int rowDiff = Math.abs(newRow - row);
        int colDiff = Math.abs(newCol - col);
        boolean isOneSpace = (rowDiff == 1 && colDiff == 0) || (rowDiff == 0 && colDiff == 1);
        return isOneSpace;
    }
} 