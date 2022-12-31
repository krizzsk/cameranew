package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.l;
/* compiled from: TransportImpl.java */
/* loaded from: classes2.dex */
final class p<T> implements com.google.android.datatransport.e<T> {
    private final m a;
    private final String b;
    private final com.google.android.datatransport.b c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.datatransport.d<T, byte[]> f3397d;

    /* renamed from: e  reason: collision with root package name */
    private final q f3398e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(m mVar, String str, com.google.android.datatransport.b bVar, com.google.android.datatransport.d<T, byte[]> dVar, q qVar) {
        this.a = mVar;
        this.b = str;
        this.c = bVar;
        this.f3397d = dVar;
        this.f3398e = qVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(Exception exc) {
    }

    @Override // com.google.android.datatransport.e
    public void schedule(com.google.android.datatransport.c<T> cVar, com.google.android.datatransport.g gVar) {
        q qVar = this.f3398e;
        l.a a = l.a();
        a.e(this.a);
        a.c(cVar);
        a.f(this.b);
        a.d(this.f3397d);
        a.b(this.c);
        qVar.a(a.a(), gVar);
    }

    @Override // com.google.android.datatransport.e
    public void send(com.google.android.datatransport.c<T> cVar) {
        schedule(cVar, o.a());
    }
}
