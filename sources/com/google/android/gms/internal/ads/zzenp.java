package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzenp extends zzenv {
    private final /* synthetic */ zzeno zzius;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzenp(zzeno zzenoVar) {
        super(zzenoVar, null);
        this.zzius = zzenoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzenv, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzenq(this.zzius, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzenp(zzeno zzenoVar, zzenn zzennVar) {
        this(zzenoVar);
    }
}
