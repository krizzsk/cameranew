package com.facebook.imagepipeline.animated.base;

import android.graphics.Canvas;
import android.graphics.Rect;
import javax.annotation.Nullable;
/* compiled from: AnimatedDrawableBackend.java */
/* loaded from: classes.dex */
public interface a {
    int a();

    int b();

    AnimatedDrawableFrameInfo c(int i2);

    void d(int i2, Canvas canvas);

    a e(@Nullable Rect rect);

    int f(int i2);

    int g();

    int getHeight();

    int getWidth();

    int h();

    d i();
}
