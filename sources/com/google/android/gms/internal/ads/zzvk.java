package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.d;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzvk extends RemoteCreator<zzxj> {
    public zzvk() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzxj getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
        if (queryLocalInterface instanceof zzxj) {
            return (zzxj) queryLocalInterface;
        }
        return new zzxm(iBinder);
    }

    public final zzxi zza(Context context, String str, zzane zzaneVar) {
        try {
            IBinder zzc = getRemoteCreatorInstance(context).zzc(d.z0(context), str, zzaneVar, 204204000);
            if (zzc == null) {
                return null;
            }
            IInterface queryLocalInterface = zzc.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (queryLocalInterface instanceof zzxi) {
                return (zzxi) queryLocalInterface;
            }
            return new zzxk(zzc);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            zzazk.zzd("Could not create remote builder for AdLoader.", e2);
            return null;
        }
    }
}
