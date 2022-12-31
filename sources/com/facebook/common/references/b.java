package com.facebook.common.references;

import com.facebook.common.references.a;
import javax.annotation.Nullable;
/* compiled from: DefaultCloseableReference.java */
/* loaded from: classes.dex */
public class b<T> extends a<T> {
    private b(SharedReference<T> sharedReference, a.c cVar, @Nullable Throwable th) {
        super(sharedReference, cVar, th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.common.references.a
    public void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (this.a) {
                    return;
                }
                T f2 = this.b.f();
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(System.identityHashCode(this));
                objArr[1] = Integer.valueOf(System.identityHashCode(this.b));
                objArr[2] = f2 == null ? null : f2.getClass().getName();
                com.facebook.common.logging.a.z("DefaultCloseableReference", "Finalized without closing: %x %x (type = %s)", objArr);
                this.c.a(this.b, this.f2413d);
                close();
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.facebook.common.references.a
    /* renamed from: t */
    public a<T> clone() {
        com.facebook.common.internal.h.i(O());
        return new b(this.b, this.c, this.f2413d != null ? new Throwable(this.f2413d) : null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(T t, h<T> hVar, a.c cVar, @Nullable Throwable th) {
        super(t, hVar, cVar, th);
    }
}
