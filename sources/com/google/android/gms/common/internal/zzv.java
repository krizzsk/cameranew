package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
@Deprecated
/* loaded from: classes2.dex */
public final class zzv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzv> CREATOR = new u0();
    private final int zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzv(int i2) {
        this.zza = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.zza);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
