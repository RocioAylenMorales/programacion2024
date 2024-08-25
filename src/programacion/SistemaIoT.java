/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion;

/**
 *
 * @author Rocio
 */
import java.util.ArrayList;
import java.util.List;

// Interface para definir las operaciones básicas de un dispositivo IoT
interface DispositivoIoT {
    void encender();
    void apagar();
    String obtenerEstado();
}

// Clase abstracta que implementa la interfaz y añade el manejo del historial de estado
abstract class Dispositivo implements DispositivoIoT {
    protected String estado;
    protected List<String> historialEstado;

    public Dispositivo() {
        this.estado = "apagado";
        this.historialEstado = new ArrayList<>();
        this.historialEstado.add(estado);
    }

    @Override
    public void encender() {
        estado = "encendido";
        registrarEstado(estado);
    }

    @Override
    public void apagar() {
        estado = "apagado";
        registrarEstado(estado);
    }

    @Override
    public String obtenerEstado() {
        return estado;
    }

    protected void registrarEstado(String nuevoEstado) {
        historialEstado.add(nuevoEstado);
    }

    public List<String> obtenerHistorial() {
        return historialEstado;
    }
}

// Clase concreta para un Sensor de Temperatura
class SensorDeTemperatura extends Dispositivo {

    public SensorDeTemperatura() {
        super();
    }

    public void leerTemperatura() {
        if ("encendido".equals(estado)) {
            System.out.println("Leyendo temperatura...");
        } else {
            System.out.println("El sensor está apagado.");
        }
    }
}

// Clase concreta para una Cámara de Seguridad
class CamaraDeSeguridad extends Dispositivo {

    public CamaraDeSeguridad() {
        super();
    }

    public void grabarVideo() {
        if ("encendido".equals(estado)) {
            System.out.println("Grabando video...");
        } else {
            System.out.println("La cámara está apagada.");
        }
    }
}

// Clase concreta para un Altavoz Inteligente
class AltavozInteligente extends Dispositivo {

    public AltavozInteligente() {
        super();
    }

    public void reproducirMusica() {
        if ("encendido".equals(estado)) {
            System.out.println("Reproduciendo música...");
        } else {
            System.out.println("El altavoz está apagado.");
        }
    }
}

// Clase principal para demostrar el uso del sistema de dispositivos IoT
public class SistemaIoT {

    public static void main(String[] args) {
        SensorDeTemperatura sensor = new SensorDeTemperatura();
        CamaraDeSeguridad camara = new CamaraDeSeguridad();
        AltavozInteligente altavoz = new AltavozInteligente();

        sensor.encender();
        camara.encender();
        altavoz.encender();

        sensor.leerTemperatura();
        camara.grabarVideo();
        altavoz.reproducirMusica();

        sensor.apagar();
        camara.apagar();
        altavoz.apagar();

        System.out.println("Historial de estados del sensor de temperatura: " + sensor.obtenerHistorial());
        System.out.println("Historial de estados de la cámara de seguridad: " + camara.obtenerHistorial());
        System.out.println("Historial de estados del altavoz inteligente: " + altavoz.obtenerHistorial());
    }
}

