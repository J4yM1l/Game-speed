package com.speed.gameManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.speed.Card;
import com.speed.cardfactory.Player;

public class GameManager {
	
	private int numberOfPlayers;
	private List<Card> decks;
	private Player player;
	private List<Card> dashBoard = new ArrayList<Card>();
	private List<Card> reshuffledCard;
	private List<Card> totalPlayingCards = new ArrayList<Card>();
	private List<Card> playingCards = new ArrayList<Card>();
	public GameManager(List<Card> decks) {
		super();
//		this.numberOfPlayers = numberOfPlayers;
		this.decks = decks;
		this.reshuffledCard = reshuffleCard(this.decks);
		
	}
	
	
	public GameManager() {
		super();
		// TODO Auto-generated constructor stub
	}


	public List<Card> getTotalPlayingCards() {
		for(int i = 0; i<20; i++) {
			totalPlayingCards.add(this.reshuffledCard.get(i));
			this.reshuffledCard.remove(i);
		}
		return totalPlayingCards;
	}
	
	public List<Card> getPlayingCards() {
		for(int i = 0; i<5; i++) {
			playingCards.add(totalPlayingCards.get(i));
			totalPlayingCards.remove(i);
		}		
		return playingCards;
	}
	public List<Card> getDashBoard() {
		
		return dashBoard;
	}
	public void setDashBoard(List<Card> dashBoard) {
		this.dashBoard = dashBoard;
	}
	
	private List<Card> reshuffleCard(List<Card> cDeck){
		Collections.shuffle(cDeck);
		return cDeck;
		
	}
	
	
	

}
