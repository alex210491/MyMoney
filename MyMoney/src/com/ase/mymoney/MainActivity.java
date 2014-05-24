package com.ase.mymoney;

import android.content.Intent;
import android.os.Bundle;

import com.ase.mymoney.models.User;
import com.ase.mymoney.ui.InregistrareUser;

public class MainActivity extends BaseActivity {

	User mUser;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		User mUser = User.getCurrentUser();
		
		if( User.getCurrentUser()==null ){ //daca nu sunt inregistrat => forteaza ecranul de inregistrare
			Intent intent = new Intent(this, InregistrareUser.class);
			startActivity(intent);
			finish();
			return;
		}
		
		setContentView(R.layout.activity_main);
	}


}
