package com.itonemm.appclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.StrictMode;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy  policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        final TabLayout tabBar=findViewById(R.id.tabbar);
        final ViewPager pager=findViewById(R.id.viewpager);
        final ViewpagerAdapter adapter=new ViewpagerAdapter(getSupportFragmentManager());
        FirebaseFirestore db=FirebaseFirestore.getInstance();
        CollectionReference categoryRef=db.collection("categories");
        categoryRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                for(DocumentSnapshot s: queryDocumentSnapshots)
                {
                    MovieFragment frag=new MovieFragment();
                    frag.categoryname=s.toObject(CategoryModel.class).categoryName;
                    adapter.addFragment(frag,frag.categoryname);
                }
                pager.setAdapter(adapter);
                tabBar.setupWithViewPager(pager);
            }
        });




    }
}
