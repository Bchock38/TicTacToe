import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class
    private TicTacToe a;
    private final int WINDOW_WIDTH = 450;
    private final int WINDOW_HEIGHT = 500;
    private final int TITLE_BAR_HEIGHT = 23;

    private Image[] images;

    public TicTacToeViewer(TicTacToe a){
        images = new Image[2];
        images[0] = new ImageIcon("Resources/X.png").getImage();
        images[1] = new ImageIcon("Resources/O.png").getImage();
        this.a = a;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tic Tac Toe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public Image[] getImages() {
        return images;
    }
    public void paint (Graphics g){

        g.setColor(Color.white);
        g.fillRect(0,0,WINDOW_HEIGHT,WINDOW_WIDTH);
        g.setColor(Color.black);

        for (int i = 0; i < 3; i ++){
            g.drawString(Integer.toString(i), (i+1)*50 + 120, 130);
            g.drawString(Integer.toString(i), 130, (i+1)*50 + 130);
            for (int j = 0; j < 3; j++) {
                a.getBoard()[i][j].draw(g);
            }
        }

        if (a.getGameOver()){

            g.setFont(new Font("WinningFont",Font.BOLD,50));
            if (a.checkTie()){
                g.drawString("It's a Tie", 140,400);
            }
            else{
                g.drawString(a.getWinner() + " WINS", 140,400);
            }

        }

    }

}
