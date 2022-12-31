package com.google.android.datatransport.cct;

import com.google.android.datatransport.cct.d;
/* compiled from: CctTransportBackend.java */
/* loaded from: classes.dex */
final /* synthetic */ class b implements com.google.android.datatransport.runtime.v.a {
    private final d a;

    private b(d dVar) {
        this.a = dVar;
    }

    public static com.google.android.datatransport.runtime.v.a a(d dVar) {
        return new b(dVar);
    }

    @Override // com.google.android.datatransport.runtime.v.a
    public Object apply(Object obj) {
        d.b d2;
        d2 = this.a.d((d.a) obj);
        return d2;
    }
}
