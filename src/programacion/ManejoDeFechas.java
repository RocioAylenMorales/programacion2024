/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion;

/**
 *
 * @author Rocio
 */
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class ManejoDeFechas {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Método para calcular los días transcurridos desde una fecha dada hasta la fecha actual
    public long calcularDiasTranscurridos(int dia, int mes, int año) {
        LocalDate fecha = LocalDate.of(año, mes, dia);
        LocalDate hoy = LocalDate.now();
        return ChronoUnit.DAYS.between(fecha, hoy);
    }

    // Método para calcular los días transcurridos desde una fecha en formato "dd/MM/yyyy" hasta la fecha actual
    public long calcularDiasTranscurridos(String fecha) {
        try {
            LocalDate fechaDate = LocalDate.parse(fecha, FORMATTER);
            LocalDate hoy = LocalDate.now();
            return ChronoUnit.DAYS.between(fechaDate, hoy);
        } catch (DateTimeParseException e) {
            System.out.println("Formato de fecha inválido. Use 'dd/MM/yyyy'.");
            return -1;
        }
    }

    // Método para determinar si un año es bisiesto
    public boolean esBisiesto(int año) {
        return LocalDate.of(año, 1, 1).isLeapYear();
    }

    // Método para determinar si el año de una fecha en formato "dd/MM/yyyy" es bisiesto
    public boolean esBisiesto(String fecha) {
        try {
            LocalDate fechaDate = LocalDate.parse(fecha, FORMATTER);
            return fechaDate.isLeapYear();
        } catch (DateTimeParseException e) {
            System.out.println("Formato de fecha inválido. Use 'dd/MM/yyyy'.");
            return false;
        }
    }

    // Método principal para interactuar con el usuario y realizar operaciones de fechas
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManejoDeFechas manejoDeFechas = new ManejoDeFechas();

        boolean continuar = true;
        while (continuar) {
            System.out.println("Seleccione la operación que desea realizar:");
            System.out.println("1. Calcular días transcurridos desde una fecha");
            System.out.println("2. Determinar si un año es bisiesto");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la fecha en formato 'dd/MM/yyyy':");
                    scanner.nextLine(); // Limpiar el buffer del scanner
                    String fechaStr = scanner.nextLine();
                    long diasTranscurridos = manejoDeFechas.calcularDiasTranscurridos(fechaStr);
                    if (diasTranscurridos >= 0) {
                        System.out.println("Días transcurridos desde " + fechaStr + ": " + diasTranscurridos);
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el año:");
                    int año = scanner.nextInt();
                    boolean esBisiesto = manejoDeFechas.esBisiesto(año);
                    System.out.println("El año " + año + " es bisiesto: " + esBisiesto);
                    break;
                default:
                    System.out.println("Opción no válida");
            }

            System.out.println("¿Desea realizar otra operación? (s/n):");
            char respuesta = scanner.next().charAt(0);
            if (respuesta == 'n' || respuesta == 'N') {
                continuar = false;
            }
        }

        scanner.close();
        System.out.println("Programa finalizado.");
    }
}

