package com.game.worldlandmarkfinder;

import java.util.List;

public class Board {
    private final List<Card> mCards;
    // a boolean array representing the state of whether or not a card has been
    // successfully matched/found
    private final boolean mMatchedCards[];
    private final int mDefaultCardId; // TODO: move to Card class
    private final int mBoardRows;
    private final int mBoardCols;
    
    public Board(final List<Card> cards, final int defaultCardId, 
            final int boardRows, final int boardCols) {
        mCards = cards;
        mMatchedCards = new boolean[cards.size()];
        mDefaultCardId = defaultCardId;
        mBoardRows = boardRows;
        mBoardCols = boardCols;
    }
 
    public List<Card> getCards() {
        return mCards;
    }
    
    public Card getCard(final int position) {
        return mCards.get(position);
    }
    
    public boolean isPositionAlreadyMatched(final int position) {
        return mMatchedCards[position];
    }
    
    public boolean isCompleted() {
        for (final boolean matched : mMatchedCards) {
            if (!matched) {
                return false;
            }
        }
        return true;
    }
    
    public void setMatchedCards(final int position1, final int position2) {
        mMatchedCards[position1] = true;
        mMatchedCards[position2] = true;
    }
    
    public int getDefaultCardId() {
        return mDefaultCardId;
    }
    
    public int getBoardRows() {
        return mBoardRows;
    }
    
    public int getBoardCols() {
        return mBoardCols;
    }
    
}
