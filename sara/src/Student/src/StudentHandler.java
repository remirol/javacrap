import java.util.Scanner;
import java.util.Vector;

public class StudentHandler {

	
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		//Det sj�lvklara valet av variabelnamn �r d� students (skrivet i pluralis f�r att ange att h�r kan det vara flera) av typen Student
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
		System.out.println("1. L�gg till student");
		System.out.println("2. L�gg till kurs f�r student");
		System.out.println("3. Visa alla kurser samt total h�gskolepo�ng f�r student");
		System.out.println("4. Visa alla kurser f�r alla studenter");
		System.out.println("5. Avsluta");
		System.out.println();
		System.out.println("Ditt val:");
		choice = keyboard.nextInt(); 
		keyboard.nextLine(); // f�rs�kring f�r t�mming av buffert
		
		return choice; 
	}
	// l�gg till student
	public static void addStudent(Scanner keyboard)
	{
		Vector <Student> students = new Vector<Student>();
		System.out.println("Studentens namn: ");
		String name = keyboard.nextLine(); 
		System.out.println("F�delsedatum: ");
		String dateOfBirth = keyboard.nextLine(); 
		
		// beh�llare f�r nu student
		Student temp = new Student(name, dateOfBirth);
		students.add(temp);
			
		
	}
	// l�gg till kurs f�r student
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
						// spara, s� vi kan anv�nda senare
						foundPersonIndex = i; 
						break;
					}
			}
				//om vi inte hittar n�gon 
				if(foundPersonIndex == -1)
				{
					System.out.println("Det finns ingen student med det h�r namnet");
					return; 
				}
		
			System.out.println("Kursnamn: ");
			String courseName = keyboard.nextLine();
			System.out.println("H�gskolepo�ng: ");
			int universityPoints = keyboard.nextInt();
			keyboard.nextLine(); // buffertt�mning
			
			Course tempCourse = new Course(courseName, universityPoints);
			Student person = students.elementAt(foundPersonIndex);
			
			person.addCourse(tempCourse); 
		
	}
	// visa f�r en student 
	public static void showForOneStudent(Scanner keyboard, Vector <Student> students)
	{
		System.out.println("Studentens namn:");
		String name = keyboard.nextLine();
		//boolean requestedStudent = false;
		int foundPersonIndex = -1;
		
		// likadan loop som i f�reg�ende metod, f�r vi vill �ven i denna
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
				System.out.println("Det finns ingen student med det h�r namnet");
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
