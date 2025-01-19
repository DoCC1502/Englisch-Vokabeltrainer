package englischVokabeltrainerCGH.model;

import englischVokabeltrainerCGH.VokabController;

import java.io.File;
import java.io.Serializable;


/**
 * Diese Klasse dient dazu, eine Datei mit Vokabeln zu laden und die Vokabeln
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 1.0
 */
public class UploadVokabelFile implements Serializable{


	private VokabelLoader vokabelLoader;

	/**
	 * Konstruktor
	 * @param vokabelLoader VokabelLoader
	 */
	public UploadVokabelFile(VokabelLoader vokabelLoader) {
		this.vokabelLoader = vokabelLoader;
	}

	/**
	 * Lädt eine Datei mit Vokabeln
	 * @param file Datei
	 * @param fileType Dateityp
	 * @param vController VokabController
	 */
	public void loadVokabelFile(File file, String fileType, VokabController vController) {
		switch (fileType.toLowerCase()) {
			case "json":
				vokabelLoader.setUser(vController.getUserAccount());
				vokabelLoader.loadFromJSON(file);
				vokabelLoader.loadVokabeln();
				break;
			case "txt":
				vokabelLoader.setUser(vController.getUserAccount());
				vokabelLoader.loadFromTXT(file);
				vokabelLoader.loadVokabeln();
				break;
			case "csv":
				vokabelLoader.setUser(vController.getUserAccount());
				vokabelLoader.loadFromCSV(file);
				vokabelLoader.loadVokabeln();
				break;
			default:
				throw new IllegalArgumentException("Unsupported file type: " + fileType);
		}
	}
}