package englischVokabeltrainerCGH.view;

import englischVokabeltrainerCGH.VokabController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

/**
 * Panel für die Favoriten
 *
 * @version 0.1
 * @autor Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 */
public class FavPanel extends JPanel {
	private VokabController vController;
	private JButton jbFav = new JButton("als Favorit markieren");
	private Set<String> favorites;
	private JList<String> vokabelList;
	private DefaultListModel<String> listModel;

	public FavPanel(VokabController vController) {
		this.vController = vController;
		this.favorites = new HashSet<>();
		initializeComponents();
	}

	private void initializeComponents() {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);

		// Top panel with icon buttons
		JPanel iconPanel = new JPanel(new BorderLayout());
		iconPanel.setBackground(Color.WHITE);

		JPanel rightIconsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		rightIconsPanel.setBackground(Color.WHITE);

		JButton iconButton1 = createIconButton("resource/Upload.png", "UploadPanel");
		JButton iconButton2 = createIconButton("resource/Favoriten.png", "FavPanel");
		JButton iconButton3 = createIconButton("resource/settings.png", "SettingsPanel");

		rightIconsPanel.add(iconButton1);
		rightIconsPanel.add(iconButton2);
		rightIconsPanel.add(iconButton3);

		JButton loginButton = createIconButton("resource/login.png", "LoginPanel");
		JPanel leftIconsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		leftIconsPanel.setBackground(Color.WHITE);
		leftIconsPanel.add(loginButton);

		iconPanel.add(leftIconsPanel, BorderLayout.WEST);
		iconPanel.add(rightIconsPanel, BorderLayout.EAST);

		add(iconPanel, BorderLayout.NORTH);

		// Main content
		listModel = new DefaultListModel<>();
		for (int i = 0; i < vController.getUserAccount().getVokabelListe().getLength(); i++) {
			String vokabelEN = vController.getUserAccount().getVokabelListe().getVokabelPaar(i).getWortEn();
			String vokabelDE = vController.getUserAccount().getVokabelListe().getVokabelPaar(i).getWortDe();
			listModel.addElement(vokabelEN + " - " + vokabelDE);
		}

		vokabelList = new JList<>(listModel);
		vokabelList.setCellRenderer(new VokabelListCellRenderer());
		JScrollPane scrollPane = new JScrollPane(vokabelList);

		add(scrollPane, BorderLayout.CENTER);
		add(jbFav, BorderLayout.SOUTH);

		jbFav.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedValue = vokabelList.getSelectedValue();
				if (selectedValue != null) {
					if (favorites.contains(selectedValue)) {
						favorites.remove(selectedValue);
						vController.getFavouriteList().removeFavWord(vController.getUserAccount().getVokabelListe().getVokabelPaar(vokabelList.getSelectedIndex()));
					} else {
						favorites.add(selectedValue);
						vController.getFavouriteList().addFavWord(vController.getUserAccount().getVokabelListe().getVokabelPaar(vokabelList.getSelectedIndex()));
					}
					vokabelList.repaint();
				}
			}
		});
	}

	private JButton createIconButton(String iconPath, String panelName) {
		ImageIcon icon = new ImageIcon(iconPath);
		Image scaledImage = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		JButton button = new JButton(new ImageIcon(scaledImage));
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vController.getVFrame().switchToPanel(panelName);
			}
		});
		return button;
	}

	private class VokabelListCellRenderer extends DefaultListCellRenderer {
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			if (favorites.contains(value.toString())) {
				c.setBackground(Color.YELLOW);
			} else {
				c.setBackground(isSelected ? Color.LIGHT_GRAY : Color.WHITE);
			}
			return c;
		}
	}

	public static void main(String[] args) {
		VokabController vController = new VokabController();

		vController.getUserAccount().getVokabelListe().addVokabelPaar("Hund", "Dog");
		vController.getUserAccount().getVokabelListe().addVokabelPaar("Katze", "Cat");
		vController.getUserAccount().getVokabelListe().addVokabelPaar("Maus", "Mouse");
		vController.getUserAccount().getVokabelListe().addVokabelPaar("Vogel", "Bird");
		vController.getUserAccount().getVokabelListe().addVokabelPaar("Fisch", "Fish");

		JFrame frame = new JFrame();
		FavPanel favPanel = new FavPanel(vController);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.add(favPanel);
		frame.setVisible(true);
	}
}