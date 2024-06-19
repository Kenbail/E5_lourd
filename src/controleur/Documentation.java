package controleur;

public class Documentation {
    private int idDoc;
    private String texte, createur, description;

    public Documentation(int idDoc, String texte, String createur, String description) {
        this.idDoc = idDoc;
        this.texte = texte;
        this.createur = createur;
        this.description = description;
    }

    public Documentation() {

    }

    public int getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(int idDoc) {
        this.idDoc = idDoc;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public String getCreateur() {
        return createur;
    }

    public void setCreateur(String createur) {
        this.createur = createur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
