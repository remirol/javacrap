
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
		 
		 return "Namn: " + this.runnerName + ", "
	    + "Startnummer: " + this.startNumber + ", "
		+ "Tid: " + this.runTime + ", " 
	    + "Shirt: " + this.orderedShirt;
	    }
	 
	 @Override
	 public String toString()
	 {
		 
		 return GetRunnerDescription(); 
	 }
	
}



