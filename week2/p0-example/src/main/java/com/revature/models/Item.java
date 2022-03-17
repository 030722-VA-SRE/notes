package com.revature.models;

import java.util.Objects;

/*-
 * for this example, item is going to be the model that we are working with.
 * 	- models have properties
 */
public class Item {
	/*-
	 * Each object might have different values for these fields
	 * these objects will be stored in our database as records
	 */
	private int id;
	private double price;
	private String type;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, price, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return id == other.id && Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(type, other.type);
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", price=" + price + ", type=" + type + "]";
	}
}
