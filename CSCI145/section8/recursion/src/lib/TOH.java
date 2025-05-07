package lib;

public class TOH {
    public static void moveStack(int diskQty, char srcPeg, char dstPeg, char tmpPeg) {
        if(diskQty == 1) {
            moveDisk(diskQty, srcPeg, dstPeg);
            return; 
        }

        moveStack(diskQty - 1, srcPeg, tmpPeg, dstPeg);
        moveDisk(diskQty, srcPeg, dstPeg);
        moveStack(diskQty - 1, srcPeg, tmpPeg, srcPeg);
    }

    private static void moveDisk(int disc, char srcPeg, char dstPeg) {
        System.out.printf("Move disk %d from peg %c to peg %c%n", disc, srcPeg, dstPeg);
    }
}
