package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
import javax.annotation.Nullable;
/* compiled from: AnimatedImageResultBuilder.java */
/* loaded from: classes.dex */
public class e {
    private final b a;
    @Nullable
    private com.facebook.common.references.a<Bitmap> b;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> c;

    /* renamed from: d  reason: collision with root package name */
    private int f2667d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private com.facebook.imagepipeline.h.a f2668e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.a = bVar;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d a() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.y(this.b);
            this.b = null;
            com.facebook.common.references.a.z(this.c);
            this.c = null;
        }
    }

    @Nullable
    public com.facebook.imagepipeline.h.a b() {
        return this.f2668e;
    }

    @Nullable
    public List<com.facebook.common.references.a<Bitmap>> c() {
        return com.facebook.common.references.a.x(this.c);
    }

    public int d() {
        return this.f2667d;
    }

    public b e() {
        return this.a;
    }

    @Nullable
    public com.facebook.common.references.a<Bitmap> f() {
        return com.facebook.common.references.a.w(this.b);
    }

    public e g(@Nullable com.facebook.imagepipeline.h.a aVar) {
        this.f2668e = aVar;
        return this;
    }

    public e h(@Nullable List<com.facebook.common.references.a<Bitmap>> list) {
        this.c = com.facebook.common.references.a.x(list);
        return this;
    }

    public e i(int i2) {
        this.f2667d = i2;
        return this;
    }

    public e j(@Nullable com.facebook.common.references.a<Bitmap> aVar) {
        this.b = com.facebook.common.references.a.w(aVar);
        return this;
    }
}
