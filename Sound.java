import java.net.URL;
import java.nio.file.*;
import javax.sound.sampled.*;

public class Sound
{
    private final int SOUND_COUNT = 5;
    static final int PERSON_ADDED = 0;
    static final int ROUND_START = 1;
    static final int GUESS_RIGHT = 2;
    static final int GUESS_WRONG = 3;
    static final int WIN = 4;

    Clip clip;
    FileSystem slash = FileSystems.getDefault();

    URL soundURL[] = new URL[SOUND_COUNT];

    public Sound()
    {
        soundURL[PERSON_ADDED] = getClass().getResource(
            slash.getSeparator() + "Img-Aud" + slash.getSeparator() + "827637__elliottliu__interface7.wav");
        soundURL[ROUND_START] = getClass().getResource(
            slash.getSeparator() + "Img-Aud" + slash.getSeparator() + "823591__happypizzabread__game-ui-sfx-practice-6.wav");
        soundURL[GUESS_RIGHT] = getClass().getResource(
            slash.getSeparator() + "Img-Aud" + slash.getSeparator() + "833495__wavewire__lootpickup_feedback.wav");
        soundURL[GUESS_WRONG] = getClass().getResource(
            slash.getSeparator() + "Img-Aud" + slash.getSeparator() +  "829078__anonio82__retro_game_death_sound.wav");
        soundURL[WIN] = getClass().getResource(
            slash.getSeparator() + "Img-Aud" + slash.getSeparator() + "765688__sabacky__activation-pick-up-item-jingle.wav");
    }
    public void setFile(int i)
    {
        try
        {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e);
        }
    }
    public void play()
    {
        clip.start();
    }
    public void loop()
    {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop()
    {
        clip.stop();
    }
    public void playSound(int i)
    {
        this.setFile(i);
        this.play();
    }
}
