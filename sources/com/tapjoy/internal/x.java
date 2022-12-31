package com.tapjoy.internal;

import android.util.Log;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public final class x {
    public static void a(String str, String str2, Object... objArr) {
        a(6, str, str2, objArr);
    }

    public static void a(int i2, String str, @Nullable String str2, @Nullable Throwable th) {
        if (str2 != null) {
            Log.println(i2, str, str2);
        }
        if (th != null) {
            Log.println(i2, str, Log.getStackTraceString(th));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(int r10, java.lang.String r11, java.lang.String r12, java.lang.Object... r13) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.x.a(int, java.lang.String, java.lang.String, java.lang.Object[]):void");
    }
}
