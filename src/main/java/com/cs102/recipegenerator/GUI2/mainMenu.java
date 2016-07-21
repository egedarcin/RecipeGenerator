

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;



public class mainMenu extends JPanel {
    private JLabel jcomp1;
    private JLabel jcomp2;
    private JLabel jcomp3;
    private JPanel jcomp4;
    private JLabel jcomp5;
    private JButton jcomp6;
    private JButton jcomp7;
    private JButton jcomp8;
    private JButton jcomp9;
    private JButton jcomp10;
    private JButton jcomp11;

    
    	
    public mainMenu() {
        //construct components
        jcomp1 = new JLabel ("Main Menu");
        
        jcomp2 = new JLabel ("Recipe Generator");
        jcomp3 = new JLabel ("Feed");
        jcomp4 = new JPanel ();
        jcomp5 = new JLabel ("newLabel");
        jcomp6 = new JButton ("My Favourite");
        jcomp7 = new JButton ("My Fridge");
        jcomp8 = new JButton ("Explore");
        jcomp9 = new JButton ("My Recipe");
        jcomp10 = new JButton ("Last Recipe");
        jcomp11 = new JButton ("Generate");
        
        
        jcomp7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JPanel tmp = new myFridge();
                        jcomp4 = (tmp);
                        
                    

               validate();
                revalidate();
            }
        });
        
        //adjust size and set layout
        setPreferredSize (new Dimension (664, 373));
        setLayout (null);

        //add components
        add (jcomp1);
        add (jcomp2);
        add (jcomp3);
        add (jcomp4);
        add (jcomp5);
        add (jcomp6);
        add (jcomp7);
        add (jcomp8);
        add (jcomp9);
        add (jcomp10);
        add (jcomp11);

        
        

        
        
        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (30, 20, 135, 30);
        jcomp2.setBounds (280, 20, 100, 25);
        jcomp3.setBounds (535, 15, 100, 25);
        jcomp4.setBounds (145, 60, 350, 270);
        jcomp5.setBounds (515, 65, 110, 250);
        jcomp6.setBounds (15, 75, 115, 25);
        jcomp7.setBounds (15, 115, 115, 25);
        jcomp8.setBounds (15, 155, 115, 25);
        jcomp9.setBounds (15, 195, 115, 25);
        jcomp10.setBounds (15, 235, 115, 25);
        jcomp11.setBounds (15, 275, 115, 25);
    }

    

    public static void main (String[] args) {
        JFrame frame = new JFrame ("MyPanel");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new mainMenu());
        frame.pack();
        frame.setVisible (true);
    }
}
