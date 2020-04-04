/**
 * Block
 *
 * This class define blocks of pentago game that can
 * rotate clockwise or counter clockwise
 * This class can accept at most 9 marble in 3*3 square
 *
 * @author Amir01
 * @version v1.0 (30 Mar 2020)
 */
public class Block implements Cloneable{

    // Fields

    // map of this block
    private int[][] block;


    // Constructor

    // TODO: add java doc for this constructor
    public Block() {

        this.block = new int[3][3];

    }


    // Setter & Getter


    /**
     * getter of block 2D Array
     *
     * @return 2D array of this block
     */
    public int[][] getBlock() {
        return block;
    }


    // Method


    /**
     * this method rotate block depend on integer input
     * number. if number be 0, block will rotate clockwise and
     * if number be 1, block will rotate counter clockwise.
     *
     * @param type this number determine kind of rotate
     */
    public void rotateBlock(int type) {

        int [][] fakeArray = new int[3][3];

        if(type == 0) {

            for (int i=0 ; i<3 ; i++) {
                for (int j=0 ; j<3 ; j++) {
                    fakeArray[i][j] = this.block[2-j][i];
                }
            }

        } else if (type == 1) {

            for (int i=0 ; i<3 ; i++) {
                for (int j=0 ; j<3 ; j++) {
                    fakeArray[i][j] = this.block[j][2-i];
                }
            }

        }

        this.block = fakeArray;
    }


    /**
     * This method check a cell is empty or not
     *
     * @param x x position of cell
     * @param y y position of cell
     * @return true if this cell be empty and false if
     * this cell be full
     */
    public boolean isEmpty(int x, int y) {

        if(this.block[x][y] == 0) {
            return true;
        }
        return false;
    }

    /**
     * This method full a cell with number of its color
     * color must be 1 or 2
     *
     * @param color color of marble that determine player
     * @param x x position of cell
     * @param y y position of cell
     * @return if all of things done, true else false
     */
    public boolean addMarble(int color, int x, int y) {

        if(isEmpty(x, y)) {

            this.getBlock()[x][y] = color;
            return true;

        } else {
            System.out.println("This cell is full!!!");
        }
        return false;

    }


    /**
     * This method check neutrality of this block
     *
     * @return true, if be neutral and false, if don't be neutral
     */
    private boolean isNeutral() {

        for (int[] ints : block) {
            for (int i : ints) {
                if(i != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * this method check is a block symmetrical or not
     *
     * @return if it is symmetrical, true else false
     */
    private boolean isSymmetrical() {

        int cornerValue = this.block[0][0];
        int middleValue = this.block[0][1];

        boolean condition1 = cornerValue == this.block[0][2];
        boolean condition2 = cornerValue == this.block[2][0];
        boolean condition3 = cornerValue == this.block[2][2];

        if(condition1 && condition2 && condition3) {

            condition1 = middleValue == this.block[1][0];
            condition2 = middleValue == this.block[1][2];
            condition3 = middleValue == this.block[2][1];

            if(condition1 && condition2 && condition3) {
                return true;
            }

        }

        return false;
    }

    /**
     * this method check can a block ignore
     * rotation or not
     *
     * @return if it can ignore, true else false
     */
    public boolean canIgnore() {

        if(isNeutral()) {

            return true;

        } else {

            if(isSymmetrical()) {
                return true;
            }

        }
        return false;
    }


    public Block getClone() throws CloneNotSupportedException{

        Block block = (Block)super.clone();

        int [][] blc = new int[3][3];
        for(int i=0 ; i<3 ; i++) {
            for(int j=0 ; j<3 ; j++) {
                blc[i][j] = this.block[i][j];
            }
        }

        block.block = blc;

        return block;

    }
}
