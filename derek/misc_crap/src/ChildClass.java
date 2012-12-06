/**
 * Created with IntelliJ IDEA.
 * User: Derek
 * Date: 11/29/12
 * Time: 11:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class ChildClass extends BaseClass
{
    // This string can be seen only from inside any ChildClass object.
    private String childClassScopePrivate;

    // This string can be seen by anything that can access or create a ChildClass object.
    public String childClassScopePublic;

    // Just a private counter
    private int childClassScopeCount;

    // A constructor that accepts all five strings
    public ChildClass(String privChild, String pubChild, String privParent, String protParent, String pubParent)
    {
        super(privParent, protParent, pubParent);
        AssignChildren(privChild, pubChild);
    }

    // A constructor that only takes two strings (for the child)
    public ChildClass(String privChild, String pubChild)
    {
        super();
        AssignChildren(privChild, pubChild);
    }

    // A constructor that takes default values for everything
    public ChildClass()
    {
        super();
        AssignChildren("private child default", "public child default");
    }

    // This is a private method to centralize the assignments
    // and ensure that even private variables are set properly
    //
    // We can't use this() like we did in BaseClass because Java doesn't like
    // mixing this() and super() -- they both have to be first.  Blame Java :(
    private void AssignChildren(String privChild, String pubChild)
    {
        childClassScopePrivate = privChild;
        childClassScopePublic = pubChild;
        childClassScopeCount = 0;
    }

    @Override
    // This returns all the strings in a usable format
    public String getAllStrings()
    {
        childClassScopeCount++;  // add to the number of times we have printed our strings

        // notice how we cheat and use super() here to print our parent strings too
        return String.format("%s, %s, %s", super.getAllStrings(), childClassScopePrivate, childClassScopePublic);
    }

    @Override
    // Because our variable is private we need to make it accessible
    public int getCount()
    {
        return childClassScopeCount;
    }
}
