package us.pinguo.foundation.utils;

import android.os.Build;
/* compiled from: VersionExtension.kt */
/* loaded from: classes4.dex */
public final class p0 {
    public static final boolean a(Object obj) {
        kotlin.jvm.internal.s.h(obj, "<this>");
        return Build.VERSION.SDK_INT >= 29;
    }

    public static final boolean b(Object obj) {
        kotlin.jvm.internal.s.h(obj, "<this>");
        return Build.VERSION.SDK_INT >= 30;
    }

    public static final boolean c() {
        return Build.VERSION.SDK_INT < 28;
    }
}
