package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public class AuthAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AuthAccountRequest> CREATOR = new t();
    private final int zalk;
    @Deprecated
    private final IBinder zaod;
    private final Scope[] zaoe;
    private Integer zaof;
    private Integer zaog;
    private Account zax;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AuthAccountRequest(int i2, IBinder iBinder, Scope[] scopeArr, Integer num, Integer num2, Account account) {
        this.zalk = i2;
        this.zaod = iBinder;
        this.zaoe = scopeArr;
        this.zaof = num;
        this.zaog = num2;
        this.zax = account;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.zalk);
        com.google.android.gms.common.internal.safeparcel.a.l(parcel, 2, this.zaod, false);
        com.google.android.gms.common.internal.safeparcel.a.y(parcel, 3, this.zaoe, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.o(parcel, 4, this.zaof, false);
        com.google.android.gms.common.internal.safeparcel.a.o(parcel, 5, this.zaog, false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 6, this.zax, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
