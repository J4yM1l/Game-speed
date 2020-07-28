package com.speed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

import com.speed.cardfactory.CardFactory;
import com.speed.cardfactory.Player;
import com.speed.gameManager.GameManager;
import com.speed.gameManager.PlayersGenerator;

public class DemoGame {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// TODO Auto-generated method stub
		// You Ain't Gonna Need It YAGNI -- It's OPTIMISTIC		
		var<Card> cardDecks = new CardFactory().getCardDecks(); // generating the card deck
		ArrayList<Stack> setOfCards = null;
		Stack<Card> boardCards = new Stack<Card>();
		Stack<Card> auxillaryCardsStack = new Stack<Card>();
		Stack<Card> rescueCardsStack = new Stack<Card>();
		Stack<Card> activeCardStack = new Stack<Card>();
		HashMap<Integer,Card> PlayingCard  = new HashMap<Integer,Card>();
		//use a custom input method rather than passing the input obj
		setOfCards = buildSets(cardDecks,input);
		activeCardStack.addAll(setOfCards.get(0));
		auxillaryCardsStack.addAll(setOfCards.get(1));
		rescueCardsStack.addAll(setOfCards.get(2));
		boardCards.addAll(setOfCards.get(3));
		PlayingCard = buildPlayingCards(activeCardStack);
		int select = 0;
		String in = null;
		// Using Hashmap.forEach() 		
		
		while(!PlayingCard.isEmpty()) {		
		
//		PlayingCard.forEach((k, v) -> System.out.println(k + " : " + (v)));
		
		boolean updated = update(PlayingCard, boardCards,rescueCardsStack);
		while(updated) {
			updated = update(PlayingCard, boardCards,rescueCardsStack);
		}
		// handle letter input exception
		System.out.println("Make a Move ");
		in = input.next();
		try {
			
			select = Integer.parseInt(in); 
			
		}catch(NumberFormatException ex) {
			 System.out.println("Invalid Input");
//			 ex.printStackTrace();
		}
		
		cardSelection(select, PlayingCard,boardCards,auxillaryCardsStack,rescueCardsStack);
		
		}
		System.out.println("You WON!!");
		input.close();
	}
	
	public static boolean update(HashMap<Integer,Card> pc, Stack<Card> boardCards,Stack<Card> rescueCards) {
//		int topCardVal = convertValue(tc.getVal());
//		int pcv = convertValue(tc.getVal());
		Card topCard = boardCards.peek();
//		System.out.println("Current Card "+topCard);
//		System.out.println("Card size "+pc.size());
		int count = 0;
		boolean isUpdated = false;
		//instead of diplaying all the cards in the boardstack, jst peek the top
		//value and display
//		boardCards.forEach(bc -> System.out.println(bc));
		System.out.println("==============================================");
		System.out.println(topCard);
		System.out.println("==============================================");
		for(Map.Entry element: pc.entrySet()) {			
			Card pCard = (Card) element.getValue();
			int key = (int) element.getKey();
			int pcv = convertValue(pCard.getVal());
			int bcv = convertValue(topCard.getVal());			
			System.out.println(key+": "+pCard );
//			System.out.println();
//			System.out.println("Counted "+count+" PCV "+pcv+" upperBound "+(bcv+1)+" lowerBound "+(bcv-1));
			if((pcv == (bcv+1) || pcv == (bcv-1))) {
				
//				return isUpdated;
				count++;
				
			}			
						
		}
		if(count == 0 && (!rescueCards.isEmpty())) {
//			System.out.println("Played with rescue card");
			boardCards.add(rescueCards.pop());
//			System.out.println("Added ");	
//			System.out.println("rscueCard size "+ rescueCards.size());
//			System.out.println("boardCards size after "+ boardCards.size());
			isUpdated = true;
//			System.out.println("IsUpdated: "+isUpdated);
			}else {
				isUpdated = false;
				return isUpdated;
			}
		
		return isUpdated;
						
	}

	public static Stack<Card> cardSelection(int k, HashMap<Integer,Card> PlayingCard, Stack<Card> leftCard, 
			Stack<Card> auxCard,Stack<Card> rscueCard) {		
		Stack<Card> rightCard = new Stack<Card>();
		Stack<Card> LRCards = new Stack<Card>();
//		System.out.println("bcv+1%13 "+(0+1%13));
//		System.out.println("bcv-1%13 "+(0-0%13));
//		System.exit(0);
		//iterating thru the list of cards
//		Set<Entry<Integer, Card>> playCard = PlayingCard.entrySet();
//		Iterator<Entry<Integer, Card>> itr = PlayingCard.entrySet().iterator();
//		while(itr.hasNext()) {
//			Entry<Integer, Card> cardElement = itr.next();
//			int key = cardElement.getKey();
			//Task: Hanndle if a wrong key value was selected => Done!			
			Card card = PlayingCard.get(k);//cardElement.getValue();
			if(card !=null) {
//				rightCard.add(leftCard.pop());
				Card lBCard0 = leftCard.peek();
//				Card rBCard1 = leftCard.peek();
				int cardVal = convertValue(card.getVal());//converting playing card property string value to int. eg A->0, K->11 ...
				int bcv = convertValue(lBCard0.getVal()); //converting board card property string value to int. eg A->0, K->11 ...;									
//				int brdVal = convertValue(rBCard1.getVal());//boardCard.pop().getVal();			
				System.out.println("Played card");
//				System.out.println(card);
				System.out.println("BCV "+ bcv);
				System.out.println("CV+ "+cardVal+" bcv+1%13 "+(bcv+1%13));
				System.out.println("CV- "+cardVal+" bcv-1%13 "+(bcv-1%13));
				if((cardVal == ((bcv+1)%13) || cardVal == ((bcv-1)%13))) {
//					System.out.println("bcv+1%13 "+(bcv+1%13));
//					System.out.println("bcv-1%13 "+(bcv-1%13));
//					System.out.println("Board card");
//					System.out.println("->"+leftCard.peek());
					leftCard.add(card);
//					System.out.println("leftCard size before "+ leftCard.size());
					PlayingCard.remove(k, card);
					
					if(!auxCard.isEmpty()) {
					PlayingCard.put(k, auxCard.pop());
//					System.out.println("auxCard size "+ auxCard.size());
					}
//					LRCards.addAll(leftCard);
					return leftCard;
//					break;
				}
				if(rscueCard.isEmpty()) {
//				System.out.println("bcv+1%13 After "+((bcv+1)%13));
//				System.out.println("bcv-1%13 After "+((bcv-1)%13));
				System.out.println("You Lost!");
				//instead of exit jst throw and exception
				System.exit(0);
				}
//				else if((cardVal == (brdVal+1%13) || cardVal == (brdVal-1%13))){
//					System.out.println("Board card");					
//					leftCard.add(card);
//					PlayingCard.remove(key, card);
//					System.out.println(rightCard.peek());
//					LRCards.addAll(rightCard);
//					return LRCards;
////					break;
//				}
				
//				if(!rscueCard.isEmpty()) {
//				leftCard.add(rscueCard.pop());
				
//				}
				System.out.println("Illegal moves!");	
				System.out.println("Hurry Up!");	
//				break;
			}else {
			System.out.println("card is Null");
//			break;
		}
		return leftCard;
	}
	
	 public static HashMap<Integer, Card> buildPlayingCards(Stack<Card> activeCardStack) {
		 int size = activeCardStack.size();
		 HashMap<Integer,Card> activePlayingCard  = new HashMap<Integer,Card>();
		 //transfer of cards from stack to a map with it key
			for(int i = 0; i< size; i++) {			
				Card card = activeCardStack.pop();
				int key = (i+1);
				activePlayingCard.put(key,card);						
			}	
			
		return activePlayingCard;
		
	}
	
	@SuppressWarnings("rawtypes")
	public static ArrayList buildSets(ArrayList<Card> cardDecks, Scanner sc) {
		Scanner in = sc;
		Stack<Card> auxillaryCards = new Stack<Card>();
		Stack<Card> rescueCards = new Stack<Card>();
		Stack<Card> activeCard = new Stack<Card>();
		Stack<Card> dashBoardCards = new Stack<Card>();
		ArrayList<Stack> stackSet = new ArrayList<Stack>();
		HashMap<String, Player> players = new HashMap<String, Player>(); // maps players with their cards
		Player p = null;
		/*
		 * Currently game can only generate game cards accurately for one or two players
		 * Fetch number of players to start the game
		 */
		System.out.print("Number of Players: ");
		int numOfPlayers; // input variable;
		
		// validate user input for only numbers else notify user
		if (in.hasNextInt()) {
			// try {
			// Integer.parseInt(players);
			numOfPlayers = in.nextInt();
			System.out.println(numOfPlayers + " players in the game");
			GameManager gm = new GameManager(cardDecks); // manage cards for each player
			players = PlayersGenerator.createPlayer(numOfPlayers, gm); // create x number of players
			Set<Entry<String, Player>> playersSet = players.entrySet();
			Iterator<Entry<String, Player>> itr = playersSet.iterator();
			while (itr.hasNext()) {
				Entry<String, Player> playerElement = itr.next();
				// System.out.print(element.getKey() + ": ");
				p = playerElement.getValue();
				// String playerName = p.getPlayerName();
				
				//creating two sets of cards: auxillaryCards sets and activeCards set 
				for (int i = 0; i < 5; i++) {
					auxillaryCards.add(p.getfallBackCards().get(i));
					activeCard.add(p.getPlayingCards().get(i));
					
				}

				for (int j = 0; j < p.getTotalPlayingCards().size(); j++) {
					// System.out.println(p.getTotalPlayingCards().get(j));
					rescueCards.add(p.getTotalPlayingCards().get(j));
					// System.out.println(auxillaryCards.get(j));
				}

			}
			try {
				gm.setDashBoard().forEach(c -> dashBoardCards.add(c));
			} catch (Exception e) {
				// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			}
			
			stackSet.add(activeCard);
			stackSet.add(auxillaryCards);
			stackSet.add(rescueCards);
			stackSet.add(dashBoardCards);
//			System.out.println("Rescue cards ");			 
			 
			// }catch(NumberFormatException ex) {
			// System.out.println("Invalid Input");
			// }
		} else {
			System.out.println("Invalid Input");
		}

		in.close();
		return stackSet;
	}
	
	public static int convertValue(String strVal) {
		int cardVal;		
		switch(strVal) {
		case "A" :
			cardVal = 1;			
			break;
		case "K" : 
			cardVal = 11;				
			break;
		case "Q" : 
			cardVal = 12;				
			break;
		case "J" : 
			cardVal = 13;				
			break;
		default  : 
			cardVal = Integer.parseInt(strVal);				
			break;
			
		}
		return cardVal;
		
	}

}
