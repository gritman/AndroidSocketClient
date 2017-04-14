package com.bianfeng.tongtian;

import java.nio.ByteBuffer;

public class ByteHelper {

	public static short getUnsignedByte(ByteBuffer buff) {
		return (short) (buff.get() & 0xff);
	}

	public static short getUnsignedByte(ByteBuffer buff, int position) {
		return (short) (buff.get(position) & (short) 0xff);
	}

	public static void putUnsignedByte(ByteBuffer buff, int value) {
		buff.put((byte) (value & 0xff));
	}

	public static void putUnsignedByte(ByteBuffer buff, int position,
			int value) {
		buff.put(position, (byte) (value & 0xff));
	}

	public static int getUnsignedShort(ByteBuffer buff) {
		return buff.getShort() & 0xffff;
	}

	public static int getUnsignedShort(ByteBuffer buff, int position) {
		return buff.getShort(position) & (short) 0xffff;
	}

	public static void putUnsignedShort(ByteBuffer buff, int value) {
		buff.putShort((short) (value & 0xffff));
	}

	public static void putUnsignedShort(ByteBuffer buff, int position,
			int value) {
		buff.putShort(position, (short) (value & 0xffff));
	}

	public static long getUnsignedInt(ByteBuffer buff) {
		return buff.getInt() & 0xffffffffL;
	}

	public static long getUnsignedInt(ByteBuffer buff, int position) {
		return buff.getInt(position) & 0xffffffffL;
	}

	public static void putUnsignedInt(ByteBuffer buff, int value) {
		buff.putInt((int) (value & 0xffffffffL));
	}

	public static void putUnsignedInt(ByteBuffer buff, int position,
			int value) {
		buff.putInt(position, (int) (value & 0xffff));
	}

	/**
	 * Convert byte[] to hex
	 * string.这里我们可以将byte转换成int，然后利用Integer.toHexString(int)来转换成16进制字符串。
	 * 
	 * @param src
	 *                byte[] data
	 * @return hex string
	 */
	public static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	/**
	 * Convert hex string to byte[]
	 * 
	 * @param hexString
	 *                the hex string
	 * @return byte[]
	 */
	public static byte[] hexStringToBytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++) {
			int pos = i * 2;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}

	/**
	 * Convert char to byte
	 * 
	 * @param c
	 *                char
	 * @return byte
	 */
	private static byte charToByte(char c) {
		return (byte) "0123456789ABCDEF".indexOf(c);
	}
	
	 /**  
	     * 字符串转换成十六进制字符串 
	     * @param String str 待转换的ASCII字符串 
	     * @return String 每个Byte之间空格分隔，如: [61 6C 6B] 
	     */    
	    public static String str2HexStr(String str)  
	    {    
	  
	        char[] chars = "0123456789ABCDEF".toCharArray();    
	        StringBuilder sb = new StringBuilder("");  
	        byte[] bs = str.getBytes();    
	        int bit;    
	          
	        for (int i = 0; i < bs.length; i++)  
	        {    
	            bit = (bs[i] & 0x0f0) >> 4;    
	            sb.append(chars[bit]);    
	            bit = bs[i] & 0x0f;    
	            sb.append(chars[bit]);  
	            sb.append(' ');  
	        }    
	        return sb.toString().trim();    
	    }  
	      
	    /**  
	     * 十六进制转换字符串 
	     * @param String str Byte字符串(Byte之间无分隔符 如:[616C6B]) 
	     * @return String 对应的字符串 
	     */    
	    public static String hexStr2Str(String hexStr)  
	    {    
	        String str = "0123456789ABCDEF";    
	        char[] hexs = hexStr.toCharArray();    
	        byte[] bytes = new byte[hexStr.length() / 2];    
	        int n;    
	  
	        for (int i = 0; i < bytes.length; i++)  
	        {    
	            n = str.indexOf(hexs[2 * i]) * 16;    
	            n += str.indexOf(hexs[2 * i + 1]);    
	            bytes[i] = (byte) (n & 0xff);    
	        }    
	        return new String(bytes);    
	    }  
	      
	    /** 
	     * bytes转换成十六进制字符串 
	     * @param byte[] b byte数组 
	     * @return String 每个Byte值之间空格分隔 
	     */  
	    public static String byte2HexStr(byte[] b)  
	    {  
	        String stmp="";  
	        StringBuilder sb = new StringBuilder("");  
	        for (int n=0;n<b.length;n++)  
	        {  
	            stmp = Integer.toHexString(b[n] & 0xFF);  
	            sb.append((stmp.length()==1)? "0"+stmp : stmp);  
	            sb.append(" ");  
	        }  
	        return sb.toString().toUpperCase().trim();  
	    }  
	      
	    /** 
	     * bytes字符串转换为Byte值 
	     * @param String src Byte字符串，每个Byte之间没有分隔符 
	     * @return byte[] 
	     */  
	    public static byte[] hexStr2Bytes(String src)  
	    {  
	        int m=0,n=0;  
	        int l=src.length()/2;  
	        System.out.println(l);  
	        byte[] ret = new byte[l];  
	        for (int i = 0; i < l; i++)  
	        {  
	            m=i*2+1;  
	            n=m+1;  
	            ret[i] = Byte.decode("0x" + src.substring(i*2, m) + src.substring(m,n));  
	        }  
	        return ret;  
	    }  
	  
	    /** 
	     * String的字符串转换成unicode的String 
	     * @param String strText 全角字符串 
	     * @return String 每个unicode之间无分隔符 
	     * @throws Exception 
	     */  
	    public static String strToUnicode(String strText)  
	        throws Exception  
	    {  
	        char c;  
	        StringBuilder str = new StringBuilder();  
	        int intAsc;  
	        String strHex;  
	        for (int i = 0; i < strText.length(); i++)  
	        {  
	            c = strText.charAt(i);  
	            intAsc = (int) c;  
	            strHex = Integer.toHexString(intAsc);  
	            if (intAsc > 128)  
	                str.append("\\u" + strHex);  
	            else // 低位在前面补00  
	                str.append("\\u00" + strHex);  
	        }  
	        return str.toString();  
	    }  
	      
	    /** 
	     * unicode的String转换成String的字符串 
	     * @param String hex 16进制值字符串 （一个unicode为2byte） 
	     * @return String 全角字符串 
	     */  
	    public static String unicodeToString(String hex)  
	    {  
	        int t = hex.length() / 6;  
	        StringBuilder str = new StringBuilder();  
	        for (int i = 0; i < t; i++)  
	        {  
	            String s = hex.substring(i * 6, (i + 1) * 6);  
	            // 高位需要补上00再转  
	            String s1 = s.substring(2, 4) + "00";  
	            // 低位直接转  
	            String s2 = s.substring(4);  
	            // 将16进制的string转为int  
	            int n = Integer.valueOf(s1, 16) + Integer.valueOf(s2, 16);  
	            // 将int转换为字符  
	            char[] chars = Character.toChars(n);  
	            str.append(new String(chars));  
	        }  
	        return str.toString();  
	    } 
	
}
