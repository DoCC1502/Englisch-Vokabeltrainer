package englischVokabeltrainerCGH.model;

import java.util.Arrays;

/**
 * Diese Klasse repräsentiert die Login-Funktionalität des Programms.
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 0.1
 */
public class ProgressTracker {

	private Result[] results;

	/**
	 * Konstruktor der Klasse ProgressTracker.
	 */
	public ProgressTracker() {
		this.results = new Result[0];
	}
	/**
	 * Speichert das Ergebnis.
	 */
	public void saveResult() {
		Result result = new Result();
		results = Arrays.copyOf(results, results.length + 1);
		results[results.length - 1] = result;
	}
	/**
	 * Gibt die Ergebnisse zurück.
	 */
	public void showDifferenceFromLast() {
		if (results.length < 2) {
			System.out.println("Not enough data to show difference.");
			return;
		}

		Result lastResult = results[results.length - 1];
		Result secondLastResult = results[results.length - 2];

		int correctDifference = lastResult.getRightAnswers() - secondLastResult.getRightAnswers();
		int incorrectDifference = lastResult.getFalseAnswers() - secondLastResult.getFalseAnswers();

		System.out.println("Difference from last result:");
		System.out.println("Correct answers: " + correctDifference);
		System.out.println("Incorrect answers: " + incorrectDifference);
	}
}
