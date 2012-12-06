import java.util.Scanner;
import java.util.Vector;

public class StudentHandler {

	
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		//Det självklara valet av variabelnamn är då students (skrivet i pluralis för att ange att här kan det vara flera) av typen Student
		Vector <Student> students = new Vector<Student>(); 
		
		
		
		int choice = 0; 
		System.out.println("Distans-studenter och dess kurser");
		System.out.println("---------------------------------");
		System.out.println();
		
			while (choice != 5)
			{
				choice = menu(keyboard);
				switch(choice)
				{
				case 1:addStudent(keyboard );
					break;
				case 2:addCourse(keyboard, students);
					break;
				case 3:showForOneStudent(keyboard, students);
					break;
				case 4:showForAllStudents( students); 
					break;
				case 5: 
					break; 
	
				}
			}
	}
	
	public static int menu(Scanner keyboard)
	{
		int choice = 0; 
		System.out.println("1. Lägg till student");
		System.out.println("2. Lägg till kurs för student");
		System.out.println("3. Visa alla kurser samt total högskolepoäng för student");
		System.out.println("4. Visa alla kurser för alla studenter");
		System.out.println("5. Avsluta");
		System.out.println();
		System.out.println("Ditt val:");
		choice = keyboard.nextInt(); 
		keyboard.nextLine(); // försäkring för tömming av buffert
		
		return choice; 
	}
	// lägg till student
	public static void addStudent(Scanner keyboard)
	{
		Vector <Student> students = new Vector<Student>();
		System.out.println("Studentens namn: ");
		String name = keyboard.nextLine(); 
		System.out.println("Födelsedatum: ");
		String dateOfBirth = keyboard.nextLine(); 
		
		// behållare för nu student
		Student temp = new Student(name, dateOfBirth);
		students.add(temp);
			
		
	}
	// lägg till kurs för student
	public static void addCourse(Scanner keyboard, Vector <Student> students)
	{	
		//Vector <Student> stud = new Vector<Student>();
		System.out.println("Studentens namn:");
		String name = keyboard.nextLine(); 
		// initiera index
		int foundPersonIndex = -1;
		
		// loopa igenom alla inlagda studenter
			for (int i = 0; i < students.size(); i++)
			{
				Student person = students.get(i);
				
					if(name.equalsIgnoreCase(person.getName()))
					{	
						// spara, så vi kan använda senare
						foundPersonIndex = i; 
						break;
					}
			}
				//om vi inte hittar någon 
				if(foundPersonIndex == -1)
				{
					System.out.println("Det finns ingen student med det här namnet");
					return; 
				}
		
			System.out.println("Kursnamn: ");
			String courseName = keyboard.nextLine();
			System.out.println("Högskolepoäng: ");
			int universityPoints = keyboard.nextInt();
			keyboard.nextLine(); // bufferttömning
			
			Course tempCourse = new Course(courseName, universityPoints);
			Student person = students.elementAt(foundPersonIndex);
			
			person.addCourse(tempCourse); 
		
	}
	// visa för en student 
	public static void showForOneStudent(Scanner keyboard, Vector <Student> students)
	{
		System.out.println("Studentens namn:");
		String name = keyboard.nextLine();
		//boolean requestedStudent = false;
		int foundPersonIndex = -1;
		
		// likadan loop som i föregående metod, för vi vill även i denna
		// veta om studenten finns eller inte
		for (int i = 0; i <students.size(); i++)
		{
			Student person = students.get(i);
				if( name.equalsIgnoreCase(person.getName()))
				{
					foundPersonIndex = i;
					break;
				}
		}
			if(foundPersonIndex == -1)
			{
				System.out.println("Det finns ingen student med det här namnet");
				return;
			}
		
		Student person = students.elementAt(foundPersonIndex);
		
		// here I want what is stored in class Students method addCourse
		// so I can add that to the right person?
			
		//return requestedStudent; 
	
	}
	// visa students
	public static void showForAllStudents(Vector <Student> students)
	{
		for (Student allStudents : students)
		{
			System.out.println(allStudents.toString());
		}
	}

	
	
}
