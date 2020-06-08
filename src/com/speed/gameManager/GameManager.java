package com.speed.gameManager;

import java.util.ArrayList;
import java.util.Collections;
import com.speed.Card;

public class GameManager {
		
	private ArrayList<Card> decks;	
	private ArrayList<Card> reshuffledCard;
	private ArrayList<Card> totalPlayingCards = new ArrayList<Card>(25);	
	
	public GameManager(ArrayList<Card> decks) {
//		super();		
		this.decks = decks;
		this.reshuffledCard = reshuffleCards(this.decks);
		
	}
	
	
	public GameManager() {
		super();
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
	
	public ArrayList<Card> getDashBoard() {
		ArrayList<Card> dashBoard = new ArrayList<Card>(2);
		while(!(totalPlayingCards.isEmpty()) && dashBoard.size()<2) {
			dashBoard.add(totalPlayingCards.get(0));
			totalPlayingCards.remove(0);
		}		
		
		return dashBoard;
	}
//	public void setDashBoard(List<Card> dashBoard) {
//		this.dashBoard = dashBoard;
//	}
	
	private ArrayList<Card> reshuffleCards(ArrayList<Card> cDeck){
		Collections.shuffle(cDeck);
		return cDeck;
		
	}
	
	
	

}
