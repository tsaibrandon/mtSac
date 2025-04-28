public class ScanTool {
    private Board board;
    private BoardState boardState;
    private Player player;

    public ScanTool(Board board, BoardState boardState, Player player) {
        this.board = board;
        this.boardState = boardState;
        this.player = player;
    }

    public void scanRooms() {
        int row = player.getRow();
        int col = player.getColumn();
        String result = "";

        if (board.getBoard()[row][col] == RoomType.WEAPON) {
            result += "W";
        }

        if (scanTop(row, col)) {
            result += "R";
        }
        if (scanRight(row, col)) {
            if (!result.contains("R")) {
                result += "R";
            }
        }
        if (scanBottom(row, col)) {
            if (!result.contains("R")) {
                result += "R";
            }
        }
        if (scanLeft(row, col)) {
            if (!result.contains("R")) {
                result += "R";
            }
        }

        while (result.length() < 3) {
            result += " ";
        }

        boardState.updateScanResults(row, col, result);
    }
    
    private boolean scanTop(int row, int col) {
        if (isValidRoom(row - 1, col)) {
            RoomType room = board.getBoard()[row - 1][col];
            return room == RoomType.RADIATION || room == RoomType.VENT;
        }
        return false;
    }

    private boolean scanRight(int row, int col) {
        if (isValidRoom(row, col + 1)) {
            RoomType room = board.getBoard()[row][col + 1];
            return room == RoomType.RADIATION || room == RoomType.VENT;
        }
        return false;
    }

    private boolean scanBottom(int row, int col) {
        if (isValidRoom(row + 1, col)) {
            RoomType room = board.getBoard()[row + 1][col];
            return room == RoomType.RADIATION || room == RoomType.VENT;
        }
        return false;
    }

    private boolean scanLeft(int row, int col) {
        if (isValidRoom(row, col - 1)) {
            RoomType room = board.getBoard()[row][col - 1];
            return room == RoomType.RADIATION || room == RoomType.VENT;
        }
        return false;
    }

    private boolean isValidRoom(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }
}
