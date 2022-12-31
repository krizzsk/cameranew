package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class zzal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzal> CREATOR = new d();
    private final List<zzao> zzcl;
    private final List<zzan> zzcm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzal(List<zzao> list, List<zzan> list2) {
        this.zzcl = Collections.unmodifiableList(list);
        this.zzcm = Collections.unmodifiableList(list2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.z(parcel, 1, this.zzcl, false);
        com.google.android.gms.common.internal.safeparcel.a.z(parcel, 2, this.zzcm, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
