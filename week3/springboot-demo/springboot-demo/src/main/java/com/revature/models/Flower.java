package com.revature.models;

import java.util.Objects;

public class Flower {

	private int id;
	private String color;
	private String type;
	
	public Flower() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Flower [id=" + id + ", color=" + color + ", type=" + type + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(color, id, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flower other = (Flower) obj;
		return Objects.equals(color, other.color) && id == other.id && Objects.equals(type, other.type);
	}
}
