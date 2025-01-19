package englischVokabeltrainerCGH.view;

import englischVokabeltrainerCGH.VokabController;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Panel für den Vokabeltrainer
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 1.0
 */
public class VokabTrainerPanel extends JPanel {

	private VokabController vController;
	private int questionCounter = 0;
	private JRadioButton jRadioButton1;
	private JRadioButton jRadioButton2;
	private JRadioButton jRadioButton3;
	private JRadioButton jRadioButton4;
	private int[] numbers = {1, 2, 3, 4};
	/**
	 * Konstruktor
	 * @param vController Controller
	 */
	public VokabTrainerPanel(VokabController vController) {
		this.vController = vController;
		initializeComponents();
	}
	/**
	 * Initialisiert die Komponenten
	 */
	private void initializeComponents() {
		setLayout(new GridLayout(6,1));
		setBackground(Color.WHITE);

		vController.getVTrainerModel().nextQuestion();
		String[] questions = vController.getVTrainerModel().getQuestions();

		JLabel questionLabel = new JLabel("Was ist die korrekte Übersetzung für "+questions[0]+"?");
		questionLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		add(questionLabel);


		numbers = shuffleArray(numbers);
		for (int number : numbers) {
			System.out.println(number);
		}
		ButtonGroup G1 = new ButtonGroup();

		jRadioButton1 = new JRadioButton(questions[numbers[0]]);
		jRadioButton1.setBackground(Color.WHITE);
		jRadioButton1.setFont(new Font("Arial", Font.PLAIN, 20));
		jRadioButton2 = new JRadioButton(questions[numbers[1]]);
		jRadioButton2.setBackground(Color.WHITE);
		jRadioButton2.setFont(new Font("Arial", Font.PLAIN, 20));
		jRadioButton3 = new JRadioButton(questions[numbers[2]]);
		jRadioButton3.setBackground(Color.WHITE);
		jRadioButton3.setFont(new Font("Arial", Font.PLAIN, 20));
		jRadioButton4 = new JRadioButton(questions[numbers[3]]);
		jRadioButton4.setBackground(Color.WHITE);
		jRadioButton4.setFont(new Font("Arial", Font.PLAIN, 20));
		G1.add(jRadioButton1);
		G1.add(jRadioButton2);
		G1.add(jRadioButton3);
		G1.add(jRadioButton4);

		JButton nextButton = new JButton("Next");
		nextButton.addActionListener(e -> {
			questionCounter++;
			String selectedAnswer = getSelectedAnswer();
			if (selectedAnswer != null) {
				boolean isCorrect = vController.getVTrainerModel().isCorrect(selectedAnswer, questions[0], vController.getVTrainerModel().getIsGerman());
				vController.updateResult(isCorrect);
			}
			if (questionCounter >= 10) {
				vController.getVFrame().switchToPanel("ResultPanel");
			} else {
				vController.getVTrainerModel().nextQuestion();
				String[] questions1 = vController.getVTrainerModel().getQuestions();
				numbers = shuffleArray(numbers);
				questionLabel.setText("Was ist die korrekte Übersetzung für " + questions1[0] + "?");
				jRadioButton1.setText(questions1[numbers[0]]);
				jRadioButton2.setText(questions1[numbers[1]]);
				jRadioButton3.setText(questions1[numbers[2]]);
				jRadioButton4.setText(questions1[numbers[3]]);
			}
			G1.clearSelection();
		});

		add(jRadioButton1);
		add(jRadioButton2);
		add(jRadioButton3);
		add(jRadioButton4);
		add(nextButton);

	}

	/**
	 * Gibt die ausgewählte Antwort zurück
	 * @return String
	 */
	private String getSelectedAnswer() {
		if (jRadioButton1.isSelected()) return jRadioButton1.getText();
		if (jRadioButton2.isSelected()) return jRadioButton2.getText();
		if (jRadioButton3.isSelected()) return jRadioButton3.getText();
		if (jRadioButton4.isSelected()) return jRadioButton4.getText();
		return null;
	}

	/**
	 * Mischfunktion für ein Array
	 * @param array Array
	 * @return int[]
	 */
	private int[] shuffleArray(int[] array) {
		Random r = new Random();
		for (int i = array.length - 1; i > 0; i--) {
			int j = r.nextInt(i + 1);
			// Swap array[i] with array[j]
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
		return array;
	}

	/**
	 * Setzt den Counter zurück
	 */
	public void reset() {
		questionCounter = 0;
	}

	/**
	 * Gibt den Controller zurück
	 * @param args Kommandozeilenargumente
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		VokabController vc = new VokabController();
		frame.add(new VokabTrainerPanel(vc));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.add(new VokabTrainerPanel(new VokabController()));
		frame.setVisible(true);
	}

}
