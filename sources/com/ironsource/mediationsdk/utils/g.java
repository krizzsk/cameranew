package com.ironsource.mediationsdk.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.ironsource.mediationsdk.logger.IronLog;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* compiled from: IronSourceAES.java */
/* loaded from: classes2.dex */
public class g {
    public static synchronized String a(String str) {
        synchronized (g.class) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                byte[] a = h.a(str);
                if (a != null) {
                    return f("C38FB23A402222A0C17D34A92F971D1F", a);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return "";
        }
    }

    public static synchronized String b(String str, String str2) {
        synchronized (g.class) {
            byte[] c = c(str, str2);
            if (c != null) {
                return new String(c);
            }
            return "";
        }
    }

    public static synchronized byte[] c(String str, String str2) {
        synchronized (g.class) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            try {
                SecretKeySpec g2 = g(str);
                byte[] bArr = new byte[16];
                Arrays.fill(bArr, (byte) 0);
                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
                byte[] decode = Base64.decode(str2, 0);
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
                cipher.init(2, g2, ivParameterSpec);
                return cipher.doFinal(decode);
            } catch (Exception e2) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("exception on decryption error: " + e2.getMessage());
                e2.printStackTrace();
                return null;
            }
        }
    }

    public static synchronized String d(String str) {
        synchronized (g.class) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                byte[] c = c("C38FB23A402222A0C17D34A92F971D1F", str);
                if (c != null) {
                    return h.b(c);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return "";
        }
    }

    public static synchronized String e(String str, String str2) {
        synchronized (g.class) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            try {
                return f(str, str2.getBytes("UTF8"));
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
    }

    public static synchronized String f(String str, byte[] bArr) {
        synchronized (g.class) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (bArr == null) {
                return "";
            }
            try {
                SecretKeySpec g2 = g(str);
                byte[] bArr2 = new byte[16];
                Arrays.fill(bArr2, (byte) 0);
                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
                cipher.init(1, g2, ivParameterSpec);
                return Base64.encodeToString(cipher.doFinal(bArr), 0).replaceAll(System.getProperty("line.separator"), "");
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
    }

    private static SecretKeySpec g(String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[32];
        Arrays.fill(bArr, (byte) 0);
        byte[] bytes = str.getBytes("UTF-8");
        System.arraycopy(bytes, 0, bArr, 0, bytes.length < 32 ? bytes.length : 32);
        return new SecretKeySpec(bArr, "AES");
    }
}
