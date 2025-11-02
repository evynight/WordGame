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

    JMenuBar menuBar = new JMenuBar();
    JMenu gameMenu = new JMenu("Game");
    JMenuItem playerAdd = new JMenuItem("Add Player");
    JMenuItem hostAdd = new JMenuItem("Add Host");

    JLabel pListLabel = new JLabel("[Players]");
    JLabel hLabel = new JLabel("[Host]");
    JLabel gamePhraseLabel = new JLabel("[Playing Phrase]");
    JButton startButton = new JButton("Start game");
    public GUI()
    {
        super("Phrase Finders");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        setJMenuBar(menuBar);
        menuBar.add(gameMenu);
        gameMenu.add(playerAdd);
        gameMenu.add(hostAdd);
        gameMenu.setMnemonic('G');

        add(pListLabel);
        add(hLabel);
        add(gamePhraseLabel);
        add(startButton);

        playerAdd.addActionListener(this);
        hostAdd.addActionListener(this);
        startButton.addActionListener(this);
        startButton.setEnabled(false);
    }
    @Override
    public void actionPerformed(ActionEvent action)
    {
        Object source = action.getSource();

        if(source == playerAdd)
        {
            if(playerCount == MAX_PLAYERS)
            {
                JOptionPane.showMessageDialog(this, "No more players can be added.", "Max players reached",
                    JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                String fName;
                String lName;
                int entLast;
                
                fName = JOptionPane.showInputDialog(this, "Enter player's first name", 
                    "New Player", JOptionPane.PLAIN_MESSAGE);
                if(fName != null)
                {
                    entLast = JOptionPane.showConfirmDialog(this, "Would you like to enter a last name?", "",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(entLast == JOptionPane.YES_OPTION)
                    {
                        lName = JOptionPane.showInputDialog(this, "Enter player's last name", 
                        "New Player", JOptionPane.PLAIN_MESSAGE);
                        if(lName != null)
                        {
                            players[playerCount] = new Players(fName, lName);
                            playerList.append(players[playerCount].getName() + " | ");
                            pListLabel.setText(playerList.toString());
                            JOptionPane.showMessageDialog(this, players[playerCount].getName() +
                            " has been added to the game.", "New Player", JOptionPane.PLAIN_MESSAGE);
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
                                JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    else
                    {
                        players[playerCount] = new Players(fName);
                        playerList.append(players[playerCount].getName() + " | ");
                        pListLabel.setText(playerList.toString());
                        JOptionPane.showMessageDialog(this, players[playerCount].getName() +
                        " has been added to the game.", "New Player", JOptionPane.PLAIN_MESSAGE);
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
                    JOptionPane.showMessageDialog(this, "Player addition canceled.", "", JOptionPane.INFORMATION_MESSAGE);
                }
            }    
        }
        if(source == hostAdd)
        {
            String fName = null;
            String lName = null;

            fName = JOptionPane.showInputDialog(this, "Enter host's first name:",
                "New Host", JOptionPane.PLAIN_MESSAGE);
            if(fName != null)
            {
                lName = JOptionPane.showInputDialog(this, "Enter host's last name:",
                    "New Host", JOptionPane.PLAIN_MESSAGE);
                if(lName == null)
                {
                    JOptionPane.showMessageDialog(this, "Host additon canceled.",
                    "New Host", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Host additon canceled.", "New Host",
                    JOptionPane.INFORMATION_MESSAGE);
            }
            
            if(fName != null && lName != null)
            {
                String setPhrase;
                setPhrase = JOptionPane.showInputDialog(this, "Write a phrase for players to guess:" +
                    "\n(Make sure to not to include any numbers)",
                    "New Phrase", JOptionPane.QUESTION_MESSAGE);
                if(setPhrase != null)
                {
                    boolean goodPhrase = false;
                    boolean hasDigit = false;
                    while(goodPhrase != true)
                    {
                        for(int x = 0; x < setPhrase.length(); x++)
                        {
                            if(Character.isDigit(setPhrase.charAt(x)))
                            {
                                hasDigit = true;
                            }
                        }
                        if(hasDigit == true)
                        {
                            JOptionPane.showMessageDialog(this, "That phrase contains a number.",
                                "New Phrase", JOptionPane.ERROR_MESSAGE);
                            setPhrase = JOptionPane.showInputDialog(this, "Please try again:",
                                "New Phrase", JOptionPane.PLAIN_MESSAGE);
                                if(setPhrase == null)
                                {
                                    JOptionPane.showMessageDialog(this, "Host and phrase addition canceled.",
                                "New Phrase", JOptionPane.INFORMATION_MESSAGE);
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
                            hLabel.setText("Host: " + gameHost.getName());
                            gamePhraseLabel.setText("Current Phrase: " + gamePhrase.getPlayingPhrase());
                            hostAdd.setEnabled(false);
                            JOptionPane.showMessageDialog(this, gameHost.getName() + " will be your host for this game.",
                                "New Host", JOptionPane.PLAIN_MESSAGE);
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
        if(source == startButton)
        {
            JOptionPane.showMessageDialog(this, "Welcome to a game of Phrase Finders!" +
                "\nI'm your host, " + gameHost.getName() + "." +
                "\nI'm going to provide a secret phrase.\n" +
                "Each of you will take turns trying to find what it is one letter at a time.\n" +
                "Make sure you only enter a single letter! Otherwise you forfeit your turn.\n" +
                "No special characters, either. Letters only!\n" +
                "Is everyone ready? Let's get started!\n", "Begin Phrase Finders!", JOptionPane.PLAIN_MESSAGE);

            Turn findGame = new Turn();
            boolean roundEnd = false;
            boolean gameEnd = false;
            boolean continueTurn = false;
            
            while(roundEnd != true && gameEnd != true)
            {
            while(roundEnd != true)
                {
                    for(int x = 0; x < playerCount; x++)
                    {
                        continueTurn = false;
                        while(continueTurn == true);
                        {
                            continueTurn = findGame.takeTurn(players[x], gameHost);
                        
                            if(gamePhrase.getGamePhrase().equals(gamePhrase.getPlayingPhrase()))
                            {
                                roundEnd = true;
                                Physical roundPrize = new Physical();
                                String prizeWon = roundPrize.receivePrize();
                                JOptionPane.showMessageDialog(this, "Congratulations on completing the phrase, " + 
                                    players[x].getName() + "!\nThe prize for this round is " +
                                    "this\n" +  prizeWon + "!", players[x].getName() + " Wins!", JOptionPane.PLAIN_MESSAGE);

                                if(players[x].getPrize() == null)
                                {
                                    players[x].setPrize(prizeWon);
                                }
                                else
                                {
                                    int swap = JOptionPane.showConfirmDialog(this, "Sorry, you can only keep " +
                                        "one prize at a time.\nDo you want to swap it out?", players[x] +
                                        "'s Prize", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                                    if(swap == JOptionPane.YES_NO_OPTION)
                                    {
                                        players[x].setPrize(prizeWon);
                                    }
                                }
                                break;
                            }
                        
                        }  

                    }
                }
                int contPlay = JOptionPane.showConfirmDialog(this,"\nShall we continue playing?",
                    "Continue",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(contPlay == JOptionPane.YES_OPTION)
                {
                    String newPhrase = JOptionPane.showInputDialog(this, gameHost.getName() + ": What will this " +
                        "round's phrase be?", "New Phrase", JOptionPane.QUESTION_MESSAGE);
                        while(newPhrase == null)
                        {
                            newPhrase = JOptionPane.showInputDialog(this, "C'mon, don't be like that." +
                            "\nGive me something to work with.", "New Phrase", JOptionPane.QUESTION_MESSAGE);
                        }
                    gameHost.setHostPhrase(newPhrase);
                    gamePhrase.setGamePhrase(gameHost.getHostPhrase());
                    gamePhraseLabel.setText("Current Phrase: " + gamePhrase.getPlayingPhrase());
                    roundEnd = false;
                    gameEnd = false;
                }
                else
                {   
                    gameEnd  = true;
                    JOptionPane.showMessageDialog(this, gameHost.getName() + ": Here are the final results",
                        "Game End", JOptionPane.PLAIN_MESSAGE);
                    for(int x = 0; x < playerCount; x++)
                    {
                        if(players[x].getPrize() == null)
                        {
                            JOptionPane.showMessageDialog(this, players[x].getName() + "won" +
                                "...uhm, they had a good time.", players[x].getName() + "'s Prize", JOptionPane.PLAIN_MESSAGE);
                        }
                        else
                        {
                        JOptionPane.showMessageDialog(this, players[x].getName() + " won a(n) " +
                            players[x].getPrize() + ".", players[x].getName() +
                            "'s Prize", JOptionPane.PLAIN_MESSAGE);
                        }
                    }
                    playerAdd.setEnabled(false);
                    hostAdd.setEnabled(false);
                    startButton.setEnabled(false);
                }
            }
        }
    }
}