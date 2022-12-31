package com.bumptech.glide;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.manager.g;
import com.bumptech.glide.manager.l;
import com.bumptech.glide.request.g.j;
/* compiled from: DrawableRequestBuilder.java */
/* loaded from: classes.dex */
public class a<ModelType> extends c<ModelType, com.bumptech.glide.load.model.f, com.bumptech.glide.load.h.g.a, com.bumptech.glide.load.h.e.b> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, Class<ModelType> cls, com.bumptech.glide.j.f<ModelType, com.bumptech.glide.load.model.f, com.bumptech.glide.load.h.g.a, com.bumptech.glide.load.h.e.b> fVar, e eVar, l lVar, g gVar) {
        super(context, cls, fVar, com.bumptech.glide.load.h.e.b.class, eVar, lVar, gVar);
        v();
    }

    public a<ModelType> A(ModelType modeltype) {
        super.m(modeltype);
        return this;
    }

    public a<ModelType> B(int i2, int i3) {
        super.o(i2, i3);
        return this;
    }

    public a<ModelType> C(com.bumptech.glide.load.b bVar) {
        super.p(bVar);
        return this;
    }

    public a<ModelType> D(boolean z) {
        super.q(z);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a<ModelType> E(com.bumptech.glide.load.f<com.bumptech.glide.load.h.g.a>... fVarArr) {
        super.s(fVarArr);
        return this;
    }

    @Override // com.bumptech.glide.c
    void b() {
        t();
    }

    @Override // com.bumptech.glide.c
    void c() {
        y();
    }

    @Override // com.bumptech.glide.c
    public /* bridge */ /* synthetic */ c g(com.bumptech.glide.load.d<com.bumptech.glide.load.model.f, com.bumptech.glide.load.h.g.a> dVar) {
        w(dVar);
        return this;
    }

    @Override // com.bumptech.glide.c
    public /* bridge */ /* synthetic */ c h(DiskCacheStrategy diskCacheStrategy) {
        x(diskCacheStrategy);
        return this;
    }

    @Override // com.bumptech.glide.c
    public j<com.bumptech.glide.load.h.e.b> j(ImageView imageView) {
        return super.j(imageView);
    }

    @Override // com.bumptech.glide.c
    public /* bridge */ /* synthetic */ c o(int i2, int i3) {
        B(i2, i3);
        return this;
    }

    @Override // com.bumptech.glide.c
    public /* bridge */ /* synthetic */ c p(com.bumptech.glide.load.b bVar) {
        C(bVar);
        return this;
    }

    @Override // com.bumptech.glide.c
    public /* bridge */ /* synthetic */ c q(boolean z) {
        D(z);
        return this;
    }

    @Override // com.bumptech.glide.c
    public /* bridge */ /* synthetic */ c s(com.bumptech.glide.load.f<com.bumptech.glide.load.h.g.a>[] fVarArr) {
        E(fVarArr);
        return this;
    }

    public a<ModelType> t() {
        E(this.b.k());
        return this;
    }

    @Override // com.bumptech.glide.c
    /* renamed from: u */
    public a<ModelType> f() {
        return (a) super.clone();
    }

    public final a<ModelType> v() {
        super.a(new com.bumptech.glide.request.f.a());
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a<ModelType> w(com.bumptech.glide.load.d<com.bumptech.glide.load.model.f, com.bumptech.glide.load.h.g.a> dVar) {
        super.g(dVar);
        return this;
    }

    public a<ModelType> x(DiskCacheStrategy diskCacheStrategy) {
        super.h(diskCacheStrategy);
        return this;
    }

    public a<ModelType> y() {
        E(this.b.l());
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a<ModelType> z(com.bumptech.glide.request.c<? super ModelType, com.bumptech.glide.load.h.e.b> cVar) {
        super.l(cVar);
        return this;
    }
}
