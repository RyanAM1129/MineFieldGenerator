package view;

public class Main {
    public static void main(String[] args) {
        Menu theMenu = new Menu();
        theMenu.mainMenu();
        OutputDisplay.displayMineField(theMenu.getMyMineField().getArray());
    }
}
