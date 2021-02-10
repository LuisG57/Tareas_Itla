package tarea3;

public class Familias {

	public static void main(String[] args) {

		// Familia Martinez
		Adulto abuelomartinez = new Adulto("Juan", "Martínez");
		Adulta abuelamartinez = new Adulta("Mercedes", "Martínez");
		Hombre padremartinez = new Hombre("Jose", "Martínez");
		Mujer madremartinez = new Mujer("Maria", "Martínez");
		Hombre tiomartinez = new Hombre("Manuel", "Martínez");
		// Mujer tiamartinez = new Mujer("Maribelle", "Sánchez");
		Niña niñamartinez = new Niña("Samanta", "Martínez");
		Niño niñomartinez = new Niño("Emilio", "Martínez");

		// Familia Sanchez
		Adulto abuelosanchez = new Adulto("Martin", "Sánchez");
		Adulta abuelasanchez = new Adulta("Julia", "Sánchez");
		Hombre padresanchez = new Hombre("Pablo", "Sánchez");
		Mujer madresanchez = new Mujer("Maria", "Martínez");
		Hombre tiomsanchez = new Hombre("Samuel", "Sánchez");
		// Mujer tiasanchez = new Mujer("Maribelle", "Sánchez");
		Niña niñasanchez = new Niña("Michelle", "Sánchez");
		Niño niñosanchez = new Niño("Randy", "Sánchez");

		// poniendo nietos e hijos a los abuelos martinez
		abuelomartinez.setNieto(niñomartinez);
		abuelomartinez.setNieta(niñamartinez);
		abuelamartinez.setNieto(niñomartinez);
		abuelamartinez.setNieta(niñamartinez);
		// poniendo hermanos, padres e hijos a los padres martinez
		padremartinez.setPadre(abuelomartinez);
		tiomartinez.setPadre(abuelomartinez);
		padremartinez.setMadre(abuelamartinez);
		tiomartinez.setMadre(abuelamartinez);
		padremartinez.setHermano(tiomartinez);
		madremartinez.setHermana(madresanchez);
		// poniendo lazos familiares a los niños martinez
		niñamartinez.setHermano(niñomartinez);
		niñomartinez.setHermana(niñamartinez);
		niñamartinez.setPadre(padremartinez);
		niñamartinez.setMadre(madremartinez);
		niñomartinez.setPadre(padremartinez);
		niñomartinez.setMadre(madremartinez);
		niñamartinez.setAbuela(abuelamartinez);
		niñomartinez.setAbuelo(abuelomartinez);

		// poniendo nietos e hijos a los abuelos en familia sanchez
		abuelosanchez.setNieto(niñosanchez);
		abuelosanchez.setNieta(niñasanchez);
		abuelasanchez.setNieto(niñosanchez);
		abuelasanchez.setNieta(niñasanchez);
		// poniendo hermanos, padres e hijos a los padres sanchez
		padresanchez.setPadre(abuelosanchez);
		tiomsanchez.setPadre(abuelosanchez);
		padresanchez.setMadre(abuelasanchez);
		tiomsanchez.setMadre(abuelasanchez);
		padresanchez.setHermano(tiomsanchez);
		madresanchez.setHermana(madremartinez);
		// poniendo lazos familiares a los niños sanchez
		niñasanchez.setHermano(niñosanchez);
		niñosanchez.setHermana(niñasanchez);
		niñasanchez.setPadre(padresanchez);
		niñasanchez.setMadre(madresanchez);
		niñosanchez.setPadre(padresanchez);
		niñosanchez.setMadre(madresanchez);
		niñasanchez.setAbuela(abuelasanchez);
		niñosanchez.setAbuelo(abuelosanchez);

	}

}
