
import java.util.Scanner;

//  [] {} \
public class cielo { // escribimos las acciones y las modulamos para estructurar mejor

        
// declaro un arreglo de los planetas que hay - definimos los planetas
static String[] planetas = { "Mars", "Mercury", "Saturn", "Jupiter", "Neptune", "Venus", "Uranus" };
// vamos a declarar un conjunto de naves dispuestas para el viaje
 static String[] naves = { "Atlantis", "Discovery", "Death-Star", "Galactica" };
// hacemos las distancias con double
static Double[] distancias = { 54.6, 91.7, 1345.0, 965.0, 4351.0, 61.0, 2723.0 };
// aplicamos velocidades a cada una de las naves
static Double[] velocidades = { 20000.0, 30000.0, 50000.0, 75000.0 };// Velocidad en km/h

public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        int planetaSeleccionado = -1;
        int naveSeleccionada = -1;
        int pasajeros = 0;

        while (!salir) {
            System.out.println("\n=== Menú de Viaje Interplanetario ===");
            System.out.println("1. Seleccionar un planeta de destino");
            System.out.println("2. Seleccionar una nave espacial");
            System.out.println("3. Iniciar la simulación del viaje");
            System.out.println("4. Salir del programa");
            System.out.print("Elige una opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    planetaSeleccionado = seleccionarPlaneta(sc);
                    break;
                case 2:
                    if (planetaSeleccionado != -1) {
                        naveSeleccionada = seleccionarNave(sc);
                        pasajeros = ingresarPasajeros(sc);
                    } else {
                        System.out.println("Primero debes seleccionar un planeta.");
                    }
                    break;
                case 3:
                    if (planetaSeleccionado != -1 && naveSeleccionada != -1) {
                        iniciarSimulacion(planetaSeleccionado, naveSeleccionada, pasajeros);
                    } else {
                        System.out.println("Debes seleccionar un planeta y una nave antes de iniciar el viaje.");
                    }
                    break;
                case 4:
                    salir = true;
                    System.out.println("¡Gracias por usar el sistema de Viaje Interplanetario!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }
        }
        sc.close();
    }

    // Métodos
    public static int seleccionarPlaneta(Scanner sc) {
        System.out.println("\n=== Selección de Planeta ===");
        for (int i = 0; i < planetas.length; i++) {
            System.out.printf("%d. %s (%.1f millones de km)\n", i + 1, planetas[i], distancias[i]);
        }
        System.out.print("Elige un planeta: ");
        int opcion = sc.nextInt();
        if (opcion >= 1 && opcion <= planetas.length) {
            System.out.printf("Has seleccionado: %s\n", planetas[opcion - 1]);
            return opcion - 1;
        } else {
            System.out.println("Opción no válida. Intenta nuevamente.");
            return -1;
        }
    }

    public static int seleccionarNave(Scanner sc) {
        System.out.println("\n=== Selección de Nave ===");
        for (int i = 0; i < naves.length; i++) {
            System.out.printf("%d. %s (Velocidad: %.1f km/h)\n", i + 1, naves[i], velocidades[i]);
        }
        System.out.print("Elige una nave: ");
        int opcion = sc.nextInt();
        if (opcion >= 1 && opcion <= naves.length) {
            System.out.printf("Has seleccionado: %s\n", naves[opcion - 1]);
            return opcion - 1;
        } else {
            System.out.println("Opción no válida. Intenta nuevamente.");
            return -1;
        }
    }

    public static int ingresarPasajeros(Scanner sc) {
        System.out.print("\nIngresa la cantidad de pasajeros: ");
        int pasajeros = sc.nextInt();
        if (pasajeros > 0) {
            System.out.printf("Cantidad de pasajeros: %d\n", pasajeros);
            return pasajeros;
        } else {
            System.out.println("La cantidad de pasajeros debe ser positiva.");
            return ingresarPasajeros(sc);
        }
    }

    public static void iniciarSimulacion(int planetaSeleccionado, int naveSeleccionada, int pasajeros) {
        System.out.println("\n=== Iniciando Simulación ===");
        double distancia = distancias[planetaSeleccionado] * 1_000_000; // Convertir a kilómetros
        double velocidad = velocidades[naveSeleccionada];
        double duracion = distancia / velocidad; // Duración en horas
        double duracionDias = duracion / 24; // Convertir a días

        System.out.printf("Destino: %s\n", planetas[planetaSeleccionado]);
        System.out.printf("Nave: %s\n", naves[naveSeleccionada]);
        System.out.printf("Distancia: %.1f km\n", distancia);
        System.out.printf("Duración estimada del viaje: %.1f días\n", duracionDias);
        System.out.println("Simulación en progreso:");

        for (int i = 0; i <= 100; i += 20) {
            System.out.printf("Progreso: %d%%\n", i);
            try {
                Thread.sleep(1000); // Pausa de 1 segundo para simular progreso
            } catch (InterruptedException e) {
                System.out.println("Error en la simulación.");
            }
        }
        System.out.println("¡Has llegado a tu destino!");
    }
}
