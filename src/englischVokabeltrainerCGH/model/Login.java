package englischVokabeltrainerCGH.model;
/**
 * Diese Klasse repräsentiert die Login-Funktionalität des Programms.
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 0.1
 */
public class Login {

	private UserAccount userAccount;

	private SchwierigkeitsLevel schwierigkeitsLevel;

	/**
	 * Überprüft die Benutzerdaten.
	 * @param userAcc Benutzerdaten
	 * @return true, wenn die Benutzerdaten korrekt sind, sonst false
	 */
	public boolean checkUserCredentials(UserAccount userAcc) {
		return false;
	}

	/**
	 * Gibt den Benutzeraccount zurück.
	 * @return Benutzeraccount
	 */
	public UserAccount getUserAccount() {
		return null;
	}

	/**
	 * Erstellt einen neuen Benutzer.
	 * @param bName Benutzername
	 * @param pass Passwort
	 * @param level Schwierigkeitslevel
	 */
	public void createNewUser(String bName, String pass, String level) {

	}

}
