package tarea2;

public class Ej_5 {

	public static void main(String[] args) {
		// Prueba de suma y resta
		Fraccion fraccion1 = new Fraccion(2, 8);
		Fraccion fraccion2 = new Fraccion(2, 4);
		Fraccion suma = fraccion1.sumar(fraccion2);
		Fraccion resta = fraccion1.restar(fraccion2);
		System.out.println(fraccion1 + " + " + fraccion2 + " = " + suma);
		System.out.println(fraccion1 + " - " + fraccion2 + " = " + resta);
	}

}

class Fraccion {

	// Constructores
	public Fraccion() {

	}

	public Fraccion(int numerador, int denominador) {
		this.numerador = numerador;
		if (denominador == 0) {
			denominador = 1;
		}
		this.denominador = denominador;
	}

	public Fraccion(int numerador) {
		this.numerador = numerador;
		this.denominador = 1;
	}

	// Metodos
	public Fraccion sumar(Fraccion f) {
		Fraccion resultado = new Fraccion();
		resultado.numerador = this.numerador * f.denominador + this.denominador * f.numerador;
		resultado.denominador = this.denominador * f.denominador;
		return resultado;
	}

	public String toString() {
		return numerador + "/" + denominador;
	}

	public Fraccion restar(Fraccion f) {
		Fraccion resultado = new Fraccion();
		resultado.numerador = this.numerador * f.denominador - this.denominador * f.numerador;
		resultado.denominador = this.denominador * f.denominador;
		return resultado;
	}

	public Fraccion multiplicar(Fraccion f) {
		Fraccion resultado = new Fraccion();
		resultado.numerador = this.numerador * f.numerador;
		resultado.denominador = this.denominador * f.denominador;
		return resultado;
	}

	public Fraccion dividir(Fraccion f) {
		Fraccion resultado = new Fraccion();
		resultado.numerador = this.numerador * f.denominador;
		resultado.denominador = this.denominador * f.numerador;
		return resultado;
	}

	// Campos de clase
	private int numerador;
	private int denominador;

}