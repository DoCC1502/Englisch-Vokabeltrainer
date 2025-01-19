package englischVokabeltrainerCGH.view;

import englischVokabeltrainerCGH.VokabController;
import englischVokabeltrainerCGH.model.*;

import javax.swing.*;
import java.awt.*;

/**
 * Hauptframe des Vokabeltrainers
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 1.0
 */
public class VokabFrame extends JFrame {
	private CardLayout cardLayout;
	private JPanel mainPanel;
	private HomemenuPanel homemenuPanel;
	private UploadPanel uploadPanel;
	private SettingsPanel settingsPanel;
	private LoginPanel loginPanel;
	private FavPanel favPanel;
	private ResultPanel resultPanel;
	private VokabTrainerPanel vokabTrainerPanel;
	private StatistikPanel statistikPanel;
	private VokabController vController;

	/**
	 * Konstruktor
	 * @param startPanel Startpanel
	 * @param vController Controller
	 */
	public VokabFrame(HomemenuPanel startPanel, VokabController vController) {
		this.homemenuPanel = startPanel;
		this.vController = vController;
		initializeFrame();
	}

	/**
	 * Initialisiert den Frame
	 */
	private void initializeFrame() {
		setTitle("Vokabeltrainer");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cardLayout = new CardLayout();
		mainPanel = new JPanel(cardLayout);

		// Initialize panels
		uploadPanel = new UploadPanel(new UploadVokabelFile(new VokabelLoader()), vController);
		settingsPanel = new SettingsPanel(vController);
		loginPanel = new LoginPanel(vController);
		favPanel = new FavPanel(vController);
		resultPanel = new ResultPanel(vController.getVTrainerModel().getResultObj(), vController);
		vokabTrainerPanel = new VokabTrainerPanel(vController);
		statistikPanel = new StatistikPanel(new VokabelStatistik());

		// Add panels to mainPanel
		addPanelToMainPanel("HomemenuPanel", homemenuPanel);
		addPanelToMainPanel("UploadPanel", uploadPanel);
		addPanelToMainPanel("SettingsPanel", settingsPanel);
		addPanelToMainPanel("LoginPanel", loginPanel);
		addPanelToMainPanel("FavPanel", favPanel);
		addPanelToMainPanel("ResultPanel", resultPanel);
		addPanelToMainPanel("VokabTrainerPanel", vokabTrainerPanel);
		addPanelToMainPanel("StatistikPanel", statistikPanel);

		add(mainPanel);
		switchToPanel("HomemenuPanel");
	}

	/**
	 * Fügt ein Panel zum Hauptpanel hinzu
	 * @param name Name des Panels
	 * @param panel Panel
	 */
	public void addPanelToMainPanel(String name, JPanel panel) {
		if (panel != null) {
			mainPanel.add(panel, name);
		}
	}

	/**
	 * Wechselt zum Panel
	 * @param name Name des Panels
	 */
	public void switchToPanel(String name) {
		cardLayout.show(mainPanel, name);
		mainPanel.revalidate();
		mainPanel.repaint();
		resultPanel.reinitializeUI();
	}

	/**
	 * Gibt den Controller zurück
	 * @param args Kommandozeilenargumente
	 */
	public static void main(String[] args) {
		VokabController vController = new VokabController();
		HomemenuPanel startPanel = new HomemenuPanel(vController);
		VokabFrame frame = new VokabFrame(startPanel, vController);
		frame.setVisible(true);
	}

	/**
	 * Setzt den Vokabeltrainer zurück
	 */
	public void resetVokabTrainer() {
		vokabTrainerPanel.reset();
	}

	/**
	 * Gibt den Vokabeltrainer zurück
	 */
	public void renewFavpanel() {
		favPanel.renewFavpanel();
	}
}