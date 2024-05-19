/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rocio
 */
public class CalculoDeInteresCompuesto {
    public static void main(String[] args) {
        double inversionInicial = 10000; // Inversión inicial en dólares
        int años = 5; // Número de años
        double tasaInteresAnual = 0.06; // Tasa de interés anual (6%)
        
        // Calculando el valor futuro con interés compuesto
        double valorFuturo = calcularValorFuturo(inversionInicial, años, tasaInteresAnual);
        
        // Redondeando el valor futuro a dos decimales utilizando el método round() de la clase Math
        double valorFuturoRedondeado = Math.round(valorFuturo * 100.0) / 100.0;
        
        System.out.println("El valor futuro de la inversión después de " + años + " años es: $" + valorFuturoRedondeado);
    }

    // Método para calcular el valor futuro de una inversión con interés compuesto
    public static double calcularValorFuturo(double inversionInicial, int años, double tasaInteresAnual) {
        double valorFuturo = inversionInicial * Math.pow(1 + tasaInteresAnual, años);
        return valorFuturo;
    }
}

