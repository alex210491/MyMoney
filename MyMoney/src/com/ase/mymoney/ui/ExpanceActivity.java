package com.ase.mymoney.ui;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;

import com.ase.mymoney.BaseActivity;
import com.ase.mymoney.R;
import com.ase.mymoney.adapters.ExpanceAdapter;
import com.ase.mymoney.models.Expance;

public class ExpanceActivity extends BaseActivity {
	
	private MenuItem mAddExpanceMenuItem;
	private FragmentManager mFragmentManager;
	private ListView mListView;
	private ExpanceAdapter mExpanceAdapter;
	private List<Expance>mExpanceList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mExpanceList = BaseActivity.dbHelper.getAllExpance();
		mExpanceAdapter = new ExpanceAdapter(this, mExpanceList);
		
		mFragmentManager = getSupportFragmentManager();
		setContentView(R.layout.activity_expance);
	
		setupView();
	}
	
	private void setupView(){
		mListView = (ListView) findViewById(R.id.listView);
		mListView.setAdapter(mExpanceAdapter);
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
