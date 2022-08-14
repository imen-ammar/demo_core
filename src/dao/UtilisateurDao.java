package dao;

import java.util.List;

import model.Utilisateur;

public interface UtilisateurDao {
	
	public void ajouterUtilisateur(String nom, String prenom, String email) throws DaoException;

	public Utilisateur recupererUtilisateur(int id) throws DaoException;

	public List<Utilisateur> recupererUtilisateurs() throws DaoException;

}
