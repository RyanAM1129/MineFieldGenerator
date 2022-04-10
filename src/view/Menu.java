package view;

import model.MineField;

import java.util.Scanner;

public class Menu {
    /**
     * The number of rows.
     */
    private int myN;
    /**
     * The number of columns.
     */
    private int myM;
    /**
     * The percent of mines.
     */
    private int myPercent;
    /**
     * Flag used to stop program.
     *
     * False when you want to stop, true when you want to continue.
     */
    private boolean myFlag;
    /**
     * Generator used to create minefields.
     */
    private MineField myMineField;

    void mainMenu() {
        Scanner myKeyboard = new Scanner(System.in);
        String myTempString;
        myFlag = false;
        while (!myFlag) {
            System.out.println("Please enter how many rows you would like: ");
            myTempString = myKeyboard.nextLine();
            if (isDigit(myTempString)) {
                myN = Integer.parseInt(myTempString);
                myFlag = true;
            }
        }
        myFlag = false;
        while(!myFlag) {
            System.out.println("Please enter how many columns you would like: ");
            myTempString = myKeyboard.nextLine();
            if(isDigit(myTempString)) {
                myM = Integer.parseInt(myTempString);
                myFlag = true;
            }
        }
        System.out.println("Enter the percent of mines you would like " +
                "(Leave blank for default) :");
        myTempString = myKeyboard.nextLine();
        if(isDigit(myTempString)) {
            myPercent = Integer.parseInt(myTempString);
            if(myPercent < 0 || myPercent > 100) {
                myPercent = -1;
            }
        } else {
            myPercent = -1;
        }
        if(myPercent != -1) {
            myMineField = new MineField(myN, myM, myPercent * 0.01);
        } else {
            myMineField = new MineField(myN, myM);
        }
    }
     /**
      * Checks if given string is an integer.
      *
      * @param theString the string to be evaluated.
      * @return true if theString is an integer, false if not.
      */
    private boolean isDigit(final String theString) {
        try {
            Integer.parseInt(theString);
            return true;
        } catch (NumberFormatException theException) {
            return false;
        }
    }
     /**
      * Returns the minefield.
      *
      * @return myMineField.
      */
    public MineField getMyMineField() {
        return myMineField;
    }
}
