 import java.util.Random;

public class Numbers.java
{
    pubic static void main(String[] args)
    {
        private int randomNum;

        public void setRandomNum(int r)
        {
            randomNum = r;
        }
        public int getRandomNum()
        {
            return randomNum;
        }

        public void generateNumber()
        {
            Random numGenerator = new Random();
            randomNum = numGenerator.nextInt(101);
        }

        public boolean compareNumber(int guess)
        {
            boolean result;

            if (guess = randomNum)
            {
                result = true;
                System.out.println("Congratutions, you guessed the Number!");
                return result;
            }
            else if(guess > randomNum)
            {
                result = false;
                System.out.println("I'm sorry, that guess was too high.");
                return result;
            }
            else
            {
                result = false;
                System.out.println("I'm sorry, that guess was too low.");
                return result;
            }

        }
    }
}