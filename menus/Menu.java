package menus;
import java.util.Scanner;

public class Menu {
    public static void mostrarMenu(){
        System.out.println("Elija el tipo de grafo que desee crear");
        System.out.println("1   --- Grafo no dirigido");
        System.out.println("2   --- Grafo Dirigido");
        System.out.println("3   --- Salir");
    }

    static boolean mostrar_Advertencia(Scanner sc){
        System.out.println("Al salir de este menu, tu grafo será destruido, ¿desesas continuar?");
        System.out.println("[S/N]");
        String respuesta = sc.nextLine();
        if(respuesta.equals("S") || respuesta.equals("s")) return true;
        else return false;
    }

    public static void menu(Scanner sc){
        int opcion; 
        System.out.println("Bienvenido al gestor de grafos");
        do{
            Menu.mostrarMenu();
            opcion = Integer.parseInt(sc.nextLine());
            System.out.print("\033[H\033[2J");
            System.out.flush();

            switch (opcion) {
                case 1 -> {
                    MenuGrafos.menuGrafo(sc);
                }
                case 2 -> {
                    System.out.println("ingresa la cantidad de nodos");
                    MenuGrafos.menuGrafoDir(sc, Integer.parseInt(sc.nextLine()));
                }
                case 3 -> System.out.println("Saliendo...");
            }
        }while(opcion != 3);
    }
}
