package englischVokabeltrainerCGH.model;
/**
 * Diese Klasse repräsentiert die Einstellungen.
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 0.1
 */
public class Settings {

	private UserAccount userAccount;

	/**
	 * Erstellt eine neue Einstellung.
	 * @param userAccount Benutzeraccount
	 */
	Settings(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	/**
	 * Erhöht die Schwierigkeitsstufe.
	 */
	public void schwierigkeitsLevelErhoehen() {
		userAccount.getLevel().setLevel(userAccount.getLevel().getLevel() + 1);
	}

	/**
	 * Erniedrigt die Schwierigkeitsstufe.
	 */
	public void schwierigkeitsLevelSinken() {
		userAccount.getLevel().setLevel(userAccount.getLevel().getLevel() - 1);
	}

	/**
	 * Löscht den Benutzeraccount.
	 */
	public void accountLoeschen(UserAccount userAccount) {
		userAccount.deleteEverything();
	}
	/**
	 * Setzt den Dark/Light Mode.
	 * @param mode Dark/Light Mode
	 */
	public void setDarkLightMode(boolean mode) {

	}
}
