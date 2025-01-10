package englischVokabeltrainerCGH.model;

import englischVokabeltrainerCGH.model.*;
import java.io.*;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.*;


public class UploadVokabelFile {

	private VokabelLoader vokabelLoader;


	public UploadVokabelFile(VokabelLoader vokabelLoader) {
		this.vokabelLoader = vokabelLoader;
	}

	public void loadVokabelJSON(String filePath) {
		try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
			StringBuilder contentBuilder = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				contentBuilder.append(line);
			}
			String content = contentBuilder.toString();
			JSONArray jsonArray = new JSONArray(content);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				String wortDe = jsonObject.getString("wortDe");
				String wortEn = jsonObject.getString("wortEn");
				vokabelLoader.addToLoadList(new VokabelPaar(wortDe, wortEn));
			}
		} catch (IOException | JSONException e) {
			System.err.println("Fehler beim Laden der JSON Datei: " + e.getMessage());
		}
	}

	public void loadVokabelTXT(String filePath) {
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 2) {
					String wortDe = parts[0].trim();
					String wortEn = parts[1].trim();
					vokabelLoader.addToLoadList(new VokabelPaar(wortDe, wortEn));
				}
			}
		} catch (IOException e) {
			System.err.println("Fehler beim Laden der .txt Datei: " + e.getMessage());
		}
	}

	public void loadVokabelCSV(String filePath) {
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 2) {
					String wortDe = parts[0].trim();
					String wortEn = parts[1].trim();
					vokabelLoader.addToLoadList(new VokabelPaar(wortDe, wortEn));
				}
			}
		} catch (IOException e) {
			System.err.println("Fehler beim Laden der .csv Datei: " + e.getMessage());
		}
	}
}
