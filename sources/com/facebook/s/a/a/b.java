package com.facebook.s.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;
import com.facebook.s.a.a.a;
import javax.annotation.Nullable;
/* compiled from: AnimationBackendDelegate.java */
/* loaded from: classes.dex */
public class b<T extends a> implements a {
    @Nullable
    private T a;

    public b(@Nullable T t) {
        this.a = t;
    }

    @Override // com.facebook.s.a.a.d
    public int a() {
        T t = this.a;
        if (t == null) {
            return 0;
        }
        return t.a();
    }

    @Override // com.facebook.s.a.a.d
    public int b() {
        T t = this.a;
        if (t == null) {
            return 0;
        }
        return t.b();
    }

    @Override // com.facebook.s.a.a.a
    public int c() {
        T t = this.a;
        if (t == null) {
            return -1;
        }
        return t.c();
    }

    @Override // com.facebook.s.a.a.a
    public void clear() {
        T t = this.a;
        if (t != null) {
            t.clear();
        }
    }

    @Override // com.facebook.s.a.a.a
    public void d(Rect rect) {
        T t = this.a;
        if (t != null) {
            t.d(rect);
        }
    }

    @Override // com.facebook.s.a.a.a
    public int e() {
        T t = this.a;
        if (t == null) {
            return -1;
        }
        return t.e();
    }

    @Override // com.facebook.s.a.a.a
    public void f(@Nullable ColorFilter colorFilter) {
        T t = this.a;
        if (t != null) {
            t.f(colorFilter);
        }
    }

    @Override // com.facebook.s.a.a.a
    public boolean g(Drawable drawable, Canvas canvas, int i2) {
        T t = this.a;
        return t != null && t.g(drawable, canvas, i2);
    }

    @Override // com.facebook.s.a.a.d
    public int i(int i2) {
        T t = this.a;
        if (t == null) {
            return 0;
        }
        return t.i(i2);
    }

    @Override // com.facebook.s.a.a.a
    public void j(@IntRange(from = 0, to = 255) int i2) {
        T t = this.a;
        if (t != null) {
            t.j(i2);
        }
    }
}
