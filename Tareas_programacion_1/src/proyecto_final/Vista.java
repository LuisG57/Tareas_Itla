package proyecto_final;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Canvas;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Vista extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;
	private String ID_Emp, logged_user, fullname, pos,ord;
	private JPanel panel_4, panel_5, panel_8, panel_9, panel_10;
	private CardLayout cl1;
	private JButton btnNewButton_1, btnNewButton_1_1, btnNewButton_1_1_1, btnNewButton_1_1_1_1;
	private String[] rol = { "Vendedor", "Encargado", "Secretario" };
	private Vector<String> nom_emp, id_emp, nom_prod, id_prod, nom_cli, id_cli, cant;
	private JLabel lblNewLabel_8, lblNewLabel_8_1, lblNewLabel_9_1;
	private double total = 0.0;

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
					Vista frame = new Vista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	Connection miconexion;
	Statement miStatement,st;
	ResultSet miresultset;
	DefaultTableModel modelo, modelo1, modelo2, modelo3, modelo4, modelo5;

	public Vista() {

		// 1. CREAR CONEXION

		try {

			String titulos[] = { "ID producto", "Nombre", "Cantidad", "Precio por cantidad actual" };
			modelo = new DefaultTableModel(null, titulos);
			String titulos1[] = { "ID orden", "Vendedor", "Cliente", "Total" };
			modelo1 = new DefaultTableModel(null, titulos1);
			String titulos2[] = { "ID empleado ", "Nombre", "Apellido", "Rol", "Sueldo", "Username" };
			modelo2 = new DefaultTableModel(null, titulos2);
			String titulos3[] = { "ID producto", "nombre producto", "descripcion producto", "precio unidad",
					"Existencias" };
			modelo3 = new DefaultTableModel(null, titulos3);
			String titulos4[] = { "ID cliente", "nombre", "RNC cliente", "numero de contacto cliente" };
			modelo4 = new DefaultTableModel(null, titulos4);
			String titulos5[] = { "ID producto", "nombre", "cantidad","precio" };
			modelo5 = new DefaultTableModel(null, titulos5);

			miconexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/base_de_datos_prueba?autoReconnect=true&useSSL=false", "root", "");

			// 2. CREAR UN OBJETO STATEMENT

			miStatement = miconexion.createStatement();
			st = miconexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(5, 10, 1430, 850);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		CardLayout cl = new CardLayout(0, 0);
		contentPane.setLayout(cl);

		JPanel panel = new JPanel();
		contentPane.add(panel, "name_54989678839400");
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setBounds(766, 198, 459, 218);
		BufferedImage img_2 = null;
		try {
			img_2 = ImageIO.read(new File(
					"C:\\\\Users\\\\luisg\\\\git\\\\repository2\\\\Tareas_programacion_1\\\\src\\\\proyecto_final\\\\Group_4.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Image dimg_2 = img_2.getScaledInstance(lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon_2 = new ImageIcon(dimg_2);

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_4.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(677, 474, 614, 36);
		panel.add(lblNewLabel_4);

		textField = new HintTextField("Username");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBorder(null);
		textField.setBounds(906, 533, 197, 20);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new HintPasswordField("Password");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		;
		textField_1.setBorder(null);
		textField_1.setColumns(10);
		textField_1.setBounds(906, 580, 197, 20);
		panel.add(textField_1);

		JButton btnNewButton = new JButton("Log in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String user, pass;
				char[] p;
				user = textField.getText();
				p = textField_1.getPassword();
				pass = String.valueOf(p);
				// modelo.setRowCount(0);

				String resultados[] = new String[6];

				try {
					miresultset = miStatement.executeQuery(
							"SELECT nombre_empleado,apellido_empleado,rol_emplaedo,username_empleado,password_empleado,empleado_id FROM Empleado WHERE username_empleado='"
									+ user + "' AND password_empleado = '" + pass + "' ");
					while (miresultset.next() == true) {

						resultados[0] = miresultset.getString(1);
						resultados[1] = miresultset.getString(2);
						resultados[2] = miresultset.getString(3);
						resultados[3] = miresultset.getString(4);
						resultados[4] = miresultset.getString(5);
						resultados[5] = miresultset.getString(6);

						if (user.equals(resultados[3]) && pass.equals(resultados[4])) {
							fullname = resultados[0] + resultados[1];
							pos = resultados[2];
							logged_user = resultados[3];
							ID_Emp = resultados[5];
							cl.show(contentPane, "name_54991504103600");
							return;
						}

						for (int i = 0; i < resultados.length; i++) {
							System.out.println(resultados[i]);
						}

						// modelo.addRow(resultados);
						// System.out.println(miresultset.getString("dia"));

					}

					lblNewLabel_4.setText("La contraseña o el usuario que ingresaste fue incorrecto");
					lblNewLabel_4.setBackground(Color.WHITE);
					// lblNewLabel_4;

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(938, 626, 137, 29);
		btnNewButton.setBorder(new RoundedBorder(25));
		// btnNewButton.setOpaque(false);
		btnNewButton.setFocusPainted(false);
		// btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		// btnNewButton.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		panel.add(btnNewButton);
		// lblNewLabel_2 = new JLabel (imageIcon_2);
		lblNewLabel_2.setIcon(imageIcon_2);
		panel.add(lblNewLabel_2);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 255, 255));
		panel_2.setBounds(0, 0, 469, 801);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel();/*
											 * = new JLabel(new ImageIcon(
											 * "C:\\Users\\luisg\\git\\repository2\\Tareas_programacion_1\\src\\proyecto_final\\ruchindra-gunasekara-GK8x_XCcDZg-unsplash.jpg"
											 * ));
											 */
		lblNewLabel.setSize(469, 801);
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(
					"C:\\\\Users\\\\luisg\\\\git\\\\repository2\\\\Tareas_programacion_1\\\\src\\\\proyecto_final\\\\ruchindra-gunasekara-GK8x_XCcDZg-unsplash.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		lblNewLabel = new JLabel(imageIcon);
		panel_2.add(lblNewLabel, BorderLayout.CENTER);

		JLabel lblNewLabel_1 = new JLabel(new ImageIcon(
				"C:\\\\\\\\Users\\\\\\\\luisg\\\\\\\\git\\\\\\\\repository2\\\\\\\\Tareas_programacion_1\\\\\\\\src\\\\\\\\proyecto_final\\\\\\\\Path_62.png"));
		lblNewLabel_1.setBounds(469, 0, 935, 801);

		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("Management System");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.ITALIC, 72));
		lblNewLabel_3.setBounds(641, 22, 730, 97);
		panel.add(lblNewLabel_3);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "name_54991504103600");
		panel_1.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(102, 102, 102));
		panel_3.setBounds(0, 0, 286, 801);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Management System");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_5.setForeground(new Color(204, 204, 204));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(10, 11, 266, 42);
		panel_3.add(lblNewLabel_5);

		btnNewButton_1 = new JButton("Ventas");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// modelo.setRowCount(0);

				String resultados[] = new String[3];

				nom_prod = new Vector<String>();
				nom_prod.clear();
				id_prod = new Vector<String>();
				id_prod.clear();
				cant = new Vector<String>();
				cant.clear();

				try {
					miresultset = miStatement.executeQuery("SELECT * FROM productos");
					while (miresultset.next() == true) {

						resultados[0] = miresultset.getString(1);
						resultados[1] = miresultset.getString(2);
						resultados[2] = miresultset.getString(5);

						for (int i = 0; i < resultados.length; i++) {
							System.out.println(resultados[i]);

						}
						nom_prod.add(resultados[0] + " " + resultados[1]);
						id_prod.add(resultados[0]);
						cant.add(resultados[2]);

						// modelo.addRow(resultados);
						// System.out.println(miresultset.getString("dia"));

					}
					/*if( comboBox_1.getSelectedIndex()!=-1) {
						comboBox_1.removeAllItems();
					}*/
					
						//comboBox_1.removeAllItems();

					// String[] nn = new String [nom_emp.size()];
					for (int i = 0; i < nom_prod.size(); i++) {
						System.out.println(i);
						comboBox_1.addItem(nom_prod.get(i));
					}
					comboBox_1.setSelectedIndex(0);
					
					//comboBox_1.setSelectedIndex(0);

					/*
					 * for (int i=0; i<cant.size();i++) { comboBox_2.addItem(cant.get(i)); }
					 */

					// comboBox_5_1.addItem();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				// modelo.setRowCount(0);

				nom_cli = new Vector<String>();
				nom_cli.clear();
				id_cli = new Vector<String>();
				id_cli.clear();

				try {
					miresultset = miStatement.executeQuery("SELECT * FROM clientes");
					while (miresultset.next() == true) {

						resultados[0] = miresultset.getString(1);
						resultados[1] = miresultset.getString(2);
						resultados[2] = miresultset.getString(3);

						for (int i = 0; i < resultados.length; i++) {
							System.out.println(resultados[i]);

						}
						nom_cli.add(resultados[1] + " " + resultados[2]);
						id_cli.add(resultados[0]);

						// modelo.addRow(resultados);
						// System.out.println(miresultset.getString("dia"));

					}
					comboBox.removeAllItems();
					comboBox_3.removeAllItems();
					// String[] nn = new String [nom_emp.size()];
					for (int i = 0; i < nom_cli.size(); i++) {
						comboBox.addItem(nom_cli.get(i));
						comboBox_3.addItem(nom_cli.get(i));
					}
					// comboBox_5_1.addItem();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

				cl1.show(panel_4, "name_148437452980900");
				btnNewButton_1.setForeground(Color.DARK_GRAY);
				btnNewButton_1_1.setForeground(Color.GRAY);
				btnNewButton_1_1_1.setForeground(Color.GRAY);
				btnNewButton_1_1_1_1.setForeground(Color.GRAY);
			}
		});
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setBounds(0, 170, 286, 52);
		panel_3.add(btnNewButton_1);

		btnNewButton_1_1 = new JButton("Inventario");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// modelo.setRowCount(0);

				String resultados[] = new String[3];

				nom_prod = new Vector<String>();
				nom_prod.clear();
				id_prod = new Vector<String>();
				id_prod.clear();

				try {
					miresultset = miStatement.executeQuery("SELECT * FROM productos");
					while (miresultset.next() == true) {

						resultados[0] = miresultset.getString(1);
						resultados[1] = miresultset.getString(2);

						for (int i = 0; i < resultados.length; i++) {
							System.out.println(resultados[i]);

						}
						nom_prod.add(resultados[0] + " " + resultados[1]);
						id_prod.add(resultados[0]);

						// modelo.addRow(resultados);
						// System.out.println(miresultset.getString("dia"));

					}
					comboBox_4.removeAllItems();
					// String[] nn = new String [nom_emp.size()];
					for (int i = 0; i < nom_prod.size(); i++) {
						comboBox_4.addItem(nom_prod.get(i));
					}
					// comboBox_5_1.addItem();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				cl1.show(panel_4, "name_151446319173000");
				btnNewButton_1.setForeground(Color.GRAY);
				btnNewButton_1_1.setForeground(Color.DARK_GRAY);
				btnNewButton_1_1_1.setForeground(Color.GRAY);
				btnNewButton_1_1_1_1.setForeground(Color.GRAY);
			}
		});
		btnNewButton_1_1.setFocusable(false);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setBorder(null);
		btnNewButton_1_1.setBackground(Color.GRAY);
		btnNewButton_1_1.setBounds(0, 222, 286, 52);
		panel_3.add(btnNewButton_1_1);

		btnNewButton_1_1_1 = new JButton("Clientes");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// modelo.setRowCount(0);

				String resultados[] = new String[4];

				nom_cli = new Vector<String>();
				nom_cli.clear();
				id_cli = new Vector<String>();
				id_cli.clear();

				try {
					miresultset = miStatement.executeQuery("SELECT * FROM clientes");
					while (miresultset.next() == true) {

						resultados[0] = miresultset.getString(1);
						resultados[1] = miresultset.getString(2);
						resultados[2] = miresultset.getString(3);
						resultados[3] = miresultset.getString(4);

						for (int i = 0; i < resultados.length; i++) {
							System.out.println(resultados[i]);

						}
						nom_cli.add(resultados[1] + " " + resultados[2]);
						id_cli.add(resultados[0]);

						// modelo.addRow(resultados);
						// System.out.println(miresultset.getString("dia"));

					}
					comboBox_5.removeAllItems();
					// String[] nn = new String [nom_emp.size()];
					for (int i = 0; i < nom_cli.size(); i++) {
						comboBox_5.addItem(nom_cli.get(i));
					}
					// comboBox_5_1.addItem();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				cl1.show(panel_4, "name_155418399685900");
				btnNewButton_1.setForeground(Color.GRAY);
				btnNewButton_1_1.setForeground(Color.GRAY);
				btnNewButton_1_1_1.setForeground(Color.DARK_GRAY);
				btnNewButton_1_1_1_1.setForeground(Color.GRAY);
			}
		});
		btnNewButton_1_1_1.setFocusable(false);
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1.setBorder(null);
		btnNewButton_1_1_1.setBackground(Color.GRAY);
		btnNewButton_1_1_1.setBounds(0, 274, 286, 52);
		panel_3.add(btnNewButton_1_1_1);

		btnNewButton_1_1_1_1 = new JButton("Empleados");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// modelo.setRowCount(0);

				String resultados[] = new String[3];

				nom_emp = new Vector<String>();
				nom_emp.clear();
				id_emp = new Vector<String>();
				id_emp.clear();

				try {
					miresultset = miStatement
							.executeQuery("SELECT empleado_id, nombre_empleado, apellido_empleado FROM Empleado");
					while (miresultset.next() == true) {

						resultados[0] = miresultset.getString(1);
						resultados[1] = miresultset.getString(2);
						resultados[2] = miresultset.getString(3);

						for (int i = 0; i < resultados.length; i++) {
							System.out.println(resultados[i]);

						}
						nom_emp.add(resultados[0] + " " + resultados[1] + " " + resultados[2]);
						id_emp.add(resultados[0]);

						// modelo.addRow(resultados);
						// System.out.println(miresultset.getString("dia"));

					}
					comboBox_5_1.removeAllItems();
					// String[] nn = new String [nom_emp.size()];
					for (int i = 0; i < nom_emp.size(); i++) {
						comboBox_5_1.addItem(nom_emp.get(i));
					}
					// comboBox_5_1.addItem();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				cl1.show(panel_4, "name_156850173768500");
				btnNewButton_1.setForeground(Color.GRAY);
				btnNewButton_1_1.setForeground(Color.GRAY);
				btnNewButton_1_1_1.setForeground(Color.GRAY);
				btnNewButton_1_1_1_1.setForeground(Color.DARK_GRAY);
			}
		});
		btnNewButton_1_1_1_1.setFocusable(false);
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1_1_1.setBorder(null);
		btnNewButton_1_1_1_1.setBackground(Color.GRAY);
		btnNewButton_1_1_1_1.setBounds(0, 749, 286, 52);
		panel_3.add(btnNewButton_1_1_1_1);

		panel_4 = new JPanel();
		panel_4.setBounds(285, 0, 1119, 801);
		panel_1.add(panel_4);
		cl1 = new CardLayout(0, 0);
		panel_4.setLayout(cl1);

		panel_5 = new JPanel();
		panel_4.add(panel_5, "name_148437452980900");
		panel_5.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1119, 801);
		panel_5.add(tabbedPane);

		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Realizar venta", null, panel_6, null);
		panel_6.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("Cliente");
		lblNewLabel_6.setBounds(42, 42, 46, 14);
		panel_6.add(lblNewLabel_6);

		comboBox = new JComboBox();
		comboBox.setFocusable(false);
		comboBox.setBounds(42, 67, 194, 22);
		panel_6.add(comboBox);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 221, 1062, 402);
		panel_6.add(scrollPane);

		table = new JTable(modelo);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		scrollPane.setViewportView(table);

		comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int lim = comboBox_1.getSelectedIndex();
				
				System.out.println("- " + lim);
				
				comboBox_2.removeAllItems();
				for (int i = 1; i < Integer.parseInt(cant.get(lim)) + 1; i++) {

					System.out.println("- " + i);
					
					comboBox_2.addItem(i);

				}

				String resultados[] = new String[4];

				try {
					miresultset = miStatement.executeQuery("SELECT * FROM productos WHERE productos_id = "
							+ id_prod.get(comboBox_1.getSelectedIndex()));
					while (miresultset.next() == true) {

						resultados[0] = miresultset.getString(1);
						resultados[1] = miresultset.getString(2);
						resultados[2] = miresultset.getString(3);
						resultados[3] = miresultset.getString(4);

						textArea.setText(resultados[2]);

						lblNewLabel_8.setText("RD$ " + resultados[3]);
						lblNewLabel_8_1.setText(
								"RD$ " + (Integer.parseInt(resultados[3]) * (1 + comboBox_2.getSelectedIndex())));

					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		comboBox_1.setFocusable(false);
		comboBox_1.setBounds(262, 67, 194, 22);
		panel_6.add(comboBox_1);

		JLabel lblNewLabel_6_1 = new JLabel("Producto");
		lblNewLabel_6_1.setBounds(262, 42, 46, 14);
		panel_6.add(lblNewLabel_6_1);

		comboBox_2 = new JComboBox();
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String resultados[] = new String[4];

				for (int i =0; i< id_prod.size();i++ ) {
					System.out.println(id_prod.get(i));
				}
				
				try {
					miresultset = miStatement.executeQuery("SELECT * FROM productos WHERE productos_id = "
							+ id_prod.get(comboBox_1.getSelectedIndex()));
					while (miresultset.next() == true) {

						resultados[0] = miresultset.getString(1);
						resultados[1] = miresultset.getString(2);
						resultados[2] = miresultset.getString(3);
						resultados[3] = miresultset.getString(4);

						lblNewLabel_8_1.setText(
								"RD$ " + (Integer.parseInt(resultados[3]) * (1 + comboBox_2.getSelectedIndex())));

					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		comboBox_2.setFocusable(false);
		comboBox_2.setBounds(501, 67, 160, 22);
		panel_6.add(comboBox_2);

		JLabel lblNewLabel_6_2 = new JLabel("Cantidad");
		lblNewLabel_6_2.setBounds(501, 42, 46, 14);
		panel_6.add(lblNewLabel_6_2);

		JLabel lblNewLabel_7 = new JLabel("Precio por unidad:");
		lblNewLabel_7.setBounds(42, 143, 103, 14);
		panel_6.add(lblNewLabel_7);

		lblNewLabel_8 = new JLabel("RD$ 0");
		lblNewLabel_8.setBounds(137, 143, 99, 14);
		panel_6.add(lblNewLabel_8);

		lblNewLabel_8_1 = new JLabel("RD$ 0");
		lblNewLabel_8_1.setBounds(388, 143, 97, 14);
		panel_6.add(lblNewLabel_8_1);

		JLabel lblNewLabel_7_1 = new JLabel("Precio por cantidad actual:");
		lblNewLabel_7_1.setBounds(246, 143, 136, 14);
		panel_6.add(lblNewLabel_7_1);

		JButton btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				modelo.removeRow(table.getSelectedRow());
				JOptionPane.showMessageDialog(contentPane, "Se ha eliminado el producto de la orden");

				total = 0.0;

				for (int i = 0; i < modelo.getRowCount(); i++) {
					System.out.println(table.getValueAt(i, 3));
					total = total + Double.parseDouble(table.getValueAt(i, 3).toString());
				}

				lblNewLabel_9_1.setText("RD$ " + total + "");

			}
		});
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.setBounds(501, 139, 89, 23);
		panel_6.add(btnNewButton_2);

		JButton btnNewButton_2_1 = new JButton("Agregar");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// modelo.setRowCount(0);

				String resultados[] = new String[4];

				try {

					String[] r = new String[1];

					miresultset = miStatement.executeQuery("SELECT * FROM productos WHERE productos_id = "
							+ id_prod.get(comboBox_1.getSelectedIndex()));
					while (miresultset.next() == true) {

						r[0] = miresultset.getString(4);

						// lblNewLabel_9_1.setText("RD$ "+ (
						// Integer.parseInt(r[0])*(1+comboBox_2.getSelectedIndex())));
						// lblNewLabel_9_1.setText("RD$ "+ (
						// Integer.parseInt(r[0])*(1+comboBox_2.getSelectedIndex())));

					}

					total = 0.0;

					miresultset = miStatement.executeQuery("SELECT * FROM productos WHERE productos_id = "
							+ id_prod.get(comboBox_1.getSelectedIndex()));
					while (miresultset.next() == true) {

						resultados[0] = miresultset.getString(1);
						resultados[1] = miresultset.getString(2);
						resultados[2] = (comboBox_2.getSelectedIndex() + 1) + "";
						resultados[3] = (Integer.parseInt(r[0]) * (1 + comboBox_2.getSelectedIndex())) + "";

						for (int i = 0; i < resultados.length; i++) {
							System.out.println(resultados[i]);

						}

						modelo.addRow(resultados);

					}
					for (int i = 0; i < modelo.getRowCount(); i++) {
						System.out.println(table.getValueAt(i, 3));
						total = total + Double.parseDouble(table.getValueAt(i, 3).toString());
					}

					lblNewLabel_9_1.setText("RD$ " + total + "");

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_2_1.setFocusable(false);
		btnNewButton_2_1.setBounds(651, 139, 89, 23);
		panel_6.add(btnNewButton_2_1);

		JButton btnNewButton_2_2 = new JButton("Cancelar");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				modelo.setRowCount(0);
				comboBox.setSelectedIndex(0);
				comboBox_1.setSelectedIndex(0);
				comboBox_2.setSelectedIndex(0);
				total = 0.0;
				lblNewLabel_9_1.setText("RD$ " + total + "");
				JOptionPane.showMessageDialog(contentPane, "Se ha cancelado la orden");

			}
		});
		btnNewButton_2_2.setFocusable(false);
		btnNewButton_2_2.setBounds(501, 634, 89, 23);
		panel_6.add(btnNewButton_2_2);

		JButton btnNewButton_2_1_1 = new JButton("Completar venta");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				

					String[] resultados = new String[4];
					String idCliente = "", idProducto = "", cantprod = "";

					nom_cli = new Vector<String>();
					nom_cli.clear();
					id_cli = new Vector<String>();
					id_cli.clear();
					// *************Obtenmos ID cliente para la venta***********

					try {
						miresultset = miStatement.executeQuery("SELECT * FROM clientes");
						while (miresultset.next() == true) {

							resultados[0] = miresultset.getString(1);
							resultados[1] = miresultset.getString(2);
							resultados[2] = miresultset.getString(3);

							for (int i = 0; i < resultados.length; i++) {
								System.out.println(resultados[i]);

							}
							id_cli.add(resultados[0]);
						}
						idCliente = id_cli.get(comboBox.getSelectedIndex());
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

					// ****Ejecutamos la actualizacion de la orden en la base de datos****
					// ***********obtenemos todos los ID y cantidades**********

					try {
						miStatement.executeUpdate(
								"INSERT INTO `orden`(`Empleado_empleado_id`, `Clientes_cliente_id`, `Total`) VALUES ('"
										+ ID_Emp + "','" + idCliente + "','" + total + "')");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}


					// *********Extraemos ID de la order de la tabla orden****************
					try {
					String ID_Orden = "";

					miresultset = miStatement.executeQuery("SELECT * FROM orden");
					while (miresultset.next() == true) {

						resultados[0] = miresultset.getString(1);
						resultados[1] = miresultset.getString(2);
						resultados[2] = miresultset.getString(3);
						resultados[3] = miresultset.getString(4);

						for (int i = 0; i < resultados.length; i++) {
							System.out.println(resultados[i]);
						}

						if (resultados[1].equals(ID_Emp)) {
							ID_Orden = resultados[0];
						}

					}

					for (int i = 0; i < modelo.getRowCount(); i++) {

						// ****Obtenemos ID producto para la venta****

						miresultset = miStatement
								.executeQuery("SELECT * FROM productos WHERE productos_id = " + table.getValueAt(i, 0));
						while (miresultset.next() == true) {

							resultados[0] = miresultset.getString(2);
							resultados[1] = miresultset.getString(3);
							resultados[2] = miresultset.getString(4);
							resultados[3] = miresultset.getString(5);

							cantprod = resultados[3];

						}

						// *****registramos la extraccion los productos de la tabla****

						miStatement.executeUpdate("UPDATE `productos` SET `productos_inventario`= "+ (Integer.parseInt(cantprod) - (Integer.parseInt(table.getValueAt(i, 2).toString())))+" WHERE `productos_id` =" + table.getValueAt(i, 0));

						// ***************registramos en la tabla interseccion*************

						idProducto = table.getValueAt(i, 0).toString();
						cantprod = table.getValueAt(i, 2).toString() ;
						System.out.println(idProducto);
						miStatement.executeUpdate("INSERT INTO `productos_orden`(`productos_id`, `orden_id`, `cantidad_producto`) VALUES ( "+ idProducto + "," + Integer.parseInt(ID_Orden) + "," + Integer.parseInt(cantprod) + ")");

					}

					JOptionPane.showMessageDialog(contentPane,
							"Se ha realizado la venta correctamente, su numero de order es:\n" + ID_Orden);
					
					modelo.setRowCount(0);
					comboBox.setSelectedIndex(0);
					comboBox_1.setSelectedIndex(0);
					comboBox_2.setSelectedIndex(0);
					total = 0.0;
					lblNewLabel_9_1.setText("RD$ " + total + "");

				}catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(contentPane, "Se ha Producido un error :\n" + e1.getMessage(), " Error",
							JOptionPane.ERROR_MESSAGE);
					
				}

			}
		});
		btnNewButton_2_1_1.setFocusable(false);
		btnNewButton_2_1_1.setBounds(651, 634, 160, 23);
		panel_6.add(btnNewButton_2_1_1);

		JLabel lblNewLabel_9 = new JLabel("Total:");
		lblNewLabel_9.setBounds(880, 643, 46, 14);
		panel_6.add(lblNewLabel_9);

		lblNewLabel_9_1 = new JLabel("RD$ 0");
		lblNewLabel_9_1.setBounds(940, 643, 136, 14);
		panel_6.add(lblNewLabel_9_1);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setBounds(784, 66, 320, 91);
		panel_6.add(textArea);

		JLabel lblNewLabel_6_2_1 = new JLabel("Descripcion de produto");
		lblNewLabel_6_2_1.setBounds(784, 42, 142, 14);
		panel_6.add(lblNewLabel_6_2_1);

		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("Ventas realizadas", null, panel_7, null);
		panel_7.setLayout(null);

		JLabel lblNewLabel_10 = new JLabel("Cliente");
		lblNewLabel_10.setBounds(44, 18, 46, 14);
		panel_7.add(lblNewLabel_10);

		comboBox_3 = new JComboBox();
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

	
			}
		});
		comboBox_3.setFocusable(false);
		comboBox_3.setBounds(44, 43, 243, 22);
		panel_7.add(comboBox_3);

		JButton btnNewButton_3 = new JButton("Mostrar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				modelo1.setRowCount(0);

				String resultados[] = new String[4];

				try {

					String[] r = new String[1];

					miresultset = miStatement.executeQuery("SELECT * FROM orden WHERE Clientes_cliente_id = " + id_cli.get(comboBox_3.getSelectedIndex()));
					while (miresultset.next() == true) {

						
						String empleado,cliente, apellido;
						ResultSet rs = st.executeQuery("SELECT * FROM empleado WHERE empleado_id = " + miresultset.getString(2));
						rs.next();empleado = rs.getString(2);apellido = rs.getString(3);
						rs = st.executeQuery("SELECT * FROM clientes WHERE cliente_id = " + miresultset.getString(3));
						rs.next();cliente = rs.getString(2);
						resultados[0] = miresultset.getString(1);
						resultados[1] = empleado + " " + apellido;
						resultados[2] = cliente;
						resultados[3] = "RD$ " + miresultset.getString(4);
						
						modelo1.addRow(resultados);

						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_3.setFocusable(false);
		btnNewButton_3.setBounds(297, 43, 89, 23);
		panel_7.add(btnNewButton_3);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(44, 76, 1060, 317);
		panel_7.add(scrollPane_1);

		table_1 = new JTable(modelo1);
		table_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				
			}
		});
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				modelo5.setRowCount(0);

				String resultados[] = new String[4];
				
				System.out.println(table_1.getValueAt(table_1.getSelectedRow(), 0).toString());
				
				try {

					miresultset = miStatement.executeQuery("SELECT * FROM productos_orden WHERE orden_id = " + table_1.getValueAt(table_1.getSelectedRow(), 0).toString());
					while (miresultset.next() == true) {

						
						String precio, nombre;
						ResultSet rs = st.executeQuery("SELECT * FROM productos WHERE productos_id = " + miresultset.getString(1));
						rs.next();precio = rs.getString(4);nombre = rs.getString(2);
						resultados[0] = miresultset.getString(1);
						resultados[1] = nombre;
						resultados[2] = miresultset.getString(3);
						resultados[3] = precio;
						
						modelo5.addRow(resultados);

						
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_10_1 = new JLabel("Articulos de la orden");
		lblNewLabel_10_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_10_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10_1.setBounds(0, 404, 1114, 32);
		panel_7.add(lblNewLabel_10_1);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(44, 447, 1060, 315);
		panel_7.add(scrollPane_4);
		
		table_5 = new JTable(modelo5);
		scrollPane_4.setViewportView(table_5);

		panel_8 = new JPanel();
		panel_4.add(panel_8, "name_151446319173000");
		panel_8.setLayout(null);

		JLabel lblNewLabel_11 = new JLabel("Producto");
		lblNewLabel_11.setBounds(39, 39, 46, 14);
		panel_8.add(lblNewLabel_11);

		comboBox_4 = new JComboBox();
		comboBox_4.setBounds(39, 64, 153, 22);
		panel_8.add(comboBox_4);

		JButton btnNewButton_4 = new JButton("Mostrar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id = id_prod.get(comboBox_4.getSelectedIndex());

				// modelo.setRowCount(0);

				String resultados[] = new String[5];

				try {
					miresultset = miStatement.executeQuery("SELECT * FROM productos WHERE productos_id = " + id);
					modelo3.setRowCount(0);
					while (miresultset.next() == true) {

						resultados[0] = miresultset.getString(1);
						resultados[1] = miresultset.getString(2);
						resultados[2] = miresultset.getString(3);
						resultados[3] = miresultset.getString(4);
						resultados[4] = miresultset.getString(5);

						for (int i = 0; i < resultados.length; i++) {
							System.out.println(resultados[i]);
						}

						modelo3.addRow(resultados);
						// System.out.println(miresultset.getString("dia"));

					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_4.setBounds(250, 64, 89, 23);
		panel_8.add(btnNewButton_4);

		JButton btnNewButton_4_1 = new JButton("Mostrar Todos");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// modelo.setRowCount(0);

				String resultados[] = new String[5];

				modelo3.setRowCount(0);

				try {
					miresultset = miStatement.executeQuery("SELECT * FROM Productos ");
					while (miresultset.next() == true) {

						resultados[0] = miresultset.getString(1);
						resultados[1] = miresultset.getString(2);
						resultados[2] = miresultset.getString(3);
						resultados[3] = miresultset.getString(4);
						resultados[4] = miresultset.getString(5);

						for (int i = 0; i < resultados.length; i++) {
							System.out.println(resultados[i]);
						}

						modelo3.addRow(resultados);
						// System.out.println(miresultset.getString("dia"));

					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_4_1.setBounds(493, 64, 198, 23);
		panel_8.add(btnNewButton_4_1);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(39, 142, 1070, 243);
		panel_8.add(scrollPane_2);

		table_2 = new JTable(modelo3);
		scrollPane_2.setViewportView(table_2);

		JSeparator separator = new JSeparator();
		separator.setBounds(39, 412, 1070, 2);
		panel_8.add(separator);

		textField_2 = new JTextField();
		textField_2.setBounds(39, 493, 214, 20);
		panel_8.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("Nombre producto");
		lblNewLabel_12.setBounds(39, 465, 119, 14);
		panel_8.add(lblNewLabel_12);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(351, 493, 119, 20);
		panel_8.add(spinner);

		JLabel lblNewLabel_12_1 = new JLabel("Cantidad");
		lblNewLabel_12_1.setBounds(351, 465, 119, 14);
		panel_8.add(lblNewLabel_12_1);

		JLabel lblNewLabel_12_1_1 = new JLabel("Precio");
		lblNewLabel_12_1_1.setBounds(572, 465, 119, 14);
		panel_8.add(lblNewLabel_12_1_1);

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(572, 493, 119, 20);
		panel_8.add(spinner_1);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(778, 491, 331, 146);
		panel_8.add(textArea_1);

		JButton btnNewButton_5 = new JButton("Agregar Producto");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name, desc, price, quant;
				name = textField_2.getText().trim();
				desc = textArea_1.getText().trim();
				price = spinner_1.getValue().toString();
				quant = spinner.getValue().toString();

				// modelo.setRowCount(0);

				try {

					miStatement.executeUpdate(
							"INSERT INTO `productos`(`nombre_producto`, `descripcion_producto`, `precio_producto`, `productos_inventario`) VALUES ('"
									+ name + "','" + desc + "','" + price + "','" + quant + "')");

					textField_2.setText("");
					textArea_1.setText("");
					spinner_1.setValue(0);
					spinner.setValue(0);
					;

					JOptionPane.showMessageDialog(contentPane, "El producto se ha agregador correctamente");

					String resultados[] = new String[3];

					nom_prod = new Vector<String>();
					nom_prod.clear();
					id_prod = new Vector<String>();
					id_prod.clear();

					try {
						miresultset = miStatement.executeQuery("SELECT * FROM productos");
						while (miresultset.next() == true) {

							resultados[0] = miresultset.getString(1);
							resultados[1] = miresultset.getString(2);

							for (int i = 0; i < resultados.length; i++) {
								System.out.println(resultados[i]);

							}
							nom_prod.add(resultados[0] + " " + resultados[1]);
							id_prod.add(resultados[0]);

							// modelo.addRow(resultados);
							// System.out.println(miresultset.getString("dia"));

						}
						comboBox_4.removeAllItems();
						// String[] nn = new String [nom_emp.size()];
						for (int i = 0; i < nom_prod.size(); i++) {
							comboBox_4.addItem(nom_prod.get(i));
						}
						// comboBox_5_1.addItem();

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(contentPane, "se ha generado un error" + e1.getMessage(), "Error",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton_5.setBounds(464, 614, 168, 23);
		panel_8.add(btnNewButton_5);

		JButton btnNewButton_5_1 = new JButton("Cancelar");
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField_2.setText("");
				spinner.setValue(0);
				spinner_1.setValue(0);
				textArea.setText("");

				JOptionPane.showMessageDialog(contentPane, "La operacion ha sido cancelada");

			}
		});
		btnNewButton_5_1.setBounds(291, 614, 89, 23);
		panel_8.add(btnNewButton_5_1);

		JLabel lblNewLabel_12_1_1_1 = new JLabel("Descripcion");
		lblNewLabel_12_1_1_1.setBounds(778, 465, 119, 14);
		panel_8.add(lblNewLabel_12_1_1_1);

		panel_9 = new JPanel();
		panel_4.add(panel_9, "name_155418399685900");
		panel_9.setLayout(null);

		JLabel lblNewLabel_13 = new JLabel("Nombre");
		lblNewLabel_13.setBounds(37, 32, 46, 14);
		panel_9.add(lblNewLabel_13);

		textField_3 = new JTextField();
		textField_3.setBounds(37, 57, 182, 20);
		panel_9.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_13_1 = new JLabel("Numero de contacto");
		lblNewLabel_13_1.setBounds(370, 32, 128, 14);
		panel_9.add(lblNewLabel_13_1);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(370, 57, 182, 20);
		panel_9.add(textField_4);

		JLabel lblNewLabel_13_2 = new JLabel("RNC");
		lblNewLabel_13_2.setBounds(671, 32, 46, 14);
		panel_9.add(lblNewLabel_13_2);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(671, 57, 182, 20);
		panel_9.add(textField_5);

		JButton btnNewButton_6 = new JButton("Cancelar");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");

				JOptionPane.showMessageDialog(contentPane, "Se ha cancelado la operacion");

			}
		});
		btnNewButton_6.setBounds(247, 115, 89, 23);
		panel_9.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("Agregar");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name, RNC, phone;

				name = textField_3.getText().trim();
				RNC = textField_4.getText().trim();
				phone = textField_5.getText().trim();

				// modelo.setRowCount(0);

				try {

					miStatement.executeUpdate(
							"INSERT INTO `clientes`(`nombre_cliente`, `RNC_cliente`, `numero_de_contacto_cliente`) VALUES ('"
									+ name + "','" + RNC + "','" + phone + "')");

					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");

					JOptionPane.showMessageDialog(contentPane, "El cliente se ha agregador correctamente");

					// modelo.setRowCount(0);

					String resultados[] = new String[4];

					nom_cli = new Vector<String>();
					nom_cli.clear();
					id_cli = new Vector<String>();
					id_cli.clear();

					try {
						miresultset = miStatement.executeQuery("SELECT * FROM clientes");
						while (miresultset.next() == true) {

							resultados[0] = miresultset.getString(1);
							resultados[1] = miresultset.getString(2);
							resultados[2] = miresultset.getString(3);
							resultados[3] = miresultset.getString(4);

							for (int i = 0; i < resultados.length; i++) {
								System.out.println(resultados[i]);

							}
							nom_cli.add(resultados[1] + " " + resultados[2]);
							id_cli.add(resultados[0]);

							// modelo.addRow(resultados);
							// System.out.println(miresultset.getString("dia"));

						}
						comboBox_5.removeAllItems();
						// String[] nn = new String [nom_emp.size()];
						for (int i = 0; i < nom_cli.size(); i++) {
							comboBox_5.addItem(nom_cli.get(i));
						}
						// comboBox_5_1.addItem();

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(contentPane, "se ha generado un error", "Error",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btnNewButton_7.setBounds(569, 115, 89, 23);
		panel_9.add(btnNewButton_7);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(37, 167, 1043, 2);
		panel_9.add(separator_1);

		comboBox_5 = new JComboBox();
		comboBox_5.setBounds(37, 291, 215, 22);
		panel_9.add(comboBox_5);

		JLabel lblNewLabel_13_3 = new JLabel("Cliente");
		lblNewLabel_13_3.setBounds(37, 266, 46, 14);
		panel_9.add(lblNewLabel_13_3);

		JButton btnNewButton_6_1 = new JButton("Cancelar");
		btnNewButton_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				comboBox_5.setSelectedIndex(0);
				modelo4.setRowCount(0);
				JOptionPane.showMessageDialog(contentPane, "La operacion ha sido cancelada");

			}
		});
		btnNewButton_6_1.setBounds(286, 291, 89, 23);
		panel_9.add(btnNewButton_6_1);

		JButton btnNewButton_7_1 = new JButton("Mostrar Todos");
		btnNewButton_7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// modelo.setRowCount(0);

				String resultados[] = new String[4];

				modelo4.setRowCount(0);

				try {
					miresultset = miStatement.executeQuery("SELECT * FROM clientes ");
					while (miresultset.next() == true) {

						resultados[0] = miresultset.getString(1);
						resultados[1] = miresultset.getString(2);
						resultados[2] = miresultset.getString(3);
						resultados[3] = miresultset.getString(4);

						for (int i = 0; i < resultados.length; i++) {
							System.out.println(resultados[i]);
						}

						modelo4.addRow(resultados);
						// System.out.println(miresultset.getString("dia"));

					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_7_1.setBounds(612, 291, 145, 23);
		panel_9.add(btnNewButton_7_1);

		JButton btnNewButton_6_1_1 = new JButton("Mostrar");
		btnNewButton_6_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String id = id_cli.get(comboBox_5.getSelectedIndex());

				// modelo.setRowCount(0);

				String resultados[] = new String[4];

				try {
					miresultset = miStatement.executeQuery("SELECT * FROM clientes WHERE cliente_id = " + id);
					modelo4.setRowCount(0);
					while (miresultset.next() == true) {

						resultados[0] = miresultset.getString(1);
						resultados[1] = miresultset.getString(2);
						resultados[2] = miresultset.getString(3);
						resultados[3] = miresultset.getString(4);

						for (int i = 0; i < resultados.length; i++) {
							System.out.println(resultados[i]);
						}

						modelo4.addRow(resultados);
						// System.out.println(miresultset.getString("dia"));

					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_6_1_1.setBounds(452, 291, 89, 23);
		panel_9.add(btnNewButton_6_1_1);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(37, 354, 1043, 411);
		panel_9.add(scrollPane_3);

		table_3 = new JTable(modelo4);
		scrollPane_3.setViewportView(table_3);

		panel_10 = new JPanel();
		panel_4.add(panel_10, "name_156850173768500");
		panel_10.setLayout(null);

		JLabel lblNewLabel_13_4 = new JLabel("Nombre");
		lblNewLabel_13_4.setBounds(10, 34, 46, 14);
		panel_10.add(lblNewLabel_13_4);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(10, 59, 182, 20);
		panel_10.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(220, 59, 182, 20);
		panel_10.add(textField_7);

		JLabel lblNewLabel_13_1_1 = new JLabel("Apellido");
		lblNewLabel_13_1_1.setBounds(220, 34, 128, 14);
		panel_10.add(lblNewLabel_13_1_1);

		JLabel lblNewLabel_13_2_1 = new JLabel("Sueldo");
		lblNewLabel_13_2_1.setBounds(713, 34, 46, 14);
		panel_10.add(lblNewLabel_13_2_1);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(713, 59, 182, 20);
		panel_10.add(textField_8);

		JButton btnNewButton_7_2 = new JButton("Agregar");
		btnNewButton_7_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name, lname, payrate, uname, pass, Rol;
				name = textField_6.getText().trim();
				lname = textField_7.getText().trim();
				payrate = textField_8.getText().trim();
				uname = textField_9.getText().trim();
				pass = textField_10.getText().trim();
				Rol = rol[comboBox_6.getSelectedIndex()];

				String id = id_emp.get(comboBox_5_1.getSelectedIndex());

				// modelo.setRowCount(0);

				try {

					miStatement.executeUpdate(
							"INSERT INTO `empleado`(`nombre_empleado`, `apellido_empleado`, `rol_emplaedo`, `sueldo_empleado`, `username_empleado`, `password_empleado`) VALUES ('"
									+ name + "','" + lname + "','" + Rol + "','" + payrate + "','" + uname + "','"
									+ pass + "')");

					textField_6.setText("");
					textField_7.setText("");
					textField_8.setText("");
					textField_9.setText("");
					textField_10.setText("");
					comboBox_6.setSelectedIndex(0);

					JOptionPane.showMessageDialog(contentPane, "El empleado se ha agregador correctamente");

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(contentPane, "se ha generado un error", "Error",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btnNewButton_7_2.setBounds(542, 185, 89, 23);
		panel_10.add(btnNewButton_7_2);

		JButton btnNewButton_6_2 = new JButton("Cancelar");
		btnNewButton_6_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				textField_9.setText("");
				textField_10.setText("");
				comboBox_6.setSelectedIndex(0);

			}
		});
		btnNewButton_6_2.setBounds(220, 185, 89, 23);
		panel_10.add(btnNewButton_6_2);

		comboBox_5_1 = new JComboBox();
		comboBox_5_1.setBounds(10, 293, 182, 22);
		panel_10.add(comboBox_5_1);

		JLabel lblNewLabel_13_3_1 = new JLabel("Empleado");
		lblNewLabel_13_3_1.setBounds(10, 268, 46, 14);
		panel_10.add(lblNewLabel_13_3_1);

		JButton btnNewButton_6_1_2 = new JButton("Cancelar");
		btnNewButton_6_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				modelo2.setRowCount(0);
				comboBox_5_1.setSelectedIndex(0);

			}
		});
		btnNewButton_6_1_2.setBounds(259, 293, 89, 23);
		panel_10.add(btnNewButton_6_1_2);

		JButton btnNewButton_6_1_1_1 = new JButton("Mostrar");
		btnNewButton_6_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String id = id_emp.get(comboBox_5_1.getSelectedIndex());

				// modelo.setRowCount(0);

				String resultados[] = new String[6];

				try {
					miresultset = miStatement.executeQuery("SELECT * FROM Empleado WHERE empleado_id = " + id);
					while (miresultset.next() == true) {

						resultados[0] = miresultset.getString(1);
						resultados[1] = miresultset.getString(2);
						resultados[2] = miresultset.getString(3);
						resultados[3] = miresultset.getString(4);
						resultados[4] = miresultset.getString(5);
						resultados[5] = miresultset.getString(6);

						modelo2.setRowCount(0);

						for (int i = 0; i < resultados.length; i++) {
							System.out.println(resultados[i]);
						}

						modelo2.addRow(resultados);
						// System.out.println(miresultset.getString("dia"));

					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_6_1_1_1.setBounds(425, 293, 89, 23);
		panel_10.add(btnNewButton_6_1_1_1);

		JButton btnNewButton_7_1_1 = new JButton("Mostrar Todos");
		btnNewButton_7_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// modelo.setRowCount(0);

				String resultados[] = new String[6];

				modelo2.setRowCount(0);

				try {
					miresultset = miStatement.executeQuery("SELECT * FROM Empleado ");
					while (miresultset.next() == true) {

						resultados[0] = miresultset.getString(1);
						resultados[1] = miresultset.getString(2);
						resultados[2] = miresultset.getString(3);
						resultados[3] = miresultset.getString(4);
						resultados[4] = miresultset.getString(5);
						resultados[5] = miresultset.getString(6);

						for (int i = 0; i < resultados.length; i++) {
							System.out.println(resultados[i]);
						}

						modelo2.addRow(resultados);
						// System.out.println(miresultset.getString("dia"));

					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_7_1_1.setBounds(585, 293, 145, 23);
		panel_10.add(btnNewButton_7_1_1);

		JScrollPane scrollPane_3_1 = new JScrollPane();
		scrollPane_3_1.setBounds(10, 356, 1043, 411);
		panel_10.add(scrollPane_3_1);

		table_4 = new JTable(modelo2);
		scrollPane_3_1.setViewportView(table_4);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(187, 139, 182, 20);
		panel_10.add(textField_9);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(548, 139, 182, 20);
		panel_10.add(textField_10);

		JLabel lblNewLabel_13_1_1_1 = new JLabel("Password");
		lblNewLabel_13_1_1_1.setBounds(548, 114, 128, 14);
		panel_10.add(lblNewLabel_13_1_1_1);

		JLabel lblNewLabel_13_4_1 = new JLabel("Username");
		lblNewLabel_13_4_1.setBounds(187, 114, 107, 14);
		panel_10.add(lblNewLabel_13_4_1);

		JLabel lblNewLabel_13_1_1_2 = new JLabel("Rol");
		lblNewLabel_13_1_1_2.setBounds(449, 34, 128, 14);
		panel_10.add(lblNewLabel_13_1_1_2);

		comboBox_6 = new JComboBox(rol);
		comboBox_6.setBounds(449, 58, 182, 22);
		panel_10.add(comboBox_6);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 237, 1043, 2);
		panel_10.add(separator_1_1);
	}
	
	public static void printSQLException(SQLException ex) {

	    for (Throwable e : ex) {
	        if (e instanceof SQLException) {

	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " +
	                    ((SQLException)e).getSQLState());

	                System.err.println("Error Code: " +
	                    ((SQLException)e).getErrorCode());

	                System.err.println("Message: " + e.getMessage());

	                Throwable t = ex.getCause();
	                while(t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            
	        }
	    }
	}

	private JLabel lblNewLabel_4;
	private JTable table;
	private JTable table_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextArea textArea;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private JComboBox comboBox_5_1, comboBox_6, comboBox_4, comboBox_5, comboBox, comboBox_1, comboBox_2,comboBox_3;
	private JTable table_5;
}

class HintTextField extends JTextField implements FocusListener {

	private final String hint;
	private boolean showingHint;

	public HintTextField(final String hint) {
		super(hint);
		this.hint = hint;
		this.showingHint = true;
		super.addFocusListener(this);
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (this.getText().isEmpty()) {
			super.setText("");
			showingHint = false;
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (this.getText().isEmpty()) {
			super.setText(hint);
			showingHint = true;
		}
	}

	@Override
	public String getText() {
		return showingHint ? "" : super.getText();
	}
}

class HintPasswordField extends JPasswordField implements FocusListener {

	private final String hint;
	private boolean showingHint;

	public HintPasswordField(final String hint) {
		super(hint);
		this.hint = hint;
		this.showingHint = true;
		super.addFocusListener(this);
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (this.getText().isEmpty()) {
			super.setText("");
			showingHint = false;
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (this.getText().isEmpty()) {
			super.setText(hint);
			showingHint = true;
		}
	}

	@Override
	public String getText() {
		return showingHint ? "" : super.getText();
	}
}


