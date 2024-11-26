
import java.util.Random;
import java.util.Scanner;

//  [] {} \
public class TravelToSpace {
// We write the actions and modulate them to structure them better.
private static int distanceTotal = 100; 
private static int distanceTraveled = 0; 
// distance traveled
private static int HealthStatus = 100; 
// It is the state of each person in the crew.
//We carry out private classes to indicate the resources we need and the percentage that each one has
private static int fuel = 100;
private static int meal = 100;
private static int water = 100;
private static boolean spaceshipDestination = false;


public static void ShowMenu() {
        System.out.println("\n---WELCOME TO OUR INTERPLANETARY JOURNEY---- ");
        System.out.println("\n --- Main Menu----");
        System.out.println("1. select the planet you want to visit");
        System.out.println("2. Select a spaceship");
        System.out.println("3. start our interplanetary journey");
        System.out.println("4. I need to adjust resources");
        System.out.println("5. I want you to show me the progress of my journey.");
        System.out.println("6. I'M NOT READY! I WANT TO GO OUT");
        System.out.println("please choose an option: ");
        }
        
// I declare an arrangement of the planets that exist: we define the planets
static String[] planet = { "Mars", "Mercury", "Saturn", "Jupiter", "Neptune", "Venus", "Uranus" };
// We are going to declare a set of spaceships ready for the journey.
 static String[] spaceships = { "Atlantis", "Discovery", "Death-Star", "Galactica" };
// We do the distances with double
static Double[] distance = { 54.6, 91.7, 1345.0, 965.0, 4351.0, 61.0, 2723.0 };
// We apply velocities to each of the spacecraft.
static Double[] speed = { 10000.0, 21000.0, 27000.0, 34000.0 }; //speed km/h

static Scanner scanner = new Scanner(System.in);
public static void main(String[] args) throws Exception {
int option;
int  selectPlanet = -1;
int selectedSpaceship = -1;
int passengers = 0;
//add a new method to provide several possible options for the user to select
while(true){
ShowMenu();
int decided = entranceValide(scanner, 1, 5);
switch (decided) {
        case 1:
             selectPlanet = selectedPlanet(scanner);
        break;
        case 2:
        if (selectPlanet != -1) {
                selectedSpaceship = selectionSpaceships(scanner);
                passengers = enterPassengers(scanner);   
         }else{
        System.out.println("first you have to select a planet");
         }
                        
        break;
         case 3:
        if (selectPlanet != -1 && selectedSpaceship != -1) {
        startOurInterPlanetaryJourney(selectPlanet, selectedSpaceship, passengers);
        } else {
        System.out.println("You must select a planet and a ship before starting the journey.");
        }
        break;
                                 
        case 4: 
        resources(scanner);
        break;      
        default:
        System.out.println("invalid option");
        break;
         }
        }
        }
                             
private static int enterPassengers(Scanner scanner) {
        System.out.print("\nIngresa la cantidad de pasajeros: ");
        int passengers = scanner.nextInt();
        if (passengers > 0) {
            System.out.printf("Cantidad de pasajeros: %d\n", passengers);
            return passengers;
        } else {
            System.out.println("La cantidad de pasajeros debe ser positiva.");
            return enterPassengers(scanner);
        }
}
////  This is a method for selecting a planet.        
private static int selectedPlanet(Scanner scanner) {
System.out.println("\n=== planet selection ===");
for (int i = 0; i < planet.length; i++) {
 System.out.printf("%d. %s (%.1f millions of km)\n", i + 1, planet[i], distance[i]);
}
System.out.print("choose a planet please: ");
int opcion = scanner.nextInt();
if (opcion >= 1 && opcion <= planet.length) {
System.out.printf("you have selected: %s\n", planet[opcion - 1]);
return opcion - 1;
} else {
System.out.println("This option is not valid. I'm sorry");
return -1;
}
        
}
             
 private static int entranceValide(Scanner scanner, int min, int max) {
int entrance;
while (true) {
try {
//Integer.parseInt(...) intenta convertir esa entrada de texto en un número entero (int).
entrance = Integer.parseInt(scanner.nextLine());
if (entrance >= min && entrance <= max) {
return entrance;
} else {
System.out.print("Por favor, ingrese un número entre " + min + " y " + max + ": ");
}
//In this case, the catch block catches the exception and displays a message to the user 
//indicating that the input is invalid. The loop then repeats, again asking the user to try valid input.
} catch (NumberFormatException e) {
System.out.print("Entrada no válida. Intente nuevamente: ");
 }
 }
}

//We create a method so that the user can choose their resources  
private static void resources(Scanner scanner) {
 System.out.print("How many resources do you need for each element (0-100 %)?");   
 int amount = entranceValide(scanner, 0, 100);
 fuel = amount;
 water = amount;
 meal = amount;
 System.out.println("you have adjusted the fuel to: "+ fuel + "%");   
 System.out.println("you have adjusted the water to: "+ water + "%");     
 System.out.println("have you adjusted the food to: "+ meal + "%");  
 }
           
//start with the journey
private static void startOurInterPlanetaryJourney(int selectedPlanet, int selectedSpaceship, int passengers) {
System.out.println("Please fasten your seatbelts, the journey has begun");  
while (!spaceshipDestination && HealthStatus > 0 && fuel > 0 && meal > 0 && water > 0){
 simulations();
 showTripStatus();
 // Options menu for the crew member.
 System.out.printf("Destino: %s\n", planet[selectedPlanet]);
 System.out.printf("Nave: %s\n", spaceships[selectedSpaceship]);
 System.out.printf("Distance: %.1f km\n", distance[distanceTraveled]);

 System.out.println("Simulación en progreso:");
 System.out.println("\n What do you want to do?");
System.out.println("1. I choose to do nothing and just observe.");
System.out.println("2. I'm going to perform maintenance on the spaceship.");
System.out.println("3. I'm going to change course");
int option= entranceValide(scanner, 1, 3);
     switch (option) {
    case 1:
    System.out.println("You decided to do nothing and watch."); 
     break;
     case 2:
    if (fuel >= 10) {
     makeRepairs();   
    }else{
     System.out.println("You no longer have resources!!!!");
     }
     case 3: 
    changeCourse();
     break;            
    default:
System.out.println("This option is not valid");
 break;

 }
 //trip in progress
distanceTraveled += 10;
fuel -= 5;
meal -= 5;
water -= 5;  
                
if(distanceTraveled >= distanceTotal){
spaceshipDestination = true;
 System.out.println("Congratulations, you have successfully reached your destination.");
 }
 }   
 //We use the following cycle to define the limit of the special trip, when the resources are less than or equal to 0
if(HealthStatus <= 10){
System.out.println("The spaceship has just suffered permanent damage. This is the end of your journey");    
}else if (fuel > 0 && meal > 0 && water > 0){
System.out.println("Sorry, you're out of resources.The journey is over");
}
}
private static void showTripStatus() {
//We created a method to show the journey of space travel and everything that is being done          
double progress = (double)distanceTraveled / distanceTotal * 100;
System.out.println("\n space travel progress: " + String.format("%.2f", progress) + "%");
System.out.println("This is your available fuel: " + fuel);
System.out.println("This is your water level: " + water);
System.out.println("This is your food level: " + meal);
System.out.println("this is your state: " + HealthStatus + "/100");
        }
        
                //creation of random events or simulations 
         private static final Random rand = new Random();
 private static void simulations() {
    int events = rand.nextInt(5);  
    //We will use 5 possible event simulations.
switch (events) {
case 1:
System.out.println("The spacecraft suffered a system failure. Your health has been affected."); 
HealthStatus -=20; 
break;
case 2:
System.out.println("You have found a supernova!!!"); 
System.out.println("you have gained more speed");
fuel +=10;
break;
case 3:
System.out.println("DANGER!!! A meteorite collided with the spacecraft.");
HealthStatus -=30;
fuel -=10;
water -=10;
meal -=15;
System.out.println("We lose resources");    
break;
case 4:
 System.out.println("We pass too close to a black hole and lose fuel."); 
fuel -=20;
break;
case 5:
System.out.println("! A shooting star has passed very close! the spaceship continues on its way"); 
break;

}      
}
//We created a new method to change course.
private static void changeCourse() {
    distanceTraveled += 20;
    fuel -= 20;
    meal -=15;
    water -=15;  
    System.out.println("We inform you that we have successfully changed course.");                   
}
                //We created a method to be able to maintain the spaceship.
private static void makeRepairs() {
 if (HealthStatus < 100) {
    HealthStatus += 20;
    fuel -= 10;
    meal -= 10;
    water -= 10;
 }else{
    System.out.println("You have repaired the spaceship and improved its condition.");
 }
    System.out.println("Perfect, you've fixed the spaceship and your resources are perfect.");   
 }                         



//We perform private classes for each option and call the method
private static int selectionSpaceships(Scanner scanner) {
       
        System.out.println("\n=== Please select the spaceship you like the most: ===");
        for (int i = 0; i < spaceships.length; i++) {
            System.out.printf("%d. %s (Speed: %.1f km/h)\n", i + 1, spaceships[i], speed[i]);
        }
        System.out.print("Elige una nave: ");
        int opcion = scanner.nextInt();
        if (opcion >= 1 && opcion <= spaceships.length) {
            System.out.printf("Has seleccionado: %s\n", spaceships[opcion - 1]);
            return opcion - 1;
        } else {
            System.out.println("Opción no válida. Intenta nuevamente.");
            return -1;
        }
    }            
}
