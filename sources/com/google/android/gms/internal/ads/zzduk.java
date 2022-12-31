package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzduk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzduk> CREATOR = new zzduj();
    private final String packageName;
    private final int versionCode;
    private final String zzhtz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzduk(int i2, String str, String str2) {
        this.versionCode = i2;
        this.packageName = str;
        this.zzhtz = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.m(parcel, 1, this.versionCode);
        a.v(parcel, 2, this.packageName, false);
        a.v(parcel, 3, this.zzhtz, false);
        a.b(parcel, a);
    }

    public zzduk(String str, String str2) {
        this(1, str, str2);
    }
}
