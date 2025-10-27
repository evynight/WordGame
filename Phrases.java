public class Phrases
{
    private static String gamePhrase = "";
    private static StringBuilder playingPhrase = null;

    public void setGamePhrase(String g)
    {
        gamePhrase = g;
        setPlayingPhrase();
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
            if(Character.isLetter(playingPhrase.charAt(x)))
            {
                playingPhrase.setCharAt(x, '_');
            }
        }
    }
    public String getPlayingPhrase()
    {
        return playingPhrase.toString();
    }
    public boolean findLetters(String g) throws MultipleLettersException, NumberOrSymbolException, IndexOutOfBoundsException
    {
        String guess = g;
        char fillIn = guess.charAt(0);
        
        if(guess.length() > 1)
        {
            throw(new MultipleLettersException());
        }
        else if(!(Character.isLetter(fillIn)))
        {
            throw(new NumberOrSymbolException());
        }

        if(getGamePhrase().toLowerCase().contains(guess.toLowerCase()))
        {
            for (int y = 0; y < gamePhrase.length(); y++)
            {
                if(Character.toLowerCase(gamePhrase.charAt(y)) == Character.toLowerCase(fillIn))
                {
                    playingPhrase.setCharAt(y, gamePhrase.charAt(y));
                }
            }
            return true;
        }
        else
        {
            return false;
        }
    }
}