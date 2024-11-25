
import java.util.Scanner;

//  [] {} \
public class TravelToSpace {
        // We write the actions and modulate them to structure them better.
public static void ShowMenu() {
        System.out.println("\n---WELCOME TO OUR INTERPLANETARY JOURNEY---- ");
        System.out.println("\n --- Main Menu----");
        System.out.println("1. select the planet you want to visit");
        System.out.println("2. Select a spaceship");
        System.out.println("3. start our interplanetary journey");
        System.out.println("4. I'M NOT READY! I WANT TO GO OUT");
        System.out.println("please choose an option: ");
        }
        
// I declare an arrangement of the planets that exist: we define the planets
static String[] planet = { "Mars", "Mercury", "Saturn", "Jupiter", "Neptune", "Venus", "Uranus" };
// We are going to declare a set of spaceships ready for the journey.
 static String[] spaceships = { "Atlantis", "Discovery", "Death-Star", "Galactica" };
// We do the distances with double
static Double[] distance = { 54.6, 91.7, 1345.0, 965.0, 4351.0, 61.0, 2723.0 };
// We apply velocities to each of the spacecraft.
static Double[] speed = { 1000.0, 2100.0, 2700.0, 3400.0 };

 static Scanner scanner = new Scanner(System.in);
public static void main(String[] args) throws Exception {
int option;
//add a new method to provide several possible options for the user to select
do {
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
//We perform private classes for each option and call the method
private static void selectionSpaceships() {
        System.out.println("Please select the spaceship you like the most: ");
        System.out.println("1. ATLANTIS");
        System.out.println("2. DISCOVERY");
        System.out.println("3. DEATH STAR");
        System.out.println("4. GALACTICA");
        int option = scanner.nextInt();
        switch (option) {
        case 1:
        System.out.println("Fabulous you chose the incredible Atlantis"); 
        break;
        case 2: 
        System.out.println("Fabulous you chose the incredible Discovery"); 
        break;
        case 3:
        System.out.println("Fabulous you chose the incredible Death star");   
        break;
        case 4:
        System.out.println("Fabulous you chose the incredible Galactica");
        break;
        default:
        System.out.println("No more spaceships, sorry.");   
        break;
        }
}

//  This is a method for selecting a planet.              
private static void printPlanetString() {
        System.out.println("Select the planet you want: ");
        System.out.println("1. The red planet: Mars");
        System.out.println("2. The Goddess Planet: Venus");
        System.out.println("3. The planet with a ring: Saturn");
        System.out.println("4. The largest planet: Jupiter");
        System.out.println("5. The most distant planet: Neptune");
        System.out.println("6. The most periodic planet: Mercury");
        System.out.println("7. The most forgotten planet: Uranus");
        System.out.println("8. I'm terrified of traveling so I'll stay on earth!!!");
        int option = scanner.nextInt();
        switch (option) {
case 1:
System.out.println("Perfect, you have selected the planet Mars.");
break;
 case 2:
System.out.println("Perfect, you have selected the planet Venus.");
 break;
case 3:
System.out.println("Perfect, you have selected the planet Saturn.");
break;
case 4:
System.out.println("Perfect, you have selected the planet Jupiter.");
break;
case 5:
System.out.println("Perfect, you have selected the planet Neptune.");
break;
case 6:
System.out.println("Perfect, you have selected the planet Mercury.");
break;
case 7:
System.out.println("Perfect, you have selected the planet Uranus");
break;
default:
 System.out.println("Wrong option, there are no planets anymore, remember?");
break;
            }
}
                

public static void selectionDestination() {
}

public static void calculateResources() {
}

public static void calculateFuel() {
}


public static void printPlanetString(String[] planets) {
}

}
