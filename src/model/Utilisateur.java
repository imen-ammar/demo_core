package model;

public class Utilisateur {

	private int id;
	private String nom;
	private String prenom;
	private String email;

	public Utilisateur() {
	}

	public Utilisateur(int id, String nom, String prenom, String email) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "\nUtilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + "]";
	}

}
