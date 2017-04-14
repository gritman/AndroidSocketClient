package com.bianfeng.tongtian;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class SrsPackage
{
	// 标志位
	protected int sFlag = 16385;   // 2 << 13 | 1
	// 包体大小,不包含包头的大小
	protected int sLen = 0; 
	// 协议id
	public int mProtId = 0;
	// 服务器模块id
	public int mProcessId = 0;
	// 服务器服务id
	public int nAppID = 0;
	// 包体
	public ByteBuffer data;

	public SrsPackage() {
		this.data = ByteBuffer.allocate(10240);  
		this.data.order(ByteOrder.LITTLE_ENDIAN);
	}
	
	public void decode(SrsStreamReader inputStream) {
		this.sFlag = inputStream.getUShort();
		this.sLen = inputStream.getUShort();
		this.mProtId = inputStream.getUShort();
		this.mProcessId = inputStream.getUShort();
		this.nAppID = inputStream.getInt();
		
		if(this.sLen > 0) {
			this.data = inputStream.getBytes(this.sLen);
		}
		
		if((this.sFlag & 1) > 0) {
			this.data = EncryptHelper.decode(this.data);
			this.data.order(ByteOrder.LITTLE_ENDIAN);
		}
	}
	
	public void encode(SrsStreamWriter outputStream) {
		this.sLen = this.data.limit();
		outputStream.putUShort(this.sFlag);
		outputStream.putUShort(this.sLen);
		outputStream.putUShort(this.mProtId);
		outputStream.putUShort(this.mProcessId);
		outputStream.putInt(this.nAppID);

		if((this.sFlag & 1) > 0) {
			this.data = EncryptHelper.encode(this.data);
		}
		outputStream.putBytes(this.data);
	}
}