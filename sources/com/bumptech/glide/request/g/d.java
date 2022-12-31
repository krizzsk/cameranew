package com.bumptech.glide.request.g;

import android.widget.ImageView;
/* compiled from: GlideDrawableImageViewTarget.java */
/* loaded from: classes.dex */
public class d extends e<com.bumptech.glide.load.h.e.b> {

    /* renamed from: e  reason: collision with root package name */
    private int f833e;

    /* renamed from: f  reason: collision with root package name */
    private com.bumptech.glide.load.h.e.b f834f;

    public d(ImageView imageView) {
        this(imageView, -1);
    }

    @Override // com.bumptech.glide.request.g.e, com.bumptech.glide.request.g.j
    /* renamed from: m */
    public void b(com.bumptech.glide.load.h.e.b bVar, com.bumptech.glide.request.f.c<? super com.bumptech.glide.load.h.e.b> cVar) {
        if (!bVar.b()) {
            float width = ((ImageView) this.b).getWidth() / ((ImageView) this.b).getHeight();
            float intrinsicWidth = bVar.getIntrinsicWidth() / bVar.getIntrinsicHeight();
            if (Math.abs(width - 1.0f) <= 0.05f && Math.abs(intrinsicWidth - 1.0f) <= 0.05f) {
                bVar = new i(bVar, ((ImageView) this.b).getWidth());
            }
        }
        super.b(bVar, cVar);
        this.f834f = bVar;
        bVar.c(this.f833e);
        bVar.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.g.e
    /* renamed from: n */
    public void l(com.bumptech.glide.load.h.e.b bVar) {
        ((ImageView) this.b).setImageDrawable(bVar);
    }

    @Override // com.bumptech.glide.request.g.a, com.bumptech.glide.manager.h
    public void onStart() {
        com.bumptech.glide.load.h.e.b bVar = this.f834f;
        if (bVar != null) {
            bVar.start();
        }
    }

    @Override // com.bumptech.glide.request.g.a, com.bumptech.glide.manager.h
    public void onStop() {
        com.bumptech.glide.load.h.e.b bVar = this.f834f;
        if (bVar != null) {
            bVar.stop();
        }
    }

    public d(ImageView imageView, int i2) {
        super(imageView);
        this.f833e = i2;
    }
}
