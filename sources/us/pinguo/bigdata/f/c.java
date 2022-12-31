package us.pinguo.bigdata.f;

import com.adjust.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* compiled from: BDSigner.java */
/* loaded from: classes3.dex */
public class c {
    public static String a(String str, String str2) {
        return b(str, str2);
    }

    private static String b(String str, String str2) {
        if (str != null && str2 != null) {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
                messageDigest.reset();
                byte[] digest = messageDigest.digest(str.getBytes("UTF-8"));
                byte[] bytes = str2.getBytes("UTF-8");
                for (int i2 = 0; i2 < digest.length; i2++) {
                    stringBuffer.append(String.format("%02x", Byte.valueOf((byte) (digest[i2] ^ bytes[i2 % bytes.length]))));
                }
                return stringBuffer.toString();
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return null;
            } catch (NoSuchAlgorithmException e3) {
                e3.printStackTrace();
            }
        }
        return null;
    }
}
