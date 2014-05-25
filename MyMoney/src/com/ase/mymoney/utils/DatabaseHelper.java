package com.ase.mymoney.utils;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.ase.mymoney.models.Expance;
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
		
		String create_expances = "CREATE TABLE "+Expance.TABLE_NAME+" ( "+
				Expance.COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
				Expance.COLUMN_EXPANCE_TYPE_ID+" INTEGER, "+
                Expance.COLUMN_TITLE+" TEXT, "+
                Expance.COLUMN_SUM+" REAL, "+
                Expance.COLUMN_CREATED+" INTEGER, "+
                Expance.COLUMN_LATITUDE+" NUMERIC, "+
                Expance.COLUMN_LONGITUDE+" NUMERIC, "+
                Expance.COLUMN_UM+" INTEGER )";
		
        db.execSQL(create_expance_types); // create expance_types table
        db.execSQL(create_expances); // create expances table
        
        insertDefaultExpanceTypes(db);
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
	
	public long addExpance(Expance expance){
		
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues contentValues = new ContentValues();
		contentValues.put(Expance.COLUMN_EXPANCE_TYPE_ID, expance.getExpanceTypeId());
		contentValues.put(Expance.COLUMN_SUM, expance.getSum());
		contentValues.put(Expance.COLUMN_TITLE, expance.getTitle());
		contentValues.put(Expance.COLUMN_UM, expance.getUm());
		contentValues.put(Expance.COLUMN_LATITUDE, expance.getLatitude());
		contentValues.put(Expance.COLUMN_LONGITUDE, expance.getLongitude());
		contentValues.put(Expance.COLUMN_CREATED, expance.getCreated());
		
		long id = db.insert(Expance.TABLE_NAME, null, contentValues);
		db.close();
		return id;
		
	}
	
	public List<Expance> getAllExpance(){
		SQLiteDatabase db = this.getWritableDatabase();
		String query = "SELECT * FROM " +Expance.TABLE_NAME;
		Cursor cursor = db.rawQuery(query, null);
		Expance expance;
		List<Expance> list = new ArrayList<Expance>();
		
		if(cursor.moveToFirst()){
			do{
				expance = new Expance();
				expance.setId(cursor.getInt(0));
				expance.setExpanceTypeId(cursor.getInt(1));
				expance.setTitle(cursor.getString(2));
				expance.setSum(cursor.getFloat(3));
				expance.setCreated(cursor.getLong(4));
				expance.setLatitude(cursor.getFloat(5));
				expance.setLongitude(cursor.getFloat(6));
				expance.setUm(cursor.getInt(7));
				list.add(expance);
			}while(cursor.moveToNext());
		}
		
		return list;
		
	}
	
	public void removeExpance(Expance e){
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(Expance.TABLE_NAME, Expance.COLUMN_ID+"= ? ", new String[]{String.valueOf(e.getId())});
		db.close();
	}
	
	private void insertDefaultExpanceTypes(SQLiteDatabase db){
		String query = "INSERT INTO " +ExpanceType.TABLE_NAME+ " VALUES "+
				"(1, 'Food', 0), "+
				"(2, 'Fitness&Health', 0), "+
				"(3, 'Travel', 0), "+
				"(4, 'Fuel', 0), "+
				"(5, 'Bank', 0), "+
				"(6, 'Others', 0)";
		db.execSQL(query);
	}

}
