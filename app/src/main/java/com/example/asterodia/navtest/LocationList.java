package com.example.asterodia.navtest;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LocationList extends AppCompatActivity {

    private ExpandableListView mExpandableList;

    //Added by Alex
    private ExpandableListView locationsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_list);
        /*
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
        */
        //Variables

        LocationXMLReader reader = new LocationXMLReader(this);

        mExpandableList = (ExpandableListView) findViewById(R.id.locationsList);

        ArrayList<LocationParent> arrayParents = new ArrayList<LocationParent>();
        ArrayList<Location> locations = reader.getLocations();
        ArrayList<String> locationNames = reader.getLocationNames();

        //here we set the parents and the children
        for (int i = 0; i < locationNames.size(); i++) {
            //for each "i" create a new Parent object to set the title and the children
            LocationParent parent = new LocationParent();
            parent.setTitle(locationNames.get(i));

            parent.setChild(locations.get(i));

            //in this array we add the Parent object. We will use the arrayParents at the setAdapter
            arrayParents.add(parent);
        }

        //sets the adapter that provides data to the list.
        mExpandableList.setAdapter(new LocationAdapter(LocationList.this, arrayParents));
    }


    public void onHomeButtonClick (View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


}
