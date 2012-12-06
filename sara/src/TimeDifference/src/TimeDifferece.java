/*
 * File: TimeDifference.java
 * Author: Sara Brännholm
 * Date: 20120914
 * 
 * */

import java.util.Scanner;

public class TimeDifferece{
	
	public static void main(String[] args){
		
		// deklarera variabler 
			
		Scanner in = new Scanner(System.in); //  inmatning av värden
		//System.out.println("This program is running..."); // check
		
		
		int startHour ; // variabel av start timme
		int startMinute ; // variabel av start Minut
		int startSecond ; // variabel av start sekund
		
		int endHour ; // variabel av slut timme
		int endMinute ; // variabel av slut minut
		int endSecond ; // variabel av slut sekund
		
		
		// Inmatning start-tid
		
		System.out.println("Start-tid:\n" + "Timme: "); 
		startHour = in.nextInt(); 
		System.out.println("Minut: ");
		startMinute = in.nextInt(); 
		System.out.println("Sekund: ");
		startSecond = in.nextInt(); 
		
		// Inmatning slut-tid
		
		System.out.println("Målgångstid:\n" + "Timme: "); 
		endHour = in.nextInt(); 
		System.out.println("Minut: ");
		endMinute = in.nextInt(); 
		System.out.println("Sekund: ");
		endSecond = in.nextInt(); 
		
		in.close(); // stänger inmatning 
		
		// beräkna tiden och mata ut till användare
		
		int resultSecond = endSecond - startSecond; 
		int resultMinute = endMinute - startMinute;
		int resultHour = endHour - startHour; 
		
		// kolla att tiden stämmer
				
		if(endSecond - startSecond < 0)
		  {
		   resultSecond = (endSecond - startSecond) + 60;
		   resultMinute = -1;   
		  }
		  else
		  {
		   resultSecond = endSecond - startSecond;
		   resultMinute = 0;
		  }
		  
		  if(endMinute - startMinute < 0)
		  {
		   resultMinute += (endMinute - startMinute) + 60;
		   resultHour = -1; 
		  }
		  else
		  {
		   resultMinute += endMinute - startMinute;
		   resultHour = 0; 
		  }
		  
		  resultHour += endHour - startHour; 
		
		System.out.println("Resultat Timme: " + resultHour + " Minut: " + resultMinute + " Sekund: " + resultSecond); 
		
		
		
		
	}
	
}