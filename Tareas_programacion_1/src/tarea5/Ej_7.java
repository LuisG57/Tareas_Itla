package tarea5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Ej_7 {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblNewLabel_2;

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
					Ej_7 window = new Ej_7();
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
	public Ej_7() {
				
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

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(10, 11, 61, 14);
		frame.getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(60, 8, 109, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Numero ID:");
		lblNewLabel_1.setBounds(10, 49, 80, 14);
		frame.getContentPane().add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("0");
		lblNewLabel_2.setBounds(100, 49, 109, 14);
		frame.getContentPane().add(lblNewLabel_2);

		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox comboBox = new JComboBox(socios);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				textField.setText(socios[comboBox.getSelectedIndex()].getNombre());
				textField_1.setText(socios[comboBox.getSelectedIndex()].getApellido());
				lblNewLabel_2.setText(socios[comboBox.getSelectedIndex()].getNumero()+"");
			}
		});
		comboBox.setBounds(10, 90, 159, 22);
		frame.getContentPane().add(comboBox);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(197, 11, 61, 14);
		frame.getContentPane().add(lblApellido);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(263, 8, 109, 20);
		frame.getContentPane().add(textField_1);
		
		textField.setText(socios[comboBox.getSelectedIndex()].getNombre());
		textField_1.setText(socios[comboBox.getSelectedIndex()].getApellido());
		lblNewLabel_2.setText(socios[comboBox.getSelectedIndex()].getNumero()+"");
		
	}
	Socios[] socios= {new Socios("Randy", "Alcala"), new Socios("Edilith", "Zabala"), new Socios("Roberto", "Luna")};
	private JLabel lblApellido;
	private JTextField textField_1;
}

class Socios {

	Socios(String nombre, String apellido) {

		this.nombre = nombre;
		this.apellido = apellido;
		signumero++;
		numero = signumero;

	}

	
	
	@Override
	public String toString() {
		return apellido + ", " + nombre ;
	}



	private String nombre, apellido;
	private int numero;
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public int getNumero() {
		return numero;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}



	private static int signumero = 0;

}