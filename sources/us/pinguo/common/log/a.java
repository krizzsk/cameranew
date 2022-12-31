package us.pinguo.common.log;

import android.util.Log;
/* compiled from: L.java */
/* loaded from: classes4.dex */
public class a {
    public static boolean a = false;
    private static int b;
    private static c c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: L.java */
    /* renamed from: us.pinguo.common.log.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0381a {
        String a;
        String b;
        int c;

        C0381a() {
        }
    }

    private static String a(C0381a c0381a, String str, Object... objArr) {
        return "[" + c0381a.a + "." + c0381a.b + "():" + c0381a.c + "]" + h(str, objArr);
    }

    private static String b(C0381a c0381a, String str, Object... objArr) {
        return "[" + c0381a.b + "():" + c0381a.c + "]" + h(str, objArr);
    }

    public static void c(String str, Object... objArr) {
        if (a) {
            C0381a i2 = i(new Throwable().getStackTrace());
            String b2 = b(i2, str, objArr);
            j(new b(i2.a, "DEBUG  ", b2));
            Log.d(i2.a, b2);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (a) {
            String a2 = a(i(new Throwable().getStackTrace()), str2, objArr);
            j(new b(str, "DEBUG  ", a2));
            Log.d(str, a2);
        }
    }

    public static void e(String str, Object... objArr) {
        if (a) {
            C0381a i2 = i(new Throwable().getStackTrace());
            String b2 = b(i2, str, objArr);
            j(new b(i2.a, "ERROR  ", b2));
            Log.e(i2.a, b2);
        }
    }

    public static void f(Throwable th) {
        if (a) {
            C0381a i2 = i(th.getStackTrace());
            j(new b(i2.a, "ERROR  ", th));
            Log.e(i2.a, "", th);
        }
    }

    public static void g(String str, String str2, Object... objArr) {
        if (a) {
            String a2 = a(i(new Throwable().getStackTrace()), str2, objArr);
            j(new b(str, "ERROR  ", a2));
            Log.e(str, a2);
        }
    }

    private static String h(String str, Object... objArr) {
        return objArr.length == 0 ? str : String.format(str, objArr);
    }

    private static C0381a i(StackTraceElement[] stackTraceElementArr) {
        C0381a c0381a = new C0381a();
        if (stackTraceElementArr.length > 1) {
            String fileName = stackTraceElementArr[1].getFileName();
            c0381a.a = fileName;
            if (fileName != null && fileName.endsWith(".java")) {
                String str = c0381a.a;
                c0381a.a = str.substring(0, str.length() - 5);
            }
            c0381a.b = stackTraceElementArr[1].getMethodName();
            c0381a.c = stackTraceElementArr[1].getLineNumber();
        }
        return c0381a;
    }

    private static void j(b bVar) {
        int i2;
        e.b(bVar);
        if (c == null || bVar == null) {
            return;
        }
        String a2 = bVar.a();
        a2.hashCode();
        char c2 = 65535;
        switch (a2.hashCode()) {
            case -2035293837:
                if (a2.equals("DEBUG  ")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1631602510:
                if (a2.equals("INFO   ")) {
                    c2 = 1;
                    break;
                }
                break;
            case -761003032:
                if (a2.equals("ERROR  ")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1842387930:
                if (a2.equals("WARN   ")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                i2 = 3;
                break;
            case 1:
                i2 = 4;
                break;
            case 2:
                i2 = 6;
                break;
            case 3:
                i2 = 5;
                break;
            default:
                i2 = 2;
                break;
        }
        c.a(bVar.d(), bVar.c(), i2, bVar.b());
    }

    public static void k(String str, Object... objArr) {
        if (a) {
            C0381a i2 = i(new Throwable().getStackTrace());
            String b2 = b(i2, str, objArr);
            j(new b(i2.a, "INFO   ", b2));
            Log.i(i2.a, b2);
        }
    }

    public static boolean l() {
        return a;
    }

    public static void m(String str, String str2, Object... objArr) {
        if (a) {
            String a2 = a(i(new Throwable().getStackTrace()), str2, objArr);
            j(new b(str, "INFO   ", a2));
            Log.i(str, a2);
        }
    }

    public static void n(boolean z) {
        int i2 = b + 1;
        b = i2;
        if (i2 > 1) {
            Log.e("L", "setLogEnable() could only be called once");
        } else {
            a = z;
        }
    }

    public static void o(String str, String str2) {
        if (a) {
            e.c(null);
            e.d(str, str2);
        }
    }

    public static void p() {
        if (a) {
            e.e();
        }
    }

    public static void q(String str, Object... objArr) {
        if (a) {
            C0381a i2 = i(new Throwable().getStackTrace());
            String b2 = b(i2, str, objArr);
            j(new b(i2.a, "VERBOSE", b2));
            Log.v(i2.a, b2);
        }
    }

    public static void r(String str, String str2, Object... objArr) {
        if (a) {
            String a2 = a(i(new Throwable().getStackTrace()), str2, objArr);
            j(new b(str, "VERBOSE", a2));
            Log.v(str, a2);
        }
    }

    public static void s(String str, Object... objArr) {
        if (a) {
            C0381a i2 = i(new Throwable().getStackTrace());
            String b2 = b(i2, str, objArr);
            j(new b(i2.a, "WARN   ", b2));
            Log.w(i2.a, b2);
        }
    }

    public static void t(Throwable th) {
        if (a) {
            C0381a i2 = i(th.getStackTrace());
            j(new b(i2.a, "WARN   ", th));
            Log.v(i2.a, "", th);
        }
    }

    public static void u(String str, String str2, Object... objArr) {
        if (a) {
            String a2 = a(i(new Throwable().getStackTrace()), str2, objArr);
            j(new b(str, "WARN   ", a2));
            Log.w(str, a2);
        }
    }
}
