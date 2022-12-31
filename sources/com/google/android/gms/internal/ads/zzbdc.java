package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbdc extends com.google.android.gms.ads.internal.util.zza {
    final zzbbo zzeix;
    private final String zzekh;
    private final String[] zzeki;
    final zzbdd zzepm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbdc(zzbbo zzbboVar, zzbdd zzbddVar, String str, String[] strArr) {
        this.zzeix = zzbboVar;
        this.zzepm = zzbddVar;
        this.zzekh = str;
        this.zzeki = strArr;
        com.google.android.gms.ads.internal.zzr.zzln().zza(this);
    }

    @Override // com.google.android.gms.ads.internal.util.zza
    public final void zzwe() {
        try {
            this.zzepm.zze(this.zzekh, this.zzeki);
        } finally {
            com.google.android.gms.ads.internal.util.zzj.zzeen.post(new zzbdb(this));
        }
    }
}
