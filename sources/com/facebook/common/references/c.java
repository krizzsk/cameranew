package com.facebook.common.references;

import com.facebook.common.references.a;
import javax.annotation.Nullable;
/* compiled from: FinalizerCloseableReference.java */
/* loaded from: classes.dex */
public class c<T> extends a<T> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(T t, h<T> hVar, a.c cVar, @Nullable Throwable th) {
        super(t, hVar, cVar, th);
    }

    @Override // com.facebook.common.references.a
    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        t();
        return this;
    }

    @Override // com.facebook.common.references.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
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
                com.facebook.common.logging.a.z("FinalizerCloseableReference", "Finalized without closing: %x %x (type = %s)", objArr);
                this.b.d();
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.facebook.common.references.a
    public a<T> t() {
        return this;
    }
}
