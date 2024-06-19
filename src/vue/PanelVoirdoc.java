package vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controleur.Controleur;
import controleur.Documentation;
import controleur.Tableau;

public class PanelVoirdoc extends PanelPrincipal implements ActionListener {
    private JPanel panelForm = new JPanel();
    private Tableau unTableau;
    private JTable tabledoc;
    private JScrollPane Scroll;

    public PanelVoirdoc() {
        super("Voici la liste des documents");

        this.panelForm.setBounds(250, 100, 350, 100);

        String entetes[] = { "Id Doc", "Description", "texte", "Createur" };
        this.unTableau = new Tableau(this.RecupDoc(), entetes);
        this.tabledoc = new JTable(this.unTableau);
        this.panelForm.add(tabledoc);

        this.Scroll = new JScrollPane(this.tabledoc);
        this.Scroll.setBounds(250, 150, 360, 240);
        this.Scroll.setBackground(Color.gray);
        this.add(this.Scroll);

        /*
         * this.txtInfos.setText(
         * "______ Les Informations de votre Profil ______"
         * + "\n\n Votre Id    : " + unDocumentation.getIdDoc()
         * + "\n\n Votre Texte : " + unDocumentation.getTexte()
         * + "\n\n Votre Createur  : " + unDocumentation.getCreateur()
         * + "\n\n Votre Description   : " + unDocumentation.getDescription());
         * this.txtInfos.setBounds(50, 120, 300, 200);
         * this.txtInfos.setBackground(Color.gray);
         * this.add(this.txtInfos);
         */

        this.add(this.panelForm);
    }

    public Object[][] RecupDoc() {
        ArrayList<Documentation> lesDocs = Controleur.RecupDoc();
        Object[][] matrice = new Object[lesDocs.size()][4];
        int i = 0;
        for (Documentation unDocumentation : lesDocs) {
            matrice[i][0] = unDocumentation.getIdDoc();
            matrice[i][1] = unDocumentation.getDescription();
            matrice[i][2] = unDocumentation.getTexte();
            matrice[i][3] = unDocumentation.getCreateur();
            i++;
        }
        return matrice;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}