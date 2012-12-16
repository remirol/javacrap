import java.util.Scanner;
import java.util.ArrayList;

public class Registry {
	public static void main(String args[])
    {
		// variabler
        Scanner keyboard = new Scanner(System.in);
        int choice = -1;
        boolean found  = false;
        ArrayList<Vehicle> registry = new ArrayList<Vehicle>(10);

        System.out.println("FORDONSREGISTER");
        System.out.println("---------------");

        while (choice != 0)
        {
            choice = menu(keyboard);

            switch (choice)
            {
                case 1:
                    addMotorbike(keyboard, registry);
                    break;
                case 2:
                    addCar(keyboard, registry);
                    break;
                case 3:
                    showRegistry(registry);
                    break;
                case 4:
                    showCars(registry);
                    break;
                case 5:
                    showMotorbikes(registry);
                    break;
                case 6:
                    found = searchByBrand(keyboard, registry);
                    if(!found)
                        System.out.println("Criteria desired was not found");
                    break;
                case 7:
                    found = searchByPrice(keyboard, registry);
                    if(!found)
                        System.out.println("Criteria desired was not found.");
                    break;
                case 0:
                    break;

                default:
                    System.out.println("Invalid input, try again.");
                    break;
            }
        }
    }

    public static int menu(Scanner keyboard)
    {
        System.out.println("1. Lägg in en motorcykel");
        System.out.println("2. Lägg in en bil");
        System.out.println("3. Lista allt i registret");
        System.out.println("4. Lista alla bilar i registret");
        System.out.println("5. Lista alla motorcyklar i registret");
        System.out.println("6. Sök på märke");
        System.out.println("7. Sök på prisintervall");
        System.out.println("0. Avsluta");
        System.out.println();
        System.out.print("välj (0-7, 0 avslutar): ");

        int choice = keyboard.nextInt();
        keyboard.nextLine(); // töm buffert, inte nödvändigt, men likaväl

        return choice;
    }

    // lägg till motorcykel
    public static void addMotorbike(Scanner keyboard, ArrayList<Vehicle> registry)
    {
        System.out.println();
        System.out.print("Märke: ");
        String brand = keyboard.nextLine();
        System.out.print("Registreringsnummer: ");
        String registration = keyboard.nextLine();
        System.out.print("Pris: ");
        int price = keyboard.nextInt();
        keyboard.nextLine();
        System.out.print("Motorvolym: ");
        int volume = keyboard.nextInt();
        keyboard.nextLine();

        registry.add(new Motorbike(brand, registration, price, volume));
    }
    // lägg till bil
    public static void addCar(Scanner keyboard, ArrayList<Vehicle> registry)
    {
        System.out.println();
        System.out.print("Märke: ");
        String brand = keyboard.nextLine();
        System.out.print("Registreringsnummer: ");
        String registration = keyboard.nextLine();
        System.out.print("Pris: ");
        int price = keyboard.nextInt();
        keyboard.nextLine();
        System.out.print("Storlek på bil (Small, Medium, Large): ");
        String size = keyboard.nextLine();
        System.out.print("Antal dörrar: ");
        int doors = keyboard.nextInt();
        keyboard.nextLine();

        registry.add(new Car(brand, registration, price, size, doors));
    }
    // visa registret
    public static void showRegistry(ArrayList<Vehicle> registry)
    {
        System.out.println("");
        for (Vehicle v : registry)
        {
            System.out.println(v);
        }
    }
     // visa bilar
    public static void showCars(ArrayList<Vehicle> registry)
    {
        for(int i = 0; i < registry.size(); i++)
        {
            if(registry.get(i) instanceof Car)
            {
                Vehicle v = (Car)registry.get(i);
                System.out.println(v);
            }
        }        
    }
     // visa motorcyklar
    public static void showMotorbikes(ArrayList<Vehicle> registry)
    {
        for(int i = 0; i < registry.size(); i++)
        {
            if(registry.get(i) instanceof Motorbike)
            {
                Vehicle v = (Motorbike)registry.get(i);
                System.out.println(v);
            }
        }
    }
     // sök på märke
    public static boolean searchByBrand(Scanner keyboard, ArrayList<Vehicle> registry)
    {
        System.out.print("Märke att söka på: ");
        String input = keyboard.nextLine();
        boolean found = false;
        for(Vehicle v: registry)
        {
            if(v.getBrand().compareToIgnoreCase(input) == 0)
            {
                System.out.println(v);
                found = true;
            }
        }
        return found;
    }
    // sök på prisgrupp
    public static boolean searchByPrice(Scanner keyboard, ArrayList<Vehicle> registry)
    {
        System.out.print("Lägsta pris: ");
        int lowPrice = keyboard.nextInt();
        keyboard.nextLine();
        System.out.print("Högsta pris: ");
        int highPrice = keyboard.nextInt();
        keyboard.nextLine();
        boolean found = false;
        
        for(Vehicle v: registry)
        {
            if(v.inPriceRange(lowPrice, highPrice))
            {
                System.out.println(v);
                found = true;
            }
        }
        return found;
    }
}
