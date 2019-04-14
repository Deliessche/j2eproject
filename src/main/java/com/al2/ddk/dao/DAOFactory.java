package com.al2.ddk.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {

	/***/
	final private String DRIVER = "com.mysql.fabric.jdbc.Driver"; 
	/***/
	private String server;
	/***/
	private String db;
	/***/
	private String user;
	/***/
	private String password;
	/***/
	private Connection connection;
	
	/**
	 * @param server
	 * @param db
	 * @param user
	 * @param password
	 */
	public DAOFactory(String server, String db, String user, String password) {

		this.server = server;
		this.db = db;
		this.user = user;
		this.password = password;
	}

	/** verif de l'import du pilote a l'aide de la librairie java-mysql **/
	public void loadPilot() {

		try{
			Class.forName(DRIVER);

		} catch(ClassNotFoundException exp) {
			System.out.println("Erreur de chargement de pilote !");
		}
	}

	/****/
	public void logIn() {

		String url = "jdbc:mysql://"+this.server+"/"+this.db;

		try{
			this.connection = DriverManager.getConnection(url,this.user,this.password);

		} catch(SQLException exp) {
			System.out.println("Erreur de connexion au "+url);
		}
	}

	/****/
	public void logOut()
	{
		try {

			if(this.connection !=null) {
				this.connection.close();
			}

		} catch(SQLException exp) {
			System.out.println("Erreur de deconnexion !");
		}
	}

	/**
	 * fournit la connexion a la bdd
	 * @return la connexion
	 */
	public Connection getConnection() {
		return this.connection;
	}
}
