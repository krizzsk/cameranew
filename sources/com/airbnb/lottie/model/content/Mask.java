package com.airbnb.lottie.model.content;
/* loaded from: classes.dex */
public class Mask {
    private final MaskMode a;
    private final com.airbnb.lottie.model.h.h b;
    private final com.airbnb.lottie.model.h.d c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f382d;

    /* loaded from: classes.dex */
    public enum MaskMode {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public Mask(MaskMode maskMode, com.airbnb.lottie.model.h.h hVar, com.airbnb.lottie.model.h.d dVar, boolean z) {
        this.a = maskMode;
        this.b = hVar;
        this.c = dVar;
        this.f382d = z;
    }

    public MaskMode a() {
        return this.a;
    }

    public com.airbnb.lottie.model.h.h b() {
        return this.b;
    }

    public com.airbnb.lottie.model.h.d c() {
        return this.c;
    }

    public boolean d() {
        return this.f382d;
    }
}
