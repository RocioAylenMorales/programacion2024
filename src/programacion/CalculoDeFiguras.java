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

public class CalculoDeFiguras {

    // Métodos para calcular el área y el perímetro de un cuadrado
    public double areaCuadrado(double lado) {
        return lado * lado;
    }

    public double perimetroCuadrado(double lado) {
        return 4 * lado;
    }

    // Métodos para calcular el área y el perímetro de un rectángulo
    public double areaRectangulo(double largo, double ancho) {
        return largo * ancho;
    }

    public double perimetroRectangulo(double largo, double ancho) {
        return 2 * (largo + ancho);
    }

    // Métodos para calcular el área y el perímetro de un círculo
    public double areaCirculo(double radio) {
        return Math.PI * radio * radio;
    }

    public double perimetroCirculo(double radio) {
        return 2 * Math.PI * radio;
    }

    // Método principal para interactuar con el usuario y realizar los cálculos
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculoDeFiguras calculoDeFiguras = new CalculoDeFiguras();

        boolean continuar = true;
        while (continuar) {
            System.out.println("Seleccione la figura para calcular el área y el perímetro:");
            System.out.println("1. Cuadrado");
            System.out.println("2. Rectángulo");
            System.out.println("3. Círculo");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el lado del cuadrado:");
                    double lado = scanner.nextDouble();
                    System.out.println("Área del cuadrado: " + calculoDeFiguras.areaCuadrado(lado));
                    System.out.println("Perímetro del cuadrado: " + calculoDeFiguras.perimetroCuadrado(lado));
                    break;
                case 2:
                    System.out.println("Ingrese el largo del rectángulo:");
                    double largo = scanner.nextDouble();
                    System.out.println("Ingrese el ancho del rectángulo:");
                    double ancho = scanner.nextDouble();
                    System.out.println("Área del rectángulo: " + calculoDeFiguras.areaRectangulo(largo, ancho));
                    System.out.println("Perímetro del rectángulo: " + calculoDeFiguras.perimetroRectangulo(largo, ancho));
                    break;
                case 3:
                    System.out.println("Ingrese el radio del círculo:");
                    double radio = scanner.nextDouble();
                    System.out.println("Área del círculo: " + calculoDeFiguras.areaCirculo(radio));
                    System.out.println("Perímetro del círculo: " + calculoDeFiguras.perimetroCirculo(radio));
                    break;
                default:
                    System.out.println("Opción no válida");
            }

            System.out.println("¿Desea realizar otro cálculo? (s/n):");
            char respuesta = scanner.next().charAt(0);
            if (respuesta == 'n' || respuesta == 'N') {
                continuar = false;
            }
        }

        scanner.close();
        System.out.println("Programa finalizado.");
    }
}

