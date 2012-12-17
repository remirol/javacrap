import java.util.ArrayList;
import java.util.Vector;

public class Logic
{
	//Instansvariabler
	private Vector<Runner> runners;
	
	//Konstruktor
	public Logic()
	{
		runners = new Vector<Runner>();
	}
	
	//Metoder
	public void addExerciseRunner(String name, String number, String time, boolean shirt)
	{
		int runTime = Integer.parseInt(time);
		
		runners.add(new ExerciseRunner(name, number, runTime, shirt));
		
	}
	
	public void addEliteRunner(String name, String number, String time, String club, String license)
	{
		int runTime = Integer.parseInt(time);
		runners.add(new EliteRunner(name, number, runTime, club, license));
		
	}
	
	public Vector<ExerciseRunner> showAllExerciseRunners()
	{
		Vector<ExerciseRunner> ERunners = new Vector<ExerciseRunner>();
		for(Runner r : runners)
		{
			if(r.getClass() == ExerciseRunner.class)
			{
				ERunners.add((ExerciseRunner)r); // säker casting, hah
			}
		}
			return ERunners; 
	}
	// visa alla elitlöpare
	public Vector<EliteRunner> showAllEliteRunners()
	{
		Vector<EliteRunner> ElRunners = new Vector<EliteRunner>();
		for(Runner r : runners)
		{
			if(r.getClass() == EliteRunner.class)
			{
				ElRunners.add((EliteRunner)r);
				
			}
		}
		return ElRunners; 
	}
	public Vector<Runner> showAll()
	{
		
		return runners;
	}
	
	 public Vector<Runner> showBestEliteRunner()
	 {
		 
		  int fastestTime = 99999;    // Långsamt nog för att åtminstonde någon ska slå det
		  Runner dummy = null; 
			  for (Runner r : runners)
			  {
			      if(r.getClass()== EliteRunner.class)
			      {
			           if(r.runTime < fastestTime)
			          {
			                   fastestTime = r.runTime;  // reset snabbaste tiden
			                    dummy = r;                // spara kopia av nya snabbaste objektet
			          }
			       }
			  }
			
			  Vector <Runner> tempList = new Vector <Runner> ();
			  tempList.add(dummy); 
			  return tempList; 
			 
	 }
	
}