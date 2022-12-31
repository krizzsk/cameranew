package com.facebook.imagepipeline.animated.base;
/* loaded from: classes.dex */
public class AnimatedDrawableFrameInfo {
    public final int a;
    public final int b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2663d;

    /* renamed from: e  reason: collision with root package name */
    public final BlendOperation f2664e;

    /* renamed from: f  reason: collision with root package name */
    public final DisposalMethod f2665f;

    /* loaded from: classes.dex */
    public enum BlendOperation {
        BLEND_WITH_PREVIOUS,
        NO_BLEND
    }

    /* loaded from: classes.dex */
    public enum DisposalMethod {
        DISPOSE_DO_NOT,
        DISPOSE_TO_BACKGROUND,
        DISPOSE_TO_PREVIOUS
    }

    public AnimatedDrawableFrameInfo(int i2, int i3, int i4, int i5, int i6, BlendOperation blendOperation, DisposalMethod disposalMethod) {
        this.a = i3;
        this.b = i4;
        this.c = i5;
        this.f2663d = i6;
        this.f2664e = blendOperation;
        this.f2665f = disposalMethod;
    }
}
