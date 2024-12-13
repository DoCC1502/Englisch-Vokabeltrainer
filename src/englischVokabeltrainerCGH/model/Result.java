package englischVokabeltrainerCGH.model;
/**
 * Diese Klasse repräsentiert das Ergebnis eines Quiz.
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 0.1
 */
public class Result {

	private int falseAnswers;

	private int rightAnswers;

	/**
	 * Gibt das Ergebnis zurück.
	 * @return true, wenn die Antwort richtig war, sonst false
	 */
	public boolean getResult() {
		return false;
	}

	/**
	 * Inkrementiert das Ergebnis.
	 * @param b true, wenn die Antwort richtig war, sonst false
	 */
	public void incrementResult(boolean b) {

	}

	/**
	 * Gibt das Ergebnisquote zurück.
	 * @return Ergebnisquote
	 */
	public double getResultQuote() {
		return 0;
	}

	/**
	 * Gibt die Anzahl der richtigen Antworten zurück.
	 * @return Anzahl der richtigen Antworten
	 */
	public int getRightAnswers() {
		return 0;
	}

	/**
	 * Gibt die Anzahl der falschen Antworten zurück.
	 * @return Anzahl der falschen Antworten
	 */
	public int getFalseAnswers() {
		return 0;
	}

}
