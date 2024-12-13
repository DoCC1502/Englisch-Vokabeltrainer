package englischVokabeltrainerFileHandler;

import englischVokabeltrainerCGH.model.UserAccount;
/**
 * Diese Klasse repräsentiert das Speichern und Laden von UserAccounts.
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 0.1
 */
public class SaveLoadUserAccount {

	private String defaultPfad;

	private UserAccount userAccount;

	/**
	 * Erstellt ein neues SaveLoadUserAccount.
	 * @param userAccount UserAccount
	 * @param filename Dateiname
	 */
	public void saveUserAccount(UserAccount userAccount, String filename) {

	}

	/**
	 * Erstellt ein neues SaveLoadUserAccount.
	 * @param userAccount UserAccount
	 * @param filename Dateiname
	 * @param pfad Pfad
	 */
	public void saveUserAccount(UserAccount userAccount, String filename, String pfad) {

	}

	/**
	 * Lädt einen UserAccount.
	 * @param filename Dateiname
	 * @return UserAccount
	 */
	public UserAccount loadUserAccount(String filename) {
		return null;
	}

	/**
	 * Lädt einen UserAccount.
	 * @param filename Dateiname
	 * @param pfad Pfad
	 * @return UserAccount
	 */
	public UserAccount loadUserAccount(String filename, String pfad) {
		return null;
	}

}
