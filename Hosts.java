public class Hosts extends Person
{
    public int randomizeNum()
    {
        Numbers randomNum = new Numbers();
        randomNum.generateNumber();
        //int hostNum = randomNum.getRandomNum();
        //return hostNum;
        return randomNum.getRandomNum();
    }
}
