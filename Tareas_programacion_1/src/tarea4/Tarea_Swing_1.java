package tarea4;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Tarea_Swing_1 {

	public static void main(String[] args) {

		swing ventana = new swing();

	}

}

class swing {

	// Constructors

	public swing() {

		frame();
		panel1();
		panel2();
		panel3();
		panel4();

		m.add(p4);
		m.add(p1);
		m.add(p2);
		m.add(p3);

		p1.updateUI();
		p2.updateUI();
		p3.updateUI();
		p4.updateUI();

	}

	// Methods

	void frame() {

		m = new JFrame();

		// m.setBounds(150, 150, 600, 550);
		m.setTitle("Ejercicio Swing");
		m.setSize(600, 500);
		m.setLayout(new BoxLayout(m.getContentPane(), BoxLayout.Y_AXIS));
		m.setLocationRelativeTo(null);
		m.setVisible(true);
		m.setResizable(false);
		m.setAlwaysOnTop(true);
		m.setMinimumSize(m.getPreferredSize());
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	void panel1() {

		p1 = new JPanel();
		JButton b1 = new JButton("Probar conexion");
		b1.setMaximumSize(new Dimension(200, 50));
		p1.add(b1);
		JButton b2 = new JButton("Probar conexion");
		b2.setMaximumSize(new Dimension(200, 50));
		p1.add(b2);
		// p1.setMaximumSize(new Dimension(200,200));
		p1.setLayout(new BoxLayout(p1, BoxLayout.X_AXIS));

	}

	void panel2() {

		p2 = new JPanel();
		Object[] o2 = { "Nombre", "Apellido", "Email", "Telefono", "Direccion", "Sexo" };
		DefaultTableModel dt = new DefaultTableModel(o2, 0);
		JTable t = new JTable(dt);
		JScrollPane sp = new JScrollPane(t);
		p2.add(sp);
		p2.setMaximumSize(new Dimension(600, 150));
		p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));

	}

	void panel3() {

		p3 = new JPanel();
		String nb[] = { "Ir", "Guardar", "Eliminar", "Modificar", "Limpiar", "Salir" };
		ImageIcon ic = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src/graphics/Disquete_icon_save 1.png"));

		for (int i = 0; i < nb.length; i++) {
			switch (i) {
			case 1:
				p3.add(new JButton(nb[i], ic));
				break;
			default:
				JButton b = new JButton(nb[i]);
				b.setMaximumSize(new Dimension(90, 50));
				p3.add(b);
			}
		}
		p3.setLayout(new BoxLayout(p3, BoxLayout.X_AXIS));

	}

	void panel4() {

		BorderLayout bl = new BorderLayout();
		bl.setHgap(10);
		p4 = new JPanel(new GridLayout(1, 1));
		p4.setBorder(BorderFactory.createTitledBorder("Datos Personales"));
		JTextField tf1 = new JTextField(20), tf2 = new JTextField(20), tf3 = new JTextField(4), tf4 = new JTextField(4),
				tf5 = new JTextField(20);

		p5 = new JPanel();
		p5.setLayout(new BoxLayout(p5, BoxLayout.Y_AXIS));
		//p5.setAlignmentX(Component.LEFT_ALIGNMENT);
		JLabel l = new JLabel("Nombres del Contacto:");
		p5.add(l);
		p5.add(tf1);
		p5.add(new JLabel("Apellidos del Contacto:"));
		p5.add(tf2);
		p6 = new JPanel(new GridLayout(2, 2, 0, 0));
		p6.add(new JLabel("Email:"));
		p6.add(new JLabel("Celular"));
		p6.add(tf3);
		p6.add(tf4);
		p5.add(p6);
		p5.add(new JLabel("Direccion"));
		p5.add(tf5);
		
		// p5.setPreferredSize(new Dimension(150,150));

		p4.add(p5, BorderLayout.WEST);
		p7 = new JPanel();
		
		p7.setLayout(new BoxLayout(p7, BoxLayout.Y_AXIS));
		//p7.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel jl = new JLabel("FOTO", JLabel.CENTER);
		jl.setMaximumSize(new Dimension(125,100));
		
		jl.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

		p7.add(jl);
		p7.add(new JButton("Cargar Foto"));
		p7.add(new JLabel("Sexo:"));
		
		String[] lista = {"Seleccione", "Femenino", "Masculino"};
		JComboBox jcb = new JComboBox(lista);
		jcb.setMaximumSize(new Dimension(150,30));
		p7.add(jcb);
		p4.add(p7, BorderLayout.EAST);
		p4.revalidate();

	}

	// class fields
	JPanel p1, p2, p3, p4, p5, p6, p7;
	JFrame m;
}