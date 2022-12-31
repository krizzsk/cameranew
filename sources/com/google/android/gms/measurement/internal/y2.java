package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzc;
import java.util.ArrayList;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class y2 extends zza implements a3 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public y2(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.measurement.internal.a3
    public final void C(zzas zzasVar, zzp zzpVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzasVar);
        zzc.zzd(zza, zzpVar);
        zzc(1, zza);
    }

    @Override // com.google.android.gms.measurement.internal.a3
    public final List<zzkg> E(String str, String str2, String str3, boolean z) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(null);
        zza.writeString(str2);
        zza.writeString(str3);
        zzc.zzb(zza, z);
        Parcel zzz = zzz(15, zza);
        ArrayList createTypedArrayList = zzz.createTypedArrayList(zzkg.CREATOR);
        zzz.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.a3
    public final void H(zzp zzpVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzpVar);
        zzc(20, zza);
    }

    @Override // com.google.android.gms.measurement.internal.a3
    public final void S(long j2, String str, String str2, String str3) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j2);
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeString(str3);
        zzc(10, zza);
    }

    @Override // com.google.android.gms.measurement.internal.a3
    public final void W(zzp zzpVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzpVar);
        zzc(18, zza);
    }

    @Override // com.google.android.gms.measurement.internal.a3
    public final void c0(Bundle bundle, zzp zzpVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, bundle);
        zzc.zzd(zza, zzpVar);
        zzc(19, zza);
    }

    @Override // com.google.android.gms.measurement.internal.a3
    public final byte[] e0(zzas zzasVar, String str) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzasVar);
        zza.writeString(str);
        Parcel zzz = zzz(9, zza);
        byte[] createByteArray = zzz.createByteArray();
        zzz.recycle();
        return createByteArray;
    }

    @Override // com.google.android.gms.measurement.internal.a3
    public final List<zzaa> k(String str, String str2, zzp zzpVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzd(zza, zzpVar);
        Parcel zzz = zzz(16, zza);
        ArrayList createTypedArrayList = zzz.createTypedArrayList(zzaa.CREATOR);
        zzz.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.a3
    public final void k0(zzp zzpVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzpVar);
        zzc(6, zza);
    }

    @Override // com.google.android.gms.measurement.internal.a3
    public final String m(zzp zzpVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzpVar);
        Parcel zzz = zzz(11, zza);
        String readString = zzz.readString();
        zzz.recycle();
        return readString;
    }

    @Override // com.google.android.gms.measurement.internal.a3
    public final void n(zzaa zzaaVar, zzp zzpVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzaaVar);
        zzc.zzd(zza, zzpVar);
        zzc(12, zza);
    }

    @Override // com.google.android.gms.measurement.internal.a3
    public final List<zzkg> o(String str, String str2, boolean z, zzp zzpVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzb(zza, z);
        zzc.zzd(zza, zzpVar);
        Parcel zzz = zzz(14, zza);
        ArrayList createTypedArrayList = zzz.createTypedArrayList(zzkg.CREATOR);
        zzz.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.a3
    public final List<zzaa> p(String str, String str2, String str3) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(null);
        zza.writeString(str2);
        zza.writeString(str3);
        Parcel zzz = zzz(17, zza);
        ArrayList createTypedArrayList = zzz.createTypedArrayList(zzaa.CREATOR);
        zzz.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.a3
    public final void t0(zzp zzpVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzpVar);
        zzc(4, zza);
    }

    @Override // com.google.android.gms.measurement.internal.a3
    public final void x(zzkg zzkgVar, zzp zzpVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzkgVar);
        zzc.zzd(zza, zzpVar);
        zzc(2, zza);
    }
}
