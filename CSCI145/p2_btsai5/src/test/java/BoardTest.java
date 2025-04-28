import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setUpBoard() {
        board = new Board();
    }

    @Test
    void createRooms_50EmptyRooms() {
        board.createRooms();

        RoomType[] rooms = board.getRooms();
        int numEmpty = 0;
        
        for (int i = 0; i < rooms.length; i++) {
            if(rooms[i] == RoomType.EMPTY) {
                numEmpty++;
            }
        }

        assertEquals(50, numEmpty);
    }

    @Test
    void createRooms_12RadiationRooms() {
        board.createRooms();

        RoomType[] rooms = board.getRooms();
        int numRadiation = 0;
        
        for (int i = 0; i < rooms.length; i++) {
            if(rooms[i] == RoomType.RADIATION) {
                numRadiation++;
            }
        }

        assertEquals(12, numRadiation);
    }

    @Test
    void createRooms_1VentRooms() {
        board.createRooms();

        RoomType[] rooms = board.getRooms();
        int numVent = 0;
        
        for (int i = 0; i < rooms.length; i++) {
            if(rooms[i] == RoomType.VENT) {
                numVent++;
            }
        }

        assertEquals(1, numVent);
    }

    @Test
    void createRooms_1WeaponRooms() {
        board.createRooms();

        RoomType[] rooms = board.getRooms();
        int numWeapon = 0;
        
        for (int i = 0; i < rooms.length; i++) {
            if(rooms[i] == RoomType.WEAPON) {
                numWeapon++;
            }
        }

        assertEquals(1, numWeapon);
    }

    @Test
    void createBoard_CorrectDimensions() {
        board.createRooms();
        board.createBoard();

        RoomType[][] gameBoard = board.getBoard();

        assertEquals(8, gameBoard.length);
        assertEquals(8, gameBoard[0].length);
    }

    @Test
    void createBoard_CorrectRooms() {
        board.createRooms();
        board.createBoard();

        RoomType[] rooms = board.getRooms();
        RoomType[][] gameBoard = board.getBoard();

        for (int i = 0; i < rooms.length; i++) {
            int row = i / 8;
            int col = i % 8;

            assertEquals(rooms[i], gameBoard[row][col]);
        }
    }

    @Test
    void createBoard_NoSpecialRoomsAroundStart() {
        board.createRooms();
        board.createBoard();

        RoomType[][] gameBoard = board.getBoard();

        assertEquals(RoomType.EMPTY, gameBoard[0][0]);
        assertEquals(RoomType.EMPTY, gameBoard[0][1]);
        assertEquals(RoomType.EMPTY, gameBoard[1][0]);
    }

}