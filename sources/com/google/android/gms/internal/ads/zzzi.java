package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzzi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzzi> CREATOR = new zzzh();
    private final int zzcjy;

    public zzzi(int i2) {
        this.zzcjy = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.m(parcel, 2, this.zzcjy);
        a.b(parcel, a);
    }
}
