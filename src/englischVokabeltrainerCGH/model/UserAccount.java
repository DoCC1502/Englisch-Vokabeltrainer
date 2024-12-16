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
		if (benutzername != null && level != null && passwort != null) {
			this.benutzername = benutzername;
			this.level = level;
			this.passwort = passwort;
			VokabelPaar[] vokabelPaare = new VokabelPaar[0];
			this.vokabelListe = new VokabelListe(vokabelPaare);
		}
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
		SchwierigkeitsLevel sl = new SchwierigkeitsLevel(1);
		this.level = sl;
		this.benutzername = "Gast";
		this.passwort = "Gast";
		VokabelPaar[] vokabelPaare = new VokabelPaar[0];
		this.vokabelListe = new VokabelListe(vokabelPaare);
	}

	/**
	 * Setzt den Benutzernamen.
	 * @param benutzername Benutzername
	 */
	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	/**
	 * Gibt den Benutzernamen zurück.
	 * @return Benutzername
	 */
	public String getBenutzername() {
		return benutzername;
	}

	/**
	 * Setzt das Schwierigkeitslevel.
	 * @param level Schwierigkeitslevel
	 */
	public void setLevel(SchwierigkeitsLevel level) {
		this.level = level;
	}

	/**
	 * Setzt das Schwierigkeitslevel.
	 * @param level Schwierigkeitslevel
	 */
	public void setLevel(int level) {
		SchwierigkeitsLevel sl = new SchwierigkeitsLevel(level);
		this.level = sl;
	}

	/**
	 * Gibt das Schwierigkeitslevel zurück.
	 * @return Schwierigkeitslevel
	 */
	public SchwierigkeitsLevel getLevel() {
		return level;
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
		return passwort;
	}

	/**
	 * Setzt die Vokabelliste.
	 * @param vokabelListe Vokabelliste
	 */
	public void setVokabelListe(VokabelListe vokabelListe) {
		this.vokabelListe = vokabelListe;
	}

	/**
	 * Gibt die Vokabelliste zurück.
	 * @return Vokabelliste
	 */
	public VokabelListe getVokabelListe() {
		return vokabelListe;
	}

	public boolean checkUsername(String name) {
		
	}

	/**
	 * Löscht den UserAccount.
	 */
	protected void deleteEverything() {
		level=null;
		vokabelListe.deleteList();
		vokabelListe=null;
		benutzername=null;
		passwort=null;
	}

}
