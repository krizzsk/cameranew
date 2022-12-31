package us.pinguo.util;

import android.os.Build;
import android.provider.MediaStore;
/* compiled from: ApiHelper.java */
/* loaded from: classes6.dex */
public class c {
    public static final boolean a;
    public static final boolean b;
    public static final boolean c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f12470d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f12471e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f12472f;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f12473g;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f12474h;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f12475i;

    /* renamed from: j  reason: collision with root package name */
    public static final boolean f12476j;

    /* renamed from: k  reason: collision with root package name */
    public static final boolean f12477k;

    /* renamed from: l  reason: collision with root package name */
    public static final boolean f12478l;
    public static final boolean m;

    static {
        int i2 = Build.VERSION.SDK_INT;
        a = i2 >= 11;
        b = i2 >= 14;
        c = i2 >= 16;
        f12470d = i2 >= 17;
        f12471e = i2 >= 19;
        f12472f = i2 >= 21;
        f12473g = i2 >= 22;
        f12474h = i2 < 21;
        f12475i = i2 < 16;
        f12476j = i2 < 23;
        f12477k = i2 < 24;
        f12478l = i2 < 26;
        m = a(MediaStore.MediaColumns.class, "WIDTH");
    }

    private static boolean a(Class<?> cls, String str) {
        try {
            cls.getDeclaredField(str);
            return true;
        } catch (NoSuchFieldException unused) {
            return false;
        }
    }
}
