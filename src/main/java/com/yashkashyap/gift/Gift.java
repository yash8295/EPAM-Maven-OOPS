package com.yashkashyap.gift;

import java.util.Scanner;
import java.util.Arrays;
import com.yashkashyap.chocolates.*;
import com.yashkashyap.sweets.*;

public class Gift
{
	private Scanner input = new Scanner(System.in);
	private Chocolate c[];
	private Sweet s[];
	private int cCapacity;
	private int sCapacity;
	private int cIndex;
	private int sIndex;

	public Gift()
	{
		c = new Chocolate[10];
		s = new Sweet[10];
		cCapacity = 10;
		sCapacity = 10;
		cIndex = 0;
		sIndex = 0;
	}

	private boolean isChocolateEmpty()
	{
		if(cIndex==0)
			return true;
		return false;
	}

	private boolean isSweetEmpty()
	{
		if(sIndex==0)
			return true;
		return false;
	}

	private boolean isChocolateFull()
	{
		if(cIndex == cCapacity)
			return true;
		return false;
	}

	private boolean isSweetFull()
	{
		if(sIndex == sCapacity)
			return true;
		return false;
	}	

	private void increaseChocolateCapacity()
	{
		cCapacity++;
		c = Arrays.copyOf(c, c.length + 1);
	}

	private void increaseSweetCapacity()
	{
		sCapacity++;
		s = Arrays.copyOf(s, s.length + 1);
	}

	public void addToBasket()
	{
		int ch;
		do
		{
			System.out.println();
			System.out.println();
			System.out.println("What do you want to add ?");
			System.out.println("1. Chocolates");
			System.out.println("2. Sweets");
			System.out.println("To Exit Press 3.");
			System.out.print("Enter your choice : ");
			ch = input.nextInt();
			switch (ch)
			{
				case 1:
				addChocolate();
				break;

				case 2:
				addSweet();
				break;

				default:
			}
		}while(ch!=3);
	}

	private void addChocolate()
	{
		String name;
		float price;
		float weight;

		System.out.println();
		System.out.println();
		System.out.println("Add Chocolate");
		System.out.print("Enter Chocolate name : ");
		input.nextLine();
		name = input.nextLine();
		System.out.print("Enter Chocolate price : ");
		price = input.nextFloat();
		System.out.print("Enter Chocolate weight : ");
		weight = input.nextFloat();
		
		if(isChocolateFull())
		{
			increaseChocolateCapacity();
			c[cIndex++] = new Chocolate(name,price,weight);
		}
		else
		{
			c[cIndex++] = new Chocolate(name,price,weight);	
		}
	}

	private void addSweet()
	{
		String name;
		float price;
		float weight;

		System.out.println();
		System.out.println();
		System.out.println("Add Sweets");
		System.out.print("Enter Sweet name : ");
		input.nextLine();
		name = input.nextLine();
		System.out.print("Enter Sweet price : ");
		price = input.nextFloat();
		System.out.print("Enter Sweet weight : ");
		weight = input.nextFloat();
		
		if(isSweetFull())
		{
			increaseSweetCapacity();
			s[sIndex++] = new Sweet(name,price,weight);
		}
		else
		{
			s[sIndex++] = new Sweet(name,price,weight);	
		}
	}

	public void displayItems()
	{
		int ch,i1=0,i2=0;
		System.out.println();
		System.out.println();
		System.out.println("Displaying items in basket ...");
		System.out.println("1. Display by price");
		System.out.println("2. Display by weight");
		System.out.print("Enter your choice : ");
		ch = input.nextInt();
		System.out.println();
		switch(ch)
		{
			case 1:
			if(!isChocolateEmpty())
				Arrays.sort(c, 0, cIndex, new SortChocolatePrice());
			if(!isSweetEmpty())
				Arrays.sort(s, 0, sIndex, new SortSweetPrice());
			while(i1<cIndex&&i2<sIndex)
			{
				if(c[i1].getPrice()<s[i2].getPrice())
				{
					System.out.println(c[i1].toString());
					i1++;
				}
				else
				{
					System.out.println(s[i2].toString());
					i2++;	
				}
			}
			while(i1<cIndex)
			{
				System.out.println(c[i1].toString());
				i1++;
			}
			while(i2<sIndex)
			{
				System.out.println(s[i2].toString());
				i2++;
			}
			break;

			case 2:
			if(!isChocolateEmpty())
				Arrays.sort(c, 0, cIndex, new SortChocolateWeight());
			if(!isSweetEmpty())
				Arrays.sort(s, 0, sIndex, new SortSweetWeight());
			while(i1<cIndex&&i2<sIndex)
			{
				if(c[i1].getWeight()<s[i2].getWeight())
				{
					System.out.println(c[i1].toString());
					i1++;
				}
				else
				{
					System.out.println(s[i2].toString());
					i2++;	
				}
			}
			while(i1<cIndex)
			{
				System.out.println(c[i1].toString());
				i1++;
			}
			while(i2<sIndex)
			{
				System.out.println(s[i2].toString());
				i2++;
			}
			break;
		}
	}

	public void displayChocolate()
	{
		int ch,ll,ul,i;
		System.out.println();
		System.out.println();
		System.out.println("Displaying chocolates in basket ...");
		System.out.println("1. Display by price");
		System.out.println("2. Display by weight");
		System.out.print("Enter your choice : ");
		ch = input.nextInt();
		switch(ch)
		{
			case 1:
			System.out.print("Enter lower limit : ");
			ll = input.nextInt();
			System.out.print("Enter upper limit : ");
			ul = input.nextInt();
			System.out.println();
			if(!isChocolateEmpty())
				Arrays.sort(c, 0, cIndex, new SortChocolatePrice());
			for(i=0;i<cIndex;++i)
			{
				if(ll<=c[i].getPrice()&&ul>=c[i].getPrice())
				{
					System.out.println(c[i].toString());
				}
			}
			break;

			case 2:
			System.out.print("Enter lower limit : ");
			ll = input.nextInt();
			System.out.print("Enter upper limit : ");
			ul = input.nextInt();
			System.out.println();
			if(!isChocolateEmpty())
				Arrays.sort(c, 0, cIndex, new SortChocolateWeight());
			for(i=0;i<cIndex;++i)
			{
				if(ll<=c[i].getWeight()&&ul>=c[i].getWeight())
				{
					System.out.println(c[i].toString());
				}
			}
			break;
		}
	}

	public void displaySweets()
	{
		int ch,ll,ul,i;
		System.out.println();
		System.out.println();
		System.out.println("Displaying sweets in basket ...");
		System.out.println("1. Display by price");
		System.out.println("2. Display by weight");
		System.out.print("Enter your choice : ");
		ch = input.nextInt();
		switch(ch)
		{
			case 1:
			System.out.print("Enter lower limit : ");
			ll = input.nextInt();
			System.out.print("Enter upper limit : ");
			ul = input.nextInt();
			System.out.println();
			if(!isSweetEmpty())
				Arrays.sort(s, 0, sIndex,new SortSweetPrice());
			for(i=0;i<sIndex;++i)
			{
				if(ll<=s[i].getPrice()&&ul>=s[i].getPrice())
				{
					System.out.println(s[i].toString());
				}
			}
			break;

			case 2:
			System.out.print("Enter lower limit : ");
			ll = input.nextInt();
			System.out.print("Enter upper limit : ");
			ul = input.nextInt();
			System.out.println();
			if(!isSweetEmpty())
				Arrays.sort(s, 0, sIndex, new SortSweetWeight());
			for(i=0;i<sIndex;++i)
			{
				if(ll<=s[i].getWeight()&&ul>=s[i].getWeight())
				{
					System.out.println(s[i].toString());
				}
			}
			break;
		}
	}
}
