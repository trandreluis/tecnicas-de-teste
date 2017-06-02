package br.edu.ifpb.mt.tt;

import java.util.List;

public class UserService {

	private UserDAO userDAO;
	
	public UserService() {
		
	}
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void save(User user) {
		userDAO.save(user);
	}

	public void update(User user) {
		userDAO.update(user);
	}

	public void delete(User user) {
		userDAO.delete(user);
	}

	public User getByID(int userId) {
		return userDAO.getByID(userId);
	}

	public List<User> getAll() {
		return userDAO.getAll(); 
	}
	
}
