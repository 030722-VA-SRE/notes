package com.revature.models;

import java.time.LocalDate;
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
@Table(name="tasks")
public class Task {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String description;
	@Column(name = "date_created", updatable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP")
	private LocalDate dateCreated;
	private LocalDate dueDate;
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private User userAssigned;
	
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public User getUserAssigned() {
		return userAssigned;
	}
	public void setUserAssigned(User userAssigned) {
		this.userAssigned = userAssigned;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dateCreated, description, dueDate, id, userAssigned);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(dateCreated, other.dateCreated) && Objects.equals(description, other.description)
				&& Objects.equals(dueDate, other.dueDate) && id == other.id
				&& Objects.equals(userAssigned, other.userAssigned);
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", description=" + description + ", dateCreated=" + dateCreated + ", dueDate="
				+ dueDate + ", userAssigned=" + userAssigned + "]";
	}
}
