package com.example.android4demo1.c4;

import java.util.ArrayList;

import com.example.android4demo1.R;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class ToDoListActivity extends Activity implements NewItemFragment.OnNewItemAddedListener {
	ArrayList<String> toDoItems;
	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		FragmentManager fm = getFragmentManager();
		ToDoListFragment toDoListFragment = (ToDoListFragment) fm.findFragmentById(R.id.ToDoListFragment);
		toDoItems = new ArrayList<String>();
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, toDoItems);
		toDoListFragment.setListAdapter(adapter);
	}

	@Override
	public void onNewItemAdded(String newItem) {
		toDoItems.add(newItem);
		adapter.notifyDataSetChanged();
	}

}
