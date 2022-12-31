package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.text.TextUtils;
import androidx.annotation.RequiresPermission;
import com.coremedia.iso.boxes.UserBox;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Locale;
import us.pinguo.common.network.common.header.PGTransHeader;
/* compiled from: IdUtils.java */
/* loaded from: classes.dex */
public class j {
    private static String a;
    private static String b;
    private static String c;

    /* renamed from: d  reason: collision with root package name */
    private static String f1675d;

    /* renamed from: e  reason: collision with root package name */
    private static String f1676e;

    /* renamed from: f  reason: collision with root package name */
    private static String f1677f;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f1678g;

    public static String a(Context context) {
        if (TextUtils.isEmpty(a) && !f1678g) {
            synchronized (j.class) {
                if (!f1678g) {
                    g(context);
                }
            }
        }
        try {
            if (TextUtils.isEmpty(a) && com.bytedance.sdk.openadsdk.multipro.b.b()) {
                a = d.a(f(context)).b("did", (String) null);
            }
        } catch (Exception unused) {
        }
        return a;
    }

    public static String b(Context context) {
        if (f1675d == null && !f1678g) {
            synchronized (j.class) {
                if (!f1678g) {
                    g(context);
                }
            }
        }
        return f1675d;
    }

    public static String c(Context context) {
        if (TextUtils.isEmpty(b) && !f1678g) {
            synchronized (j.class) {
                if (!f1678g) {
                    g(context);
                }
            }
        }
        return b;
    }

    public static String d(Context context) {
        if (TextUtils.isEmpty(f1676e) && !f1678g) {
            synchronized (j.class) {
                if (!f1678g) {
                    g(context);
                }
            }
        }
        return f1676e;
    }

    public static String e(Context context) {
        if (TextUtils.isEmpty(f1677f) && !f1678g) {
            synchronized (j.class) {
                if (!f1678g) {
                    g(context);
                }
            }
        }
        return f1677f;
    }

    private static Context f(Context context) {
        return context == null ? o.a() : context;
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_WIFI_STATE"})
    @SuppressLint({"HardwareIds"})
    private static void g(Context context) {
        Context f2;
        if (f1678g || (f2 = f(context)) == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                f1677f = Build.getSerial();
            } else {
                f1677f = Build.SERIAL;
            }
        } catch (Exception unused) {
        }
        b = a(f2, true);
        a = d.a(f2).b("did", (String) null);
        c = b();
        f1675d = String.valueOf(Build.TIME);
        f1676e = d.a(f2).b(UserBox.TYPE, (String) null);
        f1678g = true;
    }

    private static String b() {
        StringBuilder sb = new StringBuilder();
        try {
            if (com.bytedance.sdk.openadsdk.utils.u.e()) {
                sb.append("MIUI-");
            } else if (com.bytedance.sdk.openadsdk.utils.u.b()) {
                sb.append("FLYME-");
            } else {
                String n = com.bytedance.sdk.openadsdk.utils.u.n();
                if (com.bytedance.sdk.openadsdk.utils.u.a(n)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(n)) {
                    sb.append(n);
                    sb.append(PGTransHeader.CONNECTOR);
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str) || str.equals(a)) {
            return;
        }
        d.a(context).a("did", str);
        a = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:
        if (r2.length() >= 13) goto L33;
     */
    @android.annotation.SuppressLint({"TrulyRandom", "HardwareIds"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static synchronized java.lang.String a(android.content.Context r6, boolean r7) {
        /*
            java.lang.Class<com.bytedance.sdk.openadsdk.core.j> r0 = com.bytedance.sdk.openadsdk.core.j.class
            monitor-enter(r0)
            android.content.Context r6 = f(r6)     // Catch: java.lang.Throwable -> L8e
            r1 = 0
            if (r6 != 0) goto Lc
            monitor-exit(r0)
            return r1
        Lc:
            android.content.ContentResolver r2 = r6.getContentResolver()     // Catch: java.lang.Exception -> L17 java.lang.Throwable -> L8e
            java.lang.String r3 = "android_id"
            java.lang.String r2 = android.provider.Settings.Secure.getString(r2, r3)     // Catch: java.lang.Exception -> L17 java.lang.Throwable -> L8e
            goto L18
        L17:
            r2 = r1
        L18:
            r3 = 13
            if (r2 == 0) goto L2a
            java.lang.String r4 = "9774d56d682e549c"
            boolean r4 = r2.equals(r4)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            if (r4 != 0) goto L2a
            int r4 = r2.length()     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            if (r4 >= r3) goto L8c
        L2a:
            com.bytedance.sdk.openadsdk.core.d r6 = com.bytedance.sdk.openadsdk.core.d.a(r6)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.lang.String r4 = "openudid"
            java.lang.String r1 = r6.b(r4, r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            boolean r4 = a(r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            if (r4 != 0) goto L8b
            java.security.SecureRandom r1 = new java.security.SecureRandom     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            r1.<init>()     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.math.BigInteger r4 = new java.math.BigInteger     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            r5 = 64
            r4.<init>(r5, r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            r1 = 16
            java.lang.String r1 = r4.toString(r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            r4 = 0
            char r4 = r1.charAt(r4)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            r5 = 45
            if (r4 != r5) goto L5a
            r4 = 1
            java.lang.String r1 = r1.substring(r4)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
        L5a:
            int r4 = r1.length()     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            int r3 = r3 - r4
            if (r3 <= 0) goto L77
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            r4.<init>()     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
        L66:
            if (r3 <= 0) goto L70
            r5 = 70
            r4.append(r5)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            int r3 = r3 + (-1)
            goto L66
        L70:
            r4.append(r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
        L77:
            if (r7 == 0) goto L86
            java.lang.String r7 = "openudid.dat"
            java.lang.String r7 = a(r7, r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            boolean r3 = a(r7)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
            if (r3 == 0) goto L86
            r1 = r7
        L86:
            java.lang.String r7 = "openudid"
            r6.a(r7, r1)     // Catch: java.lang.Exception -> L8c java.lang.Throwable -> L8e
        L8b:
            r2 = r1
        L8c:
            monitor-exit(r0)
            return r2
        L8e:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.j.a(android.content.Context, boolean):java.lang.String");
    }

    private static String a(String str, String str2) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        byte[] bArr;
        int read;
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return str2;
        }
        String str3 = Environment.getExternalStorageDirectory().getPath() + "/Android/data/com.snssdk.api/cache";
        String str4 = str3 + "/" + str;
        FileLock fileLock = null;
        try {
            File file = new File(str3);
            if (file.exists() || file.mkdirs()) {
                File file2 = new File(str4);
                randomAccessFile2 = new RandomAccessFile(file2, "rwd");
                try {
                    fileLock = randomAccessFile2.getChannel().lock();
                    if (file2.isFile() && (read = randomAccessFile2.read((bArr = new byte[129]), 0, 129)) > 0 && read < 129) {
                        String str5 = new String(bArr, 0, read, "UTF-8");
                        if (a(str5)) {
                            if (fileLock != null) {
                                try {
                                    fileLock.release();
                                } catch (Exception unused) {
                                }
                            }
                            try {
                                randomAccessFile2.close();
                            } catch (Exception unused2) {
                            }
                            return str5;
                        }
                    }
                    byte[] bytes = str2.getBytes("UTF-8");
                    randomAccessFile2.setLength(0L);
                    randomAccessFile2.write(bytes);
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (Exception unused3) {
                        }
                    }
                    try {
                        randomAccessFile2.close();
                    } catch (Exception unused4) {
                    }
                    return str2;
                } catch (Exception unused5) {
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (Exception unused6) {
                        }
                    }
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (Exception unused7) {
                        }
                    }
                    return str2;
                } catch (Throwable th) {
                    randomAccessFile = randomAccessFile2;
                    th = th;
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (Exception unused8) {
                        }
                    }
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception unused9) {
                        }
                    }
                    throw th;
                }
            }
            return str2;
        } catch (Exception unused10) {
            randomAccessFile2 = null;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    private static boolean a(String str) {
        int length;
        if (str != null && (length = str.length()) >= 13 && length <= 128) {
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'f') && ((charAt < 'A' || charAt > 'F') && charAt != '-'))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static String a() {
        Locale locale;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = LocaleList.getDefault().get(0);
            } else {
                locale = Locale.getDefault();
            }
            String language = locale != null ? locale.getLanguage() : "";
            if (locale == null || !"zh".equals(language)) {
                return language;
            }
            String locale2 = locale.toString();
            if (locale.toString().length() >= 5) {
                locale2 = locale2.substring(0, 5);
            }
            return Locale.SIMPLIFIED_CHINESE.toString().equals(locale2) ? "zh" : "zh-Hant";
        } catch (Throwable unused) {
            return "";
        }
    }
}
