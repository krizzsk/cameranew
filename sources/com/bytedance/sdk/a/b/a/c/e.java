package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.m;
import com.bytedance.sdk.a.b.r;
import com.bytedance.sdk.a.b.s;
import java.util.List;
import java.util.regex.Pattern;
import us.pinguo.common.network.HttpRequest;
/* compiled from: HttpHeaders.java */
/* loaded from: classes.dex */
public final class e {
    private static final Pattern a = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    public static long a(aa aaVar) {
        return a(aaVar.f());
    }

    public static boolean b(aa aaVar) {
        if (aaVar.a().b().equals("HEAD")) {
            return false;
        }
        int c = aaVar.c();
        return (((c >= 100 && c < 200) || c == 204 || c == 304) && a(aaVar) == -1 && !"chunked".equalsIgnoreCase(aaVar.a("Transfer-Encoding"))) ? false : true;
    }

    public static long a(r rVar) {
        return a(rVar.a(HttpRequest.HEADER_CONTENT_LENGTH));
    }

    private static long a(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static void a(m mVar, s sVar, r rVar) {
        if (mVar == m.a) {
            return;
        }
        List<com.bytedance.sdk.a.b.l> a2 = com.bytedance.sdk.a.b.l.a(sVar, rVar);
        if (a2.isEmpty()) {
            return;
        }
        mVar.a(sVar, a2);
    }

    public static int b(String str, int i2) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    public static int a(String str, int i2, String str2) {
        while (i2 < str.length() && str2.indexOf(str.charAt(i2)) == -1) {
            i2++;
        }
        return i2;
    }

    public static int a(String str, int i2) {
        char charAt;
        while (i2 < str.length() && ((charAt = str.charAt(i2)) == ' ' || charAt == '\t')) {
            i2++;
        }
        return i2;
    }
}
