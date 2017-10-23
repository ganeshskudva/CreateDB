package com.example.gkudva.createdb;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private DBHelper dbHelper;
    private Random random;
    private List<Event> eventList;
    private List<Venue> venuesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = DBHelper.getInstance(this);
        random = new Random();
        eventList = new ArrayList<Event>();
        venuesList = new ArrayList<Venue>();
        try {
            readFromAssets(this, "dataFile");
        }
        catch (Exception ex)
        {
            Log.d("Ganesh", ex.getMessage());
        }

        dbHelper.updateVenues(venuesList);
        dbHelper.updateEvents(eventList);

    }

    public String getString(String str)
    {
        return str.substring(str.indexOf(":")+1, str.length()).trim();
    }

    public String readFromAssets(Context context, String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(filename)));

        // do reading, usually loop until end of file reading
        StringBuilder sb = new StringBuilder();
        String mLine = reader.readLine();
        String str;
        boolean contentSeen = false;

        String id = null, tags = null, pubDate= null, title= null, permalink=null, content="", start=null, end=null, lat=null, lng=null, cost=null,
                costType=null, vName=null, vAdd=null, img=null, category=null, modDate=null, bookmark=null, author = null, vID = null, bartSt = null, excerpt = null;
        while (mLine != null) {
            sb.append(mLine); // process line
            str = getString(mLine);
            if (mLine.contains("Gid"))
                id  = str;

            if (mLine.contains("Gtitle"))
                title = str;

            if (mLine.contains("Gpermalink"))
                permalink = str;

            if (mLine.contains("GStartDate")) {
                contentSeen =false;
                start = str;
            }

            if (mLine.contains("Gcontent") || contentSeen) {
                contentSeen = true;
                if (!str.isEmpty())
                    content += str;
            }

            if (mLine.contains("GEndDate"))
                end = str;

            if (mLine.contains("Glat"))
                lat = str;

            if (mLine.contains("Glong"))
                lng = str;

            if (mLine.contains("GCost")) {
                if (mLine.contains("GCostType"))
                    costType = str;
                else
                    cost = str;
            }



            if (mLine.contains("GVenueName"))
                vName = str;

            if (mLine.contains("GVenueAddress"))
                vAdd = str;

            if (mLine.contains("GImage"))
                img = str;

            if (mLine.contains("GCategory"))
                category = str;

            if (mLine.contains("GModifiedDate"))
                modDate = str;

            if (mLine.contains("GBookmarked"))
                bookmark = str;

            if (mLine.contains("GBartStation"))
                bartSt = str;

            if (mLine.contains("GVenueId"))
                vID = str;

            if (mLine.contains("GAuthor"))
                author = str;

            if (mLine.contains("GExcerpt"))
                excerpt = str;

            if (mLine.contains("GPubDate"))
                pubDate = str;

            if (mLine.contains("GTags"))
                tags = str;

            if (mLine.contains("ENDEND")) {

                Venue venue = new Venue(vID, vName, vAdd, lat, lng);
                venuesList.add(venue);

                Event event = new Event(id,
                        title,
                        permalink,
                        start,
                        end,
                        modDate,
                        cost,
                        costType,
                        img,
                        category,
                        0,
                        content,
                        author,
                        bartSt,
                        excerpt,
                        pubDate,
                        tags,
                        vID
                        );

                eventList.add(event);



                id = null;
                title= null;
                permalink=null;
                content="";
                start=null;
                end=null;
                lat=null;
                lng=null;
                cost=null;
                costType=null;
                vName=null;
                vAdd=null;
                img=null;
                category=null;
                modDate=null;
                bookmark=null;
                vID = null;
                author = null;
                excerpt = null;
                bartSt = null;
                pubDate = null;
            }

            mLine = reader.readLine();
        }
        reader.close();
        return sb.toString();
    }
}
