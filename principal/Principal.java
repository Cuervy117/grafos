package principal;
import java.util.Scanner;
import menus.Menu;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu.menu(sc);
    }
}
