import java.util.Scanner;


public class ScoreTable 
{
	public static void main(String[] args) 
	{
		//Variabeldeklaration
		Scanner keyboard = new Scanner(System.in);
		int size = 0; 
		System.out.println("Hur stor ska boken vara?:");
		size = keyboard.nextInt();
		int choice = 1;
		//final int SIZE = 30;
		String[] names = new String[size];
		int[] scores = new int[size];
		int nrOfPlayers = 0;
		
		//Visa meny
		while (choice != 0)
		{
			choice = menu(keyboard);
			switch (choice)
			{
			case 1:
				nrOfPlayers = addPlayer(keyboard, names, nrOfPlayers);
				break;
			/*case 2:
				System.out.print("Skriv in spelarens namn: ");
				String name = keyboard.nextLine();
				System.out.print("Skriv in spelarens poäng: ");
				int score = keyboard.nextInt();
				keyboard.nextLine();
				registerScore(name, score, names, scores, nrOfPlayers);
				break;*/
			case 2:
				registerScore(keyboard, names, scores, nrOfPlayers);
				break;
			case 3:
				showPlayers(names, scores, nrOfPlayers);
				break;
			case 4:
				showPlayersAboveScore(keyboard, names, scores, nrOfPlayers);
				break;
			case 5:
				showTotalScore(scores, nrOfPlayers);
				break;
			case 0:
				System.out.println("Välkommen åter!");
				break;
			default:
				System.out.println("Vänligen ange ett tal mellan 0-5");
				break;
			}
		}
	}
	
	public static int menu(Scanner keyboard)
	{
		System.out.println("\n1. Registrera spelare (namnet på spelare).");
		System.out.println("2. Lägga in poäng för spelare.");
		System.out.println("3. Presentera alla spelare.");
		System.out.println("4. Visa de spelare som passerar viss poängsumma.");
		System.out.println("5. Beräkna lagets totala poäng.");
		System.out.println("0. Avsluta programmet.");
		System.out.print("Ditt val: ");
		
		int choice = keyboard.nextInt();
		keyboard.nextLine();		//töm buffert
		
		return choice;
	}
	
	public static int addPlayer(Scanner keyboard, String[] names, int nrOfPlayers)
	{
		System.out.print("Ange spelarens namn: ");
		String name = keyboard.nextLine();
		names[nrOfPlayers] = name;
		nrOfPlayers++;
		
		return nrOfPlayers;
	}
	
	public static void registerScore(String name, int score, String[] names, int[] scores, int nrOfPlayers)
	{
		int position = -1;
		
		for (int i = 0; i < nrOfPlayers; i++)
		{
			if (names[i].equals(name))
			{
				position = i;
			}
		}
		if (position != -1)
		{
			scores[position] = score;
		}
		else
		{
			System.out.println("Namnet " + name + " du sökte finns ej");
		}
	}
	
	public static void registerScore(Scanner keyboard, String[] names, int[] scores, int nrOfPlayers)
	{
		System.out.print("Skriv in spelarens namn: ");
		String name = keyboard.nextLine();
		
		//Sök namnet
		int position = -1;
		for (int i = 0; i < nrOfPlayers; i++)
		{
			if (names[i].equals(name))
			{
				position = i;
			}
		}
		
		//Om namnet hittas, mata in poäng
		if (position != -1)
		{
			System.out.print("Skriv in spelarens poäng: ");
			int score = keyboard.nextInt();
			keyboard.nextLine();		//töm buffert
			scores[position] = score;
		}
		else
		{
			System.out.println("Namnet " + name + " du sökte finns ej");
		}
	}
	
	public static void showPlayers(String[] names, int[] scores, int nrOfPlayers)
	{
		for (int i = 0; i < nrOfPlayers; i++)
		{
			System.out.println(names[i] + "\t" + scores[i]);
		}
	}
	
	public static void showPlayersAboveScore(Scanner keyboard, String[] names, int[] scores, int nrOfPlayers)
	{
		System.out.print("Ange poäng: ");
		int score = keyboard.nextInt();
		boolean foundPlayer = false; 
		
		for (int i = 0; i < nrOfPlayers; i++)
		{
			if (scores[i] > score)
			{
				System.out.println(names[i] + "\t" + scores[i]);
				foundPlayer = true;
			}
		}
		
		if (!foundPlayer)
		{
			System.out.println("Ingen spelare har högre poäng än " + score);
		}
	}
	
	public static void showTotalScore(int[] scores, int nrOfPlayers)
	{
		int sum = 0;
		
		for (int i = 0; i < nrOfPlayers; i++)
		{
			sum += scores[i];
		}
		
		System.out.println("Totalpoängen är " + sum);
	}

	

}
