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

// Clase ConversorDeUnidades
public class ConversorDeUnidades {

    // Método para realizar la conversión entre unidades compatibles
    public double convertir(String unidadOrigen, String unidadDestino, double valor) throws UnidadesIncompatiblesException {
        double resultado;
        
        // Conversión de longitud
        if (unidadOrigen.equalsIgnoreCase("metros") && unidadDestino.equalsIgnoreCase("kilometros")) {
            resultado = valor / 1000;
        } else if (unidadOrigen.equalsIgnoreCase("kilometros") && unidadDestino.equalsIgnoreCase("metros")) {
            resultado = valor * 1000;
        }

        // Conversión de peso
        else if (unidadOrigen.equalsIgnoreCase("gramos") && unidadDestino.equalsIgnoreCase("kilogramos")) {
            resultado = valor / 1000;
        } else if (unidadOrigen.equalsIgnoreCase("kilogramos") && unidadDestino.equalsIgnoreCase("gramos")) {
            resultado = valor * 1000;
        }

        // Conversión de volumen
        else if (unidadOrigen.equalsIgnoreCase("litros") && unidadDestino.equalsIgnoreCase("mililitros")) {
            resultado = valor * 1000;
        } else if (unidadOrigen.equalsIgnoreCase("mililitros") && unidadDestino.equalsIgnoreCase("litros")) {
            resultado = valor / 1000;
        }

        // Unidades incompatibles
        else {
            throw new UnidadesIncompatiblesException("Unidades incompatibles. Conversión no válida entre " + unidadOrigen + " y " + unidadDestino + ". " +
                    "Conversiones válidas: metros a kilómetros, kilómetros a metros, gramos a kilogramos, kilogramos a gramos, litros a mililitros, mililitros a litros.");
        }

        return resultado;
    }

    // Método principal para ejecutar el programa
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorDeUnidades conversor = new ConversorDeUnidades();

        try {
            // Solicitar los datos al usuario
            System.out.print("Ingresa la unidad de origen (metros, kilometros, gramos, kilogramos, litros, mililitros): ");
            String unidadOrigen = scanner.nextLine();

            System.out.print("Ingresa la unidad de destino (metros, kilometros, gramos, kilogramos, litros, mililitros): ");
            String unidadDestino = scanner.nextLine();

            System.out.print("Ingresa el valor a convertir: ");
            double valor = scanner.nextDouble();

            // Intentar realizar la conversión
            double resultado = conversor.convertir(unidadOrigen, unidadDestino, valor);
            System.out.printf("Resultado de la conversión: %.2f %s\n", resultado, unidadDestino);

        } catch (UnidadesIncompatiblesException e) {
            System.out.println(e.getMessage()); // Muestra el mensaje si las unidades no son compatibles
        } catch (Exception e) {
            System.out.println("Entrada no válida. Por favor, revisa los datos ingresados.");
        } finally {
            scanner.close();
        }
    }
}

// Excepción personalizada para unidades incompatibles
class UnidadesIncompatiblesException extends Exception {
    public UnidadesIncompatiblesException(String mensaje) {
        super(mensaje);
    }
}

