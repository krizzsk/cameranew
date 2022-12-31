package com.tencent.mm.opensdk.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class b {
    public static Context a;
    private static final int b;
    private static final int c;

    /* renamed from: d  reason: collision with root package name */
    private static final int f8140d;

    /* renamed from: e  reason: collision with root package name */
    public static ThreadPoolExecutor f8141e;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        b = availableProcessors;
        int i2 = availableProcessors + 1;
        c = i2;
        int i3 = (availableProcessors * 2) + 1;
        f8140d = i3;
        f8141e = new ThreadPoolExecutor(i2, i3, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
    }

    public static int a(ContentResolver contentResolver, Uri uri) {
        Log.i("MicroMsg.SDK.Util", "getFileSize with content url");
        if (contentResolver == null || uri == null) {
            Log.w("MicroMsg.SDK.Util", "getFileSize fail, resolver or uri is null");
            return 0;
        }
        InputStream inputStream = null;
        try {
            try {
                InputStream openInputStream = contentResolver.openInputStream(uri);
                if (openInputStream == null) {
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    return 0;
                }
                int available = openInputStream.available();
                try {
                    openInputStream.close();
                } catch (IOException unused2) {
                }
                return available;
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            Log.w("MicroMsg.SDK.Util", "getFileSize fail, " + e2.getMessage());
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            return 0;
        }
    }

    public static int a(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            return (int) file.length();
        }
        if (a != null && str.startsWith(FirebaseAnalytics.Param.CONTENT)) {
            try {
                return a(a.getContentResolver(), Uri.parse(str));
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public static int a(String str, int i2) {
        if (str != null) {
            try {
                return str.length() <= 0 ? i2 : Integer.parseInt(str);
            } catch (Exception unused) {
                return i2;
            }
        }
        return i2;
    }

    public static boolean a(int i2) {
        return i2 == 36 || i2 == 46;
    }

    public static boolean b(String str) {
        return str == null || str.length() <= 0;
    }
}
