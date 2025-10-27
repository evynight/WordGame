public class Hosts extends Person
{
    private String hostPhrase = "";

    public Hosts()
    {
        super();
    }
    public Hosts(String f)
    {
        super(f);
    }
    public Hosts(String f, String l)
    {
        super(f, l);
    }
    public void setHostPhrase(String s)
    {
        hostPhrase = s;
    }
    public String getHostPhrase()
    {
        return hostPhrase;
    }
}
