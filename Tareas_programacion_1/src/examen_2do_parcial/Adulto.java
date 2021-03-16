package examen_2do_parcial;

public class Adulto extends Persona {

	public Adulto() {
		
	}
	
	public Adulto(String nombre, int edad, String persona) {
		
		setNombre(nombre);
		setEdad(edad);
		setPersona(persona);
		
	}
	
	@Override
	public String accionProceso() {

		return "Se ha " + proc + " a la persona " + nombre + ", " + persona + " de " + edad + " años de edad.";

	}

	@Override
	public String toString() {

		return "Adulto";
	}
	
}
