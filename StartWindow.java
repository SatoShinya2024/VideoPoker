import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.*;
import java.awt.BorderLayout;

public class StartWindow {
    public StartWindow(){
        JFrame frame = new JFrame("Video Poker");
        JLabel label = new JLabel("Welcome to Video Poker!");
        JButton startButton = new JButton("ゲームを始める");
        JButton exitButton =new JButton("ゲームをやめる");
        JButton explanationButton = new JButton("ゲームの説明を見る");
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        p1.setLayout(new FlowLayout());
        p2.setLayout(new FlowLayout());

        p1.add(label);
        p2.add(startButton);
        p2.add(exitButton);
        p2.add(explanationButton);

        label.setPreferredSize(new Dimension(950,300));
        label.setFont(new Font("Selif", Font.PLAIN, 70));

        startButton.setPreferredSize(new Dimension(270, 100));
        startButton.setFont(new Font("Selif", Font.PLAIN, 30));

        exitButton.setPreferredSize(new Dimension(270,100));
        exitButton.setFont(new Font("Selif", Font.PLAIN, 30));

        explanationButton.setPreferredSize(new Dimension(330,100));
        explanationButton.setFont(new Font("Selif", Font.PLAIN, 30));

        frame.getContentPane().add(p1,BorderLayout.NORTH);
        frame.getContentPane().add(p2, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(10, 10, 1000, 600);
        frame.setTitle("Video Poker");
        frame.setVisible(true);
        
        startButton.addMouseListener((MouseListener) new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                new GameWindow();
                frame.setVisible(false);
            }
        });
    }
}
