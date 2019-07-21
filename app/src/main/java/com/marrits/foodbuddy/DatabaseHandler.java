package com.marrits.foodbuddy;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

public class DatabaseHandler extends  SQLiteOpenHelper{
    //information of database

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "FoodBuddyDB.db";

    private static final String TABLE_NAME = "FoodItem";

    private static final String COLUMN_ID = "FoodItemID";

    private static final String COLUMN_NAME = "FoodItemName";

    //initialize the database

    DatabaseHandler(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override

    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID
                + " INTEGER PRIMARY KEY," + COLUMN_NAME + " TEXT )";
        db.execSQL(CREATE_TABLE);
    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}

    FoodItem loadHandler() {

        FoodItem item ;
        String query = "Select * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToNext();
            int result_0 = cursor.getInt(0);
            String result_1 = cursor.getString(1);

            item = new FoodItem(result_1, result_0);

        cursor.close();
        db.close();

        return item;
    }

    void addHandler(FoodItem foodItem) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, foodItem.getId());
        values.put(COLUMN_NAME, foodItem.getName());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();

    }

}
