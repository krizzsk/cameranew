package com.bumptech.glide.j;

import com.bumptech.glide.load.model.k;
import java.io.File;
import java.util.Objects;
/* compiled from: FixedLoadProvider.java */
/* loaded from: classes.dex */
public class e<A, T, Z, R> implements f<A, T, Z, R> {
    private final k<A, T> a;
    private final com.bumptech.glide.load.resource.transcode.b<Z, R> b;
    private final b<T, Z> c;

    public e(k<A, T> kVar, com.bumptech.glide.load.resource.transcode.b<Z, R> bVar, b<T, Z> bVar2) {
        Objects.requireNonNull(kVar, "ModelLoader must not be null");
        this.a = kVar;
        Objects.requireNonNull(bVar, "Transcoder must not be null");
        this.b = bVar;
        Objects.requireNonNull(bVar2, "DataLoadProvider must not be null");
        this.c = bVar2;
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.a<T> b() {
        return this.c.b();
    }

    @Override // com.bumptech.glide.j.f
    public com.bumptech.glide.load.resource.transcode.b<Z, R> c() {
        return this.b;
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.e<Z> d() {
        return this.c.d();
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.d<T, Z> e() {
        return this.c.e();
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.d<File, Z> f() {
        return this.c.f();
    }

    @Override // com.bumptech.glide.j.f
    public k<A, T> g() {
        return this.a;
    }
}
