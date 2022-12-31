package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzauz implements RewardItem {
    private final zzauk zzdze;

    public zzauz(zzauk zzaukVar) {
        this.zzdze = zzaukVar;
    }

    @Override // com.google.android.gms.ads.reward.RewardItem
    public final int getAmount() {
        zzauk zzaukVar = this.zzdze;
        if (zzaukVar == null) {
            return 0;
        }
        try {
            return zzaukVar.getAmount();
        } catch (RemoteException e2) {
            zzazk.zzd("Could not forward getAmount to RewardItem", e2);
            return 0;
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardItem
    public final String getType() {
        zzauk zzaukVar = this.zzdze;
        if (zzaukVar == null) {
            return null;
        }
        try {
            return zzaukVar.getType();
        } catch (RemoteException e2) {
            zzazk.zzd("Could not forward getType to RewardItem", e2);
            return null;
        }
    }
}
