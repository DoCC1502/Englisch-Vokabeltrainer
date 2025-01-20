package englischVokabeltrainerCGH.model;

import englischVokabeltrainerFileHandler.SaveLoadUserAccount;
import englischVokabeltrainerCGH.model.*
		;

import java.io.File;
import java.io.Serializable;
/**
 * Diese Klasse repräsentiert den UserAccount.
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 1.0
 */
public class UserAccount implements Serializable {

	private String benutzername;

	private SchwierigkeitsLevel level;

	private String passwort;

	private VokabelListe vokabelListe;

	private FavouriteList favouriteList;

	private VokabelStatistik vokabelStatistik;
	/**
	 * Erstellt einen neuen UserAccount.
	 * @param benutzername Benutzername
	 * @param level Schwierigkeitslevel
	 * @param passwort Passwort
	 */
	public UserAccount(String benutzername, SchwierigkeitsLevel level, String passwort) {
		if (benutzername != null && level != null && passwort != null && checkUsername(benutzername) && passwort.length() >= 8) {
			this.benutzername = benutzername;
			this.level = level;
			this.passwort = passwort;
			VokabelPaar[] vokabelPaare = new VokabelPaar[0];
			this.vokabelListe = new VokabelListe(vokabelPaare);
			vokabelListe.addVokabelPaar("Haus", "House");
			vokabelListe.addVokabelPaar("Auto", "Car");
			vokabelListe.addVokabelPaar("Katze", "Cat");
			vokabelListe.addVokabelPaar("Hund", "Dog");
			vokabelListe.addVokabelPaar("Schwierig", "Difficult");
			vokabelListe.addVokabelPaar("Herausforderung", "Challenge");
			vokabelListe.addVokabelPaar("Komplex", "Complex");
			vokabelListe.addVokabelPaar("Fortgeschritten", "Advanced");
			vokabelListe.addVokabelPaar("Unmöglich", "Impossible");
			vokabelListe.addVokabelPaar("Erheblich", "Significant");
			vokabelListe.addVokabelPaar("Herausfordernd", "Challenging");
			vokabelListe.addVokabelPaar("Kompliziert", "Complicated");
			favouriteList = new FavouriteList(0);
			vokabelStatistik = new VokabelStatistik();
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

			favouriteList = new FavouriteList(0);
			vokabelStatistik = new VokabelStatistik();
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
		initializeVokabelListe(sl);
		favouriteList = new FavouriteList(0);
		vokabelStatistik = new VokabelStatistik();
	}

	private void initializeVokabelListe(SchwierigkeitsLevel level) {
		VokabelPaar[] vokabelPaare;
		if (level.getLevel() == 1) {
			vokabelPaare = new VokabelPaar[]{
					new VokabelPaar("Haus", "House"),
					new VokabelPaar("Auto", "Car"),
					new VokabelPaar("Katze", "Cat"),
					new VokabelPaar("Hund", "Dog"),
					new VokabelPaar("Maus", "Mouse"),
			};
		} else if (level.getLevel() == 2) {
			vokabelPaare = new VokabelPaar[]{
					new VokabelPaar("Schwierig", "Difficult"),
					new VokabelPaar("Herausforderung", "Challenge"),
					new VokabelPaar("Komplex", "Complex"),
					new VokabelPaar("Fortgeschritten", "Advanced"),
					new VokabelPaar("Zusammenfassung", "Summary")
			};
		} else {
			vokabelPaare = new VokabelPaar[]{
					new VokabelPaar("Unmöglich", "Impossible"),
					new VokabelPaar("Erheblich", "Significant"),
					new VokabelPaar("Herausfordernd", "Challenging"),
					new VokabelPaar("Kompliziert", "Complicated"),
					new VokabelPaar("Durchschnitt", "Average")
			};
		}
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
	 * Setzt die FavouriteList.
	 * @return FavouriteList
	 */
	public FavouriteList getFavouriteList() {
		return favouriteList;
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
		return name.matches("[a-zA-Z0-9_\\- ]+");
	}

	/**
	 * Gibt die VokabelStatistik zurück.
	 * @return VokabelStatistik
	 */
	public VokabelStatistik getVokabelStatistik() {
		return vokabelStatistik;
	}

	/**
	 * Löscht den UserAccount.
	 */
	public void deleteEverything() {
		level = null;
		if (vokabelListe != null) {
			vokabelListe.deleteList();
			vokabelListe = null;
		}
		File userFile = new File("saves/AccountData/" + benutzername + ".ser");
		if (userFile.exists()) {
			userFile.delete();
		}
		benutzername = null;
		passwort = null;
		favouriteList = new FavouriteList(0);
		vokabelStatistik = null;
	}

	/**
	 * Speichert den UserAccount.
	 */
	public void saveAccount() {
		new SaveLoadUserAccount().saveUserAccount(this, benutzername + ".ser");

	}
}
