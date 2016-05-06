package com.example.android4demo1.c4;

import com.example.android4demo1.R;

import android.R.transition;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.EditText;

public class NewItemFragment extends Fragment {

	// 内部接口
	public interface OnNewItemAddedListener {
		public void onNewItemAdded(String newItem);
	}

	public OnNewItemAddedListener onNewItemAddedListener;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			onNewItemAddedListener = (OnNewItemAddedListener) activity;
			System.out.println("onAttach");
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString() + "必须实现OnNewItemAddedListener");
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.new_item_fragment, container, false);
		// 获取父activity中的EditText
		final EditText myEditText = (EditText) view.findViewById(R.id.myEditText);
		myEditText.setOnKeyListener(new OnKeyListener() {

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (event.getAction() == KeyEvent.ACTION_DOWN) {
					if ((keyCode == KeyEvent.KEYCODE_DPAD_CENTER) || (keyCode == KeyEvent.KEYCODE_ENTER)) {
						String newItem = myEditText.getText().toString();
						onNewItemAddedListener.onNewItemAdded(newItem);
						myEditText.setText("");
						return true;
					}
				}
				return false;
			}
		});

		return view;
	}

}
