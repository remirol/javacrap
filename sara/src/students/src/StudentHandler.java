import java.util.Scanner;
import java.util.Vector;

class StudentHandler
{
	// variabler
    private int choice;
    private Vector <StudentInfo>studentInfo;
    
    
    public StudentHandler()
    {
        choice = 0;
        studentInfo = new Vector <StudentInfo>(10,2);
    }
    
    public static void main(String[] args)
    {
        StudentHandler student = new StudentHandler();
        
        while(student.getChoice() != 5)
        {
            student.setChoice(student.menu());
        }
    }
    
    public int menu()
    {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("1. L�gg till student");
        System.out.println("2. L�gg till kurs f�r student");
        System.out.println("3. Visa alla kurser samt total h�gskolepo�ng f�r student");
        System.out.println("4. Visa alla kurser f�r alla studenter");
        System.out.println("5. Avsluta");
        System.out.print("Ditt val: ");
        int keyInput = keyboard.nextInt();
        keyboard.nextLine(); // t�m buffert
        System.out.println();
        
        if(keyInput < 1 || keyInput > 5) // felmeddelande ifall inget matchar
        {
            System.out.print("ogiltigt val, f�rs�k igen: ");
            keyInput = keyboard.nextInt();
            System.out.println();
        }
        
        switch(keyInput) // menyhantering
        {
            case 1:
                System.out.print("Studentens namn: ");
                String studentName = keyboard.nextLine();
                System.out.print("Students f�delesedatum: ");
                int studentDOB = keyboard.nextInt();
                keyboard.nextLine();
                addStudent(studentName, studentDOB);
                break;
            case 2:
                System.out.print("Studentens namn: ");
                studentName = keyboard.nextLine();
                System.out.print("Studentens f�delsedatum: ");
                studentDOB = keyboard.nextInt();
                keyboard.nextLine();
                boolean added = addCourses(studentName, studentDOB);
                if(!added)
                {
                    System.out.println("Ingen student matchar s�kningen.");
                    System.out.println();
                }
                break;
            case 3:
                System.out.print("Studentens namn: ");
                studentName = keyboard.nextLine();
                System.out.print("Studentens f�delsedatum: ");
                studentDOB = keyboard.nextInt();
                keyboard.nextLine();
                boolean found = showSingleStudent(studentName, studentDOB);
                if(!found)
                {
                    System.out.println("Ingen student matchar s�kningen.");
                    System.out.println();
                }
                break;
            case 4:
                showAllStudents();
                break;
            default:
                break;
        }        
        return keyInput;
    }
    // get-set-metoder f�r choice
    public void setChoice(int choiceValue)
    {
        this.choice = choiceValue;
    }
    
    public int getChoice()
    {
        return choice;
    }
    
    private void addStudent(String studentName, int studentDOB)
    {
        studentInfo.add(new StudentInfo(studentName, studentDOB));
    }
    
    private void showAllStudents()
    {
        for(int i = 0; i < studentInfo.size(); i++)
        {
            studentInfo.elementAt(i).Show();
            System.out.println();
        }
    }
    // boolean f�r enkelhet att returnera, if-statement f�r j�mmf�relse i matching av s�kningen
    private boolean showSingleStudent(String studentName, int studentDOB)
    {
        boolean found = false;
        
        for(int i = 0; i < studentInfo.size(); i++)
        {
            if(studentInfo.elementAt(i).getName().compareToIgnoreCase(studentName) == 0 & studentInfo.elementAt(i).getDOB() == studentDOB)
            {
                found = true;
                studentInfo.elementAt(i).Show();
                System.out.println();
            }
        }
        return found;
    }
    
    // samma som ovan med boolean och if-statement
    private boolean addCourses(String name, int dob)
    {
        boolean added = false;
        
        for(int i = 0; i < studentInfo.size(); i++)
        {
            if(studentInfo.elementAt(i).getName().compareToIgnoreCase(name) == 0 & studentInfo.elementAt(i).getDOB() == dob)
            {
                Scanner keyboard = new Scanner(System.in);
                System.out.print("Kurs: ");
                String courseName = keyboard.nextLine();
                System.out.print("H�gskolepo�ng: ");
                int credits = keyboard.nextInt();
                keyboard.nextLine();
                studentInfo.elementAt(i).addCourses(courseName, credits);
                System.out.println();
                added = true;
            }
        }
        return added;
       
    }
}