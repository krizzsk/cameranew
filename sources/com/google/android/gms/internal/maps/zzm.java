package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
/* loaded from: classes2.dex */
public final class zzm extends zza implements zzk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzk
    public final float getBearing() throws RemoteException {
        Parcel zza = zza(12, zza());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.maps.zzk
    public final LatLngBounds getBounds() throws RemoteException {
        Parcel zza = zza(10, zza());
        LatLngBounds latLngBounds = (LatLngBounds) zzc.zza(zza, LatLngBounds.CREATOR);
        zza.recycle();
        return latLngBounds;
    }

    @Override // com.google.android.gms.internal.maps.zzk
    public final float getHeight() throws RemoteException {
        Parcel zza = zza(8, zza());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.maps.zzk
    public final String getId() throws RemoteException {
        Parcel zza = zza(2, zza());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.maps.zzk
    public final LatLng getPosition() throws RemoteException {
        Parcel zza = zza(4, zza());
        LatLng latLng = (LatLng) zzc.zza(zza, LatLng.CREATOR);
        zza.recycle();
        return latLng;
    }

    @Override // com.google.android.gms.internal.maps.zzk
    public final float getTransparency() throws RemoteException {
        Parcel zza = zza(18, zza());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.maps.zzk
    public final float getWidth() throws RemoteException {
        Parcel zza = zza(7, zza());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.maps.zzk
    public final float getZIndex() throws RemoteException {
        Parcel zza = zza(14, zza());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.maps.zzk
    public final boolean isClickable() throws RemoteException {
        Parcel zza = zza(23, zza());
        boolean zza2 = zzc.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.maps.zzk
    public final boolean isVisible() throws RemoteException {
        Parcel zza = zza(16, zza());
        boolean zza2 = zzc.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.maps.zzk
    public final void remove() throws RemoteException {
        zzb(1, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzk
    public final void setBearing(float f2) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f2);
        zzb(11, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzk
    public final void setClickable(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.writeBoolean(zza, z);
        zzb(22, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzk
    public final void setDimensions(float f2) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f2);
        zzb(5, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzk
    public final void setPosition(LatLng latLng) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, latLng);
        zzb(3, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzk
    public final void setPositionFromBounds(LatLngBounds latLngBounds) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, latLngBounds);
        zzb(9, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzk
    public final void setTransparency(float f2) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f2);
        zzb(17, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzk
    public final void setVisible(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.writeBoolean(zza, z);
        zzb(15, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzk
    public final void setZIndex(float f2) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f2);
        zzb(13, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzk
    public final void zza(float f2, float f3) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f2);
        zza.writeFloat(f3);
        zzb(6, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzk
    public final boolean zzb(zzk zzkVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, zzkVar);
        Parcel zza2 = zza(19, zza);
        boolean zza3 = zzc.zza(zza2);
        zza2.recycle();
        return zza3;
    }

    @Override // com.google.android.gms.internal.maps.zzk
    public final void zze(b bVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, bVar);
        zzb(24, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzk
    public final void zzf(b bVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, bVar);
        zzb(21, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzk
    public final int zzj() throws RemoteException {
        Parcel zza = zza(20, zza());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.maps.zzk
    public final b zzk() throws RemoteException {
        Parcel zza = zza(25, zza());
        b x0 = b.a.x0(zza.readStrongBinder());
        zza.recycle();
        return x0;
    }
}
