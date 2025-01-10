package englischVokabeltrainerCGH.model;
/**
 * Diese Klasse repräsentiert die Vokabelstatistik.
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 0.1
 */
public class VokabelStatistik {

	private int gesamtFalsch;

	private int gesamtRichtig;

	/**
	 * Erstellt eine neue Vokabelstatistik.
	 */
	public VokabelStatistik() {
		this.gesamtFalsch = 0;
		this.gesamtRichtig = 0;
	}

	/**
	 * Setzt die Anzahl aller falschen Antworten.
	 * @param falsch Anzahl aller falschen Antworten
	 */
	public void setGesamtFalsch(int falsch) {
		this.gesamtFalsch = falsch;
	}

	/**
	 * Gibt die Anzahl aller falschen Antworten zurück.
	 * @return Anzahl aller falschen Antworten
	 */
	public int getGesamtFalsch() {
		return gesamtFalsch;
	}

	/**
	 * Setzt die Anzahl aller richtigen Antworten.
	 * @param richtig Anzahl aller richtigen Antworten
	 */
	public void setGesamtRichtig(int richtig) {
		this.gesamtRichtig = richtig;
	}

	/**
	 * Gibt die Anzahl aller richtigen Antworten zurück.
	 * @return Anzahl aller richtigen Antworten
	 */
	public int getGesamtRichtig() {
		return gesamtRichtig;
	}

}
