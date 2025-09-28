public class Hosts extends Person
{
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
    
    public void randomizeNum()
    {
        Numbers randomNum = new Numbers();
        randomNum.generateNumber();
    }
}
