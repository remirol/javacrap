import java.util.Vector;
public class Logic
{
	//Instansvariabler
	private Vector<Person> persons;
	
	//Konstruktor
	public Logic()
	{
		persons = new Vector<Person>();
	}
	
	//Metoder
	public void addPerson(String theName, String thePhoneNr)
	{
		persons.add(new Person(theName, thePhoneNr));
	}
	
	public Vector<Person> getAllPersons()
	{
		return persons;
	}
	
	public String getNameForPersonAt(int position)
	{
		Person person = persons.get(position);
		return person.getName();
		//return (persons.get(position)).getName();
	}
	
	public String getPhoneNrForPersonAt(int position)
	{
		return (persons.get(position)).getPhoneNr();
	}
}