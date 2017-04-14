package com.bianfeng.tongtian;

import java.util.Locale;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

public class Main {

	public static final String TAG = "TongTian";
	private static Main mInstance = null;
	public static UserInfo mUserInfo = null;

	public static void log(String content) {
		Log.d(TAG, content);
	}

	public enum ELoginUserType {
		CY, BF, JJ;
	}

	public static Main getInstance() {
		if (mInstance == null) {
			mInstance = new Main();
		}
		return mInstance;
	}

	public void login(ELoginUserType loginUserType, UserInfo userInfo,
			IMainCallback mcb) {
		Main.log("call login");
		mUserInfo = userInfo;
		switch (loginUserType) {
		case CY:
			SrsClient srsClient = SrsClient.instance();
			srsClient.init("192.168.136.90", 4005, mcb);
			srsClient.start();
			break;
		case BF:
			break;
		case JJ:
			break;
		default:
			break;
		}
	}

	public interface IMainCallback {
		public void onResult(String result);
	}
}
