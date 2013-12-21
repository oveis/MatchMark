package com.game.worldlandmarkfinder;

import java.util.List;

public class Board {
    private List<Card> mCards;
    private boolean mMatchedCards[];
    private int mDefaultCardId;
    private int mBoardRows;
    private int mBoardCols;
    
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
    
    public boolean isMatchedCard(final int position) {
        return mMatchedCards[position];
    }
    
    public boolean isCompleted() {
        for(int i=0; i<mMatchedCards.length; i++) {
            if(!mMatchedCards[i]) {
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
