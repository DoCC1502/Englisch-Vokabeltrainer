package englischVokabeltrainerCGH.view;

import englischVokabeltrainerCGH.VokabController;
import englischVokabeltrainerCGH.model.Result;
import java.awt.*;
import javax.swing.*;

/**
 * Panel für das Ergebnis
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 0.1
 */
public class ResultPanel extends JPanel {

	private VokabController vController;
	private Result result;

	/**
	 * Konstruktor
	 */
	public ResultPanel(Result result) {
		this.result = result;
		initializeUI();
	}

	private JButton createIconButton(String iconPath) {
		ImageIcon icon = new ImageIcon(iconPath);
		Image scaledImage = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		JButton button = new JButton(new ImageIcon(scaledImage));
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		return button;
	}

	private void initializeUI() {
		// Standardlayout auf 1x1 GridLayout setzen
		setLayout(new GridLayout(1, 1));

		// Panel 1 (Ergebnisanzeige) mit GridLayout
		JPanel resultPanel = new JPanel(new GridLayout(3, 1, 0, 20));

		// Punktestand Label
		JLabel scoreLabel = new JLabel(result.getRightAnswers() + "/" + (result.getRightAnswers() + result.getFalseAnswers()), SwingConstants.CENTER);
		scoreLabel.setFont(new Font("Arial", Font.BOLD, 48));
		scoreLabel.setForeground(Color.GREEN);
		resultPanel.add(scoreLabel);

		// Platzhalter-Panel
		JPanel spacerPanel = new JPanel();
		spacerPanel.setOpaque(false);
		resultPanel.add(spacerPanel);

		// Button-Panel mit GridLayout
		JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 20, 0));
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

		JPanel rightIconsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		rightIconsPanel.setBackground(Color.WHITE);

		JButton iconButton1 = createIconButton("resource/Upload.png");
		JButton iconButton2 = createIconButton("resource/Favoriten.png");
		JButton iconButton3 = createIconButton("resource/settings.png");

		rightIconsPanel.add(iconButton1);
		rightIconsPanel.add(iconButton2);
		rightIconsPanel.add(iconButton3);

		// Login Icon hinzufügen
		JButton loginButton = createIconButton("resource/login.png");
		JPanel leftIconsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
		leftIconsPanel.setBackground(Color.WHITE);
		leftIconsPanel.add(loginButton);

		iconPanel.add(leftIconsPanel, BorderLayout.WEST);
		iconPanel.add(rightIconsPanel, BorderLayout.EAST);

		// CardLayout-ähnlicher Wechsel durch Container
		JPanel container = new JPanel(new CardLayout());
		container.add(resultPanel, "ResultPanel");
		container.add(newPanel, "NewPanel");

		// Button-Ereignisse für Panel-Wechsel
		CardLayout cl = (CardLayout) container.getLayout();
		tryAgainButton.addActionListener(e -> cl.show(container, "NewPanel"));
		finishButton.addActionListener(e -> cl.show(container, "NewPanel"));

		// Container in das Hauptlayout einfügen
		setLayout(new BorderLayout());
		add(iconPanel, BorderLayout.NORTH);
		add(container, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		// Beispiel-Result
		Result exampleResult = new Result();

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new ResultPanel(exampleResult));
		frame.setSize(400, 300);
		frame.setVisible(true);
	}
}
