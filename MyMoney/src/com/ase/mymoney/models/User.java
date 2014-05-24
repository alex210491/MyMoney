package com.ase.mymoney.models;

import java.util.Date;

import android.content.Context;
import android.content.SharedPreferences;

import com.ase.mymoney.utils.CommonUtils;

public class User {

	public String firstName;
	public String lastName;
	public String sex;
	public int unit;
	public Date date;
	public String email;
	public float buget;

	public User() {
		super();
	}

	public User(String firtsName, String lastName, String sex, int unit, String email, Date date, float buget) {
		super();
		this.firstName = firtsName;
		this.lastName = lastName;
		this.sex = sex;
		this.unit = unit;
		this.email = email;
		this.date = date;
		this.buget = buget;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getBuget() {
		return buget;
	}

	public void setBuget(float buget) {
		this.buget = buget;
	}

	public boolean save() {
		SharedPreferences sp = CommonUtils.mContext.getSharedPreferences(
				"MyMoneyProfil", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();

		editor.putString("USER_FIRST_NAME", firstName);
		editor.putString("USER_LAST_NAME", lastName);
		editor.putString("USER_EMAIL", email);
		editor.putFloat("USER_BUGET", buget);
		editor.putString("USER_SEX", sex);
		editor.putInt("USER_UNIT", unit);
		editor.putLong("USER_BIRTHDAY", date.getTime());

		editor.commit();

		return true;
	}
	
	public static User getCurrentUser(){
		User currentUser = null;
		SharedPreferences sp = CommonUtils.mContext.getSharedPreferences("MyMoneyProfil", Context.MODE_PRIVATE);
		
		String firstname = sp.getString("USER_FIRST_NAME", null);
		String lastname = sp.getString("USER_LAST_NAME", null);
		String email = sp.getString("USER_EMAIL", null);
		String sex = sp.getString("USER_SEX", null);
		float buget = sp.getFloat("USER_BUGET", 0);
		int unit = sp.getInt("USER_UNIT", CommonUtils.UM_RON);
		Date d = new Date();
		long time = sp.getLong("USER_BIRTHDAY", 0);
		d.setTime(time);
		
		if(firstname!=null){ //user exists
			currentUser = new User(firstname, lastname, sex, unit, email, d, buget);
		}
		return currentUser;
	}

}
