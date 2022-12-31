package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Iterator;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
final class p implements Iterator<String> {
    final Iterator<String> a;
    final /* synthetic */ zzaq b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(zzaq zzaqVar) {
        Bundle bundle;
        this.b = zzaqVar;
        bundle = zzaqVar.zza;
        this.a = bundle.keySet().iterator();
    }

    @Override // java.util.Iterator
    /* renamed from: a */
    public final String next() {
        return this.a.next();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
