import java.util.Scanner;

public class TravelToSpace {
    public static void main(String[] args) {
 //realizamos un show menu       
    }
    public static void ShowMenu() {
        System.out.println("\n---WELCOME TO OUR INTERPLANETARY JOURNEY---- ");
        System.out.println("\n --- Main Menu----");
        System.out.println("1. select the planet you want to visit");
        System.out.println("2. Select a spaceship");
        System.out.println("3. start our interplanetary journey");
        System.out.println("4. I'M NOT READY! I WANT TO GO OUT");
        System.out.println("please choose an option: ");
        }
        // declaro un arreglo de los planetas que hay - definimos los planetas
static String[] planet = { "Mars", "Mercury", "Saturn", "Jupiter", "Neptune", "Venus", "Uranus" };
// vamos a declarar un conjunto de naves dispuestas para el viaje
 static String[] spaceships = { "Atlantis", "Discovery", "Death-Star", "Galactica" };
// hacemos las distancias con double
static Double[] distance = { 54.6, 91.7, 1345.0, 965.0, 4351.0, 61.0, 2723.0 };
// aplicamos velocidades a cada una de las naves
static Double[] speed = { 1000.0, 2100.0, 2700.0, 3400.0 };

 static Scanner scanner = new Scanner(System.in);
    }
    public static void main(String[] args) throws Exception {
        int option;
        do {
            //realizamos metodo
        ShowMenu();
        option = scanner.nextInt();
        switch (option) {
                case 1:
                        printPlanetString();
                break;
                case 2:
                        selectionSpaceships();
                break;
                        
                default:
                break;
        }
        } while (option != 4);
         System.out.println("Have a good trip, maybe another time.");
        }
        
