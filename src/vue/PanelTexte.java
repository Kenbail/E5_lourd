package vue;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanelTexte extends PanelPrincipal {

    private JPanel panelForm = new JPanel();
    private JPanel panelText = new JPanel();
    private JButton btEnregistrer = new JButton("Enregistrer");
    private JButton btAnnuler = new JButton("Annuler");

    private JTextArea txtDescription = new JTextArea(3, 20);
    private JTextArea txtediteur = new JTextArea(15, 25);

    public PanelTexte() {
        super("Gestion des interventions");
        // construction du panel Intervention
        this.panelForm.setBackground(Color.lightGray);
        this.panelForm.setBounds(40, 100, 350, 300);

        this.panelText.setBackground(Color.lightGray);
        this.panelText.setBounds(400, 100, 350, 300);

        JLabel labelDescription = new JLabel("Description :");
        this.panelForm.add(labelDescription);

        JLabel labelediteur = new JLabel("Ecrire votre documentation:");
        this.panelText.add(labelediteur);

        txtDescription.setLineWrap(true); // activer le retour à la ligne
        txtDescription.setWrapStyleWord(true); // activer le retour à la ligne sur les mots
        JScrollPane scrollPane = new JScrollPane(txtDescription); // ajouter un scroll pour le texte area
        this.panelForm.add(scrollPane);

        txtediteur.setLineWrap(true); // activer le retour à la ligne
        txtediteur.setWrapStyleWord(true); // activer le retour à la ligne sur les mots
        JScrollPane scrollPanet = new JScrollPane(txtediteur); // ajouter un scroll pour le texte area
        this.panelText.add(scrollPanet);

        this.panelText.add(this.btAnnuler);
        this.panelText.add(this.btEnregistrer);
        this.add(this.panelForm);
        this.add(this.panelText);
    }
}
