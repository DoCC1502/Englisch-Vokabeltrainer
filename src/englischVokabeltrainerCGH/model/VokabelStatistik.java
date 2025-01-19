package englischVokabeltrainerCGH.model;

import java.io.Serializable;
import java.util.List;

/**
 * Diese Klasse repräsentiert die Vokabelstatistik.
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 1.0
 */
public class VokabelStatistik implements Serializable {

	private int gesamtFalsch;

	private int gesamtRichtig;
	private List<VokabelPaarStatistik> vokabelPaarStatistiken;


	/**
	 * Erstellt eine neue Vokabelstatistik.
	 */
	public VokabelStatistik() {
		this.gesamtFalsch = 0;
		this.gesamtRichtig = 0;
	}

	/**
	 * Fügt eine VokabelPaarStatistik hinzu.
	 * @param paarStatistik VokabelPaarStatistik
	 */
	public void addVokabelPaarStatistik(VokabelPaarStatistik paarStatistik) {
			this.vokabelPaarStatistiken.add(paarStatistik);
	}

	/**
	 * Gibt die Liste der VokabelPaarStatistiken zurück.
	 * @return Liste der VokabelPaarStatistiken
	 */
	public List<VokabelPaarStatistik> getVokabelPaarStatistiken() {
		return this.vokabelPaarStatistiken;
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
