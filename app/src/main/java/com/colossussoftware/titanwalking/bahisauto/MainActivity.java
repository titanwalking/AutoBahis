package com.colossussoftware.titanwalking.bahisauto;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;

import com.colossussoftware.titanwalking.bahisauto.DataObjects.Mac;
import com.colossussoftware.titanwalking.bahisauto.Helper.FetchHelper;
import com.colossussoftware.titanwalking.bahisauto.Helper.MacAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    private SwipeRefreshLayout swipeContainer;


    private ListView listView;
    private ArrayList<Mac> misliFutbol;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_football:
                    return true;
                case R.id.navigation_basketball:
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        listView = findViewById(R.id.listView);
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);

        // Setup refresh listener which triggers new data loading

        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override

            public void onRefresh() {

                // Your code to refresh the list here.

                // Make sure you call swipeContainer.setRefreshing(false)

                // once the network request has completed successfully.

                new Fetch().execute();
            }

        });

        // Configure the refreshing colors

        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,

                android.R.color.holo_green_light,

                android.R.color.holo_orange_light,

                android.R.color.holo_red_light);
        new Fetch().execute();
    }

    private class Fetch extends AsyncTask<Void, Void, Void> {
        ProgressDialog dialog;


        @Override
        protected Void doInBackground(Void... voids) {
            misliFutbol = FetchHelper.fetchMisliFutbol();
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setMessage("hazırlanıyor");
            dialog.setIndeterminate(true);
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Collections.sort(misliFutbol, new Comparator<Mac>() {
                @Override
                public int compare(Mac o1, Mac o2) {
                    return Integer.compare(o2.getOynanmaYuzdesi(), o1.getOynanmaYuzdesi());
                }
            });
            listView.setAdapter(new MacAdapter(MainActivity.this, misliFutbol));
            swipeContainer.setRefreshing(false);
            dialog.dismiss();
        }
    }

}
