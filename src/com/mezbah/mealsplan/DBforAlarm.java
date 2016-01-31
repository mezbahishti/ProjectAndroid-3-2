package com.sazid.mealsplan;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBforAlarm extends SQLiteOpenHelper {

	public static final String DB_NAME="iddatabase.db";
	public static final int DB_VERSION=1;
	public static final String TABLE_NAME="idtable";
	public static final String TABLE_ID="id";
	public static final String TABLE_USER="NameForAlarm";
	public static final String TABLE_TIME="time";
	public static final String query="create table "+TABLE_NAME+" ("+TABLE_USER+" TEXT, "+TABLE_ID+" TEXT, "+TABLE_TIME+ " TEXT)";

	public DBforAlarm(Context context) {
		super(context,DB_NAME, null, DB_VERSION);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.d("crt", "created");

		db.execSQL(query);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int newVersion, int oldVersion) {
		db.execSQL("drop table if exists "+TABLE_NAME);

	}

}
