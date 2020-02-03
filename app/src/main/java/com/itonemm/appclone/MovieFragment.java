package com.itonemm.appclone;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {


    String categoryname;
    static RecyclerView rcView;
    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView=inflater.inflate(R.layout.fragment_movie, container, false);
        MobileAds.initialize(getContext(),getResources().getString(R.string.admob_id));
       AdView mAdView = myView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        rcView=myView.findViewById(R.id.rcview);
        FirebaseConnect.firbaseContext=getContext();
        FirebaseConnect.firebaseActivity=getActivity();
        FirebaseConnect connect=new FirebaseConnect();
        connect.getAllMovies(categoryname);;
        return myView;
    }

}
