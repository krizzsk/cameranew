package com.bytedance.sdk.open.aweme.utils;

import com.adjust.sdk.Constants;
import java.security.MessageDigest;
/* loaded from: classes.dex */
public class a {

    /* renamed from: k  reason: collision with root package name */
    private static final char[] f1275k = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(String str) {
        try {
            return a(str.getBytes());
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr = new char[32];
            int i2 = 0;
            for (int i3 = 0; i3 < 16; i3++) {
                byte b = digest[i3];
                int i4 = i2 + 1;
                char[] cArr2 = f1275k;
                cArr[i2] = cArr2[(b >>> 4) & 15];
                i2 = i4 + 1;
                cArr[i4] = cArr2[b & 15];
            }
            return new String(cArr);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
