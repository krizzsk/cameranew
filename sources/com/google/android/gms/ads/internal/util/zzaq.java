package com.google.android.gms.ads.internal.util;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.ads.zzdok;
import com.google.android.gms.internal.ads.zzdwt;
import com.google.android.gms.internal.ads.zzvg;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaq> CREATOR = new zzas();
    public final int errorCode;
    public final String zzacp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaq(@Nullable String str, int i2) {
        this.zzacp = str == null ? "" : str;
        this.errorCode = i2;
    }

    @Nullable
    public static zzaq zzc(Throwable th) {
        String message;
        zzvg zzh = zzdok.zzh(th);
        if (zzdwt.zzar(th.getMessage())) {
            message = zzh.zzchg;
        } else {
            message = th.getMessage();
        }
        return new zzaq(message, zzh.errorCode);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 1, this.zzacp, false);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 2, this.errorCode);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
