package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzaep extends zzgy implements zzaem {
    public zzaep() {
        super("com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    public static zzaem zzn(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent");
        if (queryLocalInterface instanceof zzaem) {
            return (zzaem) queryLocalInterface;
        }
        return new zzaeo(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        zzagd zzagcVar;
        switch (i2) {
            case 2:
                float aspectRatio = getAspectRatio();
                parcel2.writeNoException();
                parcel2.writeFloat(aspectRatio);
                return true;
            case 3:
                zzo(b.a.x0(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 4:
                b zztl = zztl();
                parcel2.writeNoException();
                zzgx.zza(parcel2, zztl);
                return true;
            case 5:
                float duration = getDuration();
                parcel2.writeNoException();
                parcel2.writeFloat(duration);
                return true;
            case 6:
                float currentTime = getCurrentTime();
                parcel2.writeNoException();
                parcel2.writeFloat(currentTime);
                return true;
            case 7:
                zzzc videoController = getVideoController();
                parcel2.writeNoException();
                zzgx.zza(parcel2, videoController);
                return true;
            case 8:
                boolean hasVideoContent = hasVideoContent();
                parcel2.writeNoException();
                zzgx.writeBoolean(parcel2, hasVideoContent);
                return true;
            case 9:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzagcVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnMediaContentChangedListener");
                    if (queryLocalInterface instanceof zzagd) {
                        zzagcVar = (zzagd) queryLocalInterface;
                    } else {
                        zzagcVar = new zzagc(readStrongBinder);
                    }
                }
                zza(zzagcVar);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
