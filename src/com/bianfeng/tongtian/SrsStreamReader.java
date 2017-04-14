package com.bianfeng.tongtian;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class SrsStreamReader {

	public ByteBuffer mStream;

	public SrsStreamReader(byte[] data) {
		mStream = ByteBuffer.wrap(data);
		mStream.order(ByteOrder.LITTLE_ENDIAN);
	}

	public int getAvailable() {
		// capacity是最大容量,limit是当前装了多少+1,position下一次该读哪里
		// 返回剩余的字节量，是limit-position
		// 调用put()或get()时，每调用一次position的值会加1，指示下次存或取开始的位置；
		// Buffer.remaining()：返回从当前位置到上界的数据元素数量；
		// Buffer.hasRemaining()：告诉我们从当前位置到上界是否有数据元素；
		// rewind()方法与flip()很相似，区别在于rewind()不会影响limit，而flip()会重设limit属性值
		return mStream.remaining();
	}

	public int getInt() {
		return mStream.getInt();
	}

	public long getUInt() {
		return ByteHelper.getUnsignedInt(mStream);
	}

	public short getShort() {
		return mStream.getShort();
	}

	public int getUShort() {
		return ByteHelper.getUnsignedShort(mStream);
	}

	public short getUByte() {
		return ByteHelper.getUnsignedByte(mStream);
	}

	public int getByte() {
		return ByteHelper.getUnsignedByte(mStream);
	}

	public String getHex(int len) {
		String hexStr = "";
		for (int i = 0; i < len; ++i) {
			short aByte = ByteHelper.getUnsignedByte(mStream);
			String aStr = Short.toString(aByte);
			String aHex = ByteHelper.str2HexStr(aStr);
			String bytesStr = aStr + aHex;
			hexStr += bytesStr;
		}
		return hexStr;
	}

	public ByteBuffer getBytes(int len) {
		byte[] ret = new byte[len];
		mStream.get(ret, 0, len);
		return ByteBuffer.wrap(ret);
	}

	// ///////////

	/** 读取字符串类型(服务端使用GBK编码表示中文，默认BYTE表示长度) */
	public String getStr() {
		Charset cs = Charset.forName("bg2312");
		CharBuffer cb = cs.decode(mStream);
		char[] charArray = cb.array();
		String str = new String(charArray);
		return str;
	}

}