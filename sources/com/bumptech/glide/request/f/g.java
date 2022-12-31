package com.bumptech.glide.request.f;

import com.bumptech.glide.request.f.f;
/* compiled from: ViewAnimationFactory.java */
/* loaded from: classes.dex */
public class g<R> implements d<R> {
    private final f.a a;
    private c<R> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f.a aVar) {
        this.a = aVar;
    }

    @Override // com.bumptech.glide.request.f.d
    public c<R> a(boolean z, boolean z2) {
        if (!z && z2) {
            if (this.b == null) {
                this.b = new f(this.a);
            }
            return this.b;
        }
        return e.c();
    }
}
