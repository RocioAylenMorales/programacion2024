/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rocio
 */
public class CalculoDeEficienciaEnergetica {
    public static void main(String[] args) {
        // Primer problema: Calculo de ahorro de energía anual
        double consumoAntes = 1000; // kWh por mes antes de la implementación
        double consumoDespues = 800; // kWh por mes después de la implementación
        double precioKwh = 0.15; // Precio de la energía por kWh
        double ahorroAnual = calcularAhorroEnergia(consumoAntes, consumoDespues, precioKwh);
        System.out.println("El ahorro de energía anual es: $" + ahorroAnual);

        // Segundo problema: Determinar máximo y mínimo consumo de energía
        double[] consumos = {2, 5 * 30, 0.5 * 6, 3 * 2}; // Consumos de los electrodomésticos en kWh
        double maxConsumo = calcularMaxConsumo(consumos);
        double minConsumo = calcularMinConsumo(consumos);
        System.out.println("El máximo consumo de energía es: " + maxConsumo + " kWh");
        System.out.println("El mínimo consumo de energía es: " + minConsumo + " kWh");
    }

    // Método para calcular el ahorro de energía anual utilizando sqrt()
    public static double calcularAhorroEnergia(double consumoAntes, double consumoDespues, double precioKwh) {
        double ahorroMensual = consumoAntes - consumoDespues;
        double ahorroAnual = ahorroMensual * 12;
        double costoAhorroAnual = Math.sqrt(ahorroAnual) * precioKwh;
        return costoAhorroAnual;
    }

    // Método para calcular el máximo consumo de energía
    public static double calcularMaxConsumo(double[] consumos) {
        double max = Double.MIN_VALUE;
        for (double consumo : consumos) {
            if (consumo > max) {
                max = consumo;
            }
        }
        return max;
    }

    // Método para calcular el mínimo consumo de energía
    public static double calcularMinConsumo(double[] consumos) {
        double min = Double.MAX_VALUE;
        for (double consumo : consumos) {
            if (consumo < min) {
                min = consumo;
            }
        }
        return min;
    }
}

