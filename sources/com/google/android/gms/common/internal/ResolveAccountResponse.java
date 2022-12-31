package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.j;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public class ResolveAccountResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new a0();
    private final int versionCode;
    private IBinder zapp;
    private ConnectionResult zapq;
    private boolean zapr;
    private boolean zaps;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResolveAccountResponse(int i2, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.versionCode = i2;
        this.zapp = iBinder;
        this.zapq = connectionResult;
        this.zapr = z;
        this.zaps = z2;
    }

    public j Q() {
        return j.a.x0(this.zapp);
    }

    public ConnectionResult R() {
        return this.zapq;
    }

    public boolean S() {
        return this.zapr;
    }

    public boolean T() {
        return this.zaps;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ResolveAccountResponse) {
            ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
            return this.zapq.equals(resolveAccountResponse.zapq) && Q().equals(resolveAccountResponse.Q());
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.versionCode);
        com.google.android.gms.common.internal.safeparcel.a.l(parcel, 2, this.zapp, false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 3, R(), i2, false);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 4, S());
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 5, T());
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
