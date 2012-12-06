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
                    System.out.print("Namn: ");
                    String nameToSearch = keyboard.nextLine();
                    searchName(keyboard, names, numbers, position, nameToSearch);
                    break;
                case 3:
                    searchNumber(keyboard, names, numbers, position);
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
     * Räknarvariabeln tickar i main istället under rätt case, istället för att ha en return i addPerson
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
    /*I uppgiften stod det att det inte skulle vara någon inmatning i denna metod, men
     * eftersom den behandlar vilket namn man vill söka på så förstår jag inte riktigt hur detta
     * skall uppnås utan någon inmatning så jag har löst det så här*/
    public static int searchName(Scanner keyboard, String[] names, int[] numbers, int position, String nameToSearch)
    {
        for(int i = 0; i < position; i++)
        {
            if(names[i].compareToIgnoreCase(nameToSearch) == 0)
            {
                System.out.println("Numret för " + names[i] + " är " + numbers[i] + ".");
                return i;
            }
        }
        return -1;
    }
    
    public static void searchNumber(Scanner keyboard, String[] names, int[] numbers, int position)
    {
        System.out.print("Nummer: ");
        int numberToSearch = keyboard.nextInt();
        
        for(int i = 0; i < position; i++)
        {
            if(numbers[i] == numberToSearch)
            {
                System.out.println("Namnet för " + numbers[i] + " är " + names[i] + ".");
            }
        }
        System.out.println();
    }
    
    public static void sort(String[] names, int[] numbers, int position)
    {
        int isSwapped = 1;
        while(isSwapped != 0)  // can just keep going until everything is in order
        {
            isSwapped = 0;
            for(int i = 0; i < position - 1; i++)   // must not run off end of array, so position-1 here
            {
                if(names[i].compareToIgnoreCase(names[i + 1]) > 0)
                {
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

    public static void showAll(String[] names, int position, int[] numbers)
    {
        for(int i = 0; i < position; i++)
        {
            System.out.println(i + 1 + ". " + names[i] + "\t" + numbers[i]);
        }
        System.out.println();
    }
}