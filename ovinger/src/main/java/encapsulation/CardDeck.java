package encapsulation;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
	
	public List<Card> cardDeck = new ArrayList<>();
	
	private char[] suits = {'S', 'H', 'D', 'C'};

	
	public CardDeck(int n) {
		for (int j = 0; j < suits.length; j++) {
			for (int i = 1; i < n+1; i++) {
				Card card = new Card(suits[j],i);
				cardDeck.add(card);
			}
		}
	}
	
	public Integer getCardCount() {
		return cardDeck.size();
	}
	
	public Card getCard(int n) {
		if (n < 0 || n >= cardDeck.size() ) {
			throw new IllegalArgumentException("Ber om kort som ligger utenfor kortstokken");
		}
		return cardDeck.get(n);
}
	
	public void shufflePerfectly() {
		List<Card> newCardDeck = new ArrayList<>();
		newCardDeck.add(cardDeck.get(0));
		
		List<Card> middleElements = new ArrayList<> (cardDeck.subList(1, cardDeck.size()-1));
		
		List<Card> firstMiddleElements = new ArrayList<> (middleElements.subList(0, middleElements.size()/2));
		List<Card> lastMiddleElements = new ArrayList<> (middleElements.subList(middleElements.size()/2, middleElements.size()));
		
		for (int i = 0; i < firstMiddleElements.size(); i++) {
			newCardDeck.add(lastMiddleElements.get(i));
			newCardDeck.add(firstMiddleElements.get(i));
		}
		newCardDeck.add(cardDeck.get(cardDeck.size()-1));
		cardDeck = newCardDeck;
	}
	
	
	public static void main(String[] args) {

	}
}





