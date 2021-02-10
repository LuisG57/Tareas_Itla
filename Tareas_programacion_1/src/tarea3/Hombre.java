package tarea3;

public class Hombre extends Adolecente_M {

	// Constructors
	public Hombre() {
		super();
	}

	public Hombre(String nombre) {
		super(nombre);
	}

	public Hombre(String nombre, String apellido) {
		super(nombre, apellido);
	}

	public Hombre(String nombre, String apellido, int edad) {
		super(nombre, apellido, edad);
	}

	// Methods

	void trabajar() {

		System.out.println("Actualmente trabajo en el area de " + area_Trabajo);

	}

	void estudiar() {

		System.out.println(
				"Estoy estudiando en la universidad y actualmente curso la carrera de " + carrera_universitaria);

	}

	public String getCarrera_universitaria() {
		return carrera_universitaria;
	}

	public void setCarrera_universitaria(String carrera_universitaria) {
		this.carrera_universitaria = carrera_universitaria;
	}

	public String getArea_Trabajo() {
		return area_Trabajo;
	}

	public int getHijos() {
		return hijos;
	}

	public void setHijos(int hijos) {
		this.hijos = hijos;
	}

	public void setArea_Trabajo(String area_Trabajo) {
		this.area_Trabajo = area_Trabajo;
	}

	public boolean isEsposa() {
		return esposa;
	}

	public void setEsposa(boolean esposa) {
		this.esposa = esposa;
	}

	public void cambiarIBancaria(String nCuenta, String Banco) {

		this.nCuenta = nCuenta;
		this.Banco = Banco;

	}

	public String getnCuenta() {
		return nCuenta;
	}

	public void setnCuenta(String nCuenta) {
		this.nCuenta = nCuenta;
	}

	public String getBanco() {
		return Banco;
	}

	public void setBanco(String banco) {
		Banco = banco;
	}
	
	public String iBancaria() {
		
		return "Mi numero de cuenta es el " + nCuenta + " y mi banco es el " + Banco;
		
	}

	// Field constants and variables
	private String carrera_universitaria, area_Trabajo, nCuenta, Banco;
	private int hijos = 0;
	private boolean esposa = false;

}
