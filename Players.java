public class Players extends Person
{
    private int money;

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

    @Override
    public String toString()
    {
        String playerInfo = super.getFirstName() + " " + super.getLastName()
                    + "'s current winnngs: $" + money;
        return playerInfo;
    }
}
