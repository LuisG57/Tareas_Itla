package ejemplosClase;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class Menus implements ActionListener{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menus window = new Menus();
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
	public Menus() {
		creamenus();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setJMenuBar(menubar);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(148, 90, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}

	void creamenus() {
		
		menubar = new JMenuBar();
		file = new JMenu("File");
		edit = new JMenu("edit");
		help = new JMenu("help");
		format = new JMenu("format");
		copiar = new JMenuItem("copiar");
		pegar = new JMenuItem("pegar");
		nuevo = new JMenuItem("nuevo");
		ayuda = new JMenuItem("ayuda");
		clear = new JMenuItem("clear");
		menubar.add(file);
		menubar.add(edit);
		menubar.add(help);
		edit.add(format);
		file.add(nuevo);
		file.add(clear);
		format.add(copiar);
		format.add(pegar);
		help.add(ayuda);
		ayuda.addActionListener(this);
		pegar.addActionListener(this);
		copiar.addActionListener(this);
		nuevo.addActionListener(this);
		clear.addActionListener(this);
		
	}
	
	JMenuBar menubar;
	JMenu file, edit,help,format;
	JMenuItem copiar,pegar,nuevo, ayuda, clear;
	private JTextField textField;

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==nuevo) {
			textField.setText("nuevo");
		}else if(e.getSource()==copiar) {
			textField.setText("copiar");
		}else if(e.getSource()==pegar) {
			textField.setText("pegar");
		}else if(e.getSource()==ayuda) {
			textField.setText("ayuda");
		}else if(e.getSource()==clear) {
			textField.setText("");
		}
		
	}
}
