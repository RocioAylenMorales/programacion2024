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

public class PromocionAlumno {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Ingrese la nota del primer parcial:");
            double nota1 = scanner.nextDouble();
            System.out.println("Ingrese la nota del segundo parcial:");
            double nota2 = scanner.nextDouble();
            System.out.println("Ingrese la nota del tercer parcial:");
            double nota3 = scanner.nextDouble();

            double promedio = (nota1 + nota2 + nota3) / 3;
            System.out.printf("El promedio del alumno es: %.2f%n", promedio);

            if (promedio >= 8) {
                System.out.println("El alumno está promocionado.");
            } else {
                System.out.println("El alumno no está promocionado.");
            }

            System.out.println("¿Desea ingresar las notas de otro alumno? (s/n):");
            char respuesta = scanner.next().charAt(0);
            if (respuesta == 'n' || respuesta == 'N') {
                continuar = false;
            }
        }

        scanner.close();
        System.out.println("Programa finalizado.");
    }
}

