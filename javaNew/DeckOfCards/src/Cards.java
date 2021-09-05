import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Cards {
    
    private List<Deck> deck;
    private List<Deck> usedCards;
    private List<Deck> sortedDeck;
    private ArrayList<Deck> dealCards;

    public Cards() {
        deck = new ArrayList<Deck>();
        sortedDeck = new ArrayList<Deck>();
        usedCards = new ArrayList<Deck>();
    }

    public boolean createDeck() {
        List<String> validFaceNames = Deck.getValidFaceNames();
        List<String> validSuitNames = Deck.getValidSuitNames();
        if (!deck.isEmpty()) {
            deck.clear();
            usedCards.clear();
        }
        for (String faces : validFaceNames)
            for (String suits : validSuitNames)
                deck.add(new Deck(faces, suits));
        shuffleDeck();
        return true;
    }

    public void printDeck() {
        if (deck.isEmpty()) {
            System.out.println("\nCreate a deck first");
            return;
        }
        System.out.println("\nThe deck is");
        for (Deck d : deck) 
            System.out.println(d);
    }

    public void printSortedDeck() {
        for (Deck i : sortedDeck)
            System.out.println(i);
    }

    public void sortDeck() {
        sortedDeck.clear();
        for (Deck i : deck)
            sortedDeck.add(i);
        List<String> faceNames = Deck.getValidFaceNames();
        Collections.sort(sortedDeck, new Comparator<Deck>() {
            @Override
            public int compare(Deck card1, Deck card2) {
                int card1Value = faceNames.indexOf(card1.getFaceName());
                int card2Value = faceNames.indexOf(card2.getFaceName());
                return card1Value - card2Value;
            }
        });
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public Deck printCard() {
        Deck d = deck.get(0);
        deck.remove(d);
        usedCards.add(d);
        return d;
    }

    public Deck sameCard() {
        System.out.println("\nThe last used card is "+ usedCards.get(usedCards.size() - 1));
        String usedCardFaceName = usedCards.get(usedCards.size() - 1).getFaceName();
        String usedCardSuitName = usedCards.get(usedCards.size() - 1).getSuitName();
        for (Deck i : deck) {
            if (i.getFaceName().equals(usedCardFaceName)) {
                if (i.getSuitName().equals(usedCardSuitName))
                    continue;
                else {
                    usedCards.add(i);
                    deck.remove(i);
                    return i;
                }
            }
        }
        return null;
    }

    public List<Deck> dealCards() {
        dealCards = new ArrayList<Deck>();
        for (int i = 0; i < 5; i++) {
            dealCards.add(deck.get(i));
            usedCards.add(deck.get(i));
            deck.remove(usedCards.get(usedCards.size() - 1));
        }
        return dealCards;
    }

    public void printUsedCards() {
        System.out.println("\nThe used cards are ");
        for (Deck i : usedCards) 
            System.out.println(i);
    }

    public void compareCards() {
        Deck card1 = deck.get(0);
        Deck card2 = deck.get(1);
        deck.remove(card1);
        deck.remove(card2);
        usedCards.add(card1);
        usedCards.add(card2);
        List<String> faceNames = Deck.getValidFaceNames();
        int card1Value = faceNames.indexOf(card1.getFaceName());
        int card2Value = faceNames.indexOf(card2.getFaceName());
        System.out.println("\nThe first two cards from the deck are");
        System.out.println("Card 1 -> "+ card1);
        System.out.println("Card 2 -> "+ card2);
        if (card1Value > card2Value)
            System.out.println("Card 1 is greater than Card 2");
        else if (card1Value < card2Value)
            System.out.println("Card 1 is less than Card 2");
        else
            System.out.println("Card 1 and Card 2 are equal");
    }

    public void findCard(String faceName, String suitName) {
        boolean isPresentOnDeck = false;
        for (Deck i : deck) {
            if (i.getFaceName().equals(faceName) && i.getSuitName().equals(suitName)) {
                System.out.println("\n"+ faceName +" of "+ suitName +" is present on the deck");
                isPresentOnDeck = true;
                break;
            }
        }
        if (!isPresentOnDeck) {
            for (Deck i : usedCards) {
                if (i.getFaceName().equals(faceName) && i.getSuitName().equals(suitName)) {
                    System.out.println("\n"+ faceName +" of "+ suitName +" has been used");
                    break;
                }
            }
        }
    }
}
