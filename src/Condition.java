/**
 * Condition
 *
 * This class have behaviors to check end of game
 * and can check a marble position is valid or not
 *
 * @author Amir01
 * @version v1.0 (31 Mar 2020)
 */
public class Condition {

    // Fields

    // objects of Table class
    private Table table;


    // Constructor

    // TODO: add a javadoc for this constructor
    public Condition(Table table) {

        this.table = table;

    }


    // Method


    /**
     * This method check end of game and its for condition
     * of while in Main class
     *
     * @return true if game ended and false if game is running
     */
    public boolean isEndGame() {

        return isEnd(1) || isEnd(2);

    }


    /**
     * This method check there is any 5 marble in a row or not
     *
     * @param color color of marble
     * @return true is there is 5 marble in a row and false if
     * there is not any 5 marble in a row
     */
    public boolean isEnd(int color) {

        boolean b1 = checkDirect(color, 1, 0);// Right
        boolean b2 = checkDirect(color, 1, 1); // Down-Right
        boolean b3 = checkDirect(color, 0, 1); // Down
        boolean b4 = checkDirect(color, -1, 1); // Down-Left
        boolean b5 = checkDirect(color, -1, 0); // Left
        boolean b6 = checkDirect(color, -1, -1); // Up-Left
        boolean b7 = checkDirect(color, 0, -1); // Up
        boolean b8 = checkDirect(color, 1, -1); // Up-Right

        return b1 || b2 || b3 || b4 || b5 || b6 || b7 || b8;
    }


    private boolean checkDirect(int color, int delX, int delY) {

        // map of this game
        int [][] map = table.getMap();

        for(int i=0; i<6 ; i++) {
            for(int j=0 ; j<6 ; j++) {

                int x = i;
                int y = j;
                int counter = 0;

                try {

                    do {

                        if(map[x][y] == color) {

                            counter++;

                        } else {

                            if(counter == 5) {

                                return true;

                            } else {

                                counter = 0;

                            }

                        }

                        x += delX;
                        y += delY;

                    } while((x>=0 && x<6) && (y>=0 && y<6));

                } catch(Exception e) {
                    e.printStackTrace();
                    return false;
                }

            }

        }
        return false;
    }



    public void checkGame() {

        if(isEnd(1) && isEnd(2)) {

            table.draw();
            System.out.println("It's Draw!!!");

        } else if(isEnd(1) && !isEnd(2)) {

            table.draw();
            System.out.println("Player 1 won!!!");

        } else if(!isEnd(1) && isEnd(2)) {

            table.draw();
            System.out.println("Player 2 won!!!");

        }

    }
}
