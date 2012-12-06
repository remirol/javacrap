/*
 * file: atm.java
 * author: Sara Br�nnholm
 * purpose: creating a simple atm
 * date: 2012-10-01
 * 
 * */	
import java.text.DecimalFormat; // formatering
import java.text.NumberFormat; // formatering
import java.util.Scanner;
	 
	 
	public class atm
	{
	     
	    public static void main(String[] args)
	    {
	    	// deklarationer
	         Scanner keyboard = new Scanner(System.in);
	          
	         int value = 0; 
	         int userChoice = 0; //	variabel f�r switch1
	         
	         int [] transactions = new int[10]; // array f�r beh�llare av transaktionerna, �nskad enligt uppgiften
	         int input; // ins�ttningsvariabel fr�n anv�ndare
	         double balance = 0; // variabel �nskad av uppgiften. Double f�r �ren
	         DecimalFormat format = new DecimalFormat("0.00"); // uppsnyggning av inmatning i fall av �ren. 

            /*
            When you do something that looks a little odd, such as this, always be sure to put a comment.
            That way the poor soul coming after you will realize that you're "cheating" and using the initial '0'
            value above to ensure that the loop always executes at least once
             */
         while (userChoice != 4){
	         
	            userChoice = menu(); /* try to make sure you keep indentation clean, OCD says it should line up with switch */
            switch(userChoice){ // switch f�r menyn. 
	            
	                case 1:
                    System.out.print("Hur mycket vill du s�tta in? :"); // fr�ga anv�ndare
	                    input = keyboard.nextInt(); // svar fr�n anv�ndare

                        /*
                         Input validation; what if I type -1?
                         */
                        if(input == 0){ // om anv�ndaren anger noll kommer han/hon f� ett meddelande om felaktigt val
	                       
                        System.out.print("felaktigt val.\n \n");
                       	                        
	                     } // slut if
	                        else { // annars, om valet �r giltigt
                        
	                        value = (int) + input;
                        makeTransactions(value, transactions); // anropa metoden makeTransaction
                        
	                        } // slut else
	                           break;
	                 
	                case 2:
	                        System.out.print("Hur mycket vill du ta ut?: "); // fr�ga anv�ndare
	                        input = keyboard.nextInt();

                        /*
                         Input validation (as above)
                         */
	                            if(input == 0){ // igen, om anv�ndaren anger noll f�r han/hon ett meddelande om felaktigt val
                            
                                System.out.print("Felaktigt val.\n \n");
	                                                            
	                            } // slut if
	                                else{ // annars
	                                
	                                    value = (int) - input;
	                                    makeTransactions(value, transactions); // anropa metoden makeTransaction igen
	                                }
	                                break;
	                 
	                case 3:
	                        showTransactions(transactions, balance, format); // vid val tre, anropa metoden showTransactions
	                        break;
	                         
	                case 4:
	                        System.out.println("Du har valt att avsluta. Adj�! "); // Val av avslut, enkel out
	                        break;
                    /*
                    Always remember to add a "default:" case, even if it does nothing but print a line reading
                    "Something weird happened."  In this case you could do input validation here as well...
                     */
	            } // slut switch
	             
	         } // slut while
	    } // slut main
	     

        /*
        It's nicer to your readers to put method comments above the actual method, instead of out to the side
         like in showTransactions below
         */
	    public static int menu() //presenterar menyn och hanterar anv�ndarens inmatning. tar inga parametrar, returnerar en int. 
	    {
            /*
            Consider moving this variable to class scope instead of making a new Scanner in every method.
             */
	            Scanner keyboard = new Scanner(System.in); // in-enhet, tangentbord
	            int userOption = 0; // variabel f�r in inmatning fr�n anv�ndare
	             
	          
	            System.out.println("\n" + "1. Ins�ttning ");
	            System.out.println("2. Uttag ");
	            System.out.println("3. Saldobesked ");
	            System.out.println("4. Avsluta");	         
	            System.out.println("\n" +"Ditt val: ");
	            
	       	/* No validation of user input?  What if I type '5' here? */
	            userOption = keyboard.nextInt(); // f� valet fr�n anv�ndare
	            return userOption; // returnera inmatat val fr�n anv�ndare
	            
	      } // slut meny
	         
	        public static void showTransactions(int [] transactions, double balance, NumberFormat df)	 // presenterar gjorda transaktioner samt saldo
	        {																	 						 // tar en array av typ int - transactions, int balance samt
	        																							 // NumberFormat df, som parametrar	
	            System.out.print("\n Sista transaktionen \n"); 
	           	             
	                for(int i = 0; i < transactions.length; i++){ // lokal variabel i = 0. S� l�nge i �r mindre �n arrayens l�ngd minus 1 forts�tter loopen

                        /*
                        Printing the empty string isn't necessary; this could have been written as a negative
                        ie. if (transactions[i] != 0), with no need for the 'else'
                         */
	                    if(transactions[i] == 0) { // om array transaction med v�rde av i �r lika med noll skriv ut en tom rad
	                    
	                        System.out.print("");
	                    } // slut if
	                     
	                        else { // annars skriv ut
	                        
	                            System.out.print(df.format(transactions[i]) + "\n"); // arrayen transactions med v�rdet av i, i decimalform, tv� nollor
	                            balance = balance + transactions[i]; // balance �r lika med balance (befintlig) plus array transaction med v�rde av i (vilket �r det nytillkomna f�r saldot)
	                         
	                        } // slut else
	             
	                } // slut for loop
	                	           
	            System.out.println("\n" + "Saldo: " + df.format(balance) + " kr" + "\n\n" ); // utskrift av saldot i decimalformat med tv� nollor
	                  
	        }
	         
	        public static void makeTransactions(int amount, int [] trans) // hanterar att placera amount sist av transaktionerna. Anv�nder metoderna findNr och moveTrans, 
	        {															  // tar int amount och en array av typ int som parametrar	
	            int findChoice = findNr(trans); // 
	            if(findChoice == -1) { // om findChoice �r -1
	            
	                moveTrans(trans); // anropa metoden moveTrans
	                    findChoice = findNr(trans); // findChoice via matoden findNrs, array trans
	                    trans[findChoice] = amount; // array trans med v�rdet av findChoice �r lika med amount
	                    
	            } // slut if
	            
	            else { // annars
	            
	                trans[findChoice] = amount; // array trans med v�rdet av findChoice �r lika med amount
	                
	            }  // slut else
	                 
	        } // slut makeTransaction

        /*
        If you make a variable at class scope, you can probably dispense with both these methods
        for example, "static int transIndex" can always point to the 'next' available transaction slot
         */
	        public static int findNr(int [] transactions) //returnerar positionen f�r var transaktionen ska placeras, om det inte finns plats returneras -1, tar en array av typ int 
	        {
	            int position = -1; // position �r lika med -1
	             
	            for(int i = 0; i < transactions.length; i++) { // lokal variabel i �r 0, s� l�nge i �r mindre �n storleken av array, transaktion, fortl�per looopen
	             
	                if(transactions[i] == 0) { // om array transaction med v�rde av i �r lika med 0
	                
	                    position = i; // position �r lika med i
	                    break; // bryt. Minus!
	                    
	                }  // slut if
	            }// slut for loop
	            return position; //  returnera position s� detta kan anv�ndas. 
	            /*
	             You can dispense with the variable "position" if you just "return i" from inside the loop, and
	             then "return -1" after the loop; if it ever reaches the final value it has clearly failed
	             */
	        } // slut findNr


	        public static void moveTrans(int [] transactions) // flyttar alla transaktioner i ett steg s� det finns plats f�r en ny transaktion., tar en array av typ int som parameter
	        {
	            for(int i = 0; i < transactions.length; i++){ // lokal variabel i �r 0, s� l�nge i �r mindre �n storleken av array, transaktion, fortl�per looopen

                    /*
                    Won't this copy every transaction in the array to transaction #0, causing problems for people
                    with more than 2 transactions?
                     */
	                transactions[0] = transactions[i + 1]; // array transaction med v�rde av noll �r lika med array transaction med v�rde av i 
	                
	            } // slut for loop  		
	                 
	        } // slut moveTrans
         
	 
} // slut class