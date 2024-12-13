package model;

public class UserAccount implements Serializable {

	private String benutzername;

	private SchwierigkeitsLevel level;

	private String passwort;

	private VokabelListe vokabelListe;

	private Login login;

	private SchwierigkeitsLevel schwierigkeitsLevel;

	private VokabelListe vokabelListe;

	public UserAccount(String benutzername, SchwierigkeitsLevel level, String passwort) {

	}

	public UserAccount(String benutzername, SchwierigkeitsLevel level, String passwort, VokabelListe vokabelListe) {

	}

	public UserAccount() {

	}

	public void setBenutzername(String benutzername) {

	}

	public String getBenutzername() {
		return null;
	}

	public void setLevel(SchwierigkeitsLevel level) {

	}

	public SchwierigkeitsLevel getLevel() {
		return null;
	}

	public void setPasswort(String passwort) {

	}

	public String getPasswort() {
		return null;
	}

	public void setVokabelListe(VokabelListe vokabelListe) {

	}

	public VokabelListe getVokabelListe() {
		return null;
	}

}
