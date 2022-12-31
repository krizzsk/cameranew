package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzccq {
    zzafs zzgex;
    zzafr zzgey;
    zzagg zzgez;
    zzagf zzgfa;
    zzakb zzgfb;
    final SimpleArrayMap<String, zzafy> zzgfc = new SimpleArrayMap<>();
    final SimpleArrayMap<String, zzafx> zzgfd = new SimpleArrayMap<>();

    public final zzccq zza(zzagf zzagfVar) {
        this.zzgfa = zzagfVar;
        return this;
    }

    public final zzcco zzaor() {
        return new zzcco(this);
    }

    public final zzccq zzb(zzafs zzafsVar) {
        this.zzgex = zzafsVar;
        return this;
    }

    public final zzccq zzb(zzafr zzafrVar) {
        this.zzgey = zzafrVar;
        return this;
    }

    public final zzccq zzb(zzagg zzaggVar) {
        this.zzgez = zzaggVar;
        return this;
    }

    public final zzccq zzb(zzakb zzakbVar) {
        this.zzgfb = zzakbVar;
        return this;
    }

    public final zzccq zzb(String str, zzafy zzafyVar, zzafx zzafxVar) {
        this.zzgfc.put(str, zzafyVar);
        this.zzgfd.put(str, zzafxVar);
        return this;
    }
}
