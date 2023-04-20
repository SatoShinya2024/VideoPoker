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

public class ResuldWindow {
    public ResuldWindow(Component C, int payout){
        JFrame frame = new JFrame("Video Poker");
        int score = Game.score;
        JLabel label = new JLabel("your score: " + score);
        String text = printRole(payout);
        JLabel result = new JLabel(text);
        JButton nextButton = new JButton("NEXT");
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        p1.add(label);
        p2.add(C);
        p2.setLayout(new FlowLayout());
        p3.add(result);
        p3.add(nextButton);
        p3.setLayout(new FlowLayout());

        label.setPreferredSize(new Dimension(400,100));
        label.setFont(new Font("Selif", Font.PLAIN, 45));
        result.setFont(new Font("Selif", Font.PLAIN, 35));
        nextButton.setPreferredSize(new Dimension(300,100));
        nextButton.setFont(new Font("Selif", Font.PLAIN, 30));
        frame.getContentPane().add(p1,BorderLayout.NORTH);
        frame.getContentPane().add(p2,BorderLayout.CENTER);
        frame.getContentPane().add(p3,BorderLayout.SOUTH);
        frame.setBounds(10, 10, 1200, 600);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        nextButton.addMouseListener((MouseListener) new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                new GameWindow();
                frame.setVisible(false);
            }
        });

    }

    public String printRole(int payout){
        String text;
        if(payout == 800){
            return ("ロイヤルストレートフラッシュ");
        }else if(payout == 50){
            text = ("ストレートフラッシュ");
        }else if(payout == 25){
            text = ("フォーカード");
        }else if(payout == 9){
            text = ("フルハウス");
        }else if(payout == 6){
            text = ("フラッシュ");
        }else if(payout == 4){
            text = ("ストレート");
        }else if(payout == 3){
            text = ("スリーカード");
        }else if(payout == 2){
            text = ("ツーペア");
        }else if(payout == 1){
            text = ("ジャックス以上のワンペア");
        }else if(payout == 0){
            text = ("ハイカード、またはテン以下のワンペア");
        }else{
            text = ("予期しない事態が起こりました。");
        }
        return text;
    }
}
