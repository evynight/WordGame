import javax.swing.*;
import java.awt.*;
public class GUI extends JFrame
{
    /**
    components needed:
    JLabel that lists current players
    JButton that makes new player w/ JOptionPane
    JLabel for current host
    JButton to make host and gamePhrase w/ JOptionPane
    JLabel to show current playingPhrase
    JButton that starts player turns

    JOptionPane for if player correct, winnings, ect
    JOptionPane for play again
    Above two may not need to be in GUI?
    */

    /**
    Array for players in game?
    
     */
    JLabel pListLabel = new JLabel("[Player list]");
    //JButton pAddButton = new JButton("Add Player");
    JLabel hLabel = new JLabel("[Host Name]");
    //JButton hAddButton = new JButton("Add host and phrase");
    JLabel playPhraseLabel = new JLabel("[Playing Phrase]");
    //JButton turnButton = new JButton("Start turn");
    public GUI()
    {
        super("Phrase Finders");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(pListLabel);
        //add(pAddButton);
        add(hLabel);
        //add(hAddButton);
        add(playPhraseLabel);
       // add(turnButton);

    }
    //Temporary main for testing purposes
    public static void main(String[] args)
    {
        GUI gooey = new GUI();
        final int WIDTH = 400;
        final int HEIGHT = 350;
        gooey.setSize(WIDTH, HEIGHT);
        gooey.setVisible(true);
    }
}
