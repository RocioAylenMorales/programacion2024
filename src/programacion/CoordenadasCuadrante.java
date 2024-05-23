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

public class CoordenadasCuadrante {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Ingrese la coordenada x (distinta de cero):");
            int x = scanner.nextInt();
            System.out.println("Ingrese la coordenada y (distinta de cero):");
            int y = scanner.nextInt();

            if (x == 0 || y == 0) {
                System.out.println("Las coordenadas deben ser distintas de cero. Intente nuevamente.");
            } else if (x > 0 && y > 0) {
                System.out.println("El punto se encuentra en el primer cuadrante.");
            } else if (x < 0 && y > 0) {
                System.out.println("El punto se encuentra en el segundo cuadrante.");
            } else if (x < 0 && y < 0) {
                System.out.println("El punto se encuentra en el tercer cuadrante.");
            } else if (x > 0 && y < 0) {
                System.out.println("El punto se encuentra en el cuarto cuadrante.");
            }

            System.out.println("¿Desea ingresar otra coordenada? (s/n):");
            char respuesta = scanner.next().charAt(0);
            if (respuesta == 'n' || respuesta == 'N') {
                continuar = false;
            }
        }

        scanner.close();
        System.out.println("Programa finalizado.");
    }
}

