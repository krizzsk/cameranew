package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdmn extends AdMetadataListener {
    private final /* synthetic */ zzdmk zzhis;
    private final /* synthetic */ zzyr zzhit;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdmn(zzdmk zzdmkVar, zzyr zzyrVar) {
        this.zzhis = zzdmkVar;
        this.zzhit = zzyrVar;
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        zzchb zzchbVar;
        zzchbVar = this.zzhis.zzhir;
        if (zzchbVar != null) {
            try {
                this.zzhit.onAdMetadataChanged();
            } catch (RemoteException e2) {
                zzazk.zze("#007 Could not call remote method.", e2);
            }
        }
    }
}
