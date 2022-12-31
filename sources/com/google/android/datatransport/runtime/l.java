package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.b;
import com.google.auto.value.AutoValue;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SendRequest.java */
@AutoValue
/* loaded from: classes2.dex */
public abstract class l {

    /* compiled from: SendRequest.java */
    @AutoValue.Builder
    /* loaded from: classes2.dex */
    public static abstract class a {
        public abstract l a();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract a b(com.google.android.datatransport.b bVar);

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract a c(com.google.android.datatransport.c<?> cVar);

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract a d(com.google.android.datatransport.d<?, byte[]> dVar);

        public abstract a e(m mVar);

        public abstract a f(String str);
    }

    public static a a() {
        return new b.C0129b();
    }

    public abstract com.google.android.datatransport.b b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract com.google.android.datatransport.c<?> c();

    public byte[] d() {
        return e().apply(c().b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract com.google.android.datatransport.d<?, byte[]> e();

    public abstract m f();

    public abstract String g();
}
