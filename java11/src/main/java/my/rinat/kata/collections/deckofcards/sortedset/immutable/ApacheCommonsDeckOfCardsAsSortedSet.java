package my.rinat.kata.collections.deckofcards.sortedset.immutable;

import my.rinat.kata.collections.deckofcards.Card;
import my.rinat.kata.collections.deckofcards.Rank;
import my.rinat.kata.collections.deckofcards.Suit;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.MultiMapUtils;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.SetValuedMap;

import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.stream.IntStream;

public class ApacheCommonsDeckOfCardsAsSortedSet {
    private SortedSet<Card> cards;
    private MultiValuedMap<Suit, Card> cardsBySuit;

    /**
     * TODO Replace the null values below with something more useful.
     * Use Apache Commons Collections APIs with {@link Card#streamCards()} to create an "immutable" SortedSet and store that in cards.
     * Group all of the cards by {@link Card#getSuit()} into an "immutable" SetValuedMap and stored that in cardsBySuit.
     * <p>
     * Hint: Look at {@link MultiValuedMap}, {@link SetValuedMap} and {@link MultiMapUtils#unmodifiableMultiValuedMap(MultiValuedMap)}
     */
    public ApacheCommonsDeckOfCardsAsSortedSet() {
        this.cards = null;
        this.cardsBySuit = null;
    }

    public Deque<Card> shuffle(Random random) {
        // TODO Shuffle the deck 3 times with the Random parameter and push the shuffled cards onto an ArrayDeque
        return null;
    }

    public Set<Card> deal(Deque<Card> deque, int count) {
        Set<Card> hand = new HashSet<>();
        IntStream.range(0, count).forEach(i -> hand.add(deque.pop()));
        return hand;
    }

    public List<Set<Card>> shuffleAndDeal(Random random, int hands, int cardsPerHand) {
        Deque<Card> shuffled = this.shuffle(random);
        return this.dealHands(shuffled, hands, cardsPerHand);
    }

    public List<Set<Card>> dealHands(
            Deque<Card> shuffled,
            int hands,
            int cardsPerHand) {
        // TODO Deal the number of hands with the cardsPerHand into an "immutable" List<Set<Card>>
        return null;
    }

    public SortedSet<Card> diamonds() {
        // TODO Return all of the diamonds as a SortedSet
        return null;
    }

    public SortedSet<Card> hearts() {
        // TODO Return all of the hearts as a SortedSet
        return null;
    }

    public SortedSet<Card> spades() {
        // TODO Return all of the spades as a SortedSet
        return null;
    }

    public SortedSet<Card> clubs() {
        // TODO Return all of the clubs as a SortedSet
        return null;
    }

    public Bag<Suit> countsBySuit() {
        // TODO return the count of cards by Suit
        // Hint: Look at HashBag
        return null;
    }

    public MultiSet<Rank> countsByRank() {
        // TODO return the count of cards by Rank
        // Hint: Look at HashMultiset.  Compare HashBag and HashMultiset.  What is the difference?
        return null;
    }

    public SortedSet<Card> getCards() {
        return this.cards;
    }

    public MultiValuedMap<Suit, Card> getCardsBySuit() {
        return this.cardsBySuit;
    }
}
