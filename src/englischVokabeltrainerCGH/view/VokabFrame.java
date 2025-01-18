package englischVokabeltrainerCGH.view;

import englischVokabeltrainerCGH.VokabController;
import englischVokabeltrainerCGH.model.*;

import javax.swing.*;
import java.awt.*;

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

	public VokabFrame(HomemenuPanel startPanel) {
		this.homemenuPanel = startPanel;
		initializeFrame();
	}

	private void initializeFrame() {
		setTitle("Vokabeltrainer");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cardLayout = new CardLayout();
		mainPanel = new JPanel(cardLayout);

		// Initialize panels
		uploadPanel = new UploadPanel(new VokabController(), new UploadVokabelFile(new VokabelLoader()));
		settingsPanel = new SettingsPanel(new VokabController());
		loginPanel = new LoginPanel(new VokabController());
		favPanel = new FavPanel(new VokabController());
		resultPanel = new ResultPanel(new Result());
		vokabTrainerPanel = new VokabTrainerPanel(new VokabController());
		statistikPanel = new StatistikPanel(new VokabelStatistik(), new VokabelPaar("Hund", "Dog"));

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
	}

	public static void main(String[] args) {
		HomemenuPanel startPanel = new HomemenuPanel(new VokabController());
		VokabFrame frame = new VokabFrame(startPanel);
		frame.setVisible(true);
	}
}