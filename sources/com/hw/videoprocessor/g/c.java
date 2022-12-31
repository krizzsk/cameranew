package com.hw.videoprocessor.g;

import android.util.Log;
/* compiled from: CL.java */
/* loaded from: classes2.dex */
public class c {
    private static boolean a = false;
    private static int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CL.java */
    /* loaded from: classes2.dex */
    public static class a {
        String a;
        String b;
        int c;

        a() {
        }
    }

    private static String a(a aVar, String str, Object... objArr) {
        return "[" + aVar.a + "." + aVar.b + "():" + aVar.c + "]" + f(str, objArr);
    }

    private static String b(a aVar, String str, Object... objArr) {
        return "[" + aVar.b + "():" + aVar.c + "]" + f(str, objArr);
    }

    public static void c(String str, Object... objArr) {
        if (a) {
            a g2 = g(new Throwable().getStackTrace());
            Log.e(g2.a, b(g2, str, objArr));
        }
    }

    public static void d(Throwable th) {
        if (a) {
            Log.e(g(th.getStackTrace()).a, "", th);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (a) {
            Log.e(str, a(g(new Throwable().getStackTrace()), str2, objArr));
        }
    }

    private static String f(String str, Object... objArr) {
        return objArr.length == 0 ? str : String.format(str, objArr);
    }

    private static a g(StackTraceElement[] stackTraceElementArr) {
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

    public static void h(String str, Object... objArr) {
        if (a) {
            a g2 = g(new Throwable().getStackTrace());
            Log.i(g2.a, b(g2, str, objArr));
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (a) {
            Log.i(str, a(g(new Throwable().getStackTrace()), str2, objArr));
        }
    }

    public static void j(boolean z) {
        int i2 = b + 1;
        b = i2;
        if (i2 > 1) {
            Log.e("L", "setLogEnable() could only be called once");
        } else {
            a = z;
        }
    }

    public static void k(String str, Object... objArr) {
        if (a) {
            a g2 = g(new Throwable().getStackTrace());
            Log.w(g2.a, b(g2, str, objArr));
        }
    }

    public static void l(String str, String str2, Object... objArr) {
        if (a) {
            Log.w(str, a(g(new Throwable().getStackTrace()), str2, objArr));
        }
    }
}
