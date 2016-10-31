package com.example.zvio.reddit_app.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.zvio.reddit_app.R;
import com.example.zvio.reddit_app.api.response.Wallpapers.Wallpaper;
import com.example.zvio.reddit_app.api.response.Wallpapers.WallpaperChild;
import com.example.zvio.reddit_app.api.response.Wallpapers.WallpaperResolution;
import com.example.zvio.reddit_app.api.response.Wallpapers.WallpaperSource;
import com.example.zvio.reddit_app.ui.components.RecyclerItemClickListener;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

/**
 * Created by QETO on 10/30/2016.
 */

public class WallpaperRecyclerAdapter extends RecyclerView.Adapter<WallpaperRecyclerAdapter.ViewHolder> {
    private ArrayList<WallpaperChild> children;
    private Context context;
    private RecyclerItemClickListener itemClickListener;

    public WallpaperRecyclerAdapter(Context context, RecyclerItemClickListener itemClickListener) {
        this.context = context;
        this.itemClickListener = itemClickListener;
    }


    public void setChildren(ArrayList<WallpaperChild> children) {
        this.children = children;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.wallpaper_recycler_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        String source = getItem(position).getResolutions().get(1).getUrl();
        Log.d("Wallpaper", source);
        holder.progressBar.setVisibility(View.VISIBLE);
        Ion.with(context).load(source).intoImageView(holder.image).setCallback(new FutureCallback<ImageView>() {
            @Override
            public void onCompleted(Exception e, ImageView result) {
                holder.progressBar.setVisibility(View.GONE);
            }
        });
        holder.title.setText(getTitle(position));
    }



    @Override
    public int getItemCount() {
        if (children == null) return 0;
        return children.size();
    }

    public Wallpaper getItem(int pos) {
        return children.get(pos).getData().getPreview().getWallpapers().get(0);
    }

    public String getTitle(int pos) {
        return children.get(pos).getData().getTitle();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image;
        TextView title;
        ProgressBar progressBar;

        public ViewHolder(View itemView) {
            super(itemView);
            progressBar = (ProgressBar) itemView.findViewById(R.id.wallpaperProgressBar);
            image = (ImageView) itemView.findViewById(R.id.imageViewWallpaper);
            title = (TextView) itemView.findViewById(R.id.wallpaperTitle);
            image.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            ArrayList<WallpaperSource> sources =  getItem(getAdapterPosition()).getResolutions();
            itemClickListener.onItemClick(sources.get(sources.size()-1));
        }
    }
}
