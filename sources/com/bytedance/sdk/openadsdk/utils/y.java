package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.reflect.Method;
/* compiled from: TTCrashHandler.java */
/* loaded from: classes.dex */
public class y implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler a = Thread.getDefaultUncaughtExceptionHandler();
    private String b;

    private y() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        b();
    }

    public static y a() {
        return new y();
    }

    private void b() {
        Context a = com.bytedance.sdk.openadsdk.core.o.a();
        if (a == null) {
            return;
        }
        try {
            File file = new File(a.getFilesDir(), "TTCache");
            file.mkdirs();
            this.b = file.getPath();
        } catch (Throwable unused) {
        }
    }

    private void c() {
        try {
            Method a = z.a("com.bytedance.sdk.openadsdk.TTC2Proxy", "a", Context.class);
            if (a != null) {
                a.invoke(null, com.bytedance.sdk.openadsdk.core.o.a());
            }
        } catch (Throwable unused) {
        }
        try {
            Method a2 = z.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "a", Context.class);
            if (a2 != null) {
                a2.invoke(null, com.bytedance.sdk.openadsdk.core.o.a());
            }
        } catch (Throwable unused2) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.g.f.a();
        } catch (Throwable unused3) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.webview.a.a.b();
        } catch (Throwable unused4) {
        }
        try {
            String b = com.bytedance.sdk.adnet.a.b(com.bytedance.sdk.openadsdk.core.o.a());
            if (TextUtils.isEmpty(b)) {
                return;
            }
            File file = new File(b);
            if (file.exists()) {
                i.c(file);
            }
        } catch (Throwable unused5) {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        boolean z = false;
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            if (stringWriter2 != null) {
                z = stringWriter2.contains(AdSlot.class.getPackage().getName());
            }
        } catch (Throwable unused) {
        }
        if (z) {
            a(thread, th);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.Properties] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(java.lang.Thread r19, java.lang.Throwable r20) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.y.a(java.lang.Thread, java.lang.Throwable):void");
    }
}
