import java.util.Scanner; 

public class Car extends Vehicles {
	
	// instansvariabler
	private String size; 
	private int nrOfDoors; 
	
	// konstruktor
	public Car()
	{
		super();
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Storlek: ");
		this.size = keyboard.nextLine();
		System.out.print("Antal d�rrar: ");
		this.nrOfDoors = keyboard.nextInt();
				
	}
	
	public Car(String brand, String licPlate, int price, String size, int nrOfDoors)
	{
		super(brand, licPlate, price);
		this.size = size;
		this.nrOfDoors = nrOfDoors;
		
	}
	
	// get set metoder
	public void setSize(String size)
	{
		this.size = size; 
	}
	
	public void setNrOfDoors(int nrOfDoors)
	{
		this.nrOfDoors = nrOfDoors; 
	}
	
	public String getSize()
	{
		return size; 
	}
	
	public int getNrOfDoors()
	{
		return nrOfDoors; 
	}
	
	// �vriga metoder
	public String toString()
	{
		String str = "";
		
		str += super.toString();
		str += "Storlek: " + size + "\n";
		str += "Antal d�rrar: " + nrOfDoors + "\n";
		
		return str; 
		
	}
	
	
	
}

