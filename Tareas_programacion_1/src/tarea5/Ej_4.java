package tarea5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ej_4 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej_4 window = new Ej_4();
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
	public Ej_4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 240);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(28, 92, 163, 20);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Escribe el titulo de una pelicula");
		lblNewLabel.setBounds(21, 46, 218, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Peliculas");
		lblNewLabel_1.setBounds(300, 46, 78, 14);
		panel.add(lblNewLabel_1);

		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Quantum of Solace");
		comboBox.addItem("Avatar");
		comboBox.setBounds(256, 91, 163, 22);
		panel.add(comboBox);

		JButton btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!textField.getText().equalsIgnoreCase("")) {
					String pel = textField.getText();
					comboBox.addItem(pel);
					textField.setText("");
					JOptionPane.showMessageDialog(frame.getContentPane(), "Pelicula " + pel + " añadida exitosamente!");
				} else {
					JOptionPane.showMessageDialog(frame.getContentPane(),
							"Por favor ingresa una pelicula en la caja de texto");
				}
			}
		});
		btnNewButton.setBounds(54, 148, 89, 23);
		panel.add(btnNewButton);
	}
}
