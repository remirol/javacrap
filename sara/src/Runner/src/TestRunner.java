import java.util.Scanner; 
import java.util.ArrayList; 

public class TestRunner {
	// vet ej om detta �r okej, men det ger global scope, minimerar
	// on�digt m�nga anrop p� den. 
	public static ArrayList<Runner> allRunners; 
	
	public static void main(String[] args) {
		
		// variabler
		Scanner keyboard = new Scanner(System.in);
		allRunners = new ArrayList<Runner>();
		int choice = 0;
				
		System.out.println("Lista �ver motions- och elitl�pare");
		System.out.println("----------------------------------");
		System.out.println();
		
		while(choice != 6)
		{
			choice = menu(keyboard);
			switch(choice)
			{
			case 1: addExerciseRunner(); 
				break;
			case 2: addEliteRunner();
				break;
			case 3:showAllExerciseRunners();
				break;
			case 4:showAllEliteRunners();
				break;
			case 5: showAll();
				break;
			case 6: 
				System.out.println("Du har valt att avsluta");
				break;
			
			
			}
		}

	}
	public static int menu(Scanner keyboard)
	{
		int choice = 0;
		System.out.println("1. L�gg till motionsl�pare "); 
		System.out.println("2. L�gg till elitl�pare");  
		System.out.println("3. Visa alla motionsl�pare"); 
		System.out.println("4. Visa alla elitl�pare"); 
		System.out.println("5. Visa alla l�pare"); 
		System.out.println("6. Avsluta");
		System.out.println();
		System.out.println("Ditt val: ");
		System.out.println();
		choice = keyboard.nextInt();
		return choice; 
		
		
		
	}
	// l�gg till motionsl�pare 
	 public static void addExerciseRunner()
	 {  
	  ExerciseRunner twoRunner = new ExerciseRunner();
	  twoRunner.SetRunnerInfo();
	        allRunners.add(twoRunner);  
	 }
	// l�gg till elitl�pare
	public static void addEliteRunner()
	{
		 EliteRunner oneRunner = new EliteRunner();
		 oneRunner.SetRunnerInfo();
	     allRunners.add(oneRunner);
	        
	}
	// visa alla motionsl�pare
	public static void showAllExerciseRunners()
	{
		for(Runner token : allRunners)
		{
			if(token.getClass() == ExerciseRunner.class)
			{
				System.out.println(token.GetRunnerDescription()); 
			}
		}
		
	}
	// visa alla elitl�pare
	public static void showAllEliteRunners()
	{
		for(Runner token : allRunners)
		{
			if(token.getClass() == EliteRunner.class)
			{
				 System.out.println(token.GetRunnerDescription());
			}
		}
	}
	// visa alla l�pare
	public static void showAll()
	{
		for(Runner token : allRunners)
		{
			 if(token.getClass() == EliteRunner.class);
			System.out.println(token.GetRunnerDescription()); 
		}
	}


}
