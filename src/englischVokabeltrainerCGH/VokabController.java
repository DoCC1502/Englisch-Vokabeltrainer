package englischVokabeltrainerCGH;
import englischVokabeltrainerCGH.model.*;
import englischVokabeltrainerCGH.view.*;
import englischVokabeltrainerFileHandler.SaveLoadUserAccount;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

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
    public void handleLogin(String username, int level) {
        userAccount = new UserAccount(username, new SchwierigkeitsLevel(level), "12345678");
        vTrainerModel = new VokabTrainer(userAccount);
        homemenuPanel = new HomemenuPanel(this);
        vFrame = new VokabFrame(homemenuPanel, this);
        vFrame.setVisible(true);
    }


    /**
     * Startet den Vokabeltrainer.
     * @param args Kommandozeilenargumente
     */
    public static void main(String[] args) {
        int response = JOptionPane.showConfirmDialog(null, "Haben Sie bereits einen Account?", "Account Abfrage",
                JOptionPane.YES_NO_OPTION);

        SaveLoadUserAccount saveLoadUserAccount = new SaveLoadUserAccount();

        if (response == JOptionPane.YES_OPTION) {
            String username = JOptionPane.showInputDialog(null, "Bitte geben Sie Ihren Benutzernamen ein:");
            if (username != null && !username.trim().isEmpty()) {
                UserAccount userAccount = saveLoadUserAccount.loadUserAccount(username);
                if (userAccount != null) {
                    new VokabController(userAccount);
                } else {
                    JOptionPane.showMessageDialog(null, "Benutzerkonto nicht gefunden. Das Programm wird normal gestartet.");
                    new VokabController();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ungültiger Benutzername. Das Programm wird normal gestartet.");
                new VokabController();
            }
        } else {
            new VokabController();
        }
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
