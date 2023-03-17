package model;

import dao.UserDAO;
import model.User;

public class LoginLogic {
	public User execute(User user) {
		UserDAO dao = new UserDAO();
		User userId = dao.findByLogin(user);

		return userId;
	}
}
