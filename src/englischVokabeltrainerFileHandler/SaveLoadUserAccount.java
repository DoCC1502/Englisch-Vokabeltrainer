package englischVokabeltrainerFileHandler;

import englischVokabeltrainerCGH.model.UserAccount;

import java.io.*;

/**
 * Diese Klasse repräsentiert das Speichern und Laden von UserAccounts.
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 0.1
 */
public class SaveLoadUserAccount {

	private String defaultPfad;

	/**
	 * Erstellt ein neues SaveLoadUserAccount.
	 * @param userAccount UserAccount
	 * @param filename Dateiname
	 */
	public void saveUserAccount(UserAccount userAccount, String filename) {
		saveUserAccount(userAccount, filename, defaultPfad);
	}

	/**
	 * Erstellt ein neues SaveLoadUserAccount.
	 * @param userAccount UserAccount
	 * @param filename Dateiname
	 * @param pfad Pfad
	 */
	public void saveUserAccount(UserAccount userAccount, String filename, String pfad) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pfad + filename))) {
			oos.writeObject(userAccount);
		} catch (IOException e) {
			System.err.println("Fehler beim Speichern des UserAccounts: " + e.getMessage());
		}
	}

	/**
	 * Lädt einen UserAccount.
	 * @param filename Dateiname
	 * @return UserAccount
	 */
	public UserAccount loadUserAccount(String filename) {
		return loadUserAccount(filename, defaultPfad);
	}

	/**
	 * Lädt einen UserAccount.
	 * @param filename Dateiname
	 * @param pfad Pfad
	 * @return UserAccount
	 */
	public UserAccount loadUserAccount(String filename, String pfad) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pfad + filename))) {
			return (UserAccount) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.err.println("Fehler beim Laden des UserAccounts: " + e.getMessage());
			return null;
		}
	}
}
