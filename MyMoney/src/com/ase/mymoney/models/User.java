package com.ase.mymoney.models;

import java.util.Date;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.RadioButton;

import com.ase.mymoney.utils.CommonUtils;

public class User {
	

	public static String firstName;
	public static String lastName;
	public static String sex;
	public static String unit;
	public static Date date;
	public static String password;
	public static String email;
	public static float buget;
	
	
	
	
	public User() {
		super();
	}


	public User(String firtsName, String lastName, String sex, String unit, String password, String email, Date date, float buget)
	{
		super();
		this.firstName=firtsName;
		this.lastName=lastName;
		this.sex=sex;
		this.unit=unit;
		this.password=password;
		this.email=email;
		this.date=date;
		this.buget=buget;
	}

	public static String getFirstName() {
		return firstName;
	}




	public static void setFirstName(String firstName) {
		User.firstName = firstName;
	}




	public static String getLastName() {
		return lastName;
	}




	public static void setLastName(String lastName) {
		User.lastName = lastName;
	}




	public static String getSex() {
		return sex;
	}




	public static void setSex(String sex) {
		User.sex = sex;
	}




	public static String getUnit() {
		return unit;
	}




	public static void setUnit(String unit) {
		User.unit = unit;
	}




	public static Date getDate() {
		return date;
	}




	public static void setDate(Date date) {
		User.date = date;
	}




	public static String getPassword() {
		return password;
	}




	public static void setPassword(String password) {
		User.password = password;
	}




	public static String getEmail() {
		return email;
	}




	public static void setEmail(String email) {
		User.email = email;
	}




	public static float getBuget() {
		return buget;
	}




	public static void setBuget(float buget) {
		User.buget = buget;
	}

	
	
	public boolean save(){
		SharedPreferences sp= CommonUtils.mContext.getSharedPreferences("MyMoneyProfil", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor= sp.edit();
		
		editor.putString("fname", firstName );
		editor.putString("lname", lastName);
		editor.putString("password", password);
		editor.putString("email", email);
		editor.putFloat("buget", buget);
		editor.putString("ssexs", sex);
		editor.putString("units", unit);
		
		editor.commit();
		
		return true;
	}
	
}
