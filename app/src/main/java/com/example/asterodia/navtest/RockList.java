package com.example.asterodia.navtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.analytics.ecommerce.Product;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class RockList extends AppCompatActivity {
    private ArrayList<Rock> rocks = null;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> rockNames;

    public class Rock
    {
        public String name, image, desc, location, subtype;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ExpandableListView rocksList = (ExpandableListView) findViewById(R.id.rocksList);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, rockNames);

        rocksList.setAdapter(adapter);
        rocksList.setTextFilterEnabled(true);


        XmlPullParserFactory pullParserFactory;
        try {
            pullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = pullParserFactory.newPullParser();

            InputStream in_s = getApplicationContext().getAssets().open("rocks.xml");

            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in_s, null);

            parseXML(parser);

        } catch (XmlPullParserException | IOException e) {

            e.printStackTrace();
        }

        rocksList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                String item = ((TextView) view).getText().toString();

                Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();

            }
        });
    }

    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        String item = ((TextView)view).getText().toString();

        Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();

    }

    private void parseXML(XmlPullParser parser) throws XmlPullParserException,IOException
    {
        TextView testing = (TextView)findViewById(R.id.testing);
        testing.setText("Test1");
        rocks = new ArrayList();
        int eventType = parser.getEventType();
        Rock currentRock = null;

        String names = "";
        while (eventType != XmlPullParser.END_DOCUMENT){
            String name = null;
            switch (eventType){
                case XmlPullParser.START_DOCUMENT:
                    names+= "start";
                    rocks = new ArrayList();
                    break;
                case XmlPullParser.START_TAG:
                    name = parser.getName();
                    if (name.equals("rock")){
                        currentRock = new Rock();
                    } else if (currentRock != null){
                        if (name.equals("rock_name")){
                            currentRock.name = parser.nextText();
                            names += ": " + currentRock.name;
                        } else if (name.equals( "rock_image")){
                            currentRock.image = parser.nextText();
                            names += ": " + currentRock.image;
                        } else if (name.equals( "rock_desc")){
                            currentRock.desc= parser.nextText();
                            names += ": " + currentRock.desc;
                        } else if (name.equals( "rock_location")){
                            currentRock.location= parser.nextText();
                            names += ": " + currentRock.location;
                        } else if (name.equals( "rock_subtype")){
                            currentRock.subtype= parser.nextText();
                            names += ": " + currentRock.subtype;
                        }
                    }
                    else
                    {
                        names += " FAILED ";
                    }
                    break;
                case XmlPullParser.END_TAG:
                    name = parser.getName();
                    names += "; end" + name;
                    if (name.equalsIgnoreCase("rock")){
                        names += "Hello!";
                        if(currentRock != null) {
                            rocks.add(currentRock);
                            names += "hello " + currentRock.name;
                        }
                    }
            }
            eventType = parser.next();
        }

        rockNames = new ArrayList<String>();

        for (int i = 0; i < rocks.size() ; i++)
        {
            rockNames.add(rocks.get(i).name);
        }


        adapter.notifyDataSetChanged();

    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

    public void onHomeButtonClick (View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


}
