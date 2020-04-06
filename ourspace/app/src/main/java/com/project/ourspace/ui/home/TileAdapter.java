package com.project.ourspace.ui.home;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.project.ourspace.MainActivity;
import com.project.ourspace.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class TileAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Tile> tileList;

    //getting the context and product list with constructor
    public TileAdapter(Context mCtx, List<Tile> tileList) {
        this.mCtx = mCtx;
        this.tileList = tileList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        if (viewType == 1) {
            View view = inflater.inflate(R.layout.image_card_layout, null);
            return new ImageViewHolder(view);
        } else if (viewType == 2) {
            View view = inflater.inflate(R.layout.song_card_layout, null);
            return new SongViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == 1 ) {
            ((ImageViewHolder) holder).setImageDetails(tileList.get(position));
        } else if (getItemViewType(position) == 2) {
            ((SongViewHolder) holder).setSongDetails(tileList.get(position));
        }
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {

        private TextView posted_by;
        private TextView Time;
        private ImageView image;

        ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            posted_by = itemView.findViewById(R.id.posted_by);
            Time = itemView.findViewById(R.id.date);
            image = itemView.findViewById(R.id.image);
        }

        private void setImageDetails(Tile tile) {
            posted_by.setText(tile.getName());
            Time.setText((tile.getTime()));
            int resId = mCtx.getResources().getIdentifier(
                    tile.getImage(),
                    "drawable",
                    mCtx.getPackageName()
            );
            System.out.println(resId);
            image.setImageResource(resId);
        }

    }

    class SongViewHolder extends RecyclerView.ViewHolder {

        private TextView posted_by;
        private TextView Time;
        private TextView song_name;
        private TextView artist_name;
        private Button song_link;

        SongViewHolder(@NonNull View itemView) {
            super(itemView);
            posted_by = itemView.findViewById(R.id.posted_by);
            Time = itemView.findViewById(R.id.date);
            song_name = itemView.findViewById(R.id.song_name);
            artist_name = itemView.findViewById(R.id.artist_name);
            song_link = itemView.findViewById(R.id.song_link);
        }

        private void setSongDetails(final Tile tile) {
            posted_by.setText(tile.getName());
            Time.setText(tile.getTime());
            song_name.setText(tile.getSong_name());
            artist_name.setText(tile.getArtist_name());
            song_link.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse(tile.getSong_link()));
                    mCtx.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (tileList.get(position).getType() == 1) {
            return 1;

        } else if (tileList.get(position).getType() == 2) {
            return 2;
        } else {
            return 0;
        }
    }

    @Override
    public int getItemCount() {
        return tileList.size();
    }



}
