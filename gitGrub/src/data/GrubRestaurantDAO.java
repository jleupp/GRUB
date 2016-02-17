package data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import entities.LogInCredentials;

@Transactional
public class GrubRestaurantDAO implements GrubDAO {
	@PersistenceContext
	private EntityManager em;
	
	public LogInCredentials checkManagerCred (LogInCredentials login, String restaurant) {
		
		//Check Restaurants list here for matching email
		//Check Managers List @email for matching password
		
		return null;
	}
	
}
