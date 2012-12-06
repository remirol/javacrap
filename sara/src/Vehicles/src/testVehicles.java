import java.util.Scanner; 
import java.util.ArrayList;

public class testVehicles {

	
	public static void main(String[] args) {
		
		
		Scanner keyboard = new Scanner(System.in); 
		ArrayList<Vehicles> vehicles = new ArrayList<Vehicles>(20); // stod inget i uppgiften om hur stor den skall vara, så jag höftade på 20
		int choice = 0; 
		
		System.out.println("BIL OCH MOTORCYKELREGISTER");
		System.out.println("--------------------------");
		System.out.println();
		
		while(choice != 8)
		{
			
			choice = menu(keyboard);
			switch(choice)
			{
			case 1:
				addMotorCycle(keyboard, vehicles);
				break;
			case 2:
				addCar(keyboard, vehicles); 
				break;
			case 3:
				showRegistery(vehicles);
				break;
			case 4:
				showCars(vehicles); 
				break;
			case 5:
				showMotorCycles(vehicles);
				break;
			case 6:searchByBrand(vehicles, keyboard);
				break;
			case 7:searchByPrice(vehicles, keyboard);
				break;
			case 8:
				break;
			
			}
		}
	}
	
	public static int menu(Scanner Keyboard)
	{
		int choice = 0; 
		System.out.println("1. lägg in en motorcykel");
		System.out.println("2. lägg in en bil");
		System.out.println("3. lista allt i registret");
		System.out.println("4. lista alla bilar");
		System.out.println("5. lista alla motorcyklar");
		System.out.println("6. söka på märke");
		System.out.println("7. söka i ett prisintervall");
		System.out.println("8. avsluta ");
		System.out.println();
		System.out.println("Ditt val: ");
		choice = Keyboard.nextInt();
		Keyboard.nextLine(); 
		System.out.println();
		return choice; 
	}
	
	
	public static void addMotorCycle(Scanner keyboard, ArrayList <Vehicles>vehicles)
	{
		System.out.println("Märke: ");
		String brand = keyboard.nextLine();
		System.out.println("Registreringsnummer: ");
		String licPlate = keyboard.nextLine();
		System.out.print("Pris: ");
		int price = keyboard.nextInt();
		keyboard.nextLine(); // för att inte äta upp enter
		System.out.println("Motorvolym: ");
		int engineVol = keyboard.nextInt();
		keyboard.nextLine(); // för att inte äta upp enter
		System.out.println();
		
		MotorCycle temp = new MotorCycle(brand, licPlate, price, engineVol);
		vehicles.add(temp);
		
	}
	public static void addCar(Scanner keyboard, ArrayList <Vehicles>vehicles)
	{
		System.out.println("Märke: ");
		String brand = keyboard.nextLine();
		System.out.println("Registreringsnummer: ");
		String licPlate = keyboard.nextLine();
		System.out.println("Pris: ");
		int price = keyboard.nextInt();
		keyboard.nextLine(); 
		System.out.println("Storlek: ");
		String size = keyboard.nextLine();
		System.out.println("Antal dörrar");
		int nrOfDoors = keyboard.nextInt(); 
		keyboard.nextLine(); // inte äta enter
		System.out.println();
		
		Car temp = new Car( brand, licPlate, price, size, nrOfDoors);
		vehicles.add(temp);		
		
	}
	
	// visa hela registret
	public static void showRegistery(ArrayList<Vehicles> vehicles)
	{
		for (Vehicles m: vehicles) 
		{
			System.out.println(m.toString());
		}
			
	}
	// visa bara bilar
	public static void showCars(ArrayList<Vehicles> vehicles)
	{
		for (Vehicles m: vehicles)
		{
			if (m instanceof Car) // släpp bara igenom bilar
			{
				System.out.println(m.toString()); // visa bilarna
			}
		}
	}
	// visa bara motorcyklar
	public static void showMotorCycles(ArrayList<Vehicles> vehicles)
	{
		for ( Vehicles m: vehicles)
		{
			// släpp bara igenom motorcyklar
			if(m instanceof MotorCycle) 
			{
				System.out.println(m.toString()); // visa motorcyklarna
			}
		}
	}
	public static void searchByBrand(ArrayList<Vehicles> vehicles, Scanner keyboard)
	{
		System.out.println("Märke: ");
		String brand = keyboard.nextLine(); 
		
			for(Vehicles m: vehicles)
			{
				// kolla att bara rätt märke kommer igenom
				if(m.isbrand(brand)) 
				{
					System.out.println(m.toString()); // visa märkena
				}
			}
	}
	
	// sök via prisintervall
	public static void searchByPrice(ArrayList<Vehicles> vehicles, Scanner keyboard)
	{
		
		// output till användare
		System.out.println("Lägsta pris: ");
		int lowPrice = keyboard.nextInt(); 
		keyboard.nextLine(); 
		System.out.println("Högsta pris: ");
		int highPrice = keyboard.nextInt();
		keyboard.nextLine();
		
			for(Vehicles m: vehicles)
			{
				// kolla att bara rätt prisIntevall kommer igenom
				if (m.inPriceRange(lowPrice, highPrice)) 
				{
					System.out.println(m.toString()); // visa alternativ som klarar pris. 
				}
			}
		
	}
}
