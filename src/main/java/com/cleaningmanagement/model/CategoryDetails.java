package com.cleaningmanagement.model;

import java.util.Objects;

public class CategoryDetails {
     private int weightInKg;
     private String category;
     private int amount;
	public int getWeightInKg() {
		return weightInKg;
	}
	public void setWeightInKg(int weightInKg) {
		this.weightInKg = weightInKg;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public CategoryDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoryDetails(int weightInKg, String category, int amount) {
		super();
		this.weightInKg = weightInKg;
		this.category = category;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "CategoryDetails [weightInKg=" + weightInKg + ", category=" + category + ", amount=" + amount + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(amount, category, weightInKg);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryDetails other = (CategoryDetails) obj;
		return amount == other.amount && Objects.equals(category, other.category) && weightInKg == other.weightInKg;
	}
     
}
