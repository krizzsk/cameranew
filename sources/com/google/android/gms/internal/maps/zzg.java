package com.google.android.gms.internal.maps;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* loaded from: classes2.dex */
public final class zzg extends zza implements zze {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zze
    public final b zza(int i2) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i2);
        Parcel zza2 = zza(1, zza);
        b x0 = b.a.x0(zza2.readStrongBinder());
        zza2.recycle();
        return x0;
    }

    @Override // com.google.android.gms.internal.maps.zze
    public final b zzb(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zza2 = zza(3, zza);
        b x0 = b.a.x0(zza2.readStrongBinder());
        zza2.recycle();
        return x0;
    }

    @Override // com.google.android.gms.internal.maps.zze
    public final b zzc(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zza2 = zza(7, zza);
        b x0 = b.a.x0(zza2.readStrongBinder());
        zza2.recycle();
        return x0;
    }

    @Override // com.google.android.gms.internal.maps.zze
    public final b zzi() throws RemoteException {
        Parcel zza = zza(4, zza());
        b x0 = b.a.x0(zza.readStrongBinder());
        zza.recycle();
        return x0;
    }

    @Override // com.google.android.gms.internal.maps.zze
    public final b zza(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zza2 = zza(2, zza);
        b x0 = b.a.x0(zza2.readStrongBinder());
        zza2.recycle();
        return x0;
    }

    @Override // com.google.android.gms.internal.maps.zze
    public final b zza(float f2) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f2);
        Parcel zza2 = zza(5, zza);
        b x0 = b.a.x0(zza2.readStrongBinder());
        zza2.recycle();
        return x0;
    }

    @Override // com.google.android.gms.internal.maps.zze
    public final b zza(Bitmap bitmap) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, bitmap);
        Parcel zza2 = zza(6, zza);
        b x0 = b.a.x0(zza2.readStrongBinder());
        zza2.recycle();
        return x0;
    }
}
