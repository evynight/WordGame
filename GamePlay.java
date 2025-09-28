import java.util.Scanner;

public class GamePlay
{
    public static void main(String[] args)
    {
        String hostFirstName = "Keyboard";
        String hostLastName = "Karl";
        String enterLast;

        Hosts gameHost = new Hosts(hostFirstName, hostLastName);
        gameHost.randomizeNum();
        Players player = new Players();
        Scanner keyboard = new Scanner(System.in);

        System.out.println(gameHost.getFirstName() + " " + gameHost.getLastName()
                         + ": Welcome to the Number Guessing Game!");

        System.out.print("Enter your name >> ");
        player.setFirstName(keyboard.nextLine());
        System.out.print("Would you like to enter your last name? (Y/N) >> ");
        enterLast = keyboard.nextLine();
        if (enterLast.startsWith("Y") || enterLast.startsWith("y"))
        {
            System.out.print("Enter your last name >> ");
            player.setLastName(keyboard.nextLine());

        }

        System.out.println();
        System.out.println(gameHost.getFirstName() + " " + gameHost.getLastName()
                        + ": Let's start the game!");

        gameHost.randomizeNum();
        Turn guessGame = new Turn();
        boolean gameEnd = false;
        boolean continuePlaying = false;

        while (gameEnd != true && continuePlaying != true)
        {
            while(gameEnd != true)
            {
                gameEnd = guessGame.takeTurn(player, gameHost);
            }
            System.out.print("Would you like to continue Playing? (Y/N) >> ");
            String contPlay = keyboard.nextLine();
            if (contPlay.startsWith("Y") || contPlay.startsWith("y"))
            {
                gameHost.randomizeNum();
                gameEnd = false;
                continuePlaying = false;
                System.out.println(gameHost.getFirstName() + " " + gameHost.getLastName()
                                + ": On to the next round!\n");
            }
            else
            {
                continuePlaying  = true;
                System.out.print(gameHost.getFirstName() + " " + gameHost.getLastName()
                                + ": You finished with $" + player.getMoney() + ".");
                System.out.println(/*gameHost.getFirstName() + " " + gameHost.getLastName()
                                + */" Thank you for playing!\n");
            }
        }
    }
}
