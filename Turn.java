import java.util.Scanner;

public class Turn
{
    final int moneyWin = 100;
    final int moneyLose = 10;
    private int playerGuess;
    Scanner keyboard = new Scanner(System.in);

    public boolean takeTurn(Players player, Hosts host)
    {

        System.out.println(host.getFirstName() + " " + host.getLastName() +
                            ": I'm thinking of a number between 0 and 100.");
        System.out.print("Try to guess it, " + player.getFirstName() + 
                            " " + player.getLastName() + " >> ");
        
        playerGuess = keyboard.nextInt();

        Numbers compare = new Numbers();
        if (compare.compareNumber(playerGuess) == true)
        {
            player.setMoney(player.getMoney() + moneyWin);
            System.out.println(player.toString());
            //Test string
            System.out.println();
            //
            return true;
        }
        else
        {
            player.setMoney(player.getMoney() - moneyLose);
            System.out.println(player.toString());
            //Test string
            System.out.println();
            //
            return false;
        }
    }
}
