package com.speed.cardfactory;

import java.util.ArrayList;
import java.util.List;

import com.speed.Card;

public class Club {
	
	private List<Card> clubs;
	private int numberOfPlayers;
	
	
	
	public List<Card> getClubs() {
		String attributes [] = {"A","2","3","4","5","6","7","8","9","10","K","Q","J"};
		for(int i = 0; i<attributes.length; i++) {
		Card card = new Card("Black", "Club", attributes[i]);
		clubs.add(card);
		}
		return clubs;
	}

	@Override
	public String toString() {
		return "Club [clubs=" + clubs + "]";
	}
	
	

}
