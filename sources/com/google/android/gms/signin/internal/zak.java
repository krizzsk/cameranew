package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new i();
    private final int zalk;
    private final ResolveAccountRequest zatd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zak(int i2, ResolveAccountRequest resolveAccountRequest) {
        this.zalk = i2;
        this.zatd = resolveAccountRequest;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.zalk);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 2, this.zatd, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    public zak(ResolveAccountRequest resolveAccountRequest) {
        this(1, resolveAccountRequest);
    }
}
