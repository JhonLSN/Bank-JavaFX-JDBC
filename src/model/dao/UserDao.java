package model.dao;

import model.entities.User;

public interface UserDao {
	void insert(User obj);
	User getLogin(String email, String password);
}
