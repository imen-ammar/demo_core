package control;

import dao.DaoException;
import dao.DaoFactory;
import dao.UtilisateurDao;

public class Start {

	public static void main(String[] args) throws DaoException {
		UtilisateurDao utilisateurDao = DaoFactory.getInstance().getUtilisateurDao();
		
		//System.out.println(utilisateurDao.recupererUtilisateur(1));
		
		utilisateurDao.ajouterUtilisateur("BECHIKH", "Mohamed Chahir", "mm@gggg.c");
		
		System.out.println(utilisateurDao.recupererUtilisateurs());

	}

}
