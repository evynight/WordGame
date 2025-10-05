import java.util.Random;
public class Physical implements Award
{
    private final int PRIZECOUNT = 5;
    private String[] prize = {"2025 Toyota Rav4",
                            "All Expenses Paid Vacation to the Bahamas",
                            "Samsung Stainless Steel Kitchen Appliance Set",
                            "LG 80-Inch 4K OLED TV",
                            "Unopened Playstation 2 We Found Stuck Behind a Shelf in Storage"};

    public int getRandomPrize()
    {
        Random numGenerator = new Random();
        return numGenerator.nextInt(PRIZECOUNT);
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
            System.out.println("Oh, so sorry, " + player.getFirstName() +
                            " " + player.getLastName() + ". Looks like you missed this " +
                            "round's bonus prize of this " + prize[getRandomPrize()] + ".");
            return 0;
        }
    }
}
