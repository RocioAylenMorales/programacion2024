/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion;

/**
 *
 * @author Rocio
 */
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

// Interfaz que define los métodos básicos para todas las tareas
interface Tarea {
    long calcularTiempoTotalInvertido();
    String generarInformeDeProgreso();
}

// Clase abstracta que proporciona una implementación base para las tareas
abstract class TareaBase implements Tarea {
    protected LocalDate fechaInicio;
    protected LocalDate fechaFin;
    protected String responsable;

    // Constructor
    public TareaBase(LocalDate fechaInicio, LocalDate fechaFin, String responsable) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.responsable = responsable;
    }

    // Implementación de calcularTiempoTotalInvertido usando ChronoUnit
    @Override
    public long calcularTiempoTotalInvertido() {
        return ChronoUnit.DAYS.between(fechaInicio, fechaFin);
    }

    // Método base para generar un informe de progreso
    @Override
    public String generarInformeDeProgreso() {
        return "Responsable: " + responsable + "\n" +
               "Fecha de Inicio: " + fechaInicio + "\n" +
               "Fecha de Fin: " + fechaFin + "\n" +
               "Tiempo Total Invertido: " + calcularTiempoTotalInvertido() + " días\n";
    }
}

// Clase concreta para tareas de desarrollo
class TareaDesarrollo extends TareaBase {

    public TareaDesarrollo(LocalDate fechaInicio, LocalDate fechaFin, String responsable) {
        super(fechaInicio, fechaFin, responsable);
    }

    @Override
    public String generarInformeDeProgreso() {
        return "Informe de Tarea de Desarrollo\n" + super.generarInformeDeProgreso();
    }
}

// Clase concreta para tareas de pruebas
class TareaPruebas extends TareaBase {

    public TareaPruebas(LocalDate fechaInicio, LocalDate fechaFin, String responsable) {
        super(fechaInicio, fechaFin, responsable);
    }

    @Override
    public String generarInformeDeProgreso() {
        return "Informe de Tarea de Pruebas\n" + super.generarInformeDeProgreso();
    }
}

// Clase concreta para tareas de documentación
class TareaDocumentacion extends TareaBase {

    public TareaDocumentacion(LocalDate fechaInicio, LocalDate fechaFin, String responsable) {
        super(fechaInicio, fechaFin, responsable);
    }

    @Override
    public String generarInformeDeProgreso() {
        return "Informe de Tarea de Documentación\n" + super.generarInformeDeProgreso();
    }
}

// Clase principal para probar el sistema de gestión de tareas
public class SistemaDeGestionDeTareas {
    public static void main(String[] args) {
        List<Tarea> tareas = new ArrayList<>();

        // Crear diferentes tipos de tareas
        Tarea tarea1 = new TareaDesarrollo(LocalDate.of(2024, 8, 1), LocalDate.of(2024, 8, 10), "Alice");
        Tarea tarea2 = new TareaPruebas(LocalDate.of(2024, 8, 11), LocalDate.of(2024, 8, 15), "Bob");
        Tarea tarea3 = new TareaDocumentacion(LocalDate.of(2024, 8, 16), LocalDate.of(2024, 8, 20), "Charlie");

        // Añadir tareas a la lista
        tareas.add(tarea1);
        tareas.add(tarea2);
        tareas.add(tarea3);

        // Imprimir informe de progreso para cada tarea
        for (Tarea tarea : tareas) {
            System.out.println(tarea.generarInformeDeProgreso());
            System.out.println("-------------------------------");
        }
    }
}

