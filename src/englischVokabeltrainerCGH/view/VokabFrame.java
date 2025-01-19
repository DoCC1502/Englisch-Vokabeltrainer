package englischVokabeltrainerCGH.view;

import englischVokabeltrainerCGH.VokabController;
import englischVokabeltrainerCGH.model.*;

import javax.swing.*;
import java.awt.*;

/**
 * Hauptframe des Vokabeltrainers
 *
 * @version 0.1
 * @autor Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
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

	public VokabFrame(HomemenuPanel startPanel, VokabController vController) {
		this.homemenuPanel = startPanel;
		this.vController = vController;
		initializeFrame();
	}

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
		resultPanel = new ResultPanel(vController.getVTrainerModel().getResultObj());
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

	public void addPanelToMainPanel(String name, JPanel panel) {
		if (panel != null) {
			mainPanel.add(panel, name);
		}
	}

	public void switchToPanel(String name) {
		cardLayout.show(mainPanel, name);
		mainPanel.revalidate();
		mainPanel.repaint();
		resultPanel.reinitializeUI();
	}

	public static void main(String[] args) {
		VokabController vController = new VokabController();
		HomemenuPanel startPanel = new HomemenuPanel(vController);
		VokabFrame frame = new VokabFrame(startPanel, vController);
		frame.setVisible(true);
	}

	public void renewFavpanel() {
		favPanel.renewFavpanel();
	}
}