package com.google.android.gms.internal.ads;

import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdwp implements Iterable<String> {
    private final /* synthetic */ CharSequence zzhwf;
    private final /* synthetic */ zzdwk zzhwg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdwp(zzdwk zzdwkVar, CharSequence charSequence) {
        this.zzhwg = zzdwkVar;
        this.zzhwf = charSequence;
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        Iterator<String> zzb;
        zzb = this.zzhwg.zzb(this.zzhwf);
        return zzb;
    }

    public final String toString() {
        StringBuilder zza = zzdwc.zzhk(", ").zza(new StringBuilder("["), iterator());
        zza.append(']');
        return zza.toString();
    }
}
