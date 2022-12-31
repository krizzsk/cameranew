package us.pinguo.advsdk.utils;

import com.adjust.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* compiled from: AdvMD5.java */
/* loaded from: classes3.dex */
public class c {
    public static byte[] a(String str) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(Constants.MD5);
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (NoSuchAlgorithmException unused) {
            System.exit(-1);
        }
        return messageDigest.digest();
    }

    public static String b(String str, String str2) throws UnsupportedEncodingException {
        byte[] bytes = (str2 == null || str2.length() == 0) ? null : str2.getBytes("UTF-8");
        byte[] a = a(str);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < a.length; i2++) {
            stringBuffer.append(String.format("%02x", Byte.valueOf((byte) (a[i2] ^ bytes[i2 % bytes.length]))));
        }
        return stringBuffer.toString();
    }
}
