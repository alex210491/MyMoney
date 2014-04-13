package com.ase.mymoney.models;

public class Expance {
	
	public static String TABLE_NAME = "expances";
	
	public static String COLUMN_ID = "id";
	public static String COLUMN_EXPANCE_TYPE_ID = "expance_type_id";
	public static String COLUMN_TITLE = "title";
	public static String COLUMN_SUM = "sum";
	public static String COLUMN_UM = "um";

	private int id;
	private int expance_type_id;
	private String title;
	private float sum;
	private int um;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getExpance_type_id() {
		return expance_type_id;
	}

	public void setExpance_type_id(int expance_type_id) {
		this.expance_type_id = expance_type_id;
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
		
	public boolean save(){
		return true;
	}

	
}
