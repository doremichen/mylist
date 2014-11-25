/**
 * ListItemMenu.java
 */
package com.adam.app.mylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;

public final class ListItemMenu {
	
	public static final String ITEMNAME = "itemName";
	public static final String ITEMINTENT = "itemIntent";
	
	/*
	 * Menu item information
	 */
	public static enum Items{
		
		Test(null, null, "testItem");
				
		//information
		private String mpackageName = null;
		private String mclassName = null;
		private String mitemName = null;
		
		private Items(String packageName, String className, String itemName) {
						
			mpackageName = packageName;
			mclassName = className;
			mitemName = itemName;
			
		}
		
		
		public HashMap<String, Object> getItemMap() {
			
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			Intent intent = new Intent();
			
			if(mpackageName != null && mclassName != null) {
				intent.setClassName(mpackageName, mclassName);
			}
			
			hashMap.put(ITEMNAME, mitemName);
			hashMap.put(ITEMINTENT, intent);
			
			return hashMap;
		}


		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return mitemName;
		}
		
		
		
		
	}
	
	private ListItemMenu() {
		//Can not instance
	}
	
	
	public static List<Map> ShowMenu() {
		
		List<Map> listItem = new ArrayList<Map>();
		
		for(Items item : Items.values()) {
			listItem.add(item.getItemMap());
		}
			
		return listItem;
		
	}
	

}
