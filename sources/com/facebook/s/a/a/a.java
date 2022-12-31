package com.facebook.s.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;
import javax.annotation.Nullable;
/* compiled from: AnimationBackend.java */
/* loaded from: classes.dex */
public interface a extends d {
    int c();

    void clear();

    void d(Rect rect);

    int e();

    void f(@Nullable ColorFilter colorFilter);

    boolean g(Drawable drawable, Canvas canvas, int i2);

    void j(@IntRange(from = 0, to = 255) int i2);
}
