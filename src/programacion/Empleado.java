/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion;

/**
 *
 * @author Rocio
 */
public class Empleado {
    private String nombre;
    private String apellido;
    private int edad;
    private double salario;

    // Constructor para inicializar el empleado con valores proporcionados por el usuario
    public Empleado(String nombre, String apellido, int edad, double salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.salario = salario;
    }

    // Método para mostrar la información completa del empleado
    public void mostrarInformacionCompleta() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Edad: " + edad);
        System.out.println("Salario: $" + salario);
    }

    // Método para mostrar la información del empleado excluyendo el salario
    public void mostrarInformacionSinSalario() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Edad: " + edad);
    }

    // Método para incrementar el salario del empleado por un monto fijo
    public void incrementarSalario(double incremento) {
        this.salario += incremento;
        System.out.println("Salario incrementado en $" + incremento + ". Nuevo salario: $" + salario);
    }

    // Método para incrementar el salario del empleado por un porcentaje basado en su desempeño
    public void incrementarSalarioPorDesempeño(double porcentaje) {
        double incremento = this.salario * (porcentaje / 100);
        this.salario += incremento;
        System.out.println("Salario incrementado en " + porcentaje + "% ($" + incremento + "). Nuevo salario: $" + salario);
    }

    // Método principal para probar la clase Empleado
    public static void main(String[] args) {
        // Creando un nuevo empleado
        Empleado empleado = new Empleado("Juan", "Pérez", 30, 50000);

        // Mostrando la información completa del empleado
        System.out.println("Información completa del empleado:");
        empleado.mostrarInformacionCompleta();

        // Mostrando la información del empleado sin el salario
        System.out.println("\nInformación del empleado sin salario:");
        empleado.mostrarInformacionSinSalario();

        // Incrementando el salario por un monto fijo
        System.out.println("\nIncrementando el salario por un monto fijo:");
        empleado.incrementarSalario(5000);

        // Incrementando el salario por un porcentaje basado en su desempeño
        System.out.println("\nIncrementando el salario por un porcentaje de desempeño:");
        empleado.incrementarSalarioPorDesempeño(10);
    }
}

