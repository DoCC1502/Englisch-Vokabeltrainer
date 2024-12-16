package englischVokabeltrainerCGH.model;

/**
 * Die Klasse stellt eine Liste von VokabelPaaren dar.
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 0.1
 */
public class VokabelListe {

	private VokabelPaar[] vokabelPaare;

	private VokabelStatistik vokabelStatistik;

	private VokabelPaar vokabelPaar;

	/**
	 * Erstellt eine neue VokabelListe.
	 * @param vokabelPaare VokabelPaare
	 */
	public VokabelListe(VokabelPaar[] vokabelPaare) {

	}

	/**
	 * Erstellt eine neue VokabelListe.
	 * @param wortDe Wort in Deutsch
	 * @param wortEn Wort in Englisch
	 */
	public void addVokabelPaar(String wortDe, String wortEn) {

	}

	/**
	 * Löscht ein VokabelPaar.
	 * @param wortDe Wort in Deutsch
	 * @param wortEn Wort in Englisch
	 * @return true, wenn das VokabelPaar gelöscht wurde, sonst false
	 */
	public int searchVokabelPaar(String wortDe, String wortEn) {
		return 0;
	}

	/**
	 * Gibt ein VokabelPaar zurück.
	 * @param index Index
	 * @return VokabelPaar
	 */
	public VokabelPaar getVokabelPaar(int index) {
		return null;
	}

	/**
	 * Gibt ein zufälliges VokabelPaar zurück.
	 * @return VokabelPaar
	 */
	public VokabelPaar getRandomVokabel() {
		return null;
	}

	/**
	 * löscht die Liste
	 */
	protected void deleteList() {
		for (int i = 0; i < vokabelPaare.length; i++) {
			vokabelPaare[i] = null;
		}
	}
}
