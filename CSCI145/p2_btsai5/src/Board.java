public class Board {
    
    private int final ROWS = 8;
    private int final COLS = 8;
    
    private int[] rooms = new int[64];
    private int[][] board = new int[][];

    public void createRooms() {
        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = RoomType.EMPTY;
        }
    }

    private void placeRadiation() {

    }

    private void placeVent() {

    }

    private void placeWeapon() {

    }

    private void createBoard() {
        for (int i = 0; i < rooms.length; i++) {
            board[i / COLS][i % COLS] = rooms[i];
        }
    }

    private boolean isValidRoom() [
        if(RoomType == EMPTY) && !isAdjacentToStart(conversion2D[]) {
            return true;
        } else {
            return false;
        }
    ]

    private boolean isAdjacentToStart(int[] array) {
        if(array[0] == 0 && array[1] == 1) {
            return true;
        }else if(array[0] == 1 && array[0] == 0) {
            return true;
        } else {
            return false;
        }
    }

    private void conversion2D(int index) {
        int[] coordinates = new int[]
        
        coordinates[0] = index / COLS;
        coordinates[1]= index % COLS;
    }

    

    public void updateBoard() {}


    

}
