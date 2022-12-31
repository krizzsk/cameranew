package com.tencent.bugly.crashreport.crash.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import androidx.room.RoomDatabase;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.File;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public class NativeCrashHandler implements com.tencent.bugly.crashreport.a {
    private static NativeCrashHandler a = null;
    private static int b = 1;
    private static boolean m = false;
    private static boolean n = false;
    private static boolean p = true;
    private final Context c;

    /* renamed from: d  reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.info.a f7907d;

    /* renamed from: e  reason: collision with root package name */
    private final w f7908e;

    /* renamed from: f  reason: collision with root package name */
    private NativeExceptionHandler f7909f;

    /* renamed from: g  reason: collision with root package name */
    private String f7910g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f7911h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f7912i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f7913j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f7914k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f7915l = false;
    private com.tencent.bugly.crashreport.crash.b o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    public final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!z.a(NativeCrashHandler.this.c, "native_record_lock", 10000L)) {
                x.a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
                return;
            }
            if (!NativeCrashHandler.p) {
                NativeCrashHandler.this.a(RoomDatabase.MAX_BIND_PARAMETER_CNT, "false");
            }
            CrashDetailBean a = b.a(NativeCrashHandler.this.c, NativeCrashHandler.this.f7910g, NativeCrashHandler.this.f7909f);
            if (a != null) {
                x.a("[Native] Get crash from native record.", new Object[0]);
                if (!NativeCrashHandler.this.o.a(a)) {
                    NativeCrashHandler.this.o.a(a, 3000L, false);
                }
                b.a(false, NativeCrashHandler.this.f7910g);
            }
            NativeCrashHandler.this.a();
            z.b(NativeCrashHandler.this.c, "native_record_lock");
        }
    }

    @SuppressLint({"SdCardPath"})
    private NativeCrashHandler(Context context, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.crash.b bVar, w wVar, boolean z, String str) {
        this.c = z.a(context);
        try {
            if (z.a(str)) {
                str = context.getDir("bugly", 0).getAbsolutePath();
            }
        } catch (Throwable unused) {
            str = "/data/data/" + com.tencent.bugly.crashreport.common.info.a.a(context).c + "/app_bugly";
        }
        this.o = bVar;
        this.f7910g = str;
        this.f7907d = aVar;
        this.f7908e = wVar;
        this.f7911h = z;
        this.f7909f = new com.tencent.bugly.crashreport.crash.jni.a(context, aVar, bVar, com.tencent.bugly.crashreport.common.strategy.a.a());
    }

    public static synchronized NativeCrashHandler getInstance(Context context, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.crash.b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar2, w wVar, boolean z, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            if (a == null) {
                a = new NativeCrashHandler(context, aVar, bVar, wVar, z, str);
            }
            nativeCrashHandler = a;
        }
        return nativeCrashHandler;
    }

    public static boolean isShouldHandleInJava() {
        return p;
    }

    public static void setShouldHandleInJava(boolean z) {
        p = z;
        NativeCrashHandler nativeCrashHandler = a;
        if (nativeCrashHandler != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(z);
            nativeCrashHandler.a(RoomDatabase.MAX_BIND_PARAMETER_CNT, sb.toString());
        }
    }

    public boolean appendLogToNative(String str, String str2, String str3) {
        if ((this.f7912i || this.f7913j) && m && str != null && str2 != null && str3 != null) {
            try {
                if (this.f7913j) {
                    return appendNativeLog(str, str2, str3);
                }
                Boolean bool = (Boolean) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", null, new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                m = false;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    protected native boolean appendNativeLog(String str, String str2, String str3);

    protected native boolean appendWholeNativeLog(String str);

    public void checkUploadRecordCrash() {
        this.f7908e.a(new a());
    }

    public void dumpAnrNativeStack() {
        a(19, "1");
    }

    public void enableCatchAnrTrace() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 30 || i2 < 23) {
            return;
        }
        b |= 2;
    }

    public boolean filterSigabrtSysLog() {
        return a(998, "true");
    }

    public synchronized String getDumpFilePath() {
        return this.f7910g;
    }

    public String getLogFromNative() {
        if ((this.f7912i || this.f7913j) && m) {
            try {
                if (this.f7913j) {
                    return getNativeLog();
                }
                return (String) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null, null);
            } catch (UnsatisfiedLinkError unused) {
                m = false;
                return null;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return null;
            }
        }
        return null;
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.f7909f;
    }

    protected native String getNativeKeyValueList();

    protected native String getNativeLog();

    public boolean isEnableCatchAnrTrace() {
        return (b & 2) == 2;
    }

    public synchronized boolean isUserOpened() {
        return this.f7915l;
    }

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        if (strategyBean != null) {
            boolean z = strategyBean.f7827e;
            if (z != this.f7914k) {
                x.d("server native changed to %b", Boolean.valueOf(z));
            }
        }
        boolean z2 = com.tencent.bugly.crashreport.common.strategy.a.a().c().f7827e && this.f7915l;
        if (z2 != this.f7914k) {
            x.a("native changed to %b", Boolean.valueOf(z2));
            b(z2);
        }
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if ((this.f7912i || this.f7913j) && m && str != null && str2 != null) {
            try {
                if (this.f7913j) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", null, new Class[]{String.class, String.class}, new Object[]{str, str2});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                m = false;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    protected native boolean putNativeKeyValue(String str, String str2);

    protected native String regist(String str, boolean z, int i2);

    public void removeEmptyNativeRecordFiles() {
        b.c(this.f7910g);
    }

    protected native String removeNativeKeyValue(String str);

    public synchronized void setDumpFilePath(String str) {
        this.f7910g = str;
    }

    public boolean setNativeAppChannel(String str) {
        return a(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return a(13, str);
    }

    public boolean setNativeAppVersion(String str) {
        return a(10, str);
    }

    protected native void setNativeInfo(int i2, String str);

    @Override // com.tencent.bugly.crashreport.a
    public boolean setNativeIsAppForeground(boolean z) {
        return a(14, z ? "true" : "false");
    }

    public boolean setNativeLaunchTime(long j2) {
        try {
            return a(15, String.valueOf(j2));
        } catch (NumberFormatException e2) {
            if (x.a(e2)) {
                return false;
            }
            e2.printStackTrace();
            return false;
        }
    }

    public boolean setNativeUserId(String str) {
        return a(11, str);
    }

    public synchronized void setUserOpened(boolean z) {
        c(z);
        boolean isUserOpened = isUserOpened();
        com.tencent.bugly.crashreport.common.strategy.a a2 = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (a2 != null) {
            isUserOpened = isUserOpened && a2.c().f7827e;
        }
        if (isUserOpened != this.f7914k) {
            x.a("native changed to %b", Boolean.valueOf(isUserOpened));
            b(isUserOpened);
        }
    }

    public synchronized void startNativeMonitor() {
        if (!this.f7913j && !this.f7912i) {
            String str = "Bugly";
            boolean z = !z.a(this.f7907d.n);
            com.tencent.bugly.crashreport.common.info.a aVar = this.f7907d;
            String str2 = aVar.n;
            if (z) {
                str = str2;
            } else {
                aVar.getClass();
            }
            boolean a2 = a(str, z);
            this.f7913j = a2;
            if (a2 || this.f7912i) {
                a(this.f7911h);
                if (m) {
                    setNativeAppVersion(this.f7907d.f7824k);
                    setNativeAppChannel(this.f7907d.m);
                    setNativeAppPackage(this.f7907d.c);
                    setNativeUserId(this.f7907d.g());
                    setNativeIsAppForeground(this.f7907d.a());
                    setNativeLaunchTime(this.f7907d.a);
                }
                return;
            }
            return;
        }
        a(this.f7911h);
    }

    protected native void testCrash();

    public void testNativeCrash() {
        if (!this.f7913j) {
            x.d("[Native] Bugly SO file has not been load.", new Object[0]);
        } else {
            testCrash();
        }
    }

    protected native String unregist();

    private synchronized void c() {
        if (!this.f7914k) {
            x.d("[Native] Native crash report has already unregistered.", new Object[0]);
        } else if (unregist() != null) {
            x.a("[Native] Successfully closed native crash report.", new Object[0]);
            this.f7914k = false;
        } else {
            z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{Boolean.FALSE});
            this.f7914k = false;
            x.a("[Native] Successfully closed native crash report.", new Object[0]);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:15|(1:17)(16:42|(1:44)|19|20|(1:22)|23|(1:25)|27|(1:29)(1:40)|30|(1:32)(1:39)|33|(1:35)|36|37|38)|18|19|20|(0)|23|(0)|27|(0)(0)|30|(0)(0)|33|(0)|36|37|38) */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0080 A[Catch: all -> 0x008e, TryCatch #2 {all -> 0x008e, blocks: (B:22:0x0076, B:24:0x0080, B:25:0x0082, B:27:0x008c), top: B:70:0x0076 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008c A[Catch: all -> 0x008e, TRY_LEAVE, TryCatch #2 {all -> 0x008e, blocks: (B:22:0x0076, B:24:0x0080, B:25:0x0082, B:27:0x008c), top: B:70:0x0076 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0092 A[Catch: all -> 0x00ed, TryCatch #4 {, blocks: (B:4:0x0003, B:6:0x0008, B:9:0x0011, B:62:0x01af, B:43:0x00f6, B:12:0x0017, B:14:0x0021, B:16:0x0053, B:17:0x005d, B:28:0x008e, B:30:0x0092, B:32:0x00a1, B:34:0x00a5, B:36:0x00b4, B:38:0x00c8, B:39:0x00dc, B:35:0x00ad, B:31:0x009a, B:18:0x0065, B:20:0x006b), top: B:74:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009a A[Catch: all -> 0x00ed, TryCatch #4 {, blocks: (B:4:0x0003, B:6:0x0008, B:9:0x0011, B:62:0x01af, B:43:0x00f6, B:12:0x0017, B:14:0x0021, B:16:0x0053, B:17:0x005d, B:28:0x008e, B:30:0x0092, B:32:0x00a1, B:34:0x00a5, B:36:0x00b4, B:38:0x00c8, B:39:0x00dc, B:35:0x00ad, B:31:0x009a, B:18:0x0065, B:20:0x006b), top: B:74:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a5 A[Catch: all -> 0x00ed, TryCatch #4 {, blocks: (B:4:0x0003, B:6:0x0008, B:9:0x0011, B:62:0x01af, B:43:0x00f6, B:12:0x0017, B:14:0x0021, B:16:0x0053, B:17:0x005d, B:28:0x008e, B:30:0x0092, B:32:0x00a1, B:34:0x00a5, B:36:0x00b4, B:38:0x00c8, B:39:0x00dc, B:35:0x00ad, B:31:0x009a, B:18:0x0065, B:20:0x006b), top: B:74:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ad A[Catch: all -> 0x00ed, TryCatch #4 {, blocks: (B:4:0x0003, B:6:0x0008, B:9:0x0011, B:62:0x01af, B:43:0x00f6, B:12:0x0017, B:14:0x0021, B:16:0x0053, B:17:0x005d, B:28:0x008e, B:30:0x0092, B:32:0x00a1, B:34:0x00a5, B:36:0x00b4, B:38:0x00c8, B:39:0x00dc, B:35:0x00ad, B:31:0x009a, B:18:0x0065, B:20:0x006b), top: B:74:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c8 A[Catch: all -> 0x00ed, TryCatch #4 {, blocks: (B:4:0x0003, B:6:0x0008, B:9:0x0011, B:62:0x01af, B:43:0x00f6, B:12:0x0017, B:14:0x0021, B:16:0x0053, B:17:0x005d, B:28:0x008e, B:30:0x0092, B:32:0x00a1, B:34:0x00a5, B:36:0x00b4, B:38:0x00c8, B:39:0x00dc, B:35:0x00ad, B:31:0x009a, B:18:0x0065, B:20:0x006b), top: B:74:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized void a(boolean r13) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.a(boolean):void");
    }

    private synchronized void b(boolean z) {
        if (z) {
            startNativeMonitor();
        } else {
            c();
        }
    }

    public static synchronized NativeCrashHandler getInstance() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            nativeCrashHandler = a;
        }
        return nativeCrashHandler;
    }

    public void testNativeCrash(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        sb.append(z);
        a(16, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z2);
        a(17, sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(z3);
        a(18, sb3.toString());
        testNativeCrash();
    }

    private synchronized void c(boolean z) {
        if (this.f7915l != z) {
            x.a("user change native %b", Boolean.valueOf(z));
            this.f7915l = z;
        }
    }

    private static boolean a(String str, boolean z) {
        boolean z2;
        try {
            x.a("[Native] Trying to load so: %s", str);
            if (z) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
        } catch (Throwable th) {
            th = th;
            z2 = false;
        }
        try {
            x.a("[Native] Successfully loaded SO: %s", str);
            return true;
        } catch (Throwable th2) {
            th = th2;
            z2 = true;
            x.d(th.getMessage(), new Object[0]);
            x.d("[Native] Failed to load so: %s", str);
            return z2;
        }
    }

    protected final void a() {
        long b2 = z.b() - c.f7875g;
        long b3 = z.b() + AdvTimeUtils.MILLIS_OF_A_DAY;
        File file = new File(this.f7910g);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    int i2 = 0;
                    int i3 = 0;
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (lastModified < b2 || lastModified >= b3) {
                            x.a("[Native] Delete record file: %s", file2.getAbsolutePath());
                            i2++;
                            if (file2.delete()) {
                                i3++;
                            }
                        }
                    }
                    x.c("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i2), Integer.valueOf(i3));
                }
            } catch (Throwable th) {
                x.a(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i2, String str) {
        if (this.f7913j && n) {
            try {
                setNativeInfo(i2, str);
                return true;
            } catch (UnsatisfiedLinkError unused) {
                n = false;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }
}
