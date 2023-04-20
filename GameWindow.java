import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.BorderLayout;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;

public class GameWindow{
    public GameWindow(){
        Game Game = new Game();
        JFrame frame = new JFrame("Video Poker");
        JLabel label = new JLabel("your score: " + Game.score);
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        ArrayList<Card> FirstHand = Game.FirstHand();
        ArrayList<Boolean> HoldOrChange = Game.HoldOrChange();
        
        CardImage cardImage = new CardImage(FirstHand);
        JButton cardChange = new JButton("Card Change");
        p1.add(label);
        p1.add(cardChange);
        p1.setLayout(new FlowLayout());
        p2.add(cardImage);
        p2.setLayout(new FlowLayout());


        HoldButton holdButton0 = new HoldButton(HoldOrChange, 0);
        HoldButton holdButton1 = new HoldButton(HoldOrChange, 1);
        HoldButton holdButton2 = new HoldButton(HoldOrChange, 2);
        HoldButton holdButton3 = new HoldButton(HoldOrChange, 3);
        HoldButton holdButton4 = new HoldButton(HoldOrChange, 4);
        
        p3.add(holdButton0);
        p3.add(holdButton1);
        p3.add(holdButton2);
        p3.add(holdButton3);
        p3.add(holdButton4);
        p3.setLayout(new FlowLayout());
        holdButton0.setPreferredSize(new Dimension(200,70));
        holdButton0.setFont(new Font("Selif", Font.PLAIN, 30));
        holdButton1.setPreferredSize(new Dimension(200,70));
        holdButton1.setFont(new Font("Selif", Font.PLAIN, 30));
        holdButton2.setPreferredSize(new Dimension(200,70));
        holdButton2.setFont(new Font("Selif", Font.PLAIN, 30));
        holdButton3.setPreferredSize(new Dimension(200,70));
        holdButton3.setFont(new Font("Selif", Font.PLAIN, 30));
        holdButton4.setPreferredSize(new Dimension(200,70));
        holdButton4.setFont(new Font("Selif", Font.PLAIN, 30));

        label.setPreferredSize(new Dimension(400,100));
        label.setFont(new Font("Selif", Font.PLAIN, 45));
        cardChange.setPreferredSize(new Dimension(300,100));
        cardChange.setFont(new Font("Selif", Font.PLAIN, 30));
        frame.getContentPane().add(p1,BorderLayout.NORTH);
        frame.getContentPane().add(p2,BorderLayout.CENTER);
        frame.getContentPane().add(p3,BorderLayout.SOUTH);
        frame.setBounds(10, 10, 1200, 600);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        cardChange.addMouseListener((MouseListener) new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                ArrayList<Card> newHand = Game.handChange(FirstHand, HoldOrChange);
                CardImage newCardImage = new CardImage(newHand);
                int payout = Game.Role(newHand);
                Game.score = Game.score + 3 * payout;
                new ResuldWindow(newCardImage, payout);
                frame.setVisible(false);
            }
        });
    }
}

class CardImage extends Component{
    
    ArrayList<BufferedImage> CardImageList = new ArrayList<>();
    CardImage(ArrayList<Card> Hand){
        for(int i = 0; i < Hand.size(); i++){
            String FilePath = Hand.get(i).getFilePath();
            try{
                CardImageList.add(ImageIO.read(new File(FilePath)));
            }catch(IOException e){
                System.out.println("image file not found.[" + FilePath + "]");
            }
        }
       
    }
    public void paint(Graphics graphics){
        for(int i = 0; i < CardImageList.size(); i++){
            graphics.drawImage(CardImageList.get(i), i * 230 + 25, 0, null);
        }
    }
    public Dimension getPreferredSize(){
        int width = 1200;
        int height = 500;
        return new Dimension(width, height);
    }

}

class HoldButton extends JButton{
    public HoldButton(ArrayList<Boolean> holdorchange, int i){
        super();
        setText("Hold");

        addMouseListener((MouseListener) new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if(getText().matches("Hold")){
                    setText("Change");
                    holdorchange.set(i, false);
                }else if(getText().matches("Change")){
                    setText("Hold");
                    holdorchange.set(i, true);
                }
            }
        });
        
    }
}
