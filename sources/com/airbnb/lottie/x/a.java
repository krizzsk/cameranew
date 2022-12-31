package com.airbnb.lottie.x;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.airbnb.lottie.e;
/* compiled from: Keyframe.java */
/* loaded from: classes.dex */
public class a<T> {
    @Nullable
    private final e a;
    @Nullable
    public final T b;
    @Nullable
    public T c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Interpolator f583d;

    /* renamed from: e  reason: collision with root package name */
    public final float f584e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public Float f585f;

    /* renamed from: g  reason: collision with root package name */
    private float f586g;

    /* renamed from: h  reason: collision with root package name */
    private float f587h;

    /* renamed from: i  reason: collision with root package name */
    private int f588i;

    /* renamed from: j  reason: collision with root package name */
    private int f589j;

    /* renamed from: k  reason: collision with root package name */
    private float f590k;

    /* renamed from: l  reason: collision with root package name */
    private float f591l;
    public PointF m;
    public PointF n;

    public a(e eVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f2, @Nullable Float f3) {
        this.f586g = -3987645.8f;
        this.f587h = -3987645.8f;
        this.f588i = 784923401;
        this.f589j = 784923401;
        this.f590k = Float.MIN_VALUE;
        this.f591l = Float.MIN_VALUE;
        this.m = null;
        this.n = null;
        this.a = eVar;
        this.b = t;
        this.c = t2;
        this.f583d = interpolator;
        this.f584e = f2;
        this.f585f = f3;
    }

    public boolean a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return f2 >= e() && f2 < b();
    }

    public float b() {
        if (this.a == null) {
            return 1.0f;
        }
        if (this.f591l == Float.MIN_VALUE) {
            if (this.f585f == null) {
                this.f591l = 1.0f;
            } else {
                this.f591l = e() + ((this.f585f.floatValue() - this.f584e) / this.a.e());
            }
        }
        return this.f591l;
    }

    public float c() {
        if (this.f587h == -3987645.8f) {
            this.f587h = ((Float) this.c).floatValue();
        }
        return this.f587h;
    }

    public int d() {
        if (this.f589j == 784923401) {
            this.f589j = ((Integer) this.c).intValue();
        }
        return this.f589j;
    }

    public float e() {
        e eVar = this.a;
        if (eVar == null) {
            return 0.0f;
        }
        if (this.f590k == Float.MIN_VALUE) {
            this.f590k = (this.f584e - eVar.o()) / this.a.e();
        }
        return this.f590k;
    }

    public float f() {
        if (this.f586g == -3987645.8f) {
            this.f586g = ((Float) this.b).floatValue();
        }
        return this.f586g;
    }

    public int g() {
        if (this.f588i == 784923401) {
            this.f588i = ((Integer) this.b).intValue();
        }
        return this.f588i;
    }

    public boolean h() {
        return this.f583d == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.b + ", endValue=" + this.c + ", startFrame=" + this.f584e + ", endFrame=" + this.f585f + ", interpolator=" + this.f583d + '}';
    }

    public a(T t) {
        this.f586g = -3987645.8f;
        this.f587h = -3987645.8f;
        this.f588i = 784923401;
        this.f589j = 784923401;
        this.f590k = Float.MIN_VALUE;
        this.f591l = Float.MIN_VALUE;
        this.m = null;
        this.n = null;
        this.a = null;
        this.b = t;
        this.c = t;
        this.f583d = null;
        this.f584e = Float.MIN_VALUE;
        this.f585f = Float.valueOf(Float.MAX_VALUE);
    }
}
