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
    public void findLetters(String g) throws MultipleLettersException
    {
        String guess = g;
        char fillIn = guess.charAt(0);
        
        if(guess.length() > 1)
        {
            throw(new MultipleLettersException());
        }
        else
        {
            for (int y = 0; y < gamePhrase.length(); y++)
            {
                if(gamePhrase.charAt(y) == fillIn)
                {
                    playingPhrase.setCharAt(y, fillIn);
                }
            }
        }
        if(playingPhrase.toString().indexOf('_') == -1)
        {
            System.out.println("Congratulations, you completed the phrase! " +
                        "You win this game's prize!");
        }
    }
}