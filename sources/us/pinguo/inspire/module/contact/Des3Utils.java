package us.pinguo.inspire.module.contact;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import org.apache.commons.codec.binary.Base64;
/* loaded from: classes9.dex */
public class Des3Utils {
    public static final String DES_KEY = "6d0baeca";
    private static final String KEY_NAME = "DESede";
    private static final String NAME = "DESede/CBC/PKCS5Padding";

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKey generateSecret = SecretKeyFactory.getInstance(KEY_NAME).generateSecret(new DESedeKeySpec(padding(bArr2, 24)));
        Cipher cipher = Cipher.getInstance(NAME);
        cipher.init(2, generateSecret, new IvParameterSpec(padding(bArr2, 8)));
        return cipher.doFinal(bArr);
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKey generateSecret = SecretKeyFactory.getInstance(KEY_NAME).generateSecret(new DESedeKeySpec(padding(bArr2, 24)));
        Cipher cipher = Cipher.getInstance(NAME);
        cipher.init(1, generateSecret, new IvParameterSpec(padding(bArr2, 8)));
        return cipher.doFinal(bArr);
    }

    public static String encryptAndBase64(String str, String str2) throws Exception {
        return new String(Base64.encodeBase64(encrypt(str.getBytes(), str2.getBytes())));
    }

    private static byte[] padding(byte[] bArr, int i2) {
        byte[] bArr2 = new byte[i2];
        if (i2 > bArr.length) {
            System.arraycopy(bArr, 0, bArr2, i2 - bArr.length, bArr.length);
        } else {
            System.arraycopy(bArr, bArr.length - i2, bArr2, 0, i2);
        }
        return bArr2;
    }
}
