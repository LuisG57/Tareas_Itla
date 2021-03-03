package tarea5;


import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ej_6 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		// ponemos el look and feel del sistema operativo actual
		try {
			// Set System L&F
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej_6 window = new Ej_6();
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
	public Ej_6() {
		initialize();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		int x[] = { 100, 70, 130 };
		int y[] = { 50, 100, 100 };
		g2.drawPolygon(x, y, 3);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		setLayout(null);

		textField = new JTextField();
		textField.setBounds(10, 58, 45, 20);
		add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(156, 58, 45, 20);
		add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(80, 117, 45, 20);
		add(textField_2);

		JButton btnNewButton = new JButton("Verificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verificar();
			}
		});
		btnNewButton.setBounds(10, 193, 89, 23);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Limpiar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		btnNewButton_1.setBounds(125, 193, 89, 23);
		add(btnNewButton_1);
	}
	
	void verificar() {
		try {
			int a = Integer.parseInt(textField.getText().trim());
			int b = Integer.parseInt(textField_1.getText().trim());
			int c = Integer.parseInt(textField_2.getText().trim());
			if (a <= 0 || b <= 0 || c <= 0)
				JOptionPane.showMessageDialog(frame.getContentPane(), "Entrada invalida", "Tipo de triangulo", 3);
			else if (a >= (b + c) || c >= (b + a) || b >= (a + c))
			JOptionPane.showMessageDialog(frame.getContentPane(), "No es un triangulo", "Tipo de triangulo", 3);
			else if (a == b && b == c)
			JOptionPane.showMessageDialog(frame.getContentPane(), "Triangulo equilatero", "Tipo de triangulo", 1);
			else if (((a * a) + (b * b)) == (c * c) || ((a * a) + (c * c)) == (b * b)
					|| ((c * c) + (b * b)) == (a * a))
			JOptionPane.showMessageDialog(frame.getContentPane(), "Triangulo recto", "Tipo de triangulo", 1);
			else if (a != b && b != c && c != a)
				JOptionPane.showMessageDialog(frame.getContentPane(), "Triangulo escaleno", "Tipo de triangulo", 1);
			else if (a == b || c == a || c == b)
				JOptionPane.showMessageDialog(frame.getContentPane(), "Triangulo isosceles", "Tipo de triangulo", 1);
		} catch (Exception e1) {
			System.out.println(e1.getStackTrace());
		}
	}
}
