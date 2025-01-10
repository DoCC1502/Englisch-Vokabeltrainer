package englischVokabeltrainerCGH.model;

/**
 * Eine Liste von Vokabeln, die als Favoriten markiert wurden.
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 0.1
 */
public class FavouriteList {
	private VokabelPaar[] favouriteWordList;
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
		VokabelPaar[] temp = new VokabelPaar[favouriteWordList.length + 1];
		for (int i = 0; i < favouriteWordList.length; i++) {
			temp[i] = favouriteWordList[i];
		}
		temp[favouriteWordList.length] = v;
		favouriteWordList = temp;
	}

}
