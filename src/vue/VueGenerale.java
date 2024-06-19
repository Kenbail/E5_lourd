package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controleur.ProjetEvent;
import controleur.User;

public class VueGenerale extends JFrame implements ActionListener {
	private JButton btProfil = new JButton("Profil");
	private JButton btQuitter = new JButton("Quitter");
	private JButton btTexte = new JButton("Ecrire une nouvelle documentation");
	private JButton btVoirdoc = new JButton("Voir les documentations");
	private JPanel panelMenu = new JPanel();

	// instanciation des panels
	private PanelProfil unPanelProfil;
	private PanelTexte unPanelTexte;
	private PanelVoirdoc unPanelVoirdoc = new PanelVoirdoc();

	public VueGenerale(User unUser) {

		// envoie de unUser au profil
		this.unPanelProfil = new PanelProfil(unUser);
		this.unPanelTexte = new PanelTexte(unUser);

		this.setTitle("Bibliothèque");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(100, 100, 900, 600);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.gray);

		// contruction du panelMenu
		this.panelMenu.setBounds(20, 10, 800, 30);
		this.panelMenu.setBackground(Color.gray);
		this.panelMenu.setLayout(new GridLayout(1, 6));
		this.panelMenu.add(this.btProfil);
		this.panelMenu.add(this.btTexte);
		this.panelMenu.add(this.btVoirdoc);
		this.panelMenu.add(this.btQuitter);

		this.add(this.panelMenu);

		// insertion des Panels dans la fenetre
		this.add(this.unPanelProfil);
		this.add(this.unPanelTexte);
		this.add(this.unPanelVoirdoc);

		// rendre les boutons ecoutables
		this.btProfil.addActionListener(this);
		this.btTexte.addActionListener(this);
		this.btVoirdoc.addActionListener(this);
		this.btQuitter.addActionListener(this);

		this.setVisible(true);
	}

	public void afficherPanel(int choix) {
		this.unPanelProfil.setVisible(false);
		this.unPanelTexte.setVisible(false);
		this.unPanelVoirdoc.setVisible(false);
		switch (choix) {
			case 1:
				this.unPanelProfil.setVisible(true);
				break;
			case 2:
				this.unPanelTexte.setVisible(true);
				break;
			case 3:
				this.unPanelVoirdoc.setVisible(true);
				break;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btProfil) {
			this.afficherPanel(1);
		} else if (e.getSource() == this.btTexte) {
			this.afficherPanel(2);
		} else if (e.getSource() == this.btVoirdoc) {
			this.afficherPanel(3);
		} else if (e.getSource() == this.btQuitter) {
			ProjetEvent.rendreVisibleVueGenerale(false, null);
			ProjetEvent.rendreVisibleVueConnexion(true);
		}
	}
}
