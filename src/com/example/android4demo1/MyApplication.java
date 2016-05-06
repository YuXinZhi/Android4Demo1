package com.example.android4demo1;

import java.util.LinkedList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;

@SuppressLint("NewApi")
public class MyApplication extends Application {
	// 用于存放每个Activity的List
	private List<Activity> mList = new LinkedList<Activity>();
	private static MyApplication instance; // SysApplication实例

	private MyApplication() { // 私有构造器，防止外面实例化该对象，
	}

	// 通过一个方法给外面提供实例
	public synchronized static MyApplication getInstance() {
		if (null == instance) {
			instance = new MyApplication();
		}
		return instance;
	}

	/**
	 * 在我们需要退出程序的时候执行下面代码： SysApplication.getInstance().exit(); //调用退出方法
	 * 
	 */
	public void exit() { // 遍历List，退出每一个Activity
		try {
			for (Activity activity : mList) {
				if (activity != null)
					activity.finish();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}

	/**
	 * 在每个Activity的onCreate中添加下面代码，把每个创建的Activity添加到List中管理： public void
	 * onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);
	 * SysApplication.getInstance().addActivity(this);
	 * //创建Activity时，添加到List进行管理。 }
	 * 
	 * @param activity
	 */
	// add Activity
	public void addActivity(Activity activity) {
		mList.add(activity);
	}

	@Override
	public void onCreate() {
		super.onCreate();
	}

	/**
	 * This method is for use in emulated process environments. It will never be
	 * called on a production Android device, where processes are removed by
	 * simply killing them; no user code (including this callback) is executed
	 * when doing so.
	 * 
	 * 
	 */
	@Override
	public void onTerminate() {
		super.onTerminate();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
		System.gc(); // 告诉系统回收
	}

	@Override
	public void onTrimMemory(int level) {
		super.onTrimMemory(level);
	}

	@Override
	public void registerComponentCallbacks(ComponentCallbacks callback) {
		// TODO Auto-generated method stub
		super.registerComponentCallbacks(callback);
	}

	@Override
	public void unregisterComponentCallbacks(ComponentCallbacks callback) {
		// TODO Auto-generated method stub
		super.unregisterComponentCallbacks(callback);
	}

	@Override
	public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
		// TODO Auto-generated method stub
		super.registerActivityLifecycleCallbacks(callback);
	}

	@Override
	public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
		// TODO Auto-generated method stub
		super.unregisterActivityLifecycleCallbacks(callback);
	}

	@Override
	public void registerOnProvideAssistDataListener(OnProvideAssistDataListener callback) {
		// TODO Auto-generated method stub
		super.registerOnProvideAssistDataListener(callback);
	}

	@Override
	public void unregisterOnProvideAssistDataListener(OnProvideAssistDataListener callback) {
		// TODO Auto-generated method stub
		super.unregisterOnProvideAssistDataListener(callback);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
