package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzajr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzajr> CREATOR = new zzajq();
    public final Bundle extras;
    public final String zzdiy;

    public zzajr(String str, Bundle bundle) {
        this.zzdiy = str;
        this.extras = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.v(parcel, 1, this.zzdiy, false);
        a.e(parcel, 2, this.extras, false);
        a.b(parcel, a);
    }
}
