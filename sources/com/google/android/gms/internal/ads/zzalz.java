package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzalz implements zzakl, zzalw {
    private final zzalx zzdkm;
    private final HashSet<AbstractMap.SimpleEntry<String, zzaif<? super zzalx>>> zzdkn = new HashSet<>();

    public zzalz(zzalx zzalxVar) {
        this.zzdkm = zzalxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzalx
    public final void zza(String str, zzaif<? super zzalx> zzaifVar) {
        this.zzdkm.zza(str, zzaifVar);
        this.zzdkn.add(new AbstractMap.SimpleEntry<>(str, zzaifVar));
    }

    @Override // com.google.android.gms.internal.ads.zzaki
    public final void zza(String str, Map map) {
        zzakk.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzakl, com.google.android.gms.internal.ads.zzaki
    public final void zza(String str, JSONObject jSONObject) {
        zzakk.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzalx
    public final void zzb(String str, zzaif<? super zzalx> zzaifVar) {
        this.zzdkm.zzb(str, zzaifVar);
        this.zzdkn.remove(new AbstractMap.SimpleEntry(str, zzaifVar));
    }

    @Override // com.google.android.gms.internal.ads.zzakw
    public final void zzb(String str, JSONObject jSONObject) {
        zzakk.zza(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzakl, com.google.android.gms.internal.ads.zzakw
    public final void zzcv(String str) {
        this.zzdkm.zzcv(str);
    }

    @Override // com.google.android.gms.internal.ads.zzakl
    public final void zzi(String str, String str2) {
        zzakk.zza(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzalw
    public final void zzuq() {
        Iterator<AbstractMap.SimpleEntry<String, zzaif<? super zzalx>>> it = this.zzdkn.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry<String, zzaif<? super zzalx>> next = it.next();
            String valueOf = String.valueOf(next.getValue().toString());
            com.google.android.gms.ads.internal.util.zzd.zzeb(valueOf.length() != 0 ? "Unregistering eventhandler: ".concat(valueOf) : new String("Unregistering eventhandler: "));
            this.zzdkm.zzb(next.getKey(), next.getValue());
        }
        this.zzdkn.clear();
    }
}
