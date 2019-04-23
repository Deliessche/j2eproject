package com.al2.ddk.jee.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
	
	/***/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idM")
	private Integer idM;
	/***/
	private String nameM;
	/***/
	private int durationM;
	/***/
	private int yearM;
	/***/
	private String creatorM;
	/***/
	private String descriptionM;
	
	/***/
	public Movie() {}

	/**
	 * @return the idM
	 */
	public Integer getIdM() {
		return idM;
	}

	/**
	 * @param idM the idM to set
	 */
	public void setIdM(Integer idM) {
		this.idM = idM;
	}

	/**
	 * @return the nameM
	 */
	public String getNameM() {
		return nameM;
	}

	/**
	 * @param nameM the nameM to set
	 */
	public void setNameM(String nameM) {
		this.nameM = nameM;
	}

	/**
	 * @return the durationM
	 */
	public int getDurationM() {
		return durationM;
	}

	/**
	 * @param durationM the durationM to set
	 */
	public void setDurationM(int durationM) {
		this.durationM = durationM;
	}

	/**
	 * @return the yearM
	 */
	public int getYearM() {
		return yearM;
	}

	/**
	 * @param yearM the yearM to set
	 */
	public void setYearM(int yearM) {
		this.yearM = yearM;
	}

	/**
	 * @return the creatorM
	 */
	public String getCreatorM() {
		return creatorM;
	}

	/**
	 * @param creatorM the creatorM to set
	 */
	public void setCreatorM(String creatorM) {
		this.creatorM = creatorM;
	}

	/**
	 * @return the descriptionM
	 */
	public String getDescriptionM() {
		return descriptionM;
	}

	/**
	 * @param descriptionM the descriptionM to set
	 */
	public void setDescriptionM(String descriptionM) {
		this.descriptionM = descriptionM;
	}
}
