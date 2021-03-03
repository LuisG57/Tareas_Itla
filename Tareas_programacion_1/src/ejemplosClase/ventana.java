package ejemplosClase;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ventana {

	private JFrame frame;
	private JTextField textField;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana window = new ventana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Incrementar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int num = Integer.parseInt(textField.getText().trim());
				num++;
				textField.setText("" + num);
				// textField.setText(Integer.parseInt(textField.getText()) + 1 +"");
			}
		});
		btnNewButton.setBounds(235, 100, 115, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Decrementar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = Integer.parseInt(textField.getText().trim());
				num--;
				textField.setText("" + num);
			}
		});
		btnNewButton_1.setBounds(59, 100, 122, 23);
		frame.getContentPane().add(btnNewButton_1);

		textField = new JTextField();
		textField.setText("0");
		textField.setBounds(163, 28, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnNewButton_2 = new JButton("Reiniciar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(0+"");
			}
		});
		btnNewButton_2.setBounds(160, 175, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
}
