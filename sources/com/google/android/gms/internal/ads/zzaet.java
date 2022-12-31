package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaet extends zzgw implements zzaer {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaet(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final int getHeight() throws RemoteException {
        Parcel zza = zza(5, zzdo());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final double getScale() throws RemoteException {
        Parcel zza = zza(3, zzdo());
        double readDouble = zza.readDouble();
        zza.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final Uri getUri() throws RemoteException {
        Parcel zza = zza(2, zzdo());
        Uri uri = (Uri) zzgx.zza(zza, Uri.CREATOR);
        zza.recycle();
        return uri;
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final int getWidth() throws RemoteException {
        Parcel zza = zza(4, zzdo());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final b zzti() throws RemoteException {
        Parcel zza = zza(1, zzdo());
        b x0 = b.a.x0(zza.readStrongBinder());
        zza.recycle();
        return x0;
    }
}
