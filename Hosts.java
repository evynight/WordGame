import java.util.Random;
public class Hosts extends Person
{
    private String[] hostPhrase = {"Lorem ipsum dolor sit amet",
                                "Not all who wander are lost",
                                "There is always a bigger fish",
                                "It is snowing on Mount Fuji",
                                "Life finds a way",
                                "See you Space Cowboy",
                                "Believe in your dreams",
                                "Taking a day trip out of town"};

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
    
    public String getHostPhrase()
    {
        Random randomNum= new Random();
        int randPhrase = randomNum.nextInt(5);
        return hostPhrase[randPhrase];
    }
}
