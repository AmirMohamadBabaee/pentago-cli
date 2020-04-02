import java.util.Scanner;

/**
 * Main
 *
 * This class manage input of players and can use all of the classes
 *
 * @author Amir01
 * @version v1.0 (31 Mar 2020)
 */
public class Main {

    // Fields

    // object of table class
    private static Table table;
    // object of condition class
    private static Condition condition;
    // object of scanner class for input from stdin
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        table = new Table();
        condition = new Condition(table);

        int counter = 0;

        do {

            table.draw();
            if(counter%2 == 0) { // player 1

                try{
                    System.out.println("please enter index of expected cell");
                    System.out.print("Player 1 >>> ");

                    if(!table.indexConverter(1, scan.nextInt(), scan.nextInt())){

                        continue;

                    }

                    table.draw();

                    if(condition.isEnd(1)) {

                        System.out.println("Player 1 won!!!");

                    } else {

                        if(table.isIgnoreValid()) {

                            System.out.println("Skipping rotation!!!");

                        } else {

                            System.out.print("Please choose your expected block >>> ");
                            int block = scan.nextInt()-1;
                            System.out.println("Please determine type of rotating (0 for clockwise & 1 for counter clockwise)");
                            System.out.print("Enter Here >>> ");
                            int type = scan.nextInt();

                            table.rotateBlock(block, type);

                            condition.checkGame();

                        }

                    }
                } catch(Exception e) {
                    e.printStackTrace();
                }

            } else if(counter%2 == 1) { // player 2

                try{
                    System.out.println("please enter index of expected cell");
                    System.out.print("Player 2 >>> ");

                    if(!table.indexConverter(2, scan.nextInt(), scan.nextInt())) {

                        continue;

                    }

                    table.draw();

                    if(condition.isEnd(2)) {

                        System.out.println("Player 2 won!!!");

                    } else {

                        if(table.isIgnoreValid()) {

                            System.out.println("Skipping rotation!!!");

                        } else {

                            System.out.print("Please choose your expected block >>> ");
                            int block = scan.nextInt()-1;
                            System.out.println("Please determine type of rotating (0 for clockwise & 1 for counter clockwise)");
                            System.out.print("Enter Here >>> ");
                            int type = scan.nextInt();

                            table.rotateBlock(block, type);

                            condition.checkGame();

                        }

                    }
                } catch(Exception e) {
                    e.printStackTrace();
                }

            }
            counter++;

        } while(!condition.isEndGame());

    }
}
