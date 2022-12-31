package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdms extends AdMetadataListener {
    private final /* synthetic */ zzxs zzhiu;
    private final /* synthetic */ zzdmq zzhiv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdms(zzdmq zzdmqVar, zzxs zzxsVar) {
        this.zzhiv = zzdmqVar;
        this.zzhiu = zzxsVar;
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        zzchb zzchbVar;
        zzchbVar = this.zzhiv.zzhir;
        if (zzchbVar != null) {
            try {
                this.zzhiu.onAdMetadataChanged();
            } catch (RemoteException e2) {
                zzazk.zze("#007 Could not call remote method.", e2);
            }
        }
    }
}
