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

public class TiposDeTriangulos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese la cantidad de triángulos:");
        int n = scanner.nextInt();
        
        int countEquilatero = 0;
        int countIsosceles = 0;
        int countEscaleno = 0;

        for (int i = 1; i <= n; i++) {
            System.out.println("Ingrese los lados del triángulo " + i + ":");
            System.out.print("Lado 1: ");
            int lado1 = scanner.nextInt();
            System.out.print("Lado 2: ");
            int lado2 = scanner.nextInt();
            System.out.print("Lado 3: ");
            int lado3 = scanner.nextInt();

            if (lado1 == lado2 && lado2 == lado3) {
                System.out.println("El triángulo " + i + " es equilátero.");
                countEquilatero++;
            } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
                System.out.println("El triángulo " + i + " es isósceles.");
                countIsosceles++;
            } else {
                System.out.println("El triángulo " + i + " es escaleno.");
                countEscaleno++;
            }
        }

        System.out.println("\nCantidad de triángulos equiláteros: " + countEquilatero);
        System.out.println("Cantidad de triángulos isósceles: " + countIsosceles);
        System.out.println("Cantidad de triángulos escalenos: " + countEscaleno);

        int menorCantidad = Math.min(countEquilatero, Math.min(countIsosceles, countEscaleno));
        System.out.print("Tipo de triángulo con menor cantidad: ");
        if (menorCantidad == countEquilatero) {
            System.out.print("Equilátero ");
        }
        if (menorCantidad == countIsosceles) {
            System.out.print("Isósceles ");
        }
        if (menorCantidad == countEscaleno) {
            System.out.print("Escaleno ");
        }
        System.out.println();

        scanner.close();
    }
}

