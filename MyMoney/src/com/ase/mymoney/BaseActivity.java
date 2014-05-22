package com.ase.mymoney;

import net.simonvt.menudrawer.MenuDrawer;
import net.simonvt.menudrawer.Position;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.ase.mymoney.ui.SlidingMenuFragment;
import com.ase.mymoney.utils.CommonUtils;
import com.ase.mymoney.utils.DatabaseHelper;

public class BaseActivity extends FragmentActivity {

	MenuDrawer mMenuDrawer;
	SlidingMenuFragment mMenuFragment;
	
	public static DatabaseHelper dbHelper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		CommonUtils.setApplicationContext(getApplicationContext());
		
		if( dbHelper==null ){
			dbHelper = new DatabaseHelper(this);
		}
		
		mMenuDrawer = MenuDrawer.attach(this, MenuDrawer.Type.BEHIND, Position.LEFT, MenuDrawer.MENU_DRAG_WINDOW);
		mMenuDrawer.setMenuView(R.layout.menu_frame);
		
		mMenuDrawer.setMenuSize((int) this.getResources().getDimension(R.dimen.sliding_menu_width));
		
		attachSlidingMenu();
	}
	
	
	protected void attachSlidingMenu() {
		mMenuFragment = new SlidingMenuFragment();
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction().replace(R.id.menuFrame, mMenuFragment);
		ft.commit();
	}
	
}
