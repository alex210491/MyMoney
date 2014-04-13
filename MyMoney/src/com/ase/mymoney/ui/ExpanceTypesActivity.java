package com.ase.mymoney.ui;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ase.mymoney.BaseActivity;
import com.ase.mymoney.R;

public class ExpanceTypesActivity extends BaseActivity {

	Button button1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tipuri_cheltuieli2);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		Button click = (Button) findViewById(R.id.btnAdauga);
        /*click.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tipuri_cheltuieli2, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.fragment_tipuri_cheltuieli2, container, false);
			return rootView;
		}
	}
	
	public void showDialog() {
		  android.app.FragmentManager fm = getFragmentManager();
		  ExpanceTypesAddTypeFragment alert = new ExpanceTypesAddTypeFragment();
		  alert.show(fm, "Alert_Dialog");
		 }

}
