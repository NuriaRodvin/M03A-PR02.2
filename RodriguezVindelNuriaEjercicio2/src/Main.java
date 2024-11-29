// Clase para representar una tarea asociada a un evento
public class EventTask {
    private String text; // Descripción de la tarea
    private boolean isCompleted; // Estado de la tarea: true (completada) o false (pendiente)

    // Constructor para inicializar la tarea
    public EventTask(String text) {
        this.text = text;
        this.isCompleted = false; // Por defecto, la tarea está sin completar
    }

    // Método para alternar el estado de la tarea
    public void toggleCompletion() {
        isCompleted = !isCompleted;
    }

    // Método para representar la tarea como texto
    @Override
    public String toString() {
        return text + " [" + (isCompleted ? "Completada" : "Pendiente") + "]";
    }
}
