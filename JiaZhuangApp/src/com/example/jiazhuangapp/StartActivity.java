package com.example.jiazhuangapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class StartActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_start);
		
		new Handler().postDelayed(new Runnable(){
			@Override
			public void run(){
				Intent intent = new Intent (StartActivity.this,WhatsnewActivity.class);			
				startActivity(intent);			
				StartActivity.this.finish();
//				Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
			}
		}, 200);

	}
}
