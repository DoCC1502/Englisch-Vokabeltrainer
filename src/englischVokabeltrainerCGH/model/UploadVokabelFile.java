package englischVokabeltrainerCGH.model;

import java.io.File;

public class UploadVokabelFile {

	private VokabelLoader vokabelLoader;

	public UploadVokabelFile(VokabelLoader vokabelLoader) {
		this.vokabelLoader = vokabelLoader;
	}

	public void loadVokabelFile(File file, String fileType) {
		switch (fileType.toLowerCase()) {
			case "json":
				vokabelLoader.loadFromJSON(file);
				break;
			case "txt":
				vokabelLoader.loadFromTXT(file);
				break;
			case "csv":
				vokabelLoader.loadFromCSV(file);
				break;
			default:
				throw new IllegalArgumentException("Unsupported file type: " + fileType);
		}
	}
}