package tarea2;

public class Ej_6 {

	public static void main(String[] args) {

		Complejo comp1 = new Complejo(5, 2);
		Complejo comp2 = new Complejo(4, 7);
		comp1.sumar(comp2).imprimirResultado();

		Complejo comp3 = new Complejo(7, 2);
		Complejo comp4 = new Complejo(5, 9);
		comp3.restar(comp4).imprimirResultado();

	}

}

class Complejo {

	public Complejo() {

	}

	public Complejo(double re, double im) {

		this.real = re;
		this.imag = im;

	}

	public double real;
	public double imag;

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImag() {
		return imag;
	}

	public void setImag(double imag) {
		this.imag = imag;
	}

	public void imprimirResultado() {

		if (this.imag < 0) {

			if (this.real % 1 == 0 && this.imag % 1 == 0) {
				System.out.println(String.format("%.0f", this.real) + " - "
						+ String.format("%.0f", (this.imag - (this.imag * 2))) + "i");
			} else {
				System.out.println(this.real + "+" + this.imag + "i");
			}

		} else {

			if (this.real % 1 == 0 && this.imag % 1 == 0) {
				System.out.println(String.format("%.0f", this.real) + " + " + String.format("%.0f", this.imag) + "i");
			} else {
				System.out.println(this.real + "+" + this.imag + "i");
			}

		}

	}

	public Complejo sumar(Complejo n) {
		return new Complejo(this.real + n.real, this.imag + n.imag);
	}

	public Complejo restar(Complejo n) {
		return new Complejo(this.real - n.real, this.imag - n.imag);
	}
	public Complejo multiplicar(Complejo n) {
		return new Complejo(this.real * n.real - this.imag * n.imag, this.real * n.imag + this.imag * n.real);
	}
	public Complejo Dividir(Complejo n) {
		return new Complejo((this.real * n.real + this.imag * n.imag)/(n.real * n.real + n.imag * n.imag), (this.imag * n.real - this.real * n.imag)/(n.real * n.real + n.imag * n.imag));
	}

}