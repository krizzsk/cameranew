package com.unity3d.player;

import android.os.Build;
/* loaded from: classes3.dex */
public final class k {
    static final boolean a;
    static final boolean b;
    static final boolean c;

    /* renamed from: d  reason: collision with root package name */
    static final e f8398d;

    static {
        int i2 = Build.VERSION.SDK_INT;
        a = i2 >= 21;
        boolean z = i2 >= 23;
        b = z;
        c = i2 >= 24;
        f8398d = z ? new h() : null;
    }
}
