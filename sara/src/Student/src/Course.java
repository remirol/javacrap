import java.util.Vector;

public class Course {
	/*Varje kurs har i detta system kursnamn och antal högskolepoäng.*/
	
 // instansvariabler
	private String courseName; 
	private int universityPoints; 
	
	// konstruktorer
	public Course()
	{
		courseName = ""; 
		universityPoints = 0; 
	}
	
	public Course(String courseName, int universityPoints)
	{
		this.courseName = courseName;
		this.universityPoints = universityPoints; 
	}
	// get set metoder
	
	public void setCourseName(String courseName)
	{
		this.courseName = courseName; 
	}
	public void setUniversityPoints(int universityPoints)
	{
		this.universityPoints = universityPoints; 
	}

	public static void add(Course temp)
	{
		//courseInfo.add(course);
		
	}
	public String toString()
	{
		String str = "Kurs: " + courseName + "\n";
		str += "Högskolepoäng" + universityPoints + "\n";
		
		return str; 
	}
	
	
	
}
