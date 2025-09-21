import java.util.Scanner;

public class GamePlay
{
    public static void main(String[] args)
    {
        String firstName;
        String lastName;
        String enterLast;

        Person player = new Person();

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter your name >> ");
        firstName = keyboard.nextLine();
        System.out.print("Would you like to enter your last name? (Y/N) >> ");
        enterLast = keyboard.nextLine();
        if (enterLast.startsWith("Y") || enterLast.startsWith("y"))
        {
            System.out.print("Enter your last name >> ");
            lastName = keyboard.nextLine();
            player.setFirstName(firstName);
            player.setLastName(lastName);
        }
        else
        {
            player.setFirstName(firstName);
        }

        Numbers winningNum = new Numbers();
        winningNum.generateNumber();
        int playerGuess;
        
        System.out.println("I'm thinking of a number between 0 and 100.");
        System.out.print("Try to guess it, " + player.getFirstName() + 
                                " " + player.getLastName() + " >> ");
        playerGuess = keyboard.nextInt();
        while (winningNum.compareNumber(playerGuess) == false)
        {
            System.out.print("Guess again, " + player.getFirstName() + " " + 
                                player.getLastName() + " >> ");
            playerGuess = keyboard.nextInt();
        }
    }
}
