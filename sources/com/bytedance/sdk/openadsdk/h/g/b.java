package com.bytedance.sdk.openadsdk.h.g;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* compiled from: MD5.java */
/* loaded from: classes.dex */
public class b {
    private static final MessageDigest a = a();
    private static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private b() {
    }

    private static MessageDigest a() {
        try {
            return MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String a(String str) {
        byte[] digest;
        MessageDigest messageDigest = a;
        if (messageDigest == null) {
            return "";
        }
        byte[] bytes = str.getBytes(d.a);
        synchronized (b.class) {
            digest = messageDigest.digest(bytes);
        }
        return a(digest);
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length << 1];
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = i2 + 1;
            char[] cArr2 = b;
            cArr[i2] = cArr2[(b2 & 240) >> 4];
            i2 = i3 + 1;
            cArr[i3] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }
}
