package data;

import java.util.List;

import client.LogInCredentials;
import entities.Restaurant;

public interface GrubDAO {

	public LogInCredentials checkUserCred (LogInCredentials login);
	public List<Restaurant> browseAllRestaurants();
}
