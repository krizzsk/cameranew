package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.rewarded.RewardItem;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzawi extends zzavk {
    private final String type;
    private final int zzdzc;

    public zzawi(@Nullable zzavj zzavjVar) {
        this(zzavjVar != null ? zzavjVar.type : "", zzavjVar != null ? zzavjVar.zzdzc : 1);
    }

    @Override // com.google.android.gms.internal.ads.zzavl
    public final int getAmount() throws RemoteException {
        return this.zzdzc;
    }

    @Override // com.google.android.gms.internal.ads.zzavl
    public final String getType() throws RemoteException {
        return this.type;
    }

    public zzawi(@Nullable RewardItem rewardItem) {
        this(rewardItem != null ? rewardItem.getType() : "", rewardItem != null ? rewardItem.getAmount() : 1);
    }

    public zzawi(String str, int i2) {
        this.type = str;
        this.zzdzc = i2;
    }
}
