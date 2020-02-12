package test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

import logic.dao.AdDAO;

public class TestAdDAO {

	//3 casi corretti, 3 casi scorretti
	
	@Test
	public void testCheckIsFavouriteAdCorrect1() throws SQLException {
		AdDAO ad = AdDAO.getInstance();
		assertEquals(true, ad.checkIsFavouriteAd(2, "Ludo98"));
	}
	
	@Test
	public void testCheckIsFavouriteAdCorrect2() throws SQLException {
		AdDAO ad = AdDAO.getInstance();
		assertEquals(true, ad.checkIsFavouriteAd(4, "CptPackage"));
	}
	
	@Test
	public void testCheckIsFavouriteAdCorrect3() throws SQLException {
		AdDAO ad = AdDAO.getInstance();
		assertEquals(true, ad.checkIsFavouriteAd(3, "Amine139"));
	}
	
	@Test
	public void testCheckIsFavouriteAdWrong1() throws SQLException {
		AdDAO ad = AdDAO.getInstance();
		assertEquals(false, ad.checkIsFavouriteAd(2, "CptPackage"));
	}
	
	@Test
	public void testCheckIsFavouriteAdWrong2() throws SQLException {
		AdDAO ad = AdDAO.getInstance();
		assertEquals(false, ad.checkIsFavouriteAd(3, "Ludo98"));
	}
	
	@Test
	public void testCheckIsFavouriteAdWrong3() throws SQLException {
		AdDAO ad = AdDAO.getInstance();
		assertEquals(false, ad.checkIsFavouriteAd(2, "Amine139"));
	}
	
}
