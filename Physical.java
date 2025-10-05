import java.util.Random;
public class Physical implements Award
{
    private final int PRIZECOUNT = 5;
    private String[] prize = new String[PRIZECOUNT];
    
    prize[0] = "2025 Toyota Rav4";
    prize[1] = "All Expenses Paid Vacation to the Bahamas";
    prize[2] = "Samsung Stainless Steel Kitchen Appliance Set";
    prize[3] = "LG 80-Inch 4K OLED TV";
    prize[4] = "Unopened Playstation 2 We Found Stuck Behind a Shelf in Storage";

    public int getRandomPrize()
    {
        Random numGenerator = new Random();
        return numGenerator.nextInt(5);
    }
    public int displayWinnings(Players player, boolean guess)
    {
        if(guess == true)
        {
            System.out.println("Surprise, " + player.getFirstName() +
                            " " + player.getLastName() + "! You won this round's " +
                            "bonus prize of this " + prize[getRandomPrize()] +"!");
            return 0;
        }
        else
        {
            System.out.println("Oh, so sorry, " + player.getLastName() +
                            " " + player.getLastName() + ". Looks like you missed this" +
                            "round's bonus prize of this " + prize[getRandomPrize()] + ".");
            return 0;
        }
    }
}
