package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.h;
import java.util.List;
import javax.annotation.Nullable;
/* compiled from: AnimatedImageResult.java */
/* loaded from: classes.dex */
public class d {
    private final b a;
    @Nullable
    private com.facebook.common.references.a<Bitmap> b;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private com.facebook.imagepipeline.h.a f2666d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        b e2 = eVar.e();
        h.g(e2);
        this.a = e2;
        eVar.d();
        this.b = eVar.f();
        this.c = eVar.c();
        this.f2666d = eVar.b();
    }

    public static d b(b bVar) {
        return new d(bVar);
    }

    public static e e(b bVar) {
        return new e(bVar);
    }

    public synchronized void a() {
        com.facebook.common.references.a.y(this.b);
        this.b = null;
        com.facebook.common.references.a.z(this.c);
        this.c = null;
    }

    @Nullable
    public com.facebook.imagepipeline.h.a c() {
        return this.f2666d;
    }

    public b d() {
        return this.a;
    }

    private d(b bVar) {
        h.g(bVar);
        this.a = bVar;
    }
}
