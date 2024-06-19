package modele;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Documentation;
import controleur.User;

public class Modele {
	// instanciation de la connexion Mysql
	private static BDD uneBdd = new BDD("localhost:3306", "E5_lourd", "root", "");

	public static User verifConnexion(String email, String mdp) {
		User unUser = null;
		String requete = "select * from user where email = ? and mdp = ? ;";
		try {
			uneBdd.seConnecter();
			PreparedStatement unStat = uneBdd.getMaConnexion().prepareStatement(requete);
			// affecter des données aux parametres
			unStat.setString(1, email);
			unStat.setString(2, mdp);

			ResultSet unRes = unStat.executeQuery();

			if (unRes.next()) {
				// extraction des données de la BDD
				unUser = new User(
						unRes.getInt("iduser"), unRes.getString("nom"),
						unRes.getString("prenom"), unRes.getString("email"),
						unRes.getString("mdp"), unRes.getString("role"));
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur execution requete :" + requete);
			exp.printStackTrace();
		}
		return unUser;
	}

	public static void updateUser(User unUser) {
		String requete = "update user set nom='"
				+ unUser.getNom() + "',prenom ='" + unUser.getPrenom()
				+ "',email = '" + unUser.getEmail() + "', mdp ='"
				+ unUser.getMdp() + "', role='" + unUser.getRole()
				+ "' where iduser =" + unUser.getIduser();
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur execution requete :" + requete);
			exp.printStackTrace();
		}
	}

	public static void appelProcedure(String nomP, String tab[]) {
		String chaine = "'" + String.join("','", tab) + "'";
		String requete = "call  " + nomP + "(" + chaine + ") ; ";
		System.out.println(requete);

		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur execution requete :" + requete);
			exp.printStackTrace();
		}
	}

	public static void EnregistrerDoc(Documentation unDocumentation) {
		String requete = "Insert into documentation (description,texte,createur) VALUES ('"
				+ unDocumentation.getTexte()
				+ "','" + unDocumentation.getDescription()
				+ "','" + unDocumentation.getCreateur() + "')";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur execution requete :" + requete);
			exp.printStackTrace();
		}
	}

	public static ArrayList<Documentation> RecupDoc() {
		ArrayList<Documentation> lesDocumentations = new ArrayList<Documentation>();
		String requete = "select * from documentation";
		try {
			uneBdd.seConnecter();
			PreparedStatement unStat = uneBdd.getMaConnexion().prepareStatement(requete);

			ResultSet desRes = unStat.executeQuery();

			if (desRes.next()) {
				// extraction des données de la BDD
				while (desRes.next()) {
					Documentation unDocumentation = new Documentation(
							desRes.getInt("idDoc"), desRes.getString("description"),
							desRes.getString("texte"), desRes.getString("createur"));
					lesDocumentations.add(unDocumentation);
				}

			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur execution requete :" + requete);
			exp.printStackTrace();
		}
		return lesDocumentations;
	}
}
