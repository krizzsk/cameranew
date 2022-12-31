package com.facebook.common.logging;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
/* loaded from: classes.dex */
public class FLogDefaultLoggingDelegate implements b {
    public static final FLogDefaultLoggingDelegate c = new FLogDefaultLoggingDelegate();
    private String a = "unknown";
    private int b = 5;

    private FLogDefaultLoggingDelegate() {
    }

    public static FLogDefaultLoggingDelegate getInstance() {
        return c;
    }

    private static String h(String str, Throwable th) {
        return str + '\n' + i(th);
    }

    private static String i(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    private String j(String str) {
        if (this.a != null) {
            return this.a + ":" + str;
        }
        return str;
    }

    private void k(int i2, String str, String str2) {
        Log.println(i2, j(str), str2);
    }

    private void l(int i2, String str, String str2, Throwable th) {
        Log.println(i2, j(str), h(str2, th));
    }

    @Override // com.facebook.common.logging.b
    public void a(String str, String str2) {
        k(6, str, str2);
    }

    @Override // com.facebook.common.logging.b
    public void b(String str, String str2, Throwable th) {
        l(3, str, str2, th);
    }

    @Override // com.facebook.common.logging.b
    public void c(String str, String str2, Throwable th) {
        l(6, str, str2, th);
    }

    @Override // com.facebook.common.logging.b
    public void d(String str, String str2) {
        k(3, str, str2);
    }

    @Override // com.facebook.common.logging.b
    public void e(String str, String str2) {
        k(6, str, str2);
    }

    @Override // com.facebook.common.logging.b
    public boolean f(int i2) {
        return this.b <= i2;
    }

    @Override // com.facebook.common.logging.b
    public void g(int i2) {
        this.b = i2;
    }

    @Override // com.facebook.common.logging.b
    public void v(String str, String str2) {
        k(2, str, str2);
    }

    @Override // com.facebook.common.logging.b
    public void w(String str, String str2) {
        k(5, str, str2);
    }

    @Override // com.facebook.common.logging.b
    public void d(String str, String str2, Throwable th) {
        l(5, str, str2, th);
    }

    @Override // com.facebook.common.logging.b
    public void e(String str, String str2, Throwable th) {
        l(6, str, str2, th);
    }
}
