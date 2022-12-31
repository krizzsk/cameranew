package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new j();
    private final int versionCode;
    private final ConnectionResult zapq;
    @Nullable
    private final ResolveAccountResponse zate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zam(int i2, ConnectionResult connectionResult, @Nullable ResolveAccountResponse resolveAccountResponse) {
        this.versionCode = i2;
        this.zapq = connectionResult;
        this.zate = resolveAccountResponse;
    }

    public final ConnectionResult Q() {
        return this.zapq;
    }

    @Nullable
    public final ResolveAccountResponse R() {
        return this.zate;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.versionCode);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 2, this.zapq, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 3, this.zate, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    public zam(int i2) {
        this(new ConnectionResult(8, null), null);
    }

    private zam(ConnectionResult connectionResult, @Nullable ResolveAccountResponse resolveAccountResponse) {
        this(1, connectionResult, null);
    }
}
