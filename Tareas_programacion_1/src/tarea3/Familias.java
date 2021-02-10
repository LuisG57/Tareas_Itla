package tarea3;

public class Familias {

	public static void main(String[] args) {

		// Familia Martinez
		Adulto abuelomartinez = new Adulto("Juan", "Mart�nez");
		Adulta abuelamartinez = new Adulta("Mercedes", "Mart�nez");
		Hombre padremartinez = new Hombre("Jose", "Mart�nez");
		Mujer madremartinez = new Mujer("Maria", "Mart�nez");
		Hombre tiomartinez = new Hombre("Manuel", "Mart�nez");
		// Mujer tiamartinez = new Mujer("Maribelle", "S�nchez");
		Ni�a ni�amartinez = new Ni�a("Samanta", "Mart�nez");
		Ni�o ni�omartinez = new Ni�o("Emilio", "Mart�nez");

		// Familia Sanchez
		Adulto abuelosanchez = new Adulto("Martin", "S�nchez");
		Adulta abuelasanchez = new Adulta("Julia", "S�nchez");
		Hombre padresanchez = new Hombre("Pablo", "S�nchez");
		Mujer madresanchez = new Mujer("Maria", "Mart�nez");
		Hombre tiomsanchez = new Hombre("Samuel", "S�nchez");
		// Mujer tiasanchez = new Mujer("Maribelle", "S�nchez");
		Ni�a ni�asanchez = new Ni�a("Michelle", "S�nchez");
		Ni�o ni�osanchez = new Ni�o("Randy", "S�nchez");

		// poniendo nietos e hijos a los abuelos martinez
		abuelomartinez.setNieto(ni�omartinez);
		abuelomartinez.setNieta(ni�amartinez);
		abuelamartinez.setNieto(ni�omartinez);
		abuelamartinez.setNieta(ni�amartinez);
		// poniendo hermanos, padres e hijos a los padres martinez
		padremartinez.setPadre(abuelomartinez);
		tiomartinez.setPadre(abuelomartinez);
		padremartinez.setMadre(abuelamartinez);
		tiomartinez.setMadre(abuelamartinez);
		padremartinez.setHermano(tiomartinez);
		madremartinez.setHermana(madresanchez);
		// poniendo lazos familiares a los ni�os martinez
		ni�amartinez.setHermano(ni�omartinez);
		ni�omartinez.setHermana(ni�amartinez);
		ni�amartinez.setPadre(padremartinez);
		ni�amartinez.setMadre(madremartinez);
		ni�omartinez.setPadre(padremartinez);
		ni�omartinez.setMadre(madremartinez);
		ni�amartinez.setAbuela(abuelamartinez);
		ni�omartinez.setAbuelo(abuelomartinez);

		// poniendo nietos e hijos a los abuelos en familia sanchez
		abuelosanchez.setNieto(ni�osanchez);
		abuelosanchez.setNieta(ni�asanchez);
		abuelasanchez.setNieto(ni�osanchez);
		abuelasanchez.setNieta(ni�asanchez);
		// poniendo hermanos, padres e hijos a los padres sanchez
		padresanchez.setPadre(abuelosanchez);
		tiomsanchez.setPadre(abuelosanchez);
		padresanchez.setMadre(abuelasanchez);
		tiomsanchez.setMadre(abuelasanchez);
		padresanchez.setHermano(tiomsanchez);
		madresanchez.setHermana(madremartinez);
		// poniendo lazos familiares a los ni�os sanchez
		ni�asanchez.setHermano(ni�osanchez);
		ni�osanchez.setHermana(ni�asanchez);
		ni�asanchez.setPadre(padresanchez);
		ni�asanchez.setMadre(madresanchez);
		ni�osanchez.setPadre(padresanchez);
		ni�osanchez.setMadre(madresanchez);
		ni�asanchez.setAbuela(abuelasanchez);
		ni�osanchez.setAbuelo(abuelosanchez);

	}

}
