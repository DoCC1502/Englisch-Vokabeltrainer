package englischVokabeltrainerCGH.model;
/**
 * Diese Klasse repräsentiert die Login-Funktionalität des Programms.
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 1.0
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
		if(userAcc.getBenutzername().equals(userAccount.getBenutzername()) && userAcc.getPasswort().equals(userAccount.getPasswort()) && userAcc.getLevel().equals(userAccount.getLevel())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Gibt den Benutzeraccount zurück.
	 * @return Benutzeraccount
	 */
	public UserAccount getUserAccount() {
		return userAccount;
	}

	/**
	 * Erstellt einen neuen Benutzer.
	 * @param bName Benutzername
	 * @param pass Passwort
	 * @param level Schwierigkeitslevel
	 */
	public void createNewUser(String bName, String pass, SchwierigkeitsLevel level) {
		UserAccount user = new UserAccount(bName, level ,pass);
	}

}
