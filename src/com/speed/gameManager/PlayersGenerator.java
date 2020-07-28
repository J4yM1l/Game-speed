package com.speed.gameManager;
import java.util.ArrayList;
import java.util.HashMap;
import com.speed.Card;
import com.speed.cardfactory.Player;

public class PlayersGenerator {
	
	public static HashMap<String, Player> createPlayer(int numOfPlayers, GameManager gm){
		HashMap<String,Player> players = new HashMap<String, Player>(2);
		ArrayList<Card> totalPlayingCards;
		ArrayList<Card> playingCards;
		ArrayList<Card> fallBackCards;
		for(int i = 0; i< numOfPlayers; i++) {			
			totalPlayingCards = gm.getTotalPlayingCards();
			playingCards = gm.getPlayingCards();
			fallBackCards = gm.getfallBackCards();
			
			String pName = "Player"+(i+1);
			players.put(pName, new Player(playingCards,
					totalPlayingCards,fallBackCards,pName));			
		}
		return players;
	}

}
