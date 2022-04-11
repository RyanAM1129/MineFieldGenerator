package model;

import java.util.Arrays;
import java.util.Random;

/**
 * Creates minefields for the MineSweeper program.
 *
 * @author Ryan MacLeod
 * @version 1.0
 */
public class MineField {
    /**
     * The number of rows.
     */
    private final int myN;
    /**
     * The number of columns.
     */
    private final int myM;
    /**
     * The percentage of mines in the minefield.
     */
    private final double myScalar;
    /**
     * 2-Dimensional character array representing a minefield.
     */
    private final char[][] myMineField;

    /**
     * Creates a generator using default scalar and a given
     * number of rows and columns.
     *
     * @param theN the number of rows.
     * @param theM the number of columns.
     */
    public MineField(final int theN, final int theM) {
        myN = theN;
        myM = theM;
        myScalar = 0.10;   //Default Percentage
        myMineField = new char[myN][myM];
        buildField();
        addMines();
    }

    /**
     * Creates a generator using given scalar, number of rows, and
     * number of columns.
     *
     * @param theN the number of rows.
     * @param theM the number of columns.
     * @param theScalar the percent of mines as decimal.
     */
    public MineField(final int theN, final int theM, final double theScalar) {
        myN = theN;
        myM = theM;
        myScalar = theScalar;   //Default Percentage
        myMineField = new char[myN][myM];
        buildField();
        addMines();
    }

    /**
     * Fills myMineField with all '.' characters.
     */
    private void buildField() {
        for (int i = 0; i < myN; i++) {
            Arrays.fill(myMineField[i], '.');
        }
    }

    /**
     * Makes a percentage of myMineField '*' characters.
     * It determines the percentage from myScalar.
     */
    private void addMines() {
        Random theRandomInt = new Random();
        final int theArea = myN * myM;
        final int thePercent = (int) Math.round(theArea * myScalar);
        int theRowIndex;
        int theColumnIndex;

        for (int i = 0; i < thePercent; i++) {
            theRowIndex = theRandomInt.nextInt(myN);
            theColumnIndex = theRandomInt.nextInt(myM);
            while (myMineField[theRowIndex][theColumnIndex] == '*') {
                theRowIndex = theRandomInt.nextInt(myN);
                theColumnIndex = theRandomInt.nextInt(myM);
            }
            myMineField[theRowIndex][theColumnIndex] = '*';
        }
    }

    public char[][] getArray() {
        return myMineField;
    }
}
