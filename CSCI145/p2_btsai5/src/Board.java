public class Board {
    
    private static final int ROWS = 8;
    private static final int COLS = 8;
    
    private RoomType[] rooms = new RoomType[64];
    private RoomType[][] board = new RoomType[ROWS][COLS];

    public void createRooms() {
        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = RoomType.EMPTY;
        }
    }

    private void placeRadiation() {
        int radiationRooms = 0;
        int roomIndex = (int)(Math.random() * 64);

        while(true) {
            if(radiationRooms < 12) {
                if(rooms[roomIndex] == RoomType.EMPTY && !isAdjacentToStart(conversion2D(roomIndex))) {
                    rooms[roomIndex] = RoomType.RADIATION;
                    radiationRooms++;
                }
                roomIndex = (int)(Math.random() * 64);
            }else {
                break;
            }
        }
    }

    private void placeVent() {
        int ventRoom = 0;
        int roomIndex = (int)(Math.random() * 64);
        
        while (true) {
            if(ventRoom < 1) {
                if(rooms[roomIndex] == RoomType.EMPTY && !isAdjacentToStart(conversion2D(roomIndex))) {
                    rooms[roomIndex] = RoomType.VENT;
                    ventRoom++;
                }
                roomIndex = (int)(Math.random() * 64);
            }else {
                break;
            }
        }
    }

    private void placeWeapon() {
        int weaponRoom = 0;
        int roomIndex = (int)(Math.random() * 64);

        while(true) {
            if(weaponRoom < 1) {
                if(rooms[roomIndex] == RoomType.EMPTY && !isAdjacentToStart(conversion2D(roomIndex))) {
                    rooms[roomIndex] = RoomType.WEAPON;
                    weaponRoom++;
                }
                roomIndex = (int)(Math.random() * 64);
            }else {
                break;
            }
        }
    }

    private void createBoard() {
        for (int i = 0; i < rooms.length; i++) {
            board[i / COLS][i % COLS] = rooms[i];
        }
    }

    private boolean isValidRoom(int index) {
        if(rooms[index] == RoomType.EMPTY && !isAdjacentToStart(conversion2D(index))) {
            return true;
        }else {
            return false;
        }
    }

    private boolean isAdjacentToStart(int[] array) {
        if(array[0] == 0 && array[1] == 1) {
            return true;
        }else if(array[0] == 1 && array[1] == 0) {
            return true;
        }else {
            return false;
        }
    }

    private int[] conversion2D(int index) {
        int[] coordinates = new int[2];
        
        coordinates[0] = index / COLS;
        coordinates[1] = index % COLS;
        
        return coordinates;
    }

    

    public void updateBoard() {}


    

}
