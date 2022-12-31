package com.bumptech.glide.request.f;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.bumptech.glide.request.f.c;
/* compiled from: DrawableCrossFadeViewAnimation.java */
/* loaded from: classes.dex */
public class b<T extends Drawable> implements c<T> {
    private final c<T> a;
    private final int b;

    public b(c<T> cVar, int i2) {
        this.a = cVar;
        this.b = i2;
    }

    @Override // com.bumptech.glide.request.f.c
    /* renamed from: b */
    public boolean a(T t, c.a aVar) {
        Drawable c = aVar.c();
        if (c != null) {
            TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{c, t});
            transitionDrawable.setCrossFadeEnabled(true);
            transitionDrawable.startTransition(this.b);
            aVar.a(transitionDrawable);
            return true;
        }
        this.a.a(t, aVar);
        return false;
    }
}
