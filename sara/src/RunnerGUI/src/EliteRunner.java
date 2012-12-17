
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
	
	public EliteRunner(String name, String number, int time, String club, String license)
	{
		super(name, number, time);
		clubName = club;
		licenseNumber = license;
				
	}
	@Override
	public String GetRunnerDescription()
	{
		return "Namn: " + this.runnerName +	", "
				+ "Startnummer: " + this.startNumber + ", "
				+ "Tid: " + this.runTime + ", "
				+ "Klubb: " + this.clubName + ", " +  
				"Licensnummer: " + 	this.licenseNumber  ;
	}
	
	public String toString()
	{
		
		return GetRunnerDescription();
	}
	
	
	
}






