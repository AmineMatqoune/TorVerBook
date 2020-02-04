package logic.controller;

import java.sql.SQLException;

import logic.dao.ReviewDAO;
import logic.stuff.Review;

public class ReviewRCController {

	public Review[] getReview() {
		Review[] review = null;
		try {
			ReviewDAO reviewDAO = ReviewDAO.getInstance();
			review = reviewDAO.loadRCReview();
			System.out.println(review);
			return review;
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Errore 1 in getReview!");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Errore 2 in getReview!");
		}
		System.out.println("FLAG.2");
		return review;
	}
}