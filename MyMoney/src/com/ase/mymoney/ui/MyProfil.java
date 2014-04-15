package com.ase.mymoney.ui;



import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ase.mymoney.BaseActivity;
import com.ase.mymoney.R;

public class MyProfil extends BaseActivity{

	public final String DEFAULT="N/A";
	TextView fname;
	TextView lname;
	TextView date;
	TextView sex;
	TextView email;
	TextView password;
	TextView buget;
	TextView unit;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profilul_meu);
		fname= (TextView)findViewById(R.id.fname);
		lname= (TextView)findViewById(R.id.lname);
		sex= (TextView)findViewById(R.id.sex);
		email= (TextView)findViewById(R.id.email);
		password= (TextView)findViewById(R.id.password);
		buget= (TextView)findViewById(R.id.buget);
		unit= (TextView)findViewById(R.id.unit);
	}
	
	public void profilulMeu(View view)
	{
		SharedPreferences sp=getSharedPreferences("MyMoneyProfil", Context.MODE_PRIVATE);
		String ffname=sp.getString("fname", DEFAULT);
		String llname=sp.getString("lname", DEFAULT);
		String ddate=sp.getString("date", DEFAULT);
		String ssex=sp.getString("sex", DEFAULT);
		String eemail=sp.getString("email", DEFAULT);
		String ppassword=sp.getString("password", DEFAULT);
		String bbuget=sp.getString("buget", DEFAULT);
		String uunit=sp.getString("unit", DEFAULT);
		
		
		if((ffname.equals(DEFAULT)) || (llname.equals(DEFAULT)))
		{
			Toast.makeText(this, "No data was found", Toast.LENGTH_LONG).show();
		}else
		{
			Toast.makeText(this, "Data loadedn successuflly", Toast.LENGTH_LONG).show();
		}
	}
	
	
}
