package com.yashkashyap.chocolates;

public class Chocolate
{
	private String name;
	private float price;
	private float weight;

	public float getPrice()
	{
		return price;
	}

	public float getWeight()
	{
		return weight;
	}

	public Chocolate(String name,float price,float weight)
	{
		this.name = name;
		this.price = price;
		this.weight = weight;
	}

	public String toString()
	{
		String s = "Chocolate Name: "+name+", Price: "+Float.toString(price)+", Weight: "+Float.toString(weight)+".";
		return s;
	}
}
