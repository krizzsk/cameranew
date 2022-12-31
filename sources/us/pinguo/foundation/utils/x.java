package us.pinguo.foundation.utils;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
/* compiled from: NotchUtil.kt */
/* loaded from: classes4.dex */
public final class x {
    public static final x a = new x();

    private x() {
    }

    private final void e(int i2, Window window) {
        int i3;
        View decorView = window.getDecorView();
        kotlin.jvm.internal.s.g(decorView, "window.decorView");
        if (i2 != -1 && i2 != 1) {
            window.clearFlags(1024);
            if (Build.VERSION.SDK_INT > 16) {
                decorView.setSystemUiVisibility(0);
                return;
            }
            return;
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 > 16) {
            if (i2 == -1) {
                i3 = 1026;
                if (i4 > 19) {
                    i3 = 5122;
                }
            } else {
                i3 = 1024;
            }
            decorView.setSystemUiVisibility(i3);
        }
        window.addFlags(1024);
    }

    public final int a(Activity activity) {
        kotlin.jvm.internal.s.h(activity, "activity");
        if (b(activity)) {
            return us.pinguo.foundation.t.b.a.k();
        }
        return 0;
    }

    public final boolean b(Activity activity) {
        kotlin.jvm.internal.s.h(activity, "activity");
        boolean z = o.c(activity) && (us.pinguo.foundation.t.b.a.f().y == us.pinguo.foundation.t.b.a.d(activity) || us.pinguo.foundation.t.b.a.i() == us.pinguo.foundation.t.b.a.d(activity));
        us.pinguo.common.log.a.k(kotlin.jvm.internal.s.q("NotchUtil.isNotchDisplay.activity:", Boolean.valueOf(z)), new Object[0]);
        return z;
    }

    public final void c(int i2, Activity activity) {
        kotlin.jvm.internal.s.h(activity, "activity");
        Window window = activity.getWindow();
        kotlin.jvm.internal.s.g(window, "window");
        d(i2, window);
    }

    public final void d(int i2, Window window) {
        kotlin.jvm.internal.s.h(window, "window");
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (i2 != -1 && i2 != 1) {
                attributes.layoutInDisplayCutoutMode = 2;
            } else {
                attributes.layoutInDisplayCutoutMode = 1;
            }
            window.setAttributes(attributes);
            e(i2, window);
        } else if (o.c(window.getContext())) {
            e(i2, window);
        }
    }
}
