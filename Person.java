public class Person
{
    private String firstName;
    private String lastName;

    public Person()
    {
        firstName = "";
        lastName = "";
    }
    public Person(String f)
    {
        firstName = f;
        lastName = "";
    }
    public Person(String f, String l)
    {
        firstName = f;
        lastName = l;
    }

    public void setFirstName(String f)
    {
        firstName = f;
    }
    public void setLastName(String l)
    {
        lastName = l;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
}