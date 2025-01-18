package englischVokabeltrainerCGH.view;

import englischVokabeltrainerCGH.VokabController;
import englischVokabeltrainerCGH.model.UserAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

/**
 * Panel für die Favoriten
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 0.1
 */
public class FavPanel extends JPanel{

	private VokabController vController;

	private JButton jbFav = new JButton("als Favorit markieren");
	private Set<String> favorites;
	private JList<String> vokabelList;
	private DefaultListModel<String> listModel;

	/**
	 * Konstruktor
	 * @param vController Controller
	 */
	public FavPanel(VokabController vController){
		this.vController = vController;
		this.favorites = new HashSet<>();
		setLayout(new GridLayout(1, 1));
		JPanel framePanel = new JPanel(new BorderLayout());
		JPanel topPanel = new JPanel();

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(1, 2));
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();

		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		listModel = new DefaultListModel<>();

		int heightLeftPanel = 0;
		for (int i = 0; i < vController.getUserAccount().getVokabelListe().getLength() ; i++) {
			StringBuilder sb = new StringBuilder();
			String vokabelEN = vController.getUserAccount().getVokabelListe().getVokabelPaar(i).getWortEn();
			String vokabelDE = vController.getUserAccount().getVokabelListe().getVokabelPaar(i).getWortDe();
			sb.append(vokabelEN).append(" - ").append(vokabelDE);
			String vokabel = sb.toString();
			listModel.addElement(vokabel);
			heightLeftPanel += 18;
		}

		vokabelList = new JList<>(listModel);
		vokabelList.setCellRenderer(new VokabelListCellRenderer());
		leftPanel.add(vokabelList);

		jbFav.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedValue = vokabelList.getSelectedValue();
				if (selectedValue != null) {
					if (favorites.contains(selectedValue)) {
						favorites.remove(selectedValue);
						vController.getFavouriteList().removeFavWord(vController.getUserAccount().getVokabelListe().getVokabelPaar(vokabelList.getSelectedIndex()));
						for (int i=0; i<vController.getFavouriteList().getFavList().length; i++) {
							System.out.println(vController.getFavouriteList().getFavWord(i).getWortDe());
						}
					} else {
						favorites.add(selectedValue);
						vController.getFavouriteList().addFavWord(vController.getUserAccount().getVokabelListe().getVokabelPaar(vokabelList.getSelectedIndex()));
						for (int i=0; i<vController.getFavouriteList().getFavList().length; i++) {
							System.out.println(vController.getFavouriteList().getFavWord(i).getWortDe());
						}
						System.out.println("\n");
						vController.getFavouriteList().getFavList();

					}
					vokabelList.repaint();
				}
			}
		});

		rightPanel.setLayout(new GridLayout(2, 1));

		JPanel topRightPanel = new JPanel();

		rightPanel.add(topRightPanel);

		leftPanel.setPreferredSize(new Dimension(200, heightLeftPanel));
		JScrollPane scrollPane = new JScrollPane(leftPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		mainPanel.setPreferredSize(new Dimension(450, 400));
		mainPanel.add(scrollPane);
		mainPanel.add(rightPanel);
		topRightPanel.add(jbFav);

		framePanel.add(topPanel, BorderLayout.NORTH);
		framePanel.add(mainPanel, BorderLayout.CENTER);
		add(mainPanel);
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
