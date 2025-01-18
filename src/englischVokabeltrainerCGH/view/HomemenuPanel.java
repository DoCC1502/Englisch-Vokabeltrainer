package englischVokabeltrainerCGH.view;

import englischVokabeltrainerCGH.VokabController;

import javax.swing.*;
import java.awt.*;

/**
 * Panel für das Hauptmenü
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 0.1
 */
public class HomemenuPanel extends JPanel {

	private VokabController vController;

	/**
	 * Konstruktor
	 * @param vController Controller
	 */
	public HomemenuPanel(VokabController vController) {
		setLayout(new GridLayout(1, 1));
		JLabel label = new JLabel("geschafft");
		add(label, BorderLayout.CENTER);
	}

}
