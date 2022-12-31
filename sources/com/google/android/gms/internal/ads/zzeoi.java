package com.google.android.gms.internal.ads;

import java.util.Iterator;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzeoi implements Iterator<String> {
    private final /* synthetic */ zzeog zzivd;
    private Iterator<String> zzivz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeoi(zzeog zzeogVar) {
        zzelv zzelvVar;
        this.zzivd = zzeogVar;
        zzelvVar = zzeogVar.zzive;
        this.zzivz = zzelvVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzivz.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zzivz.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
