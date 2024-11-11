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

// Clase CalculadoraPropinas
public class CalculadoraPropinas {

    // Método para calcular la propina mínima recomendada (10% del monto total)
    public double calcularPropinaMinima(double montoTotal) {
        return montoTotal * 0.10;
    }

    // Método para verificar y sugerir propina
    public void verificarPropina() {
        Scanner scanner = new Scanner(System.in);

        try {
            // Solicitar el monto total de la cuenta
            System.out.print("Ingresa el monto total de tu consumo: ");
            double montoTotal = scanner.nextDouble();

            // Solicitar la propina que el usuario desea dejar
            System.out.print("Ingresa la cantidad de propina que deseas dejar: ");
            double propina = scanner.nextDouble();

            // Calcular la propina mínima recomendada
            double propinaMinima = calcularPropinaMinima(montoTotal);

            // Verificar si la propina es menor al 10% del monto total
            if (propina < propinaMinima) {
                System.out.printf("La propina ingresada es menor al 10%% del monto total.\n");
                System.out.printf("La propina mínima recomendada es: %.2f\n", propinaMinima);
            } else {
                System.out.printf("Gracias por tu propina de %.2f. ¡Esperamos que hayas disfrutado tu servicio!\n", propina);
            }

        } catch (Exception e) {
            System.out.println("Por favor, ingresa valores numéricos válidos.");
        } finally {
            scanner.close();
        }
    }

    // Método principal para ejecutar el programa
    public static void main(String[] args) {
        CalculadoraPropinas calculadora = new CalculadoraPropinas();
        calculadora.verificarPropina();
    }
}

