import java.util.Scanner; 

public class testLongJumper {

	
	public static void main(String[] args)
	{
		// deklarationer
		Scanner keyboard = new Scanner(System.in); 
		System.out.print("Hur m�nga l�ngdhoppare skall deltaga: ");
		final int NUMBER = keyboard.nextInt(); 
		System.out.println();
		
		longJumper longJumper[] = new longJumper[NUMBER]; 
		int choice = 1; 
		int position = 0;

		while (choice != 4)
		{
			choice = menu(keyboard);
			switch(choice)
			{
			case 1:
				if(position >= NUMBER) // felmeddelande ifall f�r m�nga matas in
                {
                    System.out.println("Systemet kan inte hantera fler");
                    System.out.println();
                }
				else
				{	
				addLongJumper(longJumper, position);
						position++;				
				}
				break;
			case 2: addResults(position, longJumper);
				break;
			case 3:showAll(longJumper, position);
				break;
			case 4:
				System.out.println("Programmet har avslutats");
				break;
			default:
				System.out.println("Ange ett tal mellan 1 och 4 tack!");
				break;
					
			
			}
		}
	}
	public static int menu(Scanner keyboard)
	{
		System.out.println("1. L�gg till l�ngdhoppare");
		System.out.println("2. L�gg till hoppresultat f�r vald l�ngdhoppare");
		System.out.println("3. Visa alla l�ngdhoppare med namn, klubb och hoppresultat");
		System.out.println("4. Avsluta");
		System.out.println();
		System.out.println("Ditt val: ");
		int choice = keyboard.nextInt();
		keyboard.nextLine();  // t�m buffert
		
		System.out.println();		
		
		return choice; 
	}
	
	public static void addLongJumper(longJumper[] longJumper, int position)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Namn: ");
		String name = keyboard.nextLine(); 
		System.out.print("Klubb: ");
		String club = keyboard.nextLine();
		System.out.print("Antal hoppresultat: ");
		int result = keyboard.nextInt();
		longJumper [position] = new longJumper(name, club, result);
		System.out.println();
		
		
	}
	public static void addResults(int position, longJumper[] longJumper)
	{
            Scanner keyboard = new Scanner(System.in);
		
            System.out.println("L�ngdhoppare: ");
            String jumperNameSearch = keyboard.nextLine(); 
            System.out.println();
                
            for(int i = 0; i < position; i++)
            {
                if(jumperNameSearch.compareToIgnoreCase(longJumper[i].getJumperName()) == 0)
                {
                    for(int j = 0; j < longJumper[i].getArSize(); j++)
                    {
                        System.out.println("Resultat: ");
                        longJumper[i].setResultOfJumps(keyboard.nextInt(), j);
                    }
                }
            }
	}
	public static void showAll(longJumper[]longJumper, int position)
	
	{
            System.out.println("Deltagare samt deltagar-information:");
            System.out.println();
            for (int i = 0; i < position; i++)
            {
                longJumper[i].show(); 		
            }
            System.out.println();
        }	
}

