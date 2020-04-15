package com.project.ourspace.ui.music;

/**
 * Created by karanjaswani on 1/12/18.
 */
import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.project.ourspace.R;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Song> songList;

    //getting the context and product list with constructor
    public SongAdapter(Context mCtx, List<Song> songList) {
        this.mCtx = mCtx;
        this.songList = songList;
    }

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.song, null);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        //getting the product of the specified position
        Song song = songList.get(position);

        //binding the data with the viewholder views
        holder.textViewSong.setText(song.getSongName());
        holder.textViewArtist.setText(song.getArtistName());
        holder.textViewUrl.setText(String.valueOf(song.getSongUrl()));
    }


    @Override
    public int getItemCount() {
        return songList.size();
    }


    class SongViewHolder extends RecyclerView.ViewHolder {

        TextView textViewSong, textViewArtist, textViewUrl;

        SongViewHolder(View itemView) {
            super(itemView);

            textViewSong = itemView.findViewById(R.id.song_name);
            textViewArtist = itemView.findViewById(R.id.artist_name);
            textViewUrl = itemView.findViewById(R.id.song_url);
        }
    }
}
