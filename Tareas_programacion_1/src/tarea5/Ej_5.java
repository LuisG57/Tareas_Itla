package tarea5;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ej_5 {

	private JFrame frmBibliotecaItla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej_5 window = new Ej_5();
					window.frmBibliotecaItla.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ej_5() {

		for (int i = 0; i < l1.length; i++) {

			switch (i) {

			case 0:
				l1[i] = new libros("Don Quijote de la mancha", true, true);
				break;
			case 1:
				l1[i] = new libros("Analisis y Diseño de sistemas 8va edicion", true, false);
				break;
			case 2:
				l1[i] = new libros("Algebra de baldor", false, true);
				break;
			case 3:
				l1[i] = new libros("Historia Universal tomo I", false, false);
				break;
			default:
				l1[i] = new libros("Logica de la programacion", false, true);
				break;

			}

		}

		for (int i = 0; i < l.length; i++) {
			for (int j = 0; j < l[i].length; j++) {

				switch (j) {

				case 0:
					l[i][j] = l1[i].getTitulo();
					break;
				case 1:
					if (l1[i].isOriginal()) {
						l[i][j] = "si";
					} else {
						l[i][j] = "no";
					}
					break;
				default:
					if (l1[i].isPrestable()) {
						l[i][j] = "si";
					} else {
						l[i][j] = "no";
					}
					break;

				}

			}
		}

		initialize();
	}

	libros[] l1 = new libros[5];
	String[] t = { "Titulo", "Original", "Prestable" };
	String[][] l = new String[5][3];
	private JTextField textField;
	private JTable table;

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBibliotecaItla = new JFrame();
		frmBibliotecaItla.setTitle("Biblioteca ITLA");
		frmBibliotecaItla.setBounds(100, 100, 600, 290);
		frmBibliotecaItla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		frmBibliotecaItla.getContentPane().add(panel_1, BorderLayout.CENTER);

		textField = new JTextField();
		textField.setToolTipText(
				"Nota: puedes dar clic en nombre y luego en buscar tambien, pero si lo haces debes dejar vacia la caja de texto, si quieres puedes darle clic en limpiar texto antes de hacerlo.");
		textField.setColumns(10);
		textField.setBounds(10, 52, 205, 20);
		panel_1.add(textField);

		JLabel lblNewLabel_1 = new JLabel("Inserta el numero de order del libro:");
		lblNewLabel_1.setBounds(10, 27, 205, 14);
		panel_1.add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton(" Limpiar texto");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		btnNewButton_1.setBounds(108, 83, 129, 23);
		panel_1.add(btnNewButton_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 117, 564, 125);
		panel_1.add(scrollPane);

		table = new JTable(l, t);
		table.setToolTipText("");
		scrollPane.setViewportView(table);

		JTextArea txtrNotaPuedesDar = new JTextArea();
		txtrNotaPuedesDar.setEnabled(false);
		txtrNotaPuedesDar.setEditable(false);
		txtrNotaPuedesDar.setText(
				"Nota: puedes dar clic en nombre y luego en buscar tambien, pero si lo haces debes dejar vacia la caja de texto, si quieres puedes darle clic en limpiar texto antes de hacerlo.");
		txtrNotaPuedesDar.setToolTipText("");
		txtrNotaPuedesDar.setWrapStyleWord(true);
		txtrNotaPuedesDar.setLineWrap(true);
		txtrNotaPuedesDar.setBounds(272, 11, 302, 93);
		panel_1.add(txtrNotaPuedesDar);

		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setToolTipText(
				"Nota: puedes dar clic en nombre y luego en buscar tambien, pero si lo haces debes dejar vacia la caja de texto, si quieres puedes darle clic en limpiar texto antes de hacerlo.");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num;
				if (textField.getText().equalsIgnoreCase("")) {
					num = table.getSelectedRow();
					for (int i = 0; i < l1.length; i++) {
						if (i == num) {
							JOptionPane.showMessageDialog(frmBibliotecaItla.getContentPane(), l1[i]);
						}
					}
				} else {
					num = Integer.parseInt(textField.getText().trim());
					num--;
					for (int i = 0; i < l1.length; i++) {
						if (i == num) {
							JOptionPane.showMessageDialog(frmBibliotecaItla.getContentPane(), l1[i]);
						}
					}
				}
				
			}
		});
		btnNewButton.setBounds(10, 83, 89, 23);
		panel_1.add(btnNewButton);

	}
}

class libros {

	public libros() {

	}

	public libros(String titulo, boolean original, boolean prestable) {

		this.titulo = titulo;
		this.original = original;
		this.prestable = prestable;
	}

	public boolean isOriginal() {
		return original;
	}

	public void setOriginal(boolean original) {
		this.original = original;
	}

	public boolean isPrestable() {
		return prestable;
	}

	public void setPrestable(boolean prestable) {
		this.prestable = prestable;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub

		String o, p;
		o = (original) ? "es original" : "es una copia";
		p = (prestable) ? "es prestable" : "no es prestable";
		return "El libro seleccionado es: \n" + titulo + ", este libro " + o + ", y " + p + ".";
	}

	private boolean original, prestable;
	private String titulo;

}
