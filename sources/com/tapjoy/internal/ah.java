package com.tapjoy.internal;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
/* loaded from: classes3.dex */
public final class ah {
    protected int a = 0;
    protected float b = 0.0f;
    protected int c = 0;

    /* renamed from: d  reason: collision with root package name */
    protected float f7308d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    protected int f7309e = 0;

    /* renamed from: f  reason: collision with root package name */
    protected float f7310f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    protected int f7311g = 0;

    /* renamed from: h  reason: collision with root package name */
    protected float f7312h = 0.0f;

    public final Animation a() {
        return new TranslateAnimation(this.a, this.b, this.c, this.f7308d, this.f7309e, this.f7310f, this.f7311g, this.f7312h);
    }

    public final ah b(float f2) {
        this.f7309e = 1;
        this.f7310f = f2;
        return this;
    }

    public final ah a(float f2) {
        this.a = 1;
        this.b = f2;
        return this;
    }
}
