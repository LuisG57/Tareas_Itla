package examen_2do_parcial;

public class Nino extends Persona {
	
	public Nino() {
		
	}
	
	public Nino(String nombre, int edad, String persona) {
		
		setNombre(nombre);
		setEdad(edad);
		setPersona(persona);
		
	}
	

	@Override
	public String accionProceso() {
		
		return "Se ha " + proc + " a la persona " + nombre + ", " + persona + " de " + edad + " a�os de edad.";
		
	}
	
	@Override
	public String toString() {

		return "Ni�o";
	}

}
