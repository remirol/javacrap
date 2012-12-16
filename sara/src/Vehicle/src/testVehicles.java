import java.util.Scanner; 
import java.util.ArrayList;

public class testVehicles {

	
	public static void main(String[] args) {
		/*ArrayList<Media> medias = new ArrayList<Media>(20);*/
		
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
				addMotorCycle(keyboard);
				break;
			case 2:
				addCar(keyboard); 
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
			case 6:
				break;
			case 7:
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
		System.out.println();
		return choice; 
	}
	
	
	public static void addMotorCycle(Scanner keyboard)
	{
		System.out.println("Märke: ");
		String brand = keyboard.nextLine();
		System.out.println("Registreringsnummer: ");
		String licPlate = keyboard.nextLine();
		System.out.print("Pris: ");
		int price = keyboard.nextInt();
		System.out.println("Motorvolym: ");
		int engineVol = keyboard.nextInt();
		System.out.println();
	}
	public static void addCar(Scanner keyboard)
	{
		System.out.println("Märke: ");
		String brand = keyboard.nextLine();
		System.out.println("Registreringsnummer: ");
		String licPlate = keyboard.nextLine();
		System.out.println("Pris: ");
		int price = keyboard.nextInt();
		System.out.println("Storlek: ");
		int size = keyboard.nextInt();
		System.out.println("Antal dörrar");
		int nrOfDoors = keyboard.nextInt(); 
		System.out.println();
		
	}
	
	
	public static void showRegistery(ArrayList<Vehicles> vehicles)
	{
		for (Vehicles m: vehicles)
		{
			System.out.println(m);
		}
			
	}
	public static void showCars(ArrayList<Vehicles> cars)
	{
		for (Vehicles m: cars)
		{
			System.out.println(m);
		}
	}
	public static void showMotorCycles(ArrayList<Vehicles> motorCycles)
	{
		for (Vehicles m: motorCycles)
		{
			System.out.println(m);
		}
	}

}



