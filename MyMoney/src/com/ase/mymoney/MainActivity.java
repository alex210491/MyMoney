package com.ase.mymoney;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.ase.mymoney.ui.MapActivity;

public class MainActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		if( true ){
//			Intent intent = new Intent(this, InregistrareUser.class);
//			startActivity(intent);
			Intent intent = new Intent(this, MapActivity.class);
			startActivity(intent);
		}
		
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
