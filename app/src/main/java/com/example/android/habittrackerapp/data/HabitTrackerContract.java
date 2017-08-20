package com.example.android.habittrackerapp.data;

import android.provider.BaseColumns;

/**
 * Created by anu on 18/8/17.
 */

public class HabitTrackerContract {
    //to prevent accidental initialization
    private HabitTrackerContract() {
    }

    public static final class HabitTracker implements BaseColumns {

        //Name of the database table
        public static final String TABLE_NAME = "habits";
        //Unique table Id
        public static final String _ID = BaseColumns._ID;
        //Name of the habit
        public static final String COLUMN_HABIT_NAME = "habit_name";
        //Comments theat the user wants to add for the habit
        public static final String COLUMN_HABIT_COMMENT = "habit_comment";
        //Date when the habit occurred
        public static final String COLUMN_HABIT_DATE = "habit_date";
        //Time duration of the habit
        public static final String COLUMN_HABIT_DURATION = "habit_duration";
        //Nature of the habit whether its a good one or a bad one
        public static final String COLUMN_HABIT_NATURE = "habit_nature";
        //priority of the habit ranging in numbers
        public static final String COLUMN_HABIT_PRIORITY = "habit_priority";

        //Possible values for nature of habit
        public static final String NATURE_GOOD = "good";
        public static final String NATURE_BAD = "bad";

        /**
         * Returns whether its a valid nature of habit
         */
        public static boolean isValidNature(String natureOfHabit) {
            if (natureOfHabit == NATURE_GOOD || natureOfHabit == NATURE_BAD) {
                return true;
            }
            return false;
        }
    }
}
