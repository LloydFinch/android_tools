package com.example.JiamiApp.crypt;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

/**
 * Created by VennUser on 2015/8/11.
 */
//加密工具类,支持DES,DESede,AES,RSA
//支持密钥的生成
//支持数据签名
public final class EncryptUtils {
	private EncryptUtils() {}

	////////////////////////////////////////////////////////
	//DES加密     密钥8字节
	///////////////////////////////////////////////////////
	public static byte[] desEncrypt(byte[] data, byte[] key) {
		byte[] result = null;
		if (data != null && data.length > 0) {
			if (key != null && key.length == 8) {
				try {
					Cipher cipher = Cipher.getInstance("DES");
					DESKeySpec keySpec = new DESKeySpec(key);
					SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
					SecretKey secretKey = keyFactory.generateSecret(keySpec);
					cipher.init(Cipher.ENCRYPT_MODE, secretKey);
					result = cipher.doFinal(data);
				}
				catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
				catch (NoSuchPaddingException e) {
					e.printStackTrace();
				}
				catch (InvalidKeyException e) {
					e.printStackTrace();
				}
				catch (InvalidKeySpecException e) {
					e.printStackTrace();
				}
				catch (BadPaddingException e) {
					e.printStackTrace();
				}
				catch (IllegalBlockSizeException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	////////////////////////////////////////////////////////
	//DES解密     密钥8字节
	///////////////////////////////////////////////////////
	public static byte[] desDecrypt(byte[] data, byte[] key) {
		byte[] content = null;
		if (data != null && data.length > 0) {
			if (key != null && key.length == 8) {
				try {
					Cipher cipher = Cipher.getInstance("DES");
					DESKeySpec keySpec = new DESKeySpec(key);
					SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
					SecretKey secretKey = keyFactory.generateSecret(keySpec);
					cipher.init(Cipher.DECRYPT_MODE, secretKey);
					content = cipher.doFinal(data);
				}
				catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
				catch (NoSuchPaddingException e) {
					e.printStackTrace();
				}
				catch (InvalidKeyException e) {
					e.printStackTrace();
				}
				catch (InvalidKeySpecException e) {
					e.printStackTrace();
				}
				catch (BadPaddingException e) {
					e.printStackTrace();
				}
				catch (IllegalBlockSizeException e) {
					e.printStackTrace();
				}
			}
		}
		return content;
	}

	////////////////////////////////////////////////////////
	//DESede加密     密钥24字节
	///////////////////////////////////////////////////////
	public static byte[] desEdeEncrypt(byte[] data, byte[] key) {
		byte[] result = null;
		if (data != null && data.length > 0) {
			if (key != null && key.length == 24) {
				try {
					Cipher cipher = Cipher.getInstance("DESede");
					DESedeKeySpec keySpec = new DESedeKeySpec(key);
					SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
					SecretKey secretKey = keyFactory.generateSecret(keySpec);
					cipher.init(Cipher.ENCRYPT_MODE, secretKey);
					result = cipher.doFinal(data);
				}
				catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
				catch (NoSuchPaddingException e) {
					e.printStackTrace();
				}
				catch (InvalidKeyException e) {
					e.printStackTrace();
				}
				catch (InvalidKeySpecException e) {
					e.printStackTrace();
				}
				catch (BadPaddingException e) {
					e.printStackTrace();
				}
				catch (IllegalBlockSizeException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	////////////////////////////////////////////////////////
	//DESede解密     密钥24字节
	///////////////////////////////////////////////////////
	public static byte[] desEdeDecrypt(byte[] data, byte[] key) {
		byte[] content = null;
		if (data != null && data.length > 0) {
			if (key != null && key.length == 24) {
				try {
					Cipher cipher = Cipher.getInstance("DESede");
					DESedeKeySpec keySpec = new DESedeKeySpec(key);
					SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
					SecretKey secretKey = keyFactory.generateSecret(keySpec);
					cipher.init(Cipher.DECRYPT_MODE, secretKey);
					content = cipher.doFinal(data);
				}
				catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
				catch (NoSuchPaddingException e) {
					e.printStackTrace();
				}
				catch (InvalidKeyException e) {
					e.printStackTrace();
				}
				catch (InvalidKeySpecException e) {
					e.printStackTrace();
				}
				catch (BadPaddingException e) {
					e.printStackTrace();
				}
				catch (IllegalBlockSizeException e) {
					e.printStackTrace();
				}
			}
		}
		return content;
	}


	////////////////////////////////////////////////////////
	//AES加密1     密钥16字节
	///////////////////////////////////////////////////////

	public static byte[] aesEncrypt(byte[] data, byte[] key) {
		byte[] result = null;
		if (data != null && data.length > 0) {
			if (key != null && key.length == 16) {
				try {
					Cipher cipher = Cipher.getInstance("AES");
					SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
					;
					cipher.init(Cipher.ENCRYPT_MODE, secretKey);
					result = cipher.doFinal(data);
				}
				catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
				catch (NoSuchPaddingException e) {
					e.printStackTrace();
				}
				catch (InvalidKeyException e) {
					e.printStackTrace();
				}
				catch (BadPaddingException e) {
					e.printStackTrace();
				}
				catch (IllegalBlockSizeException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}


	////////////////////////////////////////////////////////
	//AES解密1    密钥16字节
	///////////////////////////////////////////////////////
	public static byte[] aesDecrypt(byte[] data, byte[] key) {
		byte[] content = null;
		if (data != null && data.length > 0) {
			if (key != null && key.length == 16) {
				try {
					Cipher cipher = Cipher.getInstance("AES");
					SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
					cipher.init(Cipher.DECRYPT_MODE, secretKey);
					content = cipher.doFinal(data);
				}
				catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
				catch (NoSuchPaddingException e) {
					e.printStackTrace();
				}
				catch (InvalidKeyException e) {
					e.printStackTrace();
				}
				catch (BadPaddingException e) {
					e.printStackTrace();
				}
				catch (IllegalBlockSizeException e) {
					e.printStackTrace();
				}
			}
		}
		return content;
	}

	////////////////////////////////////////////////////////
	//AES加密2     密钥16字节
	///////////////////////////////////////////////////////

	public static byte[] aesPaddingEncrypt(byte[] data, byte[] key, byte[] ivKey) {
		byte[] result = null;
		if (data != null && data.length > 0) {
			if (key != null && key.length == 16) {
				if (ivKey != null && ivKey.length == 16) {
					try {
						Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
						SecretKeySpec secretKey = new SecretKeySpec(key, "AES");

						//向量密码
						IvParameterSpec ivSpec = new IvParameterSpec(ivKey);

						cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
						result = cipher.doFinal(data);
					}
					catch (NoSuchAlgorithmException e) {
						e.printStackTrace();
					}
					catch (NoSuchPaddingException e) {
						e.printStackTrace();
					}
					catch (InvalidKeyException e) {
						e.printStackTrace();
					}
					catch (BadPaddingException e) {
						e.printStackTrace();
					}
					catch (IllegalBlockSizeException e) {
						e.printStackTrace();
					}
					catch (InvalidAlgorithmParameterException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return result;
	}

	////////////////////////////////////////////////////////
	//AES解密2     密钥16字节
	///////////////////////////////////////////////////////
	public static byte[] aesPaddingDecrypt(byte[] data, byte[] key, byte[] ivKey) {
		byte[] result = null;
		if (data != null && data.length > 0) {
			if (key != null && key.length == 16) {
				if (ivKey != null && ivKey.length == 16) {
					try {
						Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
						SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
						IvParameterSpec ivSpec = new IvParameterSpec(ivKey);

						cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
						result = cipher.doFinal(data);
					}
					catch (NoSuchAlgorithmException e) {
						e.printStackTrace();
					}
					catch (NoSuchPaddingException e) {
						e.printStackTrace();
					}
					catch (InvalidKeyException e) {
						e.printStackTrace();
					}
					catch (BadPaddingException e) {
						e.printStackTrace();
					}
					catch (IllegalBlockSizeException e) {
						e.printStackTrace();
					}
					catch (InvalidAlgorithmParameterException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return result;
	}
}
