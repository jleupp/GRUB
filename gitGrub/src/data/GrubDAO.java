package data;

import entities.LogInCredentials;

public interface GrubDAO {

	public LogInCredentials checkManagerCred (LogInCredentials login, String restaurant);
}
