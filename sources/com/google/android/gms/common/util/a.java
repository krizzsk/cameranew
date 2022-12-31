package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public class a {
    public static byte[] a(Context context, String str) throws PackageManager.NameNotFoundException {
        MessageDigest b;
        PackageInfo e2 = com.google.android.gms.common.wrappers.b.a(context).e(str, 64);
        Signature[] signatureArr = e2.signatures;
        if (signatureArr == null || signatureArr.length != 1 || (b = b("SHA1")) == null) {
            return null;
        }
        return b.digest(e2.signatures[0].toByteArray());
    }

    public static MessageDigest b(String str) {
        MessageDigest messageDigest;
        for (int i2 = 0; i2 < 2; i2++) {
            try {
                messageDigest = MessageDigest.getInstance(str);
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }
}
