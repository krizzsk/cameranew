package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public final class i {
    private static Boolean a;
    private static Boolean b;
    private static Boolean c;

    /* renamed from: d  reason: collision with root package name */
    private static Boolean f3696d;

    public static boolean a(Context context) {
        if (c == null) {
            PackageManager packageManager = context.getPackageManager();
            c = Boolean.valueOf(packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services"));
        }
        return c.booleanValue();
    }

    @TargetApi(21)
    public static boolean b(Context context) {
        return h(context);
    }

    public static boolean c() {
        return "user".equals(Build.TYPE);
    }

    @TargetApi(20)
    public static boolean d(Context context) {
        return e(context.getPackageManager());
    }

    @TargetApi(20)
    public static boolean e(PackageManager packageManager) {
        if (a == null) {
            a = Boolean.valueOf(o.g() && packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return a.booleanValue();
    }

    @TargetApi(26)
    public static boolean f(Context context) {
        if (d(context)) {
            if (o.j()) {
                return h(context) && !o.k();
            }
            return true;
        }
        return false;
    }

    public static boolean g(Context context) {
        if (f3696d == null) {
            f3696d = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return f3696d.booleanValue();
    }

    @TargetApi(21)
    private static boolean h(Context context) {
        if (b == null) {
            b = Boolean.valueOf(o.h() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return b.booleanValue();
    }
}
