import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

// Clase principal para gestionar el menú
public class Main {
    private static ArrayList<Event> events = new ArrayList<>(); // Lista de eventos

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Para leer la entrada del usuario
        int option;

        // Bucle para mostrar el menú hasta que el usuario decida salir
        do {
            System.out.println("Bienvenido a Event Planner. Seleccione una opción:");
            System.out.println("[1] Añadir evento");
            System.out.println("[2] Listar eventos");
            System.out.println("[3] Salir");

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                option = -1; // Si el usuario introduce algo no válido
            }

            switch (option) {
                case 1 -> addEvent(scanner); // Añadir evento
                case 2 -> listEvents(); // Listar eventos
                case 3 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (option != 3);

        scanner.close(); // Cerrar el Scanner al final
    }

    // Método para añadir un nuevo evento
    private static void addEvent(Scanner scanner) {
        System.out.print("Ingrese el título del evento: ");
        String title = scanner.nextLine();
        System.out.print("Ingrese la fecha (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        System.out.print("Ingrese la prioridad (HIGH, MEDIUM, LOW): ");
        Event.Priority priority = Event.Priority.valueOf(scanner.nextLine().toUpperCase());

        Event event = new Event(title, date, priority);
        events.add(event); // Añadir el evento a la lista
        System.out.println("Evento añadido exitosamente.");
    }

    // Método para listar todos los eventos
    private static void listEvents() {
        if (events.isEmpty()) {
            System.out.println("No hay eventos registrados.");
        } else {
            events.forEach(System.out::println); // Imprimir cada evento
        }
    }
}
