package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public class q {
    private static String a;
    private static int b;

    @Nullable
    public static String a() {
        if (a == null) {
            if (b == 0) {
                b = Process.myPid();
            }
            a = c(b);
        }
        return a;
    }

    private static BufferedReader b(String str) throws IOException {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return new BufferedReader(new FileReader(str));
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    @Nullable
    private static String c(int i2) {
        Throwable th;
        BufferedReader bufferedReader;
        String str = null;
        if (i2 <= 0) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder(25);
            sb.append("/proc/");
            sb.append(i2);
            sb.append("/cmdline");
            bufferedReader = b(sb.toString());
            try {
                str = bufferedReader.readLine().trim();
                k.a(bufferedReader);
            } catch (IOException unused) {
                k.a(bufferedReader);
                return str;
            } catch (Throwable th2) {
                th = th2;
                k.a(bufferedReader);
                throw th;
            }
        } catch (IOException unused2) {
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
        return str;
    }
}
