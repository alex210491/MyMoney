package com.ase.mymoney;

import net.simonvt.menudrawer.MenuDrawer;
import net.simonvt.menudrawer.Position;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.ase.mymoney.ui.SlidingMenuFragment;

public class BaseActivity extends Activity {

	MenuDrawer mMenuDrawer;
	SlidingMenuFragment mMenuFragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//test git commit
		mMenuDrawer = MenuDrawer.attach(this, MenuDrawer.Type.BEHIND, Position.LEFT, MenuDrawer.MENU_DRAG_WINDOW);
		mMenuDrawer.setMenuView(R.layout.menu_frame);
		
		mMenuDrawer.setMenuSize((int) this.getResources().getDimension(R.dimen.sliding_menu_width));
		
		attachSlidingMenu();
	}
	
	
	protected void attachSlidingMenu() {
		mMenuFragment = new SlidingMenuFragment();
		FragmentTransaction ft = getFragmentManager().beginTransaction().replace(R.id.menuFrame, mMenuFragment);
		ft.commit();
	}
	
	
}
