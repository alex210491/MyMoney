package com.ase.mymoney.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ase.mymoney.R;
import com.ase.mymoney.models.Expance;

public class ExpanceAdapter extends BaseAdapter {

	List<Expance> mObjects;
	Context mContext;
	
	public class ViewHolder{
		TextView expanceCount, expanceTitle, expancePrice;
	}
	
	public ExpanceAdapter(Context context, List<Expance> expanceList){
		mObjects = expanceList;
		mContext = context;
	}
	
	@Override
	public int getCount() {
		return mObjects.size();
	}

	@Override
	public Expance getItem(int arg0) {
		return mObjects.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return getItem(arg0).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		Expance currentExpance = getItem(position);
		
		View view = convertView;
		ViewHolder holder = new ViewHolder();
		if(view==null){
			LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.expance_list_item, null);
			holder.expanceCount = (TextView) view.findViewById(R.id.rowCount);
			holder.expanceTitle = (TextView) view.findViewById(R.id.expanceTitle);
			holder.expancePrice = (TextView) view.findViewById(R.id.expancePrice);
			view.setTag(holder);
		}else{
			holder = (ViewHolder) view.getTag();
		}
		
		holder.expanceCount.setText(String.valueOf(position));
		holder.expanceTitle.setText(currentExpance.getTitle());
		holder.expancePrice.setText(String.valueOf(currentExpance.getSum()));
		
		return view;
	}

}
