package com.example.mynew;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBOpenHelperCalander extends SQLiteOpenHelper {

    private static final String CREATE_EVENTS_TABLE = "create table" + DBStructureCalander.EVENT_TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"
            + DBStructureCalander.EVENT + "TEXT," + DBStructureCalander.TIME + "TEXT," + DBStructureCalander.DATE + "TEXT," + DBStructureCalander.MONTH + "TEXT,"
            + DBStructureCalander.YEAR + "TEXT)";
    private static final String DROP_EVENT_TABLE = "DROP TABLE IF EXISTS" + DBStructureCalander.EVENT_TABLE_NAME;


    public DBOpenHelperCalander(@Nullable Context context) {
        super(context, DBStructureCalander.DB_NAME, null, DBStructureCalander.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_EVENTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_EVENT_TABLE);
        onCreate(db);

    }

    public void SaveEvent(String event, String time, String date, String month, String year, SQLiteDatabase database) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBStructureCalander.EVENT, event);
        contentValues.put(DBStructureCalander.TIME, time);
        contentValues.put(DBStructureCalander.DATE, date);
        contentValues.put(DBStructureCalander.MONTH, month);
        contentValues.put(DBStructureCalander.YEAR, year);
        database.insert(DBStructureCalander.EVENT_TABLE_NAME, null, contentValues);


    }

    public Cursor ReadEvents(String date, SQLiteDatabase database) {
        String[] Projections = {DBStructureCalander.EVENT, DBStructureCalander.TIME, DBStructureCalander.DATE, DBStructureCalander.MONTH, DBStructureCalander.YEAR};
        String Selection = DBStructureCalander.DATE + "=?";
        String[] SelectionArgs = {date};

        return database.query(DBStructureCalander.EVENT_TABLE_NAME, Projections, Selection, SelectionArgs, null, null, null);
    }

    public Cursor ReadEventsperMonths(String month, String year, SQLiteDatabase database) {
        String[] Projections = {DBStructureCalander.EVENT, DBStructureCalander.TIME, DBStructureCalander.DATE, DBStructureCalander.MONTH, DBStructureCalander.YEAR};
        String Selection = DBStructureCalander.MONTH + "=? and " + DBStructureCalander.YEAR + "=?";
        String[] SelectionArgs = {month, year};

        return database.query(DBStructureCalander.EVENT_TABLE_NAME, Projections, Selection, SelectionArgs, null, null, null);
    }
}