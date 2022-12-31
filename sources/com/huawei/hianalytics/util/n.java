package com.huawei.hianalytics.util;

import android.text.TextUtils;
import com.adjust.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
/* loaded from: classes2.dex */
public abstract class n {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        return "f6040d0e807aaec325ecf44823765544e92905158169f694b282bf17388632cf95a83bae7d2d235c1f039";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        String str2;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA256);
            messageDigest.update(str.getBytes("UTF-8"));
            return h.a(messageDigest.digest());
        } catch (UnsupportedEncodingException unused) {
            str2 = "getSHA256StrJava, update Exception ";
            com.huawei.hianalytics.b.b.d("HiStringUtils", str2);
            return "";
        } catch (NoSuchAlgorithmException unused2) {
            str2 = "getSHA256StrJava, getInstance Exception";
            com.huawei.hianalytics.b.b.d("HiStringUtils", str2);
            return "";
        }
    }

    public static String a(String str, int i2) {
        int i3;
        if (!TextUtils.isEmpty(str) && str.length() > i2) {
            int length = str.length();
            for (int i4 = 0; i4 < i2; i4++) {
                str = str.substring(i3) + str.substring(0, length - 1);
            }
        }
        return str;
    }

    public static String a(String str, String str2, String str3, String str4, String str5) {
        byte[] a = h.a(str);
        byte[] a2 = h.a(str2);
        byte[] a3 = h.a(str3);
        byte[] a4 = h.a(str4);
        int length = a.length;
        if (length > a2.length) {
            length = a2.length;
        }
        if (length > a3.length) {
            length = a3.length;
        }
        if (length > a4.length) {
            length = a4.length;
        }
        char[] cArr = new char[length];
        for (int i2 = 0; i2 < length; i2++) {
            cArr[i2] = (char) (((a[i2] ^ a2[i2]) ^ a3[i2]) ^ a4[i2]);
        }
        return a(cArr, h.a(str5));
    }

    private static String a(char[] cArr, byte[] bArr) {
        String str;
        try {
            return h.a(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(cArr, bArr, 10000, 128)).getEncoded());
        } catch (NoSuchAlgorithmException unused) {
            str = "encryptPBKDF2 NoSuchAlgorithmException";
            com.huawei.hianalytics.b.b.d("HiAnalytics", str);
            return null;
        } catch (InvalidKeySpecException unused2) {
            str = "encryptPBKDF2 InvalidKeySpecException";
            com.huawei.hianalytics.b.b.d("HiAnalytics", str);
            return null;
        }
    }
}
