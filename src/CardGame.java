import java.util.*;

public class CardGame {
    List<Card> deckOfCards = new ArrayList<Card>();
    public CardGame(){
        initializeDeck();
        shuffleDeck();
    }
    public void initializeDeck(){
        final String[] SUIT = {"heart","club","diamond","spade"};
        final int[] CARD_VALUES = {1,2,3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        final String[] CARD_SYMBOLS= {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        for(int i = 0; i<CARD_VALUES.length*4; i++){
            deckOfCards.add(new Card(CARD_VALUES[i%13], SUIT[(int) Math.floor(deckOfCards.size()/13)], CARD_SYMBOLS[i%13]));
        }
    }
    public Card dealCard(){
        return this.deckOfCards.get(0);
    }
    public List<Card> shuffleDeck(){
        Collections.shuffle(this.deckOfCards);
        return this.deckOfCards;
    }
    public List<Card> sortDeckByNumberOrder(){
        shuffleDeck();
        Collections.sort(this.deckOfCards, Comparator.comparingInt(Card::getNumber));
        System.out.println(this.deckOfCards.toString());
        return this.deckOfCards;
    }
    public List<Card> getDeck(){
        return this.deckOfCards;
    }
    public List<Card> sortDeckBySuits(){
        shuffleDeck();
        Collections.sort(this.deckOfCards, Comparator.comparing(Card::getSuit));
        System.out.println(this.deckOfCards.toString());
        return this.deckOfCards;
    }
}

