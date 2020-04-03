package com.project.ourspace.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.project.ourspace.R;

import java.util.List;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class TileAdapter extends RecyclerView.Adapter<TileAdapter.TileViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Tile> tileList;
    RequestManager glide;

    //getting the context and product list with constructor
    public TileAdapter(Context mCtx, List<Tile> tileList) {
        this.mCtx = mCtx;
        this.tileList = tileList;
        this.glide = Glide.with(mCtx);
    }

    @Override
    public TileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.image_card_layout_test, null);
        return new TileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TileViewHolder holder, int position) {
        //getting the product of the specified position
        Tile tile = tileList.get(position);

        //binding the data with the viewholder views
//        holder.textViewTitle.setText(tile.getTitle());
//        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(tile.getImage()));

        holder.uploadername.setText(tile.getName());
        holder.likername.setText(tile.getLikedBy());
        holder.posttime.setText(tile.getTime());
        holder.likes.setText(tile.getLikes()+" others");
        holder.captionnames.setText(tile.getName());
        holder.tags.setText(tile.getTags());
        glide.load(tile.getUploaderPic()).into(holder.uploader);
        glide.load(tile.getLikerPic()).into(holder.liker);
        glide.load(tile.getPostPic()).into(holder.post);




    }


    @Override
    public int getItemCount() {
        return tileList.size();
    }


    class TileViewHolder extends RecyclerView.ViewHolder {

//        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
//        ImageView imageView;
        TextView uploadername,likername,posttime,likes,captionnames,tags;
        CircleImageView uploader,userpic,liker;
        ImageView post;

        public TileViewHolder(@NonNull View itemView) {
            super(itemView);

//            textViewTitle = itemView.findViewById(R.id.title);
//
//            imageView = itemView.findViewById(R.id.imageView);
////            imageView = itemView.findViewById(R.id.favorite_button);
////            imageView = itemView.findViewById(R.id.bookmark_button);
////            imageView = itemView.findViewById(R.id.share_button);
            uploadername=(TextView) itemView.findViewById(R.id.tv_uploader_name);
            likername=(TextView) itemView.findViewById(R.id.liker_name);
            posttime=(TextView) itemView.findViewById(R.id.tv_time);
            likes=(TextView) itemView.findViewById(R.id.tv_likes);
            captionnames=(TextView) itemView.findViewById(R.id.tv_uploader_name_caption);
            tags=(TextView) itemView.findViewById(R.id.tv_tags);

            uploader=(CircleImageView) itemView.findViewById(R.id.uploader_pro_pic);
            liker=(CircleImageView) itemView.findViewById(R.id.liker_pro_pic);

            post=(ImageView) itemView.findViewById(R.id.post_pic);



        }
    }
}
