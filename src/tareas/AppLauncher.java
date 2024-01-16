package tareas;

import java.util.Scanner;
import tareas.GestorTareas;

public class AppLauncher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorTareas gestor = new GestorTareas();

        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Visualizar tareas de un usuario");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el ID del usuario: ");
                    int usuarioId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese la descripción de la tarea: ");
                    String descripcion = scanner.nextLine();
                    gestor.agregarTarea(usuarioId, descripcion);
                    break;
                case 2:
                    System.out.print("Ingrese el ID del usuario: ");
                    int usuarioIdConsulta = scanner.nextInt();
                    gestor.obtenerTareasUsuario(usuarioIdConsulta);
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}