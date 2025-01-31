package englischVokabeltrainerCGH.view;

import englischVokabeltrainerCGH.VokabController;

import javax.swing.*;

import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Panel für den Login
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 1.0
 */
public class LoginPanel extends JPanel {

	private VokabController vController;

	// Komponenten
	private JTextField usernameField;
	private JComboBox<String> levelComboBox;
	private JButton signInButton;

	/**
	 * Konstruktor
	 *
	 * @param vController Controller
	 */
	public LoginPanel(VokabController vController) {
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

		// Hinzufügen des Icon-Panels in das framePanel
		framePanel.add(iconPanel, BorderLayout.NORTH);

		// Box für das Login-Panel (abgerundete Kanten)
		JPanel loginBox = new JPanel();
		loginBox.setLayout(new GridLayout(3, 1, 10, 10)); // 3 Zeilen, Abstand 10px
		loginBox.setBorder(new CompoundBorder(
				new EmptyBorder(20, 20, 20, 20), // Innenabstand
				new LineBorder(Color.LIGHT_GRAY, 2, true) // Abgerundeter Rand
		));
		loginBox.setBackground(Color.WHITE);

		// Username
		JPanel usernamePanel = new JPanel(new BorderLayout());
		usernamePanel.setBackground(Color.WHITE);
		JLabel usernameLabel = new JLabel("Username:");
		usernameField = new JTextField(15);
		usernamePanel.add(usernameLabel, BorderLayout.NORTH);
		usernamePanel.add(usernameField, BorderLayout.CENTER);

		// Level
		JPanel levelPanel = new JPanel(new BorderLayout());
		levelPanel.setBackground(Color.WHITE);
		JLabel levelLabel = new JLabel("Level:");
		levelComboBox = new JComboBox<>(new String[]{"1 (Leicht)", "2 (Mittel)", "3 (Schwer)"});
		levelPanel.add(levelLabel, BorderLayout.NORTH);
		levelPanel.add(levelComboBox, BorderLayout.CENTER);

		// Sign-In Button
		signInButton = new JButton("Sign In");
		signInButton.setBackground(Color.WHITE);
		signInButton.setForeground(Color.BLACK);
		signInButton.setFocusPainted(false);
		signInButton.setFont(new Font("Arial", Font.BOLD, 14));

		// Hinzufügen der Komponenten in die Box
		loginBox.add(usernamePanel);
		loginBox.add(levelPanel);
		loginBox.add(signInButton);

		// Hinzufügen der Box in das framePanel
		framePanel.add(loginBox, BorderLayout.CENTER);

		// Hinzufügen des framePanel in das Haupt-Layout
		add(framePanel);

		// ActionListener für den Button
		signInButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleSignIn();
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
	 * Handhabt den Sign-In-Prozess
	 */
	private void handleSignIn() {
		String username = usernameField.getText();
		String level = (String) levelComboBox.getSelectedItem();
		String parts = level.split(" ")[0]; // Entfernt die Klammern
		level = parts;
		int levelInt = Integer.parseInt(level); // Konvertiert den String in einen Integer
		// Übergibt die Daten an den Controller
		if (vController != null) {
			vController.handleLogin(username, levelInt);
		} else {
			JOptionPane.showMessageDialog(this, "Controller ist nicht verfügbar!", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
	}


}