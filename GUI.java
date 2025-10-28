import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GUI extends JFrame implements ActionListener
{
    private final int MAX_PLAYERS = 5;
    private int playerCount = 0;
    private StringBuilder playerList = new StringBuilder("Current Players: ");
    Players[] players = new Players[MAX_PLAYERS];
    Hosts gameHost;
    Phrases gamePhrase = new Phrases();
    boolean playerReady;
    boolean hostReady;

    JLabel pListLabel = new JLabel("No players yet");
    JButton pAddButton = new JButton("Add Player");
    JLabel hLabel = new JLabel("No host entered yet");
    JButton hostButton = new JButton("Add host");
    JLabel gamePhraseLabel = new JLabel("[Playing Phrase]");
    JButton startButton = new JButton("Start game");
    public GUI()
    {
        super("Phrase Finders");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(pListLabel);
        add(pAddButton);
        add(hLabel);
        add(hostButton);
        add(gamePhraseLabel);
        add(startButton);

        pAddButton.addActionListener(this);
        hostButton.addActionListener(this);
        startButton.addActionListener(this);
        startButton.setEnabled(false);
    }
    @Override
    public void actionPerformed(ActionEvent action)
    {
        Object source = action.getSource();

        if(source == pAddButton)
        {
            if(playerCount == MAX_PLAYERS)
            {
                JOptionPane.showMessageDialog(this, "No more players can be added.", "Max players reached",
                    JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                String fName;
                String lName;
                int entLast;
                
                fName = JOptionPane.showInputDialog(this, "Enter player's first name", 
                    "New Player", JOptionPane.INFORMATION_MESSAGE);
                if(fName != null)
                {
                    entLast = JOptionPane.showConfirmDialog(this, "Would you like to enter a last name?", "",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(entLast == JOptionPane.YES_OPTION)
                    {
                        lName = JOptionPane.showInputDialog(this, "Enter player's last name", 
                        "New Player", JOptionPane.INFORMATION_MESSAGE);
                        if(lName != null)
                        {
                            players[playerCount] = new Players(fName, lName);
                            playerList.append(players[playerCount].getName() + " | ");
                            pListLabel.setText(playerList.toString());
                            JOptionPane.showMessageDialog(this, players[playerCount].getName() +
                            " has been added to the game.", "New Player", JOptionPane.INFORMATION_MESSAGE);
                            playerCount++;
                            playerReady = true;
                            if(playerReady == true && hostReady == true)
                            {
                                startButton.setEnabled(true);
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(this, "Player addition canceled.", "",
                                JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else
                    {
                        players[playerCount] = new Players(fName);
                        playerList.append(players[playerCount].getName() + " | ");
                        pListLabel.setText(playerList.toString());
                        JOptionPane.showMessageDialog(this, players[playerCount].getName() +
                        " has been added to the game.", "New Player", JOptionPane.INFORMATION_MESSAGE);
                        playerCount++;
                        playerReady = true;
                        if(playerReady == true && hostReady == true)
                        {
                            startButton.setEnabled(true);
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Player addition canceled.", "", JOptionPane.ERROR_MESSAGE);
                }
            }    
        }
        if(source == hostButton)
        {
            String fName = null;
            String lName = null;

            fName = JOptionPane.showInputDialog(this, "Enter host's first name:",
                "New Host", JOptionPane.INFORMATION_MESSAGE);
            if(fName != null)
            {
                lName = JOptionPane.showInputDialog(this, "Enter host's last name:",
                    "New Host", JOptionPane.INFORMATION_MESSAGE);
                if(lName == null)
                {
                    JOptionPane.showMessageDialog(this, "Host additon canceled.",
                    "New Host", JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Host additon canceled.", "New Host",
                    JOptionPane.ERROR_MESSAGE);
            }
            
            if(fName != null && lName != null)
            {
                String setPhrase;
                setPhrase = JOptionPane.showInputDialog(this, "Write a phrase for players to guess:" +
                    "\n(Make sure to not to include any numbers)",
                    "New Host", JOptionPane.INFORMATION_MESSAGE);
                if(setPhrase != null)
                {
                    boolean goodPhrase = false;
                    boolean hasDigit = false;
                    while(goodPhrase != true)
                    {
                        for(int x =0; x < setPhrase.length(); x++)
                        {
                            if(Character.isDigit(setPhrase.charAt(x)))
                            {
                                hasDigit = true;
                            }
                        }
                        if(hasDigit == true)
                        {
                            JOptionPane.showMessageDialog(this, "That phrase contains a number.",
                                "New Host", JOptionPane.ERROR_MESSAGE);
                            setPhrase = JOptionPane.showInputDialog(this, "Please try again:",
                                "New Host", JOptionPane.INFORMATION_MESSAGE);
                                if(setPhrase == null)
                                {
                                    JOptionPane.showMessageDialog(this, "Host and phrase addition canceled.",
                                "New Host", JOptionPane.ERROR_MESSAGE);
                                break;
                                }
                            hasDigit = false;
                        }
                        else
                        {
                            goodPhrase = true;
                            gameHost = new Hosts(fName, lName);
                            gameHost.setHostPhrase(setPhrase);
                            gamePhrase.setGamePhrase(gameHost.getHostPhrase());
                            gamePhrase.setPlayingPhrase();
                            hLabel.setText(gameHost.getName());
                            gamePhraseLabel.setText(gamePhrase.getPlayingPhrase());
                            hostButton.setEnabled(false);
                            JOptionPane.showMessageDialog(this, gameHost.getName() + " will be your host for this game.",
                                "New Host", JOptionPane.INFORMATION_MESSAGE);
                            hostReady = true;
                            if(hostReady == true && playerReady == true)
                            {
                                startButton.setEnabled(true);
                            }
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Host and phrase addition canceled.",
                        "New Host", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if(source == pAddButton && source == hostButton)
        {
            startButton.setEnabled(true);
        }
    }
}