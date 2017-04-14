package com.bianfeng.tongtian;

public class UserInfo {
	public static final byte PASSWORD = 1;
	public static final byte SESSION = 2;
	
	public String mLoginName = "gametea150";
	public String mLoginPassword = "111111";
	public byte mLoginUserType = PASSWORD; // UserInfo.PASSWORD 或 UserInfo.SESSION
	public int mAreaId = 0;
	public String mDeviceId = "device_id_unknown";
	public int mChannelId = 0;
	public int mVersionId = 0;
	
	// from svr
	public int svrRoleId;
	public int svrNumId;
	public int svrAreaId;
	public String svrName;
	public String svrSession;
}