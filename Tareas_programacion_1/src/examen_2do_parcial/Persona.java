package examen_2do_parcial;

public abstract class Persona {
	
	public abstract String accionProceso();
	
	String nombre;
	static String proc;
	int edad;
	
	Object persona;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public static String getProc() {
		return proc;
	}
	public static void setProc(String proc) {
		Persona.proc = proc;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Object getPersona() {
		return persona;
	}
	public void setPersona(Object persona) {
		this.persona = persona;
	}
	
}
