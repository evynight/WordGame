import java.util.Scanner;

public class GamePlay
{
    public static void main(String[] args)
    {
        GUI game = new GUI();
        final int WIDTH = 400;
        final int HEIGHT = 350;
        game.setSize(WIDTH, HEIGHT);
        game.setVisible(true);

        /**
        String hostFirstName = "Keyboard";
        String hostLastName = "Karl";
        String enterLast;
        final int PLAYERCOUNT = 3;

        Scanner keyboard = new Scanner(System.in);
        Hosts gameHost = new Hosts(hostFirstName, hostLastName);

        Players[] currentPlayers = new Players[PLAYERCOUNT];

        System.out.println(gameHost.getName()+ ": Welcome to a game of Phrase Finder!");
        System.out.println("I'm your host, " + gameHost.getName() + ".");
        System.out.println("\nWhy don't you introduce yourselves?");

        for(int x = 0; x < currentPlayers.length; x++)
        {
            System.out.print("Player " + (x + 1) + ": Enter your name >> ");
            currentPlayers[x] = new Players(keyboard.nextLine());
            System.out.print("Player " + (x + 1) + ": Would you like to enter your last name? (Y/N) >> ");
            enterLast = keyboard.nextLine();
            if((Character.toLowerCase(enterLast.charAt(0)) == 'y'))
            {
                System.out.print("Player " + (x + 1) + ": Enter your last name >> ");
                currentPlayers[x].setLastName(keyboard.nextLine());
            }
        }

        System.out.print("\n" + gameHost.getName() + ": Thank you ");
        for(int x = 0; x < PLAYERCOUNT; x++)
        {
            if(x < (PLAYERCOUNT - 1))
            {
                System.out.print(currentPlayers[x].getName() + ", ");
            }
            else
            {
                System.out.print("and " + currentPlayers[x].getName() + "!\n");
            }
        }
        System.out.println("\n" + gameHost.getName() + ": I'm going to provide a secret phrase.\n" +
                           "Each of you will take turns trying to find what it is one letter at a time.\n" +
                            "Make sure you only enter a single letter! Otherwise you forfeit your turn.\n" +
                            "No special characters, either. Letters only!\n" +
                            "Is everyone ready? Let's get started!\n");

        Turn findGame = new Turn();
        Phrases gamePhrase = new Phrases();
        gamePhrase.setGamePhrase(gameHost.getHostPhrase());
        boolean roundEnd = false;
        boolean gameEnd = false;
        boolean continueTurn = false;

        System.out.println(gameHost.getName() + ": Here is this round's phrase: ");
        
        while(roundEnd != true && gameEnd != true)
        {
        while(roundEnd != true)
            {
                for(int x = 0; x < currentPlayers.length; x++)
                {
                    continueTurn = false;
                    while(continueTurn == true);
                    {
                        continueTurn = findGame.takeTurn(currentPlayers[x], gameHost);
                    
                        if(gamePhrase.getGamePhrase().equals(gamePhrase.getPlayingPhrase()))
                        {
                            roundEnd = true;
                            Physical roundPrize = new Physical();
                            String prizeWon = roundPrize.receivePrize();
                            System.out.println("Congratulations on completing the phrase, " + 
                                                currentPlayers[x].getName() + "!\nThe prize for this round is " +
                                                "this\n" +  prizeWon + "!");
                            if(currentPlayers[x].getPrize() == null)
                            {
                                currentPlayers[x].setPrize(prizeWon);
                            }
                            else
                            {
                                System.out.println("It looks like you already have a prize. " +
                                                    "Sorry, but you can only keep one at a time.");
                                System.out.print("Do you want to swap it out? (Y/N) >> ");
                                String prizeSwap = keyboard.nextLine();
                                if((Character.toLowerCase(prizeSwap.charAt(0)) == 'y'))
                                {
                                    currentPlayers[x].setPrize(prizeWon);
                                }
                            }
                            break;
                        }
                       
                    }  

                }
            }

            System.out.print("\nShall we continue playing? (Y/N) >> ");
            String contPlay = keyboard.nextLine();
            if((Character.toLowerCase(contPlay.charAt(0)) == 'y'))
            {
                gamePhrase.setGamePhrase(gameHost.getHostPhrase());
                roundEnd = false;
                gameEnd = false;
                System.out.println(gameHost.getName() + ": On to the next round!");
                System.out.println("Here is the new phrase:");
            }
            else
            {   
                gameEnd  = true;
                System.out.println(gameHost.getName() + ": Here are the final results: ");
                for(int x = 0; x < currentPlayers.length; x++)
                {
                    if(currentPlayers[x].getPrize() == null)
                    {
                        System.out.println(currentPlayers[x].getName() + "won" +
                        "...uhm, they had a good time.");
                    }
                    else
                    {
                    System.out.println(currentPlayers[x].getName() + " won a(n) " +
                                    currentPlayers[x].getPrize() + ".");
                    }
                }
                System.out.println(" Thank you for playing!\n");
            }
        }*/
    }
}
