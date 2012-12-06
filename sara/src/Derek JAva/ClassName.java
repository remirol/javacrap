/**
 * Created with IntelliJ IDEA.
 * User: Derek
 * Date: 11/29/12
 * Time: 10:58 AM
 * To change this template use File | Settings | File Templates.
 */

public class ClassName
{
    // This string can be seen by all static methods
    public static String classScopeStaticString;

    // This string can only be seen by non-static methods
    public String classScopeString;

    public static void main(String[] args)
    {
        // This string can only be seen inside the main() function
        String functionScopeString;


    }
}
