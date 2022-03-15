package com.revature.models;

import java.util.Objects;

public class Task {

	private int id;
	private String description;
	private boolean isCompleted;
	
	// in this case, many to one (many tasks to one user)
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

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public User getUserAssigned() {
		return userAssigned;
	}

	public void setUserAssigned(User userAssigned) {
		this.userAssigned = userAssigned;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", description=" + description + ", isCompleted=" + isCompleted + ", userAssigned="
				+ userAssigned + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, isCompleted, userAssigned);
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
		return Objects.equals(description, other.description) && id == other.id && isCompleted == other.isCompleted
				&& Objects.equals(userAssigned, other.userAssigned);
	}
	
}
