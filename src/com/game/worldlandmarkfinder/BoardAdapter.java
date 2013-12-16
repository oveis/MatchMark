package com.game.worldlandmarkfinder;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class BoardAdapter extends BaseAdapter {
	private Context mContext;
	private Board mBoard;

	public BoardAdapter(final Context context, final Board board) {
		mContext = context;
		mBoard = board;
	}

	@Override
	public Object getItem(final int position) {
        return (mBoard.getCards() != null) ? mBoard.getCard(position) : null;
    } 
	
	@Override
	public long getItemId(final int position) {
        return position;
    }
	
	@Override
	public int getCount() {
		return mBoard.getCards().size();
	}
	
	@Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        ImageView imageView = null;
        Log.d("WLF", "getView for position " + position);

        if (convertView != null)
            imageView = (ImageView)convertView;
        else {
        	imageView = new ImageView(mContext);
        	imageView.setLayoutParams(new GridView.LayoutParams(250, 250));
        	imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        	imageView.setPadding(1, 1, 1, 1);
        }
        
        imageView.setImageResource(mBoard.getDefaultCardId());
        return imageView;
    }	
}
