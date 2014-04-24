package com.ase.mymoney.models;

import java.util.Date;

public class Expance {
	
	public static String TABLE_NAME = "expances";
	
	public static String COLUMN_ID = "id";
	public static String COLUMN_EXPANCE_TYPE_ID = "expanceTypeId";
	public static String COLUMN_TITLE = "title";
	public static String COLUMN_SUM = "sum";
	public static String COLUMN_UM = "um";
	public static String COLUMN_CREATED = "created";

	private int id;
	private int expanceTypeId;
	private String title;
	private float sum;
	private int um;
	private long created;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getExpanceTypeId() {
		return expanceTypeId;
	}

	public void setExpanceTypeId(int expance_type_id) {
		this.expanceTypeId = expance_type_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getSum() {
		return sum;
	}

	public void setSum(float sum) {
		this.sum = sum;
	}

	public int getUm() {
		return um;
	}

	public void setUm(int um) {
		this.um = um;
	}
		
	public long getCreated() {
		return created;
	}

	public void setCreated(long created) {
		this.created = created;
	}

	public boolean save(){
		return true;
	}

	
}
