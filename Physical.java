import java.util.Random;
import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Physical implements Award, ActionListener
{
    private final int PRIZE_COUNT = 5;
    private int prizeWon;

    private Random numGenerator = new Random();
    private String[] prize = {"Brand New Toyota Rav4",
                            "All Expenses Paid Vacation to the Bahamas",
                            "Complete Kitchen Renovation",
                            "Brand New Flatscreen TV",
                            "Unopened Playstation 2 We Found Stuck Behind a Shelf in Storage"};
    //URL imgURL[] = new URL[PRIZE_COUNT];
    FileSystem slash = FileSystems.getDefault();
    BufferedImage prizeImg[] = new BufferedImage[PRIZE_COUNT];
    BufferedImage animImg[] = new BufferedImage[2];



    public Physical()
    {
        try
        {
            prizeImg[0] = ImageIO.read(new File(slash.getSeparator() + "Img-Aud" +
                slash.getSeparator() + "toyota-rav-4-5272095_1280.jpg"));
            prizeImg[1] = ImageIO.read(new File(slash.getSeparator() + "Img-Aud" +
                slash.getSeparator() + "pool-115850_1280.jpg"));
            prizeImg[2] = ImageIO.read(new File(slash.getSeparator() + "Img-Aud" +
                slash.getSeparator() + "home-5835289_1280.jpg"));
            prizeImg[3] = ImageIO.read(new File(slash.getSeparator() + "Img-Aud" +
                slash.getSeparator() + "lion-2210947_1280.jpg"));
            prizeImg[4] = ImageIO.read(new File(slash.getSeparator() + "Img-Aud" +
                slash.getSeparator() + "video-game-console-2202637_1280.jpg"));

            animImg[1] = ImageIO.read(new File(slash.getSeparator() + "Img-Aud" +
                slash.getSeparator() + "chest-145753_1280.png"));
            animImg[2] = ImageIO.read(new File(slash.getSeparator() + "Img-Aud" +
                slash.getSeparator() + "chest-145752_1280.png"));
        }
        catch(IOException e)
        {
            System.out.println("Error: " + e);
        }
    }
    public int randomizePrize()
    {
        return numGenerator.nextInt(PRIZE_COUNT);
    }
    public String receivePrize()
    {
        prizeWon = randomizePrize();
        showPrize();
        return prize[prizeWon];
    }
    public void showPrize()
    {
        JFrame prizeFrame = new JFrame("Congratulations!");
        prizeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        prizeFrame.setSize(250,250);
        prizeFrame.setLocationRelativeTo(null);
        prizeFrame.setVisible(true);

        //Graphics.drawImage(prizeImg[0], 125, 125, null);
        //Giving up and moving on to next lesson.
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
    public int displayWinnings(Players player, boolean guess)
    {
        if(guess == true)
        {
            GUI.addGameMessage("Surprise, " + player.getFirstName() +
                            " " + player.getLastName() + "! You won this round's " +
                            "bonus prize of this " + receivePrize() +"!");
            return 0;
        }
        else
        {
            GUI.addGameMessage("Oh, so sorry, " + player.getFirstName() +
                            " " + player.getLastName() + ". Looks like you missed this " +
                            "round's bonus prize of this " + receivePrize() + ".");
            return 0;
        }
    }
}
