import java.util.Scanner;

public class book
{
    public static void main(String[] args)
    {
    	
    	// Variabel-deklaration
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Storleken på boken: ");
        final int SIZE = keyboard.nextInt();
        
        int choice = 1;
        
        String[] names = new String[SIZE];
        int[] numbers = new int[SIZE];
        int position = 0;
        
        /*While-loop och switch för att hålla programmet i snurr och hantera menyn*/
        while(choice != 6)
        {
            choice = menu(keyboard);
            switch(choice)
            {
                case 1:
                    addPerson(keyboard, names, position, numbers);
                    position++;
                    break;
                case 2:
                	System.out.println("Namn:"); 
                	String nameToSearch = keyboard.nextLine();
                	int nameResult = searchName( keyboard, names, numbers,  position, nameToSearch);
                	
                		if(nameResult != -1){
                			System.out.println("Indexet för namnet du letade efter är på position:" + nameResult);
                		} else {
                		System.out.println("Namnet du letade efter finns inte");
                	}
                    
                    break;
                case 3:
                	System.out.print("Nummer: ");
                	int numberToSearch = keyboard.nextInt();
                    int numberResult = searchNumber(keyboard, names, numbers, position, numberToSearch);
                    
                    	if(numberResult != -1){
                    	System.out.println("Numret du letade efter finns i position: " + numberResult);
                    	} else{
                    	
                    	System.out.println("Numret du letade efter går inte att hitta." );
                    }
                    break;
                case 4:
                    sort(names, numbers, position);
                    break;
                case 5:
                    showAll(names, position, numbers);
                    break;
                case 6:
                    System.out.println("välkommen åter");
                    break;
                default:
                    System.out.println("vänligen ange ett nummer mellan 1 och 6.");
                    break;
            }
        }
    }
    
    public static int menu(Scanner keyboard) // hanterar enbart menyn
    {
        System.out.println("1. Lägg till person");
        System.out.println("2. Sök på namn");
        System.out.println("3. Sök på nummer");
        System.out.println("4. Sortera på namn");
        System.out.println("5. Visa alla");
        System.out.println("6. Avsluta program");
        System.out.println();
        System.out.print("Ditt val: ");
        int menuChoice = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println();
        
        return menuChoice;
    }
    
    /*
     * Räknarvariabeln tickar i main under rätt case (addPerson), istället för att ha en return i addPerson
     * */
    public static void addPerson(Scanner keyboard, String[] names, int position, int[] numbers)
    {
        System.out.print("Namn: ");
        String name = keyboard.nextLine();
        System.out.print("Nummer: ");
        int number = keyboard.nextInt();
        keyboard.nextLine();
        names[position] = name;
        numbers[position] = number;
        System.out.println();
    }
    
    /**/
    public static int searchName(Scanner keyboard, String[] names, int[] numbers, int position, String nameToSearch)
    {
    	        
        for(int i = 0; i < position; i++)
        {
            if(names[i].compareToIgnoreCase(nameToSearch) == 0)
            {
                System.out.println("Numret är " + names[i] + " är " + numbers[i] + ".");
		return i;
            }
        }
        System.out.println();
        return -1;
    }
    
    /*samma princip som ovan bara att
     * det räcker med != istället för compareToIgnorCase
     * och numbers[] istället för names[]*/
    public static int searchNumber(Scanner keyboard, String[] names, int[] numbers, int position, int numberToSearch)
    {

    	
        for(int i = 0; i < position; i++)
        {
            if(numbers[i] == numberToSearch)
            {
                System.out.println("Namnet för nummer " + numbers[i] + " är " + names[i] + ".");
		return i;
            }
        }
        System.out.println();
        return -1;
    	
    }
    /*
     * Den här metoden var riktigt klurig, jag har inte alls löst den optimalt
     * vad jag skulle tro, men det här var det enda sättet jag klurade ut
     * jag höll ärligt talat på att bli lätt galen när jag höll på med 
     * CompareTo, så jag hittade bubble sort istället som funkade för mig
     * 
     * */
	  public static void sort(String[] names, int[] numbers, int position)
{
 
		  	int isSwapped = 1;
		  	while(isSwapped != 0){  
  
			  isSwapped = 0;
			  for(int i = 0; i < position - 1; i++) {  
      
			  if(names[i].compareToIgnoreCase(names[i + 1]) > 0){
          
              String tempName = names[i];
              int tempNum = numbers[i];
              names[i] = names[i + 1];
              numbers[i] = numbers[i + 1];
              names[i + 1] = tempName;
              numbers[i + 1] = tempNum;
              isSwapped = 1;
          }
      }
 
  }
}
    
    /*Inget speciellt i den här metoden som behöver nämnas*/
    public static void showAll(String[] names, int position, int[] numbers)
    {
        for(int i = 0; i < position; i++) {
       
            System.out.println(i + 1 + ". " + names[i] + "\t" + numbers[i]);
        }
        System.out.println();
    }
}