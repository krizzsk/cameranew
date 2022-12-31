package com.facebook.datasource;

import com.facebook.common.internal.h;
/* compiled from: SimpleDataSource.java */
/* loaded from: classes.dex */
public class g<T> extends AbstractDataSource<T> {
    private g() {
    }

    public static <T> g<T> v() {
        return new g<>();
    }

    @Override // com.facebook.datasource.AbstractDataSource
    public boolean n(Throwable th) {
        h.g(th);
        return super.n(th);
    }
}
