import java.util.Scanner;

public class GamePlay
{
    public static void main(String[] args)
    {
        String hostFirstName = "Keyboard";
        String hostLastName = "Karl";
        String enterLast;
        final int PLAYERCOUNT = 3;

        Scanner keyboard = new Scanner(System.in);
        Hosts gameHost = new Hosts(hostFirstName, hostLastName);
        gameHost.randomizeNum();
        Person[] currentPlayers = new Person[PLAYERCOUNT];

        System.out.println(gameHost.getFirstName() + " " + gameHost.getLastName()
                         + ": Welcome to the Number Guessing Game!");

        for(int x = 0; x < currentPlayers.length; x++)
        {
            System.out.print("Player " + (x + 1) + ": Enter your name >> ");
            currentPlayers[x] = new Players(keyboard.nextLine());
            System.out.print("Player " + (x + 1) + "Would you like to enter your last name? (Y/N) >> ");
            enterLast = keyboard.nextLine();
            if(enterLast.startsWith("Y") || enterLast.startsWith("y"))
            {
                System.out.print("Player " + (x + 1) + ": Enter your last name >> ");
                currentPlayers[x].setLastName(keyboard.nextLine());
            }
        }

        System.out.println("\n" + gameHost.getFirstName() + " " + gameHost.getLastName()
                        + ": Let's start the game!");

        Turn guessGame = new Turn();
        boolean roundEnd = false;
        boolean playerWin = false;
        boolean gameEnd = false;
        
        gameHost.randomizeNum();
        while(roundEnd != true && gameEnd != true)
        {
        while(roundEnd != true || playerWin != true)
            {
                for(int x = 0; x < currentPlayers.length; x++)
                {
                    playerWin = guessGame.takeTurn(currentPlayers[x], gameHost);
                    if(playerWin == true)
                    {
                        roundEnd = true;
                    }
                }
            }

            System.out.print("Shall we continue playing? (Y/N) >> ");
            String contPlay = keyboard.nextLine();
            if (contPlay.startsWith("Y") || contPlay.startsWith("y"))
            {
                gameHost.randomizeNum();
                roundEnd = false;
                gameEnd = false;
                System.out.println(gameHost.getFirstName() + " " + gameHost.getLastName()
                                + ": On to the next round!\n");
            }
            else
            {
                gameEnd  = true;
                System.out.print(gameHost.getFirstName() + " " + gameHost.getLastName()
                                + ": You finished with $" + player.getMoney() + ".");
                System.out.println(" Thank you for playing!\n");
            }
        }
    }
}
