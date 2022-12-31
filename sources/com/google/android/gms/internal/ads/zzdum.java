package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.internal.ads.zzcf;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdum extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdum> CREATOR = new zzdul();
    private final int versionCode;
    private zzcf.zza zzhua = null;
    private byte[] zzhub;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdum(int i2, byte[] bArr) {
        this.versionCode = i2;
        this.zzhub = bArr;
        zzayj();
    }

    private final void zzayj() {
        zzcf.zza zzaVar = this.zzhua;
        if (zzaVar != null || this.zzhub == null) {
            if (zzaVar == null || this.zzhub != null) {
                if (zzaVar != null && this.zzhub != null) {
                    throw new IllegalStateException("Invalid internal representation - full");
                }
                if (zzaVar == null && this.zzhub == null) {
                    throw new IllegalStateException("Invalid internal representation - empty");
                }
                throw new IllegalStateException("Impossible");
            }
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.m(parcel, 1, this.versionCode);
        byte[] bArr = this.zzhub;
        if (bArr == null) {
            bArr = this.zzhua.toByteArray();
        }
        a.g(parcel, 2, bArr, false);
        a.b(parcel, a);
    }

    public final zzcf.zza zzayi() {
        if (!(this.zzhua != null)) {
            try {
                this.zzhua = zzcf.zza.zza(this.zzhub, zzeko.zzbhw());
                this.zzhub = null;
            } catch (zzelo | NullPointerException e2) {
                throw new IllegalStateException(e2);
            }
        }
        zzayj();
        return this.zzhua;
    }
}
