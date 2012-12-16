/*
 * file: Random.java
 * author: Sara Br�nnholm
 * date: 2012-09-28
 * purpose: Ett program som matar ut slumpade tal och ordnar upp dem i f�lt. 
 *
 */


import java.util.Scanner;

class Random
{
    public static void main(String[] args)
    {
     // deklarationer
     
        Scanner in = new Scanner(System.in); 
        
        System.out.print("Hur m�nga slumptal i intervallet 0 -999?: ");         
        
        int userChoice[] = new int[in.nextInt()]; 
        System.out.println();
        int count = 0; 
        
        // bearbetning, for loopar f�r att f� fram slumpning
        	for(int i = 0; i < userChoice.length; i++){
        
        		/*NOTE: Eftersom det i uppgiften stod att tipset var Math.random()
        		 * har jag valt denna och bara �ndrat siffran man multiplicerar med*/
        		
        		userChoice[i] = (int)(Math.random() * 1000);
            
        	} 
        
        System.out.println("H�r �r de slumpade talen: "); 
        
        	for(int i = 0; i < userChoice.length; i++) {  
        		System.out.print(userChoice[i] + " "); 
            
        	}
        
        System.out.println("\n"); 
       
        // bearbetning f�r slumptal l�gre tal
        	for(int i = 0; i < userChoice.length; i++){ 	
        													 
               if(userChoice[i] < 500){      
            
            	   count++;      
            	   
               }          
        } 
        	
        	// deklarationer
        
        int lowGroup[] = new int[count];  
        int highGroup[] = new int[userChoice.length - count];            
        
        	for(int i = 0, lowRandom = 0, highRandom = 0; i < userChoice.length; i++){ 
        
        		if(userChoice[i] < 500){  
            
        			lowGroup[lowRandom] = userChoice[i]; 
        			lowRandom++;	
        			
        		} 
        		
        		else{ 
            
                highGroup[highRandom] = userChoice[i]; 
                highRandom++; 
                
        		}
        	}
        
        	// antal nummer (lowGroup.length) tillh�rande det l�gre intervallet
        	
        System.out.println("Dessa " + lowGroup.length + " talen �r i intervallet 0-499: "); 
        
        	for(int i = 0; i < lowGroup.length; i++) {       		
       
            System.out.print(lowGroup[i] + " "); 
            
        	}
        	
        System.out.println(); 
        System.out.println(); 
        
        // antal nummer (lowGroup.length) tillh�rande det l�gre intervallet
        
        System.out.println("Dessa " + highGroup.length + " talen �r i intervallet 500-999: " ); 
        
        	for(int i = 0; i < highGroup.length; i++){  
        
            System.out.print(highGroup[i] + " "); 
            
        	} 
        System.out.println();     
       
        
    } 
    
}