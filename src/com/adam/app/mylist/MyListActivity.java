/**
 * MyListActivity.java
 */
package com.adam.app.mylist;

import java.util.List;
import java.util.Map;

import com.adam.app.mylist.ListItemMenu.Items;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;


public class MyListActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		List testItemMap = ListItemMenu.ShowMenu();
		SimpleAdapter adapter = new SimpleAdapter(this, testItemMap, android.R.layout.simple_list_item_1,
				new String[]{ListItemMenu.ITEMNAME}, new int[]{android.R.id.text1});
		
		setListAdapter(adapter);
		this.getListView().setTextFilterEnabled(true);
		this.getListView().setScrollbarFadingEnabled(true);
	
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		Map map = (Map)l.getItemAtPosition(position);
		String Name = (String)map.get(ListItemMenu.ITEMNAME);
		Intent intent = (Intent)map.get(ListItemMenu.ITEMINTENT);
		
		if(Name.equals(Items.Test.toString())) {
			
			finish();
		
		} else {
			
			startActivity(intent);
			
		}
		
		
	}
	
	
	

	
}
