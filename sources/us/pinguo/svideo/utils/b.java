package us.pinguo.svideo.utils;

import android.util.Log;
/* compiled from: RL.java */
/* loaded from: classes6.dex */
public class b {
    public static boolean a = false;
    private static int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RL.java */
    /* loaded from: classes6.dex */
    public static class a {
        String a;
        String b;
        int c;

        a() {
        }
    }

    private static String a(a aVar, String str, Object... objArr) {
        return "[" + aVar.a + "." + aVar.b + "():" + aVar.c + "]" + g(str, objArr);
    }

    private static String b(a aVar, String str, Object... objArr) {
        return "[" + aVar.b + "():" + aVar.c + "]" + g(str, objArr);
    }

    public static void c(String str, Object... objArr) {
        if (a) {
            a h2 = h(new Throwable().getStackTrace());
            Log.d(h2.a, b(h2, str, objArr));
        }
    }

    public static void d(String str, Object... objArr) {
        if (a) {
            a h2 = h(new Throwable().getStackTrace());
            Log.e(h2.a, b(h2, str, objArr));
        }
    }

    public static void e(Throwable th) {
        if (a) {
            Log.e(h(th.getStackTrace()).a, "", th);
        }
    }

    public static void f(String str, String str2, Object... objArr) {
        if (a) {
            Log.e(str, a(h(new Throwable().getStackTrace()), str2, objArr));
        }
    }

    private static String g(String str, Object... objArr) {
        return objArr.length == 0 ? str : String.format(str, objArr);
    }

    private static a h(StackTraceElement[] stackTraceElementArr) {
        a aVar = new a();
        if (stackTraceElementArr.length > 1) {
            String fileName = stackTraceElementArr[1].getFileName();
            aVar.a = fileName;
            if (fileName.endsWith(".java")) {
                String str = aVar.a;
                aVar.a = str.substring(0, str.length() - 5);
            }
            aVar.b = stackTraceElementArr[1].getMethodName();
            aVar.c = stackTraceElementArr[1].getLineNumber();
        }
        return aVar;
    }

    public static void i(String str, Object... objArr) {
        if (a) {
            a h2 = h(new Throwable().getStackTrace());
            Log.i(h2.a, b(h2, str, objArr));
        }
    }

    public static void j(String str, String str2, Object... objArr) {
        if (a) {
            Log.i(str, a(h(new Throwable().getStackTrace()), str2, objArr));
        }
    }

    public static void k(boolean z) {
        int i2 = b + 1;
        b = i2;
        if (i2 > 1) {
            Log.e("L", "setLogEnable() could only be called once");
        } else {
            a = z;
        }
    }

    public static void l(String str, Object... objArr) {
        if (a) {
            a h2 = h(new Throwable().getStackTrace());
            Log.v(h2.a, b(h2, str, objArr));
        }
    }

    public static void m(String str, Object... objArr) {
        if (a) {
            a h2 = h(new Throwable().getStackTrace());
            Log.w(h2.a, b(h2, str, objArr));
        }
    }
}
