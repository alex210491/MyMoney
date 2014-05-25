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
import android.widget.TextView;

import com.ase.mymoney.BaseActivity;
import com.ase.mymoney.R;
import com.ase.mymoney.adapters.ExpanceAdapter;
import com.ase.mymoney.models.Expance;
import com.ase.mymoney.ui.ExpanceAddWizardDialogFragment.OnExpanceAddListener;

public class ExpanceActivity extends BaseActivity implements OnExpanceAddListener {
	
	private MenuItem mAddExpanceMenuItem;
	private FragmentManager mFragmentManager;
	private ListView mListView;
	private ExpanceAdapter mExpanceAdapter;
	private List<Expance>mExpanceList;
	private TextView mInfoBar;
	
	private OnClickListener mDeleteExpanceClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Expance e = (Expance) v.getTag();
			BaseActivity.dbHelper.removeExpance(e);
			mExpanceList.remove(e);
			mExpanceAdapter.notifyDataSetChanged();
			float total = 0;
			for(Expance ex: mExpanceList){
				total+=ex.getSum();
			}
			mInfoBar.setText("TOTAL: "+total);
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mExpanceList = BaseActivity.dbHelper.getAllExpance();
		mExpanceAdapter = new ExpanceAdapter(this, mExpanceList, mDeleteExpanceClickListener);
		
		mFragmentManager = getSupportFragmentManager();
		setContentView(R.layout.activity_expance);
	
		setupView();
	}
	
	private void setupView(){
		mListView = (ListView) findViewById(R.id.listView);
		mInfoBar = (TextView) findViewById(R.id.infoBar);
		mListView.setAdapter(mExpanceAdapter);
		
		if(mExpanceList.isEmpty()){
			mInfoBar.setText("No added expance");
		}else{
			float total = 0;
			for(Expance e: mExpanceList){
				total+=e.getSum();
			}
			mInfoBar.setText("TOTAL: "+total);
		}
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

	@Override
	public void onExpanceAdded(Expance expance) {
		mExpanceList.add(expance);
		mExpanceAdapter.notifyDataSetChanged();
		float total = 0;
		for(Expance e: mExpanceList){
			total+=e.getSum();
		}
		mInfoBar.setText("TOTAL: "+total);
	}
	

}
