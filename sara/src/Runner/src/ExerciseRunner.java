import java.util.Scanner;

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
	
	public ExerciseRunner(String name, String number, String time, boolean shirt)
	{
		super();
		orderedShirt = shirt;
		
	}

	@Override
	public String GetRunnerDescription() 
	{
		// sätter ett ja eller nej istället för true/false i utskriften
		String shirtText = "Nej"; 
		if (orderedShirt)
		{
		   shirtText = "Ja";
		}	
		// utskriftsformatering
		 String returnValue = String.format("\nNamn: %s \n Startnummer: %s \n Tid: %s \n T-shirt: %s \n",
											runnerName, startNumber, runTime, shirtText);
		return returnValue;
	}

	
	@Override
	public void SetRunnerInfo()
	{
		super.SetRunnerInfo();
		orderedShirt = false;
		Scanner Keyboard = new Scanner(System.in);
		System.out.println("Beställt t-shirt: ");
		String answer = Keyboard.nextLine();  // för att se om boolean-variablen av t-shirten ska vara sann eller falsk
		if(answer.startsWith("J") || answer.startsWith("j"))
		{
			orderedShirt = true; 
		}
	}

}






