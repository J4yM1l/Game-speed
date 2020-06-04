package com.speed.cardfactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.speed.Card;

public class CardFactory {
	
	private List<Card> spades = new ArrayList<Card>();	

	public List<Card> getSpades() {
		var cardValues = List.of("A","2","3","4","5","6","7","8","9","10","K","Q","J");
		var cardTypes = List.of("Spade", "Club","Heart","Diamond");
		String color[] = {"Black","Red"};
		cardColor: for (int c = 0; c < color.length; c++) {
			
			types: for (int aType = 0; aType < cardTypes.size(); aType++) {
			
			if(color[c].equals("Black") && (cardTypes.get(aType).equals("Heart") || cardTypes.get(aType).equals("Diamond"))){
				continue cardColor;
			}else if(color[c].equals("Red") && (cardTypes.get(aType).equals("Spade") || cardTypes.get(aType).equals("Club")))
			{
				continue types;
			}
			for(String value: cardValues) {

					spades.add(new Card(color[c], cardTypes.get(aType), value));			
			}
		}
	}
		return spades;
	}
	
	public int testing(int a, int b) {
	
		return a+b;
	}
	
	public List<Card> testList(Card t1, Card t2, Card t3){//		
		List<Card> tstLst = Arrays.asList(t1,t2,t3);
		return tstLst;
	}

//	@Override
//	public String toString() {
//		return "Spade [spades=" + spades + "]";
//	}	
	
	
	
	
	

}
