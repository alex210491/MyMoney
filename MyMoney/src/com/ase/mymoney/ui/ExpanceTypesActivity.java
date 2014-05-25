package com.ase.mymoney.ui;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

import com.ase.mymoney.BaseActivity;
import com.ase.mymoney.R;
import com.ase.mymoney.adapters.ExpanceTypeAdapter;
import com.ase.mymoney.models.ExpanceType;
import com.ase.mymoney.ui.ExpanceTypeAddFragmentDialog.OnExpanceTypeAddListener;

public class ExpanceTypesActivity extends BaseActivity implements OnExpanceTypeAddListener {
	
	private MenuItem mAddExpanceMenuItem;
	private FragmentManager mFragmentManager;
	private ListView mListView;
	private ExpanceTypeAdapter mExpanceTypeAdapter;
	private List<ExpanceType>mExpanceTypeList;
	
	private OnClickListener mDeleteExpanceClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			ExpanceType e = (ExpanceType) v.getTag();
			BaseActivity.dbHelper.removeExpanceType(e);
			mExpanceTypeList.remove(e);
			mExpanceTypeAdapter.notifyDataSetChanged();
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mExpanceTypeList = BaseActivity.dbHelper.getAllExpanceTypes();
		mExpanceTypeAdapter = new ExpanceTypeAdapter(this, mExpanceTypeList, mDeleteExpanceClickListener);
		
		mFragmentManager = getSupportFragmentManager();
		setContentView(R.layout.activity_expance);
	
		setupView();
	}
	
	private void setupView(){
		mListView = (ListView) findViewById(R.id.listView);
		mListView.setAdapter(mExpanceTypeAdapter);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.expance_menu, menu);
		
		mAddExpanceMenuItem = menu.findItem(R.id.action_add);
		mAddExpanceMenuItem.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				ExpanceTypeAddFragmentDialog wizard = new ExpanceTypeAddFragmentDialog();
				wizard.show(mFragmentManager, ExpanceAddWizardDialogFragment.TAG);
				return true; //consumed action
			}
		});
		
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public void onExpanceTypeAdded(ExpanceType expanceType) {
		mExpanceTypeList.add(expanceType);
		mExpanceTypeAdapter.notifyDataSetChanged();
	}
	

}
