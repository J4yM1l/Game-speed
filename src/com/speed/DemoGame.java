package com.speed;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.speed.cardfactory.CardFactory;
import com.speed.cardfactory.Player;
import com.speed.gameManager.GameManager;
import com.speed.gameManager.PlayersGenerator;

public class DemoGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		You Ain't Gonna Need It YAGNI -- It's OPTIMISTIC
		Scanner in = new Scanner(System.in);		
		var<Card> cardDecks = new CardFactory().getCardDecks(); //generating the card deck							
		HashMap<String, Player> players = new HashMap<String, Player>(); //maps players with their cards		
		//Currently game can only generate game cards accurately for one or two players
		//Fetch number of players to start the game
		System.out.print("Number of Players: ");		
		int numOfPlayers; //= in.nextLine();
		//validate user input for only numbers else notify user
		if(in.hasNextInt()) {
//			try {
//				Integer.parseInt(players);
				numOfPlayers = in.nextInt();
				System.out.println(numOfPlayers+" players in the game");
				GameManager gm = new GameManager(cardDecks); //manage cards for each player
				players = PlayersGenerator.createPlayer(numOfPlayers, gm); //create x number of players 				
				Set<Entry<String, Player>> set = players.entrySet();
				Iterator<Entry<String, Player>> itr = set.iterator();
				while(itr.hasNext()) {
					Entry<String, Player> element = itr.next();
					System.out.print(element.getKey() + ": ");
					Object p = element.getValue();
			        System.out.println(p);
					
				}
				System.out.println();
				
//			}catch(NumberFormatException ex) {
//				System.out.println("Invalid Input");
//			}
		}else {
			System.out.println("Invalid Input");
		}
					 			
		in.close();	
	}

}
