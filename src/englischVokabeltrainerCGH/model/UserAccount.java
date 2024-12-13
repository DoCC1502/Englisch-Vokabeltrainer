package englischVokabeltrainerCGH.model;

import java.io.Serializable;
/**
 * Diese Klasse repräsentiert den UserAccount.
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 0.1
 */
public class UserAccount implements Serializable {

	private String benutzername;

	private SchwierigkeitsLevel level;

	private String passwort;

	private VokabelListe vokabelListe;

	/**
	 * Erstellt einen neuen UserAccount.
	 * @param benutzername Benutzername
	 * @param level Schwierigkeitslevel
	 * @param passwort Passwort
	 */
	public UserAccount(String benutzername, SchwierigkeitsLevel level, String passwort) {

	}

	/**
	 * Erstellt einen neuen UserAccount.
	 * @param benutzername Benutzername
	 * @param level Schwierigkeitslevel
	 * @param passwort Passwort
	 * @param vokabelListe Vokabelliste
	 */
	public UserAccount(String benutzername, SchwierigkeitsLevel level, String passwort, VokabelListe vokabelListe) {

	}

	/**
	 * Erstellt einen neuen UserAccount.
	 */
	public UserAccount() {

	}

	/**
	 * Setzt den Benutzernamen.
	 * @param benutzername Benutzername
	 */
	public void setBenutzername(String benutzername) {

	}

	/**
	 * Gibt den Benutzernamen zurück.
	 * @return Benutzername
	 */
	public String getBenutzername() {
		return null;
	}

	/**
	 * Setzt das Schwierigkeitslevel.
	 * @param level Schwierigkeitslevel
	 */
	public void setLevel(SchwierigkeitsLevel level) {

	}

	/**
	 * Gibt das Schwierigkeitslevel zurück.
	 * @return Schwierigkeitslevel
	 */
	public SchwierigkeitsLevel getLevel() {
		return null;
	}

	/**
	 * Setzt das Passwort.
	 * @param passwort Passwort
	 */
	public void setPasswort(String passwort) {

	}

	/**
	 * Gibt das Passwort zurück.
	 * @return Passwort
	 */
	public String getPasswort() {
		return null;
	}

	/**
	 * Setzt die Vokabelliste.
	 * @param vokabelListe Vokabelliste
	 */
	public void setVokabelListe(VokabelListe vokabelListe) {

	}

	/**
	 * Gibt die Vokabelliste zurück.
	 * @return Vokabelliste
	 */
	public VokabelListe getVokabelListe() {
		return null;
	}

}
