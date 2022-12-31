package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.d;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzarp extends RemoteCreator<zzart> {
    public zzarp() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzart getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        if (queryLocalInterface instanceof zzart) {
            return (zzart) queryLocalInterface;
        }
        return new zzars(iBinder);
    }

    public final zzaro zze(Activity activity) {
        try {
            IBinder zzae = getRemoteCreatorInstance(activity).zzae(d.z0(activity));
            if (zzae == null) {
                return null;
            }
            IInterface queryLocalInterface = zzae.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            if (queryLocalInterface instanceof zzaro) {
                return (zzaro) queryLocalInterface;
            }
            return new zzarq(zzae);
        } catch (RemoteException e2) {
            zzazk.zzd("Could not create remote AdOverlay.", e2);
            return null;
        } catch (RemoteCreator.RemoteCreatorException e3) {
            zzazk.zzd("Could not create remote AdOverlay.", e3);
            return null;
        }
    }
}
