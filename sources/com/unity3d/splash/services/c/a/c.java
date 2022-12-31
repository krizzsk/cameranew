package com.unity3d.splash.services.c.a;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.unity3d.splash.services.core.log.DeviceLog;
/* loaded from: classes3.dex */
public class c {
    public static void a(View view) {
        if (view == null || view.getParent() == null) {
            return;
        }
        try {
            ((ViewGroup) view.getParent()).removeView(view);
        } catch (Exception e2) {
            DeviceLog.g("Error while removing view from it's parent", e2);
        }
    }

    public static void b(View view, Drawable drawable) {
        String str = Build.VERSION.SDK_INT < 16 ? "setBackgroundDrawable" : "setBackground";
        try {
            View.class.getMethod(str, Drawable.class).invoke(view, drawable);
        } catch (Exception e2) {
            DeviceLog.g("Couldn't run" + str, e2);
        }
    }
}
