import java.util.Random;
import java.util.Scanner;

public class TravelToSpace {
    // Variables principales del estado del viaje
    private static int HealthStatus = 100; // Estado de salud de la tripulación
    private static int fuel = 100; // Combustible restante (%)
    private static int meal = 100; // Comida restante (%)
    private static int water = 100; // Agua restante (%)
    private static boolean spaceshipDestination = false; // Indica si se ha llegado al destino

    // Definición de planetas y distancias (en millones de km)
    private static final String[] planet = {"Mars", "Venus", "Saturn", "Jupiter", "Neptune", "Mercury", "Uranus"};
    private static final double[] distance = {54.6, 61.0, 1345.0, 965.0, 4351.0, 91.7, 2723.0}; 

    // Naves espaciales y velocidades (en km/h)
    private static final String[] spaceships = {"Atlantis", "Discovery", "Death Star", "Galactica"};
    private static final double[] speed = {1000.0, 2100.0, 2700.0, 3400.0};

    // Variables de selección del usuario
    private static int selectedPlanetIndex = -1; // Índice del planeta seleccionado
    private static int selectedSpaceshipIndex = -1; // Índice de la nave seleccionada

    // Objetos auxiliares
    private static final Random rand = new Random(); // Generador de eventos aleatorios
    private static final Scanner scanner = new Scanner(System.in); // Entrada del usuario

    public static void main(String[] args) {
        System.out.println("---WELCOME TO OUR INTERPLANETARY JOURNEY---"); // Mensaje de bienvenida

        // Bucle principal del programa
        while (true) {
            ShowMenu(); // Mostrar el menú principal
            int option = entranceValide(scanner, 1, 6); // Leer opción válida del usuario
            switch (option) {
                case 1:
                    selectPlanet(); // Selección de planeta
                    break;
                case 2:
                    selectSpaceship(); // Selección de nave espacial
                    break;
                case 3:
                    if (selectedPlanetIndex == -1 || selectedSpaceshipIndex == -1) {
                        // Validar que se haya seleccionado un planeta y nave antes de comenzar el viaje
                        System.out.println("Please select a planet and spaceship before starting the journey!");
                    } else {
                        startOurInterPlanetaryJourney(); // Comenzar el viaje
                    }
                    break;
                case 4:
                    adjustResources(); // Ajustar recursos del viaje
                    break;
                case 5:
                    showTripStatus(); // Mostrar el progreso actual del viaje
                    break;
                case 6:
                    System.out.println("Exiting the program. Safe travels!"); // Salir del programa
                    return; // Terminar el programa
                default:
                    System.out.println("Invalid option. Try again."); // Manejo de entrada inválida
            }
        }
    }

    // Método para mostrar el menú principal
    private static void ShowMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Select the planet you want to visit");
        System.out.println("2. Select a spaceship");
        System.out.println("3. Start the interplanetary journey");
        System.out.println("4. Adjust resources");
        System.out.println("5. Show journey progress");
        System.out.println("6. Exit");
        System.out.print("Please choose an option: ");
    }

    // Método para validar la entrada del usuario
    private static int entranceValide(Scanner scanner, int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input; // Retorna la opción si está dentro del rango permitido
                } else {
                    System.out.print("Please enter a number between " + min + " and " + max + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Try again: "); // Manejo de errores en la entrada
            }
        }
    }

    // Método para seleccionar un planeta
    private static void selectPlanet() {
        System.out.println("Select the planet you want to visit:");
        for (int i = 0; i < planet.length; i++) {
            System.out.println((i + 1) + ". " + planet[i]); // Lista de planetas
        }
        selectedPlanetIndex = entranceValide(scanner, 1, planet.length) - 1; // Guardar la selección
        System.out.println("You have selected: " + planet[selectedPlanetIndex]);
    }

    // Método para seleccionar una nave espacial
    private static void selectSpaceship() {
        System.out.println("Select your spaceship:");
        for (int i = 0; i < spaceships.length; i++) {
            System.out.println((i + 1) + ". " + spaceships[i]); // Lista de naves
        }
        selectedSpaceshipIndex = entranceValide(scanner, 1, spaceships.length) - 1; // Guardar la selección
        System.out.println("You have selected: " + spaceships[selectedSpaceshipIndex]);
    }

    // Método para ajustar los recursos
    private static void adjustResources() {
        System.out.print("Set the level for all resources (0-100%): ");
        int level = entranceValide(scanner, 0, 100); // Entrada para ajustar los recursos
        fuel = level;
        meal = level;
        water = level;
        System.out.println("Resources have been adjusted.");
    }

    // Método para iniciar el viaje interplanetario
    private static void startOurInterPlanetaryJourney() {
        System.out.println("Starting the journey to " + planet[selectedPlanetIndex] + " using " + spaceships[selectedSpaceshipIndex]);
        double planetDistance = distance[selectedPlanetIndex] * 1_000_000; // Distancia en kilómetros
        double spaceshipSpeed = speed[selectedSpaceshipIndex];
        double totalTravelTimeHours = planetDistance / spaceshipSpeed; // Tiempo total en horas
        double totalTravelTimeDays = totalTravelTimeHours / 24; // Tiempo total en días

        System.out.println("The journey will take approximately " + String.format("%.2f", totalTravelTimeDays) + " days.");
        System.out.println("Let's begin!");

        // Variables de progreso del viaje
        double progressPercentage = 0.0;
        double traveledDistance = 0.0;
        double dailyTravelDistance = spaceshipSpeed * 24; // Distancia diaria

        while (!spaceshipDestination) {
            if (HealthStatus <= 0 || fuel <= 0 || meal <= 0 || water <= 0) {
                // Si los recursos o la salud llegan a 0, el viaje termina
                System.out.println("\nThe journey ends due to lack of resources or health issues.");
                break;
            }

            traveledDistance += dailyTravelDistance; // Actualizar distancia recorrida
            progressPercentage = Math.min((traveledDistance / planetDistance) * 100, 100); // Calcular progreso en porcentaje
            fuel -= 5; // Reducir recursos
            meal -= 5;
            water -= 5;

            System.out.println("\nDay " + String.format("%.2f", traveledDistance / dailyTravelDistance) +
                               " - Progress: " + String.format("%.2f", progressPercentage) + "%");
            showTripStatus(); // Mostrar el estado del viaje
            simulations(); // Ejecutar eventos aleatorios

            if (progressPercentage >= 100.0) {
                spaceshipDestination = true; // Llegada al destino
                System.out.println("\nCongratulations! You have reached " + planet[selectedPlanetIndex] + ".");
                break;
            }

            System.out.println("\nWhat do you want to do?");
            System.out.println("1. Do nothing.");
            System.out.println("2. Perform maintenance.");
            System.out.println("3. Change course.");
            int option = entranceValide(scanner, 1, 3);

            switch (option) {
                case 1:
                    System.out.println("You decided to continue the journey.");
                    break;
                case 2:
                    makeRepairs(); // Realizar mantenimiento
                    break;
                case 3:
                    changeCourse(); // Cambiar rumbo
                    break;
                default:
                    System.out.println("Invalid option. Continuing journey.");
            }
        }
    }
// Método para mostrar el estado del viaje
     private static void showTripStatus() {
        System.out.println("Fuel: " + fuel + "%");
        System.out.println("Water: " + water + "%");
        System.out.println("Meal: " + meal + "%");
        System.out.println("Health: " + HealthStatus + "/100");
    }
 
// Método para eventos aleatorios durante el viaje
    private static void simulations() {
        int event = rand.nextInt(5); // Generar un evento aleatorio
        switch (event) {
            case 1:
                System.out.println("A meteorite hit the spaceship!");
                HealthStatus -= 30;
                fuel -= 10;
                water -= 10;
                meal -= 15;
                break;
            case 2:
                System.out.println("Found a supernova! Resources increased slightly.");
                fuel += 5;
                water += 5;
                meal += 5;
                break;
            case 3:
                System.out.println("Passed too close to a black hole. Fuel reduced.");
                fuel -= 20;
                break;
            case 4:
                System.out.println("Minor system failure. Health decreased.");
                HealthStatus -= 10;
                break;
            case 5:
                System.out.println("Clear skies ahead. No issues today.");
                break;
        }
    }

    // Método para realizar reparaciones
    private static void makeRepairs() {
        if (HealthStatus < 100) {
            HealthStatus += 20;
            fuel -= 10;
            meal -= 10;
            water -= 10;
            System.out.println("Repairs completed. Health improved.");
        } else {
            System.out.println("The spaceship is already in perfect condition.");
        }
    }

    // Método para cambiar el rumbo
    private static void changeCourse() {
        System.out.println("Course changed. Resources consumed.");
        fuel -= 20;
        meal -= 15;
        water -= 15;
    }
}
