package com.al2.ddk.jee.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.*;

@Entity
public class Movie {

	/***/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idM")
	private Integer idM;
	/***/
	@Column(name = "nameM")
	private String nameM;
	/***/
	@Column(name = "durationM")
	private int durationM;
	/***/
	@Column(name = "yearM")
	private int yearM;
	/***/
	@Lob
	@Column(name = "descriptionM")
	private String descriptionM;
	/***/
	@Column(name = "cover_url")
	private String cover_url;
	/***/
	@JsonIgnore
	@OneToMany(mappedBy="movie")
	private List<Copy> copies;

	/***/
	public Movie() {}
	
	/**
	 * @param nameM
	 * @param durationM
	 * @param yearM
	 * @param descriptionM
	 * @param cover_url*/
	public Movie(String nameM, int durationM, int yearM, String descriptionM, String cover_url) {
		this.nameM = nameM;
		this.durationM = durationM;
		this.yearM = yearM;
		this.descriptionM = descriptionM;
		this.cover_url = cover_url;
	}

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

	/**
	 * @return the copies
	 */
	public List<Copy> getCopies() {
		return copies;
	}

	/**
	 * @param copies the copies to set
	 */
	public void setCopies(List<Copy> copies) {
		this.copies = copies;
	}

	public String getCover_url() {
		return cover_url;
	}

	public void setCover_url(String cover_url) {
		this.cover_url = cover_url;
	}
}
