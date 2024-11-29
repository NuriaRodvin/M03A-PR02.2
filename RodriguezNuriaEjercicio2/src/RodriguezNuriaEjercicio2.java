import java.util.InputMismatchException;
import java.util.Scanner;

public class RodriguezNuriaEjercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear un personaje de Juego de Tronos
        PersonajeJuegoTronos personaje = new PersonajeJuegoTronos("Jon Nieve", 25, "Stark");

        // Menú de opciones
        int opcion;
        do {
            try {
                System.out.println("MENU:");
                System.out.println("1. Cambiar estado del personaje");
                System.out.println("2. Mostrar información del personaje");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("¿Está vivo el personaje? (true/false): ");
                        boolean estado = scanner.nextBoolean();
                        personaje.cambiarEstado(estado);
                        break;
                    case 2:
                        System.out.println(personaje);
                        break;
                    case 0:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida. Inténtelo de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número entero válido.");
                scanner.nextLine(); // Limpiar el buffer del scanner
                opcion = -1; // Asignar un valor inválido para repetir el bucle
            }
        } while (opcion != 0);

        scanner.close();
    }

    // Clase PersonajeJuegoTronos
    static class PersonajeJuegoTronos {
        private String nombre;
        private int edad;
        private String casa;
        private boolean vivo;

        // Constructor
        public PersonajeJuegoTronos(String nombre, int edad, String casa) {
            this.nombre = nombre;
            this.edad = edad;
            this.casa = casa;
            this.vivo = true; // Por defecto, el personaje está vivo
        }

        // Getters y setters
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        public String getCasa() {
            return casa;
        }

        public void setCasa(String casa) {
            this.casa = casa;
        }

        public boolean isVivo() {
            return vivo;
        }

        // Método para cambiar el estado del personaje
        public void cambiarEstado(boolean estado) {
            this.vivo = estado;
        }

        // Método para mostrar información del personaje
        @Override
        public String toString() {
            return "PersonajeJuegoTronos{" +
                    "nombre='" + nombre + '\'' +
                    ", edad=" + edad +
                    ", casa='" + casa + '\'' +
                    ", vivo=" + (vivo ? "vivo" : "muerto") +
                    '}';
        }
    }
}
