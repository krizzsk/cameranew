package com.google.android.datatransport.runtime.w.j;

import com.google.android.datatransport.runtime.w.j.a;
import com.google.auto.value.AutoValue;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EventStoreConfig.java */
@AutoValue
/* loaded from: classes2.dex */
public abstract class d {
    static final d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EventStoreConfig.java */
    @AutoValue.Builder
    /* loaded from: classes2.dex */
    public static abstract class a {
        abstract d a();

        abstract a b(int i2);

        abstract a c(long j2);

        abstract a d(int i2);

        abstract a e(int i2);

        abstract a f(long j2);
    }

    static {
        a a2 = a();
        a2.f(10485760L);
        a2.d(200);
        a2.b(10000);
        a2.c(604800000L);
        a2.e(81920);
        a = a2.a();
    }

    static a a() {
        return new a.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int e();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract long f();
}
