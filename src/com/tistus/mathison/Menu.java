package com.tistus.mathison;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String classes[] = {"StartingPoint","TextPlay","Email","Camera","Data","Example5"}; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String menuClassName = classes[position];
		try {
			Class ourClass = Class.forName("com.tistus.mathison."+menuClassName);
			Intent ourIntent = new Intent(Menu.this,ourClass); 
			startActivity(ourIntent);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
