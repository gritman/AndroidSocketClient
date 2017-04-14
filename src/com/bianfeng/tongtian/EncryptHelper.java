package com.bianfeng.tongtian;

import java.nio.ByteBuffer;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptHelper {

	private static final String key = "F362120513E389FF2311D7360123100705A210007ACC023C3901DA2ECB12448B";
	private static final String iv = "15FF010034AB4CD355FEA122084F1307";
	
	public static byte[] akey = null;
	public static byte[] aiv = null;

	public static void init() {
		akey = ByteHelper.hexStringToBytes(key);
		aiv = ByteHelper.hexStringToBytes(iv);
	}
	
	public static byte[] encrypt(byte[] toEncryptData) throws Exception {
		try {
			Cipher cipher = Cipher.getInstance("AES/CFB/NoPadding");
			int blockSize = cipher.getBlockSize();

			int plaintextLength = toEncryptData.length;
			if (plaintextLength % blockSize != 0) {
				plaintextLength = plaintextLength
						+ (blockSize - (plaintextLength % blockSize));
			}

			byte[] plaintext = new byte[plaintextLength];
			System.arraycopy(toEncryptData, 0, plaintext, 0,
					toEncryptData.length);

			SecretKeySpec keyspec = new SecretKeySpec(
					key.getBytes(), "AES");
			IvParameterSpec ivspec = new IvParameterSpec(
					iv.getBytes());

			cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
			byte[] encrypted = cipher.doFinal(plaintext);

			return encrypted;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static byte[] desEncrypt(byte[] toDecryptData) throws Exception {
		try {
			Cipher cipher = Cipher.getInstance("AES/CFB/NoPadding");
			SecretKeySpec keyspec = new SecretKeySpec(
					key.getBytes(), "AES");
			IvParameterSpec ivspec = new IvParameterSpec(
					iv.getBytes());

			cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

			byte[] original = cipher.doFinal(toDecryptData);
			return original;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ByteBuffer encode(ByteBuffer data) {
		return data;
	}

	public static ByteBuffer decode(ByteBuffer data) {
		return data;
	}
}
