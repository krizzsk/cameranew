package com.facebook.datasource;

import javax.annotation.Nonnull;
/* compiled from: BaseDataSubscriber.java */
/* loaded from: classes.dex */
public abstract class a<T> implements d<T> {
    @Override // com.facebook.datasource.d
    public void a(@Nonnull b<T> bVar) {
    }

    @Override // com.facebook.datasource.d
    public void b(@Nonnull b<T> bVar) {
        try {
            e(bVar);
        } finally {
            bVar.close();
        }
    }

    @Override // com.facebook.datasource.d
    public void c(@Nonnull b<T> bVar) {
        boolean b = bVar.b();
        try {
            f(bVar);
        } finally {
            if (b) {
                bVar.close();
            }
        }
    }

    @Override // com.facebook.datasource.d
    public void d(@Nonnull b<T> bVar) {
    }

    protected abstract void e(@Nonnull b<T> bVar);

    protected abstract void f(@Nonnull b<T> bVar);
}
