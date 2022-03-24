package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="lions")
public class Lion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@ManyToOne
	@JoinColumn(nullable=false, name = "pet_owner_id")
	private User petOwner;
	
	public Lion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getPetOwner() {
		return petOwner;
	}
	public void setPetOwner(User petOwner) {
		this.petOwner = petOwner;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, name, petOwner);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lion other = (Lion) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(petOwner, other.petOwner);
	}
	@Override
	public String toString() {
		return "Lion [id=" + id + ", name=" + name + ", petOwner=" + petOwner + "]";
	}
}
