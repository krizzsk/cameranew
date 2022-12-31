package com.facebook.animated.webp;

import android.graphics.Bitmap;
import com.facebook.common.internal.d;
import com.facebook.imagepipeline.animated.base.c;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes.dex */
public class WebPFrame implements c {
    @d
    private long mNativeContext;

    @d
    WebPFrame(long j2) {
        this.mNativeContext = j2;
    }

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDurationMs();

    private native int nativeGetHeight();

    private native int nativeGetWidth();

    private native int nativeGetXOffset();

    private native int nativeGetYOffset();

    private native boolean nativeIsBlendWithPreviousFrame();

    private native void nativeRenderFrame(int i2, int i3, Bitmap bitmap);

    private native boolean nativeShouldDisposeToBackgroundColor();

    @Override // com.facebook.imagepipeline.animated.base.c
    public void a(int i2, int i3, Bitmap bitmap) {
        nativeRenderFrame(i2, i3, bitmap);
    }

    public boolean b() {
        return nativeIsBlendWithPreviousFrame();
    }

    public boolean c() {
        return nativeShouldDisposeToBackgroundColor();
    }

    @Override // com.facebook.imagepipeline.animated.base.c
    public void dispose() {
        nativeDispose();
    }

    protected void finalize() {
        nativeFinalize();
    }

    @Override // com.facebook.imagepipeline.animated.base.c
    public int getHeight() {
        return nativeGetHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.c
    public int getWidth() {
        return nativeGetWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.c
    public int getXOffset() {
        return nativeGetXOffset();
    }

    @Override // com.facebook.imagepipeline.animated.base.c
    public int getYOffset() {
        return nativeGetYOffset();
    }
}
