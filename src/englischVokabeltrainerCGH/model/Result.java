package englischVokabeltrainerCGH.model;

import java.io.Serializable;

/**
 * Diese Klasse repräsentiert das Ergebnis eines Quiz.
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 1.0
 */
public class Result implements Serializable {

	private int falseAnswers;

	private int rightAnswers;

	/**
	 * Konstruktor der Klasse Result.
	 */
	public Result() {
		this.falseAnswers = 0;
		this.rightAnswers = 0;
	}

	/**
	 * Gibt das Ergebnis zurück.
	 * @return true, wenn der Test bestanden wurde, sonst false
	 */
	public boolean getResult() {
		if(rightAnswers > falseAnswers) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Inkrementiert das Ergebnis.
	 * @param b true, wenn die Antwort richtig war, sonst false
	 */
	public void incrementResult(boolean b) {
		if(b) {
			rightAnswers++;
		}
		else {
			falseAnswers++;
		}
	}

	/**
	 * Gibt das Ergebnisquote zurück.
	 * @return Ergebnisquote
	 */
	public double getResultQuote() {
		return 100.0 * rightAnswers / (rightAnswers + falseAnswers);
	}

	/**
	 * Gibt die Anzahl der richtigen Antworten zurück.
	 * @return Anzahl der richtigen Antworten
	 */
	public int getRightAnswers() {return rightAnswers;}

	/**
	 * Gibt die Anzahl der falschen Antworten zurück.
	 * @return Anzahl der falschen Antworten
	 */
	public int getFalseAnswers() {
		return falseAnswers;
	}

	/**
	 * Setzt das Ergebnis zurück.
	 */
	public void resetResult() {
		this.falseAnswers = 0;
		this.rightAnswers = 0;
	}
}
