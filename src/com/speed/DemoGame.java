package com.speed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.speed.cardfactory.CardFactory;
import com.speed.cardfactory.Player;
import com.speed.gameManager.GameManager;

public class DemoGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		var cardDecks = new ArrayList<Card>();		
		CardFactory cardFactory = new CardFactory();			
		cardDecks = (ArrayList<Card>) cardFactory.getSpades();
		System.out.println("Card Size: "+cardDecks.size());
		GameManager gm = new GameManager(cardDecks);
		Player pl = new Player();
		//List<Player> players;
		HashMap<String, Player> map = new HashMap<String, Player>();
		System.out.println("Original Cards size ");
		System.out.println("Number of Players");		
		int players; //= in.nextLine();
		if(in.hasNextInt()) {
//			try {
//				Integer.parseInt(players);
				players = in.nextInt();
				System.out.println("Valid Input "+ players);
				for(int i = 0; i< players; i++)
					//players.Add(new Player());
					//
					pl.setPlayerName("p"+(i+1));
					pl.setTotalPlayingCards(gm.getTotalPlayingCards());
					pl.setPlayingCards(gm.getPlayingCards());
					map.put(pl.getPlayerName(), pl);
//				}
				System.out.println("Player Details"+ map);
//			}catch(NumberFormatException ex) {
//				System.out.println("Invalid Input");
//			}
		}else {
			System.out.println("Invalid Input");
		}
		
		
		// You Ain't Gonna Need It YAGNI -- It's OPTIMISTIC		
//		Collections.shuffle(cardDecks);
//		System.out.println("Shuffled Cards ");
//		cardDecks.forEach(car -> {
//			
//		System.out.println(car);
//			
//		});
		
		

	}

}
