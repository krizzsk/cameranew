package com.facebook.common.internal;
/* compiled from: Suppliers.java */
/* loaded from: classes.dex */
public class l {
    public static final k<Boolean> a = new b();

    /* compiled from: Suppliers.java */
    /* loaded from: classes.dex */
    static class a implements k<T> {
        final /* synthetic */ Object a;

        a(Object obj) {
            this.a = obj;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [T, java.lang.Object] */
        @Override // com.facebook.common.internal.k
        public T get() {
            return this.a;
        }
    }

    /* compiled from: Suppliers.java */
    /* loaded from: classes.dex */
    static class b implements k<Boolean> {
        b() {
        }

        @Override // com.facebook.common.internal.k
        /* renamed from: a */
        public Boolean get() {
            return Boolean.FALSE;
        }
    }

    public static <T> k<T> a(T t) {
        return new a(t);
    }
}
