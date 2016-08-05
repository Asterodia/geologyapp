package com.example.asterodia.navtest;

import android.app.Activity;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Asterodia on 30/07/2016.
 */
public class RockXMLReader {
    private ArrayList<Rock> rocks = null;
    private ArrayList<String> rockNames;

    RockXMLReader(Activity active)
    {
        XmlPullParserFactory pullParserFactory;
        try {
            pullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = pullParserFactory.newPullParser();

            InputStream in_s = active.getApplicationContext().getAssets().open("rocks.xml");

            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in_s, null);

            parseXML(parser);

        } catch (XmlPullParserException | IOException e) {

            e.printStackTrace();
        }
    }

    public ArrayList<String> getRockNames()
    {
        return rockNames;
    }

    public ArrayList<Rock> getRocks()
    {
        return rocks;
    }

    private void parseXML(XmlPullParser parser) throws XmlPullParserException,IOException
    {
        rocks = new ArrayList();
        int eventType = parser.getEventType();
        Rock currentRock = null;

        while (eventType != XmlPullParser.END_DOCUMENT){
            String name = null;
            switch (eventType){
                case XmlPullParser.START_DOCUMENT:
                    rocks = new ArrayList();
                    break;
                case XmlPullParser.START_TAG:
                    name = parser.getName();
                    if (name.equals("rock")){
                        currentRock = new Rock();
                    } else if (currentRock != null){
                        if (name.equals("rock_name")){
                            currentRock.name = parser.nextText();
                        } else if (name.equals( "rock_image")){
                            currentRock.image = parser.nextText();
                        } else if (name.equals( "rock_desc")){
                            currentRock.desc= parser.nextText();
                        } else if (name.equals( "rock_location")){
                                currentRock.location = parser.nextText();
                        } else if (name.equals("location_image")){
                            currentRock.locationImage = parser.nextText();
                        } else if (name.equals( "rock_subtype")){
                            currentRock.subtype= parser.nextText();
                        }
                    }
                    break;
                case XmlPullParser.END_TAG:
                    name = parser.getName();
                    if (name.equalsIgnoreCase("rock")){
                        if(currentRock != null) {
                            rocks.add(currentRock);
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
    }

}
