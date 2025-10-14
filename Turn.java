import java.util.Scanner;

public class Turn
{
    private String playerChoice;
    Scanner keyboard = new Scanner(System.in);
    Phrases gamePhrase = new Phrases();

    public boolean takeTurn(Players player, Hosts host)
    {
        System.out.println(gamePhrase.getPlayingPhrase());
        System.out.print(host.getName() + ": Choose a letter, " + 
                            player.getName() + " >> ");
        
        playerChoice = keyboard.nextLine();

        try
        {
            if(gamePhrase.findLetters(playerChoice))
            {
                System.out.println("Looks like we have a(n) " + playerChoice + "!");
                System.out.println("It's still your turn!");
                return true;
            }
            else
            {
                System.out.println("Too bad, looks like there isn't a(n) "+ playerChoice + ".");
                System.out.println("Next player's turn!");
                return false;
            }
        }
        catch(MultipleLettersException m)
        {
            System.out.println(m.getMessage() + ". Sorry, that means your turn is up.");
            System.out.println("Next player's turn!");
            return false;
        }
        catch(NumberOrSymbolException i)
        {
            System.out.println(i.getMessage() + ". Sorry, that means your turn is up. "); 
            System.out.println("Next player's turn!");
            return false;
        }
        catch(IndexOutOfBoundsException o)
        {
            System.out.println("Erm...Hm. I guess that means your turn is over.");
            System.out.println("Next player's turn!");
            return false;
        }
    }
}
