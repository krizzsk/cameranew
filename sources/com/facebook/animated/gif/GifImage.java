package com.facebook.animated.gif;

import android.graphics.Bitmap;
import com.facebook.common.internal.d;
import com.facebook.common.internal.h;
import com.facebook.imagepipeline.animated.a.c;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.b;
import com.facebook.soloader.n.a;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@d
/* loaded from: classes.dex */
public class GifImage implements b, c {
    private static volatile boolean b;
    @Nullable
    private Bitmap.Config a = null;
    @d
    private long mNativeContext;

    @d
    public GifImage() {
    }

    public static GifImage k(ByteBuffer byteBuffer, com.facebook.imagepipeline.common.b bVar) {
        m();
        byteBuffer.rewind();
        GifImage nativeCreateFromDirectByteBuffer = nativeCreateFromDirectByteBuffer(byteBuffer, bVar.b, bVar.f2702f);
        nativeCreateFromDirectByteBuffer.a = bVar.f2704h;
        return nativeCreateFromDirectByteBuffer;
    }

    public static GifImage l(long j2, int i2, com.facebook.imagepipeline.common.b bVar) {
        m();
        h.b(Boolean.valueOf(j2 != 0));
        GifImage nativeCreateFromNativeMemory = nativeCreateFromNativeMemory(j2, i2, bVar.b, bVar.f2702f);
        nativeCreateFromNativeMemory.a = bVar.f2704h;
        return nativeCreateFromNativeMemory;
    }

    private static synchronized void m() {
        synchronized (GifImage.class) {
            if (!b) {
                b = true;
                a.d("gifimage");
            }
        }
    }

    private static AnimatedDrawableFrameInfo.DisposalMethod n(int i2) {
        if (i2 == 0) {
            return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
        }
        if (i2 == 1) {
            return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
        }
        if (i2 == 2) {
            return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND;
        }
        if (i2 == 3) {
            return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS;
        }
        return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
    }

    @d
    private static native GifImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer, int i2, boolean z);

    @d
    private static native GifImage nativeCreateFromFileDescriptor(int i2, int i3, boolean z);

    @d
    private static native GifImage nativeCreateFromNativeMemory(long j2, int i2, int i3, boolean z);

    @d
    private native void nativeDispose();

    @d
    private native void nativeFinalize();

    @d
    private native int nativeGetDuration();

    @d
    private native GifFrame nativeGetFrame(int i2);

    @d
    private native int nativeGetFrameCount();

    @d
    private native int[] nativeGetFrameDurations();

    @d
    private native int nativeGetHeight();

    @d
    private native int nativeGetLoopCount();

    @d
    private native int nativeGetSizeInBytes();

    @d
    private native int nativeGetWidth();

    @d
    private native boolean nativeIsAnimated();

    @Override // com.facebook.imagepipeline.animated.base.b
    public int a() {
        return nativeGetFrameCount();
    }

    @Override // com.facebook.imagepipeline.animated.base.b
    public int b() {
        int nativeGetLoopCount = nativeGetLoopCount();
        if (nativeGetLoopCount != -1) {
            if (nativeGetLoopCount != 0) {
                return nativeGetLoopCount + 1;
            }
            return 0;
        }
        return 1;
    }

    @Override // com.facebook.imagepipeline.animated.base.b
    public AnimatedDrawableFrameInfo c(int i2) {
        GifFrame i3 = i(i2);
        try {
            return new AnimatedDrawableFrameInfo(i2, i3.getXOffset(), i3.getYOffset(), i3.getWidth(), i3.getHeight(), AnimatedDrawableFrameInfo.BlendOperation.BLEND_WITH_PREVIOUS, n(i3.b()));
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
        return false;
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
    /* renamed from: o */
    public GifFrame i(int i2) {
        return nativeGetFrame(i2);
    }

    @d
    GifImage(long j2) {
        this.mNativeContext = j2;
    }
}
