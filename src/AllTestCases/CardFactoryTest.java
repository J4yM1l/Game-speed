package AllTestCases;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import com.speed.Card;
import com.speed.cardfactory.CardFactory;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class CardFactoryTest {

	CardFactory cf = new CardFactory();
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	
	@Test
	public void testing() {
		
		int a = 4;
		int b = 2;
		int actual = cf.testing(a,b);
		int expected = 6; 
		assertEquals("Running test case ",expected, actual);
	}
	
	@Test
	public void testList() {
		
		Card a1 = new Card("Black", "Spade","A");
		Card a2 = new Card("Red", "Heart","2");
		Card a3 = new Card("Black", "Club","3");
		
		List<Card> actual = cf.testList(a1, a2, a3);//(a1,a2,a3);
		List<Card> expected = Arrays.asList(a1, a2, a3);
		
		//1. Test equal.
		assertThat("Testing a List ",actual, is(expected));
		
		//2. If List has this value?
		assertThat("Testing a List for an item",actual, hasItems(a1));
		//3. Check List Size		
		 assertThat(actual.size(), is(3));
		 			
	}
	
	@Test
	public void getSpades() {
		Card c1 = new Card("Black", "Spade","A");
		Card c2 = new Card("Red", "Heart","2");
		Card c3 = new Card("Black", "Club","3");		
		var actual = List.of(c1, c2, c3);
		var expected = Arrays.asList(c1, c2, c3);
		
		assertThat("List of cards ",actual, is(expected));
		
		//3. Check List Size
		assertThat("Get spades size",cf.getSpades().size(), is(52));
	}

}
