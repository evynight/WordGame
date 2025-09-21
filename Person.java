public class Person
{
    public static void main(String[] args);
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

        public void setFirstName(String f);
        {
            f = firstName;
        }
        public void setLastName(String l);
        {
            l = lastName;
        }
        public String getFirstName();
        {
            return firstName;
        }
        public String getLastName();
        {
            return lastName;
        }
    }
}