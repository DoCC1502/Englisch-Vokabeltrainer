package englischVokabeltrainerCGH.model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import englischVokabeltrainerCGH.VokabController;
/**
 * Die Klasse stellt eine Liste von VokabelPaaren dar.
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 1.0
 */
public class VokabelListe implements Serializable {

	private VokabelPaar[] vokabelPaare;

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
	 * Fügt ein VokabelPaar hinzu.
	 * @param vp VokabelPaar
	 */
	public void addVokabelPaar(VokabelPaar vp) {
		if(vokabelPaare == null) {
			vokabelPaare = new VokabelPaar[1];
			vokabelPaare[0] = vp;
		} else {
			VokabelPaar[] temp = new VokabelPaar[vokabelPaare.length + 1];
			for(int i = 0; i < vokabelPaare.length; i++) {
				temp[i] = vokabelPaare[i];
			}
			temp[vokabelPaare.length] = vp;
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
	 * Entfernt Duplikate aus der Liste.
	 */
	public void removeDuplicates() {
		if (vokabelPaare == null || vokabelPaare.length == 0) {
			return;
		}

		Set<VokabelPaar> uniqueVokabelPaare = new HashSet<>();
		for (VokabelPaar vp : vokabelPaare) {
			uniqueVokabelPaare.add(vp);
		}

		vokabelPaare = uniqueVokabelPaare.toArray(new VokabelPaar[0]);
	}

	/**
	 * Gibt die Länge der Liste zurück.
	 * @return
	 */
	public int getLength() {
		return vokabelPaare.length;
	}
}
