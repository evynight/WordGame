public class Phrases
{
    private String gamePhrase = "";
    private StringBuilder playingPhrase = null;

    public void setGamePhrase(String g)
    {
        gamePhrase =g;
    }
    public String getGamePhrase()
    {
        return gamePhrase;
    }
    public void setPlayingPhrase()
    {
        playingPhrase = new StringBuilder(gamePhrase);

        for(int x = 0; x < gamePhrase.length(); x++)
        {
            if(Character.isLetterOrDigit(playingPhrase.charAt(x)))
            {
                playingPhrase.setCharAt(x, '_');
            }
        }
    }
    public String getPlayingPhrase()
    {
        return playingPhrase.toString();
    }
    public void findLetters(String guess) throws MultipleLettersException
    {
        try
        {

        }
        catch(MultipleLettersException m)
        {
            System.out.println(m.getMessage());
        }
        finally
        {
            String nowPhrase = playingPhrase.toString();
            if(nowPhrase.indexOf('_') == -1)
            {
                System.out.println("Congratulations, you completed the phrase! " +
                            "You win this game's prize!");
            }
        }
    }
}