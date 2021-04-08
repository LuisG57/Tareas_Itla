package tarea7;

import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

public class Ej_1 {

	private JFrame frame;
	private JTable table;
	private JTable table_1;

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

	Connection miconexion;
	Statement miStatement;
	ResultSet miresultset;
	DefaultTableModel modelo, modelo1;
	private JTextField textField;

	public Ej_1() {

		// 1. CREAR CONEXION

		try {

			String titulos[] = { "Hora", "Dia", "Mes", "Actividad" };
			modelo = new DefaultTableModel(null, titulos);
			modelo1 = new DefaultTableModel(null, titulos);

			miconexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Programacion_1?autoReconnect=true&useSSL=false", "root", "");

			// 2. CREAR UN OBJETO STATEMENT

			miStatement = miconexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// String instruccionsql = "INSERT INTO PRODUCTOSNUEVOS(C”DIGOARTÌCULO,
		// NOMBREARTÕCULO, PRECIO) VALUES ('AR77', 'PANTAL”N', '25.35')";

		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 580, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Buscar y modificar", null, panel, null);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(10, 130, 539, 233);
		panel.add(scrollPane);

		table = new JTable(modelo);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 117, 539, 2);
		panel.add(separator);

		String[] months = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
				"Octubre", "Noviembre", "Diciembre" };

		JComboBox comboBox = new JComboBox(months);
		comboBox.setBounds(278, 49, 124, 22);
		panel.add(comboBox);

		String days[] = { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" };

		JComboBox comboBox_1 = new JComboBox(days);
		comboBox_1.setBounds(144, 49, 124, 22);
		panel.add(comboBox_1);

		String times[] = new String[24];

		for (int i = 0; i < 24; i++) {

			if (i < 10) {
				times[i] = "0" + i + ":00";
			} else {
				times[i] = i + ":00";
			}

			System.out.println(times[i]);
		}

		JComboBox comboBox_2 = new JComboBox(times);
		comboBox_2.setBounds(10, 49, 124, 22);
		panel.add(comboBox_2);

		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				modelo.setRowCount(0);

				String resultados[] = new String[4];

				try {
					miresultset = miStatement
							.executeQuery("SELECT * FROM TAREA_6 WHERE HORA='" + times[comboBox_2.getSelectedIndex()]
									+ "' AND DIA = '" + days[comboBox_1.getSelectedIndex()] + "' AND MES='"
									+ months[comboBox.getSelectedIndex()] + "' ");
					while (miresultset.next() == true) {

						resultados[0] = miresultset.getString(1);
						resultados[1] = miresultset.getString(2);
						resultados[2] = miresultset.getString(3);
						resultados[3] = miresultset.getString(4);

						modelo.addRow(resultados);
						// System.out.println(miresultset.getString("dia"));

					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(433, 49, 89, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Mostrar todos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				modelo.setRowCount(0);

				String resultados[] = new String[4];

				try {
					miresultset = miStatement.executeQuery("SELECT * FROM TAREA_6");
					while (miresultset.next() == true) {

						resultados[0] = miresultset.getString(1);
						resultados[1] = miresultset.getString(2);
						resultados[2] = miresultset.getString(3);
						resultados[3] = miresultset.getString(4);

						modelo.addRow(resultados);
						// System.out.println(miresultset.getString("dia"));

					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_1.setBounds(52, 83, 124, 23);
		panel.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("Busquedas");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 0, 131, 22);
		panel.add(lblNewLabel);

		JButton btnNewButton_1_1 = new JButton("Actualizar");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int r = table.getSelectedRow();
				String d = (String) table.getModel().getValueAt(r, 3);
				String resultados[] = new String[4];

				try {

					miStatement.executeUpdate("UPDATE `tarea_6` SET `hora`='" + times[comboBox_2.getSelectedIndex()]
							+ "',`dia`='" + days[comboBox_1.getSelectedIndex()] + "',`mes`='"
							+ months[comboBox.getSelectedIndex()] + "',`actividad`='"+textField.getText().trim()+"' WHERE actividad='"
							+ d + "'");

					miresultset = miStatement.executeQuery("SELECT * FROM TAREA_6");
					modelo.setRowCount(0);
					while (miresultset.next() == true) {

						resultados[0] = miresultset.getString(1);
						resultados[1] = miresultset.getString(2);
						resultados[2] = miresultset.getString(3);
						resultados[3] = miresultset.getString(4);

						modelo.addRow(resultados);

						// System.out.println(miresultset.getString("dia"));

					}
					comboBox.setSelectedIndex(0);
					comboBox_1.setSelectedIndex(0);
					comboBox_2.setSelectedIndex(0);
					textField.setText("");

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_1_1.setBounds(200, 82, 124, 23);
		panel.add(btnNewButton_1_1);

		JLabel lblNewLabel_1 = new JLabel("Hora");
		lblNewLabel_1.setBounds(52, 33, 46, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Dia");
		lblNewLabel_1_1.setBounds(189, 33, 46, 14);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Mes");
		lblNewLabel_1_2.setBounds(327, 33, 46, 14);
		panel.add(lblNewLabel_1_2);

		JButton btnNewButton_1_1_1 = new JButton("Eliminar");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int r = table.getSelectedRow();
				String d = (String) table.getModel().getValueAt(r, 3);
				String resultados[] = new String[4];

				try {

					miStatement.executeUpdate("DELETE FROM `tarea_6` WHERE actividad='" + d + "'");

					miresultset = miStatement.executeQuery("SELECT * FROM TAREA_6");
					modelo.setRowCount(0);
					while (miresultset.next() == true) {

						resultados[0] = miresultset.getString(1);
						resultados[1] = miresultset.getString(2);
						resultados[2] = miresultset.getString(3);
						resultados[3] = miresultset.getString(4);

						modelo.addRow(resultados);

						// System.out.println(miresultset.getString("dia"));

					}
					comboBox.setSelectedIndex(0);
					comboBox_1.setSelectedIndex(0);
					comboBox_2.setSelectedIndex(0);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_1_1_1.setBounds(345, 82, 124, 23);
		panel.add(btnNewButton_1_1_1);

		JButton btnNewButton_2 = new JButton("Limpiar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				modelo.setRowCount(0);
				comboBox.setSelectedIndex(0);
				comboBox_1.setSelectedIndex(0);
				comboBox_2.setSelectedIndex(0);

			}
		});
		btnNewButton_2.setBounds(479, 83, 70, 23);
		panel.add(btnNewButton_2);

		textField = new JTextField();
		textField.setBounds(10, 402, 539, 20);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Actividad ( solo para actualizaciones ):");
		lblNewLabel_2.setBounds(10, 377, 199, 14);
		panel.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Agregar", null, panel_1, null);
		panel_1.setLayout(null);

		JComboBox comboBox_2_1 = new JComboBox(times);
		comboBox_2_1.setBounds(61, 60, 124, 22);
		panel_1.add(comboBox_2_1);

		JLabel lblNewLabel_1_3 = new JLabel("Hora");
		lblNewLabel_1_3.setBounds(103, 44, 46, 14);
		panel_1.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_1_1 = new JLabel("Dia");
		lblNewLabel_1_1_1.setBounds(240, 44, 46, 14);
		panel_1.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_2_1 = new JLabel("Mes");
		lblNewLabel_1_2_1.setBounds(378, 44, 46, 14);
		panel_1.add(lblNewLabel_1_2_1);

		JComboBox comboBox_3 = new JComboBox(months);
		comboBox_3.setBounds(329, 60, 124, 22);
		panel_1.add(comboBox_3);

		JComboBox comboBox_1_1 = new JComboBox(days);
		comboBox_1_1.setBounds(195, 60, 124, 22);
		panel_1.add(comboBox_1_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 304, 539, 2);
		panel_1.add(separator_1);

		JLabel lblAgregar = new JLabel("Agregar");
		lblAgregar.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblAgregar.setBounds(10, 11, 131, 22);
		panel_1.add(lblAgregar);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 316, 539, 106);
		panel_1.add(scrollPane_1);

		table_1 = new JTable(modelo1);
		scrollPane_1.setViewportView(table_1);

		JTextArea textArea = new JTextArea();
		textArea.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBounds(10, 130, 539, 106);
		panel_1.add(textArea);

		JLabel lblNewLabel_1_3_1 = new JLabel("Descripcion:");
		lblNewLabel_1_3_1.setBounds(10, 105, 113, 14);
		panel_1.add(lblNewLabel_1_3_1);

		JButton btnNewButton_1_2 = new JButton("Agregar y guardar");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				modelo1.setRowCount(0);

				String resultados[] = new String[4];

				if (textArea.getText().equalsIgnoreCase("")) {

					JOptionPane.showMessageDialog(frame.getContentPane(), "Debes ingresar una descripcion", "Error",
							JOptionPane.ERROR_MESSAGE);

				} else {

					try {

						miStatement.executeUpdate("INSERT INTO `tarea_6`(`hora`, `dia`, `mes`, `actividad`) VALUES ('"
								+ times[comboBox_2_1.getSelectedIndex()] + "','" + days[comboBox_1_1.getSelectedIndex()]
								+ "','" + months[comboBox_3.getSelectedIndex()] + "','" + textArea.getText().trim()
								+ "')");

						miresultset = miStatement
								.executeQuery("SELECT * FROM TAREA_6 WHERE ACTIVIDAD='" + textArea.getText() + "'");
						while (miresultset.next() == true) {

							resultados[0] = miresultset.getString(1);
							resultados[1] = miresultset.getString(2);
							resultados[2] = miresultset.getString(3);
							resultados[3] = miresultset.getString(4);

							modelo1.setRowCount(0);
							textArea.setText("");
							comboBox_2_1.setSelectedIndex(0);
							comboBox_3.setSelectedIndex(0);
							comboBox_1_1.setSelectedIndex(0);

							modelo1.addRow(resultados);

							// System.out.println(miresultset.getString("dia"));

						}

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
		});
		btnNewButton_1_2.setBounds(144, 270, 124, 23);
		panel_1.add(btnNewButton_1_2);

		JButton btnNewButton_1_1_2 = new JButton("Cancelar");
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				modelo1.setRowCount(0);
				textArea.setText("");
				comboBox_2_1.setSelectedIndex(0);
				comboBox_3.setSelectedIndex(0);
				comboBox_1_1.setSelectedIndex(0);
			}
		});
		btnNewButton_1_1_2.setBounds(292, 269, 124, 23);
		panel_1.add(btnNewButton_1_1_2);

	}
}
