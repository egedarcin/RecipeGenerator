import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class deneme {
	public static ArrayList<JLabel> getFridge(){
		ArrayList<JLabel> tmp  = new ArrayList<JLabel>();
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
    		tmp.add(lbl);
    		
	}
    	return tmp;
}
}