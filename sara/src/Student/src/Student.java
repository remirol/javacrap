import java.util.Vector;

public class Student {
	/*Studenterna har i detta system namn, f�delsedata och kurser d�r kurserna hanteras i ett Vector-objekt.*/
	
	// instansvariabler
	private String name = ""; 
	private String dateOfBirth = "";
	private Vector <Course> courseInfo = new Vector <Course>(10);
	
	// konstruktorer
	public Student()
	{
		this.name = ""; 
		this.dateOfBirth = ""; 
		
	}
	public Student(String name, String dateOfBirth)
	{
		this.name = name;
		this.dateOfBirth = dateOfBirth; 
	}
	
	// get-set-metoder
	public void setName(String name)
	{
		this.name = name;
	}
	public void setDateOfBirth(String dateOfbirth)
	{
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getName()
	{
		return this.name;
	}
	public String getDateOfBirth()
	{
		return dateOfBirth; 
	}
	public Vector<Course> getCourseInfo()
	{
		return courseInfo; 
	}
	public String toString()
	{
		String str = "Namn: " + name + "\n";
		str += "F�delsedatum" + dateOfBirth + "\n";
		
		return str; 
	}
	// beh�llare f�r att l�gga till kurser till student
	// i StudentHandler addCourse
	public void addCourse(Course course)
	{
		 courseInfo.add(course);
	}
	
	
	// l�gg till student
	

}
