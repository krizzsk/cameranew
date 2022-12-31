package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzats extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzats> CREATOR = new zzatv();
    String zzdxm;

    public zzats(String str) {
        this.zzdxm = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.v(parcel, 2, this.zzdxm, false);
        a.b(parcel, a);
    }
}
