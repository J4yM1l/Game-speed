package com.speed.gameManager;

import java.util.ArrayList;
import java.util.Collections;
import com.speed.Card;

public class GameManager {
		
	private ArrayList<Card> decks;	
	private ArrayList<Card> reshuffledCard;
	private ArrayList<Card> totalPlayingCards = new ArrayList<Card>(25);	
	private ArrayList<Card> dashBoard = new ArrayList<Card>(27);
	public GameManager(ArrayList<Card> decks) {
//		super();		
		this.decks = decks;
		this.reshuffledCard = reshuffleCards(this.decks);
		
	}
	
	
	public GameManager() {
//		super();
		// TODO Auto-generated constructor stub
	}


	public ArrayList<Card> getTotalPlayingCards() {
		while(!(this.reshuffledCard.isEmpty()) && totalPlayingCards.size()<25) {
			totalPlayingCards.add(this.reshuffledCard.get(0));			
			this.reshuffledCard.remove(0);			
		}			
		
		return totalPlayingCards;
	}
	
	
	public ArrayList<Card> getPlayingCards() {
		ArrayList<Card> playingCards = new ArrayList<Card>(5);
		int count = 0;
		while(!(totalPlayingCards.isEmpty()) && count<5) {			
			playingCards.add(totalPlayingCards.get(0));			
			totalPlayingCards.remove(0);
			count++;
		}		
		return playingCards;
	}
	
	public ArrayList<Card> getfallBackCards() {
		ArrayList<Card> fallBackCards = new ArrayList<Card>(5);		
		int count = 0;
		while(!(totalPlayingCards.isEmpty()) && count<5) {			
			fallBackCards.add(totalPlayingCards.get(0));			
			totalPlayingCards.remove(0);
			count++;
		}			
		return fallBackCards;
	}
	
	public ArrayList<Card> setDashBoard() throws Exception {
		
		if(dashBoard.isEmpty()) {
			dashBoard.add(reshuffledCard.get(0));
//			dashBoard.add(reshuffledCard.get(1));
			reshuffledCard.remove(0);
//			reshuffledCard.remove(1);
			return dashBoard;
		}		
		
		throw new Exception("Cards already on dashboard");
	}
	public void setDashBoard(Card aCard) {
		if(!dashBoard.isEmpty()) {
			this.dashBoard.add(aCard);
		}else {
			System.out.println("DashBoard card is Full");			
		}
		
	}
	
	private ArrayList<Card> reshuffleCards(ArrayList<Card> cDeck){
		Collections.shuffle(cDeck);
		return cDeck;
		
	}
	
	
	

}
