package com.facebook.datasource;

import com.facebook.common.internal.k;
/* compiled from: DataSources.java */
/* loaded from: classes.dex */
public class c {

    /* compiled from: DataSources.java */
    /* loaded from: classes.dex */
    static class a implements k<b<T>> {
        final /* synthetic */ Throwable a;

        a(Throwable th) {
            this.a = th;
        }

        @Override // com.facebook.common.internal.k
        /* renamed from: a */
        public b<T> get() {
            return c.b(this.a);
        }
    }

    public static <T> k<b<T>> a(Throwable th) {
        return new a(th);
    }

    public static <T> b<T> b(Throwable th) {
        g v = g.v();
        v.n(th);
        return v;
    }
}
