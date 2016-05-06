package com.example.android4demo1;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageView imag = (ImageView) findViewById(R.id.imag);
		imag.setBackgroundResource(R.drawable.animation_list);
		AnimationDrawable animationDrawable = (AnimationDrawable) imag.getBackground();
		animationDrawable.start();
	}

}
