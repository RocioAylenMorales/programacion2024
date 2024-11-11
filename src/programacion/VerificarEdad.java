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
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

// Clase VerificarEdad
public class VerificarEdad {

    // Método para calcular la edad a partir de la fecha de nacimiento
    public int calcularEdad(LocalDate fechaNacimiento) {
        LocalDate fechaActual = LocalDate.now();
        return Period.between(fechaNacimiento, fechaActual).getYears();
    }

    // Método para verificar si el usuario cumple con la edad mínima
    public void verificarEdadUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa tu fecha de nacimiento (YYYY-MM-DD): ");
        
        try {
            // Captura la fecha de nacimiento ingresada por el usuario
            String fechaIngreso = scanner.nextLine();
            LocalDate fechaNacimiento = LocalDate.parse(fechaIngreso, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            
            // Calcula la edad
            int edad = calcularEdad(fechaNacimiento);
            
            // Verifica si la edad es menor a 13 años
            if (edad < 13) {
                System.out.println("Lo sentimos, tienes " + edad + " años, lo cual es menos de la edad permitida para esta red social.");
                System.out.println("Redirigiendo a una página más adecuada para tu edad...");
                System.out.println("Visita: www.contenido-seguro-para-ninos.com");
            } else {
                System.out.println("Acceso permitido. Bienvenido a la red social.");
            }
        } catch (DateTimeParseException e) {
            System.out.println("Formato de fecha inválido. Asegúrate de usar el formato YYYY-MM-DD.");
        } finally {
            scanner.close();
        }
    }

    // Método principal para ejecutar el programa
    public static void main(String[] args) {
        VerificarEdad verificador = new VerificarEdad();
        verificador.verificarEdadUsuario();
    }
}

