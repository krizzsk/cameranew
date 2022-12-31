package com.google.android.gms.internal.measurement;

import java.util.Iterator;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
final class zzka implements Iterator<String> {
    final Iterator<String> zza;
    final /* synthetic */ zzkb zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzka(zzkb zzkbVar) {
        zzih zzihVar;
        this.zzb = zzkbVar;
        zzihVar = zzkbVar.zza;
        this.zza = zzihVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ String next() {
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
