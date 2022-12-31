package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public final class y {
    public static boolean a = true;
    private static boolean b = true;
    private static SimpleDateFormat c = null;

    /* renamed from: d  reason: collision with root package name */
    private static int f8023d = 30720;

    /* renamed from: e  reason: collision with root package name */
    private static StringBuilder f8024e = null;

    /* renamed from: f  reason: collision with root package name */
    private static StringBuilder f8025f = null;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f8026g = false;

    /* renamed from: h  reason: collision with root package name */
    private static a f8027h = null;

    /* renamed from: i  reason: collision with root package name */
    private static String f8028i = null;

    /* renamed from: j  reason: collision with root package name */
    private static String f8029j = null;

    /* renamed from: k  reason: collision with root package name */
    private static Context f8030k = null;

    /* renamed from: l  reason: collision with root package name */
    private static String f8031l = null;
    private static boolean m = false;
    private static boolean n = false;
    private static ExecutorService o;
    private static int p;
    private static final Object q = new Object();

    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    public static class a {
        private boolean a;
        private File b;
        private String c;

        /* renamed from: d  reason: collision with root package name */
        private long f8032d;

        /* renamed from: e  reason: collision with root package name */
        private long f8033e = 30720;

        public a(String str) {
            if (str == null || str.equals("")) {
                return;
            }
            this.c = str;
            this.a = a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a() {
            try {
                File file = new File(this.c);
                this.b = file;
                if (file.exists() && !this.b.delete()) {
                    this.a = false;
                    return false;
                } else if (this.b.createNewFile()) {
                    return true;
                } else {
                    this.a = false;
                    return false;
                }
            } catch (Throwable th) {
                x.a(th);
                this.a = false;
                return false;
            }
        }

        public final boolean a(String str) {
            byte[] bytes;
            if (!this.a) {
                return false;
            }
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(this.b, true);
                try {
                    fileOutputStream2.write(str.getBytes("UTF-8"));
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    this.f8032d += bytes.length;
                    this.a = true;
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused) {
                    }
                    return true;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    try {
                        x.a(th);
                        this.a = false;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return false;
                    } catch (Throwable th2) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    public static class b implements Runnable {
        private /* synthetic */ String a;
        private /* synthetic */ String b;
        private /* synthetic */ String c;

        b(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            y.c(this.a, this.b, this.c);
        }
    }

    static {
        try {
            c = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable th) {
            x.b(th.getCause());
        }
    }

    public static synchronized void a(Context context) {
        synchronized (y.class) {
            if (m || context == null || !a) {
                return;
            }
            try {
                o = Executors.newSingleThreadExecutor();
                f8025f = new StringBuilder(0);
                f8024e = new StringBuilder(0);
                f8030k = context;
                com.tencent.bugly.crashreport.common.info.a a2 = com.tencent.bugly.crashreport.common.info.a.a(context);
                f8028i = a2.f7817d;
                a2.getClass();
                f8029j = "";
                f8031l = f8030k.getFilesDir().getPath() + "/buglylog_" + f8028i + "_" + f8029j + ".txt";
                p = Process.myPid();
            } catch (Throwable unused) {
            }
            m = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void c(String str, String str2, String str3) {
        synchronized (y.class) {
            if (b) {
                d(str, str2, str3);
            } else {
                e(str, str2, str3);
            }
        }
    }

    private static synchronized void d(String str, String str2, String str3) {
        synchronized (y.class) {
            String a2 = a(str, str2, str3, Process.myTid());
            synchronized (q) {
                f8025f.append(a2);
                if (f8025f.length() >= f8023d) {
                    StringBuilder sb = f8025f;
                    f8025f = sb.delete(0, sb.indexOf("\u0001\r\n") + 1);
                }
            }
        }
    }

    private static synchronized void e(String str, String str2, String str3) {
        synchronized (y.class) {
            String a2 = a(str, str2, str3, Process.myTid());
            synchronized (q) {
                try {
                    f8025f.append(a2);
                } catch (Throwable unused) {
                }
                if (f8025f.length() <= f8023d) {
                    return;
                }
                if (f8026g) {
                    return;
                }
                f8026g = true;
                a aVar = f8027h;
                if (aVar != null) {
                    if (aVar.b == null || f8027h.b.length() + f8025f.length() > f8027h.f8033e) {
                        f8027h.a();
                    }
                } else {
                    f8027h = new a(f8031l);
                }
                if (f8027h.a(f8025f.toString())) {
                    f8025f.setLength(0);
                    f8026g = false;
                }
            }
        }
    }

    private static byte[] b() {
        if (a) {
            StringBuilder sb = new StringBuilder();
            synchronized (q) {
                a aVar = f8027h;
                if (aVar != null && aVar.a && f8027h.b != null && f8027h.b.length() > 0) {
                    sb.append(z.a(f8027h.b, 30720, true));
                }
                StringBuilder sb2 = f8025f;
                if (sb2 != null && sb2.length() > 0) {
                    sb.append(f8025f.toString());
                }
            }
            return z.a((File) null, sb.toString(), "BuglyLog.txt");
        }
        return null;
    }

    public static void a(int i2) {
        synchronized (q) {
            f8023d = i2;
            if (i2 < 0) {
                f8023d = 0;
            } else if (i2 > 30720) {
                f8023d = 30720;
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (th == null) {
            return;
        }
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        a(str, str2, message + '\n' + z.b(th));
    }

    public static synchronized void a(String str, String str2, String str3) {
        synchronized (y.class) {
            if (m && a) {
                try {
                    o.execute(new b(str, str2, str3));
                } catch (Exception e2) {
                    x.b(e2);
                }
            }
        }
    }

    private static String a(String str, String str2, String str3, long j2) {
        String date;
        f8024e.setLength(0);
        if (str3.length() > 30720) {
            str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
        }
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat = c;
        if (simpleDateFormat != null) {
            date = simpleDateFormat.format(date2);
        } else {
            date = date2.toString();
        }
        StringBuilder sb = f8024e;
        sb.append(date);
        sb.append(" ");
        sb.append(p);
        sb.append(" ");
        sb.append(j2);
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        sb.append(": ");
        sb.append(str3);
        sb.append("\u0001\r\n");
        return f8024e.toString();
    }

    public static byte[] a() {
        if (b) {
            if (a) {
                return z.a((File) null, f8025f.toString(), "BuglyLog.txt");
            }
            return null;
        }
        return b();
    }
}
