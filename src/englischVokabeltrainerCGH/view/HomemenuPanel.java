package englischVokabeltrainerCGH.view;


import englischVokabeltrainerCGH.VokabController;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


/**
 * Panel für das Hauptmenü
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 1.0
 */
public class HomemenuPanel extends JPanel {

	// Komponenten
	private JLabel welcomeLabel;
	private JButton startButton;

	private VokabController vController;

	/**
	 * Konstruktor
	 */

	public HomemenuPanel(VokabController vController) {
		this.vController = vController;
		initializeComponents();
	}

	/**
	 * Initialisiert die Komponenten des Panels
	 */
	private void initializeComponents() {
		// Haupt-Layout (GridLayout für die Strukturierung)
		setLayout(new GridLayout(1, 1));
		setBackground(Color.WHITE); // Hintergrundfarbe

		JPanel framePanel = new JPanel(new BorderLayout());

		// Panel für die Icons
		JPanel iconPanel = new JPanel(new BorderLayout());
		iconPanel.setBackground(Color.WHITE);

		// Icons hinzufügen
		JPanel rightIconsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		rightIconsPanel.setBackground(Color.WHITE);

		JButton iconButton0 = createIconButton("resource/Home.png", "HomemenuPanel");
		JButton iconButton1 = createIconButton("resource/Upload.png", "UploadPanel");
		JButton iconButton2 = createIconButton("resource/Favoriten.png", "FavPanel");
		JButton iconButton3 = createIconButton("resource/settings.png", "SettingsPanel");

		rightIconsPanel.add(iconButton0);
		rightIconsPanel.add(iconButton1);
		rightIconsPanel.add(iconButton2);
		rightIconsPanel.add(iconButton3);

		// Login Icon hinzufügen
		JButton loginButton = createIconButton("resource/login.png", "LoginPanel");
		JPanel leftIconsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		leftIconsPanel.setBackground(Color.WHITE);
		leftIconsPanel.add(loginButton);

		iconPanel.add(leftIconsPanel, BorderLayout.WEST);
		iconPanel.add(rightIconsPanel, BorderLayout.EAST);

		// Hinzufügen des Icon-Panels in das framePanel
		framePanel.add(iconPanel, BorderLayout.NORTH);

		// Box für das Begrüßungs-Panel
		JPanel menuBox = new JPanel();
		menuBox.setLayout(new GridLayout(3, 1, 10, 10)); // 3 Zeilen, Abstand 10px
		menuBox.setBorder(new CompoundBorder(
				new EmptyBorder(20, 20, 20, 20), // Innenabstand
				new LineBorder(Color.LIGHT_GRAY, 2, true) // Abgerundeter Rand
		));
		menuBox.setBackground(Color.WHITE);

		// Begrüßungstext
		welcomeLabel = new JLabel("Welcome!", SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
		menuBox.add(welcomeLabel);

		// Platz für Bild oder Grafik (optional)
		JLabel imageLabel = new JLabel();
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageLabel.setIcon(new ImageIcon("resource/LOGO.png")); // Beispielbild ersetzen
		menuBox.add(imageLabel);

		// Start-Button
		startButton = new JButton("Start");
		startButton.setBackground(Color.WHITE);
		startButton.setForeground(Color.BLACK);
		startButton.setFocusPainted(false);
		startButton.setFont(new Font("Arial", Font.BOLD, 14));
		menuBox.add(startButton);

		// Hinzufügen der Box in das framePanel
		framePanel.add(menuBox, BorderLayout.CENTER);

		// Hinzufügen des framePanel in das Haupt-Layout
		add(framePanel);

		// ActionListener für den Button
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleStartButtonClick();
			}
		});
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
				vController.getVFrame().switchToPanel(panelName);
			}
		});
		return button;

	}

	/**
	 * Handhabt das Klicken auf den Start-Button
	 */
	private void handleStartButtonClick() {
		vController.getVFrame().switchToPanel("VokabTrainerPanel");
	}

	/**
	 * Erneuert das Panel
	 * @param args Kommandozeilenargumente
	 */
	public static void main(String[] args) {
		VokabController vc = new VokabController();
		VokabFrame vFrame = new VokabFrame(new HomemenuPanel(vc), vc);
		vFrame.setVisible(true);


	}
}