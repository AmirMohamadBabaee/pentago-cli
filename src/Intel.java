import java.util.ArrayList;
import java.util.List;

/**
 * Intel
 *
 * This class implement Intelligence interface and
 * implement method to win bot in every game
 *
 * @author Amir01
 * @version v2.0 (2 Apr 2020)
 */
public class Intel implements Intelligence{

    // Fields

    // map of priority of rotation
    private List<Table> rotatePriority;
    // object of Table class
    private Table table;
    // a blue print of map
    private int [][] blueMap;
    // priority array
    private int[][] priority = {
            {4 , 3, 2, 2, 3, 4},
            {3 , 6, 3, 3, 6, 3},
            {2 , 4, 3, 3, 4, 2},
            {2 , 4, 3, 3, 4, 2},
            {3 , 6, 3, 3, 6, 3},
            {4 , 3, 2, 2, 3, 4}
    };


    // Constructor

    // TODO: add javadoc for this default constructor
    public Intel(Table table) {

        this.rotatePriority = new ArrayList<>();
        this.table = table;
        this.blueMap = new int[6][6];

    }


    // Methods


    @Override
    public int[] findBestPos(Table table) {
        return new int[0];
    }


    /**
     * this method add a zero to a specific position
     * to show this position is full and it's useless
     *
     * @param x x position of cell
     * @param y y position of cell
     */
    private void zeroAdd(int x, int y) {

        try{

            priority[x][y] = 0;

        } catch(Exception e) {
            e.printStackTrace();
        }

    }


    // Todo: add javadoc
    public boolean checkDirect(int color, int delX, int delY) {

        int [][] map = this.table.getMap();

        for(int i=0; i<6 ; i++) {
            for(int j=0 ; j<6 ; j++) {

                int x = i;
                int y = j;
                int counter = 0;

                try {

                    do {

                        if(map[x][y] == color) {

                            counter++;

                        } else if(map[x][y] == 0) {

                            if(color == 1) {

                                if(counter == 5) {

                                    return true;

                                } else if(counter == 4) {

                                    blueMap[x+delX][y+delY] = -4;

                                } else if(counter == 3) {

                                    blueMap[x+delX][y+delY] = -3;

                                } else {

                                    counter = 0;

                                }

                            } else if (color == 2) {

                                if(counter == 5) {

                                    return false;

                                } else if(counter == 4) {

                                    blueMap[x+delX][y+delY] = 4;

                                } else if(counter == 3) {

                                    blueMap[x+delX][y+delY] = 3;

                                } else {

                                    counter = 0;

                                }

                            }

                        }

                        x += delX;
                        y += delY;

                    } while((x>=0 && x<6) && (y>=0 && y<6));

                } catch(Exception e) {
                    e.printStackTrace();
                    return true;
                }

            }

        }
        return true;
    }


    private void checkRotation(int blocknumber, int rotateType) {

        Table fakeTable = this.table.getClone();

        fakeTable.rotateBlock(blocknumber, rotateType);

        this.rotatePriority.add(fakeTable);

    }



    public void check() {

        checkRotation(0, 0);
        checkRotation(0, 1);
        checkRotation(1, 0);
        checkRotation(1, 1);
        checkRotation(2, 0);
        checkRotation(2, 1);
        checkRotation(3, 0);
        checkRotation(3, 1);

    }

}
