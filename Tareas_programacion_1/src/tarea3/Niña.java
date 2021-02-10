package tarea3;

public class Ni�a extends Humano {

	// Constructors
	public Ni�a() {
		super();
	}

	public Ni�a(String nombre) {
		super(nombre);
	}

	public Ni�a(String nombre, String apellido) {
		super(nombre, apellido);
	}

	public Ni�a(String nombre, String apellido, int edad) {
		super(nombre, apellido, edad);
	}

	// Methods
	void jugar() {

		System.out.println("estoy jugando con mis Mu�ecas");

	}

	void estudiar() {
		System.out.println("Estoy estudiando, actualmente estoy en " + nivel_primaria);
	}

	public String getNivel_primaria() {
		return nivel_primaria;
	}

	public void setNivel_primaria(String nivel_primaria) {
		this.nivel_primaria = nivel_primaria;
	}

	public String getHermano() {
		return hermano;
	}

	public void setHermano(Ni�o hermano) {
		this.hermano = hermano.getNombre();
	}

	public String getHermana() {
		return hermana;
	}

	public void setHermana(Ni�a hermana) {
		this.hermana = hermana.getNombre();
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getAbuelo() {
		return abuelo;
	}

	public String getAbuela() {
		return abuela;
	}

	// Field constants & variables
	private String nivel_primaria, direccion, hermano, hermana, abuelo, abuela;

	// metodos abstractos

	void setAbuelo(Adulto abuelo) {

		this.abuelo = abuelo.getNombre();

	}

	void setAbuela(Adulta abuela) {

		this.abuelo = abuela.getNombre();

	}

	void setAltura(int altura) {
		super.altura = altura;
	}

	void setPeso(int peso) {
		super.peso = peso;
	}

	void setEdad(int edad) {
		super.edad = edad;
	}

	public void cambiarNTelefonico(String numeroTelefonico) {

	}

	public void cambiarDireccion(String direccion) {

		this.direccion = direccion;

	}

	public void cambiarIBancaria(String nCuenta, String Banco) {

	}

	public String iBancaria() {
		return null;
	}

}
