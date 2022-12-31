package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzd;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public final class i extends zzb implements j {
    /* JADX INFO: Access modifiers changed from: package-private */
    public i(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    @Override // com.google.android.gms.dynamite.j
    public final com.google.android.gms.dynamic.b I(com.google.android.gms.dynamic.b bVar, String str, int i2, com.google.android.gms.dynamic.b bVar2) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, bVar);
        a_.writeString(str);
        a_.writeInt(i2);
        zzd.zza(a_, bVar2);
        Parcel zza = zza(2, a_);
        com.google.android.gms.dynamic.b x0 = b.a.x0(zza.readStrongBinder());
        zza.recycle();
        return x0;
    }

    @Override // com.google.android.gms.dynamite.j
    public final com.google.android.gms.dynamic.b J(com.google.android.gms.dynamic.b bVar, String str, int i2, com.google.android.gms.dynamic.b bVar2) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, bVar);
        a_.writeString(str);
        a_.writeInt(i2);
        zzd.zza(a_, bVar2);
        Parcel zza = zza(3, a_);
        com.google.android.gms.dynamic.b x0 = b.a.x0(zza.readStrongBinder());
        zza.recycle();
        return x0;
    }
}
