package englischVokabeltrainerCGH.view;

import englischVokabeltrainerCGH.VokabController;
import englischVokabeltrainerCGH.model.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Panel für das Ergebnis
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 1.0
 */
public class ResultPanel extends JPanel {

	private VokabController vController;
	private Result result;

	/**
	 * Konstruktor
	 */
	public ResultPanel(Result result, VokabController vController) {
		this.vController = vController;
		this.result = result;
		initializeUI();
	}
	/**
	 * Erstellt einen Icon-Button
	 * @param iconPath Pfad zum Icon
	 * @param panelName Name des Panels
	 * @return JButton
	 */
	private JButton createIconButton(String iconPath, String panelName) {
		ImageIcon icon = new ImageIcon(iconPath);
		Image scaledImage = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		JButton button = new JButton(new ImageIcon(scaledImage));
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vController.getVFrame().resetVokabTrainer();
				result.resetResult();
				vController.getVFrame().switchToPanel(panelName);
			}
		});
		return button;

	}

	/**
	 * Initialisiert das UI
	 */
	private void initializeUI() {
		// Standardlayout auf 1x1 GridLayout setzen
		setLayout(new GridLayout(1, 1));
		setBackground(Color.WHITE);

		// Panel 1 (Ergebnisanzeige) mit GridLayout
		JPanel resultPanel = new JPanel(new GridLayout(3, 1, 0, 20));
		resultPanel.setBackground(Color.WHITE);

		// Punktestand Label
		JLabel scoreLabel = new JLabel(result.getRightAnswers() + "/10", SwingConstants.CENTER);
		scoreLabel.setFont(new Font("Arial", Font.BOLD, 48));
		scoreLabel.setForeground(Color.GREEN);
		resultPanel.add(scoreLabel);

		// Platzhalter-Panel
		JPanel spacerPanel = new JPanel();
		spacerPanel.setOpaque(false);
		resultPanel.add(spacerPanel);

		// Button-Panel mit GridLayout
		JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 20, 0));
		buttonPanel.setBackground(Color.WHITE);
		JButton tryAgainButton = new JButton("Try again");
		JButton finishButton = new JButton("Finish");

		// Buttons zum Button-Panel hinzufügen
		buttonPanel.add(tryAgainButton);
		buttonPanel.add(finishButton);

		// Button-Panel zum Ergebnis-Panel hinzufügen
		resultPanel.add(buttonPanel);

		// Panel 2 (neues Panel nach Button-Klick)
		JPanel newPanel = new JPanel(new GridLayout(1, 1));
		newPanel.setBackground(Color.LIGHT_GRAY);
		JLabel newPanelLabel = new JLabel("Neues Panel!", SwingConstants.CENTER);
		newPanelLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		newPanel.add(newPanelLabel);

		// Icons hinzufügen
		JPanel iconPanel = new JPanel(new BorderLayout());
		iconPanel.setBackground(Color.WHITE);

		JPanel rightIconsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		rightIconsPanel.setBackground(Color.WHITE);

		JButton iconButton1 = createIconButton("resource/Upload.png", "UploadPanel");
		JButton iconButton2 = createIconButton("resource/Favoriten.png", "FavPanel");
		JButton iconButton3 = createIconButton("resource/settings.png", "SettingsPanel");

		rightIconsPanel.add(iconButton1);
		rightIconsPanel.add(iconButton2);
		rightIconsPanel.add(iconButton3);

		JButton iconButton0 = createIconButton("resource/Home.png", "HomemenuPanel");
		JButton loginButton = createIconButton("resource/login.png", "LoginPanel");
		JPanel leftIconsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		leftIconsPanel.setBackground(Color.WHITE);
		leftIconsPanel.add(loginButton);
		leftIconsPanel.add(iconButton0);

		iconPanel.add(leftIconsPanel, BorderLayout.WEST);
		iconPanel.add(rightIconsPanel, BorderLayout.EAST);

		// CardLayout-ähnlicher Wechsel durch Container
		JPanel container = new JPanel(new CardLayout());
		container.add(resultPanel, "ResultPanel");
		container.add(newPanel, "NewPanel");

		// Button-Ereignisse für Panel-Wechsel
		CardLayout cl = (CardLayout) container.getLayout();

		tryAgainButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vController.getVFrame().switchToPanel("VokabTrainerPanel");
				vController.getVFrame().resetVokabTrainer();
				result.resetResult();
			}
		});

		finishButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vController.getVFrame().switchToPanel("HomemenuPanel");
				vController.getVFrame().resetVokabTrainer();
				result.resetResult();
			}
		});

		// Container in das Hauptlayout einfügen
		setLayout(new BorderLayout());
		add(iconPanel, BorderLayout.NORTH);
		add(container, BorderLayout.CENTER);
	}

	/**
	 * Setzt das Ergebnis neu
	 */
	public void reinitializeUI() {
		removeAll();
		initializeUI();
	}

	/**
	 * Main-Methode
	 * @param args Argumente
	 */
	public static void main(String[] args) {
		// Beispiel-Result
		Result exampleResult = new Result();

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new ResultPanel(exampleResult, new VokabController()));
		frame.setSize(400, 300);
		frame.setVisible(true);
	}
}
