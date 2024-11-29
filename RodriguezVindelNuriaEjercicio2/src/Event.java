import java.time.LocalDate;
import java.util.ArrayList;

// Clase para representar un evento
public class Event {
    private String title; // Título del evento
    private LocalDate date; // Fecha del evento
    private Priority priority; // Prioridad del evento: HIGH, MEDIUM, LOW
    private ArrayList<EventTask> tasks; // Lista de tareas asociadas al evento

    // Constructor para inicializar un evento
    public Event(String title, LocalDate date, Priority priority) {
        this.title = title;
        this.date = date;
        this.priority = priority;
        this.tasks = new ArrayList<>(); // Lista de tareas vacía por defecto
    }

    // Método para añadir una tarea al evento
    public void addTask(EventTask task) {
        tasks.add(task);
    }

    // Representación del evento como texto
    @Override
    public String toString() {
        long completedTasks = tasks.stream().filter(t -> t.isCompleted).count();
        return title + " | Fecha: " + date + " | Prioridad: " + priority + " | Tareas: "
                + completedTasks + "/" + tasks.size();
    }

    // Enum para definir los niveles de prioridad
    public enum Priority {
        HIGH, MEDIUM, LOW
    }
}
