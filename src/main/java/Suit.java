public enum Suit {
    HEARTS("Hearts", "♥"),
    DIAMONDS("Diamonds", "♦"),
    CLUBS("Clubs", "♣"),
    SPADES("Spades", "♠");

    private final String suit;
    private final String symbol;

    Suit(String suit, String symbol) {
        this.suit = suit;
        this.symbol = symbol;
    }

    public String getSuit() { return suit; }

    public String getSymbol() { return symbol; }

    @Override
    public String toString() {
        return suit; // default display
    }

    public String toStringSymbol() {
        return symbol;
    }
}
