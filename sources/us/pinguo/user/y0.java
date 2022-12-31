package us.pinguo.user;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileLock;
import java.util.Properties;
/* compiled from: UserHelper.java */
/* loaded from: classes6.dex */
public class y0 {
    private static Object a = new Object();

    /* compiled from: UserHelper.java */
    /* loaded from: classes6.dex */
    public static class b {
        private long a;
        private long b;

        public long a() {
            return this.a;
        }

        public long b() {
            return this.b;
        }

        private b(String str, String str2) {
            try {
                this.a = Long.parseLong(str);
            } catch (Exception unused) {
                this.a = -1L;
            }
            try {
                this.b = Long.parseLong(str2);
            } catch (Exception unused2) {
                this.b = -1L;
            }
            long j2 = this.b;
            if (j2 < 0 || j2 > 5184000) {
                this.b = 2592000L;
            }
        }
    }

    /* compiled from: UserHelper.java */
    /* loaded from: classes6.dex */
    public static class c {
        public int a;
        public long b;

        public c(String str, String str2) {
            this.a = Integer.parseInt(str);
            this.b = Long.parseLong(str2);
        }

        public boolean a() {
            return this.a == 1;
        }

        public boolean b() {
            return this.a == 4;
        }

        public boolean c() {
            return this.a == 3;
        }

        public boolean d() {
            int i2 = this.a;
            return i2 == 1 || i2 == 3 || i2 == 4;
        }
    }

    private y0() {
    }

    private static void a(InputStream inputStream) {
        if (inputStream == null) {
            return;
        }
        try {
            inputStream.close();
        } catch (IOException unused) {
        }
    }

    private static void b(OutputStream outputStream) {
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.close();
        } catch (IOException unused) {
        }
    }

    public static String c(Context context) {
        String d2;
        synchronized (y0.class) {
            d2 = d(context, "user_info_gson");
        }
        return d2;
    }

    public static String d(Context context, String str) {
        return e(context).getProperty(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r7v9 */
    private static Properties e(Context context) {
        Properties properties;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream2;
        synchronized (a) {
            properties = new Properties();
            FileLock fileLock = null;
            r3 = null;
            FileInputStream fileInputStream3 = null;
            r3 = null;
            fileLock = null;
            FileLock fileLock2 = null;
            try {
                fileOutputStream = context.openFileOutput("userinfo_lock.txt", 0);
                try {
                    FileLock lock = fileOutputStream.getChannel().lock();
                    try {
                        fileInputStream3 = context.openFileInput("userinfo.txt");
                        properties.load(fileInputStream3);
                        i(lock);
                        b(fileOutputStream);
                        a(fileInputStream3);
                    } catch (Exception unused) {
                        fileInputStream2 = fileInputStream3;
                        fileLock2 = lock;
                        i(fileLock2);
                        b(fileOutputStream);
                        a(fileInputStream2);
                        us.pinguo.common.log.a.k("user->prop->" + properties.toString(), new Object[0]);
                        return properties;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream3;
                        fileLock = lock;
                        i(fileLock);
                        b(fileOutputStream);
                        a(fileInputStream);
                        throw th;
                    }
                } catch (Exception unused2) {
                    fileInputStream2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                }
            } catch (Exception unused3) {
                fileInputStream2 = null;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                fileOutputStream = null;
            }
            us.pinguo.common.log.a.k("user->prop->" + properties.toString(), new Object[0]);
        }
        return properties;
    }

    public static b f(Context context) {
        Properties e2 = e(context);
        return new b(e2.getProperty("last_login_time", "0"), e2.getProperty("token_expire", "2592000"));
    }

    public static c g(Context context) {
        try {
            Properties e2 = e(context);
            return new c(e2.getProperty("is_vip_member", "0"), e2.getProperty("expire_time", "0"));
        } catch (Exception unused) {
            return new c("0", "0");
        }
    }

    public static void h(Context context, String str) {
        synchronized (y0.class) {
            us.pinguo.common.log.a.k("user->savevalue->" + str, new Object[0]);
            j(context, "user_info_gson", str);
        }
    }

    private static void i(FileLock fileLock) {
        if (fileLock == null) {
            return;
        }
        try {
            fileLock.release();
        } catch (IOException unused) {
        }
    }

    public static void j(Context context, String str, String str2) {
        Properties e2 = e(context);
        e2.setProperty(str, str2);
        k(context, e2);
    }

    private static void k(Context context, Properties properties) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        FileLock lock;
        us.pinguo.common.log.a.k("user->saveprop->threadid:" + Thread.currentThread().getId(), new Object[0]);
        synchronized (a) {
            FileLock fileLock = null;
            r2 = null;
            FileOutputStream fileOutputStream3 = null;
            fileLock = null;
            fileLock = null;
            fileLock = null;
            try {
                fileOutputStream2 = context.openFileOutput("userinfo_lock.txt", 0);
                try {
                    lock = fileOutputStream2.getChannel().lock();
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                fileOutputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                fileOutputStream2 = null;
            }
            try {
                fileOutputStream3 = context.openFileOutput("userinfo.txt", 0);
                properties.store(fileOutputStream3, "saveFreePuzzlePic prop " + System.currentTimeMillis());
                us.pinguo.common.log.a.k("user->saveprop->" + properties.toString(), new Object[0]);
                i(lock);
                b(fileOutputStream2);
                b(fileOutputStream3);
            } catch (Exception e4) {
                e = e4;
                fileOutputStream = fileOutputStream3;
                fileLock = lock;
                try {
                    us.pinguo.common.log.a.k("user->saveExceptioon>" + e.toString(), new Object[0]);
                    us.pinguo.common.log.a.e("UserHelper", e.toString());
                    us.pinguo.foundation.e.e(e);
                    e.printStackTrace();
                    i(fileLock);
                    b(fileOutputStream2);
                    b(fileOutputStream);
                } catch (Throwable th3) {
                    th = th3;
                    i(fileLock);
                    b(fileOutputStream2);
                    b(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = fileOutputStream3;
                fileLock = lock;
                i(fileLock);
                b(fileOutputStream2);
                b(fileOutputStream);
                throw th;
            }
        }
    }

    public static void l(Context context, long j2, long j3) {
        Properties e2 = e(context);
        e2.setProperty("last_login_time", String.valueOf(j2));
        e2.setProperty("token_expire", String.valueOf(j3));
        k(context, e2);
    }

    public static void m(Context context, int i2) {
        Properties e2 = e(context);
        e2.setProperty("is_vip_member", String.valueOf(i2));
        k(context, e2);
    }

    public static void n(Context context, long j2) {
        Properties e2 = e(context);
        e2.setProperty("expire_time", String.valueOf(j2));
        k(context, e2);
    }

    public static void o(Context context, int i2, long j2) {
        Properties e2 = e(context);
        e2.setProperty("is_vip_member", String.valueOf(i2));
        e2.setProperty("expire_time", String.valueOf(j2));
        k(context, e2);
    }
}
