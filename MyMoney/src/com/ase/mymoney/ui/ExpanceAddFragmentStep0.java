package com.ase.mymoney.ui;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.ase.mymoney.BaseActivity;
import com.ase.mymoney.R;
import com.ase.mymoney.models.Expance;
import com.ase.mymoney.models.ExpanceType;
import com.ase.mymoney.ui.ExpanceAddWizardDialogFragment.ExpanceUpdater;

public class ExpanceAddFragmentStep0 extends Fragment implements ExpanceUpdater{
	
	private TextView mExpanceTitle;
	private Spinner mExpanceTypeSpinner;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.expance_add_fragment_0, null);
		return root;
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		
		mExpanceTypeSpinner = (Spinner) view.findViewById(R.id.inputExpanceType);
		mExpanceTitle = (TextView) view.findViewById(R.id.inputExpanceName);
		
		List<ExpanceType> list = new ArrayList<ExpanceType>();
		list.add(new ExpanceType(-1, "Expance Type", 0));
		List<ExpanceType> dbList = BaseActivity.dbHelper.getAllExpanceTypes();
		list.addAll(dbList);
		
		ArrayAdapter<ExpanceType> adapter = new ArrayAdapter<ExpanceType>(getActivity(), android.R.layout.simple_list_item_1, list);
		mExpanceTypeSpinner.setAdapter(adapter);
		
		
		
		//pune expance type-urile in spinner
		//pune valorile in mExpance din wizard
		//fa next etc
	}

	@Override
	public Expance updateExpance(Expance expance) {
		ExpanceType selectedExpanceType = (ExpanceType) mExpanceTypeSpinner.getSelectedItem();
		
		expance.setTitle(mExpanceTitle.getText().toString());
		expance.setExpanceTypeId(selectedExpanceType.getId());
		return expance;
	}
	
}
