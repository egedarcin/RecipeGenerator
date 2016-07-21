
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class generate extends JPanel {
    private JPanel jcomp1;
    private JPanel jcomp4;
    private JPanel jcomp2;

    public generate() {
        //construct components
        jcomp1 = new JPanel ();
        jcomp4 = new JPanel (new GridLayout(3, 1));
        jcomp2 = new JPanel (new GridLayout(1, 1));
        
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
    		jcomp1.add(lbl);
    		
    	}
        //construct components
        
    	 JButton jcomp6 = new JButton ("My Favourite");
    	 jcomp6.setPreferredSize(new Dimension(115,25));
    	 JButton jcomp7 = new JButton ("My Fride");
    	 jcomp7.setPreferredSize(new Dimension(115,25));
    	 JButton jcomp8 = new JButton ("Explore");
    	 jcomp8.setPreferredSize(new Dimension(115,25));
    	 jcomp4.add(jcomp8);
    	 
    	 JButton jcomp9 = new JButton ("GENERATE");
    	 jcomp2.add(jcomp9);

         jcomp4.add(Box.createRigidArea(new Dimension(0,6)));
    	 jcomp4.add(jcomp7);

    	 jcomp4.add(Box.createRigidArea(new Dimension(0,6)));
    	 jcomp4.add(jcomp6);
    	 
    	 BoxLayout layout3 = new BoxLayout(jcomp4,BoxLayout.Y_AXIS);
    	 
    	 //jcomp4.setLayout(layout3);
    	 jcomp4.setLayout(new GridLayout(16, 1));
    	 

    	 jcomp7.setPreferredSize(new Dimension(115,25));
    	 
        //adjust size and set layout
        setPreferredSize (new Dimension (664, 373));
        GridLayout layout2 = new GridLayout(5, 5, 5, 5);
        jcomp1.setLayout (layout2);
        
        

        //adjust size and set layout
        BorderLayout layout = new BorderLayout(0, 0);
        setLayout (layout);

        //add components
        add (jcomp1, BorderLayout.CENTER);
        add (jcomp4, BorderLayout.EAST);

        add (jcomp2, BorderLayout.SOUTH);
    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("MyPanel");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new generate());
        frame.pack();
        frame.setVisible (true);
    }
}
