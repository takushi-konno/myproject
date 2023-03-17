package model;

import java.io.Serializable;

public class User implements Serializable{
	private String userId;	// ユーザーID
	private String pass;	// パスワード

	public User() {	}

	public User(String userId) {
		super();
		this.userId = userId;
	}

	public User(String userId, String pass) {
		super();
		this.userId = userId;
		this.pass = pass;
	}

	public String getUserId() {
		return userId;
	}

	public String getPass() {
		return pass;
	}

}
