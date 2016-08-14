package com.example.asterodia.navtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;
import java.util.ArrayList;

public class RockList extends AppCompatActivity {

    private ExpandableListView mExpandableList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_list);

        //Toolbar & Back button
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Show Icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Set navigation for toolbar
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //Variables
/*
        RockXMLReader reader = new RockXMLReader(this);

        mExpandableList = (ExpandableListView) findViewById(R.id.rocksList);

        ArrayList<RockParent> arrayParents = new ArrayList<RockParent>();
        ArrayList<Rock> rocks = reader.getRocks();
        ArrayList<String> rockNames = reader.getRockNames();

        //here we set the parents and the children
        for (int i = 0; i < rockNames.size(); i++) {
            //for each "i" create a new Parent object to set the title and the children
            RockParent parent = new RockParent();
            parent.setTitle(rockNames.get(i));

            parent.setChild(rocks.get(i));

            //in this array we add the Parent object. We will use the arrayParents at the setAdapter
            arrayParents.add(parent);
        }

        //sets the adapter that provides data to the list.
        mExpandableList.setAdapter(new RockAdapter(RockList.this, arrayParents));
        */
    }

    public void onHomeButtonClick (View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void onClick_rock_1 (View v)
    {
        Intent intent = new Intent(this, rock_1.class);
        startActivity(intent);
    }
}
