package com.facebook.common.references;

import com.facebook.common.references.a;
import javax.annotation.Nullable;
/* compiled from: NoOpCloseableReference.java */
/* loaded from: classes.dex */
public class e<T> extends a<T> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public e(T t, h<T> hVar, a.c cVar, @Nullable Throwable th) {
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

    @Override // com.facebook.common.references.a
    public a<T> t() {
        return this;
    }
}
