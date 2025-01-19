package englischVokabeltrainerCGH;
import englischVokabeltrainerCGH.model.*;
import englischVokabeltrainerCGH.view.*;
/**
 * Diese Klasse repräsentiert den Vokabeltrainer.
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 1.0
 */
public class VokabController {
    private UserAccount userAccount;
    private VokabTrainer vTrainerModel;
    private HomemenuPanel homemenuPanel;
    private VokabFrame vFrame;
    /**
     * Konstruktor der Klasse VokabController.
     */
    public VokabController() {
        userAccount = new UserAccount();
        vTrainerModel = new VokabTrainer(userAccount);
        homemenuPanel = new HomemenuPanel(this);
        vFrame = new VokabFrame(homemenuPanel, this);

        vFrame.setVisible(true);
    }
    /**
     * Konstruktor der Klasse VokabController.
     * @param userAccount Benutzerkonto
     */
    public VokabController(UserAccount userAccount) {
        this.userAccount = userAccount;
        vTrainerModel = new VokabTrainer(userAccount);
        homemenuPanel = new HomemenuPanel(this);
        vFrame = new VokabFrame(homemenuPanel, this);

        vFrame.setVisible(true);
    }

    /**
     * Gibt die FavouriteList des Benutzers zurück.
     * @return FavouriteList
     */
    public FavouriteList getFavouriteList() {
        return userAccount.getFavouriteList();
    }

    /**
     * Gibt das Benutzerkonto zurück.
     * @return UserAccount
     */
    public UserAccount getUserAccount() {
        return userAccount;
    }

    /**
     * Setzt das Benutzerkonto.
     * @param username Benutzername
     * @param level Schwierigkeitsgrad
     */
    public void handleLogin(String username, String level) {}

    /**
     * Startet den Vokabeltrainer.
     * @param args Kommandozeilenargumente
     */
    public static void main(String[] args) {
        new VokabController();

    }

    /**
     * Aktualisiert das FavouritePanel.
     */
    public void renewFavpanel() {
        vFrame.renewFavpanel();
    }

    /**
     * Gibt das Vokabeltrainer-Frame zurück.
     * @return VokabTrainer-Frame
     */
    public VokabFrame getVFrame() {
        return vFrame;
    }

    /**
     * Gibt das Vokabeltrainer-Modell zurück.
     * @return VokabTrainer
     */
    public VokabTrainer getVTrainerModel() {
        return vTrainerModel;
    }

    /**
     * Updatet das Ergebnis des Benutzers.
     * @param isCorrect Ob die Antwort korrekt ist
     */
    public void updateResult(boolean isCorrect) {
        vTrainerModel.getResultObj().incrementResult(isCorrect);
    }
}
