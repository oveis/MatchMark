package com.game.worldlandmarkfinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

class DBLevel1 {
    List<Card> mCards = Arrays.asList(new Card(R.drawable.chihuly_gardens, "Chihuly Gardens"),
            new Card(R.drawable.fremont_troll, "Fremont Troll"), new Card(R.drawable.gas_works_park, "Gas Works Park"),
            new Card(R.drawable.pike_market, "Pike Market"), new Card(R.drawable.seattle_great_wheel, "Seattle Great Wheel"),
            new Card(R.drawable.space_needle, "Space Needle"));
    int mDefaultCardId = R.drawable.landmakrs;
    int mBoardRows = 3;
    int mBoardCols = 4;
}
 
public class BoardManager {
    
    // TODO: use enum
    static final int CARD_SELECT = 0;
    static final int CARDS_MATCH_SUCCESS = 1;
    static final int CARDS_MATCH_FAILURE = 2;
    static final int WRONG_CARD_SELECT = 3;
    static final int ALL_CARDS_MATCHED = 4;
    
    private Board mBoard;
    // The position of the card previously selected.  -1 if there is none.
	private int mPrevCardPosition = -1;
	private ImageView mPrevImageView = null;
	private ImageView mCurrImageView = null;
	
	public Board getBoard() {
	    return mBoard;
	}
	
	public void createBoard() {
	    final DBLevel1 dbLevel1 = new DBLevel1();
	    final List<Card> cards = new ArrayList<Card>();
        for(final Card card : dbLevel1.mCards) {  // add twice to make a pair
            cards.add(card);
            cards.add(card);
        }
        final long seed = System.nanoTime();
        Collections.shuffle(cards, new Random(seed));
        mBoard = new Board(cards, dbLevel1.mDefaultCardId, dbLevel1.mBoardCols, dbLevel1.mBoardRows);
    }
	
	private class FlipCardsBackTask extends AsyncTask {
	    @Override
        protected Object doInBackground(Object... params) {
	        Log.d("WLF", "enter doInBackgroud");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
     
        @Override
        protected void onPostExecute(Object obj) {
            Log.d("WLF", "on Post Execution");
            mCurrImageView.setImageResource(mBoard.getDefaultCardId());
            mPrevImageView.setImageResource(mBoard.getDefaultCardId());
            mPrevImageView = null;
        }
    }
	
	public int clickCard(final ImageView imageView, final int position) {
	    mCurrImageView = imageView;
	    
	    // If a selected card does not produce a match
	    if(!mBoard.isPositionAlreadyMatched(position)) {
	        // If this is the first of two cards selected/flipped
	        if(mPrevCardPosition == -1) {
	            mCurrImageView.setImageResource(mBoard.getCard(position).getId());
                mPrevCardPosition = position;
                mPrevImageView = mCurrImageView;
                return CARD_SELECT;
            // If this is the second of two cards selected/flipped
            } else if(mPrevCardPosition != position) {
                mCurrImageView.setImageResource(mBoard.getCard(position).getId());
 
                final int prevCardId = mBoard.getCard(mPrevCardPosition).getId();
                final int currCardId = mBoard.getCard(position).getId();
                
                if(prevCardId == currCardId) {
                    mBoard.setMatchedCards(mPrevCardPosition, position);
                    if(mBoard.isCompleted()) {
                        return ALL_CARDS_MATCHED;
                    }
                    mPrevCardPosition = -1;
                    mPrevImageView = null;
                    return CARDS_MATCH_SUCCESS;
                } else {
                    new FlipCardsBackTask().execute();
                    mPrevCardPosition = -1;
                    return CARDS_MATCH_FAILURE;
                }                
    	    }
	    }
	    return WRONG_CARD_SELECT;
	}
	
	public void resetBoard(final Set<Landmark> landmarks, final int width, final int height) {
		
	}
}
