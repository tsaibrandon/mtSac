public class ScanTool {

    public char topRoom;
    public char rightRoom;
    public char bottomRoom;
    public char leftRoom;
    public char weaponRoom;
    
    public char getTopRoom() {
        return topRoom;
    }

    public void setTopRoom(char topRoom) {
        this.topRoom = topRoom;
    }

    public char getRightRoom() {
        return rightRoom;
    }

    public void setRightRoom(char rightRoom) {
        this.rightRoom = rightRoom;
    }

    public char getBottomRoom() {
        return bottomRoom;
    }

    public void setBottomRoom(char bottomRoom) {
        this.bottomRoom = bottomRoom;
    }

    public char getLeftRoom() {
        return leftRoom;
    }

    public void setLeftRoom(char leftRoom) {
        this.leftRoom = leftRoom;
    }

    public char getWeaponRoom() {
        return weaponRoom;
    }

    public void setWeaponRoom(char weaponRoom) {
        this.weaponRoom = weaponRoom;
    }

    public void scanRooms() {
        scanTop();
        scanRight();
        scanBottom();
        scanLeft();
        scanForWeapon();
    }

    private char scanTop() {
        
    }
    
    private char scanRight() {}
    
    private char scanBottom() {}
    
    private char scanLeft() {}
    
    private char scanWeapon() {}
}
