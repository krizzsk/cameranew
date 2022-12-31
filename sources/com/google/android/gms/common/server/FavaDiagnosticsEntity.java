package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new a();
    private final int zalk;
    private final String zapz;
    private final int zaqa;

    public FavaDiagnosticsEntity(int i2, String str, int i3) {
        this.zalk = i2;
        this.zapz = str;
        this.zaqa = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.zalk);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 2, this.zapz, false);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 3, this.zaqa);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
