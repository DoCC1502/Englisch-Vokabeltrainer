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
		if (benutzername != null && level != null && passwort != null && checkUsername(benutzername) && passwort.length() > 8) {
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
		if (benutzername != null && level != null && passwort != null && checkUsername(benutzername) && passwort.length() > 8) {
			this.benutzername = benutzername;
			this.level = level;
			this.passwort = passwort;
			this.vokabelListe = vokabelListe;
		}
	}

	/**
	 * Erstellt einen neuen Gast UserAccount.
	 */
	public UserAccount() {
		SchwierigkeitsLevel sl = new SchwierigkeitsLevel(1);
		this.level = sl;
		this.benutzername = "Gast";
		this.passwort = "12345678";
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
		if(passwort.length() > 8) {
			this.passwort = passwort;
		}
		else {
			this.passwort = "12345678";
		}
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

	/**
	 * Überprüft den Benutzernamen.
	 * @param name Benutzername
	 * @return true, wenn der Benutzername korrekt ist, sonst false
	 */
	public boolean checkUsername(String name) {
		if (!(name.length() > 3 && name.length() < 20)) {
			return false;
		}
		return name.matches("[a-zA-Z0-9_-]+");
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
