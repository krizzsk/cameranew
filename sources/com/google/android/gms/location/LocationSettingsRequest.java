package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class LocationSettingsRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new m();
    private final List<LocationRequest> zzbg;
    private final boolean zzbh;
    private final boolean zzbi;
    private zzae zzbj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationSettingsRequest(List<LocationRequest> list, boolean z, boolean z2, zzae zzaeVar) {
        this.zzbg = list;
        this.zzbh = z;
        this.zzbi = z2;
        this.zzbj = zzaeVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.z(parcel, 1, Collections.unmodifiableList(this.zzbg), false);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 2, this.zzbh);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 3, this.zzbi);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 5, this.zzbj, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
