package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import javax.annotation.Nullable;
/* compiled from: DrawableProperties.java */
/* loaded from: classes.dex */
public class d {
    private int a = -1;
    private boolean b = false;
    @Nullable
    private ColorFilter c = null;

    /* renamed from: d  reason: collision with root package name */
    private int f2520d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f2521e = -1;

    @SuppressLint({"Range"})
    public void a(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        int i2 = this.a;
        if (i2 != -1) {
            drawable.setAlpha(i2);
        }
        if (this.b) {
            drawable.setColorFilter(this.c);
        }
        int i3 = this.f2520d;
        if (i3 != -1) {
            drawable.setDither(i3 != 0);
        }
        int i4 = this.f2521e;
        if (i4 != -1) {
            drawable.setFilterBitmap(i4 != 0);
        }
    }

    public void b(int i2) {
        this.a = i2;
    }

    public void c(@Nullable ColorFilter colorFilter) {
        this.c = colorFilter;
        this.b = colorFilter != null;
    }

    public void d(boolean z) {
        this.f2520d = z ? 1 : 0;
    }

    public void e(boolean z) {
        this.f2521e = z ? 1 : 0;
    }
}
