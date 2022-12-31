package com.bumptech.glide.request.g;

import android.graphics.drawable.Drawable;
/* compiled from: BaseTarget.java */
/* loaded from: classes.dex */
public abstract class a<Z> implements j<Z> {
    private com.bumptech.glide.request.a a;

    @Override // com.bumptech.glide.request.g.j
    public void d(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.g.j
    public com.bumptech.glide.request.a e() {
        return this.a;
    }

    @Override // com.bumptech.glide.request.g.j
    public void f(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.g.j
    public void g(com.bumptech.glide.request.a aVar) {
        this.a = aVar;
    }

    @Override // com.bumptech.glide.request.g.j
    public void h(Exception exc, Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.h
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.h
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.h
    public void onStop() {
    }
}
