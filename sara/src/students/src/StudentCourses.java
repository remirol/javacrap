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
    // metod för att visa
    public void Show()
    {
        System.out.println("Kurs: " + this.courseName);
        System.out.println("Högskolepoäng: " + this.courseCredit);
    }
}