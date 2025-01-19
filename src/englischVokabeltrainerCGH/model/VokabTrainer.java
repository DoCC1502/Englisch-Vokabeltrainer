package englischVokabeltrainerCGH.model;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Diese Klasse repräsentiert den Vokabeltrainer.
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 1.0
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
		Set<VokabelPaar> usedVokabelPaare = new HashSet<>();
		usedVokabelPaare.add(vp);

		VokabelPaar[] randomVokabelPaare = new VokabelPaar[3];
		for (int i = 0; i < 3; i++) {
			VokabelPaar randomVokabel;
			do {
				randomVokabel = vokabelListe.getRandomVokabel();
			} while (usedVokabelPaare.contains(randomVokabel));
			randomVokabelPaare[i] = randomVokabel;
			usedVokabelPaare.add(randomVokabel);
		}

		Random r = new Random();
		boolean random = r.nextBoolean();
		question[0] = random ? vp.getWortDe() : vp.getWortEn();
		if (random) {
			question[1] = vp.getWortEn();
			question[2] = randomVokabelPaare[0].getWortEn();
			question[3] = randomVokabelPaare[1].getWortEn();
			question[4] = randomVokabelPaare[2].getWortEn();
			isGerman = false;
		} else {
			question[1] = vp.getWortDe();
			question[2] = randomVokabelPaare[0].getWortDe();
			question[3] = randomVokabelPaare[1].getWortDe();
			question[4] = randomVokabelPaare[2].getWortDe();
			isGerman = true;
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
	 * Returned, ob die antworten auf Deutsch oder Englisch sind
	 * @return
	 */
	public boolean getIsGerman() {
		return isGerman;
	}

	/**
	 * Überprüft, ob die Antwort richtig ist.
	 * @param answer
	 * @param correctTranslation
	 * @param isGerman
	 * @return
	 */
	public boolean isCorrect(String answer, String correctTranslation, boolean isGerman) {
		if(isGerman) {
            return vokabelListe.searchVokabelPaar(answer, correctTranslation) != -1;
		} else {
            return vokabelListe.searchVokabelPaar(correctTranslation, answer) != -1;
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
