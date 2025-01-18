package englischVokabeltrainerCGH.model;
import java.util.Random;

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
		this.vokabelPaare = vokabelPaare;
	}

	/**
	 * Erstellt eine neue VokabelListe.
	 * @param wortDe Wort in Deutsch
	 * @param wortEn Wort in Englisch
	 */
	public void addVokabelPaar(String wortDe, String wortEn) {

		VokabelPaar vokabelPaar = new VokabelPaar(wortDe, wortEn);
		if(vokabelPaare == null) {
			vokabelPaare = new VokabelPaar[1];
			vokabelPaare[0] = vokabelPaar;
		} else {
			VokabelPaar[] temp = new VokabelPaar[vokabelPaare.length + 1];
			for(int i = 0; i < vokabelPaare.length; i++) {
				temp[i] = vokabelPaare[i];
			}
			temp[vokabelPaare.length] = vokabelPaar;
			vokabelPaare = temp;
		}

	}

	/**
	 * Löscht ein VokabelPaar.
	 * @param wortDe Wort in Deutsch
	 * @param wortEn Wort in Englisch
	 * @return true, wenn das VokabelPaar gelöscht wurde, sonst false
	 */
	public int searchVokabelPaar(String wortDe, String wortEn) {
		if(vokabelPaare != null || vokabelPaare.length != 0) {
			for(int i = 0; i < vokabelPaare.length; i++) {
				if(vokabelPaare[i].getWortDe().equals(wortDe) && vokabelPaare[i].getWortEn().equals(wortEn)) {
					return i;
				}
			}
		}
		return -1;
  }

	/**
	 * Gibt ein VokabelPaar zurück.
	 * @param index Index
	 * @return VokabelPaar
	 */
	public VokabelPaar getVokabelPaar(int index) {
		return vokabelPaare[index];
	}

	/**
	 * Gibt ein zufälliges VokabelPaar zurück.
	 * @return VokabelPaar
	 */
	public VokabelPaar getRandomVokabel() {
		if(vokabelPaare == null || vokabelPaare.length == 0) {
			return null;
		}
		Random random = new Random();
		int index = random.nextInt(vokabelPaare.length);
		return vokabelPaare[index];
	}

	/**
	 * löscht die Liste
	 */
	protected void deleteList() {
		for (int i = 0; i < vokabelPaare.length; i++) {
			vokabelPaare[i] = null;
		}
	}

	/**
	 * Gibt die Länge der Liste zurück.
	 * @return
	 */
	public int getLength() {
		return vokabelPaare.length;
	}
}
