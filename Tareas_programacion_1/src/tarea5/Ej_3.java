package tarea5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Ej_3 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej_3 window = new Ej_3();
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
	public Ej_3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Elije un sistema operativo");
		lblNewLabel.setBounds(26, 21, 181, 14);
		frame.getContentPane().add(lblNewLabel);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Windows");
		rdbtnNewRadioButton.setBounds(26, 59, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Linux");
		rdbtnNewRadioButton_1.setBounds(26, 104, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Mac");
		rdbtnNewRadioButton_2.setBounds(26, 148, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton_2);

		JSeparator separator = new JSeparator();
		separator.setBounds(30, 200, 200, 2);
		frame.getContentPane().add(separator);

		JLabel lblNewLabel_1 = new JLabel("Elije tu especialidad");
		lblNewLabel_1.setBounds(26, 225, 181, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Programacion");
		chckbxNewCheckBox.setBounds(26, 266, 155, 23);
		frame.getContentPane().add(chckbxNewCheckBox);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Dise\u00F1o grafico");
		chckbxNewCheckBox_1.setBounds(26, 306, 155, 23);
		frame.getContentPane().add(chckbxNewCheckBox_1);

		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Administracion");
		chckbxNewCheckBox_2.setBounds(26, 347, 155, 23);
		frame.getContentPane().add(chckbxNewCheckBox_2);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(30, 395, 200, 2);
		frame.getContentPane().add(separator_1);

		JLabel lblNewLabel_2 = new JLabel("Horas que dedicas en el ordenador");
		lblNewLabel_2.setBounds(26, 421, 204, 14);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("0");
		lblNewLabel_3.setBounds(46, 461, 46, 26);
		frame.getContentPane().add(lblNewLabel_3);

		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				lblNewLabel_3.setText(slider.getValue() + "");

			}
		});
		slider.setValue(0);
		slider.setMaximum(10);
		slider.setBounds(68, 461, 181, 26);
		frame.getContentPane().add(slider);

		JButton btnNewButton = new JButton("Generar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String os = "", esp = "", horas = "", mensaje = "";

				if (rdbtnNewRadioButton.isSelected()) {
					os = rdbtnNewRadioButton.getText();
				} else if (rdbtnNewRadioButton_1.isSelected()) {
					os = rdbtnNewRadioButton_1.getText();
				} else if (rdbtnNewRadioButton_2.isSelected()) {
					os = rdbtnNewRadioButton_2.getText();
				}

				if (chckbxNewCheckBox.isSelected()) {
					esp = chckbxNewCheckBox.getText();
				}
				if (chckbxNewCheckBox_1.isSelected()) {
					esp = esp + ", " + chckbxNewCheckBox_1.getText();
				}
				if (chckbxNewCheckBox_2.isSelected()) {
					esp = esp + ", " + chckbxNewCheckBox_2.getText();
				}

				horas = slider.getValue() + "";

				mensaje = "Tu sistema operativo predefinido es " + os + ",\n tus especialidades son " + esp
						+ "\n y el numero de horas dedicadas al ordernador son " + horas;

				JOptionPane.showMessageDialog(frame.getContentPane(), mensaje, "Muestra de datos", 1);

			}
		});
		btnNewButton.setBounds(92, 511, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
