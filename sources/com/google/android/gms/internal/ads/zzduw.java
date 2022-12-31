package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzduw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzduw> CREATOR = new zzduv();
    public final int status;
    private final int versionCode;
    public final byte[] zzhun;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzduw(int i2, byte[] bArr, int i3) {
        this.versionCode = i2;
        this.zzhun = bArr == null ? null : Arrays.copyOf(bArr, bArr.length);
        this.status = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.m(parcel, 1, this.versionCode);
        a.g(parcel, 2, this.zzhun, false);
        a.m(parcel, 3, this.status);
        a.b(parcel, a);
    }

    public zzduw(byte[] bArr, int i2) {
        this(1, null, 1);
    }
}
