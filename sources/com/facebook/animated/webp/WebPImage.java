package com.facebook.animated.webp;

import android.graphics.Bitmap;
import com.facebook.common.internal.d;
import com.facebook.common.internal.h;
import com.facebook.imagepipeline.animated.a.c;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.b;
import com.facebook.imagepipeline.nativecode.e;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@d
/* loaded from: classes.dex */
public class WebPImage implements b, c {
    @Nullable
    private Bitmap.Config a = null;
    @d
    private long mNativeContext;

    @d
    public WebPImage() {
    }

    public static WebPImage k(ByteBuffer byteBuffer, @Nullable com.facebook.imagepipeline.common.b bVar) {
        e.a();
        byteBuffer.rewind();
        WebPImage nativeCreateFromDirectByteBuffer = nativeCreateFromDirectByteBuffer(byteBuffer);
        if (bVar != null) {
            nativeCreateFromDirectByteBuffer.a = bVar.f2704h;
        }
        return nativeCreateFromDirectByteBuffer;
    }

    public static WebPImage l(long j2, int i2, @Nullable com.facebook.imagepipeline.common.b bVar) {
        e.a();
        h.b(Boolean.valueOf(j2 != 0));
        WebPImage nativeCreateFromNativeMemory = nativeCreateFromNativeMemory(j2, i2);
        if (bVar != null) {
            nativeCreateFromNativeMemory.a = bVar.f2704h;
        }
        return nativeCreateFromNativeMemory;
    }

    private static native WebPImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer);

    private static native WebPImage nativeCreateFromNativeMemory(long j2, int i2);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDuration();

    private native WebPFrame nativeGetFrame(int i2);

    private native int nativeGetFrameCount();

    private native int[] nativeGetFrameDurations();

    private native int nativeGetHeight();

    private native int nativeGetLoopCount();

    private native int nativeGetSizeInBytes();

    private native int nativeGetWidth();

    @Override // com.facebook.imagepipeline.animated.base.b
    public int a() {
        return nativeGetFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.b
    public int b() {
        return nativeGetLoopCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.b
    public AnimatedDrawableFrameInfo c(int i2) {
        WebPFrame i3 = i(i2);
        try {
            return new AnimatedDrawableFrameInfo(i2, i3.getXOffset(), i3.getYOffset(), i3.getWidth(), i3.getHeight(), i3.b() ? AnimatedDrawableFrameInfo.BlendOperation.BLEND_WITH_PREVIOUS : AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND, i3.c() ? AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND : AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT);
        } finally {
            i3.dispose();
        }
    }

    @Override // com.facebook.imagepipeline.animated.a.c
    public b d(ByteBuffer byteBuffer, com.facebook.imagepipeline.common.b bVar) {
        return k(byteBuffer, bVar);
    }

    @Override // com.facebook.imagepipeline.animated.base.b
    public boolean e() {
        return true;
    }

    @Override // com.facebook.imagepipeline.animated.a.c
    public b f(long j2, int i2, com.facebook.imagepipeline.common.b bVar) {
        return l(j2, i2, bVar);
    }

    protected void finalize() {
        nativeFinalize();
    }

    @Override // com.facebook.imagepipeline.animated.base.b
    public int g() {
        return nativeGetSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.animated.base.b
    public int getHeight() {
        return nativeGetHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.b
    public int getWidth() {
        return nativeGetWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.b
    @Nullable
    public Bitmap.Config h() {
        return this.a;
    }

    @Override // com.facebook.imagepipeline.animated.base.b
    public int[] j() {
        return nativeGetFrameDurations();
    }

    @Override // com.facebook.imagepipeline.animated.base.b
    /* renamed from: m */
    public WebPFrame i(int i2) {
        return nativeGetFrame(i2);
    }

    @d
    WebPImage(long j2) {
        this.mNativeContext = j2;
    }
}
