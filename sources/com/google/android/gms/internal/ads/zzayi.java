package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzayi implements zzayk {
    @Override // com.google.android.gms.internal.ads.zzayk
    public final zzdzw<String> zza(String str, PackageInfo packageInfo, int i2) {
        return zzdzk.zzag(str);
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    public final zzdzw<String> zzb(Context context, int i2) {
        return zzdzk.zzag(null);
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    public final zzdzw<AdvertisingIdClient.Info> zza(Context context, int i2) {
        zzbaa zzbaaVar = new zzbaa();
        zzwr.zzqn();
        if (zzaza.zzbo(context)) {
            zzazp.zzeic.execute(new zzayl(this, context, zzbaaVar));
        }
        return zzbaaVar;
    }
}
