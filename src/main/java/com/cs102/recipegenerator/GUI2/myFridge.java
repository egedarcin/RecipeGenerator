

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class myFridge extends JPanel {
    
	
    public myFridge() {
    	System.out.println("Yay you clicked me");
    	JLabel lbl;
    	
    	ImageIcon image = new ImageIcon(new ImageIcon("C:/bacon.jpg").getImage().getScaledInstance(55, 55, Image.SCALE_DEFAULT));
    	for(int i =0;i < 20;i++){
    		lbl = new JLabel(image);
    		lbl.addMouseListener(new MouseAdapter() {
                
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Yay you clicked me");
                }

            });
    		
    		lbl.setSize(20, 20);
    		lbl.setText("BACON");
    		lbl.setHorizontalTextPosition(JLabel.CENTER);
    		lbl.setVerticalTextPosition(JLabel.BOTTOM);
    		add(lbl);
    		
    	}
        //construct components
        

        //adjust size and set layout
        setPreferredSize (new Dimension (664, 373));
        GridLayout layout = new GridLayout(5, 5, 5, 5);
        setLayout (layout);

        //add components
        
    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("MyPanel");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new myFridge());
        frame.pack();
        frame.setVisible (true);
    }
}
