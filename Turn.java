import javax.swing.JOptionPane;

public class Turn
{
    private String playerChoice;
    Phrases gamePhrase = new Phrases();

    public boolean takeTurn(Players player, Hosts host)
    {
        playerChoice = JOptionPane.showInputDialog(null, host.getName() + ": Choose a letter, " + 
            player.getName() + ".", player.getName() + "'s Turn", JOptionPane.QUESTION_MESSAGE);

        try
        {
            if(gamePhrase.findLetters(playerChoice))
            {
                GUI.addGameMessage(host.getName() + ": Looks like we have a(n) " + playerChoice + "!");
                return true;
            }
            else
            {
                GUI.addGameMessage(host.getName() + ": Too bad, looks like there isn't a(n) "+ playerChoice + ".");
                return false;
            }
        }
        catch(MultipleLettersException m)
        {
            GUI.addGameMessage(host.getName() + ": " + m.getMessage() + ". Sorry, that means your turn is up.");
            return false;
        }
        catch(NumberOrSymbolException i)
        {
            GUI.addGameMessage(host.getName() + ": " + i.getMessage() + ". Sorry, that means your turn is up. ");
            return false;
        }
        catch(IndexOutOfBoundsException o)
        {
            GUI.addGameMessage(host.getName() + ": " + "Erm...Hm. I guess that means your turn is over.");
            return false;
        }
        catch(NullPointerException n)
        {
            GUI.addGameMessage(host.getName() + ": " + "Skipping your turn? Well, I suppose that's fine.");
            return false;
        }
    }
}
