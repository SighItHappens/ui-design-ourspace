package com.project.ourspace.ui.home;
import com.project.ourspace.ShowTvshowActivity;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.ourspace.R;
import com.project.ourspace.ShowTvshowActivity;

import java.util.List;

public class TileAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "TileAdapter";

    // This context we will use to inflate the layout
    private Context mCtx;

    // We are storing all the products in a list
    private List<Tile> tileList;

    // Getting the context and product list with constructor
    public TileAdapter(Context mCtx, List<Tile> tileList) {
        this.mCtx = mCtx;
        this.tileList = tileList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        if (viewType == 1) {
            View view = inflater.inflate(R.layout.image_card_layout, parent, false);
            return new ImageViewHolder(view);
        } else if (viewType == 2) {
            View view = inflater.inflate(R.layout.song_card_layout, parent, false);
            return new SongViewHolder(view);
        } else if (viewType == 3) {
            View view = inflater.inflate(R.layout.tv_show_card_layout, parent, false);
            return new TVShowViewHolder(view);
        } else if (viewType == 4) {
            View view = inflater.inflate(R.layout.text_card_layout, parent, false);
            return new NoteViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == 1) {
            ((ImageViewHolder) holder).setImageDetails(tileList.get(position));
        } else if (getItemViewType(position) == 2) {
            ((SongViewHolder) holder).setSongDetails(tileList.get(position));
        } else if (getItemViewType(position) == 3) {
            ((TVShowViewHolder) holder).setTVShowDetails(tileList.get(position));
        } else if (getItemViewType(position) == 4) {
            ((NoteViewHolder) holder).setNoteDetails(tileList.get(position));
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
            Log.d(TAG, "setImageDetails: ResourceID: " + resId);
            image.setImageResource(resId);
        }
    }

    class SongViewHolder extends RecyclerView.ViewHolder {

        private TextView posted_by;
        private TextView time;
        private TextView song_name;
        private TextView artist_name;
        private Button song_link;

        SongViewHolder(@NonNull View itemView) {
            super(itemView);
            posted_by = itemView.findViewById(R.id.posted_by);
            time = itemView.findViewById(R.id.date);
            song_name = itemView.findViewById(R.id.song_name);
            artist_name = itemView.findViewById(R.id.artist_name);
            song_link = itemView.findViewById(R.id.song_link);
        }

        private void setSongDetails(final Tile tile) {
            posted_by.setText(tile.getName());
            time.setText(tile.getTime());
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

    class TVShowViewHolder extends RecyclerView.ViewHolder {

        private TextView posted_by;
        private TextView time;
        private ImageView image;
        private Button track;



        TVShowViewHolder(@NonNull View itemView) {
            super(itemView);
            posted_by = itemView.findViewById(R.id.posted_by);
            time = itemView.findViewById(R.id.date);
            image = itemView.findViewById(R.id.image);
        }

        private void setTVShowDetails(final Tile tile) {
            posted_by.setText(tile.getName());
            time.setText((tile.getTime()));
            int resId = mCtx.getResources().getIdentifier(
                    tile.getImage(),
                    "drawable",
                    mCtx.getPackageName()
            );
            track = itemView.findViewById(R.id.track);
            track.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mCtx.getApplicationContext(), ShowTvshowActivity.class);
                    Bundle mBundle = new Bundle();
                    mBundle.putSerializable("number_of_season", tile.getSeasons());
                    mBundle.putSerializable("number_of_episodes", tile.getEpisodes());
                    mBundle.putSerializable("show_progress", tile.getShowProgress());
                    intent.putExtras(mBundle);
                    mCtx.startActivity(intent);
                }
            });
            Log.d(TAG, "setImageDetails: ResourceID: " + resId);
            image.setImageResource(resId);
        }

    }

    class NoteViewHolder extends RecyclerView.ViewHolder {

        private TextView posted_by;
        private TextView time;
        private TextView note;
        private TextView noteHeader;

        NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            posted_by = itemView.findViewById(R.id.posted_by);
            time = itemView.findViewById(R.id.date);
            note = itemView.findViewById(R.id.note);
            noteHeader = itemView.findViewById(R.id.noteTitle);
        }

        private void setNoteDetails(Tile tile) {
            posted_by.setText(tile.getName());
            time.setText(tile.getTime());
            note.setText(tile.getNote());
            noteHeader.setText(tile.getNoteTitle());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (tileList.get(position).getType() == 1) {
            return 1;
        } else if (tileList.get(position).getType() == 2) {
            return 2;
        } else if (tileList.get(position).getType() == 3) {
            return 3;
        } else if (tileList.get(position).getType() == 4) {
            return 4;
        } else {
            return 0;
        }
    }

    @Override
    public int getItemCount() {
        return tileList.size();
    }

}
