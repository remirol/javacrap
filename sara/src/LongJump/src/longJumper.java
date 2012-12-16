import java.util.Scanner;

class longJumper {

	private String jumperName; 
	private String clubName;
    private int arSize = 0;
        private int[] nrOfJumps;
	
	public longJumper() // konstruktor
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Namn: " );
		this.jumperName = keyboard.nextLine(); 
		System.out.print("Klubb: " );
		this.clubName = keyboard.nextLine();
		System.out.print("Antal hoppresultat");
		this.arSize = keyboard.nextInt();
        this.nrOfJumps = new int[arSize];
	}
	
	public longJumper(String name, String club, int results) // konstruktor
	{
		this.jumperName = name;
		this.clubName = club;
		this.arSize = results; 
        this.nrOfJumps = new int[arSize];
	}
	// get-set-metoder
	public void setJumperName(String name)
        {
		
            this.jumperName = name;
        }
	
	public void setClubName(String club)
	{
            this.clubName = club;
	}
	
	public void setResultOfJumps(int results, int position)
	{
            nrOfJumps[position] = results; 
	}
	
	public String getJumperName()
        {
            return this.jumperName;
        }
	
	public String getClubName()
	{
            return this.clubName;
	}
	
	public int getResult(int i)
	{
            return this.nrOfJumps[i];
	}
        
        public int getArSize()
        {
            return this.arSize;
        }
	
	public void show()
        {
            System.out.println("Namn: " + jumperName);
            System.out.println("Klubb: " + clubName);
            System.out.print("Resultat: ");
            for(int i = 0; i < arSize; i++)
            {
                System.out.print(nrOfJumps[i] + " ");
            }
            System.out.println("\n");
        }
}
