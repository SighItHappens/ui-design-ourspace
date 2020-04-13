package com.project.ourspace.ui.music;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.project.ourspace.R;

public class CreateMusicDialog extends DialogFragment {
    private EditText editSongName;
    private EditText editArtistName;
    private EditText editSongUrl;
    private CreateMusicDialogListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.playlist_dialog, null); // Later use R.layout to find editText?

        builder.setView(view)
                .setTitle("Add Song")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String songname = "";
                        listener.cancelTexts();
                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String songname = editSongName.getText().toString();
                        String artistname = editArtistName.getText().toString();
                        String songurl = editSongUrl.getText().toString();
                        listener.applyTexts(songname, artistname, songurl);
                    }
                });
        editSongName = view.findViewById(R.id.edit_single_songname);
        editArtistName = view.findViewById(R.id.edit_single_artistname);
        editSongUrl = view.findViewById(R.id.edit_single_songurl);
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        System.out.println(this.getClass().toString());
        super.onAttach(context);
        try {
            listener = (CreateMusicDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + "must implement listener");
        }
    }

    public interface CreateMusicDialogListener {
        void cancelTexts();
        void applyTexts(String songname, String artistname, String songurl);
    }
}
