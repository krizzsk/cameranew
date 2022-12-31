package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class zzai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzai> CREATOR = new b();
    private final float zzcb;
    private final int zzcc;
    private final List<Integer> zzg;
    private final String zzh;
    private final Uri zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzai(List<Integer> list, String str, Uri uri, float f2, int i2) {
        this.zzg = Collections.unmodifiableList(list);
        this.zzh = str;
        this.zzi = uri;
        this.zzcb = f2;
        this.zzcc = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.n(parcel, 1, this.zzg, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 2, this.zzh, false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 3, this.zzi, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 4, this.zzcb);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 5, this.zzcc);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
