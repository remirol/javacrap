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
	public void addEliteRunner(String name, String number, int time, String club, String license)
	{
		runners.add(new EliteRunner(name, number, time, club, license));
		
	}
	public void addExersiceRunner(String name, String number, int time, boolean shirt)
	{
		runners.add(new ExerciseRunner(name, number, time, shirt));
	}
	
	
	
}