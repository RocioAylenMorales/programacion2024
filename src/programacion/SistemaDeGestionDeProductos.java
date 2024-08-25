/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion;

/**
 *
 * @author Rocio
 */
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// Interfaz que define los métodos comunes para todos los productos
interface Producto {
    double calcularPrecio();
    String mostrarDetalles();
}

// Clase abstracta que proporciona una implementación base para los productos
abstract class ProductoBase implements Producto {
    protected String nombre;
    protected double precio;

    // Constructor
    public ProductoBase(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Implementación del método mostrarDetalles
    @Override
    public String mostrarDetalles() {
        return "Nombre: " + nombre + "\n" +
               "Precio: $" + precio;
    }
}

// Clase concreta para productos alimenticios
class ProductoAlimenticio extends ProductoBase {
    private LocalDate fechaExpiracion;

    public ProductoAlimenticio(String nombre, double precio, LocalDate fechaExpiracion) {
        super(nombre, precio);
        this.fechaExpiracion = fechaExpiracion;
    }

    @Override
    public double calcularPrecio() {
        return precio; // Podrías agregar lógica adicional como descuentos según la fecha de vencimiento
    }

    @Override
    public String mostrarDetalles() {
        return super.mostrarDetalles() + "\nFecha de Expiración: " + fechaExpiracion;
    }

    // Método específico para verificar si el producto está próximo a vencer
    public boolean estaProximoAVencer() {
        return ChronoUnit.DAYS.between(LocalDate.now(), fechaExpiracion) <= 5;
    }
}

// Clase concreta para productos electrónicos
class ProductoElectronico extends ProductoBase {
    private int garantiaMeses;

    public ProductoElectronico(String nombre, double precio, int garantiaMeses) {
        super(nombre, precio);
        this.garantiaMeses = garantiaMeses;
    }

    @Override
    public double calcularPrecio() {
        return precio; // Podrías agregar lógica adicional como impuestos o descuentos
    }

    @Override
    public String mostrarDetalles() {
        return super.mostrarDetalles() + "\nGarantía: " + garantiaMeses + " meses";
    }
}

// Clase concreta para productos de ropa
class ProductoRopa extends ProductoBase {
    private String talla;

    public ProductoRopa(String nombre, double precio, String talla) {
        super(nombre, precio);
        this.talla = talla;
    }

    @Override
    public double calcularPrecio() {
        return precio; // Podrías agregar lógica adicional como descuentos por temporada
    }

    @Override
    public String mostrarDetalles() {
        return super.mostrarDetalles() + "\nTalla: " + talla;
    }
}

// Clase principal para probar el sistema de gestión de productos
public class SistemaDeGestionDeProductos {
    public static void main(String[] args) {
        ProductoAlimenticio manzana = new ProductoAlimenticio("Manzana", 0.5, LocalDate.of(2024, 8, 28));
        ProductoElectronico televisor = new ProductoElectronico("Televisor", 300.0, 24);
        ProductoRopa camiseta = new ProductoRopa("Camiseta", 15.0, "M");

        // Mostrar detalles de cada producto
        System.out.println(manzana.mostrarDetalles());
        System.out.println("¿Está próximo a vencer? " + (manzana.estaProximoAVencer() ? "Sí" : "No"));
        System.out.println("-------------------------------");
        System.out.println(televisor.mostrarDetalles());
        System.out.println("-------------------------------");
        System.out.println(camiseta.mostrarDetalles());
    }
}
