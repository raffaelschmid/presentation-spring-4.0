package com.trivadis.boot.city;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class City implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @Column()
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String country;

	@Column(nullable = false)
	private String map;

	protected City() {
	}

	public City(String name, String country) {
		this.name = name;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public String getCountry() {
		return this.country;
	}

	public String getMap() {
		return this.map;
	}

	@Override
	public String toString() {
		return getName() + ", " + getCountry();
	}
}