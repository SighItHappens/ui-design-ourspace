package com.project.ourspace.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.project.ourspace.R;

import java.util.List;

import java.util.List;

public class TileAdapter extends RecyclerView.Adapter<TileAdapter.TileViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Tile> tileList;

    //getting the context and product list with constructor
    public TileAdapter(Context mCtx, List<Tile> tileList) {
        this.mCtx = mCtx;
        this.tileList = tileList;
    }

    @Override
    public TileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.image_card_layout, null);
        return new TileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TileViewHolder holder, int position) {
        //getting the product of the specified position
        Tile tile = tileList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(tile.getTitle());
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(tile.getImage()));

    }


    @Override
    public int getItemCount() {
        return tileList.size();
    }


    class TileViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
        ImageView imageView;

        public TileViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.title);

            imageView = itemView.findViewById(R.id.imageView);
//            imageView = itemView.findViewById(R.id.favorite_button);
//            imageView = itemView.findViewById(R.id.bookmark_button);
//            imageView = itemView.findViewById(R.id.share_button);



        }
    }
}
