package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.o0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import javax.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new p();
    private final String zza;
    @Nullable
    private final h zzb;
    private final boolean zzc;
    private final boolean zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzj(String str, @Nullable IBinder iBinder, boolean z, boolean z2) {
        this.zza = str;
        this.zzb = h(iBinder);
        this.zzc = z;
        this.zzd = z2;
    }

    @Nullable
    private static h h(@Nullable IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        try {
            com.google.android.gms.dynamic.b zzb = o0.x0(iBinder).zzb();
            byte[] bArr = zzb == null ? null : (byte[]) com.google.android.gms.dynamic.d.y0(zzb);
            if (bArr != null) {
                return new k(bArr);
            }
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
            return null;
        } catch (RemoteException e2) {
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e2);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        IBinder asBinder;
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 1, this.zza, false);
        h hVar = this.zzb;
        if (hVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            asBinder = null;
        } else {
            asBinder = hVar.asBinder();
        }
        com.google.android.gms.common.internal.safeparcel.a.l(parcel, 2, asBinder, false);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 3, this.zzc);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 4, this.zzd);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzj(String str, @Nullable h hVar, boolean z, boolean z2) {
        this.zza = str;
        this.zzb = hVar;
        this.zzc = z;
        this.zzd = z2;
    }
}
