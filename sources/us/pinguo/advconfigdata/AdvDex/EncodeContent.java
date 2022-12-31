package us.pinguo.advconfigdata.AdvDex;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes3.dex */
public class EncodeContent {
    private static final String HEX = "0123456789ABCDEF";

    private static void appendHex(StringBuffer stringBuffer, byte b) {
        stringBuffer.append(HEX.charAt((b >> 4) & 15));
        stringBuffer.append(HEX.charAt(b & 15));
    }

    public static String decrypt(String str, String str2) throws Exception {
        return new String(decrypt(getRawKey(str.getBytes()), toByte(str2)));
    }

    public static String encrypt(String str, String str2) throws Exception {
        return toHex(encrypt(getRawKey(str.getBytes()), str2.getBytes()));
    }

    public static String fromHex(String str) {
        return new String(toByte(str));
    }

    private static byte[] getRawKey(byte[] bArr) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG", "Crypto");
        secureRandom.setSeed(bArr);
        keyGenerator.init(128, secureRandom);
        return keyGenerator.generateKey().getEncoded();
    }

    public static byte[] toByte(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = Integer.valueOf(str.substring(i3, i3 + 2), 16).byteValue();
        }
        return bArr;
    }

    public static String toHex(String str) {
        return toHex(str.getBytes());
    }

    public static String toHex(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            appendHex(stringBuffer, b);
        }
        return stringBuffer.toString();
    }

    private static byte[] encrypt(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, secretKeySpec);
        cipher.init(1, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
        return cipher.doFinal(bArr2);
    }

    private static byte[] decrypt(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(2, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
        return cipher.doFinal(bArr2);
    }
}
