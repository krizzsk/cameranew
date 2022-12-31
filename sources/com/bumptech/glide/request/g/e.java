package com.bumptech.glide.request.g;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.f.c;
/* compiled from: ImageViewTarget.java */
/* loaded from: classes.dex */
public abstract class e<Z> extends k<ImageView, Z> implements c.a {
    public e(ImageView imageView) {
        super(imageView);
    }

    @Override // com.bumptech.glide.request.f.c.a
    public void a(Drawable drawable) {
        ((ImageView) this.b).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.g.j
    public void b(Z z, com.bumptech.glide.request.f.c<? super Z> cVar) {
        if (cVar == null || !cVar.a(z, this)) {
            l(z);
        }
    }

    @Override // com.bumptech.glide.request.f.c.a
    public Drawable c() {
        return ((ImageView) this.b).getDrawable();
    }

    @Override // com.bumptech.glide.request.g.a, com.bumptech.glide.request.g.j
    public void d(Drawable drawable) {
        ((ImageView) this.b).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.g.a, com.bumptech.glide.request.g.j
    public void f(Drawable drawable) {
        ((ImageView) this.b).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.g.a, com.bumptech.glide.request.g.j
    public void h(Exception exc, Drawable drawable) {
        ((ImageView) this.b).setImageDrawable(drawable);
    }

    protected abstract void l(Z z);
}
