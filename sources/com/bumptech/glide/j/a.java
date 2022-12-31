package com.bumptech.glide.j;

import com.bumptech.glide.load.model.k;
import java.io.File;
/* compiled from: ChildLoadProvider.java */
/* loaded from: classes.dex */
public class a<A, T, Z, R> implements f<A, T, Z, R>, Cloneable {
    private final f<A, T, Z, R> a;
    private com.bumptech.glide.load.d<File, Z> b;
    private com.bumptech.glide.load.d<T, Z> c;

    /* renamed from: d  reason: collision with root package name */
    private com.bumptech.glide.load.e<Z> f705d;

    /* renamed from: e  reason: collision with root package name */
    private com.bumptech.glide.load.resource.transcode.b<Z, R> f706e;

    /* renamed from: f  reason: collision with root package name */
    private com.bumptech.glide.load.a<T> f707f;

    public a(f<A, T, Z, R> fVar) {
        this.a = fVar;
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.a<T> b() {
        com.bumptech.glide.load.a<T> aVar = this.f707f;
        return aVar != null ? aVar : this.a.b();
    }

    @Override // com.bumptech.glide.j.f
    public com.bumptech.glide.load.resource.transcode.b<Z, R> c() {
        com.bumptech.glide.load.resource.transcode.b<Z, R> bVar = this.f706e;
        return bVar != null ? bVar : this.a.c();
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.e<Z> d() {
        com.bumptech.glide.load.e<Z> eVar = this.f705d;
        return eVar != null ? eVar : this.a.d();
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.d<T, Z> e() {
        com.bumptech.glide.load.d<T, Z> dVar = this.c;
        return dVar != null ? dVar : this.a.e();
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.d<File, Z> f() {
        com.bumptech.glide.load.d<File, Z> dVar = this.b;
        return dVar != null ? dVar : this.a.f();
    }

    @Override // com.bumptech.glide.j.f
    public k<A, T> g() {
        return this.a.g();
    }

    /* renamed from: h */
    public a<A, T, Z, R> clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void i(com.bumptech.glide.load.d<T, Z> dVar) {
        this.c = dVar;
    }

    public void j(com.bumptech.glide.load.a<T> aVar) {
        this.f707f = aVar;
    }
}
