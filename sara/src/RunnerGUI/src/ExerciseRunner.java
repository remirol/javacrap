
public class ExerciseRunner extends Runner
{
	// variabler
	private boolean orderedShirt;
	
	// konstruktorer
	public ExerciseRunner()
	{
		super();
		orderedShirt = false;
		
	}
	
	 public ExerciseRunner(String name, String number, int time, boolean shirt)
	 {
	  super(name, number, time);
	  orderedShirt = shirt;
	  
	 }

	 @Override
	 public String GetRunnerDescription()
	    {
		 
		 return "Namn: " + this.runnerName + "\n"
	    + "Startnummer: " + this.startNumber + "\n"
		+ "Tid: " + this.runTime + "\n" 
	    + "Shirt: " + this.orderedShirt;
	    }
	
}



