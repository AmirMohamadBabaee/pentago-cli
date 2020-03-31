import java.util.ArrayList;
import java.util.List;

/**
 * Table
 *
 * This class collect four block and use them
 * together. also draw table method is in this
 * class
 *
 * @author Amir01
 * @version v1.0 (30 Mar 2020)
 */
public class Table {

    // Fields

    // List of block in this table
    private List<Block> block;
    // whole table of this game
    private int[][] map;
    // counter of marble method
    static int counter = 0;


    // Constructor

    // TODO: add java doc for this constructor
    public Table() {

        block = new ArrayList<>();
        block.add(new Block());
        block.add(new Block());
        block.add(new Block());
        block.add(new Block());
        this.map = new int[6][6];

    }


    // Setter & Getter

    /**
     * getter of map 2D array is 6*6
     *
     * @return 2D array called map
     */
    public int[][] getMap() {
        return map;
    }

    // Method

    /**
     * this method combine 4 block in this table map
     */
    private void makeMap() {

        for(int i=0 ; i<6 ; i++) {
            for(int j=0 ; j<6 ; j++) {

                if(i<3) {

                    if(j<3) {
                        this.map[i][j] = block.get(0).getBlock()[i][j];
                    } else {
                        this.map[i][j] = block.get(1).getBlock()[i][j-3];
                    }

                } else {

                    if(j<3) {
                        this.map[i][j] = block.get(2).getBlock()[i-3][j];
                    } else {
                        this.map[i][j] = block.get(3).getBlock()[i-3][j-3];
                    }

                }
            }
        }
    }


    /**
     * this method take x and y position in map array and
     * convert them to x and y of specific block and call
     * that block itself
     *
     * @param color color of marble
     * @param mapX x position in map 2D array
     * @param mapY y position in map 2D array
     */
    public void indexConverter(int color ,int mapX, int mapY) {

        if(mapX >= 0 && mapX < 6 && mapY >= 0 && mapY < 6) {

            if(mapX < 3) {

                if(mapY < 3) { // first block (1)

                    block.get(0).addMarble(color, mapX, mapY);

                } else { // second block (2)

                    block.get(1).addMarble(color, mapX, mapY-3);

                }

            } else {

                if(mapY < 3) { // third block (3)

                    block.get(2).addMarble(color, mapX-3, mapY);

                } else { // forth block (4)

                    block.get(3).addMarble(color, mapX-3, mapY-3);

                }

            }
            // call make map to refresh map 2D array
            makeMap();
        } else {
            System.out.println("entered index is not correct!!!");
        }

    }


    /**
     * this method take block number and kind of rotate
     * then rotate that block.
     *
     * @param blockNumber number of block in list of Block object
     * @param type clockwise = 0 or counter clockwise = 1
     */
    public void rotateBlock(int blockNumber, int type) {

        try{

            block.get(blockNumber).rotateBlock(type);
            makeMap();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // TODO: check this method is useful or not (refreshMap)
    public void refreshMap() {

        makeMap();

    }


    public void draw() {

        String sol = "\u1690";

        String horLine = "\u2500";
        String verLine = "\u2502";

        String up_left = "\u256D";
        String up_right = "\u256E";
        String down_left = "\u2570";
        String down_right = "\u256F";

        String horMain = "\u2550";
        String verMain = "\u2551";
        String left = "\u255E";
        String right = "\u2561";
        String up = "\u2565";
        String down = "\u2568";
        String cross = "\u256C";

        System.out.print(up_left+horLine+horLine+horLine+horLine+sol+horLine+horLine+horLine+horLine+up_right+" ");
        System.out.println(up+" "+up_left+horLine+horLine+horLine+horLine+sol+horLine+horLine+horLine+horLine+up_right);
        System.out.print(verLine+" "+marble()+" "+marble()+" "+marble()+" "+verLine+" ");
        System.out.println(verMain+" "+verLine+" "+marble()+" "+marble()+" "+marble()+" "+verLine);
        System.out.print(verLine+" "+marble()+" "+marble()+" "+marble()+" "+verLine+" ");
        System.out.println(verMain+" "+verLine+" "+marble()+" "+marble()+" "+marble()+" "+verLine);
        System.out.print(verLine+" "+marble()+" "+marble()+" "+marble()+" "+verLine+" ");
        System.out.println(verMain+" "+verLine+" "+marble()+" "+marble()+" "+marble()+" "+verLine);
        System.out.print(down_left+horLine+horLine+horLine+horLine+sol+horLine+horLine+horLine+horLine+down_right+" ");
        System.out.println(verMain+" "+down_left+horLine+horLine+horLine+horLine+sol+horLine+horLine+horLine+horLine+down_right);

        System.out.print(left+horMain+horMain+horMain+horMain+horMain+sol+horMain+horMain+horMain+horMain+horMain+cross);
        System.out.println(horMain+horMain+horMain+horMain+horMain+sol+horMain+horMain+horMain+horMain+horMain+right);

        System.out.print(up_left+horLine+horLine+horLine+horLine+sol+horLine+horLine+horLine+horLine+up_right+" ");
        System.out.println(verMain+" "+up_left+horLine+horLine+horLine+horLine+sol+horLine+horLine+horLine+horLine+up_right);
        System.out.print(verLine+" "+marble()+" "+marble()+" "+marble()+" "+verLine+" ");
        System.out.println(verMain+" "+verLine+" "+marble()+" "+marble()+" "+marble()+" "+verLine);
        System.out.print(verLine+" "+marble()+" "+marble()+" "+marble()+" "+verLine+" ");
        System.out.println(verMain+" "+verLine+" "+marble()+" "+marble()+" "+marble()+" "+verLine);
        System.out.print(verLine+" "+marble()+" "+marble()+" "+marble()+" "+verLine+" ");
        System.out.println(verMain+" "+verLine+" "+marble()+" "+marble()+" "+marble()+" "+verLine);
        System.out.print(down_left+horLine+horLine+horLine+horLine+sol+horLine+horLine+horLine+horLine+down_right+" ");
        System.out.println(down+" "+down_left+horLine+horLine+horLine+horLine+sol+horLine+horLine+horLine+horLine+down_right);

    }


    private String marble() {

        String res = "";
        String gen = "\u25CC";
        String marble1 = "\u25CF";
        String marble2 = "\u25CB";

        if(counter < 36) {

            int x = counter/6;
            int y = counter%6;

            if( getMap()[x][y] == 0) {

                counter++;
                return gen;

            } else if(getMap()[x][y] == 1) {

                counter++;
                return marble1;

            } else if(getMap()[x][y] == 2) {

                counter++;
                return marble2;

            }

        } else {

            counter %= 36;
            res = marble();

        }
        return res;
    }
}
