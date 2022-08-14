package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao {

	private String SQL_SELECT = "SELECT * FROM utilisateur";

	private String SQL_SELECT_BY_ID = "SELECT * FROM utilisateur WHERE id =?";

	private String SQL_INSRT = "INSERT INTO public.utilisateur(nom, prenom, email) VALUES (?, ?, ?)";
	DaoFactory daoFactory;

	public UtilisateurDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void ajouterUtilisateur(String nom, String prenom, String email) throws DaoException {
		Connection con = null;
		try {
			con = daoFactory.getConnection();

			PreparedStatement pst = con.prepareStatement(SQL_INSRT);
			pst.setString(1, nom);
			pst.setString(2, prenom);
			pst.setString(3, email);

			int resultatInsertion = pst.executeUpdate();

			if (resultatInsertion != 1) {
				throw new DaoException("Impossible d'insérer l'utilisateur " + nom + " " + prenom + " dans la BDD.");
			}

			pst.close();

		} catch (SQLException e) {
			throw new DaoException("Erreur de lecture Table Utilisateur");
		} finally {
			daoFactory.releaseConnection(con);
		}

	}

	@Override
	public Utilisateur recupererUtilisateur(int id) throws DaoException {
		Utilisateur utilisateur;
		Connection con = null;
		try {
			con = daoFactory.getConnection();

			PreparedStatement pst = con.prepareStatement(SQL_SELECT_BY_ID);
			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				utilisateur = map(rs);
			} else {
				throw new DaoException("Impossible de trouver l'utilisateur " + id);
			}

			rs.close();
			pst.close();

		} catch (SQLException e) {
			throw new DaoException("Erreur de lecture Table Utilisateur");
		} finally {
			daoFactory.releaseConnection(con);
		}

		return utilisateur;
	}

	@Override
	public List<Utilisateur> recupererUtilisateurs() throws DaoException {
		List<Utilisateur> listeUtilisateurs = new ArrayList();
		Connection con = null;
		try {
			con = daoFactory.getConnection();

			PreparedStatement pst = con.prepareStatement(SQL_SELECT);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				listeUtilisateurs.add(map(rs));
			}

			rs.close();
			pst.close();

		} catch (SQLException e) {
			throw new DaoException("Erreur de lecture Table Utilisateur");
		} finally {
			daoFactory.releaseConnection(con);
		}

		return listeUtilisateurs;
	}

	private Utilisateur map(ResultSet rs) throws SQLException {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setId(rs.getInt("id"));
		utilisateur.setNom(rs.getString("nom"));
		utilisateur.setPrenom(rs.getString("prenom"));
		utilisateur.setEmail(rs.getString("email"));
		return utilisateur;
	}

}
