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

public class EvaluacionNotas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Ingrese la nota de la materia (0-10):");
            double nota = scanner.nextDouble();

            if (nota < 0 || nota > 10) {
                System.out.println("Nota inválida. Por favor, ingrese una nota entre 0 y 10.");
            } else if (nota < 4) {
                System.out.println("El alumno ha desaprobado la materia.");
            } else if (nota == 10) {
                System.out.println("El alumno es sobresaliente.");
            } else {
                System.out.println("El alumno ha aprobado la materia.");
            }

            System.out.println("¿Desea ingresar otra nota? (s/n):");
            char respuesta = scanner.next().charAt(0);
            if (respuesta == 'n' || respuesta == 'N') {
                continuar = false;
            }
        }

        scanner.close();
        System.out.println("Programa finalizado.");
    }
}

