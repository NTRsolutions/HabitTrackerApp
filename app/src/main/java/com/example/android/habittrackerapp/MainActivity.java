package com.example.android.habittrackerapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.android.habittrackerapp.data.HabitTrackerContract;
import com.example.android.habittrackerapp.data.HabitTrackerDbHelper;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Insert records to test */
        HabitTrackerDbHelper mDbHelper = new HabitTrackerDbHelper(this);

        mDbHelper.insertData("Eating BreakFast",
                "08-18-2017", "The most important meal of the day", "30 mins",
                HabitTrackerContract.HabitTracker.NATURE_GOOD);

        mDbHelper.insertData("Exercise",
                "08-18-2017", "Brisk walking", "60 mins",
                HabitTrackerContract.HabitTracker.NATURE_GOOD);

        mDbHelper.insertData("Reading",
                "08-18-2017", "Continued reading haruki murakami", "45 mins",
                HabitTrackerContract.HabitTracker.NATURE_GOOD);

        mDbHelper.insertData("Drinking",
                "08-18-2017", "Had a pint of beer", "45 mins",
                HabitTrackerContract.HabitTracker.NATURE_BAD);

        /** Read the records */
        Cursor readCursor = mDbHelper.queryData();

        try {
            while (readCursor.moveToNext()) {
                Log.i(LOG_TAG,
                        "Habit >> " + readCursor.getInt(0) + " / "
                                + readCursor.getString(1) + " / "
                                + readCursor.getString(2) + " / "
                                + readCursor.getString(3) + " " + readCursor.getString(4) + " / "
                                + readCursor.getString(5));
            }
        } finally {
            readCursor.close();
        }
    }
}
