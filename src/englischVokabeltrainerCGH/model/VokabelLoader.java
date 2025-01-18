package englischVokabeltrainerCGH.model;

import java.io.*;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Diese Klasse repräsentiert das Laden von Vokabeln.
 *
 * @author Dario Cikojevic
 * @version 0.1
 */
public class VokabelLoader {

	private VokabelPaar[] vokabelToAdd;

	/**
	 * Konstruktor VokabelLoader.
	 */
	public VokabelLoader() {
		this.vokabelToAdd = new VokabelPaar[0];
	}

	/**
	 * Fügt Vokabeln zur Hauptliste hinzu.
	 * @param vokabeln Vokabeln
	 * @param user UserAccount
	 */
	public void addToMainList(VokabelPaar[] vokabeln, UserAccount user) {
		// Add vocabulary to the main list
		vokabelToAdd = Arrays.copyOf(vokabelToAdd, vokabelToAdd.length + vokabeln.length);
		System.arraycopy(vokabeln, 0, vokabelToAdd, vokabelToAdd.length - vokabeln.length, vokabeln.length);


	}

	/**
	 * Fügt Vokabeln zur Ladeliste hinzu.
	 * @param vokabel Vokabel
	 */
	public void addToLoadList(VokabelPaar vokabel) {
		vokabelToAdd = Arrays.copyOf(vokabelToAdd, vokabelToAdd.length + 1);
		vokabelToAdd[vokabelToAdd.length - 1] = vokabel;
	}

	/**
	 * Lädt Vokabeln aus einer Datei.
	 * @param file Datei
	 */
	public void loadFromTXT(File file) {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 2) {
					VokabelPaar vokabel = new VokabelPaar(parts[0], parts[1]);
					addToLoadList(vokabel);
				}
			}
		} catch (IOException e) {
			System.err.println("Fehler beim Lesen der Datei.");
		}
	}

	/**
	 * Lädt Vokabeln aus einer CSV-Datei.
	 * @param file Datei
	 */
	public void loadFromCSV(File file) {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 2) {
					VokabelPaar vokabel = new VokabelPaar(parts[0], parts[1]);
					addToLoadList(vokabel);
				}
			}
		} catch (IOException e) {
			System.err.println("Fehler beim Lesen der Datei.");
		}
	}

	/**
	 * Lädt Vokabeln aus einer JSON-Datei.
	 * @param file Datei
	 */
	public void loadFromJSON(File file) {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			StringBuilder jsonContent = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				jsonContent.append(line);
			}
			JSONArray jsonArray = new JSONArray(jsonContent.toString());
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				String word = jsonObject.getString("word");
				String translation = jsonObject.getString("translation");
				VokabelPaar vokabel = new VokabelPaar(word, translation);
				addToLoadList(vokabel);
			}
		} catch (IOException e) {
			System.err.println("Fehler beim Lesen der JSON-Datei.");
		}
	}
}