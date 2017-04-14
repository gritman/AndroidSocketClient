package com.bianfeng.tongtian;

public class SrsIp {
	public String ip;
	public int port;
	public int appId;
	public int load;

	public int gameId;
	public int moduleServerId;

	public int roomType = 2;
	public String label = "正式环境";
	public String notice;
	public String mail;

	public SrsIp(int appId, String ip, int port, int gameId,
			int moduleServerId, String notice, String mail,
			String label, int roomType) {

		this.appId = appId;
		this.ip = ip;
		this.port = port;

		this.gameId = gameId;
		this.moduleServerId = moduleServerId;

		this.label = label;
		this.roomType = roomType;

		this.notice = "http://" + notice;
		this.mail = "http://" + mail;
	}

}
