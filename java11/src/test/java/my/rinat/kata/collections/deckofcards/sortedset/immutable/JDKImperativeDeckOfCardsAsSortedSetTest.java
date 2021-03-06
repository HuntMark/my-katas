package my.rinat.kata.collections.deckofcards.sortedset.immutable;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;

import my.rinat.kata.collections.deckofcards.Card;
import my.rinat.kata.collections.deckofcards.Rank;
import my.rinat.kata.collections.deckofcards.Suit;
import org.assertj.core.api.Assertions;
import org.eclipse.collections.impl.utility.Iterate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class JDKImperativeDeckOfCardsAsSortedSetTest {
    private JDKImperativeDeckOfCardsAsSortedSet jdkDeck = new JDKImperativeDeckOfCardsAsSortedSet();

    @Test
    void allCards() {
        Assertions.assertThat(this.jdkDeck.getCards().size()).isEqualTo(52);
        Assertions.assertThat(this.jdkDeck.getCards().first()).isEqualTo(new Card(Rank.ACE, Suit.SPADES));
        Assertions.assertThat(this.jdkDeck.getCards().last()).isEqualTo(new Card(Rank.KING, Suit.CLUBS));
    }

    @Test
    void cardsAreImmutable() {
        var jdkCards = this.jdkDeck.getCards();

        Executable remove = () -> jdkCards.remove(null);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, remove);

        Executable clear = jdkCards::clear;
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, clear);

        Executable add = () -> jdkCards.add(null);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, add);
    }

    @Test
    void diamonds() {
        Assertions.assertThat(this.jdkDeck.diamonds().size()).isEqualTo(13);
        Assertions.assertThat(Iterate.allSatisfy(this.jdkDeck.diamonds(), Card::isDiamonds)).isTrue();
    }

    @Test
    void hearts() {
        Assertions.assertThat(this.jdkDeck.hearts().size()).isEqualTo(13);
        Assertions.assertThat(Iterate.allSatisfy(this.jdkDeck.hearts(), Card::isHearts)).isTrue();
    }

    @Test
    void spades() {
        Assertions.assertThat(this.jdkDeck.spades().size()).isEqualTo(13);
        Assertions.assertThat(Iterate.allSatisfy(this.jdkDeck.spades(), Card::isSpades)).isTrue();
    }

    @Test
    void clubs() {
        Assertions.assertThat(this.jdkDeck.clubs().size()).isEqualTo(13);
        Assertions.assertThat(Iterate.allSatisfy(this.jdkDeck.clubs(), Card::isClubs)).isTrue();
    }

    @Test
    void deal() {
        Deque<Card> jdkShuffle = this.jdkDeck.shuffle(new Random(1));
        Set<Card> jdkHand = this.jdkDeck.deal(jdkShuffle, 5);
        Assertions.assertThat(jdkHand.size()).isEqualTo(5);
        Assertions.assertThat(jdkShuffle.size()).isEqualTo(47);
    }

    @Test
    void shuffleAndDealHands() {
        List<Set<Card>> jdkHands = this.jdkDeck.shuffleAndDeal(new Random(1), 5, 5);
        Assertions.assertThat(jdkHands.size()).isEqualTo(5);
        Assertions.assertThat(Iterate.allSatisfy(jdkHands, each -> each.size() == 5)).isTrue();
    }

    @Test
    void dealHands() {
        Deque<Card> jdkShuffled = this.jdkDeck.shuffle(new Random(1));
        List<Set<Card>> jdkHands = this.jdkDeck.dealHands(jdkShuffled, 5, 5);
        Assertions.assertThat(jdkHands.size()).isEqualTo(5);
        Assertions.assertThat(Iterate.allSatisfy(jdkHands, each -> each.size() == 5)).isTrue();
        Assertions.assertThat(jdkShuffled.size()).isEqualTo(27);
    }

    @Test
    void cardsBySuit() {
        Map<Suit, SortedSet<Card>> jdkCardsBySuit = this.jdkDeck.getCardsBySuit();
        Assertions.assertThat(jdkCardsBySuit.size()).isEqualTo(4);
        Assertions.assertThat(jdkCardsBySuit.get(Suit.CLUBS).size()).isEqualTo(13);
        Assertions.assertThat(jdkCardsBySuit.get(Suit.DIAMONDS).size()).isEqualTo(13);
        Assertions.assertThat(jdkCardsBySuit.get(Suit.SPADES).size()).isEqualTo(13);
        Assertions.assertThat(jdkCardsBySuit.get(Suit.HEARTS).size()).isEqualTo(13);
    }

    @Test
    void cardsBySuitIsImmutable() {
        var jdkCardsBySuit = this.jdkDeck.getCardsBySuit();

        Executable remove = () -> jdkCardsBySuit.remove(Suit.CLUBS);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, remove);

        Executable clear = jdkCardsBySuit::clear;
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, clear);

        Executable removeBySuit = () -> jdkCardsBySuit.get(Suit.CLUBS).remove(null);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, removeBySuit);

        Executable add = () -> jdkCardsBySuit.get(Suit.CLUBS).add(null);
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, add);

        Executable clearBySuit = jdkCardsBySuit.get(Suit.CLUBS)::clear;
        org.junit.jupiter.api.Assertions.assertThrows(UnsupportedOperationException.class, clearBySuit);
    }

    @Test
    void countsBySuit() {
        Assertions.assertThat(this.jdkDeck.countsBySuit().get(Suit.CLUBS)).isEqualTo(Long.valueOf(13));
    }

    @Test
    void countsByRank() {
        Assertions.assertThat(this.jdkDeck.countsByRank().get(Rank.TEN)).isEqualTo(Long.valueOf(4));
    }
}
