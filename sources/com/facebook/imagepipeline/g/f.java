package com.facebook.imagepipeline.g;

import com.facebook.imagepipeline.core.l;
import javax.annotation.Nullable;
/* compiled from: MultiImageTranscoderFactory.java */
/* loaded from: classes.dex */
public class f implements d {
    private final int a;
    private final boolean b;
    @Nullable
    private final d c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final Integer f2802d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f2803e;

    public f(int i2, boolean z, @Nullable d dVar, @Nullable Integer num, boolean z2) {
        this.a = i2;
        this.b = z;
        this.c = dVar;
        this.f2802d = num;
        this.f2803e = z2;
    }

    @Nullable
    private c a(com.facebook.imageformat.c cVar, boolean z) {
        d dVar = this.c;
        if (dVar == null) {
            return null;
        }
        return dVar.createImageTranscoder(cVar, z);
    }

    @Nullable
    private c b(com.facebook.imageformat.c cVar, boolean z) {
        Integer num = this.f2802d;
        if (num == null) {
            return null;
        }
        int intValue = num.intValue();
        if (intValue != 0) {
            if (intValue == 1) {
                return d(cVar, z);
            }
            throw new IllegalArgumentException("Invalid ImageTranscoderType");
        }
        return c(cVar, z);
    }

    @Nullable
    private c c(com.facebook.imageformat.c cVar, boolean z) {
        return com.facebook.imagepipeline.nativecode.c.a(this.a, this.b, this.f2803e).createImageTranscoder(cVar, z);
    }

    private c d(com.facebook.imageformat.c cVar, boolean z) {
        return new h(this.a).createImageTranscoder(cVar, z);
    }

    @Override // com.facebook.imagepipeline.g.d
    public c createImageTranscoder(com.facebook.imageformat.c cVar, boolean z) {
        c a = a(cVar, z);
        if (a == null) {
            a = b(cVar, z);
        }
        if (a == null && l.a()) {
            a = c(cVar, z);
        }
        return a == null ? d(cVar, z) : a;
    }
}
