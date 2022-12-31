package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.g.j;
import com.bytedance.sdk.openadsdk.utils.i;
import java.io.File;
import java.util.Set;
/* compiled from: TTDynamic.java */
/* loaded from: classes.dex */
public class a {
    public static void a() {
        b.a();
        d.a();
    }

    public static void b() {
        try {
            f.d();
            File f2 = b.f();
            if (f2 != null && f2.exists()) {
                if (f2.getParentFile() != null) {
                    i.c(f2.getParentFile());
                } else {
                    i.c(f2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void c() {
        d.a().c();
    }

    public static String d() {
        return c.c();
    }

    public static void e() {
        d.a().d();
    }

    public static k f() {
        return b.a().d();
    }

    public static boolean g() {
        return b.a().c();
    }

    public static void a(h hVar) {
        d.a().a(hVar);
    }

    public static void a(j jVar) {
        d.a().a(jVar, "");
    }

    public static void a(Set<String> set) {
        d.a().a(set);
    }

    public static l a(String str) {
        return d.a().a(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0052, code lost:
        if (r2.b().equals(r4) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.webkit.WebResourceResponse a(java.lang.String r4, com.bytedance.sdk.openadsdk.core.widget.webview.a.e.a r5) {
        /*
            boolean r0 = g()
            r1 = 0
            if (r0 == 0) goto L54
            com.bytedance.sdk.openadsdk.core.d.k r0 = f()
            java.util.List r0 = r0.d()
            java.util.Iterator r0 = r0.iterator()
        L13:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L54
            java.lang.Object r2 = r0.next()
            com.bytedance.sdk.openadsdk.core.d.k$a r2 = (com.bytedance.sdk.openadsdk.core.d.k.a) r2
            java.lang.String r3 = r2.a()
            if (r3 == 0) goto L13
            java.lang.String r3 = r2.a()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L13
            java.lang.String r4 = r2.a()
            java.lang.String r4 = com.bytedance.sdk.openadsdk.utils.h.a(r4)
            java.io.File r0 = new java.io.File
            java.io.File r3 = com.bytedance.sdk.openadsdk.core.widget.webview.a.b.f()
            r0.<init>(r3, r4)
            java.lang.String r4 = com.bytedance.sdk.openadsdk.utils.h.a(r0)
            java.lang.String r3 = r2.b()
            if (r3 == 0) goto L54
            java.lang.String r2 = r2.b()
            boolean r4 = r2.equals(r4)
            if (r4 != 0) goto L55
        L54:
            r0 = r1
        L55:
            if (r0 == 0) goto L72
            android.webkit.WebResourceResponse r4 = new android.webkit.WebResourceResponse     // Catch: java.lang.Throwable -> L6a
            java.lang.String r5 = r5.a()     // Catch: java.lang.Throwable -> L6a
            java.lang.String r2 = "utf-8"
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L6a
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L6a
            r4.<init>(r5, r2, r3)     // Catch: java.lang.Throwable -> L6a
            r1 = r4
            goto L72
        L6a:
            r4 = move-exception
            java.lang.String r5 = "TTDynamic"
            java.lang.String r0 = "get html WebResourceResponse error"
            com.bytedance.sdk.openadsdk.utils.o.c(r5, r0, r4)
        L72:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.widget.webview.a.a.a(java.lang.String, com.bytedance.sdk.openadsdk.core.widget.webview.a.e$a):android.webkit.WebResourceResponse");
    }

    public static l b(h hVar) {
        if (hVar == null || hVar.u() == null) {
            return null;
        }
        return d.a().a(hVar.u().b());
    }
}
