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

import java.util.Scanner;

public class OperacionesMatematicas {

    // Método para sumar dos números enteros
    public int sumar(int a, int b) {
        return a + b;
    }

    // Método para sumar dos números de punto flotante
    public double sumar(double a, double b) {
        return a + b;
    }

    // Método para restar dos números enteros
    public int restar(int a, int b) {
        return a - b;
    }

    // Método para restar dos números de punto flotante
    public double restar(double a, double b) {
        return a - b;
    }

    // Método para multiplicar dos números enteros
    public int multiplicar(int a, int b) {
        return a * b;
    }

    // Método para multiplicar dos números de punto flotante
    public double multiplicar(double a, double b) {
        return a * b;
    }

    // Método para dividir dos números enteros
    public int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return a / b;
    }

    // Método para dividir dos números de punto flotante
    public double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return a / b;
    }

    // Método principal para interactuar con el usuario y realizar operaciones matemáticas
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OperacionesMatematicas opMat = new OperacionesMatematicas();

        boolean continuar = true;

        while (continuar) {
            System.out.println("Seleccione la operación que desea realizar:");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            int operacion = scanner.nextInt();

            System.out.println("Seleccione el tipo de números:");
            System.out.println("1. Enteros");
            System.out.println("2. Decimales");
            int tipo = scanner.nextInt();

            if (tipo == 1) {
                // Operaciones con enteros
                System.out.println("Ingrese el primer número entero:");
                int num1 = scanner.nextInt();
                System.out.println("Ingrese el segundo número entero:");
                int num2 = scanner.nextInt();

                switch (operacion) {
                    case 1:
                        System.out.println("Resultado: " + opMat.sumar(num1, num2));
                        break;
                    case 2:
                        System.out.println("Resultado: " + opMat.restar(num1, num2));
                        break;
                    case 3:
                        System.out.println("Resultado: " + opMat.multiplicar(num1, num2));
                        break;
                    case 4:
                        try {
                            System.out.println("Resultado: " + opMat.dividir(num1, num2));
                        } catch (ArithmeticException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    default:
                        System.out.println("Operación no válida");
                }
            } else if (tipo == 2) {
                // Operaciones con decimales
                System.out.println("Ingrese el primer número decimal:");
                double num1 = scanner.nextDouble();
                System.out.println("Ingrese el segundo número decimal:");
                double num2 = scanner.nextDouble();

                switch (operacion) {
                    case 1:
                        System.out.println("Resultado: " + opMat.sumar(num1, num2));
                        break;
                    case 2:
                        System.out.println("Resultado: " + opMat.restar(num1, num2));
                        break;
                    case 3:
                        System.out.println("Resultado: " + opMat.multiplicar(num1, num2));
                        break;
                    case 4:
                        try {
                            System.out.println("Resultado: " + opMat.dividir(num1, num2));
                        } catch (ArithmeticException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    default:
                        System.out.println("Operación no válida");
                }
            } else {
                System.out.println("Tipo de número no válido");
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


