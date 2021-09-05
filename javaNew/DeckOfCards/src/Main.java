import java.util.Scanner;
import java.util.List;

public class Main {
    private static Cards deck = new Cards();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        String choice;
        printDeckDetails();
        System.out.println("\nEverytime a deck is created it will be shuffled"+
                            "\nThe cards used will be removed from the deck and"+ 
                            " be inserted into the used deck"+
                            "\nWhen a new deck will be created, the used cards deck"+
                            " will also be reset");
        while (!exit) {
            printMenu();
            System.out.print("Enter your choice number: ");
            System.gc();
            choice = sc.nextLine();
            switch(choice) {
                case "1":
                    System.out.println("\nThe deck has been created");
                    deck.createDeck();
                    break;
                case "2":
                    deck.printDeck();
                    break;
                case "3":
                    System.out.println("\nThe first card from the deck is "
                                + deck.printCard());
                    break;
                case "4":
                    dealCards();
                    break;
                case "5":
                    System.out.println("The equivalent card is "
                    + deck.sameCard());
                    break;
                case "6":
                    deck.compareCards();
                    break;
                case "7":
                    System.out.println("\nThe sorted deck is");
                    deck.sortDeck();
                    deck.printSortedDeck();
                    break;
                case "8":
                    deck.shuffleDeck();
                    break;
                case "9":
                    deck.printUsedCards();
                    break;
                case "10":
                    findCard();
                    break;
                case "11":
                    exit = true;
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("\n1. Create deck"+
                            "\n2. Print deck"+
                            "\n3. Print Card"+
                            "\n4. Deal first five cards from the deck"+
                            "\n5. Print equivalent card to last used card"+
                            "\n6. Compare first two cards on the deck"+
                            "\n7. Sort the deck"+
                            "\n8. Shuffle the deck"+
                            "\n9. Show all the cards that were used"+
                            "\n10. Find card"+
                            "\n11. exit");
    }

    public static void dealCards() {
        System.out.println("\nFirst five cards from the deck are");
        List<Deck> deal = deck.dealCards();
        for (Deck i : deal) 
            System.out.println(i);
    }

    public static void printDeckDetails() {
        List<String> faceNames = Deck.getValidFaceNames();
        List<String> suitNames = Deck.getValidSuitNames();
        System.out.println("\nIn a deck of cards,  there are 4 suits and 52 cards"+
                            " of various ranks. Each suit has all the 13 ranks.");
        System.out.println("The suits are "+ suitNames);
        System.out.println("The ranks are "+ faceNames + "\n");
    }

    public static void findCard() {
        String face, suit;
        System.out.println("\nEnter face name of the card to be searched: ");
        face = sc.nextLine();
        System.out.println("Enter suit name of the card to be searched: ");
        suit = sc.nextLine();
        deck.findCard(face, suit);
    }
}
