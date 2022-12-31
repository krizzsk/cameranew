package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.d;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzagv extends RemoteCreator<zzaew> {
    public zzagv() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzaew getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
        if (queryLocalInterface instanceof zzaew) {
            return (zzaew) queryLocalInterface;
        }
        return new zzaez(iBinder);
    }

    public final zzaev zzb(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        try {
            IBinder zza = getRemoteCreatorInstance(context).zza(d.z0(context), d.z0(frameLayout), d.z0(frameLayout2), 204204000);
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
            if (queryLocalInterface instanceof zzaev) {
                return (zzaev) queryLocalInterface;
            }
            return new zzaex(zza);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            zzazk.zzd("Could not create remote NativeAdViewDelegate.", e2);
            return null;
        }
    }
}
