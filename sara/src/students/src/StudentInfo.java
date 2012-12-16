import java.util.Vector;

class StudentInfo
{
	// variabler
    private String studentName;
    private int studentDOB;
    private Vector <StudentCourses> courseInfo = new Vector <StudentCourses>(10,2);
    
    // konstruktorer
    public StudentInfo()
    {
        this.studentName = "null";
        this.studentDOB = 0;
    }
    
    public StudentInfo(String name, int DOB)
    {
        this.studentName = name;
        this.studentDOB = DOB;
    }
    
    // funktion för visa
    public void Show()
    {
        System.out.println("Namn: " + this.studentName);
        System.out.println("Födelsedatum: " + this.studentDOB);
        for(int i = 0; i < courseInfo.size(); i++)
        {
            courseInfo.elementAt(i).Show();
        }
    }
    
    
    
    public void addCourses(String name, int credit)
    {
        courseInfo.add(new StudentCourses(name, credit));
    }
    
    public String getName()
    {
        return this.studentName;
    }
    
    public int getDOB()
    {
        return this.studentDOB;
    }
}