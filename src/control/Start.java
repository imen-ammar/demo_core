package control;

import dao.DaoException;
import dao.DaoFactory;
import dao.UtilisateurDao;

public class Start {

	public static void main(String[] args) throws DaoException {
		UtilisateurDao utilisateurDao = DaoFactory.getInstance().getUtilisateurDao();
		
		utilisateurDao.ajouterUtilisateur("AMMAR", "Imen", "imenammar25@gmail.com");
		
		System.out.println(utilisateurDao.recupererUtilisateur(1));
		
		System.out.println(utilisateurDao.recupererUtilisateurs());
	}
}
