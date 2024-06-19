package vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controleur.Controleur;
import controleur.Documentation;
import controleur.User;

public class PanelTexte extends PanelPrincipal implements ActionListener {
    private User unUser;
    private Documentation unDocumentation;
    private JPanel panelForm = new JPanel();
    private JPanel panelText = new JPanel();
    private JButton btEnregistrer = new JButton("Enregistrer");
    private JButton btAnnulert = new JButton("Annuler");
    // private JComboBox<String> btcomboBoxPolice = new JComboBox<>();
    // private JLabel labelPolice = new JLabel();
    JPanel ligneVide = new JPanel();

    private JTextArea txtDescription = new JTextArea(3, 20);
    private JTextArea txtediteur = new JTextArea(15, 25);

    public PanelTexte(User unUser) {
        super("Ecrivez votre Doc");
        this.unUser = unUser;
        this.unDocumentation = null;
        // construction du panel Intervention
        this.panelForm.setBackground(Color.lightGray);
        this.panelForm.setBounds(40, 100, 350, 100);

        this.panelText.setBackground(Color.lightGray);
        this.panelText.setBounds(400, 100, 350, 350);

        // btcomboBoxPolice.addItem("Arial");
        // btcomboBoxPolice.addItem("Courier");
        // btcomboBoxPolice.addItem("Verdana");

        JLabel labelDescription = new JLabel("Description :");
        this.panelForm.add(labelDescription);

        JLabel labelediteur = new JLabel("Ecrire votre Doc:");
        this.panelText.add(labelediteur);

        // ligneVide.setPreferredSize(new Dimension(0, 20)); // 20 pixels de hauteur
        // this.panelText.add(ligneVide);

        // this.panelText.add(new JLabel("Police :"));
        // this.panelText.add(btcomboBoxPolice);
        // this.panelText.add(labelPolice);

        txtDescription.setLineWrap(true); // activer le retour à la ligne
        txtDescription.setWrapStyleWord(true); // activer le retour à la ligne sur les mots
        JScrollPane scrollPane = new JScrollPane(txtDescription); // ajouter un scroll pour le texte area
        this.panelForm.add(scrollPane);

        txtediteur.setLineWrap(true);
        txtediteur.setWrapStyleWord(true);
        JScrollPane scrollPanet = new JScrollPane(txtediteur);
        this.panelText.add(scrollPanet);

        this.panelText.add(this.btAnnulert);
        this.panelText.add(this.btEnregistrer);
        this.add(this.panelForm);
        this.add(this.panelText);

        this.btAnnulert.addActionListener(this);
        this.btEnregistrer.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btAnnulert) {
            txtediteur.setText(""); // Vide le texte éditeur
        } else if (e.getSource() == this.btEnregistrer) {
            this.unDocumentation = new Documentation();
            String descriton = this.txtDescription.getText();
            String text = this.txtediteur.getText();
            // on realise les modifs dans Doc
            this.unDocumentation.setTexte(text);
            this.unDocumentation.setDescription(descriton);
            this.unDocumentation.setCreateur(unUser.getEmail());

            // modification dans la BDD
            Controleur.EnregistrerDoc(this.unDocumentation);
        }

        /*
         * @Override
         * public void actionPerformed(ActionEvent e) {
         * 
         * String selectedItem = (String) btcomboBoxPolice.getSelectedItem();
         * 
         * if (selectedItem.equals("Arial")) {
         * txtediteur.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 12));
         * } else if (selectedItem.equals("Verdanna")) {
         * txtediteur.setFont(new java.awt.Font("Verdanna", java.awt.Font.PLAIN, 12));
         * } else if (selectedItem.equals("Courier")) {
         * txtediteur.setFont(new java.awt.Font("Courier", java.awt.Font.PLAIN, 12));
         * } else {
         * // Default font
         * txtediteur.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 12));
         * }
         * 
         * }
         */
    }
}
