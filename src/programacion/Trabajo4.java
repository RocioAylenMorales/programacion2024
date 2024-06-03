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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Clase base Persona
class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void concentrar() {
        System.out.println(nombre + " está concentrando.");
    }

    public void viajar() {
        System.out.println(nombre + " está viajando.");
    }

    public void entrenar() {
        System.out.println(nombre + " está entrenando.");
    }
}

// Subclase Jugador
class Jugador extends Persona {
    private String posicion;
    private int dorsal;
    private int golesAnotados;

    public Jugador(String nombre, int edad, String posicion, int dorsal, int golesAnotados) {
        super(nombre, edad);
        this.posicion = posicion;
        this.dorsal = dorsal;
        this.golesAnotados = golesAnotados;
    }

    public String getPosicion() {
        return posicion;
    }

    public int getDorsal() {
        return dorsal;
    }

    public int getGolesAnotados() {
        return golesAnotados;
    }

    public void jugarPartido() {
        System.out.println(getNombre() + " está jugando un partido.");
    }

    @Override
    public void entrenar() {
        System.out.println(getNombre() + " está entrenando en la posición " + posicion + ".");
    }
}

// Subclase Entrenador
class Entrenador extends Persona {
    private int añosExperiencia;
    private String titulo;
    private String nombreEquipo;

    public Entrenador(String nombre, int edad, int añosExperiencia, String titulo, String nombreEquipo) {
        super(nombre, edad);
        this.añosExperiencia = añosExperiencia;
        this.titulo = titulo;
        this.nombreEquipo = nombreEquipo;
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    @Override
    public void concentrar() {
        System.out.println(getNombre() + " está concentrando con el equipo " + nombreEquipo + ".");
    }
}

// Subclase Masajista
class Masajista extends Persona {
    private int añosExperiencia;
    private List<String> certificados;
    private String especialidad;

    public Masajista(String nombre, int edad, int añosExperiencia, List<String> certificados, String especialidad) {
        super(nombre, edad);
        this.añosExperiencia = añosExperiencia;
        this.certificados = certificados;
        this.especialidad = especialidad;
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public List<String> getCertificados() {
        return certificados;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}

// Subclase Utilero
class Utilero extends Persona {
    private int añosExperiencia;
    private String funciones;
    private String categoria;

    public Utilero(String nombre, int edad, int añosExperiencia, String funciones, String categoria) {
        super(nombre, edad);
        this.añosExperiencia = añosExperiencia;
        this.funciones = funciones;
        this.categoria = categoria;
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public String getFunciones() {
        return funciones;
    }

    public String getCategoria() {
        return categoria;
    }
}

// Clase Equipo
class Equipo {
    private String nombreEquipo;
    private String ciudad;
    private List<Jugador> jugadores;
    private List<Persona> cuerpoTecnico;

    public Equipo(String nombreEquipo, String ciudad) {
        this.nombreEquipo = nombreEquipo;
        this.ciudad = ciudad;
        this.jugadores = new ArrayList<>();
        this.cuerpoTecnico = new ArrayList<>();
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void eliminarJugador(Jugador jugador) {
        jugadores.remove(jugador);
    }

    public void agregarCuerpoTecnico(Persona persona) {
        cuerpoTecnico.add(persona);
    }

    public void concentrarEquipo() {
        for (Persona persona : jugadores) {
            persona.concentrar();
        }
        for (Persona persona : cuerpoTecnico) {
            persona.concentrar();
        }
    }

    public void viajarEquipo() {
        for (Persona persona : jugadores) {
            persona.viajar();
        }
        for (Persona persona : cuerpoTecnico) {
            persona.viajar();
        }
    }

    public void entrenarEquipo() {
        for (Persona persona : jugadores) {
            persona.entrenar();
        }
        for (Persona persona : cuerpoTecnico) {
            persona.entrenar();
        }
    }

    public void jugarPartido() {
        for (Jugador jugador : jugadores) {
            jugador.jugarPartido();
        }
    }

    public void mostrarGoles() {
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getNombre() + " ha anotado " + jugador.getGolesAnotados() + " goles.");
        }
    }

    public void mostrarJugadoresPorPosicion() {
        Collections.sort(jugadores, Comparator.comparing(Jugador::getPosicion));
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getNombre() + " juega en la posición " + jugador.getPosicion() + ".");
        }
    }
}

public class Trabajo4 {
    public static void main(String[] args) {
        // Crear el equipo
        Equipo equipo = new Equipo("Los Guerreros", "Ciudad Fantástica");

        // Crear jugadores
        Jugador jugador1 = new Jugador("Juan", 25, "Delantero", 10, 15);
        Jugador jugador2 = new Jugador("Pedro", 28, "Defensa", 4,
