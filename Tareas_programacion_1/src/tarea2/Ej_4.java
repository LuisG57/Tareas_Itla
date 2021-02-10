package tarea2;

public class Ej_4 {

	public static void main(String[] args) {

		Libro libro = new Libro ("El principito");
		
		libro.prestar();
		System.out.println(libro.estado());
		
		libro.devolver();
		System.out.println(libro.estado());
		
	}

}

class Libro {
	
	public Libro(String nombre) {
		
		this.setNombre(nombre);
		
	}
	//getter
	public String getNombre() {
		return nombre.toString();
	}
	String estado() {
		
		System.out.print("El estado del libro " + nombre.toString() + " es que ");
		System.out.print(this.prestado?"el libro esta prestado\n":"el libro esta devuelto\n");
		
		return this.prestado?"El libro esta prestado":"el libro esta devuelto";
		
	}
	
	//setter
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	void prestar() {
		
		this.prestado=true;
		System.out.println("El libro " + this.nombre + " ha sido prestado");
		
	}
	void devolver() {
		
		this.prestado=false;
		System.out.println("El libro " + this.nombre + " ha sido devuelto");
		
	}

	private String nombre;
	private boolean prestado;
	
}