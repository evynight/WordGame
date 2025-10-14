public class Players extends Person
{
    private int money;
    private String prize;

    public Players()
    {
        super();
        money = 1000;
    }
    public Players(String f)
    {
        super(f);
        money = 1000;
    }
    public Players(String f, String l)
    {
        super(f, l);
        money = 1000;
    }

    public void setMoney(int m)
    {
        money = m;
    }
    public int getMoney()
    {
        return money;
    }

    public void setPrize(String p)
    {
        prize = p;
    }
    public String getPrize()
    {
        return prize;
    }

    @Override
    public String toString()
    {
        if(super.getLastName().equals(""))
        {
            String playerInfo = super.getFirstName() + "'s current winnings: $"
                        + money;
            return playerInfo;
        }
        else
        {
            String playerInfo = super.getFirstName() + " " + super.getLastName()
                        + "'s current winnings: $" + money;
            return playerInfo;
        }
    }
}
