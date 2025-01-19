package englischVokabeltrainerCGH.model;

import java.io.Serializable;

/**
 * Diese Klasse repräsentiert die Statistik eines Vokabelpaares.
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 0.1
 */
public class VokabelPaarStatistik implements Serializable {

	private int falsch;
	private int richtig;
	private String wortDe;
	private String wortEn;

	/**
	 * Erstellt eine neue VokabelPaarStatistik.
	 */
	public VokabelPaarStatistik(String wortEn, String wortDe, int richtig, int falsch) {
		this.falsch = 0;
		this.richtig = 0;
		this.wortDe = wortDe;
		this.wortEn = wortEn;
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
	/**
	 * Setzt das deutsche Wort.
	 * @param wortDe Wort in Deutsch
	 */
	public void setWortDe(String wortDe) {
		this.wortDe = wortDe;
	}

	/**
	 * Gibt das deutsche Wort zurück.
	 * @return Wort in Deutsch
	 */
	public String getWortDe() {
		return wortDe;
	}

	/**
	 * Setzt das englische Wort.
	 * @param wortEn Wort in Englisch
	 */
	public void setWortEn(String wortEn) {
		this.wortEn = wortEn;
	}

	/**
	 * Gibt das englische Wort zurück.
	 * @return Wort in Englisch
	 */
	public String getWortEn() {
		return wortEn;
	}

}
