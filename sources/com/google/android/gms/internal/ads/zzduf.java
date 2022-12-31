package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzduf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzduf> CREATOR = new zzdui();
    private final int versionCode;
    private final byte[] zzhtx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzduf(int i2, byte[] bArr) {
        this.versionCode = i2;
        this.zzhtx = bArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.m(parcel, 1, this.versionCode);
        a.g(parcel, 2, this.zzhtx, false);
        a.b(parcel, a);
    }

    public zzduf(byte[] bArr) {
        this(1, bArr);
    }
}
