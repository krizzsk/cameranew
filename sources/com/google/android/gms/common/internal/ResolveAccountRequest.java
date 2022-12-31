package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public class ResolveAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountRequest> CREATOR = new z();
    private final int zalk;
    private final int zapn;
    private final GoogleSignInAccount zapo;
    private final Account zax;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResolveAccountRequest(int i2, Account account, int i3, GoogleSignInAccount googleSignInAccount) {
        this.zalk = i2;
        this.zax = account;
        this.zapn = i3;
        this.zapo = googleSignInAccount;
    }

    public int Q() {
        return this.zapn;
    }

    @Nullable
    public GoogleSignInAccount R() {
        return this.zapo;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.zalk);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 2, y(), i2, false);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 3, Q());
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 4, R(), i2, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    public Account y() {
        return this.zax;
    }

    public ResolveAccountRequest(Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i2, googleSignInAccount);
    }
}
