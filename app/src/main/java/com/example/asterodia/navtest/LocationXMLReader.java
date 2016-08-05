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
 * Created by Asterodia on 31/07/2016.
 */
public class LocationXMLReader {


    private ArrayList<Location> locations = null;
    private ArrayList<String> locationNames;

    LocationXMLReader(Activity active)
    {
        XmlPullParserFactory pullParserFactory;
        try {
            pullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = pullParserFactory.newPullParser();

            InputStream in_s = active.getApplicationContext().getAssets().open("locations.xml");

            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in_s, null);

            parseXML(parser);

        } catch (XmlPullParserException | IOException e) {

            e.printStackTrace();
        }
    }

    public ArrayList<String> getLocationNames()
    {
        return locationNames;
    }

    public ArrayList<Location> getLocations()
    {
        return locations;
    }

    private void parseXML(XmlPullParser parser) throws XmlPullParserException,IOException
    {
        locations = new ArrayList();
        int eventType = parser.getEventType();
        Location currentLocation = null;

        while (eventType != XmlPullParser.END_DOCUMENT){
            String name = null;
            switch (eventType){
                case XmlPullParser.START_DOCUMENT:
                    locations = new ArrayList();
                    break;
                case XmlPullParser.START_TAG:
                    name = parser.getName();
                    if (name.equals("location")){
                        currentLocation = new Location();
                    } else if (currentLocation != null){
                        if (name.equals("location_name")){
                            currentLocation.name = parser.nextText();
                        } else if (name.equals( "location_image")){
                            currentLocation.image = parser.nextText();
                        } else if (name.equals( "location_desc")){
                            currentLocation.desc= parser.nextText();
                        }
                    }
                    break;
                case XmlPullParser.END_TAG:
                    name = parser.getName();
                    if (name.equalsIgnoreCase("location")){
                        if(currentLocation != null) {
                            locations.add(currentLocation);
                        }
                    }
            }
            eventType = parser.next();
        }

        locationNames = new ArrayList<String>();

        for (int i = 0; i < locations.size() ; i++)
        {
            locationNames.add(locations.get(i).name);
        }
    }

}
