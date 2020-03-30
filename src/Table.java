import jdk.nashorn.internal.objects.annotations.Constructor;

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
    List<Block> block;
    // whole table of this game
    private int[][] map;


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
    public void makeMap() {

        for(int i=0 ; i<6 ; i++) {
            for(int j=0 ; j<6 ; j++) {

                if(i<3) {

                    if(j<3) {
                        this.map[i][j] = block.get(0).getBlock()[i][j];
                    } else {
                        this.map[i][j] = block.get(2).getBlock()[i][j-3];
                    }

                } else {

                    if(j<3) {
                        this.map[i][j] = block.get(3).getBlock()[i-3][j];
                    } else {
                        this.map[i][j] = block.get(4).getBlock()[i-3][j-3];
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
    private void indexConverter(int color ,int mapX, int mapY) {

        if(mapX >= 0 && mapX < 6 && mapY >= 0 && mapY < 6) {

            if(mapX < 3) {

                if(mapY < 3) { // first block (1)

                    block.get(1).addMarble(color, mapX, mapY);

                } else { // second block (2)

                    block.get(2).addMarble(color, mapX, mapY-3);

                }

            } else {

                if(mapY < 3) { // third block (3)

                    block.get(3).addMarble(color, mapX-3, mapY);

                } else { // forth block (4)

                    block.get(4).addMarble(color, mapX, mapY);

                }

            }

        } else {
            System.out.println("entered index is not correct!!!");
        }

    }


    
}
