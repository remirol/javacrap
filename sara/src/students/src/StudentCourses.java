class StudentCourses
{
	// variabler
    private String courseName;
    private int courseCredit;
    
    // konstruktorer
    public StudentCourses()
    {
        courseName = "null";
        courseCredit = 0;
    }
    
    public StudentCourses(String name, int credit)
    {
        this.courseName = name;
        this.courseCredit = credit;
    }
    // metod f�r att visa
    public void Show()
    {
        System.out.println("Kurs: " + this.courseName);
        System.out.println("H�gskolepo�ng: " + this.courseCredit);
    }
}