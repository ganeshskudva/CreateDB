package com.example.gkudva.createdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.List;
import java.util.Random;

import static android.provider.Contacts.SettingsColumns.KEY;

/**
 * Created by gkudva on 19/10/17.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static String TAG = "EventsDBHelper";
    private static final String DATABASE_NAME = "MySFfuncheapDatabase.db";
    private static final int DATABASE_VERSION = 3;

    private static int maxId = 1;

    private static final String TABLE_EVENTS = "events";
    private static final String TABLE_VENUE = "venue";
    private static final String TABLE_FILTER = "filter";


    private static final String KEY_ID= "id";
    private static final String KEY_UNIQUE_ID= "uniqueId";
    private static final String KEY_EVENT_ID= "eventId";
    private static final String KEY_TITLE= "title";
    private static final String KEY_PERMALINK= "permalink";
    private static final String KEY_CONTENT= "content";
    private static final String KEY_START_DATE= "startDate";
    private static final String KEY_END_DATE= "endDate";
    private static final String KEY_LAT= "latitude";
    private static final String KEY_LNG= "longitude";
    private static final String KEY_COST= "cost";
    private static final String KEY_COSTTYPE= "costDetails";
    private static final String KEY_VNAME= "venueName";
    private static final String KEY_vADD= "venueAddress";
    private static final String KEY_THUMB= "thumbnail";
    private static final String KEY_CATEGORY= "category";
    private static final String KEY_MODIFIED_DATE= "modifiedDate";
    private static final String KEY_BOOKMARK= "bookmark";
    private static final String KEY_AUTHOR= "author";
    private static final String KEY_VID= "venueId";
    private static final String KEY_BARTST= "bartStation";
    private static final String KEY_EXCERPT= "excerpt";
    private static final String KEY_PUBLISH_DATE= "publishDate";
    private static final String KEY_TAGS= "tags";
    private static final String KEY_VENUE = "venue";

    private static final String KEY_FILTER_ID = "id";
    private static final String KEY_FILTER_QUERY = "query";
    private static final String KEY_FILTER_WHENDATE = "whenDate";
    private static final String KEY_FILTER_EX_STARTDATE = "explicitStartDate";
    private static final String KEY_FILTER_EX_ENDDATE = "explicitEndDate";
    private static final String KEY_FILTER_FREE = "free";
    private static final String KEY_FILTER_VENUE_QUERY = "venueQuery";
    private static final String KEY_FILTER_CATEGORIES = "categories";

    private Random random;

    private static DBHelper sInstance;

    public static synchronized DBHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DBHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    private DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_VENUE_FILTER = "CREATE TABLE " + TABLE_FILTER +
                "(" +
                KEY_FILTER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                KEY_FILTER_QUERY + " TEXT," +
                KEY_FILTER_WHENDATE + " TEXT," +
                KEY_FILTER_EX_STARTDATE + " TEXT," +
                KEY_FILTER_EX_ENDDATE + " TEXT," +
                KEY_FILTER_FREE + " INTEGER DEFAULT(0)," +
                KEY_FILTER_VENUE_QUERY + " TEXT," +
                KEY_FILTER_CATEGORIES + " TEXT" +
                ")";

        db.execSQL(CREATE_VENUE_FILTER);

        String CREATE_VENUE_TABLE = "CREATE TABLE " + TABLE_VENUE +
                "(" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_VID + " TEXT," +
                KEY_VNAME + " TEXT," +
                KEY_vADD + " TEXT," +
                KEY_LAT + " TEXT," +
                KEY_LNG + " TEXT" +
                ")";

        db.execSQL(CREATE_VENUE_TABLE);

        String CREATE_EVENT_TABLE = "CREATE TABLE " + TABLE_EVENTS +
                "(" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + // Define a primary key
                KEY_EVENT_ID + " TEXT," +
                KEY_TITLE + " TEXT," +
                KEY_PERMALINK + " TEXT," +
                KEY_CONTENT + " TEXT," +
                KEY_START_DATE + " TEXT," +
                KEY_END_DATE + " TEXT," +
                KEY_MODIFIED_DATE + " TEXT," +
                KEY_COST + " TEXT," +
                KEY_COSTTYPE + " TEXT," +
                KEY_THUMB + " TEXT," +
                KEY_CATEGORY + " TEXT," +
                KEY_AUTHOR + " TEXT," +
                KEY_BARTST + " TEXT," +
                KEY_EXCERPT + " TEXT," +
                KEY_TAGS + " TEXT," +
                KEY_PUBLISH_DATE + " TEXT," +
                KEY_BOOKMARK + " INTEGER," +
                KEY_VID + " STRING" +
                ")";

        db.execSQL(CREATE_EVENT_TABLE);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENTS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_VENUE);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_FILTER);
            onCreate(db);
        }
    }

    public void updateVenues(List<Venue> venueList)
    {
        for (Venue venue: venueList)
        {
            updateVenueTask(venue);
        }
    }

    public void updateVenueTask(Venue venue)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try
        {
            ContentValues values = new ContentValues();

            values.put(KEY_VID, venue.getvId());
            values.put(KEY_VNAME, venue.getvName());
            values.put(KEY_vADD, venue.getvAdd());
            values.put(KEY_LAT, venue.getLat());
            values.put(KEY_LNG, venue.getLng());
            db.insertOrThrow(TABLE_VENUE, null, values);
            db.setTransactionSuccessful();

        }
        catch(Exception ex)
        {
            Log.d("Ganesh", ex.getMessage());
        }
        finally {
            db.endTransaction();
        }
    }

    public void updateEvents(List<Event> eventList)
    {
        for (Event event:  eventList)
        {
            updateTask(event);
        }
    }

    public void updateTask(Event event) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();

            values.put(KEY_EVENT_ID, event.getId());
            values.put(KEY_TITLE, event.getTitle());
            values.put(KEY_PERMALINK, event.getPermalink());
            values.put(KEY_CONTENT, event.getContent());
            values.put(KEY_START_DATE, event.getStartDate());
            values.put(KEY_END_DATE, event.getEndDate());
            values.put(KEY_MODIFIED_DATE, event.getModifiedDate());
            values.put(KEY_COST, event.getCost());
            values.put(KEY_COSTTYPE, event.getCostType());
            values.put(KEY_THUMB, event.getThumb());
            values.put(KEY_CATEGORY, event.getCategory());
            values.put(KEY_BOOKMARK, event.getBookmark());
            values.put(KEY_AUTHOR, event.getAuthor());
            values.put(KEY_BARTST, event.getBartstation());
            values.put(KEY_EXCERPT, event.getExcerpt());
            values.put(KEY_TAGS, event.getTags());
            values.put(KEY_VID, event.getVenueId());
            values.put(KEY_PUBLISH_DATE, event.getPublishDate());
            db.insertOrThrow(TABLE_EVENTS, null, values);
            db.setTransactionSuccessful();

            if (maxId == 100)
            {
                int j;
            }

            maxId++;


        }
        catch(Exception ex)
        {
            Log.d("Ganesh", ex.getMessage());
        }
        finally {
            db.endTransaction();
        }
    }

}
