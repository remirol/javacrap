
import java.util.Scanner;

public class EliteRunner extends Runner
{
	
	// variabler
	private String clubName;
	private String licenseNumber;
	
	
	// konstruktorer
	public EliteRunner()
	{
		super();
		clubName = "";
		licenseNumber = "";
	
	}
	
	public EliteRunner(String name, String number, String time, String club, String license)
	{
		super(name, number, time);
		clubName = club;
		licenseNumber = license;
				
	}
	@Override
	public String GetRunnerDescription()
	{
		// utskiftsformatering
		String returnValue = String.format("\nNamn: %s \n Startnummer: %s \n Tid: %s \n Klubb: %s \n LicensNr: %s \n", 
											runnerName, startNumber, runTime, clubName, licenseNumber);
		return returnValue;
	}
	

	
	@Override
	public void SetRunnerInfo()
	{
		super.SetRunnerInfo(); // ärver exerciseRunners setRunner
		Scanner Keyboard = new Scanner(System.in);
		System.out.println("Klubbnamn: ");
		clubName = Keyboard.nextLine();
		System.out.println("Licensnummer: ");
		licenseNumber = Keyboard.nextLine();
		
	}

}






