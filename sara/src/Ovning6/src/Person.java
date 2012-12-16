public class Person
{
	//Instansvariabler
	private String name;
	private String phoneNr;
	
	//Konstruktorer
	public Person()
	{
		name = "";
		phoneNr = "";
	}
	
	public Person(String theName, String thePhoneNr)
	{
		name = theName;
		phoneNr = thePhoneNr;
	}
	
	//Get/set-metoder
	public String getName()
	{
		return name;
	}
	
	public String getPhoneNr()
	{
		return phoneNr;
	}
	
	//Denna metod anropas implicit då ett Personobjekt ska visas 
	//i JList-komponenten i det grafiska gränssnittet
	public String toString()
	{
		return name;
	}
}