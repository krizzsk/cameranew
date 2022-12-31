package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.d;
import java.util.HashMap;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzagu extends RemoteCreator<zzafd> {
    public zzagu() {
        super("com.google.android.gms.ads.NativeAdViewHolderDelegateCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzafd getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegateCreator");
        if (queryLocalInterface instanceof zzafd) {
            return (zzafd) queryLocalInterface;
        }
        return new zzafc(iBinder);
    }

    public final zzaey zzb(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        try {
            IBinder zzb = getRemoteCreatorInstance(view.getContext()).zzb(d.z0(view), d.z0(hashMap), d.z0(hashMap2));
            if (zzb == null) {
                return null;
            }
            IInterface queryLocalInterface = zzb.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
            if (queryLocalInterface instanceof zzaey) {
                return (zzaey) queryLocalInterface;
            }
            return new zzafa(zzb);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            zzazk.zzd("Could not create remote NativeAdViewHolderDelegate.", e2);
            return null;
        }
    }
}
