package com.bianfeng.tongtian;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class SrsStreamWriter {
	public ByteBuffer mStream;

	public SrsStreamWriter(ByteBuffer stream) {
		mStream = stream;
		mStream.order(ByteOrder.LITTLE_ENDIAN);
	}

	public void putLong(long val) {
		mStream.putLong(val);
	}

	public void putUInt(long val) {
		ByteHelper.putUnsignedInt(mStream, (int) val);
	}

	public void putInt(int val) {
		mStream.putInt(val);
	}

	public void putShort(short val) {
		mStream.putShort(val);
	}

	public void putUShort(int val) {
		ByteHelper.putUnsignedByte(mStream, val);
	}

	/** 写入字符串类型(服务端使用GBK编码表示中文，默认BYTE表示长度) */
	public void putStr(String val) {
		Charset cs = Charset.forName ("gb2312");
		char[] charArray = val.toCharArray();
		 CharBuffer cb = CharBuffer.allocate (charArray.length);
		 cb.put (charArray);
		 cb.flip ();
		 ByteBuffer bb = cs.encode (cb);
		 mStream.put(bb);
	}
	
	public void putByte(int val) {
		ByteHelper.putUnsignedByte(mStream, val);
	}

	public void putBytes(ByteBuffer val) {
		mStream.put(val.array());
	}

	/** 按字节长度写入16进制原始编码，若第一位为%,将以uri形式写入 */
	public void putHex(String val) {
		int uri = val.charAt(0) == '%' ? 1 : 0;
		int len = val.length() / (2 + uri);
		for (int i = 0; i < len; ++i) {
			char a = val.charAt(i * (2 + uri) + uri);
			char b = val.charAt(i * (2 + uri) + 1 + uri);
			String hexStr = String.valueOf(a) + String.valueOf(b);
			mStream.put(ByteHelper.hexStringToBytes(hexStr));
		}
	}
}
