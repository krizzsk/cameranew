package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class zzan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzan> CREATOR = new j();
    private final int endYear;
    private final int startYear;
    private final int zzcn;
    private final int zzco;
    private final int zzcp;
    private final int zzcq;
    private final List<zzao> zzcr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzan(int i2, int i3, int i4, int i5, int i6, int i7, List<zzao> list) {
        this.startYear = i2;
        this.zzcn = i3;
        this.zzco = i4;
        this.endYear = i5;
        this.zzcp = i6;
        this.zzcq = i7;
        this.zzcr = Collections.unmodifiableList(list);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.startYear);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 2, this.zzcn);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 3, this.zzco);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 4, this.endYear);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 5, this.zzcp);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 6, this.zzcq);
        com.google.android.gms.common.internal.safeparcel.a.z(parcel, 7, this.zzcr, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
