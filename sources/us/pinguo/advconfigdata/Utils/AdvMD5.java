package us.pinguo.advconfigdata.Utils;

import com.adjust.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes3.dex */
public class AdvMD5 {
    public static byte[] PGMD5(String str) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(Constants.MD5);
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (NoSuchAlgorithmException unused) {
        }
        return messageDigest.digest();
    }

    public static String getCommonMd5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer("");
            for (int i2 = 0; i2 < digest.length; i2++) {
                int i3 = digest[i2];
                if (i3 < 0) {
                    i3 += 256;
                }
                if (i3 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i3));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getMd5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < digest.length; i2++) {
                stringBuffer.append(String.format("%02x", Byte.valueOf(digest[i2])));
            }
            messageDigest.update(stringBuffer.toString().getBytes("UTF-8"));
            StringBuffer stringBuffer2 = new StringBuffer();
            byte[] digest2 = messageDigest.digest();
            for (int i3 = 0; i3 < digest2.length; i3++) {
                stringBuffer2.append(String.format("%02x", Byte.valueOf(digest2[i3])));
            }
            return stringBuffer2.toString();
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static String pinguoMD5(String str, String str2) throws UnsupportedEncodingException {
        byte[] bytes = (str2 == null || str2.length() == 0) ? null : str2.getBytes("UTF-8");
        byte[] PGMD5 = PGMD5(str);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < PGMD5.length; i2++) {
            stringBuffer.append(String.format("%02x", Byte.valueOf((byte) (PGMD5[i2] ^ bytes[i2 % bytes.length]))));
        }
        return stringBuffer.toString();
    }
}
