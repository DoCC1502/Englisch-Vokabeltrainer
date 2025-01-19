package englischVokabeltrainerCGH.view;

import englischVokabeltrainerCGH.VokabController;
import englischVokabeltrainerCGH.model.UploadVokabelFile;

import englischVokabeltrainerCGH.model.VokabelLoader;
import englischVokabeltrainerCGH.model.VokabelPaar;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Panel für das Uploaden von Vokabeln
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 0.1
 */
public class UploadPanel extends JPanel {

	private JLabel instructionLabel;
	private JComboBox<String> fileTypeComboBox;
	private JButton uploadButton;
	private JLabel statusLabel;
	private JButton backButton;
	private UploadVokabelFile uploadVokabelFile;
	private VokabController vController;

	public UploadPanel(UploadVokabelFile uploadVokabelFile, VokabController vController) {
		this.uploadVokabelFile = uploadVokabelFile;
		this.vController = vController;
		setLayout(new GridLayout(5, 1, 10, 10));
		setBackground(Color.WHITE);

		instructionLabel = new JLabel("Bitte wählen Sie ein Dateiformat und laden Sie die Datei hoch:", SwingConstants.CENTER);
		fileTypeComboBox = new JComboBox<>(new String[]{"JSON", "TXT", "CSV"});
		uploadButton = new JButton("Datei hochladen");
		statusLabel = new JLabel("Status: Keine Datei hochgeladen.", SwingConstants.CENTER);
		backButton = new JButton("Zurück");

		add(instructionLabel);

		JPanel comboBoxPanel = new JPanel();
		comboBoxPanel.add(fileTypeComboBox);
		add(comboBoxPanel);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(uploadButton);
		add(buttonPanel);

		add(statusLabel);

		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vController.getVFrame().switchToPanel("HomemenuPanel");
			};
		});

		add(backButton);

		uploadButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedFileType = (String) fileTypeComboBox.getSelectedItem();
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
					@Override
					public boolean accept(File f) {
						if (f.isDirectory()) {
							return true;
						}
						String fileName = f.getName().toLowerCase();
						switch (selectedFileType) {
							case "JSON":
								return fileName.endsWith(".json");
							case "TXT":
								return fileName.endsWith(".txt");
							case "CSV":
								return fileName.endsWith(".csv");
							default:
								return false;
						}
					}

					@Override
					public String getDescription() {
						return selectedFileType + " Dateien (*." + selectedFileType.toLowerCase() + ")";
					}
				});

				int returnValue = fileChooser.showOpenDialog(UploadPanel.this);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					if (validateFileType(selectedFile, selectedFileType)) {
						boolean uploadSuccess = uploadFile(selectedFile, selectedFileType);
						if (uploadSuccess) {
							statusLabel.setText("Status: " + selectedFileType + "-Datei erfolgreich hochgeladen.");
						} else {
							statusLabel.setText("Status: Fehler beim Hochladen der Datei.");
						}
					} else {
						statusLabel.setText("Status: Ungültige Datei. Bitte eine " + selectedFileType + "-Datei auswählen.");
					}
				}
			}
		});
		comboBoxPanel.setBackground(Color.WHITE);
		buttonPanel.setBackground(Color.WHITE);
	}

	private boolean validateFileType(File file, String expectedFileType) {
		String fileName = file.getName().toLowerCase();
		switch (expectedFileType) {
			case "JSON":
				return fileName.endsWith(".json");
			case "TXT":
				return fileName.endsWith(".txt");
			case "CSV":
				return fileName.endsWith(".csv");
			default:
				return false;
		}
	}

	private boolean uploadFile(File file, String fileType) {
		try {
			uploadVokabelFile.loadVokabelFile(file, fileType, vController);
			System.out.println("Diese Vokabeln wurden hinzugefügt: ");
			for (int i = 0; i < vController.getUserAccount().getVokabelListe().getLength(); i++) {
				VokabelPaar paar = vController.getUserAccount().getVokabelListe().getVokabelPaar(i);
				System.out.println(paar.getWortDe()+ " - " + paar.getWortEn());
			}
			vController.renewFavpanel();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {
		VokabelLoader dummyLoader = new VokabelLoader() {
			@Override
			public void addToLoadList(VokabelPaar paar) {
				System.out.println("VokabelPaar hinzugefügt: " + paar);
			}
		};

		UploadVokabelFile uploadVokabelFile = new UploadVokabelFile(dummyLoader);

		JFrame frame = new JFrame("Upload Panel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.add(new UploadPanel(uploadVokabelFile, new VokabController()));
		frame.setVisible(true);
	}
}