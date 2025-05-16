package components;

import java.util.List;

public abstract class Entity {
    protected int row;
    protected int col;

    public Entity(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public abstract void move(List<Entity>[][] board);

    public abstract char getSymbol();
} 