package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import java.util.ArrayList;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzafl extends zzgw implements zzafj {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzafl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeContentAd");
    }

    @Override // com.google.android.gms.internal.ads.zzafj
    public final void destroy() throws RemoteException {
        zzb(10, zzdo());
    }

    @Override // com.google.android.gms.internal.ads.zzafj
    public final String getAdvertiser() throws RemoteException {
        Parcel zza = zza(8, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzafj
    public final String getBody() throws RemoteException {
        Parcel zza = zza(5, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzafj
    public final String getCallToAction() throws RemoteException {
        Parcel zza = zza(7, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzafj
    public final Bundle getExtras() throws RemoteException {
        Parcel zza = zza(9, zzdo());
        Bundle bundle = (Bundle) zzgx.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzafj
    public final String getHeadline() throws RemoteException {
        Parcel zza = zza(3, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzafj
    public final List getImages() throws RemoteException {
        Parcel zza = zza(4, zzdo());
        ArrayList zzb = zzgx.zzb(zza);
        zza.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzafj
    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel zza = zza(17, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzafj
    public final zzzc getVideoController() throws RemoteException {
        Parcel zza = zza(11, zzdo());
        zzzc zzk = zzzb.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzafj
    public final void performClick(Bundle bundle) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bundle);
        zzb(12, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzafj
    public final boolean recordImpression(Bundle bundle) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bundle);
        Parcel zza = zza(13, zzdo);
        boolean zza2 = zzgx.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzafj
    public final void reportTouchEvent(Bundle bundle) throws RemoteException {
        Parcel zzdo = zzdo();
        zzgx.zza(zzdo, bundle);
        zzb(14, zzdo);
    }

    @Override // com.google.android.gms.internal.ads.zzafj
    public final b zztm() throws RemoteException {
        Parcel zza = zza(2, zzdo());
        b x0 = b.a.x0(zza.readStrongBinder());
        zza.recycle();
        return x0;
    }

    @Override // com.google.android.gms.internal.ads.zzafj
    public final zzaej zzto() throws RemoteException {
        zzaej zzaelVar;
        Parcel zza = zza(15, zzdo());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzaelVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
            if (queryLocalInterface instanceof zzaej) {
                zzaelVar = (zzaej) queryLocalInterface;
            } else {
                zzaelVar = new zzael(readStrongBinder);
            }
        }
        zza.recycle();
        return zzaelVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafj
    public final b zztp() throws RemoteException {
        Parcel zza = zza(16, zzdo());
        b x0 = b.a.x0(zza.readStrongBinder());
        zza.recycle();
        return x0;
    }

    @Override // com.google.android.gms.internal.ads.zzafj
    public final zzaer zztq() throws RemoteException {
        zzaer zzaetVar;
        Parcel zza = zza(6, zzdo());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            zzaetVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            if (queryLocalInterface instanceof zzaer) {
                zzaetVar = (zzaer) queryLocalInterface;
            } else {
                zzaetVar = new zzaet(readStrongBinder);
            }
        }
        zza.recycle();
        return zzaetVar;
    }
}
