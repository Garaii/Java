/**
 * Your name here:
 * Your McGill ID here:
 **/
package assignment2;

import java.util.Random;

public class Deck {
    public static String[] suitsInOrder = {"clubs", "diamonds", "hearts", "spades"};
    public static Random gen = new Random();

    public int numOfCards; // contains the total number of cards in the deck
    public Card head; // contains a pointer to the card on the top of the deck

    /*
     * TODO: Initializes a Deck object using the inputs provided
     */

    public Deck(int numOfCardsPerSuit, int numOfSuits) {
        /**** ADD CODE HERE ****/

        if (numOfCardsPerSuit < 1 || numOfCardsPerSuit > 13) {
            throw new IllegalArgumentException("Invalid number of cards per suit");
        }
        if (numOfSuits < 1 || numOfSuits > suitsInOrder.length) {
            throw new IllegalArgumentException("Invalid number of suits");
        }
        //head = new PlayingCard("club", 1);
        numOfCards = 0;
        Card curr = null;

        for(int i = 0 ;i< numOfSuits; i++){
            for (int j = 1; j <= numOfCardsPerSuit; j++){

                Card newCard = new PlayingCard(suitsInOrder[i],j );
                if (head==null){
                    head = newCard;
                    curr = newCard;
                    head.prev = curr;
                    head.next = curr;
                }else{
                    curr.next = newCard;
                    newCard.prev = curr;
                    curr = newCard;
                }
                numOfCards++;
            }
        }
            Card redJoker = new Joker("red");
            curr.next = redJoker;
            redJoker.prev = curr;
            curr = redJoker;
            numOfCards++;


            Card blackJoker = new Joker("black");
            curr.next = blackJoker;
            blackJoker.prev = curr;
            curr = blackJoker;
            numOfCards++;

            curr.next = head;
            head.prev = curr;


    }

    /*
     * TODO: Implements a copy constructor for Deck using Card.getCopy().
     * This method runs in O(n), where n is the number of cards in d.
     */
    public Deck(Deck d) {
        /**** ADD CODE HERE ****/

        this.numOfCards = d.numOfCards;
        this.head = d.head.getCopy();
        Card curr = this.head;
        Card dCurr = d.head.next;


        for (int i = 1; i < d.numOfCards; i++) {
            curr.next = dCurr.getCopy();
            curr.next.prev = curr;
            curr = curr.next;
            dCurr = dCurr.next;
        }

        curr.next = this.head;
        this.head.prev = curr;

    }

    /*
     * For testing purposes we need a default constructor.
     */
    public Deck() {}

    /*
     * TODO: Adds the specified card at the bottom of the deck. This
     * method runs in $O(1)$.
     */
    public void addCard(Card c) {
        /**** ADD CODE HERE ****/
        if (head == null) {
            head = c;
            head.next = head;
            head.prev = head;
            numOfCards++;
        } else {
            Card curr = head.prev;
            curr.next = c;
            c.prev = curr;
            c.next = head;
            head.prev = c;
            numOfCards++;
        }
    }

    /*
     * TODO: Shuffles the deck using the algorithm described in the pdf.
     * This method runs in O(n) and uses O(n) space, where n is the total
     * number of cards in the deck.
     */
    public void shuffle() {
        /**** ADD CODE HERE ****/

        Card[] cards = new Card[numOfCards];
        Card curr = head;
        if (head != null){
        for (int i = 0; i<numOfCards; i++){
            cards[i] = curr;
            curr = curr.next;
        }

        for (int i = numOfCards-1; i>0 ; i--){
            int j = gen.nextInt(i+1);
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
        head = cards[0];
        curr = head;
        for (int i = 1; i < numOfCards; i++) {
            //System.out.println(curr.toString());
            curr.next = cards[i];
            curr.next.prev = curr;
            curr = curr.next;
        }
        curr.next = head;
        head.prev = curr;}

    }

    /*
     * TODO: Returns a reference to the joker with the specified color in
     * the deck. This method runs in O(n), where n is the total number of
     * cards in the deck.
     */
    public Joker locateJoker(String color) {
        /**** ADD CODE HERE ****/
        Card curr = head;
        for ( int i = 0; i< numOfCards; i++){
            if ( curr instanceof Joker && ((Joker) curr).getColor().equals(color) ){

                return (Joker) curr;
                }
            curr = curr.next;
        }
        return null;
    }

    /*
     * TODO: Moved the specified Card, p positions down the deck. You can
     * assume that the input Card does belong to the deck (hence the deck is
     * not empty). This method runs in O(p).
     */
    public void moveCard(Card c, int p) {   ////////////////////////////////////////////////////////////////////////////////////////SEE IF WORKS
        /**** ADD CODE HERE ****/

        Card curr = c;
        Card cardA = c.prev;
        Card cardB = c.next;

        if (p > numOfCards) {
            p = p%numOfCards+1;
        }
            for (int i = 0; i < p; i++) {
                curr = curr.next;

                if (curr == null) {
                    curr = head;}

//                if (p > numOfCards) {
//                    curr = curr.next;}
            }

            cardA.next = cardB;
            cardB.prev = cardA;

            Card E = curr;
            Card D = curr.next;

            E.next = c;
            c.next = D;
            D.prev = c;
            c.prev = E;


    }

    /*
     * TODO: Performs a triple cut on the deck using the two input cards. You
     * can assume that the input cards belong to the deck and the first one is
     * nearest to the top of the deck. This method runs in O(1)
     */
    public void tripleCut(Card firstCard, Card secondCard) {
        /**** ADD CODE HERE ****/
        // code runs in O(1) so no loops, need to figure out a way to separate deck in three parts; before first joker,
        // after second joker and between both jokers
        Card part1Head = head;
        Card part1Tail = firstCard.prev;

        Card part2Head = secondCard.next;
        Card part2tail = head.prev;

        if (firstCard == head){
            head = part2Head;
            firstCard.prev = part2tail;
            head.prev = secondCard;
             //secondCard.next = head;firstCard.prev= head.prev;tail= head.prev;
        }//added else
       else if (secondCard.next == head){
           secondCard.next = part1Head;
           head = firstCard;
           head.prev = part1Tail;
        }
        else if(firstCard != head && secondCard.next != head){

         //cards before first joker
        head = part2Head;
        head.prev = part1Tail;
        part1Tail.next = part2Head;

        firstCard.prev = part2tail;
        part2tail.next = firstCard;

        secondCard.next = part1Head;
        part1Head.prev = secondCard;
        }

    }

    /*
     * TODO: Performs a count cut on the deck. Note that if the value of the
     * bottom card is equal to a multiple of the number of cards in the deck,
     * then the method should not do anything. This method runs in O(n).
     */
    public void countCut() { ///////////////////////////////////////////////////////////////////////////
        /**** ADD CODE HERE ****/
        int cutValue = (head.prev.getValue()) % numOfCards;
        Card cutCard = head;
        Card tail = head.prev;

       if (cutValue != 0){
           if ((head.prev.getValue()) == numOfCards-1 ){
               return;
           }
            for (int i = 0; i< cutValue; i++){
                cutCard = cutCard.next;
            }
            tail.prev.next= head;
            head.prev= tail.prev;

            tail.prev= cutCard.prev;
            cutCard.prev.next= tail;

            head = cutCard;
            head.prev = tail;

            tail.next = head;
            }
        }

    /*
     * TODO: Returns the card that can be found by looking at the value of the
     * card on the top of the deck, and counting down that many cards. If the
     * card found is a Joker, then the method returns null, otherwise it returns
     * the Card found. This method runs in O(n).
     */
    public Card lookUpCard() {
        /**** ADD CODE HERE ****/

        Card curr = head;
        int valueTopCard = head.getValue();

        for (int i = 0; i < valueTopCard ; i++){
            curr = curr.next;

        }if (curr instanceof Joker){
            return null;
        }
        return curr;
    }

    /*
     * TODO: Uses the Solitaire algorithm to generate one value for the keystream
     * using this deck. This method runs in O(n).
     */
    public int generateNextKeystreamValue() {
        /**** ADD CODE HERE ****/
        //Locate the red joker and move it one card below
        //Locate the black joker and move it two cards below.
        //Perform a “triple cut
        //Perform a “count cut”:
        //look at the value of the card on the top of the deck.
        // Count down that many cards,and look at the next card.
        //If you hit a joker, ignore it and repeat the keystream algorithm
        //Otherwise, use the value of the card you counted to as the next keystream value

        Joker red = locateJoker("red");
        Joker black = locateJoker("black");
        moveCard(red, 1);
        moveCard(black, 2);
         //need to find which joker is first before triple cut

        Card curr = head;
        Card firstCard = null;
        //Card secondCard = null;
        for (int i =0; i<numOfCards; i++){
            if ( curr instanceof Joker ){
                firstCard = (Joker) curr;
                break;
            }
            curr = curr.next;
        }
        if (red == firstCard)
            tripleCut(red, black);
        else{
            tripleCut(black, red);
        }
        countCut();
        Card c = lookUpCard();
        if (c == null)
            generateNextKeystreamValue();
        return lookUpCard().getValue();
    }


    public abstract class Card {
        public Card next;
        public Card prev;

        public abstract Card getCopy();
        public abstract int getValue();

    }
    public class PlayingCard extends Card {
        public String suit;
        public int rank;

        public PlayingCard(String s, int r) {
            this.suit = s.toLowerCase();
            this.rank = r;
        }

        public String toString() {
            String info = "";
            if (this.rank == 1) {
                //info += "Ace";
                info += "A";
            } else if (this.rank > 10) {
                String[] cards = {"Jack", "Queen", "King"};
                //info += cards[this.rank - 11];
                info += cards[this.rank - 11].charAt(0);
            } else {
                info += this.rank;
            }
            //info += " of " + this.suit;
            info = (info + this.suit.charAt(0)).toUpperCase();
            return info;
        }

        public PlayingCard getCopy() {
            return new PlayingCard(this.suit, this.rank);
        }

        public int getValue() {
            int i;
            for (i = 0; i < suitsInOrder.length; i++) {
                if (this.suit.equals(suitsInOrder[i]))
                    break;
            }

            return this.rank + 13*i;
        }

    }

    public class Joker extends Card{
        public String redOrBlack;

        public Joker(String c) {
            if (!c.equalsIgnoreCase("red") && !c.equalsIgnoreCase("black"))
                throw new IllegalArgumentException("Jokers can only be red or black");

            this.redOrBlack = c.toLowerCase();
        }

        public String toString() {
            //return this.redOrBlack + " Joker";
            return (this.redOrBlack.charAt(0) + "J").toUpperCase();
        }

        public Joker getCopy() {
            return new Joker(this.redOrBlack);
        }

        public int getValue() {
            return numOfCards - 1;
        }

        public String getColor() {
            return this.redOrBlack;
        }
    }




}
