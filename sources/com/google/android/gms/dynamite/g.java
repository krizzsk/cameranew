package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzd;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public final class g extends zzb implements h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    @Override // com.google.android.gms.dynamite.h
    public final com.google.android.gms.dynamic.b Q(com.google.android.gms.dynamic.b bVar, String str, int i2) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, bVar);
        a_.writeString(str);
        a_.writeInt(i2);
        Parcel zza = zza(2, a_);
        com.google.android.gms.dynamic.b x0 = b.a.x0(zza.readStrongBinder());
        zza.recycle();
        return x0;
    }

    @Override // com.google.android.gms.dynamite.h
    public final int f0(com.google.android.gms.dynamic.b bVar, String str, boolean z) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, bVar);
        a_.writeString(str);
        zzd.zza(a_, z);
        Parcel zza = zza(5, a_);
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.h
    public final int l0(com.google.android.gms.dynamic.b bVar, String str, boolean z) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, bVar);
        a_.writeString(str);
        zzd.zza(a_, z);
        Parcel zza = zza(3, a_);
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.h
    public final com.google.android.gms.dynamic.b p0(com.google.android.gms.dynamic.b bVar, String str, int i2) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, bVar);
        a_.writeString(str);
        a_.writeInt(i2);
        Parcel zza = zza(4, a_);
        com.google.android.gms.dynamic.b x0 = b.a.x0(zza.readStrongBinder());
        zza.recycle();
        return x0;
    }

    @Override // com.google.android.gms.dynamite.h
    public final int zzb() throws RemoteException {
        Parcel zza = zza(6, a_());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }
}
