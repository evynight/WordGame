import javax.swing.JOptionPane;

public class Turn
{
    private String playerChoice;
    Phrases gamePhrase = new Phrases();

    public boolean takeTurn(Players player, Hosts host)
    {
        playerChoice = JOptionPane.showInputDialog(null, gamePhrase.getPlayingPhrase() +
            "\n" +  host.getName() + ": Choose a letter, " +  player.getName() + ".",
            player.getName() + "'s Turn", JOptionPane.QUESTION_MESSAGE);

        try
        {
            if(gamePhrase.findLetters(playerChoice))
            {
                JOptionPane.showMessageDialog(null, "Looks like we have a(n) " + playerChoice + "!",
                    player.getName() + "'s Turn", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Too bad, looks like there isn't a(n) "+ playerChoice + ".",
                    player.getName() + "'s Turn", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        }
        catch(MultipleLettersException m)
        {
            JOptionPane.showMessageDialog(null, m.getMessage() + ". Sorry, that means your turn is up.",
                    player.getName() + "'s Turn", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        catch(NumberOrSymbolException i)
        {
            JOptionPane.showMessageDialog(null, i.getMessage() + ". Sorry, that means your turn is up. ",
                player.getName() + "'s Turn", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        catch(IndexOutOfBoundsException o)
        {
            JOptionPane.showMessageDialog(null, "Erm...Hm. I guess that means your turn is over.",
                player.getName() + "'s Turn", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        catch(NullPointerException n)
        {
            JOptionPane.showMessageDialog(null, "Skipping your turn? Well, I suppose that's fine.",
                player.getName() + "'s Turn", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
