package com.al2.ddk.jee.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {

	/***/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idU")
	private Integer idU;
	/***/
	@Column(name = "first_nameU")
	private String firstNameU;
	/***/
	@Column(name = "last_nameU")
	private String lastNameU;
	/***/
	@Column(name = "emailU")
	private String emailU;
	/***/
	@JsonIgnore
	@Column(name = "passwordU")
	private String passwordU;
	/***/
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<Command> commands;

	/***/
	public User() {}

	/**
	 * @return the idU
	 */
	public Integer getIdU() {
		return idU;
	}

	/**
	 * @param idU the idU to set
	 */
	public void setIdU(Integer idU) {
		this.idU = idU;
	}

	/**
	 * @return the firstNameU
	 */
	public String getFirstNameU() {
		return firstNameU;
	}

	/**
	 * @param firstNameU the firstNameU to set
	 */
	public void setFirstNameU(String firstNameU) {
		this.firstNameU = firstNameU;
	}

	/**
	 * @return the lastNameU
	 */
	public String getLastNameU() {
		return lastNameU;
	}

	/**
	 * @param lastNameU the lastNameU to set
	 */
	public void setLastNameU(String lastNameU) {
		this.lastNameU = lastNameU;
	}

	/**
	 * @return the emailU
	 */
	public String getEmailU() {
		return emailU;
	}

	/**
	 * @param emailU the emailU to set
	 */
	public void setEmailU(String emailU) {
		this.emailU = emailU;
	}

	/**
	 * @return the passwordU
	 */
	public String getPasswordU() {
		return passwordU;
	}

	/**
	 * @param passwordU the passwordU to set
	 */
	public void setPasswordU(String passwordU) {
		this.passwordU = passwordU;
	}

	/**
	 * @return the commands
	 */
	public List<Command> getCommands() {
		return commands;
	}

	/**
	 * @param commands the commands to set
	 */
	public void setCommands(List<Command> commands) {
		this.commands = commands;
	}
}
