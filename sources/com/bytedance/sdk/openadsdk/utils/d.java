package com.bytedance.sdk.openadsdk.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import java.io.ByteArrayOutputStream;
/* compiled from: BitmapUtils.java */
/* loaded from: classes.dex */
public class d {
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0027, code lost:
        if (r1 == null) goto L15;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(android.graphics.Bitmap r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L26
            r1.<init>()     // Catch: java.lang.Throwable -> L26
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch: java.lang.Throwable -> L27
            r3 = 100
            r4.compress(r2, r3, r1)     // Catch: java.lang.Throwable -> L27
            r1.flush()     // Catch: java.lang.Throwable -> L27
            r1.close()     // Catch: java.lang.Throwable -> L27
            byte[] r4 = r1.toByteArray()     // Catch: java.lang.Throwable -> L27
            r2 = 0
            java.lang.String r0 = android.util.Base64.encodeToString(r4, r2)     // Catch: java.lang.Throwable -> L27
        L1f:
            r1.flush()     // Catch: java.lang.Throwable -> L2a
            r1.close()     // Catch: java.lang.Throwable -> L2a
            goto L2a
        L26:
            r1 = r0
        L27:
            if (r1 == 0) goto L2a
            goto L1f
        L2a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.d.a(android.graphics.Bitmap):java.lang.String");
    }

    public static byte[] b(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bitmap.getByteCount());
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    @Nullable
    public static Bitmap a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Throwable unused) {
            return null;
        }
    }
}
