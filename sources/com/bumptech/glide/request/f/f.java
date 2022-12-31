package com.bumptech.glide.request.f;

import android.view.View;
import android.view.animation.Animation;
import com.bumptech.glide.request.f.c;
/* compiled from: ViewAnimation.java */
/* loaded from: classes.dex */
public class f<R> implements c<R> {
    private final a a;

    /* compiled from: ViewAnimation.java */
    /* loaded from: classes.dex */
    interface a {
        Animation build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.a = aVar;
    }

    @Override // com.bumptech.glide.request.f.c
    public boolean a(R r, c.a aVar) {
        View view = aVar.getView();
        if (view != null) {
            view.clearAnimation();
            view.startAnimation(this.a.build());
            return false;
        }
        return false;
    }
}
