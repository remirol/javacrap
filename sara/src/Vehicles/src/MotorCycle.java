
import java.util.Scanner; 

public class MotorCycle extends Vehicles {
	
	// instansvariabel
	private int engineVol; 
	
	// konstruktorer
	public MotorCycle()
	{
		super();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Motorvolym: ");
		this.engineVol = keyboard.nextInt(); 
	}
	
	public MotorCycle(String brand, String licPlate, int price, int engineVol)
	{
		super(brand, licPlate, price);
		this.engineVol = engineVol; 
	}
	
	// get set metoder
	
	public void setEngineVol(int engineVol)
	{
		this.engineVol = engineVol; 
	}
	public int getEngineVol()
	{
		return engineVol; 
	}
	public String toString()
	{
		String str = "";
		str += super.toString();
		str += "Motorvolym: " + engineVol + "\n";
		
		return str;
	}
	
}
