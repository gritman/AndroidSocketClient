package com.bianfeng.tongtian;

public class CmdLogin extends CmdBase {
	public void resultHandler(SrsStreamWriter streamWriter, short data) {
		if (mAction == ProtDef.CMDT_PLAYERCONNECT) {
			SrsClient.instance().mNiceSelect = null;
			streamWriter.putByte(2);
			streamWriter.putByte(Main.mUserInfo.mLoginUserType);
			streamWriter.putInt(Main.mUserInfo.mAreaId);
			streamWriter.putStr(Main.mUserInfo.mLoginName);
			if (Main.mUserInfo.mLoginUserType == UserInfo.SESSION) {
				streamWriter.putHex(Main.mUserInfo.mLoginPassword); // 密码其实是SESSION值
			} else {
				streamWriter.putStr(Main.mUserInfo.mLoginPassword);
			}
			streamWriter.putStr(Main.mUserInfo.mDeviceId);
			streamWriter.putInt(Main.mUserInfo.mVersionId);
			streamWriter.putInt(Main.mUserInfo.mChannelId);
		} else if (mAction == ProtDef.CMDT_REQPROCESSAPP) {
			streamWriter.putShort(data);
		}
	}

	public void resultHandler(SrsStreamWriter streamWriter) {
		resultHandler(streamWriter, (short) 0);
	}

	public void sendHandler(SrsStreamReader s) {
		if (mAction == ProtDef.CMDT_REQEAUTH) {
			int nOfsAppId = s.getInt();
			int nSAskId = s.getInt();
			int cbEType = s.getByte();
			int cbSubEType = s.getByte();
			String szNum = s.getStr();
		} else if (mAction == ProtDef.CMDT_PTPUSHMSG) {
			int nAskId = s.getInt();
			String szMsg = s.getStr();
		} else if (mAction == ProtDef.CMDT_PLAYERDATA) {
			int cbFlag = s.getByte();// 错误号
			int nAreaID = s.getInt();// 区号(即brandId)
			int nNumId = s.getInt();// 数字账号
			int roleId = (int) (nAreaID * 4294967296.0 + nNumId);// 合并数字ID
			String szNickName = s.getStr(); // 玩家昵称

			if (cbFlag == 1) {
				SrsClient.instance().close();
				return;
			} else if (cbFlag == 2) {
				// 边锋平台账号绑定注册茶苑账号
				SrsClient.instance().close();
				return;
			} else if (cbFlag != 0) {
				SrsClient.instance().close();
				return;
			}

			String sessionID = "";
			if (s.getAvailable() >= 16) {
				sessionID = s.getHex(16);
			}

			Main.mUserInfo.svrRoleId = roleId;
			Main.mUserInfo.svrNumId = nNumId;
			Main.mUserInfo.svrAreaId = nAreaID;
			Main.mUserInfo.svrName = szNickName;
			if (Main.mUserInfo.svrSession == null) {
				Main.mUserInfo.svrSession = sessionID;
			}
			// 发送23号指令，获取玩家数据
			SrsClient.instance().excuteCommand(
					ProtDef.CMDT_REQPLAYERPLUSDATA, null);
		}
	}

}
