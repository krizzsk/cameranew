package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.d;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzauy extends RemoteCreator<zzaus> {
    public zzauy() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzaus getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
        if (queryLocalInterface instanceof zzaus) {
            return (zzaus) queryLocalInterface;
        }
        return new zzauv(iBinder);
    }

    public final zzaur zzc(Context context, zzane zzaneVar) {
        try {
            IBinder zzd = getRemoteCreatorInstance(context).zzd(d.z0(context), zzaneVar, 204204000);
            if (zzd == null) {
                return null;
            }
            IInterface queryLocalInterface = zzd.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
            if (queryLocalInterface instanceof zzaur) {
                return (zzaur) queryLocalInterface;
            }
            return new zzaut(zzd);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            zzazk.zzd("Could not get remote RewardedVideoAd.", e2);
            return null;
        }
    }
}
