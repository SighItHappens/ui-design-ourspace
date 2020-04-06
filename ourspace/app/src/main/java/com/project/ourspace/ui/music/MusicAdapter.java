package com.project.ourspace.ui.music;

import android.os.Build;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.ourspace.R;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {
    private MusicViewModel.Song[] songs;

    MusicAdapter(MusicViewModel.Song[] init) {
        this.songs = init;
    }

    // Create new views (invoked by the layout manager)
    @Override
    @NonNull
    public MusicAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.song, null);

        // create ViewHolder
        return new ViewHolder(itemLayoutView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData
        viewHolder.song_name.setText(songs[position].getName());
        String url = String.format("<a href='%s'> Link </a>" , (songs[position].getUrl()));
        viewHolder.song_url.setText(Html.fromHtml(url, Html.FROM_HTML_MODE_COMPACT));
    }

    // inner class to hold a reference to each item of RecyclerView
    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView song_name;
        TextView song_url;

        ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            song_name = itemLayoutView.findViewById(R.id.song_name);
            song_url = itemLayoutView.findViewById(R.id.song_url);
            song_url.setClickable(true);
            song_url.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }


    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return songs.length;
    }
}
