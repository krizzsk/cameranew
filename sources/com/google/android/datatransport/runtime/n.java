package com.google.android.datatransport.runtime;

import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TransportFactoryImpl.java */
/* loaded from: classes2.dex */
public final class n implements com.google.android.datatransport.f {
    private final Set<com.google.android.datatransport.b> a;
    private final m b;
    private final q c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Set<com.google.android.datatransport.b> set, m mVar, q qVar) {
        this.a = set;
        this.b = mVar;
        this.c = qVar;
    }

    @Override // com.google.android.datatransport.f
    public <T> com.google.android.datatransport.e<T> getTransport(String str, Class<T> cls, com.google.android.datatransport.b bVar, com.google.android.datatransport.d<T, byte[]> dVar) {
        if (this.a.contains(bVar)) {
            return new p(this.b, str, bVar, dVar, this.c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", bVar, this.a));
    }
}
