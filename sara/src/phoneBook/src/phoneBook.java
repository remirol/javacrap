import java.util.Scanner;

class PhoneBook
{
    static String phoneBook[][] = new String[255][2];
    static int arrayCounter = -1;
    
    public static void main(String args [])
    {
    	
    	/* TODO; something like this
    	 * int sizeBook = 0; 
    	 * ask user
    	 * get sizeBook
    	 * array[sizeBook][something else, probably  0]*/
    	
        int userChoice = 1;
        String personName;
        Scanner input = new Scanner(System.in);
       // char [][] phoneBook = new char[0][0]; 
        
        while(userChoice != 0)
        {
            System.out.println("1. Add person to phonebook");
            System.out.println("2. Search for person by name");
            System.out.println("3. Search for person by number");
            System.out.println("4. Sort phonebook alphabetically");
            System.out.println("5. Show entire phonebook"); 
            System.out.println("6. Avsluta");
            System.out.println();
            System.out.print("Ditt val: ");
            userChoice = input.nextInt();
            System.out.println();
            
            switch(userChoice)
            { // TODO; split this into a method of its own. Should not be in main
                case 0:
                	System.out.println("Ogiltigt val, försök igen");
                    break;
                case 1:
                    Scanner addName = new Scanner(System.in);
                    System.out.print("Enter the name of the person to add: ");
                    personName = addName.nextLine();
                    System.out.print("Enter the phone number of " + personName + " : ");
                    addPerson(personName, addName.nextLine());
                    break;
                case 2:
                    System.out.print("Enter the person to search for: ");
                    Scanner person = new Scanner(System.in);
                    System.out.println();
                    searchPerson(person.nextLine());
                    break;
                case 3:
                    System.out.print("Enter the phone number to search for: ");
                    Scanner phoneNumber = new Scanner(System.in);
                    searchNumber(phoneNumber.nextLine());		
                    break;
                case 4:
                    phonebookSort();
                    System.out.println("Phonebook sorted.\n");
                    break;
                case 5:                    
                    showBook();
                    break;
                case 6:
                	System.out.println("Du har valt att avsluta.");
                	System.exit(0);
                	break; 
               // default:
               //     System.out.println("Invalid input, try again");
               //     System.out.println();
               //     break;                
            }
        }
    }
    
    public static void addPerson(String name, String number)
    {
        arrayCounter++;
        phoneBook[arrayCounter][0] = name;
        phoneBook[arrayCounter][1] = number;
    }
    
    public static void searchPerson(String person) // want to add String number here, otherwise it will not display number
    {
    	  
        for(int i = 0; i <= arrayCounter; i++){ 
        
        	for(int j = 0; j < phoneBook[i].length; j++){
        	
        		if(person.compareToIgnoreCase(phoneBook[i][j]) == 0){
            
        			if (person.compareToIgnoreCase(phoneBook[0][j]) == 0){
        				
        				// System.out.println("Person found in location [" + i + "],[0]");
        				System.out.println( phoneBook[i][0] + " har telefonnummer " + phoneBook[0][j]);
        				
        			} // TODO; need a if- incase invalid search. 
        		}
            
            }
        }
    }
    
    public static void searchNumber(String number)
    {
        for(int i = 0; i <= arrayCounter; i++){
        
            for(int j = 0; j < phoneBook[0].length; j++){
            
                if(number.compareToIgnoreCase(phoneBook[i][j]) == 0){
                
                    System.out.println("Number found in location [" + i + "],[" + j + "].");
                } // TODO; need a if- incase invalid search
            }
        }
    }
    
    public static void phonebookSort()
    {
        int isSwapped = 1;
        int j = 0;
        String tmp[][] = new String[1][2];
        
        while(isSwapped != 0){
        
            isSwapped = 0;
            j++;
            
            for(int i = 0; i <= arrayCounter - j; i++){
            
                if(phoneBook[i][0].compareToIgnoreCase(phoneBook[i + 1][0]) > 0){
                
                    tmp[0][0] = phoneBook[i][0];
                    tmp[0][1] = phoneBook[i][1];
                    phoneBook[i][0] = phoneBook[i + 1][0];
                    phoneBook[i][1] = phoneBook[i + 1][1];
                    phoneBook[i + 1][0] = tmp[0][0];
                    phoneBook[i + 1][1] = tmp[0][1];
                    isSwapped = 1;
                } // TODO; insert print to show the result, not only that it is sorted. 
            }
        }
    }
    
    public static void showBook()
    {
        for(int i = 0; i <= arrayCounter; i++){
        
            for(int j = 0; j < phoneBook[0].length; j++){
           
                System.out.print(phoneBook[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}