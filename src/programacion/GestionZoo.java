/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion;

/**
 *
 * @author Rocio
 */
import java.io.*;
import java.util.*;

// Clase Animal (Abstracta)
abstract class Animal {
    private String codigo;
    private String nombre;
    private int edad;
    private double peso;
    private Dieta dieta;

    public Animal(String codigo, String nombre, int edad, double peso, Dieta dieta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.dieta = dieta;
    }

    public abstract String getTipo();

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public Dieta getDieta() {
        return dieta;
    }

    // Otros getters y setters omitidos por brevedad
}

// Subclases de Animal
class Mamifero extends Animal {
    public Mamifero(String codigo, String nombre, int edad, double peso, Dieta dieta) {
        super(codigo, nombre, edad, peso, dieta);
    }

    @Override
    public String getTipo() {
        return "Mamífero";
    }
}

class Ave extends Animal {
    public Ave(String codigo, String nombre, int edad, double peso, Dieta dieta) {
        super(codigo, nombre, edad, peso, dieta);
    }

    @Override
    public String getTipo() {
        return "Ave";
    }
}

class Reptil extends Animal {
    public Reptil(String codigo, String nombre, int edad, double peso, Dieta dieta) {
        super(codigo, nombre, edad, peso, dieta);
    }

    @Override
    public String getTipo() {
        return "Reptil";
    }
}

// Clase Dieta
class Dieta {
    private String codigo;
    private String tipo; // Carnívoro, Herbívoro, Omnívoro

    public Dieta(String codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCodigo() {
        return codigo;
    }
}

// Clase Cuidador
class Cuidador {
    private String codigo;
    private String nombre;
    private String especialidad;

    public Cuidador(String codigo, String nombre, String especialidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getCodigo() {
        return codigo;
    }
}

// Clase Habitat
class Habitat {
    private String codigo;
    private String nombre;
    private String tipo;
    private int capacidad;
    private List<Animal> animales;

    public Habitat(String codigo, String nombre, String tipo, int capacidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.animales = new ArrayList<>();
    }

    public boolean agregarAnimal(Animal animal) {
        if (animales.size() < capacidad) {
            animales.add(animal);
            return true;
        }
        return false;
    }

    public List<Animal> getAnimales() {
        return animales;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }
}

// Clase principal GestionZoo
public class GestionZoo {
    private List<Animal> animales;
    private List<Cuidador> cuidadores;
    private List<Habitat> habitats;
    private List<Dieta> dietas;

    public GestionZoo() {
        this.animales = new ArrayList<>();
        this.cuidadores = new ArrayList<>();
        this.habitats = new ArrayList<>();
        this.dietas = new ArrayList<>();
    }

    // Métodos para agregar elementos al zoológico
    public void agregarAnimal(Animal animal) {
        animales.add(animal);
    }

    public void agregarCuidador(Cuidador cuidador) {
        cuidadores.add(cuidador);
    }

    public void agregarHabitat(Habitat habitat) {
        habitats.add(habitat);
    }

    public void agregarDieta(Dieta dieta) {
        dietas.add(dieta);
    }

    // Buscar animales por especie o hábitat
    public List<Animal> buscarAnimalesPorEspecie(String especie) {
        List<Animal> resultado = new ArrayList<>();
        for (Animal animal : animales) {
            if (animal.getTipo().equalsIgnoreCase(especie)) {
                resultado.add(animal);
            }
        }
        return resultado;
    }

    public List<Animal> buscarAnimalesPorHabitat(String habitatNombre) {
        List<Animal> resultado = new ArrayList<>();
        for (Habitat habitat : habitats) {
            if (habitat.getNombre().equalsIgnoreCase(habitatNombre)) {
                resultado.addAll(habitat.getAnimales());
            }
        }
        return resultado;
    }

    // Listar animales bajo el cuidado de un cuidador específico
    public List<Animal> animalesPorCuidador(String cuidadorNombre) {
        List<Animal> resultado = new ArrayList<>();
        for (Cuidador cuidador : cuidadores) {
            if (cuidador.getNombre().equalsIgnoreCase(cuidadorNombre)) {
                // Implementar lógica para buscar los animales bajo su cuidado
                
            }
        }
        return resultado;
    }

    // Calcular total de animales por tipo
    public int totalAnimalesPorTipo(String tipo) {
        int total = 0;
        for (Animal animal : animales) {
            if (animal.getTipo().equalsIgnoreCase(tipo)) {
                total++;
            }
        }
        return total;
    }

    // Métodos para leer y escribir archivos CSV
    public void leerDatosDeArchivos() {
        // Implementación de lectura de CSV
        List<String[]> datosAnimales = ArchivoCSV.leerCSV("animales.csv");
        for (String[] linea : datosAnimales) {
            // Parsear y crear objetos a partir de los datos CSV
        }
    }

    public void escribirDatosAArchivos() {
        // Implementación de escritura de CSV
        List<String[]> datosAnimales = new ArrayList<>();
        for (Animal animal : animales) {
            datosAnimales.add(new String[] {
                animal.getCodigo(), animal.getNombre(), animal.getTipo()
                // Otros datos relevantes
            });
        }
        ArchivoCSV.escribirCSV("animales.csv", datosAnimales);
    }

    public static void main(String[] args) {
        GestionZoo zoo = new GestionZoo();

        //Creación y uso
        Dieta carnivoro = new Dieta("D001", "Carnívoro");
        Mamifero leon = new Mamifero("A001", "León", 5, 190.5, carnivoro);
        Habitat sabana = new Habitat("H001", "Sabana Africana", "Sabana", 10);

        zoo.agregarDieta(carnivoro);
        zoo.agregarAnimal(leon);
        zoo.agregarHabitat(sabana);

        sabana.agregarAnimal(leon);

        zoo.escribirDatosAArchivos();
    }
}

// Clase para manejar lectura/escritura de archivos CSV
class ArchivoCSV {
    public static List<String[]> leerCSV(String archivo) {
        List<String[]> datos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                datos.add(linea.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datos;
    }

    public static void escribirCSV(String archivo, List<String[]> datos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (String[] linea : datos) {
                bw.write(String.join(",", linea));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

