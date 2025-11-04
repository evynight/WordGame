public class Money implements Award
{
    private final int MONEYWIN = 100;
    private final int MONEYLOSE = 10;
    
    public int displayWinnings(Players player, boolean guess)
    {
        if(guess == true)
        {
            GUI.addGameMessage("Congratulations, " + player.getFirstName() +
                            " " + player.getLastName() + "! You won!");
            return MONEYWIN;
        }
        else
        {
            GUI.addGameMessage("Oh, so sorry, " + player.getLastName() +
                            " " + player.getLastName() + ". Seems you lost this time.");
            return -MONEYLOSE;
        }
    }
}
