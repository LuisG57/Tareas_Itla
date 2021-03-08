package tarea6;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;

import javax.swing.*;
import java.awt.Font;

public class Ej_1 implements ActionListener {

	private JFrame frmCalculadoraDeEnteros;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

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
					Ej_1 window = new Ej_1();
					window.frmCalculadoraDeEnteros.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ej_1() {

		menu();
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculadoraDeEnteros = new JFrame();
		frmCalculadoraDeEnteros.setTitle("Calculadora de enteros");
		frmCalculadoraDeEnteros.setResizable(false);
		frmCalculadoraDeEnteros.setBounds(100, 100, 450, 460);
		frmCalculadoraDeEnteros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculadoraDeEnteros.setJMenuBar(jmb);

		JPanel panel = new JPanel();
		frmCalculadoraDeEnteros.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(40, 78, 86, 20);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(166, 78, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(314, 78, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel = new JLabel("1er numero:");
		lblNewLabel.setBounds(40, 53, 86, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("2do numero:");
		lblNewLabel_1.setBounds(166, 53, 86, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("3er numero:");
		lblNewLabel_2.setBounds(314, 53, 86, 14);
		panel.add(lblNewLabel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 163, 414, 225);
		panel.add(scrollPane);

		table = new JTable(new DefaultTableModel(
				new String[] { "1er numero", "2do numero", "3er numero", "Resultado", "Operacion" }, 0));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_3 = new JLabel("Resultados:");
		lblNewLabel_3.setBounds(10, 138, 57, 14);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Calculadora de enteros");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(143, 11, 187, 14);
		panel.add(lblNewLabel_4);

		dtm = (DefaultTableModel) table.getModel();

	}

	void menu() {

		jmb = new JMenuBar();
		JMenu sum = new JMenu("Sumar");
		JMenu rest = new JMenu("Restar");
		JMenu mult = new JMenu("Multiplicar");
		JMenu div = new JMenu("Dividir");
		JMenu cal = new JMenu("Calcular");
		sdos = new JMenuItem("Sumar dos numeros");
		stres = new JMenuItem("Sumar tres numeros");
		rdos = new JMenuItem("Restar dos numeros");
		rtres = new JMenuItem("Restar tres numeros");
		mdos = new JMenuItem("Multiplicar dos numeros");
		mtres = new JMenuItem("Multiplicar tres numeros");
		ddos = new JMenuItem("Dividir dos numeros");
		dtres = new JMenuItem("Dividir tres numeros");
		jmb.add(cal);
		cal.add(sum);
		cal.add(rest);
		cal.add(mult);
		cal.add(div);
		sum.add(sdos);
		sum.add(stres);
		rest.add(rdos);
		rest.add(rtres);
		mult.add(mdos);
		mult.add(mtres);
		div.add(ddos);
		div.add(dtres);
		sdos.addActionListener(this);
		stres.addActionListener(this);
		rdos.addActionListener(this);
		rtres.addActionListener(this);
		mdos.addActionListener(this);
		mtres.addActionListener(this);
		ddos.addActionListener(this);
		dtres.addActionListener(this);

	}

	private JMenuItem sdos, stres, rdos, rtres, mdos, mtres, ddos, dtres;
	private JMenuBar jmb;
	private DefaultTableModel dtm;
	private JLabel lblNewLabel_4;

	@Override
	public void actionPerformed(ActionEvent e) {

		if (textField.getText().equalsIgnoreCase("") || textField_1.getText().equalsIgnoreCase("")) {

			JOptionPane.showMessageDialog(frmCalculadoraDeEnteros.getContentPane(),
					"Debes ingresar un 1er y 2do numero antes de realizar cualquier operacion", "Error", 0);

		} else {

			int n1, n2, n3, r;
			String[] rrow = { "", "", "", "", "" };

			try {
				n1 = Integer.parseInt(textField.getText().trim());
				n2 = Integer.parseInt(textField_1.getText().trim());
				if (textField_2.getText().equalsIgnoreCase("")) {
					n3 = 0;
				} else {
					n3 = Integer.parseInt(textField_2.getText().trim());
				}

				if (e.getSource() == sdos) {
					r = n1 + n2;
					rrow = new String[] { n1 + "", n2 + "", "No", r + "", "Suma" };
				} else if (e.getSource() == stres) {
					r = n1 + n2 + n3;
					rrow = new String[] { n1 + "", n2 + "", n3+"", r + "", "Suma" };
				} else if (e.getSource() == rdos) {
					r = n1 - n2;
					rrow = new String[] { n1 + "", n2 + "", "No", r + "", "Resta" };
				} else if (e.getSource() == rtres) {
					r = (n1 - n2) - n3;
					rrow = new String[] { n1 + "", n2 + "", n3+"", r + "", "Resta" };
				} else if (e.getSource() == mdos) {
					r = n1 * n2;
					rrow = new String[] { n1 + "", n2 + "", "No", r + "", "Multiplicacion" };
				} else if (e.getSource() == mtres) {
					if (textField_2.getText().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(frmCalculadoraDeEnteros.getContentPane(),
								"Debes introducir algo en el 3er numero,\n si quieres seleccion la opcion de solo dos numeros",
								"Error", 0);
						return;
					} else {
						r = n1 * n2 * n3;
						rrow = new String[] { n1 + "", n2 + "", n3 + "", r + "", "Multiplicacion" };
					}
				} else if (e.getSource() == ddos) {
					r = n1 / n2;
					rrow = new String[] { n1 + "", n2 + "", "No", r + "", "Division" };
				} else if (e.getSource() == dtres) {
					if (textField_2.getText().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(frmCalculadoraDeEnteros.getContentPane(),
								"Debes introducir algo en el 3er numero,\n si quieres seleccion la opcion de solo dos numeros",
								"Error", 0);
						return;
					} else {
						r = (n1 / n2) / n3;
						rrow = new String[] { n1 + "", n2 + "", n3 + "", r + "", "Division" };
					}
				}

				dtm.addRow(rrow);

			} catch (Exception e1) {

				JOptionPane.showMessageDialog(frmCalculadoraDeEnteros.getContentPane(),
						"ha ocurrido un error, te lo dejo acontinuacion:\n" + e1.getMessage(), "Error", 0);
				e1.printStackTrace();
				
			}

		}

	}

}
