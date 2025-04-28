public class ScanTool {
    private static final int ROWS = 8;
    private static final int COLS = 8;
    
    private Player player;
    private Board board;
    private BoardState boardState;

    public ScanTool(Player player, Board board, BoardState boardState) {
        this.player = player;
        this.board = board;
        this.boardState = boardState;
    }

    public void scanRooms() {
        // Clear current room's detections first
        boardState.clearDetections(player.getRow(), player.getColumn());
        
        scanTop();
        scanRight();
        scanBottom();
        scanLeft();
    }

    private boolean isValidRoom(int row, int col) {
        return row >= 0 && row < ROWS && col >= 0 && col < COLS;
    }
    
    private void scanTop() {
        int row = player.getRow() - 1;
        int col = player.getColumn();
        
        if (isValidRoom(row, col)) {
            RoomType roomType = board.getBoard()[row][col];
            if (roomType == RoomType.RADIATION) {
                boardState.addDetection(player.getRow(), player.getColumn(), ScanDetect.R);
            } else if (roomType == RoomType.VENT) {
                boardState.addDetection(player.getRow(), player.getColumn(), ScanDetect.V);
            } else if (roomType == RoomType.WEAPON) {
                boardState.addDetection(player.getRow(), player.getColumn(), ScanDetect.W);
            }
        }
    }

    private void scanRight() {
        int row = player.getRow();
        int col = player.getColumn() + 1;
        
        if (isValidRoom(row, col)) {
            RoomType roomType = board.getBoard()[row][col];
            if (roomType == RoomType.RADIATION) {
                boardState.addDetection(player.getRow(), player.getColumn(), ScanDetect.R);
            } else if (roomType == RoomType.VENT) {
                boardState.addDetection(player.getRow(), player.getColumn(), ScanDetect.V);
            } else if (roomType == RoomType.WEAPON) {
                boardState.addDetection(player.getRow(), player.getColumn(), ScanDetect.W);
            }
        }
    }

    private void scanBottom() {
        int row = player.getRow() + 1;
        int col = player.getColumn();
        
        if (isValidRoom(row, col)) {
            RoomType roomType = board.getBoard()[row][col];
            if (roomType == RoomType.RADIATION) {
                boardState.addDetection(player.getRow(), player.getColumn(), ScanDetect.R);
            } else if (roomType == RoomType.VENT) {
                boardState.addDetection(player.getRow(), player.getColumn(), ScanDetect.V);
            } else if (roomType == RoomType.WEAPON) {
                boardState.addDetection(player.getRow(), player.getColumn(), ScanDetect.W);
            }
        }
    }

    private void scanLeft() {
        int row = player.getRow();
        int col = player.getColumn() - 1;
        
        if (isValidRoom(row, col)) {
            RoomType roomType = board.getBoard()[row][col];
            if (roomType == RoomType.RADIATION) {
                boardState.addDetection(player.getRow(), player.getColumn(), ScanDetect.R);
            } else if (roomType == RoomType.VENT) {
                boardState.addDetection(player.getRow(), player.getColumn(), ScanDetect.V);
            } else if (roomType == RoomType.WEAPON) {
                boardState.addDetection(player.getRow(), player.getColumn(), ScanDetect.W);
            }
        }
    }
}
