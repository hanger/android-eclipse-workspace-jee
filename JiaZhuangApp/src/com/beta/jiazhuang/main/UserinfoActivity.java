package com.beta.jiazhuang.main;

import com.beta.jiazhuang.mybase.MyBaseActivity;
import com.beta.main.R;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class UserinfoActivity extends MyBaseActivity implements OnClickListener {
	Context context = UserinfoActivity.this;
	private TextView tvUserCollect;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ---------------------------------------------------
		// 自定义Activity标题栏
		CustomTitleBar.getTitleBar(this, "个人主页");
		// ---------------------------------------------------
		setContentView(R.layout.activity_userinfo);
		goBack();
		initViewById();
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.userCollect:
			intent.setClass(context, UserCollectActivity.class);
			break;

		default:
			break;
		}
		Log.e("eeeee"," ----->"+intent.getClass());
		startActivity(intent);
	}
	
	private void initViewById() {
		tvUserCollect = (TextView) findViewById(R.id.userCollect);
		tvUserCollect.setOnClickListener(this);
	}

	public void goHome(View v) {
		UserinfoActivity.this.finish();
	}

	// 判断是否登陆
	public void goLogin(View v) {
		Intent intent = new Intent(context, LoginActivity.class);
		startActivity(intent);
	}

}
