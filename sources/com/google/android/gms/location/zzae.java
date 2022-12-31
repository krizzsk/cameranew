package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes2.dex */
public final class zzae extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzae> CREATOR = new l();
    private final String zzbd;
    private final String zzbe;
    private final String zzbf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzae(String str, String str2, String str3) {
        this.zzbf = str;
        this.zzbd = str2;
        this.zzbe = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 1, this.zzbd, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 2, this.zzbe, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 5, this.zzbf, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
