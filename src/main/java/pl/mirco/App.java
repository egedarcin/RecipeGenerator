/**
 * Przykład ze szkolenia
 */
package pl.mirco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class App extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField arg1;
	private JTextField arg2;
	private JLabel lblWynik;
	private JLabel label;

	public App() {

		arg1 = new JTextField();
		add(arg1);
		arg1.setColumns(10);

		label = new JLabel("+");
		add(label);

		arg2 = new JTextField();
		add(arg2);
		arg2.setColumns(10);

		JLabel label_1 = new JLabel("=");
		add(label_1);

		lblWynik = new JLabel("wynik");
		add(lblWynik);

		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int argInt1 = Integer.parseInt(arg1.getText());
					int argInt2 = Integer.parseInt(arg2.getText());
					int sum = argInt1 + argInt2;
					lblWynik.setText(sum + "");
					label.setText("+");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Źle i niedobrze",
							"Błąd", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		add(btnDodaj);

		JButton btnOdejmij = new JButton("Odejmij");
		btnOdejmij.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int argInt1 = Integer.parseInt(arg1.getText());
				int argInt2 = Integer.parseInt(arg2.getText());

				int sum = argInt1 - argInt2;
				lblWynik.setText(sum + "");
				label.setText("-");

			}
		});
		add(btnOdejmij);
	}

	public static void main(String[] args) throws InvocationTargetException,
			InterruptedException {

		SwingUtilities.invokeAndWait(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame();
				frame.setContentPane(new App());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);

			}
		});
	}

}
