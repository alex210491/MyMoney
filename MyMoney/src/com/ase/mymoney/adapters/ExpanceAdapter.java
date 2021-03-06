package com.ase.mymoney.adapters;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ase.mymoney.BaseActivity;
import com.ase.mymoney.R;
import com.ase.mymoney.models.Expance;
import com.ase.mymoney.utils.CommonUtils;

public class ExpanceAdapter extends BaseAdapter {

	List<Expance> mObjects;
	Context mContext;
	Drawable mDeleteDrawable;
	OnClickListener mDeleteExpanceClickListener;
	
	public class ViewHolder{
		TextView expanceCount, expanceTitle, expancePrice;
		ImageView deleteButton;
	}
	
	public ExpanceAdapter(Context context, List<Expance> expanceList, OnClickListener deleteExpanceClickListener){
		mObjects = expanceList;
		mContext = context;
		mDeleteDrawable = context.getResources().getDrawable(R.drawable.delete_icon);
		mDeleteExpanceClickListener = deleteExpanceClickListener;
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
		String um = "EUR";
		if(currentExpance.getUm()==CommonUtils.UM_RON) um = "RON";
				
		View view = convertView;
		ViewHolder holder = new ViewHolder();
		if(view==null){
			LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.expance_list_item, null);
			holder.expanceCount = (TextView) view.findViewById(R.id.rowCount);
			holder.expanceTitle = (TextView) view.findViewById(R.id.expanceTitle);
			holder.expancePrice = (TextView) view.findViewById(R.id.expancePrice);
			holder.deleteButton = (ImageView) view.findViewById(R.id.deleteButton);
			holder.deleteButton.setTag(currentExpance);
			view.setTag(holder);
		}else{
			holder = (ViewHolder) view.getTag();
		}
		
		holder.expanceCount.setText(String.valueOf(position+1));
		holder.expanceTitle.setText(currentExpance.getTitle());
		holder.expancePrice.setText(String.valueOf(currentExpance.getSum())+um);
		holder.deleteButton.setImageDrawable(mDeleteDrawable);
		holder.deleteButton.setOnClickListener(mDeleteExpanceClickListener);
		
		return view;
	}

}
