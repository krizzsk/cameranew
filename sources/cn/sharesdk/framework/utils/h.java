package cn.sharesdk.framework.utils;

import android.content.Context;
import com.mob.tools.utils.ResHelper;
/* compiled from: SizeHelper.java */
/* loaded from: classes.dex */
public class h {
    public static float a = 1.5f;
    public static int b = 540;
    private static Context c;

    public static void a(Context context) {
        Context context2 = c;
        if (context2 == null || context2 != context.getApplicationContext()) {
            c = context;
        }
    }

    public static int b(int i2) {
        return ResHelper.designToDevice(c, b, i2);
    }

    public static int a(int i2) {
        return ResHelper.designToDevice(c, a, i2);
    }
}
