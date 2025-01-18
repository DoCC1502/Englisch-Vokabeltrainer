package englischVokabeltrainerCGH.model;

import java.util.Random;

/**
 * Diese Klasse repräsentiert den Vokabeltrainer.
 *
 * @version 0.1
 * @autor Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 */
public class VokabTrainer {
	UserAccount userAccount;
	VokabelListe vokabelListe;
	String[] question = new String[5];
	Result result = new Result();
	boolean isGerman;

	/**
	 * Erstellt einen neuen Vokabeltrainer.
	 * @param userAccount Benutzeraccount
	 */
	public VokabTrainer(UserAccount userAccount) {
		this.userAccount = userAccount;
		vokabelListe = userAccount.getVokabelListe();
	}

	/**
	 * Gibt die nächste Frage zurück.
	 * 0 ist die Frage, 1 ist die richtige Antwort, 2-4 sind falsche Antworten.
	 */
	public void nextQuestion() {
		VokabelPaar vp = vokabelListe.getRandomVokabel();
		VokabelPaar[] randomVokabelPaare = new VokabelPaar[3];
		for (int i = 0; i < 3; i++) {
			randomVokabelPaare[i] = vokabelListe.getRandomVokabel();
			if (randomVokabelPaare[i].equals(vp)) {
				i--;
			}
		}
		Random r = new Random();
		boolean random = r.nextBoolean();
		question[0] = random ? vp.getWortDe() : vp.getWortEn();
		if(random) {
			question[1] = vp.getWortEn();
			question[2] = randomVokabelPaare[0].getWortEn();
			question[3] = randomVokabelPaare[1].getWortEn();
			question[4] = randomVokabelPaare[2].getWortEn();
			isGerman=false;
		} else {
			question[1] = vp.getWortDe();
			question[2] = randomVokabelPaare[0].getWortDe();
			question[3] = randomVokabelPaare[1].getWortDe();
			question[4] = randomVokabelPaare[2].getWortDe();
			isGerman=true;
		}
	}

	/**
	 * Gibt die Fragen zurück.
	 * @return
	 */
	public String[] getQuestions() {
		return question;
	}

	/**
	 * returned ob die antworten auf deutsch oder englisch sind
	 * @return
	 */
	public boolean getIsGerman() {
		return isGerman;
	}

	/**
	 * Überprüft ob die Antwort richtig ist.
	 * @param answer
	 * @param correctAnswer
	 * @param isGerman
	 * @return
	 */
	public boolean isCorrect(String answer, String correctAnswer, boolean isGerman) {
		if(isGerman) {
            return vokabelListe.searchVokabelPaar(answer, correctAnswer) != -1;
		} else {
            return vokabelListe.searchVokabelPaar(correctAnswer, answer) != -1;
		}
	}

	/**
	 * returned das Result Objekt
	 * @return
	 */
	public Result getResultObj() {
		return result;
	}

	/**
	 * gibt die Ergebnisse zurück
	 * @return
	 */
	public double[] showResult() {
		double[] resultArray = new double[3];
		resultArray[0] = result.getRightAnswers();
		resultArray[1] = result.getFalseAnswers();
		resultArray[2] = (int) result.getResultQuote();
		return resultArray;
	}
}
