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
	         int userChoice = 0;
	         // �ndrad nu till storlek 10
	         int [] transactions = new int[10]; // array f�r beh�llare av transaktionerna, �nskad enligt uppgiften
	         int input; 
	         double balance = 0; // variabel �nskad av uppgiften. Double f�r �ren
	         DecimalFormat format = new DecimalFormat("0.00");
	         
	         // Bearbetning f�r menyn, switch-l�sning som anropar de olika metoderna. 
	         
         while (userChoice != 4){
	         
	            userChoice = menu();
            switch(userChoice){ 
	            
	                case 1:
                    System.out.print("Hur mycket vill du s�tta in? :"); 
	                    input = keyboard.nextInt(); 
	                    
                        if(input == 0){ 
	                       
                        System.out.print("felaktigt val.\n \n");
                       	                        
	                     } 
	                        else { 
                        
	                        value = (int) + input;
                        makeTransactions(value, transactions); 
                        
	                        } 	
	                           break;
	                 
	                case 2:
	                        System.out.print("Hur mycket vill du ta ut?: "); 
	                        input = keyboard.nextInt();
	                        
	                            if(input == 0){ 
                            
                                System.out.print("Felaktigt val.\n \n");
	                                                            
	                            } 
	                                else{ 
	                                
	                                    value = (int) - input;
	                                    makeTransactions(value, transactions); // anropa metoden makeTransaction igen
	                                }
	                                break;
	                 
	                case 3:
	                        showTransactions(transactions, balance, format); 
	                        break;
	                         
	                case 4:
	                        System.out.println("Du har valt att avsluta. Adj�! "); 
	                        break;
	            } 
	             
	         } 
         
         
	    } 
	     
	  //presenterar menyn och hanterar anv�ndarens inmatning. tar inga parametrar, returnerar en int.
	    
	    public static int menu()  
	    {
	            Scanner keyboard = new Scanner(System.in); 
	            int userOption = 0; 
	             
	          
	            System.out.println("\n" + "1. Ins�ttning ");
	            System.out.println("2. Uttag ");
	            System.out.println("3. Saldobesked ");
	            System.out.println("4. Avsluta");	         
	            System.out.println("\n" +"Ditt val: ");
	            
	       	             
	            userOption = keyboard.nextInt(); 
	            return userOption; 
	            
	            
	      } 
	    
	    // presenterar gjorda transaktioner samt saldo tar en array av typ int - transactions, int balance samt
	    // NumberFormat df, som parametrar	
	    
	    public static void showTransactions(int [] transactions, double balance, NumberFormat df) 
        {
                   int count = 0;
                   
                   for(int i = 0; i < transactions.length; i++){
                   
                       if(transactions[i] != 0){
                       
                           count++;
                       }
                   }
                   
                   int arrayStart;
                   
                   if(count <= 10){
                   
                       arrayStart = 0;
                   }
                   
                   else {
                   
                       arrayStart = count - 10;
                   }
                   
            System.out.print("\n Sista transaktionerna \n"); 
                         
                for(int i = 0; i < count; i++){ 
                
                    if(transactions[arrayStart] == 0) { 
                    
                        System.out.print("");
                               arrayStart++;
                    } 
                     
                        else {          
                         
                         
                            System.out.print(df.format(transactions[arrayStart]) + "\n"); 
                           balance = balance + transactions[arrayStart]; 
                                  arrayStart++;                                 
                        
                        } 
             
                } 
                            
            System.out.println("\n" + "Saldo: " + df.format(balance) + " kr" + "\n\n" ); // utskrift av saldot i decimalformat med tv? nollor
                  
        }
	         
	     // hanterar att placera amount sist av transaktionerna. Anv�nder metoderna findNr och moveTrans, 
	     // tar int amount och en array av typ int som parametrar
	        
	        public static void makeTransactions(int amount, int [] trans) 
	        {															  	
	            int findChoice = findNr(trans);
	            if(findChoice == -1) { 
	            
	                moveTrans(trans); 
	                    findChoice = findNr(trans); 
	                    trans[findChoice] = amount; 
	                    
	            } 
	            
	            else { 
	            
	                trans[findChoice] = amount; 
	                
	            }  
	                 
	        } 
	        
	      //returnerar positionen f�r var transaktionen ska placeras, om det inte finns plats returneras -1, tar en array av typ int
	         
	        public static int findNr(int [] transactions)  
	        {
	            int position = -1; // �ndrad fr�n 0 till -1
	             
	            for(int i = 0; i < transactions.length; i++) { 
	             
	                if(transactions[i] == 0) { 
	                
	                    position = i; 
	                    break; // bryt. Minus!
	                    
	                }  
	            }
	            return position; //  returnera position s� detta kan anv�ndas. 
	            
	        } 
	        
	     /* flyttar alla transaktioner i ett steg s� det finns plats f�r en ny transaktion., tar en array av typ int som parameter
	      * har gjort om den lite, hoppas detta �r b�ttre. den kastar ingen array out of bounds vad jag ser n�r jag testar den */
	     
	        public static void moveTrans(int [] transactions) 
	        {
	            for(int i = 0; i < transactions.length -1; i++){ 
	                 
	                transactions[i] = transactions[i + 1]; 
	                
	            } 
	            
	            transactions[transactions.length-1] = 0; 
	                 
	        } 
         
	 
} 