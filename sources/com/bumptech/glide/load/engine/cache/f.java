package com.bumptech.glide.load.engine.cache;

import android.annotation.SuppressLint;
import com.bumptech.glide.load.engine.cache.g;
import com.bumptech.glide.load.engine.i;
/* compiled from: LruResourceCache.java */
/* loaded from: classes.dex */
public class f extends com.bumptech.glide.l.e<com.bumptech.glide.load.b, i<?>> implements g {

    /* renamed from: d  reason: collision with root package name */
    private g.a f749d;

    public f(int i2) {
        super(i2);
    }

    @Override // com.bumptech.glide.load.engine.cache.g
    public /* bridge */ /* synthetic */ i a(com.bumptech.glide.load.b bVar, i iVar) {
        return (i) super.k(bVar, iVar);
    }

    @Override // com.bumptech.glide.load.engine.cache.g
    @SuppressLint({"InlinedApi"})
    public void b(int i2) {
        if (i2 >= 60) {
            c();
        } else if (i2 >= 40) {
            m(h() / 2);
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.g
    public /* bridge */ /* synthetic */ i d(com.bumptech.glide.load.b bVar) {
        return (i) super.l(bVar);
    }

    @Override // com.bumptech.glide.load.engine.cache.g
    public void e(g.a aVar) {
        this.f749d = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.l.e
    /* renamed from: n */
    public int i(i<?> iVar) {
        return iVar.getSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.l.e
    /* renamed from: o */
    public void j(com.bumptech.glide.load.b bVar, i<?> iVar) {
        g.a aVar = this.f749d;
        if (aVar != null) {
            aVar.a(iVar);
        }
    }
}
