package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new c();
    private Bundle mBundle;
    private int mType;
    private final int versionCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleSignInOptionsExtensionParcelable(int i2, int i3, Bundle bundle) {
        this.versionCode = i2;
        this.mType = i3;
        this.mBundle = bundle;
    }

    public int Q() {
        return this.mType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.versionCode);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 2, Q());
        com.google.android.gms.common.internal.safeparcel.a.e(parcel, 3, this.mBundle, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
