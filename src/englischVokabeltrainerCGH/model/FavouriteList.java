package englischVokabeltrainerCGH.model;

import java.io.Serializable;

/**
 * Eine Liste von Vokabeln, die als Favoriten markiert wurden.
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 0.1
 */
public class FavouriteList implements Serializable {
	private VokabelPaar[] favouriteWordList;

	public FavouriteList(int i) {
		favouriteWordList = new VokabelPaar[i];
	}


	/**
	 * Erstellt eine neue Favoritenliste.
	 */
	public VokabelPaar[] getFavList() {
		return favouriteWordList;
	}
	/**
	 * Gibt ein Vokabelpaar aus der Favoritenliste zurück.
	 */
	public VokabelPaar getFavWord(int i) {
		return favouriteWordList[i];
	}
	/**
	 * Fügt ein Vokabelpaar zur Favoritenliste hinzu.
	 */
	public void addFavWord(VokabelPaar v) {
		if (favouriteWordList == null) {
			favouriteWordList = new VokabelPaar[1];
			favouriteWordList[0] = v;
			return;
		}
		VokabelPaar[] temp = new VokabelPaar[favouriteWordList.length + 1];
		for (int i = 0; i < favouriteWordList.length; i++) {
			temp[i] = favouriteWordList[i];
		}
		temp[favouriteWordList.length] = v;
		favouriteWordList = temp;
	}

	/**
	 * Entfernt ein Vokabelpaar aus der Favoritenliste.
	 * @param v
	 */
	public void removeFavWord(VokabelPaar v) {
		if (favouriteWordList == null || favouriteWordList.length == 0) {
			return;
		}
		VokabelPaar[] temp = new VokabelPaar[favouriteWordList.length - 1];
		int index = 0;
		for (int i = 0; i < favouriteWordList.length; i++) {
			if (!favouriteWordList[i].equals(v)) {
				if (index < temp.length) {
					temp[index] = favouriteWordList[i];
					index++;
				}
			}
		}
		favouriteWordList = temp;
	}

}
