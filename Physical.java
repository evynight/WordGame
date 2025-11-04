import java.util.Random;
public class Physical implements Award
{
    private final int PRIZECOUNT = 5;
    private String[] prize = {"2025 Toyota Rav4",
                            "All Expenses Paid Vacation to the Bahamas",
                            "Samsung Stainless Steel Kitchen Appliance Set",
                            "LG 80-Inch 4K OLED TV",
                            "Unopened Playstation 2 We Found Stuck Behind a Shelf in Storage"};
    private Random numGenerator = new Random();

    public int randomizePrize()
    {
        return numGenerator.nextInt(PRIZECOUNT);
    }
    public String receivePrize()
    {
        return prize[randomizePrize()];
    }
    public int displayWinnings(Players player, boolean guess)
    {
        if(guess == true)
        {
            GUI.addGameMessage("Surprise, " + player.getFirstName() +
                            " " + player.getLastName() + "! You won this round's " +
                            "bonus prize of this " + receivePrize() +"!");
            return 0;
        }
        else
        {
            GUI.addGameMessage("Oh, so sorry, " + player.getFirstName() +
                            " " + player.getLastName() + ". Looks like you missed this " +
                            "round's bonus prize of this " + receivePrize() + ".");
            return 0;
        }
    }
}
