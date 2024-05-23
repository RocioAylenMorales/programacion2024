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

public class DigitosNumero {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Ingrese un número positivo de uno o dos dígitos (1-99):");
            int numero = scanner.nextInt();

            if (numero >= 1 && numero <= 9) {
                System.out.println("El número tiene un dígito.");
            } else if (numero >= 10 && numero <= 99) {
                System.out.println("El número tiene dos dígitos.");
            } else {
                System.out.println("Número fuera de rango. Por favor, ingrese un número entre 1 y 99.");
            }

            System.out.println("¿Desea ingresar otro número? (s/n):");
            char respuesta = scanner.next().charAt(0);
            if (respuesta == 'n' || respuesta == 'N') {
                continuar = false;
            }
        }

        scanner.close();
        System.out.println("Programa finalizado.");
    }
}

