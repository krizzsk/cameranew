package com.unity3d.splash.services.c.a;

import android.os.Handler;
import android.os.Looper;
import com.adjust.sdk.Constants;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import com.unity3d.splash.services.core.log.DeviceLog;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes3.dex */
public class b {
    public static String a(String str) {
        return b(str.getBytes());
    }

    public static String b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA256);
            messageDigest.update(bArr, 0, bArr.length);
            return f(messageDigest.digest());
        } catch (NoSuchAlgorithmException e2) {
            DeviceLog.g("SHA-256 algorithm not found", e2);
            return null;
        }
    }

    public static byte[] c(File file) {
        if (file == null) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[(int) file.length()];
        int i2 = 0;
        int length = file.length() < 4096 ? (int) file.length() : 4096;
        while (true) {
            int read = fileInputStream.read(bArr, i2, length);
            if (read <= 0) {
                fileInputStream.close();
                return bArr;
            }
            i2 += read;
            if (file.length() - i2 < 4096) {
                length = ((int) file.length()) - i2;
            }
        }
    }

    public static void d(Runnable runnable) {
        e(runnable, 0L);
    }

    public static void e(Runnable runnable, long j2) {
        Handler handler = new Handler(Looper.getMainLooper());
        if (j2 > 0) {
            handler.postDelayed(runnable, j2);
        } else {
            handler.post(runnable);
        }
    }

    public static String f(byte[] bArr) {
        int i2;
        String str = "";
        for (byte b : bArr) {
            if ((b & Draft_75.END_OF_FRAME) <= 15) {
                str = str + "0";
            }
            str = str + Integer.toHexString(i2);
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean g(java.io.File r5, java.lang.String r6) {
        /*
            java.lang.String r0 = "Error closing FileOutputStream"
            r1 = 0
            if (r5 != 0) goto L6
            return r1
        L6:
            r2 = 0
            r3 = 1
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            byte[] r6 = r6.getBytes()     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L24
            r4.write(r6)     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L24
            r4.flush()     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L24
            r4.close()     // Catch: java.lang.Exception -> L1b
            goto L1f
        L1b:
            r6 = move-exception
            com.unity3d.splash.services.core.log.DeviceLog.g(r0, r6)
        L1f:
            r1 = 1
            goto L39
        L21:
            r5 = move-exception
            r2 = r4
            goto L51
        L24:
            r6 = move-exception
            r2 = r4
            goto L2a
        L27:
            r5 = move-exception
            goto L51
        L29:
            r6 = move-exception
        L2a:
            java.lang.String r3 = "Could not write file"
            com.unity3d.splash.services.core.log.DeviceLog.g(r3, r6)     // Catch: java.lang.Throwable -> L27
            if (r2 == 0) goto L39
            r2.close()     // Catch: java.lang.Exception -> L35
            goto L39
        L35:
            r6 = move-exception
            com.unity3d.splash.services.core.log.DeviceLog.g(r0, r6)
        L39:
            if (r1 == 0) goto L50
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r0 = "Wrote file: "
            r6.<init>(r0)
            java.lang.String r5 = r5.getAbsolutePath()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            com.unity3d.splash.services.core.log.DeviceLog.c(r5)
        L50:
            return r1
        L51:
            if (r2 == 0) goto L5b
            r2.close()     // Catch: java.lang.Exception -> L57
            goto L5b
        L57:
            r6 = move-exception
            com.unity3d.splash.services.core.log.DeviceLog.g(r0, r6)
        L5b:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.splash.services.c.a.b.g(java.io.File, java.lang.String):boolean");
    }
}
