package tarea3;

public abstract class Humano implements InformacionPersonal {

	// Constructors
	public Humano() {

	}

	public Humano(String nombre) {

		this.nombre = nombre;

	}

	public Humano(String nombre, String apellido) {

		this.nombre = nombre;
		this.apellido = apellido;

	}

	public Humano(String nombre, String apellido, int edad) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;

	}

	// Methods
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getEdad() {
		return edad;
	}

	abstract void setEdad(int edad);

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getAltura() {
		return altura;
	}

	abstract void setAltura(int altura);

	public int getPeso() {
		return peso;
	}

	public String getPadre() {
		return padre;
	}

	public void setPadre(Adolecente_M Padre) {
		padre = Padre.getNombre();
	}

	public String getMadre() {
		return madre;
	}

	public void setMadre(Adolecente_F madre) {
		this.madre = madre.getNombre();
	}

	abstract void setPeso(int peso);

	abstract void setHermano(Niño hermano);

	abstract void setHermana(Niña hermana);

	abstract void setAbuelo(Adulto abuelo);

	abstract void setAbuela(Adulta abuela);

	// Field variables & constants
	private String nombre, apellido;

	protected int edad;

	protected int altura, peso;

	private String padre, madre;

}
