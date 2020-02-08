package com.yashkashyap.sweets;

import java.util.Comparator;

public class Sweet
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

	public Sweet(String name,float price,float weight)
	{
		this.name = name;
		this.price = price;
		this.weight = weight;
	}

	public String toString()
	{
		String s = "Sweet Name: "+name+", Price: "+Float.toString(price)+", Weight: "+Float.toString(weight)+".";
		return s;
	}
}
