package com.ase.mymoney.utils;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.ase.mymoney.models.ExpanceType;

public class DatabaseHelper extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "MyMoneyDB";
	
	
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String create_expance_types = "CREATE TABLE "+ExpanceType.TABLE_NAME+" ( " +
                ExpanceType.COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " + 
                ExpanceType.COLUMN_TITLE+" TEXT, "+
                ExpanceType.COLUMN_REMINDER_DAY+" INTEGER )";
 
        // create books table
        db.execSQL(create_expance_types);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		
	}
	
	
	/*
	 * return inserted id; -1 on error occurred
	 * */
	public long addExpanceType( ExpanceType expanceType ){
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues contentValues = new ContentValues();
		contentValues.put(ExpanceType.COLUMN_TITLE, expanceType.getTitle());
		contentValues.put(ExpanceType.COLUMN_REMINDER_DAY, expanceType.getReminderDay());
		
		long id = db.insert(ExpanceType.TABLE_NAME, null, contentValues);
		db.close();
		return id;
	}
	
	public List<ExpanceType> getAllExpanceTypes(){
		SQLiteDatabase db = this.getWritableDatabase();
		String query = "SELECT * FROM " +ExpanceType.TABLE_NAME;
		Cursor cursor = db.rawQuery(query, null);
		ExpanceType expanceType;
		List<ExpanceType> list = new ArrayList<ExpanceType>();
		
		if(cursor.moveToFirst()){
			do{
				expanceType = new ExpanceType();
				expanceType.setId(cursor.getInt(0));
				expanceType.setTitle(cursor.getString(1));
				expanceType.setReminderDay(cursor.getInt(2));
				list.add(expanceType);
			}while(cursor.moveToNext());
		}
		
		return list;
		
	}

}
