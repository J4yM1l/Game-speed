package com.speed.cardfactory;

import java.util.ArrayList;
import java.util.List;

import com.speed.Card;

public class Heart {
	
	private List<Card> heart = new ArrayList<>();
	
	public List<Card> getHearts(){
		String attributes [] = {"A","2","3","4","5","6","7","8","9","10","K","Q","J"};
		for(int i = 0; i<attributes.length; i++) {
		Card card = new Card("Red", "Heart", attributes[i]);
		heart.add(card);
		}
		return heart;
	}

	@Override
	public String toString() {
		return "Heart [heart=" + heart + "]";
	}
	
}
