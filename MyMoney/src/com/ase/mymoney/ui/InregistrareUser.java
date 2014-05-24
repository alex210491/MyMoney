package com.ase.mymoney.ui;

import java.util.Calendar;
import java.util.Date;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.ase.mymoney.BaseActivity;
import com.ase.mymoney.MainActivity;
import com.ase.mymoney.R;
import com.ase.mymoney.models.User;
import com.ase.mymoney.utils.CommonUtils;

public class InregistrareUser extends BaseActivity{
	private EditText fname;
	private EditText lname;
	private RadioGroup sex;
	private EditText email;
	private EditText buget;
	private RadioGroup unit;
	private RadioButton sexM, sexF, unitRON, unitEUR;
	private DatePicker date;
	
	private User mUser;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inregistrare);	
		
		mUser = User.getCurrentUser();
		
		fname = (EditText)findViewById(R.id.fname);
		lname= (EditText)findViewById(R.id.lname);
		sex= (RadioGroup)findViewById(R.id.radioGroup1);
		buget= (EditText)findViewById(R.id.buget);
		email= (EditText)findViewById(R.id.email);
		unit= (RadioGroup)findViewById(R.id.radioGroup2);
		date = (DatePicker)findViewById(R.id.date);
		
		sexF = (RadioButton) findViewById(R.id.feminin);
		sexM = (RadioButton) findViewById(R.id.masculin);
		
		unitRON = (RadioButton) findViewById(R.id.lei);
		unitEUR = (RadioButton) findViewById(R.id.euro);
		
		repopulateData();
		
	}
	
	private void repopulateData(){
		if(mUser==null){
			this.disableMenuDrawer(); //meniul din stanga nu exista
			return;
		}
		
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(mUser.date.getTime());
		
		fname.setText(mUser.firstName);
		lname.setText(mUser.lastName);
		buget.setText(String.valueOf(mUser.buget));
		
		date.updateDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
		
		if(mUser.sex.equalsIgnoreCase("female")){
			sexF.setChecked(true);
			sexM.setChecked(false);
		}else{
			sexM.setChecked(true);
			sexF.setChecked(false);
		}
		
		if(mUser.unit==CommonUtils.UM_RON){
			unitRON.setChecked(true);
			unitEUR.setChecked(false);
		}else{
			unitRON.setChecked(false);
			unitEUR.setChecked(true);
		}
	}


	public void save(View view){

		try{
			String firstName = fname.getText().toString();
			String lastName = lname.getText().toString();
			String tmpEmail = email.getText().toString();
			float tmpBuget = Float.parseFloat(buget.getText().toString());
			String ssex = sex.getCheckedRadioButtonId()==R.id.masculin?"Male":"Female";
			int uunit = unit.getCheckedRadioButtonId()==R.id.lei?CommonUtils.UM_RON:CommonUtils.UM_EUR;
			int year = date.getYear();
			int month = date.getMonth();
			int day = date.getDayOfMonth();
			
			Calendar c = Calendar.getInstance();
			c.set(Calendar.YEAR, year);
			c.set(Calendar.MONTH, month);
			c.set(Calendar.DAY_OF_MONTH, day);
			
			User userForSave = new User(firstName, lastName, ssex, uunit, tmpEmail, new Date(c.getTimeInMillis()), tmpBuget);
			userForSave.save();
			Toast.makeText(this, "Datele au fost salvate cu succes", Toast.LENGTH_LONG).show();
			
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
		}catch(Exception e){
			Toast.makeText(this, "Datele sunt invalide!", Toast.LENGTH_LONG).show();
		}
	}


	
	
	
}
