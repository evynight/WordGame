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

        Players[] currentPlayers = new Players[PLAYERCOUNT];

        System.out.println(gameHost.getName()+ ": Welcome to the Guess That Phrase Game!");
        System.out.println("I'm your host, " + gameHost.getName() + ".");
        System.out.println("Why don't you introduce yourselves?\n");

        for(int x = 0; x < currentPlayers.length; x++)
        {
            System.out.print("Player " + (x + 1) + ": Enter your name >> ");
            currentPlayers[x] = new Players(keyboard.nextLine());
            System.out.print("Player " + (x + 1) + ": Would you like to enter your last name? (Y/N) >> ");
            enterLast = keyboard.nextLine();
            if(enterLast.startsWith("Y") || enterLast.startsWith("y"))
            {
                System.out.print("Player " + (x + 1) + ": Enter your last name >> ");
                currentPlayers[x].setLastName(keyboard.nextLine());
            }
        }

        System.out.println("\n" + gameHost.getName() + ": Let's start the game!");

        Turn guessGame = new Turn();
        Phrases gamePhrase = new Phrases();
        gamePhrase.setGamePhrase(gameHost.getHostPhrase());
        boolean roundEnd = false;
        boolean playerWin = false;
        boolean gameEnd = false;
        
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
                gamePhrase.setGamePhrase(gameHost.getHostPhrase());
                roundEnd = false;
                gameEnd = false;
                System.out.println(gameHost.getName() + ": On to the next round!\n");
            }
            else
            {   //Do I even want to keep this block?
                /**
                gameEnd  = true;
                System.out.println(gameHost.getName() + ": Here are the final results: ");
                for(int x = 0; x < currentPlayers.length; x++)
                {
                    System.out.println(currentPlayers[x].getName() +
                                    " finished with $" + currentPlayers[x].getMoney() + ".");
                }*/
                System.out.println(" Thank you for playing!\n");
            }
        }
    }
}
