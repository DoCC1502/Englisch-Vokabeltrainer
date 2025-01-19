package englischVokabeltrainerCGH.model;

import englischVokabeltrainerCGH.VokabController;

import java.io.File;
import java.io.Serializable;

public class UploadVokabelFile implements Serializable {

	private VokabelLoader vokabelLoader;

	public UploadVokabelFile(VokabelLoader vokabelLoader) {
		this.vokabelLoader = vokabelLoader;
	}

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