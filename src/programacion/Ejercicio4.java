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

public class Ejercicio4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Ingrese el día:");
            int dia = scanner.nextInt();
            System.out.println("Ingrese el mes:");
            int mes = scanner.nextInt();
            System.out.println("Ingrese el año:");
            int año = scanner.nextInt();

            if (mes >= 1 && mes <= 3) {
                System.out.println("La fecha corresponde al primer trimestre del año.");
            } else if (mes >= 4 && mes <= 6) {
                System.out.println("La fecha corresponde al segundo trimestre del año.");
            } else if (mes >= 7 && mes <= 9) {
                System.out.println("La fecha corresponde al tercer trimestre del año.");
            } else if (mes >= 10 && mes <= 12) {
                System.out.println("La fecha corresponde al cuarto trimestre del año.");
            } else {
                System.out.println("Mes inválido. Por favor, ingrese un mes entre 1 y 12.");
            }

            System.out.println("¿Desea ingresar otra fecha? (s/n):");
            char respuesta = scanner.next().charAt(0);
            if (respuesta == 'n' || respuesta == 'N') {
                continuar = false;
            }
        }

        scanner.close();
        System.out.println("Programa finalizado.");
    }
}

