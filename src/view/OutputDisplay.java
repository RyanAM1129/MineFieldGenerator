package view;

public class OutputDisplay {
    public static void displayMineField(final char[][] theMineField) {
        System.out.println(theMineField.length + " " + theMineField[0].length);
        for (int i = 0; i < theMineField.length; i++) {
            System.out.println(String.copyValueOf(theMineField[i]));
        }
    }
}
