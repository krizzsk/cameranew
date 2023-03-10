package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcgh implements zzaif<Object> {
    private final zzepv<zzcge> zzgdo;
    private final zzcgk zzgge;
    @Nullable
    private final zzafx zzgiu;

    public zzcgh(zzcco zzccoVar, zzccd zzccdVar, zzcgk zzcgkVar, zzepv<zzcge> zzepvVar) {
        this.zzgiu = zzccoVar.zzgb(zzccdVar.getCustomTemplateId());
        this.zzgge = zzcgkVar;
        this.zzgdo = zzepvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("asset");
        try {
            this.zzgiu.zza(this.zzgdo.get(), str);
        } catch (RemoteException e2) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40);
            sb.append("Failed to call onCustomClick for asset ");
            sb.append(str);
            sb.append(".");
            zzazk.zzd(sb.toString(), e2);
        }
    }

    public final void zzapn() {
        if (this.zzgiu == null) {
            return;
        }
        this.zzgge.zza("/nativeAdCustomClick", this);
    }
}
