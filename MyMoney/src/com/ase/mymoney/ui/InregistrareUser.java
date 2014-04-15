package com.ase.mymoney.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.ase.mymoney.BaseActivity;
import com.ase.mymoney.R;
import com.ase.mymoney.models.User;

public class InregistrareUser extends BaseActivity{
	EditText fname;
	EditText lname;
	int sex;
	EditText password;
	EditText email;
	EditText buget;
	int unit;
	EditText date;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inregistrare);	
		
		fname = (EditText)findViewById(R.id.fname);
		lname= (EditText)findViewById(R.id.lname);
		sex= ((RadioGroup)findViewById(R.id.radioGroup1)).getCheckedRadioButtonId();
		password= (EditText)findViewById(R.id.password);
		buget= (EditText)findViewById(R.id.buget);
		email= (EditText)findViewById(R.id.email);
		unit= ((RadioGroup)findViewById(R.id.radioGroup2)).getCheckedRadioButtonId();
		
	}


	public void save(View view){

		String firstName = fname.getText().toString();
		String lastName = lname.getText().toString();
		String tmpPass = password.getText().toString();
		String tmpEmail = email.getText().toString();
		float tmpBuget = Float.parseFloat(buget.getText().toString());
		String ssex=(String)((RadioButton)findViewById(sex)).getText();
		String uunit=(String)((RadioButton)findViewById(unit)).getText();
		
		User userForSave = new User(firstName, lastName, ssex, uunit, tmpPass, tmpEmail, null, tmpBuget);
		
		userForSave.save();
		
		Toast.makeText(this, "Datele au fost salvate cu succes", Toast.LENGTH_LONG).show();
	}


	
	
	
}
