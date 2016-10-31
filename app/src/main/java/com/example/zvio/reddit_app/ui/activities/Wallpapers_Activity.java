package com.example.zvio.reddit_app.ui.activities;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.zvio.reddit_app.R;
import com.example.zvio.reddit_app.api.Service.RedditApi;
import com.example.zvio.reddit_app.api.response.Wallpapers.Wallpaper;
import com.example.zvio.reddit_app.api.response.Wallpapers.WallpaperChild;
import com.example.zvio.reddit_app.api.response.Wallpapers.WallpaperResponse;
import com.example.zvio.reddit_app.api.response.Wallpapers.WallpaperSource;
import com.example.zvio.reddit_app.ui.adapters.WallpaperRecyclerAdapter;
import com.example.zvio.reddit_app.ui.components.RecyclerItemClickListener;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Wallpapers_Activity extends AppCompatActivity implements RecyclerItemClickListener {
    private RecyclerView recyclerView;
    private WallpaperRecyclerAdapter wpRecyclerAdapter;
    private int screenHeight = 0;
    private int screenWidthFrame = 0;
    private View wpFrame;
    private ProgressBar progressBar,frameProgress;
    private ImageView imageViewWallpaper, fullScreenWallpaper;
    private Toolbar toolbar;


    private Point getScreenDimens() {
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Point size = new Point();
        wm.getDefaultDisplay().getSize(size);
        return size;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpapers);

        screenHeight = getScreenDimens().y;
        screenWidthFrame = getScreenDimens().x;

        progressBar = (ProgressBar) findViewById(R.id.wallpaperProgressBar);
        frameProgress = (ProgressBar)findViewById(R.id.frame_progress);
        imageViewWallpaper = (ImageView) findViewById(R.id.imageViewWallpaper);
        fullScreenWallpaper = (ImageView) findViewById(R.id.full_screen_wallpaper);

        recyclerView = (RecyclerView) findViewById(R.id.walpaperRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        wpRecyclerAdapter = new WallpaperRecyclerAdapter(this, this);
        recyclerView.setAdapter(wpRecyclerAdapter);

        wpFrame = findViewById(R.id.wallpaper_frame);

        RedditApi redditApi = new RedditApi();
        redditApi.getGifJson(callback);


        recyclerView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                scrollImages();
            }
        });
    }

    public void scrollImages() {
        LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int first = manager.findFirstVisibleItemPosition();
        int last = manager.findLastVisibleItemPosition();
        for (int i = first; i <= last; i++) {
            View v = manager.findViewByPosition(i);
            if (v == null)
                continue;
            ImageView image = (ImageView) v.findViewById(R.id.imageViewWallpaper);
            adjustImage(v, image);
        }
    }

    public void adjustImage(View v, View image) {
        int[] coords = new int[2];
        v.getLocationOnScreen(coords);
        float distanceFromCenter = screenHeight * 0.5f - (coords[1]);
        float difference = image.getHeight() - (v.getHeight());
        float move = (distanceFromCenter / screenHeight) * difference;
        float y = -(difference * 0.5f) + move;
        if (y > 0) y = 0;
        image.setY(y);
    }

    Callback<WallpaperResponse> callback = new Callback<WallpaperResponse>() {
        @Override
        public void onResponse(Call<WallpaperResponse> call, Response<WallpaperResponse> response) {

            ArrayList<WallpaperChild> children = new ArrayList<>();
            for (WallpaperChild child : response.body().getData().getChildren()) {
                if (child.getData().getPreview() != null) {
                    if (child.getData().getPreview().getWallpapers() != null)
                        children.add(child);
                }
            }
            wpRecyclerAdapter.setChildren(children);
            wpRecyclerAdapter.notifyDataSetChanged();
        }

        @Override
        public void onFailure(Call<WallpaperResponse> call, Throwable t) {
            Toast.makeText(Wallpapers_Activity.this, "Something went wrong :/", Toast.LENGTH_SHORT).show();
        }
    };


    @Override
    public void onItemClick(final WallpaperSource source) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale_out);
        animation.setInterpolator(new OvershootInterpolator());
        wpFrame.setVisibility(View.VISIBLE);
        frameProgress.setVisibility(View.VISIBLE);
        frameProgress.startAnimation(animation);
        String url = source.getUrl();
        Ion.with(Wallpapers_Activity.this).load(source.getUrl()).intoImageView(fullScreenWallpaper).setCallback(new FutureCallback<ImageView>() {
            @Override
            public void onCompleted(Exception e, ImageView result) {

                frameProgress.setVisibility(View.GONE);
                ViewGroup.LayoutParams imageParams = fullScreenWallpaper.getLayoutParams();
                ViewGroup.LayoutParams frameParams = wpFrame.getLayoutParams();

                float ratio = (float) screenWidthFrame / (float) source.getWidth();

                imageParams.height = (int) (source.getHeight() * ratio);
                imageParams.width = screenWidthFrame;


                frameParams.height = imageParams.height;
                frameParams.width = imageParams.width;

                wpFrame.setLayoutParams(frameParams);
                fullScreenWallpaper.setLayoutParams(imageParams);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (wpFrame.getVisibility() == View.VISIBLE) {
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale_in);
            animation.setInterpolator(new OvershootInterpolator());
            wpFrame.startAnimation(animation);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    wpFrame.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });
            return;
        }
            super.onBackPressed();
        }
    }

