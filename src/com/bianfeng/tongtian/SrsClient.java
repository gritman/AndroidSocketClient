package com.bianfeng.tongtian;

import java.nio.ByteBuffer;

import android.util.Log;

import com.bianfeng.tongtian.Main.IMainCallback;
import com.bianfeng.tongtian.SrsSocket.ConnectListener;
import com.bianfeng.tongtian.SrsSocket.ENUM_CONNECT;

public class SrsClient {
	private SrsSocket mSrsSocket = null;
	private IMainCallback mMainCallback = null;
	public SrsIp mNiceSelect = null;
	// private ByteBuffer mBufToSrv = null;
	// private ByteBuffer mBufFmSrv = null;

	// private SrsPackage sendSrsPackage = new SrsPackage();
	// private SrsPackage recvSrsPackage = new SrsPackage();

	private static SrsClient mSrsClient = null;

	public static SrsClient instance() {
		if (mSrsClient == null) {
			mSrsClient = new SrsClient();
			return mSrsClient;
		} else {
			if (mSrsClient.mSrsSocket == null) {
				Main.log("instance instance no init");
			}
			return mSrsClient;
		}
	}

	public void init(String ip, int port, IMainCallback mainCallback) {
		Main.log("client init");
		mSrsSocket = new SrsSocket(ip, port, this);
		mSrsSocket.setConnectListener(new MyConnectListener());
		mMainCallback = mainCallback;
	}

	private class MyConnectListener implements SrsSocket.ConnectListener {
		public void connect(ENUM_CONNECT STATUS) {
			if (STATUS == ENUM_CONNECT.STATUS_OK) {
				EncryptHelper.init();
				connectCommand(ProtDef.SRS_CONNECT, null);
			}
		}
	}

	private boolean connectCommand(String protId, SrsPackage srsPkg) {
		// 连接成功后，先发送消息1，验证客户端合法性
		if (protId == ProtDef.SRS_CONNECT) {
			SrsPackage pkg = new SrsPackage();
			ByteHelper.putUnsignedInt(pkg.data, 1);
			pkg.mProtId = Integer.parseInt(ProtDef.CMDT_ENCRYPTVER);
			send(pkg);
			return true;
		}
		// 收到连接1号消息回复后，发送3号消息，获取KEY
		else if (protId == ProtDef.CMDT_ENCRYPTVER) {
			SrsPackage pkg = new SrsPackage();
			pkg.mProtId = Integer.parseInt(ProtDef.CMDT_REQKEY);
			send(pkg);
			return true;
		}
		// 收到4号消息(3号的回复)，得到KEY，并记录
		else if (protId == ProtDef.CMDT_RESPKEY) {
			SrsPackage pkg = new SrsPackage();
			int cbLen = srsPkg.data.remaining();
			byte[] cbKeys = new byte[cbLen];
			srsPkg.data.get(cbKeys, 0, cbLen);
			EncryptHelper.akey = cbKeys;
			excuteCommand(ProtDef.CMDT_PLAYERCONNECT, null);
			return true;
		} else {
			return false;
		}
	}

	public void onRecv(byte[] data) {
		SrsPackage pkg = new SrsPackage();
		SrsStreamReader streamReader = new SrsStreamReader(data);
		pkg.decode(streamReader);
		if (!connectCommand(String.valueOf(pkg.mProtId), pkg)) {
			if (!ProtDef.PROCESS_PREFIX.contains(pkg.mProcessId)) {
				excuteCommand(String.valueOf(pkg.mProtId), pkg);
			} else {
				String cmdId = pkg.mProcessId
						+ ProtDef.PROCESS_CUT
						+ pkg.mProtId;
				excuteCommand(cmdId, pkg);
			}
		}
	}

	public void excuteCommand(String id, SrsPackage srsPkg) {
		CmdBase cmd = CmdBase.factory(id);
		cmd.parse(id, srsPkg);
	}

	private void send(SrsPackage srsPkg) {
		if (!mSrsSocket.isConnected()) {
			Main.log("send but not connect");
			return;
		}
		ByteBuffer bufToSrv = ByteBuffer.allocate(10240);
		SrsStreamWriter streamWriter = new SrsStreamWriter(bufToSrv);
		srsPkg.encode(streamWriter);
		try {
			mSrsSocket.writeBuf(bufToSrv.array());
		} catch (Exception e) {
			Main.log("mSrsSocket.writeBuf error");
			e.printStackTrace();
		}
		Main.log("send " + srsPkg.mProtId);
	}

	public void start() {
		Main.log("client start");
		mSrsSocket.setConnectListener(new MyConnectListener());
		mSrsSocket.start();
	}

	// //////////////////
	public void close() {
		mSrsSocket.close();
	}
}
