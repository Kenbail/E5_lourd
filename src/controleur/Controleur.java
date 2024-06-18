package controleur;

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
}
