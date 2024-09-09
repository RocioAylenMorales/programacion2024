/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion;

/**
 *
 * @author Rocio
 */
import java.io.*;
import java.time.LocalDate;
import java.util.*;

// Enumeración para el estado de las tareas
enum EstadoTarea {
    PENDIENTE, EN_PROGRESO, COMPLETADA;
}

// Clase Tarea
class Tarea {
    private String codigo;
    private String descripcion;
    private EstadoTarea estado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int horasEstimadas;

    public Tarea(String codigo, String descripcion, EstadoTarea estado, LocalDate fechaInicio, LocalDate fechaFin, int horasEstimadas) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horasEstimadas = horasEstimadas;
    }

    public EstadoTarea getEstado() {
        return estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getHorasEstimadas() {
        return horasEstimadas;
    }

    public void setEstado(EstadoTarea estado) {
        this.estado = estado;
    }

    // Otros getters y setters omitidos por brevedad
}

// Clase Trabajador (abstracta)
abstract class Trabajador {
    protected String codigo;
    protected String nombre;
    protected double salarioBase;
    protected List<Tarea> tareas;

    public Trabajador(String codigo, String nombre, double salarioBase) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        this.tareas = new ArrayList<>();
    }

    public abstract double calcularSalario();

    public void asignarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public List<Tarea> getTareasPendientes() {
        List<Tarea> pendientes = new ArrayList<>();
        for (Tarea tarea : tareas) {
            if (tarea.getEstado() == EstadoTarea.PENDIENTE) {
                pendientes.add(tarea);
            }
        }
        return pendientes;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public String getNombre() {
        return nombre;
    }
}

// Clase Desarrollador
class Desarrollador extends Trabajador {
    private String lenguaje;

    public Desarrollador(String codigo, String nombre, double salarioBase, String lenguaje) {
        super(codigo, nombre, salarioBase);
        this.lenguaje = lenguaje;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + (tareas.size() * 50); // Ejemplo: paga adicional por tarea
    }

    public String getLenguaje() {
        return lenguaje;
    }
}

// Clase DiseñadorUX
class DiseñadorUX extends Trabajador {
    public DiseñadorUX(String codigo, String nombre, double salarioBase) {
        super(codigo, nombre, salarioBase);
    }

    @Override
    public double calcularSalario() {
        return salarioBase + (tareas.size() * 30); // Ejemplo: paga adicional por tarea
    }
}

// Clase GerenteDeProyectos
class GerenteDeProyectos extends Trabajador {
    public GerenteDeProyectos(String codigo, String nombre, double salarioBase) {
        super(codigo, nombre, salarioBase);
    }

    @Override
    public double calcularSalario() {
        return salarioBase + (tareas.size() * 100); // Ejemplo: paga adicional por tarea
    }
}

// Clase Cliente
class Cliente {
    private String codigo;
    private String nombre;

    public Cliente(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }
}

// Clase Proyecto
class Proyecto {
    private String codigo;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFinEstimada;
    private Cliente cliente;
    private List<Trabajador> trabajadores;
    private List<Tarea> tareas;

    public Proyecto(String codigo, String nombre, LocalDate fechaInicio, LocalDate fechaFinEstimada, Cliente cliente) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinEstimada = fechaFinEstimada;
        this.cliente = cliente;
        this.trabajadores = new ArrayList<>();
        this.tareas = new ArrayList<>();
    }

    public void asignarTrabajador(Trabajador trabajador) {
        trabajadores.add(trabajador);
    }

    public void asignarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public int calcularProgreso() {
        int completadas = 0;
        for (Tarea tarea : tareas) {
            if (tarea.getEstado() == EstadoTarea.COMPLETADA) {
                completadas++;
            }
        }
        return (int) ((double) completadas / tareas.size() * 100); // Porcentaje completado
    }

    public int calcularHorasTotales() {
        int totalHoras = 0;
        for (Tarea tarea : tareas) {
            totalHoras += tarea.getHorasEstimadas();
        }
        return totalHoras;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public String getNombre() {
        return nombre;
    }
}

// Clase para manejar archivos CSV
class ArchivoCSV {
    public static List<String[]> leerCSV(String archivo) {
        List<String[]> datos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                datos.add(linea.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datos;
    }

    public static void escribirCSV(String archivo, List<String[]> datos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (String[] linea : datos) {
                bw.write(String.join(",", linea));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Clase principal
public class SistemaGestionSoftware {
    private List<Proyecto> proyectos;
    private List<Cliente> clientes;
    private List<Trabajador> trabajadores;

    public SistemaGestionSoftware() {
        this.proyectos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.trabajadores = new ArrayList<>();
    }

    // Asignar trabajador a proyecto
    public void asignarTrabajadorAProyecto(String codigoProyecto, Trabajador trabajador) {
        for (Proyecto proyecto : proyectos) {
            if (proyecto.getNombre().equals(codigoProyecto)) {
                proyecto.asignarTrabajador(trabajador);
                break;
            }
        }
    }

    // Asignar tarea a trabajador
    public void asignarTareaATrabajador(String codigoTrabajador, Tarea tarea) {
        for (Trabajador trabajador : trabajadores) {
            if (trabajador.getNombre().equals(codigoTrabajador)) {
                trabajador.asignarTarea(tarea);
                break;
            }
        }
    }

    // Reporte de horas trabajadas por proyecto
    public void reporteHorasPorProyecto() {
        for (Proyecto proyecto : proyectos) {
            System.out.println("Proyecto: " + proyecto.getNombre() + " - Horas totales: " + proyecto.calcularHorasTotales());
        }
    }

    // Reporte de horas trabajadas por trabajador
    public void reporteHorasPorTrabajador() {
        for (Trabajador trabajador : trabajadores) {
            int totalHoras = 0;
            for (Tarea tarea : trabajador.getTareas()) {
                totalHoras += tarea.getHorasEstimadas();
            }
            System.out.println("Trabajador: " + trabajador.getNombre() + " - Horas totales: " + totalHoras);
        }
    }

    // Leer datos de archivos CSV
    public void leerDatosDeArchivos() {
        List<String[]> datosProyectos = ArchivoCSV.leerCSV("proyectos.csv");
        // Procesar los datos
    }

    // Escribir datos en archivos CSV
    public void escribirDatosAArchivos() {
        List<String[]> datosProyectos = new ArrayList<>();
        for (Proyecto proyecto : proyectos) {
            // Escribir los datos del proyecto
        }
        ArchivoCSV.escribirCSV("proyectos.csv", datosProyectos);
    }

    public static void main(String[] args) {
        SistemaGestionSoftware sistema = new SistemaGestionSoftware();

        // Creación de datos
        Cliente cliente1 = new Cliente("C001", "Empresa ABC");
        Desarrollador dev1 = new Desarrollador("T001", "Juan", 1000, "Java");
        DiseñadorUX ux1 = new DiseñadorUX("T002", "Ana", 900);
        GerenteDeProyectos gerente1 = new GerenteDeProyectos("T003", "Carlos", 1200);

        Proyecto proyecto1 = new Proyecto("P001", "Sistema de Gestión", LocalDate.now(), LocalDate.now().plusMonths(6), cliente1);

        Tarea tarea1 = new Tarea("T001", "Implementar backend", EstadoTarea.PENDIENTE, LocalDate.now(), LocalDate.now().plusDays(10), 40);

        sistema.proyectos.add(proyecto1);
        sistema.clientes.add(cliente1);
        sistema.trabajadores.add(dev1);
        sistema.trabajadores.add(ux1);
        sistema.trabajadores.add(gerente1);

        sistema.asignarTrabajadorAProyecto("P001", dev1);
        sistema.asignarTareaATrabajador("T001", tarea1);

        // Reporte de progreso
        System.out.println("Progreso del proyecto: " + proyecto1.calcularProgreso() + "%");

        // Generar reportes
        sistema.reporteHorasPorProyecto();
        sistema.reporteHorasPorTrabajador();
    }
}

