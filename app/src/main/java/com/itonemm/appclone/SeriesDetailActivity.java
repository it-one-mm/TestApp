package com.itonemm.appclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SeriesDetailActivity extends AppCompatActivity {

   static SeriesModel model;
    static  RecyclerView rcView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_detail);

        StrictMode.ThreadPolicy  policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        ImageView movieImage=findViewById(R.id.movieImage);
        TextView movieName=findViewById(R.id.movieName);
        Glide.with(getApplicationContext())
                .load(model.image)
                .into(movieImage);
        movieName.setText(model.name);
         rcView=findViewById(R.id.rcview);
        FirebaseConnect.firbaseContext=getApplicationContext();
        FirebaseConnect.firebaseActivity=this;
        FirebaseConnect connect=new FirebaseConnect();
        connect.getEpisode(model.name);
    }
}
