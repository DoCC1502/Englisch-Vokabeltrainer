package englischVokabeltrainerCGH.model;
/**
 * Diese Klasse repräsentiert die Schwierigkeitsstufe.
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 0.1
 */
public class SchwierigkeitsLevel {

	private int level;

	/**
	 * Erstellt eine neue Schwierigkeitsstufe.
	 * @param intIN Schwierigkeitsstufe
	 */
	public SchwierigkeitsLevel(int intIN) {
		if (checkSchwierigkeitsLevel(intIN)) {
			level = intIN;
		} else {
			level = 1;
		}
	}

	/**
	 * Überprüft die Schwierigkeitsstufe.
	 * @param intIN Schwierigkeitsstufe
	 * @return true, wenn die Schwierigkeitsstufe korrekt ist, sonst false
	 */
	public boolean checkSchwierigkeitsLevel(int intIN) {
		if (intIN >= 1 && intIN <= 3) {
			return true;
		}
		return false;
	}

	/**
	 * Setzt die Schwierigkeitsstufe.
	 * @param i Schwierigkeitsstufe
	 */
	public void setLevel(int i) {
		if (checkSchwierigkeitsLevel(i)) {
			level = i;
		}
	}

	/**
	 * Gibt die Schwierigkeitsstufe zurück.
	 * @return Schwierigkeitsstufe
	 */
	public int getLevel() {
		return level;
	}
}
