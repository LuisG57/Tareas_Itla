package tarea5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ej_2 {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej_2 window = new Ej_2();
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
	public Ej_2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 350, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numero 1");
		lblNewLabel.setBounds(40, 60, 57, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero 2");
		lblNewLabel_1.setBounds(40, 120, 57, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Numero Generado");
		lblNewLabel_2.setBounds(40, 208, 113, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(180, 205, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(180, 57, 86, 20);
		frame.getContentPane().add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(180, 117, 86, 20);
		frame.getContentPane().add(spinner_1);
		
		JButton btnNewButton = new JButton("Generar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textField.setText(genera(Integer.parseInt(spinner.getValue()+""), Integer.parseInt(spinner_1.getValue()+""))+"");
			}
		});
		btnNewButton.setBounds(97, 273, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
	}
	
	int genera(int n1, int n2) {
		n1++;
		int numero = 0;
		
		numero =(int) (Math.random() * (n2 - n1)) + n1;
		
		return numero; 
		
	}
	
}
