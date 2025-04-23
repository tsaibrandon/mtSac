public class User2DPos {
    public int userRow;
    public int userCol;

    public User2DPos(int user1DPos, int colQty) {
        userRow = user1DPos / colQty;
        userCol = user1DPos % colQty;    
    }
}