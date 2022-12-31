package com.airbnb.lottie;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
/* compiled from: LottieImageAsset.java */
/* loaded from: classes.dex */
public class h {
    private final int a;
    private final int b;
    private final String c;

    /* renamed from: d  reason: collision with root package name */
    private final String f361d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private Bitmap f362e;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public h(int i2, int i3, String str, String str2, String str3) {
        this.a = i2;
        this.b = i3;
        this.c = str;
        this.f361d = str2;
    }

    @Nullable
    public Bitmap a() {
        return this.f362e;
    }

    public String b() {
        return this.f361d;
    }

    public int c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public int e() {
        return this.a;
    }

    public void f(@Nullable Bitmap bitmap) {
        this.f362e = bitmap;
    }
}
