package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new d0();
    Bundle a;
    Feature[] b;
    private int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzc(Bundle bundle, Feature[] featureArr, int i2) {
        this.a = bundle;
        this.b = featureArr;
        this.zzc = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.e(parcel, 1, this.a, false);
        com.google.android.gms.common.internal.safeparcel.a.y(parcel, 2, this.b, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 3, this.zzc);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    public zzc() {
    }
}
