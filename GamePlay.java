public class GamePlay
{
    public static void main(String[] args)
    {
        GUI game = new GUI();
        final int WIDTH = 400;
        final int HEIGHT = 350;
        final int HORIZ = 800;
        final int VERT = 300;
        game.setBounds(HORIZ,VERT, WIDTH, HEIGHT);
        game.setVisible(true);
    }
}
