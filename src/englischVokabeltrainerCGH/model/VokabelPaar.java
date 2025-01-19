package englischVokabeltrainerCGH.model;
/**
 * Diese Klasse repräsentiert ein Vokabelpaar.
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 0.1
 */
public class VokabelPaar {

	private String wortDe;

	private String wortEn;

	private VokabelPaarStatistik vokabelPaarStatistik;

	private boolean isFavourite;

	private SchwierigkeitsLevel schwierigkeit;

	/**
	 * Erstellt ein neues Vokabelpaar.
	 * @param wortDe Wort in Deutsch
	 * @param wortEn Wort in Englisch
	 */
	public VokabelPaar(String wortDe, String wortEn) {
		this.wortDe = wortDe;
		this.wortEn = wortEn;
	}

	/**
	 * Überprüft, ob das Vokabelpaar korrekt ist.
	 * @param wortDe Wort in Deutsch
	 * @param wortEn Wort in Englisch
	 * @return true, wenn das Vokabelpaar korrekt ist, sonst false
	 */
	public boolean checkVokabelPaar(String wortDe, String wortEn) {
		return this.wortDe.equals(wortDe) && this.wortEn.equals(wortEn);
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
		return wortEn.toLowerCase();
	}

	/**
	 * Setzt das Vokabelpaar als Favorit.
	 */
	public void setFavourite() {
		this.isFavourite = true;
	}

	/**
	 * Setzt die Schwierigkeit.
	 * @param schwierigkeit Schwierigkeitslevel
	 */
	public void setSchwierigkeit(SchwierigkeitsLevel schwierigkeit) {
		this.schwierigkeit = schwierigkeit;
	}

	/**
	 * Gibt die Schwierigkeit zurück.
	 * @return Schwierigkeitslevel
	 */
	public SchwierigkeitsLevel getSchwierigkeit() {
		return schwierigkeit;
	}
}
