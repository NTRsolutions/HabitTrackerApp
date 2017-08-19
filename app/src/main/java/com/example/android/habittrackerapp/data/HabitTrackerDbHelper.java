package com.example.android.habittrackerapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by anu on 18/8/17.
 */

public class HabitTrackerDbHelper extends SQLiteOpenHelper {
    /**
     * Name of the database file
     */
    private static final String DATABASE_NAME = "habits.db";

    /**
     * Database version
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Default Constructor
     */
    public HabitTrackerDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This method is called when the database is created for the first time
     */
    @Override
    public void onCreate(SQLiteDatabase sqlDb) {
        // Create a String that contains the SQL statement to create the table
        String SQL_CREATE_TABLE = "CREATE TABLE " + HabitTrackerContract.HabitTracker.TABLE_NAME + "(" +
                HabitTrackerContract.HabitTracker._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                HabitTrackerContract.HabitTracker.COLUMN_HABIT_NAME + " TEXT NOT NULL, " +
                HabitTrackerContract.HabitTracker.COLUMN_HABIT_DATE + " TEXT NOT NULL, " +
                HabitTrackerContract.HabitTracker.COLUMN_HABIT_COMMENT + " TEXT NOT NULL, " +
                HabitTrackerContract.HabitTracker.COLUMN_HABIT_DURATION + " TEXT NOT NULL, " +
                HabitTrackerContract.HabitTracker.COLUMN_HABIT_NATURE + " TEXT ); ";

        // Execute the SQL statement
        sqlDb.execSQL(SQL_CREATE_TABLE);
    }

    /**
     * This methods inserts data into the table
     */
    public void insertData(String name, String date, String comment, String duration, String nature) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues habitValues = new ContentValues();
        habitValues.put(HabitTrackerContract.HabitTracker.COLUMN_HABIT_NAME, name);
        habitValues.put(HabitTrackerContract.HabitTracker.COLUMN_HABIT_DATE, date);
        habitValues.put(HabitTrackerContract.HabitTracker.COLUMN_HABIT_COMMENT, comment);
        habitValues.put(HabitTrackerContract.HabitTracker.COLUMN_HABIT_DURATION, duration);
        habitValues.put(HabitTrackerContract.HabitTracker.COLUMN_HABIT_NATURE, nature);

        sqLiteDatabase.insert(HabitTrackerContract.HabitTracker.TABLE_NAME, null, habitValues);
    }

    /*Method to fetch records from the table*/
    public Cursor queryData() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String[] projection = {
                HabitTrackerContract.HabitTracker._ID,
                HabitTrackerContract.HabitTracker.COLUMN_HABIT_NAME,
                HabitTrackerContract.HabitTracker.COLUMN_HABIT_DATE,
                HabitTrackerContract.HabitTracker.COLUMN_HABIT_COMMENT,
                HabitTrackerContract.HabitTracker.COLUMN_HABIT_DURATION,
                HabitTrackerContract.HabitTracker.COLUMN_HABIT_NATURE,
        };

        return sqLiteDatabase.query(
                HabitTrackerContract.HabitTracker.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
    }

    /**
     * This method is called when the database needs an upgrade.
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqlDb, int oldVersion, int newVersion) {

    }
}
