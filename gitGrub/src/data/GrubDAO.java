package data;

import java.util.List;

import client.LogInCredentials;
import entities.Menu;
import entities.Order;
import entities.Restaurant;

public interface GrubDAO {

	public LogInCredentials checkUserCred (LogInCredentials login);
	public List<Restaurant> browseAllRestaurants();
	public Menu	getUserSelectedMenu(String s);
	public Order buildOrder(LogInCredentials login, Order order, String s);
	public void submitAndFinalizeOrder(LogInCredentials login);
	
}
