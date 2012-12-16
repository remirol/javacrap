
public abstract class Runner
{
	protected String startNumber;
	protected String runnerName;
	protected int runTime;
	
	public abstract String GetRunnerDescription();
	
	
	 // konstruktorer
	public Runner()
	{
		startNumber = "";
		runnerName = "";
		runTime = 0;
	}
	
	public Runner(String name, String number, int time)
	{
		startNumber= number;
		runnerName = name;
		runTime = time; 
		
	}
	
}

