package view;

public class Main {
    public static void main(String[] args) {
        Menu myMenu = new Menu();
        myMenu.mainMenu();
        OutputDisplay.displayMineField(myMenu.getMyMineField().getArray());
    }
}
