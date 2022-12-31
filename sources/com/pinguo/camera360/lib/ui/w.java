package com.pinguo.camera360.lib.ui;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
/* compiled from: WebviewUtil.java */
/* loaded from: classes3.dex */
public final class w {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r8v8 */
    public static String a(Context context, int i2, Intent intent, String str, String str2) {
        Uri data;
        ?? r8;
        BufferedOutputStream bufferedOutputStream;
        String j2 = us.pinguo.webview.b.j();
        if (j2 == null) {
            return null;
        }
        if (i2 == 1002) {
            if (intent == null || (data = intent.getData()) == null) {
                return null;
            }
            str = j2 + File.separator + "IMG_" + System.currentTimeMillis() + ".jpg";
            String scheme = data.getScheme();
            if ("file".equals(scheme) || FirebaseAnalytics.Param.CONTENT.equals(scheme)) {
                try {
                    ContentResolver contentResolver = context.getContentResolver();
                    if (FirebaseAnalytics.Param.CONTENT.equals(scheme)) {
                        r8 = "image/jpeg".equalsIgnoreCase(contentResolver.getType(data));
                    } else {
                        r8 = data.getPath().endsWith(".jpg");
                    }
                    if (r8 == 0) {
                        return "ERROR_TYPE";
                    }
                    try {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(contentResolver.openInputStream(data), 8192);
                        try {
                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
                            try {
                                byte[] bArr = new byte[8192];
                                while (true) {
                                    int read = bufferedInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    bufferedOutputStream.write(bArr, 0, read);
                                }
                                bufferedOutputStream.close();
                                try {
                                    bufferedInputStream.close();
                                } catch (Exception unused) {
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (bufferedOutputStream != null) {
                                    bufferedOutputStream.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedOutputStream = null;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            us.pinguo.common.log.a.f(th);
                            if (r8 != 0) {
                                try {
                                    r8.close();
                                } catch (Exception unused2) {
                                }
                            }
                            return null;
                        } catch (Throwable th4) {
                            if (r8 != 0) {
                                try {
                                    r8.close();
                                } catch (Exception unused3) {
                                }
                            }
                            throw th4;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    r8 = 0;
                }
            }
        }
        if (str != null && new File(str).exists()) {
            try {
                return e(str, j2 + File.separator + "upload_" + System.currentTimeMillis() + ".jpg", str2);
            } catch (Exception unused4) {
                return null;
            }
        }
        return null;
    }

    public static boolean b(String str) {
        return !c(str);
    }

    public static boolean c(String str) {
        return str == null || str.isEmpty();
    }

    private static String d(String str, String str2, int i2) {
        if (i2 == 0) {
            return str;
        }
        try {
            us.pinguo.util.e.t(str2, us.pinguo.util.e.p(BitmapFactory.decodeFile(str), i2), 95);
            return str2;
        } catch (Throwable th) {
            us.pinguo.common.log.a.f(th);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00ae A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static java.lang.String e(java.lang.String r10, java.lang.String r11, java.lang.String r12) throws java.io.IOException {
        /*
            boolean r0 = b(r12)
            r1 = 1280(0x500, float:1.794E-42)
            r2 = 200(0xc8, float:2.8E-43)
            r3 = 2
            r4 = 0
            r5 = 720(0x2d0, float:1.009E-42)
            r6 = 3
            r7 = 1
            if (r0 == 0) goto L37
            char r0 = r12.charAt(r4)
            r8 = 119(0x77, float:1.67E-43)
            if (r0 != r8) goto L1e
            java.lang.String r12 = r12.substring(r7)
            r6 = 1
            goto L27
        L1e:
            r8 = 104(0x68, float:1.46E-43)
            if (r0 != r8) goto L27
            java.lang.String r12 = r12.substring(r7)
            r6 = 2
        L27:
            int r5 = java.lang.Integer.parseInt(r12)     // Catch: java.lang.Exception -> L2c
            goto L2d
        L2c:
        L2d:
            if (r5 >= r2) goto L32
            r1 = 200(0xc8, float:2.8E-43)
            goto L39
        L32:
            if (r5 <= r1) goto L35
            goto L39
        L35:
            r1 = r5
            goto L39
        L37:
            r1 = 720(0x2d0, float:1.009E-42)
        L39:
            android.graphics.BitmapFactory$Options r12 = new android.graphics.BitmapFactory$Options
            r12.<init>()
            r12.inSampleSize = r7
            r12.inJustDecodeBounds = r7
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r10)
            r2 = 0
            android.graphics.BitmapFactory.decodeStream(r0, r2, r12)     // Catch: java.lang.Throwable -> Lb0
            r0.close()     // Catch: java.io.IOException -> L4f
            goto L50
        L4f:
        L50:
            boolean r0 = r12.mCancel
            if (r0 != 0) goto Laf
            int r0 = r12.outWidth
            r5 = 100
            if (r0 <= r5) goto Laf
            int r0 = r12.outHeight
            if (r0 > r5) goto L5f
            goto Laf
        L5f:
            int r0 = us.pinguo.util.j.l(r10)
            int r5 = r12.outWidth
            int r12 = r12.outHeight
            r8 = 90
            if (r0 == r8) goto L6f
            r8 = 270(0x10e, float:3.78E-43)
            if (r0 != r8) goto L70
        L6f:
            r4 = 1
        L70:
            if (r4 == 0) goto L75
            r9 = r5
            r5 = r12
            r12 = r9
        L75:
            int r4 = java.lang.Math.max(r5, r12)
            if (r6 != r7) goto L86
            if (r5 > r1) goto L82
            java.lang.String r10 = d(r10, r11, r0)
            return r10
        L82:
            float r12 = (float) r1
            float r1 = (float) r5
        L84:
            float r12 = r12 / r1
            goto L9e
        L86:
            if (r6 != r3) goto L94
            if (r12 > r1) goto L8f
            java.lang.String r10 = d(r10, r11, r0)
            return r10
        L8f:
            float r1 = (float) r1
            float r12 = (float) r12
            float r12 = r1 / r12
            goto L9e
        L94:
            if (r4 > r1) goto L9b
            java.lang.String r10 = d(r10, r11, r0)
            return r10
        L9b:
            float r12 = (float) r1
            float r1 = (float) r4
            goto L84
        L9e:
            r1 = 95
            us.pinguo.image.ImageNative.scaleImg(r10, r11, r0, r12, r1)
            java.io.File r10 = new java.io.File
            r10.<init>(r11)
            boolean r10 = r10.exists()
            if (r10 == 0) goto Laf
            return r11
        Laf:
            return r2
        Lb0:
            r10 = move-exception
            r0.close()     // Catch: java.io.IOException -> Lb4
        Lb4:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.lib.ui.w.e(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static String f(String str, File file) throws IOException {
        HashMap hashMap = new HashMap();
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
        hashMap.put("sig", com.pinguo.camera360.g.a.a.a(hashMap, "*jNb29>,1*)4`:\\Bo)023&3MnvQ14Lk@"));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("file", file);
        return com.pinguo.camera360.g.a.a.b(str, hashMap, hashMap2);
    }
}
