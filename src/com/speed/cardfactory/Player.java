package com.speed.cardfactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.speed.Card;

public class Player {
	
	private List<Card> playingCards;
	private List<Card> totalPlayingCards;
	private List<Card> fallBackCards;
	private String playerName;
	public Player(List<Card> playingCards, List<Card> totalPlayingCards, List<Card> fallBackCards, String playerName) {
		super();
		this.playingCards = playingCards;
		this.totalPlayingCards = totalPlayingCards;
		this.fallBackCards = fallBackCards;
		this.playerName = playerName;
	}
	
	
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}


	public List<Card> getPlayingCards() {
		return playingCards;
	}
	public void setPlayingCards(List<Card> playingCards) {
		this.playingCards = playingCards;
	}
	public List<Card> getTotalPlayingCards() {
		return totalPlayingCards;
	}
	public void setTotalPlayingCards(List<Card> totalPlayingCards) {
		this.totalPlayingCards = totalPlayingCards;
	}
	public List<Card> getfallBackCards() {
		return fallBackCards;
	}
	public void setfallBackCards(List<Card> backUpCards) {
		this.fallBackCards = backUpCards;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}


	@Override
	public String toString() {
		return "Player [playingCards=" + playingCards + ", totalPlayingCards=" + totalPlayingCards + ", fallbackCards="
				+ fallBackCards + ", playerName=" + playerName + "]";
	}
	
	
	

	
}
