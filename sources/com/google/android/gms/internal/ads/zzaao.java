package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaao extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaao> CREATOR = new zzaar();
    private final int zzado;
    private final int zzadp;

    public zzaao(int i2, int i3) {
        this.zzado = i2;
        this.zzadp = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.m(parcel, 1, this.zzado);
        a.m(parcel, 2, this.zzadp);
        a.b(parcel, a);
    }

    public zzaao(RequestConfiguration requestConfiguration) {
        this.zzado = requestConfiguration.getTagForChildDirectedTreatment();
        this.zzadp = requestConfiguration.getTagForUnderAgeOfConsent();
    }
}
