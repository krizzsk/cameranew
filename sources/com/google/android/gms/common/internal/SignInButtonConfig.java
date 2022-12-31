package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public class SignInButtonConfig extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInButtonConfig> CREATOR = new b0();
    private final int zalk;
    @Deprecated
    private final Scope[] zaoe;
    private final int zapt;
    private final int zapu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SignInButtonConfig(int i2, int i3, int i4, Scope[] scopeArr) {
        this.zalk = i2;
        this.zapt = i3;
        this.zapu = i4;
        this.zaoe = scopeArr;
    }

    public int Q() {
        return this.zapt;
    }

    public int R() {
        return this.zapu;
    }

    @Deprecated
    public Scope[] S() {
        return this.zaoe;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.zalk);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 2, Q());
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 3, R());
        com.google.android.gms.common.internal.safeparcel.a.y(parcel, 4, S(), i2, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    public SignInButtonConfig(int i2, int i3, Scope[] scopeArr) {
        this(1, i2, i3, null);
    }
}
