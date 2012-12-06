import java.util.Scanner; 

public abstract class Runner
{
	// variabler
	protected String startNumber;
	protected String runnerName;
	protected String runTime;
	
	public abstract String GetRunnerDescription();
	
	public void SetRunnerInfo()
	{
		Scanner Keyboard = new Scanner(System.in); 
		System.out.println("Löparens namn: ");
		runnerName = Keyboard.nextLine();
		System.out.println("Startnummer: ");
		startNumber = Keyboard.nextLine();
		System.out.println("Tid: ");
		runTime = Keyboard.nextLine(); 
		
	}
	 // konstruktorer
	public Runner()
	{
		startNumber = "";
		runnerName = "";
		runTime = "";
	}
	
	public Runner(String name, String number, String time)
	{
		startNumber= number;
		runnerName = name;
		runTime = time; 
		
	}
	
}




