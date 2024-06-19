package controleur;

import java.util.ArrayList;

import modele.Modele;

public class Controleur {
	public static User verifConnexion(String email, String mdp) {
		return Modele.verifConnexion(email, mdp);
	}

	public static void updateUser(User unUser) {
		Modele.updateUser(unUser);
	}

	public static void appelProcedure(String nomP, String tab[]) {
		Modele.appelProcedure(nomP, tab);
	}

	public static void EnregistrerDoc(Documentation unDocumentation) {
		Modele.EnregistrerDoc(unDocumentation);
	}

	public static ArrayList<Documentation> RecupDoc() {
		return Modele.RecupDoc();
	}
}
