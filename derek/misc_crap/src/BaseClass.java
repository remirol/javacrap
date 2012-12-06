/**
 * Created with IntelliJ IDEA.
 * User: Derek
 * Date: 11/29/12
 * Time: 11:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class BaseClass
{
    // This string can be seen by all methods of 'BaseClass'
    private String classScopePrivate;

    // This string can be seen by all methods of 'BaseClass' and any class that extends 'BaseClass'
    protected String classScopeProtected;
    protected int classScopeCount;

    // This string can be seen by anything that can see or create a BaseClass object
    public String classScopePublic;

    // This constructor expects three strings to be passed in to it, which it will assign appropriately
    public BaseClass(String privString, String protString, String pubString)
    {
        classScopePrivate = privString;
        classScopeProtected = protString;
        classScopePublic = pubString;

        classScopeCount = 0;    // always start counting at 0
    }

    // This constructor can be called to generate default strings.
    // Note how it calls the main constructor to avoid duplicating code and to ensure that
    // all other variables are initialized the same way every time
    public BaseClass()
    {
        this("private default", "protected default", "public default");
    }

    // This returns all the strings in a usable format
    public String getAllStrings()
    {
        classScopeCount++;  // add to the number of times we have printed our strings
        return String.format("%s, %s, %s", classScopePrivate, classScopeProtected, classScopePublic);
    }

    // Because our variable is private we need to make it accessible
    public int getCount()
    {
        return classScopeCount;
    }
}
