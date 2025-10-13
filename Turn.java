import java.util.Scanner;
import java.util.Random;

public class Turn
{
    private String playerGuess;
    Scanner keyboard = new Scanner(System.in);

    public boolean takeTurn(Players player, Hosts host)
    {

        System.out.println(host.getFirstName() + " " + host.getLastName() +
                            ": I'm thinking of a number between 0 and 100.");
        System.out.print("Your turn to guess, " + player.getFirstName() + 
                            " " + player.getLastName() + " >> ");
        
        playerGuess = keyboard.nextLine();

        Random prizeDecide = new Random();
        Numbers compare = new Numbers();
        if (prizeDecide.nextInt(5) == prizeDecide.nextInt(5))
        {
            Money prizeMoney = new Money();
            boolean result = compare.compareNumber(playerGuess);
            int resultMoney = prizeMoney.displayWinnings(player, result);
            player.setMoney(player.getMoney() + resultMoney);
            System.out.println(player.toString() + "\n");
            return result;
        }
        else
        {
            Physical prizePhys = new Physical();
            boolean result = compare.compareNumber(playerGuess);
            int resultPhys = prizePhys.displayWinnings(player, result);
            player.setMoney(player.getMoney() + resultPhys);
            System.out.println(player.toString() + "\n");
            return result;
        }
    }
}
