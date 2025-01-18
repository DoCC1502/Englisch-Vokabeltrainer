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
 * @version 0.1
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

		// Icons hinzufügen
		JPanel rightIconsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		rightIconsPanel.setBackground(Color.WHITE);

		JButton iconButton1 = createIconButton("resource/Upload.png");
		JButton iconButton2 = createIconButton("resource/Favoriten.png");
		JButton iconButton3 = createIconButton("resource/settings.png");

		rightIconsPanel.add(iconButton1);
		rightIconsPanel.add(iconButton2);
		rightIconsPanel.add(iconButton3);

		// Login Icon hinzufügen
		JButton loginButton = createIconButton("resource/login.png");
		JPanel leftIconsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		leftIconsPanel.setBackground(Color.WHITE);
		leftIconsPanel.add(loginButton);

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
		levelComboBox = new JComboBox<>(new String[]{"A1", "A2", "B1", "B2", "C1", "C2"});
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

	private JButton createIconButton(String iconPath) {
		ImageIcon icon = new ImageIcon(iconPath);
		Image scaledImage = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		JButton button = new JButton(new ImageIcon(scaledImage));
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		return button;
	}

	/**
	 * Handhabt den Sign-In-Prozess
	 */
	private void handleSignIn() {
		String username = usernameField.getText();
		String level = (String) levelComboBox.getSelectedItem();

		// Übergibt die Daten an den Controller
		if (vController != null) {
			vController.handleLogin(username, level);
		} else {
			JOptionPane.showMessageDialog(this, "Controller ist nicht verfügbar!", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String[] args) {
		// Erstelle das JFrame
		JFrame frame = new JFrame("Englisch Vokabeltrainer - Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 350);
		frame.setLocationRelativeTo(null); // Zentriert das Fenster

		// Simulierter Controller (falls du ihn noch nicht implementiert hast)
		VokabController dummyController = new VokabController() {
			@Override
			public void handleLogin(String username, String level) {
				// Einfach eine Nachricht ausgeben
				System.out.println("Login-Daten:");
				System.out.println("Username: " + username);
				System.out.println("Level: " + level);
				JOptionPane.showMessageDialog(null,
						"Username: " + username + "\nLevel: " + level,
						"Login erfolgreich",
						JOptionPane.INFORMATION_MESSAGE);
			}
		};

		// Füge das LoginPanel hinzu
		LoginPanel loginPanel = new LoginPanel(dummyController);
		frame.add(loginPanel);

		// Zeige das Fenster
		frame.setVisible(true);
	}
}