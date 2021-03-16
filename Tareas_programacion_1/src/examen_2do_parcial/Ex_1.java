package examen_2do_parcial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ex_1 {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	DefaultTableModel dtm;

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
					Ex_1 window = new Ex_1();
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
	public Ex_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 540, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Examen 2do Parcial - Creacion de Personas");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(113, 11, 317, 14);
		panel.add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(9, 109, 504, 2);
		panel.add(separator);

		textField = new JTextField();
		textField.setBounds(9, 76, 151, 20);
		panel.add(textField);
		textField.setColumns(10);

		JComboBox comboBox = new JComboBox(new String[] { "Seleccionar", "Niño", "Joven", "Adulto" });
		comboBox.setBounds(271, 75, 131, 22);
		panel.add(comboBox);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(170, 76, 91, 20);
		panel.add(spinner);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(9, 122, 504, 264);
		panel.add(scrollPane);

		table = new JTable(new DefaultTableModel(new String[] { "Nombre", "Persona", "Edad" }, 0));
		scrollPane.setViewportView(table);
		dtm = (DefaultTableModel) table.getModel();

		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String nombre = textField.getText().trim();
				int edad = (int) spinner.getValue();
				String tipo = comboBox.getSelectedItem().toString();

				if (tipo.equalsIgnoreCase("Seleccionar")) {
					JOptionPane.showMessageDialog(frame.getContentPane(),
							"Debes seleccionar el tipo de persona que deseas agregar", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else if (textField.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(frame.getContentPane(),
							"Debes agregar el nombre de la persona que deseas agregar", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else if ((int) spinner.getValue() == 0) {
					JOptionPane.showMessageDialog(frame.getContentPane(),
							"Debes agregar la edad de la persona que deseas agregar", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else if ((int) spinner.getValue() < 0) {
					JOptionPane.showMessageDialog(frame.getContentPane(),
							"la edad de la persona que deseas agregar debe de ser mayor a cero", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				Persona per;

				if (tipo.equalsIgnoreCase("Niño")) {
					per = new Nino(nombre, edad, tipo);
					agregar(per);
					notificar(per.accionProceso());
				} else if (tipo.equalsIgnoreCase("Joven")) {
					per = new Joven(nombre, edad, tipo);
					agregar(per);
					notificar(per.accionProceso());
				} else if (tipo.equalsIgnoreCase("Adulto")) {
					per = new Adulto(nombre, edad, tipo);
					agregar(per);
					notificar(per.accionProceso());
				}

				textField.setText("");
				comboBox.setSelectedIndex(0);
				spinner.setValue(0);

			}
		});
		btnNewButton.setBounds(412, 75, 89, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Eliminar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					int row = table.getSelectedRow();
					dtm.removeRow(row);
					Persona.setProc("Eliminar");
					notificar();

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}
		});
		btnNewButton_1.setBounds(159, 394, 89, 23);
		panel.add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(9, 52, 46, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Edad");
		lblNewLabel_2.setBounds(170, 52, 46, 14);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Tipo");
		lblNewLabel_3.setBounds(271, 52, 46, 14);
		panel.add(lblNewLabel_3);

		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.clearSelection();
				Persona.setProc("cancelar");
				notificar();

			}
		});
		btnNewButton_2.setBounds(271, 394, 89, 23);
		panel.add(btnNewButton_2);
	}

	void agregar(Persona persona) {

		String row[] = { persona.getNombre(), (String) persona.getPersona(), persona.getEdad() + "" };
		Persona.setProc("Agregar");
		dtm.addRow(row);

	}

	void notificar() {
		JOptionPane.showMessageDialog(frame.getContentPane(),
				"la opcion de " + Persona.getProc() + " se ha realizado existosamente!", "Accion Proceso",
				JOptionPane.INFORMATION_MESSAGE);
	}

	void notificar(String mensaje) {
		JOptionPane.showMessageDialog(frame.getContentPane(), mensaje, "Accion Proceso",
				JOptionPane.INFORMATION_MESSAGE);
	}

	void eliminar() {

	}

}
