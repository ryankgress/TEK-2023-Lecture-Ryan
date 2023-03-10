package hibernate;

import java.util.Date;
import java.util.List;

public class BlockbusterMain {
	UserDAO userDao = new UserDAO();
	MovieDAO movieDao = new MovieDAO();
	MovieRentalDAO mrDao = new MovieRentalDAO();

	public static void main(String[] args) {
		BlockbusterMain bm = new BlockbusterMain();
		
		Movie movie1 = bm.movieDao.findById(2);
		User user1 = bm.userDao.findById(2);
		
//		bm.changePassword(1, "PissWord");
		
//		bm.checkout(movie1, user1);
//		bm.checkin(movie1, user1);
		
		bm.displayMovies();

	} 
	
	public void changePassword(int userId, String password) {

		User user = userDao.findById(userId);
		
		user.setPassword(password);
		userDao.update(user);
	}
	
	public void checkout(Movie movie, User user) {
		MovieRental mr = new MovieRental();
		
		mr.setUser(user);
		mr.setMovie(movie);
		mr.setCheckoutDate(new Date());
		
		mrDao.insert(mr);
		
		user.getMovieRentals().add(mr);
		movie.getMovieRentals().add(mr);
		
		userDao.update(user);
		movieDao.update(movie);
	}
	
	public void checkin(Movie movie , User user) {
		MovieRental mr = new MovieRental();
		
		mr = mrDao.findByMovieUser(movie.getId(), user.getId());
		
		mr.setCheckinDate(new Date());
		mrDao.update(mr);
	}
	
	public void displayMovies() {
		List<MovieRental> rentals = mrDao.selectAllRentals();
		
		for(MovieRental mr : rentals) {
			if(mr.getCheckinDate() == null) {
				User user = userDao.findById(mr.getUserId());
				Movie movie = movieDao.findById(mr.getMovieId());
				
				System.out.println(user.getFirstName() + " " + user.getLastName() + " is renting out "
						+ movie.getName());
			}
		}
		
	}
	
	
	
	

}
