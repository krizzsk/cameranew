package com.pinguo.album.common;

import android.os.Build;
/* compiled from: AlbumApiHelper.java */
/* loaded from: classes3.dex */
public class a {
    public static final boolean a;
    public static final boolean b;
    public static final boolean c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f6015d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f6016e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f6017f;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f6018g;

    static {
        int i2 = Build.VERSION.SDK_INT;
        a = i2 >= 11;
        b = i2 >= 16;
        c = i2 >= 16;
        f6015d = i2 >= 11;
        f6016e = i2 >= 11;
        f6017f = i2 >= 16;
        f6018g = i2 >= 11;
    }
}
