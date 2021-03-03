package tarea5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Ej_1 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	public Ej_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		String[] sel = {"Opcion 1", "Opcion 2", "Opcion 3"};
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Espejo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		panel_1.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton_2_1 = new JRadioButton("Opcion 3");
		rdbtnNewRadioButton_2_1.setEnabled(false);
		rdbtnNewRadioButton_2_1.setBounds(29, 152, 109, 23);
		panel_1.add(rdbtnNewRadioButton_2_1);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("Opcion 2");
		rdbtnNewRadioButton_1_1.setEnabled(false);
		rdbtnNewRadioButton_1_1.setBounds(29, 92, 109, 23);
		panel_1.add(rdbtnNewRadioButton_1_1);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Opcion 1");
		rdbtnNewRadioButton_3.setEnabled(false);
		rdbtnNewRadioButton_3.setBounds(29, 30, 109, 23);
		panel_1.add(rdbtnNewRadioButton_3);
		
		ButtonGroup bg1 = new ButtonGroup();
		bg1.add(rdbtnNewRadioButton_3);
		bg1.add(rdbtnNewRadioButton_1_1);
		bg1.add(rdbtnNewRadioButton_2_1);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Opcion 1");
		chckbxNewCheckBox_3.setEnabled(false);
		chckbxNewCheckBox_3.setBounds(167, 30, 97, 23);
		panel_1.add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("Opcion 2");
		chckbxNewCheckBox_1_1.setEnabled(false);
		chckbxNewCheckBox_1_1.setBounds(167, 92, 97, 23);
		panel_1.add(chckbxNewCheckBox_1_1);
		
		JCheckBox chckbxNewCheckBox_2_1 = new JCheckBox("Opcion 3");
		chckbxNewCheckBox_2_1.setEnabled(false);
		chckbxNewCheckBox_2_1.setBounds(167, 152, 97, 23);
		panel_1.add(chckbxNewCheckBox_2_1);
		
		JComboBox comboBox_1 = new JComboBox(sel);
		comboBox_1.setSelectedIndex(-1);
		comboBox_1.setEnabled(false);
		comboBox_1.setBounds(318, 92, 86, 22);
		panel_1.add(comboBox_1);
		
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setEnabled(false);
		spinner_1.setBounds(318, 153, 86, 20);
		panel_1.add(spinner_1);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(318, 31, 86, 20);
		panel_1.add(textField_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Original", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Opcion 1");
		rdbtnNewRadioButton.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnNewRadioButton.isSelected()) {
					rdbtnNewRadioButton_3.setSelected(true);
				}
			}
		});
		rdbtnNewRadioButton.setBounds(30, 20, 109, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Opcion 2");
		rdbtnNewRadioButton_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (rdbtnNewRadioButton_1.isSelected()) {
					rdbtnNewRadioButton_1_1.setSelected(true);
				}
			}
		});
		
		rdbtnNewRadioButton_1.setBounds(30, 82, 109, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Opcion 3");
		rdbtnNewRadioButton_2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (rdbtnNewRadioButton_2.isSelected()) {
					rdbtnNewRadioButton_2_1.setSelected(true);
				}
			}
		});
		rdbtnNewRadioButton_2.setBounds(30, 142, 109, 23);
		panel.add(rdbtnNewRadioButton_2);
		
		ButtonGroup bg = new ButtonGroup();
		
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton_2);
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Opcion 1");
		chckbxNewCheckBox.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					chckbxNewCheckBox_3.setSelected(true);
				}else if(!chckbxNewCheckBox.isSelected()) {
					chckbxNewCheckBox_3.setSelected(false);
				}
			}
		});
		chckbxNewCheckBox.setBounds(168, 20, 97, 23);
		panel.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Opcion 2");
		chckbxNewCheckBox_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(chckbxNewCheckBox_1.isSelected()) {
					chckbxNewCheckBox_1_1.setSelected(true);
				}else if(!chckbxNewCheckBox_1.isSelected()) {
					chckbxNewCheckBox_1_1.setSelected(false);
				}
			}
		});
		chckbxNewCheckBox_1.setBounds(168, 82, 97, 23);
		panel.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Opcion 3");
		chckbxNewCheckBox_2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(chckbxNewCheckBox_2.isSelected()) {
					chckbxNewCheckBox_2_1.setSelected(true);
				}else if(!chckbxNewCheckBox_2.isSelected()) {
					chckbxNewCheckBox_2_1.setSelected(false);
				}
			}
		});
		chckbxNewCheckBox_2.setBounds(168, 142, 97, 23);
		panel.add(chckbxNewCheckBox_2);
		
		textField = new JTextField();
		textField.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				textField_1.setText(textField.getText());
			}
		});		
		textField.setBounds(319, 21, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				spinner_1.setValue(spinner.getValue());
			}
		});
		spinner.setBounds(319, 143, 86, 20);
		panel.add(spinner);
		
		JComboBox comboBox = new JComboBox(sel);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBox_1.setSelectedIndex(comboBox.getSelectedIndex());
			}
		});
		comboBox.setSelectedIndex(-1);
		comboBox.setBounds(319, 82, 86, 22);
		panel.add(comboBox);
		
		frame.getContentPane().add(panel_1);
		
		
	}
}
