package englischVokabeltrainerCGH.view;

import englischVokabeltrainerCGH.VokabController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel für die Einstellungen
 *
 * @author Dario Cikojevic, Berkay Semi Genc, Elias Hofbauer
 * @version 0.1
 */
public class SettingsPanel extends JPanel {
    private VokabController vController;
    private JComboBox<String> levelComboBox;

    public SettingsPanel(VokabController vController) {
        this.vController = vController;
        initializeComponents();


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

    private void initializeComponents() {
        // Haupt-Layout (GridLayout für die Strukturierung)
        setLayout(new GridLayout(1, 1));
        setBackground(Color.WHITE); // Hintergrundfarbe

        JPanel framePanel = new JPanel(new BorderLayout());

        // Panel für die Icons
        JPanel iconPanel = new JPanel(new BorderLayout());
        iconPanel.setBackground(Color.WHITE);

        // Icons hinzufügen
        JPanel rightIconsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightIconsPanel.setBackground(Color.WHITE);

        // Icons hinzufügen
        JButton iconButton0 = createIconButton("resource/Home.png", "HomemenuPanel");
        JButton iconButton1 = createIconButton("resource/Upload.png", "UploadPanel");
        JButton iconButton2 = createIconButton("resource/Favoriten.png", "FavPanel");
        JButton iconButton3 = createIconButton("resource/settings.png", "SettingsPanel");

        rightIconsPanel.add(iconButton0);
        rightIconsPanel.add(iconButton1);
        rightIconsPanel.add(iconButton2);
        rightIconsPanel.add(iconButton3);

        JButton loginButton = createIconButton("resource/login.png", "LoginPanel");
        JPanel leftIconsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftIconsPanel.setBackground(Color.WHITE);
        leftIconsPanel.add(loginButton);

        iconPanel.add(leftIconsPanel, BorderLayout.WEST);
        iconPanel.add(rightIconsPanel, BorderLayout.EAST);

        framePanel.add(iconPanel, BorderLayout.NORTH);

        JPanel settingsPanel = new JPanel();
        settingsPanel.setLayout(new GridLayout(5, 2));
        settingsPanel.setBackground(Color.WHITE);

        JLabel settingsLabel = new JLabel("Einstellungen", SwingConstants.CENTER);
        settingsLabel.setFont(new Font("Arial", Font.BOLD, 20));
        settingsPanel.add(settingsLabel);
        settingsPanel.add(new JLabel("")); // Empty label to fill the grid slot

        JLabel levelLabel = new JLabel("Level ändern:", SwingConstants.CENTER);
        levelLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        levelComboBox = new JComboBox<>(new String[]{"1 (Leicht)", "2 (Mittel)", "3 (Schwer)"});
        settingsPanel.add(levelLabel);
        settingsPanel.add(levelComboBox);

        JLabel accountSpeichernLabel = new JLabel("Account speichern:", SwingConstants.CENTER);
        accountSpeichernLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        JButton accountSpeichernButton = new JButton("Speichern");
        accountSpeichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vController.getUserAccount().saveAccount();
                JOptionPane.showMessageDialog(null, "Account wurde gespeichert.", "Account gespeichert", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        settingsPanel.add(accountSpeichernLabel);
        settingsPanel.add(accountSpeichernButton);

        JLabel kontaktLabel = new JLabel("Kontakt:", SwingConstants.CENTER);
        kontaktLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        JButton kontaktButton = new JButton("Kontaktiere uns");
        kontaktButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "unser Team:\nDario Cikojevic - Teamleiter: dcikojevic@student.tgm.ac.at\nBerkay Semi Genc - Developer: bgenc@student.tgm.ac.at" +
                        "\nElias Hofbauer - Developer: ehofbauer@student.tgm.ac.at", "Kontaktdaten", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        settingsPanel.add(kontaktLabel);
        settingsPanel.add(kontaktButton);

        JLabel deleteAccountLabel = new JLabel("Account löschen:", SwingConstants.CENTER);
        deleteAccountLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        JButton deleteAccountButton = new JButton("Account löschen");
        deleteAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dialogResult = JOptionPane.showConfirmDialog(null, "Möchten Sie Ihren Account wirklich löschen?", "Account löschen", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    vController.getUserAccount().deleteEverything();
                    JOptionPane.showMessageDialog(null, "Account wurde gelöscht.", "Account gelöscht", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        settingsPanel.add(deleteAccountLabel);
        settingsPanel.add(deleteAccountButton);

        framePanel.add(settingsPanel, BorderLayout.CENTER);
        add(framePanel);
    }
}
