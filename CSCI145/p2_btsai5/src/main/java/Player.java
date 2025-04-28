public class Player {

    private final char PLAYER_ICON = 'O';
    private final int START_POS = 0;
    
    private char icon;
    private String status;
    private String bag;
    private int row;
    private int column;

    public Player() {
        this.icon = PLAYER_ICON;
        this.row = START_POS;
        this.column = START_POS;
        this.status = "Alive";
        this.bag = "Empty";
    }

    public char getIcon() {
        return icon;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBag() {
        return bag;
    }

    public void setBag(String bag) {
        this.bag = bag;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void updatePosition(int newRow, int newColumn) {
        this.row = newRow;
        this.column = newColumn;
    }
}
