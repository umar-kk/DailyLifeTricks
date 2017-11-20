package com.example.umarkk.dailylifetricks;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Typeface;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    boolean doubleBackToExitPressedOnce = false;
    List<HackList> hackLists = new ArrayList();
    private String[] range = new String[]{"1", "101", "201", "301", "401", "501", "601", "701", "801", "901"};
    private String[] range2 = new String[]{"100", "200", "300", "400", "500", "600", "700", "800", "900", "1000"};
    RecyclerView recyclerView;
    private String[] second_range = new String[]{"Technology", "Food & Drinks", "Health & Fitness", "Solutions",
            "Money Savers", "Life Tips", "Survival", "Party", "Brainy", "Extras", "Household Hacks", "Jugad",
            "Travelling Hacks", "Student Hacks", "Workplace Hacks", "Pure Pakistani Hacks", "Makeup Hacks",
            "Beauty Hacks", "Cleaning Hacks", "Decorating Hacks", "Interview Hacks", "Car Hacks", "Summer Hacks",
            "Weight Loss Hacks", "Photography Hacks"};

    private Typeface simple_type;
    private Toolbar toolbar;
    Cursor c;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);


        for (String category : this.second_range) {
            HackList hackList = new HackList();
            hackList.setCategory(category);
            this.hackLists.add(hackList);
        }
        this.recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        this.recyclerView.setHasFixedSize(true);
        DataAdaptar adapter = new DataAdaptar(this.hackLists);
        this.recyclerView.setAdapter(adapter);
        this.recyclerView.setNestedScrollingEnabled(false);
        adapter.setOnItemClickListener(new DataAdaptar.MyClickListener() {
            @Override
            public void onItemClick(View view) {
                Intent intent = new Intent(MainActivity.this, FullScreenHackActivity.class);
                MainActivity.this.startActivity(intent);
                return;
            }
        });


        /*  Code for checking the connection of DATABASE.  */


//        DataBaseHelper databaseHelper = new DataBaseHelper(MainActivity.this);
//        try {
//            databaseHelper.createDatabase();
//        }catch (IOException e){
//            throw new Error("Unable to create database");
//        }
//        try {
//            databaseHelper.openDatabase();
//        }catch (SQLException sqle){
//            throw sqle;
//        }
//        Toast.makeText(MainActivity.this,"Successfully Impoted", Toast.LENGTH_SHORT).show();
//        c = databaseHelper.query("lifehacks", null, null, null, null, null, null);
//
//        if (c.moveToFirst()){
//            do {
//                Toast.makeText(MainActivity.this,
//                                "_id: " + c.getString(0) + "\n" +
//                                "category: " + c.getString(1) + "\n" +
//                        "hack: " + c.getString(2) + "\n",
//                        Toast.LENGTH_SHORT).show();
//            }while (c.moveToNext());
//        }



    }


}
