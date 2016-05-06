//package com.example.android4demo1.c4;
//
//import java.util.ArrayList;
//
//import com.example.android4demo1.R;
//
//import android.R.string;
//import android.app.Activity;
//import android.os.Bundle;
//import android.view.KeyEvent;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.View.OnKeyListener;
//import android.widget.ArrayAdapter;
//import android.widget.EditText;
//import android.widget.ListView;
//
//public class ToDoListActivity2 extends Activity {
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.main);
//		final EditText myEditText = (EditText) findViewById(R.id.myEditText);
//		ListView myListView = (ListView) findViewById(R.id.myListView);
//
//		final ArrayList<String> toDoItems = new ArrayList<String>();
//		final ArrayAdapter<String> adapter;
//		adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, toDoItems);
//		myListView.setAdapter(adapter);
//
//		myEditText.setOnKeyListener(new OnKeyListener() {
//
//			@Override
//			public boolean onKey(View v, int keyCode, KeyEvent event) {
//
//				if (event.getAction() == KeyEvent.ACTION_DOWN) {
//					if ((keyCode == KeyEvent.KEYCODE_DPAD_CENTER) || (keyCode == KeyEvent.KEYCODE_ENTER)) {
//						toDoItems.add(0, myEditText.getText().toString());
//						adapter.notifyDataSetChanged();
//						myEditText.setText("");
//						return true;
//					}
//				}
//				return false;
//			}
//		});
//	}
//
//}
