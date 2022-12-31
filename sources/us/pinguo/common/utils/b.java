package us.pinguo.common.utils;

import android.os.Build;
/* compiled from: ApiHelper.java */
/* loaded from: classes4.dex */
public class b {
    public static final boolean a;
    public static final boolean b;

    static {
        int i2 = Build.VERSION.SDK_INT;
        a = i2 >= 11;
        b = i2 >= 16;
    }
}
