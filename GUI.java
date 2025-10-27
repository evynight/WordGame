import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class GUI extends JFrame implements ActionListener
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
    host object?
     */
    private final int MAX_PLAYERS = 5;
    private int playerCount = 0;
    StringBuilder playerList = new StringBuilder("Current Players: ");
    Players[] currentPlayers = new Players[MAX_PLAYERS];
    Hosts currentHost;

    JLabel pListLabel = new JLabel(playerList.toString());
    JButton pAddButton = new JButton("Add Player");
    JLabel hLabel = new JLabel("[Host Name]");
    JButton hostButton = new JButton("Add host and phrase");
    JLabel playPhraseLabel = new JLabel("[Playing Phrase]");
    JButton turnButton = new JButton("Start turn");
    public GUI()
    {
        super("Phrase Finders");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(pListLabel);
        add(pAddButton);
        add(hLabel);
        add(hostButton);
        add(playPhraseLabel);
        add(turnButton);

        pAddButton.addActionListener(this);
        hostButton.addActionListener(this);
        turnButton.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        if(source == pAddButton)
        {
            if(playerCount == MAX_PLAYERS)
            {
                JOptionPane.showMessageDialog(this, "No more players can be added", "Max players reached",
                    JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                String fName;
                String lName;
                int entLast;
                
                fName = JOptionPane.showInputDialog(this, "Enter player's first name", 
                    "Player Name", JOptionPane.INFORMATION_MESSAGE);
                if(fName != null)
                {
                    entLast = JOptionPane.showConfirmDialog(this, "Would you like to enter a last name?", "",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(entLast == JOptionPane.YES_OPTION)
                    {
                        lName = JOptionPane.showInputDialog(this, "Enter player's last name", 
                        "Player Name", JOptionPane.INFORMATION_MESSAGE);
                        if(lName != null)
                        {
                            currentPlayers[playerCount] = new Players(fName, lName);
                        }
                        else
                        {
                            currentPlayers[playerCount] = new Players(fName);
                        }
                        playerList.append(currentPlayers[playerCount].getName() + " | ");
                    }
                    else
                    {
                        currentPlayers[playerCount] = new Players(fName);
                        playerList.append(currentPlayers[playerCount].getName() + " | ");
                    }
                    pListLabel.setText(playerList.toString());
                    playerCount++;
                }
            }
        }
    }
}