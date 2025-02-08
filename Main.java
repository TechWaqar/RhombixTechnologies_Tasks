import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();



        frame.setTitle("Word Counter");
        frame.setLayout(new BorderLayout());
        frame.setSize(700,550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        frame.setIconImage(new ImageIcon("logo.png").getImage());
        Font hfont = new Font("SansSerif",Font.BOLD,28);
        Font mfont = new Font("Serif",Font.PLAIN,15);
        Color color = new Color(85,37,130);

        JPanel header = new JPanel();
        header.setBackground(color);
        JLabel title = new JLabel("\u270D\uFE0F Word Counter \u2728");
        title.setFont(hfont);
        title.setForeground(Color.white);
        header.add(title, BorderLayout.CENTER);
        frame.add(header,BorderLayout.NORTH);

        JPanel inputpanel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea(10,50);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setFont(mfont);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(85,37,130),5),"Type Your Peragraph Here",0,0,new Font("Serif",Font.PLAIN,14),new Color(85,37,130)));
        inputpanel.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputpanel,BorderLayout.CENTER);

        JPanel footerpanel = new JPanel(new BorderLayout());
        JLabel footerlabel = new JLabel("Word Count 0", SwingConstants.CENTER);
        footerlabel.setFont(hfont);
        footerlabel.setForeground(color);
        footerlabel.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
        footerpanel.add(footerlabel, BorderLayout.CENTER);
        frame.add(footerpanel, BorderLayout.SOUTH);

        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });

        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                String text = textArea.getText().trim();
                int wordCount = text.isEmpty() ? 0 : text.split("\\s+").length;
                int charCount = text.length();
                footerlabel.setText("Word Count: " + wordCount + " | Character Count: " + charCount);
            }
        });

    }
}