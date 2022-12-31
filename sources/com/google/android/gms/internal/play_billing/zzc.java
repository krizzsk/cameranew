package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
import tv.danmaku.ijk.media.player.IMediaPlayer;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes2.dex */
public final class zzc extends zzf implements zza {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzc(IBinder iBinder) {
        super(iBinder, "com.android.vending.billing.IInAppBillingService");
    }

    @Override // com.google.android.gms.internal.play_billing.zza
    public final int zza(int i2, String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i2);
        zza.writeString(str);
        zza.writeString(str2);
        Parcel zza2 = zza(1, zza);
        int readInt = zza2.readInt();
        zza2.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.play_billing.zza
    public final int zzb(int i2, String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(3);
        zza.writeString(str);
        zza.writeString(str2);
        Parcel zza2 = zza(5, zza);
        int readInt = zza2.readInt();
        zza2.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.play_billing.zza
    public final Bundle zzc(int i2, String str, String str2, String str3, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(9);
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeString(str3);
        zzh.zza(zza, bundle);
        Parcel zza2 = zza(11, zza);
        Bundle bundle2 = (Bundle) zzh.zza(zza2, Bundle.CREATOR);
        zza2.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zza
    public final Bundle zzd(int i2, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(9);
        zza.writeString(str);
        zza.writeString(str2);
        zzh.zza(zza, bundle);
        Parcel zza2 = zza(902, zza);
        Bundle bundle2 = (Bundle) zzh.zza(zza2, Bundle.CREATOR);
        zza2.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zza
    public final Bundle zza(int i2, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(3);
        zza.writeString(str);
        zza.writeString(str2);
        zzh.zza(zza, bundle);
        Parcel zza2 = zza(2, zza);
        Bundle bundle2 = (Bundle) zzh.zza(zza2, Bundle.CREATOR);
        zza2.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zza
    public final int zzb(int i2, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(7);
        zza.writeString(str);
        zza.writeString(str2);
        zzh.zza(zza, bundle);
        Parcel zza2 = zza(10, zza);
        int readInt = zza2.readInt();
        zza2.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.play_billing.zza
    public final Bundle zzc(int i2, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(9);
        zza.writeString(str);
        zza.writeString(str2);
        zzh.zza(zza, bundle);
        Parcel zza2 = zza(12, zza);
        Bundle bundle2 = (Bundle) zzh.zza(zza2, Bundle.CREATOR);
        zza2.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zza
    public final Bundle zza(int i2, String str, String str2, String str3, String str4) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(3);
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeString(str3);
        zza.writeString(null);
        Parcel zza2 = zza(3, zza);
        Bundle bundle = (Bundle) zzh.zza(zza2, Bundle.CREATOR);
        zza2.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.play_billing.zza
    public final Bundle zzb(int i2, String str, String str2, String str3, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(8);
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeString(str3);
        zzh.zza(zza, bundle);
        Parcel zza2 = zza(IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE, zza);
        Bundle bundle2 = (Bundle) zzh.zza(zza2, Bundle.CREATOR);
        zza2.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zza
    public final Bundle zza(int i2, String str, String str2, String str3) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(3);
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeString(str3);
        Parcel zza2 = zza(4, zza);
        Bundle bundle = (Bundle) zzh.zza(zza2, Bundle.CREATOR);
        zza2.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.play_billing.zza
    public final Bundle zza(int i2, String str, List<String> list, String str2, String str3, String str4) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(5);
        zza.writeString(str);
        zza.writeStringList(list);
        zza.writeString(str2);
        zza.writeString(str3);
        zza.writeString(null);
        Parcel zza2 = zza(7, zza);
        Bundle bundle = (Bundle) zzh.zza(zza2, Bundle.CREATOR);
        zza2.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.play_billing.zza
    public final Bundle zza(int i2, String str, String str2, String str3, String str4, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i2);
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeString(str3);
        zza.writeString(str4);
        zzh.zza(zza, bundle);
        Parcel zza2 = zza(8, zza);
        Bundle bundle2 = (Bundle) zzh.zza(zza2, Bundle.CREATOR);
        zza2.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zza
    public final Bundle zza(int i2, String str, String str2, String str3, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(6);
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeString(str3);
        zzh.zza(zza, bundle);
        Parcel zza2 = zza(9, zza);
        Bundle bundle2 = (Bundle) zzh.zza(zza2, Bundle.CREATOR);
        zza2.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zza
    public final Bundle zza(int i2, String str, String str2, Bundle bundle, Bundle bundle2) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(10);
        zza.writeString(str);
        zza.writeString(str2);
        zzh.zza(zza, bundle);
        zzh.zza(zza, bundle2);
        Parcel zza2 = zza(901, zza);
        Bundle bundle3 = (Bundle) zzh.zza(zza2, Bundle.CREATOR);
        zza2.recycle();
        return bundle3;
    }
}
