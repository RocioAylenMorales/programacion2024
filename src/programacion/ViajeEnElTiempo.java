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

// Excepción personalizada para años fuera de rango
class AnioFueraDeRangoException extends Exception {
    public AnioFueraDeRangoException(String mensaje) {
        super(mensaje);
    }
}

// Clase ViajeEnElTiempo
public class ViajeEnElTiempo {

    // Método para realizar el viaje en el tiempo
    public void viajarA(int anio) throws AnioFueraDeRangoException {
        if (anio < 1900 || anio > 2100) {
            throw new AnioFueraDeRangoException("¡Cuidado! Viajar demasiado lejos en el tiempo puede causar paradojas y dimensiones alternas.");
        } else {
            System.out.println("Viajando al año " + anio + "... ¡Prepara tu traje temporal!");
        }
    }

    // Método principal para ejecutar el programa
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ViajeEnElTiempo maquinaDelTiempo = new ViajeEnElTiempo();

        System.out.print("¿A qué año deseas viajar?: ");
        try {
            int anio = scanner.nextInt(); // Captura el año ingresado por el usuario
            maquinaDelTiempo.viajarA(anio); // Intenta realizar el viaje
        } catch (AnioFueraDeRangoException e) {
            System.out.println(e.getMessage()); // Mensaje divertido si el año está fuera de rango
        } catch (Exception e) {
            System.out.println("Por favor, ingresa un número válido para el año.");
        } finally {
            scanner.close(); // Cierra el scanner para liberar recursos
        }
    }
}

