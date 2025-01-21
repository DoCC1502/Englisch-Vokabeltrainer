package englischVokabeltrainerCGH.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Diese Klasse repräsentiert ein Vokabelpaar.
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 1.0
 */
public class VokabelPaar implements Serializable {

	private String wortDe;

	private String wortEn;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		VokabelPaar that = (VokabelPaar) o;
		return Objects.equals(wortDe, that.wortDe) && Objects.equals(wortEn, that.wortEn);
	}

	@Override
	public int hashCode() {
		return Objects.hash(wortDe, wortEn);
	}
}
