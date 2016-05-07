package sistemskeoperacije;

import menjacnica.Valuta;

public class SONapraviValutu {

	public static Valuta izvrsi(int sifra, String naziv, String skraceniNaziv, double kupovni, double prodajni,
			double srednji) {
		Valuta valuta = new Valuta();
		valuta.setKupovni(kupovni);
		valuta.setNaziv(naziv);
		valuta.setProdajni(prodajni);
		valuta.setSifra(sifra);
		valuta.setSkraceniNaziv(skraceniNaziv);
		valuta.setSrednji(srednji);
		return valuta;
	}

}
