package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzvx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvx> CREATOR = new zzwa();
    @AppOpenAd.AppOpenAdOrientation
    public final int orientation;

    public zzvx(@AppOpenAd.AppOpenAdOrientation int i2) {
        this.orientation = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.m(parcel, 2, this.orientation);
        a.b(parcel, a);
    }
}
