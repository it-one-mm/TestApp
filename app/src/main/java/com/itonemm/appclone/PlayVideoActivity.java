package com.itonemm.appclone;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;

public class PlayVideoActivity extends AppCompatActivity {

    public static String videourl;
    SimpleExoPlayerView playerView;
    SimpleExoPlayer player;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        StrictMode.ThreadPolicy  policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        progressBar=findViewById(R.id.progressbar);
        playerView=findViewById(R.id.playerView);
        player= ExoPlayerFactory.newSimpleInstance(getApplicationContext(),new DefaultTrackSelector());
        DefaultHttpDataSourceFactory df=new DefaultHttpDataSourceFactory("Exo Player");
        ExtractorsFactory ef=new DefaultExtractorsFactory();
        Uri uri=Uri.parse(videourl);
        ExtractorMediaSource mSoure=new ExtractorMediaSource(uri,df,ef,null,null);
        player.prepare(mSoure);
        player.setPlayWhenReady(true);
        SimpleExoPlayer.EventListener myListerner=new ExoPlayer.EventListener() {
            @Override
            public void onTimelineChanged(Timeline timeline, Object manifest) {

            }

            @Override
            public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {

            }

            @Override
            public void onLoadingChanged(boolean isLoading) {

            }

            @Override
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {

                if(playbackState==SimpleExoPlayer.STATE_BUFFERING)
                {
                    progressBar.setVisibility(View.VISIBLE);
                }
                else
                {
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onRepeatModeChanged(int repeatMode) {

            }

            @Override
            public void onPlayerError(ExoPlaybackException error) {

            }

            @Override
            public void onPositionDiscontinuity() {

            }

            @Override
            public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {

            }
        };
        player.addListener(myListerner);
        playerView.setPlayer(player);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        player.stop();
    }
}
