package com.ase.mymoney.models;

import com.ase.mymoney.BaseActivity;

public class ExpanceType {
	
    public static final String TABLE_NAME = "expance_types";

    // PERSISTENCE
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_REMINDER_DAY = "reminder_day";
    public static final String[] COLUMNS = {COLUMN_ID,COLUMN_TITLE,COLUMN_REMINDER_DAY};
	
    //fields
    private int id;
	private String title;
	private int reminderDay;
	
	
	public ExpanceType() {
		super();
	}
	
	public ExpanceType(String title, int reminderDay) {
		super();
		this.title = title;
		this.reminderDay = reminderDay;
	}
	
	public ExpanceType(int id, String title, int reminderDay) {
		super();
		this.id = id;
		this.title = title;
		this.reminderDay = reminderDay;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public int getReminderDay() {
		return reminderDay;
	}



	public void setReminderDay(int reminderDate) {
		this.reminderDay = reminderDate;
	}



	
	/*
	 * return inserted id; -1 on error occurred
	 * */
	public long save(){
		return BaseActivity.dbHelper.addExpanceType(this);
	}
	
	@Override
	public String toString() {
		return this.title;
	}
}
