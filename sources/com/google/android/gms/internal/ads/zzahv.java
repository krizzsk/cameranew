package com.google.android.gms.internal.ads;

import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzahv implements zzaif<zzbeb> {
    @Override // com.google.android.gms.internal.ads.zzaif
    public final /* synthetic */ void zza(zzbeb zzbebVar, Map map) {
        zzbeb zzbebVar2 = zzbebVar;
        if (zzbebVar2.zzadl() != null) {
            zzbebVar2.zzadl().zzmt();
        }
        com.google.android.gms.ads.internal.overlay.zzc zzact = zzbebVar2.zzact();
        if (zzact != null) {
            zzact.close();
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzc zzacu = zzbebVar2.zzacu();
        if (zzacu != null) {
            zzacu.close();
        } else {
            zzazk.zzex("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
