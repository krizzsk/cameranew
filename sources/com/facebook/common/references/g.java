package com.facebook.common.references;

import com.facebook.common.references.a;
import javax.annotation.Nullable;
/* compiled from: RefCountCloseableReference.java */
/* loaded from: classes.dex */
public class g<T> extends a<T> {
    private g(SharedReference<T> sharedReference, a.c cVar, @Nullable Throwable th) {
        super(sharedReference, cVar, th);
    }

    @Override // com.facebook.common.references.a
    /* renamed from: t */
    public a<T> clone() {
        com.facebook.common.internal.h.i(O());
        return new g(this.b, this.c, this.f2413d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(T t, h<T> hVar, a.c cVar, @Nullable Throwable th) {
        super(t, hVar, cVar, th);
    }
}
