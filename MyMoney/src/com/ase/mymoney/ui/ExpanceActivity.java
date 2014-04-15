package com.ase.mymoney.ui;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

import com.ase.mymoney.BaseActivity;
import com.ase.mymoney.R;

public class ExpanceActivity extends BaseActivity {
	
	MenuItem mAddExpanceMenuItem;
	FragmentManager mFragmentManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mFragmentManager = getFragmentManager();
		setContentView(R.layout.activity_expance);
	
		setupView();
	}
	
	private void setupView(){
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.expance_menu, menu);
		
		mAddExpanceMenuItem = menu.findItem(R.id.action_add);
		mAddExpanceMenuItem.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				ExpanceAddWizardDialogFragment wizard = new ExpanceAddWizardDialogFragment();
				wizard.show(mFragmentManager, ExpanceAddWizardDialogFragment.TAG);
				return true; //consumed action
			}
		});
		
		return super.onCreateOptionsMenu(menu);
	}
	

}
