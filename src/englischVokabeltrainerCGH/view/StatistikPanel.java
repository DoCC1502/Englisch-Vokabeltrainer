package englischVokabeltrainerCGH.view;

import englischVokabeltrainerCGH.model.VokabelPaar;
import englischVokabeltrainerCGH.model.VokabelPaarStatistik;
import englischVokabeltrainerCGH.model.VokabelStatistik;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Panel für die Statistik
 *
 * @autor Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 0.1
 */
public class StatistikPanel extends JPanel {

	private VokabelStatistik statistik;
	private VokabelPaar vokabelPaar;

	/**
	 * Konstruktor
	 * @param statistik Vokabelstatistik
	 */
	public StatistikPanel(VokabelStatistik statistik) {
		this.statistik = statistik;
	}

	public void runStatistikPanel() {
		initializePanel();
	}

	public void insertVokabelPaar(VokabelPaar vokabelPaar) {
		this.vokabelPaar = vokabelPaar;
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

	/**
	 * Initialisiert das Panel.
	 */
	private void initializePanel() {
		setLayout(new GridLayout(2, 1));
		// Icons hinzufügen
		JPanel iconPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		iconPanel.setBackground(Color.WHITE);

		// Icons hinzufügen
		JButton iconButton0 = createIconButton("resource/Home.png");
		JButton iconButton1 = createIconButton("resource/Upload.png");
		JButton iconButton2 = createIconButton("resource/Favoriten.png");
		JButton iconButton3 = createIconButton("resource/settings.png");

		iconPanel.add(iconButton0);
		iconPanel.add(iconButton1);
		iconPanel.add(iconButton2);
		iconPanel.add(iconButton3);

		add(iconPanel);
		// Statistik-Anzeige
		JPanel statistikPanel = new JPanel(new GridLayout(0, 1, 5, 5));
		statistikPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JLabel titleLabel = new JLabel("Statistik", SwingConstants.CENTER);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
		statistikPanel.add(titleLabel);



		// Gesamtstatistik
		JLabel totalCorrectLabel = new JLabel("Gesamt richtige Antworten von " + vokabelPaar.getWortEn()+ ": " + statistik.getGesamtRichtig());
		JLabel totalIncorrectLabel = new JLabel("Gesamt falsche Antworten von " + vokabelPaar.getWortDe() + ": " + statistik.getGesamtFalsch());
		statistikPanel.add(totalCorrectLabel);
		statistikPanel.add(totalIncorrectLabel);

		add(statistikPanel);


	}

	public static void main(String[] args) {
		// Beispiel-Daten für die Statistik
		VokabelStatistik statistik = new VokabelStatistik();
		VokabelPaar vokabelPaar1 = new VokabelPaar("Hund", "Dog");
		StatistikPanel sp = new StatistikPanel(statistik);
		sp.insertVokabelPaar(vokabelPaar1);
		sp.runStatistikPanel();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(sp);

		frame.setSize(400, 400);
		frame.setVisible(true);
	}
}