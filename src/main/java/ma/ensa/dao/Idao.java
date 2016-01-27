package ma.ensa.dao;

import java.util.List;
import ma.ensa.model.*;

public interface Idao<T> {
	
	public List<User> findAll();
	public void persist(T obj);
	public User getUserByLogin(String login);
	public void updateRecord(Object entite);
	
}
