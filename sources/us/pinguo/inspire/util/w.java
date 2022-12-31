package us.pinguo.inspire.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
/* compiled from: StatusUtil.java */
/* loaded from: classes9.dex */
public class w {
    @TargetApi(21)
    public static void a(Activity activity) {
        if (b()) {
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().getDecorView().setSystemUiVisibility(1280);
            activity.getWindow().setStatusBarColor(0);
        }
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 21;
    }
}
