package englischVokabeltrainerCGH.model;
/**
 * Diese Klasse repräsentiert die Statistik eines Vokabelpaares.
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 0.1
 */
public class VokabelPaarStatistik {

	private int falsch;
	private int richtig;

	/**
	 * Erstellt eine neue VokabelPaarStatistik.
	 */
	public VokabelPaarStatistik() {
		this.falsch = 0;
		this.richtig = 0;
	}

	/**
	 * Setzt die Anzahl der falschen Antworten.
	 * @param falsch Anzahl der falschen Antworten
	 */
	public void setFalsch(int falsch) {
		if(falsch >= 0) {
			this.falsch = falsch;
		}
		else {
			throw new IllegalArgumentException("Anzahl von falschen Antworten kann nicht negativ sein.");
		}
	}
	/**
	 * Gibt die Anzahl der falschen Antworten zurück.
	 * @return Anzahl der falschen Antworten
	 */
	public int getFalsch() {return falsch;}
	/**
	 * Setzt die Anzahl der richtigen Antworten.
	 * @param richtig Anzahl der richtigen Antworten
	 */
	public void setRichtig(int richtig) {
		if(richtig >= 0) {
			this.richtig = richtig;
		}
		else {
			throw new IllegalArgumentException("Anzahl von richtigen Antworten kann nicht negativ sein.");
		}
	}
	/**
	 * Gibt die Anzahl der richtigen Antworten zurück.
	 * @return Anzahl der richtigen Antworten
	 */
	public int getRichtig() {
		return richtig;
	}

}
