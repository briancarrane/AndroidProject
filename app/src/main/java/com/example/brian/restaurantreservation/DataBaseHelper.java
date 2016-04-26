package com.example.brian.restaurantreservation;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;


    public class DataBaseHelper extends SQLiteOpenHelper {
        // If you change the database schema, you must increment the database version.
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "restaurant.db";

        private static final String TEXT_TYPE = " TEXT";
        private static final String COMMA_SEP = ",";
        private static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                        FeedEntry.COLUMN_NAME_RESTAURANT_ID + " TEXT PRIMARY KEY," +
                        FeedEntry.COLUMN_NAME_DAY + TEXT_TYPE + COMMA_SEP +
                        FeedEntry.COLUMN_NAME_TIME + TEXT_TYPE + COMMA_SEP +
                        " )";

        private static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;

        public DataBaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);

        }
        public static abstract class FeedEntry implements BaseColumns {
            public static final String TABLE_NAME = "entries";
            public static final String COLUMN_NAME_RESTAURANT_ID = "name";
            public static final String COLUMN_NAME_DAY = "day";
            public static final String COLUMN_NAME_TIME = "time";
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_ENTRIES);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // This database is only a cache for online data, so its upgrade policy is
            // to simply to discard the data and start over
            db.execSQL(SQL_DELETE_ENTRIES);
            onCreate(db);
        }

        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }
        public boolean insertData(String name,String day,String time) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(FeedEntry.COLUMN_NAME_RESTAURANT_ID,name);
            contentValues.put(FeedEntry.COLUMN_NAME_DAY,day);
            contentValues.put(FeedEntry.COLUMN_NAME_TIME,time);
            long result = db.insert(FeedEntry.TABLE_NAME,null,contentValues);
            if (result == -1)
            {
                return false;
            }
            else
            {
                return true;
            }

        }
    }

