package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.maps.model.LatLng;
/* loaded from: classes2.dex */
public final class zzv extends zza implements zzt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IMarkerDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzt
    public final float getAlpha() throws RemoteException {
        Parcel zza = zza(26, zza());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.maps.zzt
    public final String getId() throws RemoteException {
        Parcel zza = zza(2, zza());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.maps.zzt
    public final LatLng getPosition() throws RemoteException {
        Parcel zza = zza(4, zza());
        LatLng latLng = (LatLng) zzc.zza(zza, LatLng.CREATOR);
        zza.recycle();
        return latLng;
    }

    @Override // com.google.android.gms.internal.maps.zzt
    public final float getRotation() throws RemoteException {
        Parcel zza = zza(23, zza());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.maps.zzt
    public final String getSnippet() throws RemoteException {
        Parcel zza = zza(8, zza());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.maps.zzt
    public final String getTitle() throws RemoteException {
        Parcel zza = zza(6, zza());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.maps.zzt
    public final float getZIndex() throws RemoteException {
        Parcel zza = zza(28, zza());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.maps.zzt
    public final void hideInfoWindow() throws RemoteException {
        zzb(12, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzt
    public final boolean isDraggable() throws RemoteException {
        Parcel zza = zza(10, zza());
        boolean zza2 = zzc.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.maps.zzt
    public final boolean isFlat() throws RemoteException {
        Parcel zza = zza(21, zza());
        boolean zza2 = zzc.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.maps.zzt
    public final boolean isInfoWindowShown() throws RemoteException {
        Parcel zza = zza(13, zza());
        boolean zza2 = zzc.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.maps.zzt
    public final boolean isVisible() throws RemoteException {
        Parcel zza = zza(15, zza());
        boolean zza2 = zzc.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.internal.maps.zzt
    public final void remove() throws RemoteException {
        zzb(1, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzt
    public final void setAlpha(float f2) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f2);
        zzb(25, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzt
    public final void setAnchor(float f2, float f3) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f2);
        zza.writeFloat(f3);
        zzb(19, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzt
    public final void setDraggable(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.writeBoolean(zza, z);
        zzb(9, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzt
    public final void setFlat(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.writeBoolean(zza, z);
        zzb(20, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzt
    public final void setInfoWindowAnchor(float f2, float f3) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f2);
        zza.writeFloat(f3);
        zzb(24, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzt
    public final void setPosition(LatLng latLng) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, latLng);
        zzb(3, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzt
    public final void setRotation(float f2) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f2);
        zzb(22, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzt
    public final void setSnippet(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzb(7, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzt
    public final void setTitle(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzb(5, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzt
    public final void setVisible(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.writeBoolean(zza, z);
        zzb(14, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzt
    public final void setZIndex(float f2) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f2);
        zzb(27, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzt
    public final void showInfoWindow() throws RemoteException {
        zzb(11, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzt
    public final void zze(b bVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, bVar);
        zzb(29, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzt
    public final void zzg(b bVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, bVar);
        zzb(18, zza);
    }

    @Override // com.google.android.gms.internal.maps.zzt
    public final boolean zzj(zzt zztVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, zztVar);
        Parcel zza2 = zza(16, zza);
        boolean zza3 = zzc.zza(zza2);
        zza2.recycle();
        return zza3;
    }

    @Override // com.google.android.gms.internal.maps.zzt
    public final b zzk() throws RemoteException {
        Parcel zza = zza(30, zza());
        b x0 = b.a.x0(zza.readStrongBinder());
        zza.recycle();
        return x0;
    }

    @Override // com.google.android.gms.internal.maps.zzt
    public final int zzj() throws RemoteException {
        Parcel zza = zza(17, zza());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }
}
